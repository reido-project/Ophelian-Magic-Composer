package app.controllers;

import app.models.database.tables.CharacterMagicTypeTable;
import app.models.database.tables.CharacterTable;
import app.models.enums.Role;
import app.models.enums.Slot;
import app.models.interfaces.Refreshable;
import app.models.runtime.CharacterRegistryRuntime;
import app.models.runtime.MagicRegistryRuntime;
import app.models.types.CharacterMagicType;
import app.models.types.MagicType;
import app.utils.Text;
import app.views.panels.CharacterRegistryPanel;
import app.models.types.Character;

import javax.swing.*;

import java.util.ArrayList;
import java.util.List;

public class CharacterRegistryController implements Refreshable {
    private final CharacterRegistryPanel view;
    private final CharacterRegistryRuntime runtime;
    private final MagicRegistryRuntime magicRegistryRuntime;
    private final CharacterTable characterTable;
    private final CharacterMagicTypeTable magicTypeTable;

    private Runnable globalRefresh;

    public CharacterRegistryController(CharacterRegistryPanel view,
                                       CharacterRegistryRuntime runtime,
                                       MagicRegistryRuntime magicRegistryRuntime,
                                       CharacterTable characterTable,
                                       CharacterMagicTypeTable magicTypeTable
    ) {
        this.view = view;
        this.runtime = runtime;
        this.magicRegistryRuntime = magicRegistryRuntime;
        this.characterTable = characterTable;
        this.magicTypeTable = magicTypeTable;

        view.addSubmitListener(e -> handleCharacterSubmit());
    }

    @Override
    public void refresh() {
        runtime.setCharacters(characterTable.fetch());
        runtime.setMagicTypes(magicTypeTable.fetch());

        view.updateMagicTypeCombo(magicRegistryRuntime.magicTypes());

        Character selectedCharacter = runtime.getSelectedCharacter();

        if(selectedCharacter != null){
            // Selected Character
            view.updateCharacterNameInputValue(selectedCharacter.getName());
            view.updateCharacterAgeInputValue(String.valueOf(selectedCharacter.getAge()));
            view.updateCharacterRoleSelection(selectedCharacter.getRole());
            view.updateDescriptionInputValue(selectedCharacter.getDescription());

            // Selected Character Magic Types
            List<CharacterMagicType> magicList = runtime.getMagicTypesFromCharacterID(selectedCharacter.getID());
            CharacterMagicType[] scMagicTypes = new CharacterMagicType[3];

            for (int i = 0; i < Math.min(magicList.size(), 3); i++) {
                scMagicTypes[i] = magicList.get(i);
            }

            view.updatePrimaryProficiencyInputValue("0");
            view.updateSecondaryProficiencyInputValue("0");
            view.updateTertiaryProficiencyInputValue("0");

            if(scMagicTypes[0] != null){
                view.updatePrimaryMagicTypeSelection(magicRegistryRuntime.getMagicTypeFromID(scMagicTypes[0].getMagicTypeID()));
                view.updatePrimaryProficiencyInputValue(String.valueOf(scMagicTypes[0].getProficiency()));
            }

            if(scMagicTypes[1] != null){
                view.updateSecondaryMagicTypeSelection(magicRegistryRuntime.getMagicTypeFromID(scMagicTypes[1].getMagicTypeID()));
                view.updateSecondaryProficiencyInputValue(String.valueOf(scMagicTypes[1].getProficiency()));
            }

            if(scMagicTypes[2] != null){
                view.updateTertiaryMagicTypeSelection(magicRegistryRuntime.getMagicTypeFromID(scMagicTypes[2].getMagicTypeID()));
                view.updateTertiaryProficiencyInputValue(String.valueOf(scMagicTypes[2].getProficiency()));
            }
        }
        else{
            view.updateCharacterNameInputValue("");
            view.updateCharacterAgeInputValue("");
            view.updateDescriptionInputValue("");

            view.updatePrimaryProficiencyInputValue("0");
            view.updateSecondaryProficiencyInputValue("0");
            view.updateTertiaryProficiencyInputValue("0");
        }
    }

    @Override
    public void setGlobalRefresh(Runnable globalRefresh) {
        this.globalRefresh = globalRefresh;
    }

    private void handleCharacterSubmit(){
        Character selectedCharacter = runtime.getSelectedCharacter();

        if (selectedCharacter == null){
            JOptionPane.showMessageDialog(view, "Please select a character");
            return;
        }

        // Character
        String name = Text.toTitleCase(view.getNameInputValue().trim());
        Role role = view.getRoleValue();
        int age;
        String description = view.getDescriptionInputValue().trim();

        try{
            age = Integer.parseInt(view.getAgeInputValue().trim());

            if(age < 0){
                throw new IllegalArgumentException("Age must be a positive integer");
            }
        } catch(Exception e){
            JOptionPane.showMessageDialog(view, "Please enter a valid age (At least 0)", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Character character = new Character(name, role, age, description);

        characterTable.write(character);

        runtime.setCharacters(characterTable.fetch());

        // Magic Type
        MagicType[] magicTypes = new MagicType[]{
                view.getPrimaryMagicType(),
                view.getSecondaryMagicType(),
                view.getTertiaryMagicType(),
        };

        String[] proficiencyInputs = new String[]{
                view.getPrimaryProficiencyInputValue(),
                view.getSecondaryProficiencyInputValue(),
                view.getTertiaryProficiencyInputValue()
        };

        int[] proficiencies = new int[magicTypes.length];

        int characterID = characterTable.fetchID(character.getName());
        List<CharacterMagicType> cmt = new ArrayList<>();

       try{
           for(int i = 0; i < magicTypes.length; i++){
               if(magicTypes[i] != null && magicTypes[i].id() > 0){
                   for (int j = i - 1; j >= 0; j--) {
                       if (magicTypes[j].equals(magicTypes[i])) {
                           throw new IllegalArgumentException("Magic type must be unique");
                       }
                   }

                   proficiencies[i] = Integer.parseInt(proficiencyInputs[i]);

                   String slot = switch (i) {
                       case 0 -> "Primary";
                       case 1 -> "Secondary";
                       case 2 -> "Tertiary";
                       default -> throw new IllegalStateException("Unexpected value: " + i);
                   };

                   if(proficiencies[i] < 1 ||  proficiencies[i] > 3){
                       throw new IllegalArgumentException(slot + " proficiency level must be between 1 and 3");
                   }

                   cmt.add(new CharacterMagicType(characterID, magicTypes[i].id(), Slot.fromName(slot), proficiencies[i]));
               }
           }
       }catch(NumberFormatException e){
           JOptionPane.showMessageDialog(view, "Please enter a valid proficiency level (1 to 3)", "Error", JOptionPane.ERROR_MESSAGE);
           return;
       }catch(IllegalArgumentException e){
           JOptionPane.showMessageDialog(view, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
           return;
       }catch(Exception e){
           JOptionPane.showMessageDialog(view, "Something went wrong", "Error", JOptionPane.ERROR_MESSAGE);
           return;
       }

       magicTypeTable.write(cmt);
       globalRefresh.run();
    }
}

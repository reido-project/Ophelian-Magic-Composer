package app.controllers;

import app.models.database.tables.CharacterSpellTable;
import app.models.interfaces.Refreshable;
import app.models.runtime.CharacterRegistryRuntime;
import app.models.runtime.MagicRegistryRuntime;
import app.models.runtime.SpellRegistryRuntime;
import app.models.types.*;
import app.models.types.Character;
import app.views.panels.CharacterSpellPanel;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class CharacterSpellController implements Refreshable {
    private final CharacterSpellPanel view;
    private final CharacterRegistryRuntime runtime;
    private final SpellRegistryRuntime spellRegistryRuntime;
    private final MagicRegistryRuntime magicRegistryRuntime;
    private final CharacterSpellTable table;

    private Runnable globalRefresh;

    private boolean lock = false;

    public CharacterSpellController(CharacterSpellPanel view, CharacterRegistryRuntime runtime, SpellRegistryRuntime spellRegistryRuntime, MagicRegistryRuntime magicRegistryRuntime, CharacterSpellTable table){
        this.view = view;
        this.runtime = runtime;
        this.spellRegistryRuntime = spellRegistryRuntime;
        this.magicRegistryRuntime = magicRegistryRuntime;
        this.table = table;

        view.addSubmitListener(e -> handleCharacterSpellSubmit());
        view.addMagicTypeComboListener(e -> {
            try{
                lock = true;
                refresh();
            }finally {
                lock = false;
            }
        });
    }

    @Override
    public void refresh() {
        runtime.setSpells(table.fetch());

        Character sc = runtime.getSelectedCharacter();

        if(sc != null){
            // Character's Magic Type Selection
            List<CharacterMagicType> scMagicList = runtime.getMagicTypesFromCharacterID(sc.getID());
            List<MagicType> scMagicType = new ArrayList<>();

            for(CharacterMagicType magicType : scMagicList){
                scMagicType.add(magicRegistryRuntime.getMagicTypeFromID(magicType.getID()));
            }

            // Character's Spell Selection
            List<CharacterSpell> characterSpells = runtime.getSpells(); // CharacterSpell selected info

            List<Spell> spells = new ArrayList<>(); // All Spells for Selected Character's Magic Types
            List<Spell> scSpells = new ArrayList<>(); // Character's Actual Selected Spells

            MagicType currentMagicType = view.getMagicTypeSelectComboValue();

            for(MagicType magicType : scMagicType){
                if(currentMagicType != null && currentMagicType.id() == magicType.id()){
                    spells.addAll(spellRegistryRuntime.getSpellsByMagicTypeID(magicType.id()));
                }
            }

            for(CharacterSpell characterSpell : characterSpells){
                if(characterSpell.characterID() == sc.getID()){
                    for(Spell spell : spells){
                        if(currentMagicType.id() == spell.magicTypeID() && characterSpell.spellID() == spell.id()){
                            scSpells.add(spell);
                        }
                    }
                }
            }

            if(!lock) {
                view.updateMagicTypeCombo(scMagicType);
            }

            view.updateSpells(spells);
            view.updateSelectedSpells(scSpells);

            view.updateInfoNameLabelText(sc.getName());
            view.updateInfoRoleLabelText(sc.getRole().getName());
            view.updateInfoAgeLabelText(String.valueOf(sc.getAge()));
        }
        else{
            view.updateInfoNameLabelText("");
            view.updateInfoRoleLabelText("");
            view.updateInfoAgeLabelText("");

            view.updateMagicTypeCombo(new ArrayList<>());
            view.updateSpells(new ArrayList<>());
            view.updateSelectedSpells(new ArrayList<>());
        }
    }

    @Override
    public void setGlobalRefresh(Runnable globalRefresh) {
        this.globalRefresh = globalRefresh;
    }

    private void handleCharacterSpellSubmit(){
        Character selectedCharacter = runtime.getSelectedCharacter();

        if (selectedCharacter == null){
            JOptionPane.showMessageDialog(view, "Please select a character");
            return;
        }

        // Magic Type
        MagicType magicType = view.getMagicTypeSelectComboValue();

        // Spells
        List<Spell> spells = view.getSelectedSpells();

        List<CharacterSpell> characterSpells = new ArrayList<>();

        for(Spell spell : spells){
            characterSpells.add(new CharacterSpell(selectedCharacter.getID(), spell.id()));
        }

        table.deleteByCharacterID(selectedCharacter.getID());
        table.write(characterSpells);
        globalRefresh.run();
    }
}

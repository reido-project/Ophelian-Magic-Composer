package app.models.runtime;

import app.models.types.Character;
import app.models.types.CharacterMagicType;
import app.models.types.CharacterSpell;

import java.util.ArrayList;
import java.util.List;

public class CharacterRegistryRuntime {
    private final List<Character> characters;
    private final List<CharacterMagicType> magicTypes;
    private final List<CharacterSpell> spells;

    private Character selectedCharacter;

    public CharacterRegistryRuntime(List<Character> characters, List<CharacterMagicType> magicTypes,  List<CharacterSpell> spells) {
        this.characters = characters;
        this.magicTypes = magicTypes;
        this.spells = spells;
    }

    public List<Character> getCharacters() {
        return characters;
    }

    public void setCharacters(List<Character> charactersUpdate) {
        characters.clear();
        characters.addAll(charactersUpdate);
    }

    public List<CharacterMagicType> getMagicTypes() {
        return magicTypes;
    }

    public void setMagicTypes(List<CharacterMagicType> magicTypesUpdate) {
        magicTypes.clear();
        magicTypes.addAll(magicTypesUpdate);
    }

    public List<CharacterSpell> getSpells() {
        return spells;
    }

    public void setSpells(List<CharacterSpell> spellsUpdate) {
        spells.clear();
        spells.addAll(spellsUpdate);
    }

    public Character getSelectedCharacter() {
        return selectedCharacter;
    }

    public void setSelectedCharacter(Character character) {
        this.selectedCharacter = character;
    }

    public List<CharacterMagicType> getMagicTypesFromCharacterID(int characterID) {
        List<CharacterMagicType> result = new ArrayList<>();

        for (CharacterMagicType magicType : magicTypes) {
            if (magicType.getCharacterID() == characterID) {
                result.add(magicType);
            }
        }

        return result;
    }
}

package app.models.runtime;

import app.models.types.Character;
import app.models.types.CharacterMagicType;

import java.util.List;

public class CharacterRegistryRuntime {
    private List<Character> characters;
    private List<CharacterMagicType> magicTypes;
    private int characterLastIndex;
    private int magicTypeLastIndex;

    public CharacterRegistryRuntime(List<Character> characters, List<CharacterMagicType> magicTypes) {
        this.characters = characters;
        this.magicTypes = magicTypes;
        this.characterLastIndex = characters.size() - 1;
        this.magicTypeLastIndex = magicTypes.size() - 1;
    }

    public void addCharacter(Character character) {
        characters.add(character);
    }

    public void addMagicType(CharacterMagicType magicType) {
        magicTypes.add(magicType);
    }

    public List<Character> getCharacters() {
        return characters;
    }

    public List<CharacterMagicType> getMagicTypes() {
        return magicTypes;
    }

    public void setCharacters(List<Character> characters) {
        this.characters = characters;
        this.characterLastIndex = characters.size() - 1;
    }

    public void setMagicTypes(List<CharacterMagicType> magicTypes) {
        this.magicTypes = magicTypes;
        this.magicTypeLastIndex = magicTypes.size() - 1;
    }

    public int getCharacterLastIndex() {
        return characterLastIndex;
    }

    public int getMagicTypeLastIndex() {
        return magicTypeLastIndex;
    }
}

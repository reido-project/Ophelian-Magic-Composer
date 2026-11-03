package app.models.runtime;

import app.models.types.Character;
import app.models.types.CharacterMagicType;

import java.util.List;

public class CharacterRegistryRuntime {
    private final List<Character> characters;
    private final List<CharacterMagicType> magicTypes;
    private Character selectedCharacter;

    public CharacterRegistryRuntime(List<Character> characters, List<CharacterMagicType> magicTypes) {
        this.characters = characters;
        this.magicTypes = magicTypes;

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

    public Character getSelectedCharacter() {
        return selectedCharacter;
    }

    public void setSelectedCharacter(Character character) {
        this.selectedCharacter = character;
    }
}

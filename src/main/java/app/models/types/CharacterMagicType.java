package app.models.types;

import app.models.enums.Slot;

public record CharacterMagicType(int id, int characterID, int magicTypeID, Slot slot, int proficiency) {
    public CharacterMagicType(int characterID, int magicTypeID, Slot slot, int proficiency) {
        this(0, characterID, magicTypeID, slot, proficiency);
    }
}
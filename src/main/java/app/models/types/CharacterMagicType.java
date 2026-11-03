package app.models.types;

import app.models.enums.Slot;

public class CharacterMagicType {
    private final int id;
    private int characterID;
    private final int magicTypeID;
    private final Slot slot;
    private final int proficiency;

    public CharacterMagicType(int id, int characterID, int magicTypeID, Slot slot, int proficiency) {
        this.id = id;
        this.characterID = characterID;
        this.magicTypeID = magicTypeID;
        this.slot = slot;
        this.proficiency = proficiency;
    }

    public CharacterMagicType(int characterID, int magicTypeID, Slot slot, int proficiency) {
        this(0, characterID, magicTypeID, slot, proficiency);
    }


    public int getID() {
        return id;
    }

    public int getCharacterID() {
        return characterID;
    }

    public void setCharacterID(int characterID) {
        this.characterID = characterID;
    }

    public int getMagicTypeID() {
        return magicTypeID;
    }

    public Slot getSlot() {
        return slot;
    }

    public int getProficiency() {
        return proficiency;
    }
}
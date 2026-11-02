package app.models.types;

public record CharacterSpell(int id, int characterID, int spellID) {
    public CharacterSpell(int characterID, int spellID) {
        this(0, characterID, spellID);
    }
}

package app.models.runtime;

import app.models.types.CharacterSpell;

import java.util.List;

public class CharacterSpellRegistryRuntime {
    private List<CharacterSpell> spells;
    private int spellsLastIndex;

    public CharacterSpellRegistryRuntime(List<CharacterSpell> spells) {
        this.spells = spells;
        this.spellsLastIndex = spells.size() - 1;
    }

    public void add(CharacterSpell spell) {
        spells.add(spell);
    }

    public List<CharacterSpell> get() {
        return spells;
    }

    public void set(List<CharacterSpell> spells) {
        this.spells = spells;
        this.spellsLastIndex = spells.size() - 1;
    }

    public int getSpellsLastIndex() {
        return spellsLastIndex;
    }
}

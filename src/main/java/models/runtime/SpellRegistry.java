package models.runtime;

import models.types.Spell;

import java.util.List;

public class SpellRegistry {
    private List<Spell> spells;
    private int spellsLastIndex;

    public SpellRegistry(List<Spell> spells) {
        this.spells = spells;
        this.spellsLastIndex = spells.size() - 1;
    }

    public void addSpell(Spell spell) {
        spells.add(spell);
    }

    public List<Spell> get() {
        return spells;
    }

    public void set(List<Spell> spells) {
        this.spells = spells;
        this.spellsLastIndex = spells.size() - 1;
    }

    public int getSpellsLastIndex() {
        return spellsLastIndex;
    }
}

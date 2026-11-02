package app.models.runtime;

import app.models.types.Spell;

import java.util.List;

public record SpellRegistryRuntime(List<Spell> spells) {
    public void set(List<Spell> spellsUpdate) {
        spells.clear();
        spells.addAll(spellsUpdate);
    }
}
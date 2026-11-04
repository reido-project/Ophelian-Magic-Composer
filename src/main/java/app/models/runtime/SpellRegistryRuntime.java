package app.models.runtime;

import app.models.types.Spell;

import java.util.ArrayList;
import java.util.List;

public record SpellRegistryRuntime(List<Spell> spells) {
    public void set(List<Spell> spellsUpdate) {
        spells.clear();
        spells.addAll(spellsUpdate);
    }

    public List<Spell> getSpellsByMagicTypeID(int id) {
        List<Spell> result = new ArrayList<>();

        for(Spell spell : spells){
            if(spell.magicTypeID() == id){
                result.add(spell);
            }
        }

        return result;
    }
}
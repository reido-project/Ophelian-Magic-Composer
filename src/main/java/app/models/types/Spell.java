package app.models.types;

import app.models.enums.Target;

public record Spell(int id, int magicTypeID, String name, Target target, boolean contact, boolean shortRange, boolean longRange, boolean aoe, int minimumProficiency, long cost, String mechanism, String reference) {
    public Spell(int magicTypeID, String name, Target target, boolean contact, boolean shortRange, boolean longRange, boolean aoe, int minimumProficiency, long cost, String mechanism, String reference) {
        this(0, magicTypeID, name, target, contact, shortRange, longRange, aoe, minimumProficiency, cost, mechanism, reference);
    }

    @Override
    public String toString() {
        return name;
    }
}

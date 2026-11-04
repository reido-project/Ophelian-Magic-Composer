package tools.seeder.seeds;

import tools.seeder.model.enums.Target;
import tools.seeder.model.Spell;

public final class SpellSeed {
    public static Spell[] get(){
        return new Spell[]{
                // ==========================================
                // DARKNESS
                // ==========================================
                new Spell(1, 1, "Nyx Kalytra", Target.Matter,
                        false, true, false, true,
                        2, 200000,
                        "Destroys information from photon.", ""),

                new Spell(2, 1, "Umbra Veyl", Target.Matter,
                        false, true, false, false,
                        1, 50000,
                        "Absorbs photons from a target area, creating absolute darkness within its range.", ""),

                new Spell(4, 1, "Tenebris", Target.Matter,
                        false, true, false, false,
                        3, 150000,
                        "Manipulates the distribution of photons to create localized shadows that obscure a target.", ""),

                // ==========================================
                // CRYO
                // ==========================================
                new Spell(5, 2, "Glacies Forma", Target.Matter,
                        false, true, false, false,
                        1, 75000,
                        "Manipulates the shape of frozen liquids or gases, forming solid structures from existing frozen material.", ""),

                new Spell(6, 2, "Cryo Vectis", Target.Matter,
                        false, true, false, false,
                        2, 150000,
                        "Manipulates the movement of frozen liquids or gases, allowing the caster to redirect or propel them.", ""),

                new Spell(8, 2, "Frigus Vinculum", Target.Matter,
                        false, true, false, true,
                        3, 350000,
                        "Shapes existing frozen material into restraints that immobilize targets within the affected area.", ""),

                // ==========================================
                // FROST
                // ==========================================
                new Spell(9, 3, "Algor", Target.Matter,
                        false, true, false, false,
                        1, 50000,
                        "Manipulates the temperature of a target, reducing it toward -273.15 degrees Celsius.", ""),

                new Spell(10, 3, "Glacialis", Target.Matter,
                        false, true, false, false,
                        2, 100000,
                        "Manipulates the temperature of a target or area to freeze available liquids and moisture.", ""),

                new Spell(11, 3, "Mors Frigoris", Target.Matter,
                        false, true, false, true,
                        3, 300000,
                        "Reduces the temperature of everything within an affected area, potentially freezing liquids and causing severe thermal damage.", ""),

                // ==========================================
                // LIGHT
                // ==========================================
                new Spell(13, 4, "Lux Aeterna", Target.Matter,
                        false, true, false, true,
                        1, 100000,
                        "Concentrates and emits photons across an area, producing intense illumination.", ""),

                new Spell(14, 4, "Radiant Lance", Target.Matter,
                        false, true, false, false,
                        2, 200000,
                        "Concentrates photons into a narrow beam directed toward a target.", ""),

                new Spell(16, 4, "Prisma", Target.Matter,
                        false, true, false, false,
                        3, 250000,
                        "Refracts and redirects photons to distort the apparent position and appearance of objects.", ""),
        };
    }
}
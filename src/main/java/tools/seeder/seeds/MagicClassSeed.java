package tools.seeder.seeds;

import tools.seeder.model.MagicClass;

public final class MagicClassSeed {
    public static MagicClass[] get(){
        return new MagicClass[]{
                new MagicClass(1, "Thermodynamics"),
                new MagicClass(2, "Optics"),
                new MagicClass(3, "Crystallography"),
                new MagicClass(4, "Phase Transitions"),
                new MagicClass(5, "Electromagnetism"),
                new MagicClass(6, "Fluid Dynamics"),
                new MagicClass(7, "Nuclear"),
                new MagicClass(8, "Acoustics"),
                new MagicClass(9, "Gravitation"),
                new MagicClass(10, "Space"),
        };
    }
}

package tools.seeder.seeds;

import tools.seeder.model.MagicType;

public final class MagicTypeSeed {
    public static MagicType[] get(){
        return new MagicType[]{
                new MagicType(1, 2, "Darkness", 1, ""),
                new MagicType(2, 4, "Cryo", 2, "Can do everything Frost magic does, can also manipulate the movement and shape of frozen liquid or gas. Cannot manipulate the movement or shape of already solid object, even if it's frozen."),
                new MagicType(3, 1, "Frost", 1, "Can manipulate temperature of any object or area from -273.15 degree Celsius to exactly 25 degree Celsius. Beyond that, the object's / environment temperature cannot be manipulated by this magic."),
                new MagicType(4, 8, "Light", 3, ""),
        };
    }
}
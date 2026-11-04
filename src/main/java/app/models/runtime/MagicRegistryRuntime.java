package app.models.runtime;

import app.models.types.MagicClass;
import app.models.types.MagicType;

import java.util.List;

public record MagicRegistryRuntime(List<MagicClass> magicClasses, List<MagicType> magicTypes) {
    public MagicRegistryRuntime(List<MagicClass> magicClasses, List<MagicType> magicTypes) {
        this.magicClasses = magicClasses;

        magicTypes.addFirst(new MagicType(0, 0, "Unspecified", 0, ""));
        this.magicTypes = magicTypes;
    }

    public void setMagicClasses(List<MagicClass> magicClassChange) {
        magicClasses.clear();
        magicClasses.addAll(magicClassChange);
    }

    public void setMagicTypes(List<MagicType> magicTypeChange) {
        magicTypes.clear();
        magicTypes.addFirst(new MagicType(0, 0, "Unspecified", 0, ""));
        magicTypes.addAll(magicTypeChange);
    }

    public MagicType getMagicTypeFromID(int id) {
        for (MagicType magicType : magicTypes) {
            if(magicType.id() == id){
                return magicType;
            }
        }

        return null;
    }
}

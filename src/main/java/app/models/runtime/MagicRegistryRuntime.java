package app.models.runtime;

import app.models.types.MagicClass;
import app.models.types.MagicType;

import java.util.List;

public record MagicRegistryRuntime(List<MagicClass> magicClasses, List<MagicType> magicTypes) {
    public void setMagicClasses(List<MagicClass> magicClassChange) {
        magicClasses.clear();
        magicClasses.addAll(magicClassChange);
    }

    public void setMagicTypes(List<MagicType> magicTypeChange) {
        magicTypes.clear();
        magicTypes.addAll(magicTypeChange);
    }
}

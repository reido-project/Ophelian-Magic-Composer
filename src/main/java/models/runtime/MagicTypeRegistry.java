package models.runtime;

import models.types.MagicClass;
import models.types.MagicType;

import java.util.List;

public class MagicTypeRegistry {
    private final List<MagicClass> magicClasses;
    private List<MagicType> magicTypes;
    private int magicTypesLastIndex;

    public MagicTypeRegistry(List<MagicClass> magicClasses, List<MagicType> magicTypes) {
        this.magicClasses = magicClasses;
        this.magicTypes = magicTypes;
        this.magicTypesLastIndex = magicTypes.size() - 1;
    }

    public void add(MagicType magicType) {
        magicTypes.add(magicType);
    }

    public List<MagicClass> getMagicClasses() {
        return magicClasses;
    }

    public List<MagicType> getMagicTypes() {
        return magicTypes;
    }

    public void setMagicTypes(List<MagicType> magicTypes) {
        this.magicTypes = magicTypes;
        this.magicTypesLastIndex = magicTypes.size() - 1;
    }

    public int getMagicTypesLastIndex() {
        return magicTypesLastIndex;
    }
}

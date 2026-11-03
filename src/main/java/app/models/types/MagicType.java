package app.models.types;

public record MagicType(int id, int magicClassID, String name, int magicLevel, String description) {
    public MagicType(int magicClassID, String name, int magicLevel, String description) {
        this(0, magicClassID, name, magicLevel, description);
    }

    @Override
    public String toString() {
        return name;
    }
}
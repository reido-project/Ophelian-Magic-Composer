package app.models.types;

public record MagicClass(int id, String name) {
    @Override
    public String toString() {
        return name;
    }
}

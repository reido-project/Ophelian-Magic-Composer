package tools.seeder.model;

public record MagicClass(int id, String name) {
    public MagicClass(String name) {
        this(0, name);
    }
}

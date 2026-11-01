package models.enums;

public enum Target {
    MATTER("Matter"),
    ENERGY("Energy"),
    FIELD("Field"),
    WAVE("Wave"),
    ORGANISM("Organism"),
    SPACE("Space");

    private final String name;

    Target(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

package app.models.enums;

public enum Target {
    Matter("Matter"),
    Energy("Energy"),
    Field("Field"),
    Wave("Wave"),
    Organism("Organism"),
    Space("Space");

    private final String name;

    Target(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static Target fromName(String name) {
        for (Target target : Target.values()) {
            if (target.getName().equalsIgnoreCase(name)) {
                return target;
            }
        }
        throw new IllegalArgumentException("No enum constant with name: " + name);
    }
}

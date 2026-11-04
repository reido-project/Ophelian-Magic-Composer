package tools.seeder.model.enums;

public enum Slot {
    Primary("Primary"),
    Secondary("Secondary"),
    Tertiary("Tertiary");

    private final String name;

    Slot(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static Slot fromName(String name) {
        for (Slot slot : Slot.values()) {
            if (slot.getName().equalsIgnoreCase(name)) {
                return slot;
            }
        }
        throw new IllegalArgumentException("No enum constant with name: " + name);
    }
}

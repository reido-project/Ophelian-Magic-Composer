package models.enums;

public enum Slot {
    PRIMARY("Primary"),
    SECONDARY("Secondary"),
    TERTIARY("Tertiary");

    private final String name;

    Slot(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

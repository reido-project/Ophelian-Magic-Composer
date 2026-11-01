package models.enums;

public enum Range {
    CONTACT("Contact"),
    SHORT("Short Range"),
    LONG("Long Range"),
    AOE("Area of Effect");

    private final String name;

    Range(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

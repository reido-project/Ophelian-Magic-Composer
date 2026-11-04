package tools.seeder.model.enums;

public enum Range {
    Contact("Contact"),
    Short("Short Range"),
    Long("Long Range"),
    Age("Area of Effect");

    private final String name;

    Range(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

package app.models.enums;

public enum Role {
    Unspecified("Unspecified"),
    Harbinger("Harbinger"),
    Ophelian("Ophelian"),
    Human("Human");

    private final String name;

    Role(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static Role fromName(String name) {
        for (Role role : Role.values()) {
            if (role.getName().equalsIgnoreCase(name)) {
                return role;
            }
        }
        throw new IllegalArgumentException("No enum constant with name: " + name);
    }
}

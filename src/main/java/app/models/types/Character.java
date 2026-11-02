package app.models.types;

import app.models.enums.Role;

public record Character(int id, String name, Role role, int age, String description) {
    public Character(String name, Role role, int age, String description) {
        this(0, name, role, age, description);
    }
}

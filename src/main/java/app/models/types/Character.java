package app.models.types;

import app.models.enums.Role;

public class Character {
    private final int id;
    private String name;
    private Role role;
    private int age;
    private String description;

    public Character(int id, String name, Role role, int age, String description) {
        this.id = id;
        this.name = name;
        this.role = role;
        this.age = age;
        this.description = description;
    }

    public Character(String name, Role role, int age, String description) {
        this(0, name, role, age, description);
    }

    public int getID() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        if (id == -1) return "Create New Character";

        return String.format("[%s] %s", this.role.getName(), this.name);
    }
}
package models.database.tables;

import models.database.Database;
import models.enums.Role;
import models.types.Character;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CharacterTable extends Database {
    public void push(List<Character> characters) {
        connect();

        for(Character chara : characters) {
            String sql = String.format("""
                INSERT INTO characters (name, role, age, description) VALUES ('%s', '%s', %d, '%s');
                """, chara.name(), chara.role().getName(), chara.age(), chara.description());

            query(sql);
        }

        disconnect();
    }

    public List<Character> pull() {
        connect();

        List<Character> result = new ArrayList<>();

        ResultSet rs = view("""
                SELECT id, name, role, age, description FROM characters;
                """);

        if(rs == null) {
            return result;
        }

        try{
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String role = rs.getString("role");
                int age = rs.getInt("age");
                String description = rs.getString("description");

                result.add(new Character(id, name, Role.fromName(role), age, description));
            }
        }catch(SQLException e){
            System.err.println("Error while trying to pull Characters from database: " + e.getMessage());
        }
        finally {
            disconnect();
        }

        return result;
    }
}

package app.models.database.tables;

import app.models.database.Database;
import app.models.enums.Role;
import app.models.types.Character;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CharacterTable extends Database {
    public void write(Character chara) {
        connect();

        String sql = String.format("""
                INSERT OR REPLACE INTO characters (name, role, age, description) VALUES ('%s', '%s', %d, '%s');
                """, chara.getName(), chara.getRole().getName(), chara.getAge(), chara.getDescription());

        query(sql);

        disconnect();
    }

    public void write(List<Character> characters) {
        connect();

        for(Character chara : characters) {
            String sql = String.format("""
                INSERT OR REPLACE INTO characters (name, role, age, description) VALUES ('%s', '%s', %d, '%s');
                """, chara.getName(), chara.getRole().getName(), chara.getAge(), chara.getDescription());

            query(sql);
        }

        disconnect();
    }

    public List<Character> fetch() {
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
            System.err.println("Error while trying to fetch Characters from database: " + e.getMessage());
        }
        finally {
            disconnect();
        }

        return result;
    }

    public int fetchID(String name){
        connect();

        String sql = String.format("SELECT id FROM characters WHERE name = '%s';", name);

        ResultSet rs = view(sql);

        if(rs == null) {
            return -1;
        }

        try{
            rs.next();
            return rs.getInt("id");
        }catch(SQLException e){
            System.err.println("Error while trying to fetch Characters from database: " + e.getMessage());
        }
        finally {
            disconnect();
        }

        return -1;
    }
}

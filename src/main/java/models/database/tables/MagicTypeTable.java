package models.database.tables;

import models.database.Database;
import models.types.MagicType;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MagicTypeTable extends Database {
    public void push(List<MagicType> magicTypes) {
        connect();

        for(MagicType magicType : magicTypes) {
            String sql = String.format("""
                INSERT INTO magic_types (magic_class_id, name, magic_level, description)  VALUES (%d, '%s', %d, '%s');
                """, magicType.magicClassID(), magicType.name(), magicType.magicLevel(), magicType.description());

            query(sql);
        }

        disconnect();
    }

    public List<MagicType> pull() {
        connect();

        List<MagicType> result = new ArrayList<>();

        ResultSet rs = view("""
                SELECT id, magic_class_id, name, magic_level, description FROM magic_types;
                """);

        if(rs == null) {
            return result;
        }

        try{
            while(rs.next()){
                int id = rs.getInt("id");
                int magicClassID = rs.getInt("magic_class_id");
                String name = rs.getString("name");
                int magicLevel = rs.getInt("magic_level");
                String description = rs.getString("description");

                result.add(new MagicType(magicClassID, name, magicLevel, description));
            }
        }catch (SQLException e){
            System.err.println("Error while trying to pull Magic Type from database: " + e.getMessage());
        }finally {
            disconnect();
        }

        return result;
    }
}

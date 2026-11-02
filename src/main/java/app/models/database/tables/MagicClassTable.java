package app.models.database.tables;

import app.models.database.Database;
import app.models.types.MagicClass;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MagicClassTable extends Database {
    public List<MagicClass> fetch(){
        connect();

        List<MagicClass> result = new ArrayList<>();

        ResultSet rs = view("""
                SELECT id, name FROM magic_class;
                """);

        if(rs == null) {
            return result;
        }

        try{
            while(rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");

                result.add(new MagicClass(id, name));
            }
        } catch (SQLException e) {
            System.err.println("Error while trying to fetch Magic Class from database: " + e.getMessage());
        }
        finally {
            disconnect();
        }

        return result;
    }
}

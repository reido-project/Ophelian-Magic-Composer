package app.models.database.tables;

import app.models.database.Database;
import app.models.enums.Slot;
import app.models.types.CharacterMagicType;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CharacterMagicTypeTable extends Database {
    public void write(List<CharacterMagicType> characterMagicTypes) {
        connect();

        for (CharacterMagicType cmt : characterMagicTypes) {
            String sql = String.format("""
                    INSERT INTO character_magic_types (character_id, magic_type_id, slot, proficiency) VALUES (%d, %d, '%s', %d);
                    """, cmt.characterID(), cmt.magicTypeID(), cmt.slot().getName(), cmt.proficiency());

            query(sql);
        }

        disconnect();
    }

    public List<CharacterMagicType> fetch() {
        connect();

        List<CharacterMagicType> result = new ArrayList<>();

        ResultSet rs = view("""
                SELECT id, character_id, magic_type_id, slot, proficiency FROM character_magic_types;
                """);

        if (rs == null) {
            return result;
        }

        try{
            while(rs.next()){
                int id = rs.getInt("id");
                int characterID = rs.getInt("character_id");
                int magicTypeID = rs.getInt("magic_type_id");
                String slot = rs.getString("slot");
                int proficiency = rs.getInt("proficiency");

                result.add(new CharacterMagicType(id, characterID, magicTypeID, Slot.fromName(slot), proficiency));
            }
        }catch (SQLException e){
            System.err.println("Error while trying to fetch Character Magic Types from database: " + e.getMessage());
        }
        finally {
            disconnect();
        }

        return result;
    }
}

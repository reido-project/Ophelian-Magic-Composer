package app.models.database.tables;

import app.models.database.Database;
import app.models.types.CharacterSpell;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CharacterSpellTable extends Database {
    public void write(CharacterSpell characterSpell) {
        connect();

        String sql = String.format("""
                    INSERT INTO character_spells (character_id, spell_id) VALUES (%d, %d);
                    """, characterSpell.characterID(), characterSpell.spellID());

        query(sql);

        disconnect();
    }

    public void write(List<CharacterSpell> characterSpells) {
        connect();

        for(CharacterSpell cs : characterSpells) {
            String sql = String.format("""
                    INSERT INTO character_spells (character_id, spell_id) VALUES (%d, %d);
                    """, cs.characterID(), cs.spellID());

            query(sql);
        }

        disconnect();
    }

    public List<CharacterSpell> fetch() {
        connect();

        List<CharacterSpell> result = new ArrayList<>();

        ResultSet rs = view("""
                SELECT id, character_id, spell_id FROM character_spells;
                """);

        if(rs == null) {
            return result;
        }

        try{
            while (rs.next()){
                int id = rs.getInt("id");
                int charactedID = rs.getInt("character_id");
                int spellID = rs.getInt("spell_id");

                result.add(new CharacterSpell(id, charactedID, spellID));
            }
        } catch (SQLException e) {
            System.err.println("Error while trying to fetch Character Spells from database: " + e.getMessage());
        }
        finally {
            disconnect();
        }

        return result;
    }

    public void deleteByCharacterID(int id){
        connect();

        String sql = String.format("DELETE FROM character_spells WHERE character_id = %d;", id);
        query(sql);

        disconnect();
    }
}

package app.models.database.tables;

import app.models.database.Database;
import app.models.enums.Target;
import app.models.types.Spell;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SpellTable extends Database {
    public void write(Spell spell) {
        connect();

        upsert(spell);

        disconnect();
    }

    public void write(List<Spell> spells) {
        connect();

        for (Spell spell : spells) {
            upsert(spell);
        }

        disconnect();
    }

    public List<Spell> fetch() {
        connect();

        List<Spell> result = new ArrayList<>();

        ResultSet rs = view("""
                SELECT id, magic_type_id, name, target, contact, short_range, long_range, aoe, minimum_proficiency, cost, mechanism, reference FROM spells;
                """);

        if (rs == null) {
            return result;
        }

        try{
            while (rs.next()){
                int id = rs.getInt("id");
                int magicTypeID = rs.getInt("magic_type_id");
                String name = rs.getString("name");
                String target = rs.getString("target");
                boolean contact = rs.getInt("contact") == 1;
                boolean shortRange = rs.getInt("short_range") == 1;
                boolean longRange = rs.getInt("long_range") == 1;
                boolean aoe = rs.getInt("aoe") == 1;
                int minimumProficiency = rs.getInt("minimum_proficiency");
                long cost = rs.getLong("cost");
                String mechanism = rs.getString("mechanism");
                String reference = rs.getString("reference");

                result.add(new Spell(id, magicTypeID, name, Target.fromName(target), contact, shortRange, longRange, aoe, minimumProficiency, cost, mechanism, reference));
            }
        } catch (SQLException e) {
            System.err.println("Error while trying to fetch Spells from database: " + e.getMessage());
        }
        finally {
            disconnect();
        }

        return result;
    }

    private void upsert(Spell spell) {
        int contact = spell.contact() ? 1 : 0;
        int shortRange = spell.shortRange() ? 1 : 0;
        int longRange = spell.longRange() ? 1 : 0;
        int aoe = spell.aoe() ? 1 : 0;

        String sql = String.format("""
                INSERT OR REPLACE INTO spells (magic_type_id, name, target, contact, short_range, long_range, aoe, minimum_proficiency, cost, mechanism, reference) VALUES (%d, '%s', '%s', %d, %d, %d, %d, %d, %d, '%s', '%s');
                """, spell.magicTypeID(), spell.name(), spell.target().getName(), contact, shortRange, longRange, aoe, spell.minimumProficiency(), spell.cost(), spell.mechanism(), spell.reference());

        query(sql);
    }
}

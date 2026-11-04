package tools;

import tools.seeder.model.Character;
import tools.seeder.model.MagicClass;
import tools.seeder.model.MagicType;
import tools.seeder.model.Spell;
import tools.seeder.seeds.CharacterSeed;
import tools.seeder.seeds.MagicClassSeed;
import tools.seeder.seeds.MagicTypeSeed;
import tools.seeder.seeds.SpellSeed;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Tool extends Connector {
    public void migrateAndSeed() {
        connect();

        // === Migrate ===
        String up = "migration/up.sql";
        String down = "migration/down.sql";

        executeSQLFile(down);
        executeSQLFile(up);

        // === Seeds ===
        // 1. Magic Class
        MagicClass[] magicClasses = MagicClassSeed.get();
        for (MagicClass magicClass : magicClasses) {
            String sql = String.format("""
                INSERT INTO magic_class (id, name) VALUES (%d, '%s');
                """, magicClass.id(), escapeSql(magicClass.name()));
            query(sql);
        }

        // 2. Magic Type
        MagicType[] magicTypes = MagicTypeSeed.get();
        for (MagicType magicType : magicTypes) {
            String sql = String.format("""
                INSERT INTO magic_types (id, magic_class_id, name, magic_level, description) VALUES (%d, %d, '%s', %d, '%s');
                """, magicType.id(), magicType.magicClassID(), escapeSql(magicType.name()), magicType.magicLevel(), escapeSql(magicType.description()));
            query(sql);
        }

        // 3. Spell
        Spell[] spells = SpellSeed.get();
        for (Spell spell : spells) {
            pushSpell(spell);
        }

        // 4. Character
        Character[] characters = CharacterSeed.get();
        for (Character character : characters) {
            String sql = String.format("""
                INSERT INTO characters (name, role, age, description) VALUES ('%s', '%s', %d, '%s');
                """,
                    escapeSql(character.name()),
                    escapeSql(character.role().getName()),
                    character.age(),
                    escapeSql(character.description())
            );
            query(sql);
        }

        disconnect();
    }

    public boolean needsMigration() {
        connect();
        try (ResultSet rs = view("SELECT name FROM sqlite_master WHERE type='table' AND name='magic_class'")) {
            return rs == null || !rs.next();
        } catch (SQLException e) {
            return true;
        } finally {
            disconnect();
        }
    }

    private void pushSpell(Spell spell) {
        int[] ranges = boolConvert(new boolean[]{spell.contact(), spell.shortRange(), spell.longRange(), spell.aoe()});

        String sql = String.format("""
            INSERT INTO spells (magic_type_id, name, target, contact, short_range, long_range, aoe, minimum_proficiency, cost, mechanism, reference) VALUES (%d, '%s', '%s', %d, %d, %d, %d, %d, %d, '%s', '%s');
            """,
                spell.magicTypeID(),
                escapeSql(spell.name()),
                escapeSql(spell.target().getName()),
                ranges[0], ranges[1], ranges[2], ranges[3],
                spell.minimumProficiency(),
                spell.cost(),
                escapeSql(spell.mechanism()),
                escapeSql(spell.reference())
        );
        query(sql);
    }

    private int[] boolConvert(boolean[] bool) {
        int[] result = new int[bool.length];
        for (int i = 0; i < bool.length; i++) {
            result[i] = bool[i] ? 1 : 0;
        }
        return result;
    }

    private static String escapeSql(String input) {
        if (input == null) return "";
        return input.replace("'", "''");
    }
}
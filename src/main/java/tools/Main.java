package tools;

import tools.seeder.model.Character;
import tools.seeder.model.MagicClass;
import tools.seeder.model.MagicType;
import tools.seeder.model.Spell;
import tools.seeder.seeds.CharacterSeed;
import tools.seeder.seeds.MagicClassSeed;
import tools.seeder.seeds.MagicTypeSeed;
import tools.seeder.seeds.SpellSeed;

public class Main extends Connector {
    public static void main(String[] args) {
        Main app = new Main();

        app.connect();

        // === Migrate ===
        String up = "src/main/java/tools/migration/Up.sql";
        String down = "src/main/java/tools/migration/Down.sql";

        app.executeSQLFile(down);
        app.executeSQLFile(up);

        // === Seeds ===
        // 1. Magic Class
        MagicClass[] magicClasses = MagicClassSeed.get();
        for (MagicClass magicClass : magicClasses) {
            String sql = String.format("""
                INSERT INTO magic_class (id, name) VALUES (%d, '%s');
                """, magicClass.id(), escapeSql(magicClass.name()));
            app.query(sql);
        }

        // 2. Magic Type
        MagicType[] magicTypes = MagicTypeSeed.get();
        for (MagicType magicType : magicTypes) {
            String sql = String.format("""
                INSERT INTO magic_types (id, magic_class_id, name, magic_level, description) VALUES (%d, %d, '%s', %d, '%s');
                """, magicType.id(), magicType.magicClassID(), escapeSql(magicType.name()), magicType.magicLevel(), escapeSql(magicType.description()));
            app.query(sql);
        }

        // 3. Spell
        Spell[] spells = SpellSeed.get();
        for (Spell spell : spells) {
            int[] ranges = app.boolConvert(new boolean[]{spell.contact(), spell.shortRange(), spell.longRange(), spell.aoe()});

            String sql = String.format("""
                INSERT INTO spells (magic_type_id, name, target, contact, short_range, long_range, aoe, minimum_proficiency, cost, mechanism, reference) 
                VALUES (%d, '%s', '%s', %d, %d, %d, %d, %d, %d, '%s', '%s');
                """,
                    spell.magicTypeID(),
                    escapeSql(spell.name()),
                    escapeSql(spell.target().getName()), // Pastikan target() punya .getName(), kalau String langsung spell.target()
                    ranges[0], ranges[1], ranges[2], ranges[3],
                    spell.minimumProficiency(),
                    spell.cost(),
                    escapeSql(spell.mechanism()),
                    escapeSql(spell.reference())
            );
            app.query(sql);
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
            app.query(sql);
        }

        app.disconnect();
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
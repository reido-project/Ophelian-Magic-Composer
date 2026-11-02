package tools;

import tools.seeder.model.MagicClass;
import tools.seeder.seeds.MagicClassSeed;

public class Main extends Connector{
    public static void main(String[] args) {
        Main app = new Main();

        app.connect();

        // === Migrate ===
        String up = "src/main/java/tools/migration/Up.sql";
        String down = "src/main/java/tools/migration/Down.sql";

        app.executeSQLFile(down);
        app.executeSQLFile(up);


        //  === Seeds ===
        // Magic Class
        MagicClass[] magicClasses = MagicClassSeed.get();

        for(MagicClass magicClass : magicClasses) {
            String sql = String.format("""
                INSERT INTO magic_class (name) VALUES ('%s');
                """, magicClass.name());

            app.query(sql);
        }

        app.disconnect();
    }
}
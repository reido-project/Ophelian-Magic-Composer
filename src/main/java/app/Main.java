package app;

import app.controllers.*;
import app.models.database.tables.*;
import app.models.runtime.MagicRegistryRuntime;
import app.models.runtime.SpellRegistryRuntime;
import app.views.ComposerFrame;
import app.views.panels.*;

import java.awt.*;

public class Main {
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                MagicRegistryPanel magicRegistryPanel = new MagicRegistryPanel();
                SpellRegistryPanel spellRegistryPanel = new SpellRegistryPanel();
                CharacterRegistryPanel characterRegistryPanel = new CharacterRegistryPanel();
                CharacterSelectorPanel characterSelectorPanel = new CharacterSelectorPanel();
                CharacterSpellPanel characterSpellPanel = new CharacterSpellPanel();
                ActionPanel mainActionPanel = new ActionPanel();

                ComposerFrame frame = new ComposerFrame(
                        magicRegistryPanel,
                        spellRegistryPanel,
                        characterRegistryPanel,
                        characterSelectorPanel,
                        characterSpellPanel,
                        mainActionPanel
                );

                MagicClassTable magicClassTable = new MagicClassTable();
                MagicTypeTable magicTypeTable = new MagicTypeTable();
                SpellTable spellTable = new SpellTable();
                CharacterTable characterTable = new CharacterTable();
                CharacterMagicTypeTable characterMagicTypeTable = new CharacterMagicTypeTable();
                CharacterSpellTable characterSpellTable = new CharacterSpellTable();

                MagicRegistryRuntime magicRegistryRuntime = new MagicRegistryRuntime(magicClassTable.fetch(), magicTypeTable.fetch());
                SpellRegistryRuntime spellRegistryRuntime = new SpellRegistryRuntime(spellTable.fetch());

                MagicRegistryController magicRegistryController = new MagicRegistryController(magicRegistryPanel, magicRegistryRuntime, magicTypeTable);
                SpellRegistryController spellRegistryController = new SpellRegistryController(spellRegistryPanel, spellRegistryRuntime, spellTable, magicRegistryRuntime);
                CharacterRegistryController characterRegistryController = new CharacterRegistryController(characterRegistryPanel);
                CharacterSelectorController characterSelectorController = new CharacterSelectorController(characterSelectorPanel);
                CharacterSpellController characterSpellController = new CharacterSpellController(characterSpellPanel);
                ActionController actionController = new ActionController(mainActionPanel);

                frame.setVisible(true);
            } catch (Exception e) {
                System.err.println("Error while trying to start composer frame: " + e.getMessage());
            }
        });
    }
}

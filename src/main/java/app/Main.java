package app;

import app.controllers.*;
import app.models.database.tables.*;
import app.models.interfaces.Refreshable;
import app.models.runtime.CharacterRegistryRuntime;
import app.models.runtime.MagicRegistryRuntime;
import app.models.runtime.SpellRegistryRuntime;
import app.models.types.*;
import app.views.ComposerFrame;
import app.views.panels.*;

import java.awt.EventQueue;

public class Main {
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                // Initialize Tables
                MagicClassTable magicClassTable = new MagicClassTable();
                MagicTypeTable magicTypeTable = new MagicTypeTable();
                SpellTable spellTable = new SpellTable();
                CharacterTable characterTable = new CharacterTable();
                CharacterMagicTypeTable characterMagicTypeTable = new CharacterMagicTypeTable();
                CharacterSpellTable characterSpellTable = new CharacterSpellTable();

                // Initialize Runtime Data
                MagicRegistryRuntime magicRegistryRuntime = new MagicRegistryRuntime(magicClassTable.fetch(), magicTypeTable.fetch());
                SpellRegistryRuntime spellRegistryRuntime = new SpellRegistryRuntime(spellTable.fetch());
                CharacterRegistryRuntime characterRegistryRuntime = new CharacterRegistryRuntime(characterTable.fetch(),  characterMagicTypeTable.fetch());

                // Initialize Panels
                MagicRegistryPanel magicRegistryPanel = new MagicRegistryPanel();
                SpellRegistryPanel spellRegistryPanel = new SpellRegistryPanel();
                CharacterRegistryPanel characterRegistryPanel = new CharacterRegistryPanel();
                CharacterSelectorPanel characterSelectorPanel = new CharacterSelectorPanel();
                CharacterSpellPanel characterSpellPanel = new CharacterSpellPanel();
                ActionPanel mainActionPanel = new ActionPanel();

                // Initialize Controllers
                Refreshable[] controllers =  new Refreshable[]{
                        new MagicRegistryController(
                                magicRegistryPanel,
                                magicRegistryRuntime,
                                magicTypeTable
                        ),
                        new SpellRegistryController(
                                spellRegistryPanel,
                                spellRegistryRuntime,
                                spellTable,
                                magicRegistryRuntime
                        ),
                        new CharacterRegistryController(
                                characterRegistryPanel,
                                characterRegistryRuntime,
                                magicRegistryRuntime,
                                characterTable,
                                characterMagicTypeTable
                        ),
                        new CharacterSelectorController(
                                characterSelectorPanel,
                                characterRegistryRuntime
                        ),
                        new CharacterSpellController(
                                characterSpellPanel
                        )
                };

                ActionController actionController = new ActionController(mainActionPanel, controllers);

                // Initialize Frame
                ComposerFrame frame = new ComposerFrame(
                        magicRegistryPanel,
                        spellRegistryPanel,
                        characterRegistryPanel,
                        characterSelectorPanel,
                        characterSpellPanel,
                        mainActionPanel
                );

                frame.setVisible(true);
            } catch (Exception e) {
                System.err.println("Error while trying to start composer frame: " + e.getMessage());
            }
        });
    }
}

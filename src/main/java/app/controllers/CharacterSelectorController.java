package app.controllers;

import app.models.interfaces.Refreshable;
import app.models.runtime.CharacterRegistryRuntime;
import app.models.types.Character;
import app.views.panels.CharacterSelectorPanel;

import javax.swing.*;

public class CharacterSelectorController implements Refreshable {
    private final CharacterSelectorPanel view;
    private final CharacterRegistryRuntime runtime;

    private Runnable globalRefresh;
    private boolean isSelecting = false;

    public CharacterSelectorController(CharacterSelectorPanel view, CharacterRegistryRuntime runtime) {
        this.view = view;
        this.runtime = runtime;

        view.getCharacterList().addListSelectionListener(e -> handleSelection());
    }

    @Override
    public void refresh() {
        if(!isSelecting) {
            view.updateCharacters(runtime.getCharacters());
        }
    }

    @Override
    public void setGlobalRefresh(Runnable globalRefresh) {
        this.globalRefresh = globalRefresh;
    }

    private void handleSelection(){
        Character selected = view.getSelectedCharacter();

        isSelecting = true;
        try {
            runtime.setSelectedCharacter(selected);
            if (globalRefresh != null) {
                globalRefresh.run();
            }
        } finally {
            isSelecting = false;
        }
    }
}

package app.controllers;

import app.models.interfaces.Refreshable;
import app.views.panels.CharacterSpellPanel;

public class CharacterSpellController implements Refreshable {
    private final CharacterSpellPanel view;

    private Runnable globalRefresh;

    public CharacterSpellController(CharacterSpellPanel view) {
        this.view = view;

        view.addSubmitListener(e -> handleCharacterSpellSubmit());
    }

    @Override
    public void refresh() {

    }

    @Override
    public void setGlobalRefresh(Runnable globalRefresh) {
        this.globalRefresh = globalRefresh;
    }

    private void handleCharacterSpellSubmit(){

    }
}

package app.controllers;

import app.views.panels.CharacterSpellPanel;

public class CharacterSpellController {
    private final CharacterSpellPanel view;

    public CharacterSpellController(CharacterSpellPanel view) {
        this.view = view;
        init();
    }

    private void init(){
        view.addSubmitListener(e -> {
            handleCharacterSpellSubmit();
        });
    }

    private void handleCharacterSpellSubmit(){

    }
}

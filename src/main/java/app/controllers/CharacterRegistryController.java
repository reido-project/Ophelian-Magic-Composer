package app.controllers;

import app.views.panels.CharacterRegistryPanel;

public class CharacterRegistryController {
    private final CharacterRegistryPanel view;

    public CharacterRegistryController(CharacterRegistryPanel view) {
        this.view = view;
        init();
    }

    private void init(){
        view.addSubmitListener(e -> {
            handleCharacterSubmit();
        });
    }

    private void handleCharacterSubmit(){

    }
}

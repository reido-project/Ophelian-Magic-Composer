package app.controllers;

import app.views.panels.ActionPanel;

public class ActionController {
    private final ActionPanel view;

    public ActionController(ActionPanel view) {
        this.view = view;
        init();
    }

    private void init(){
        view.addRefreshListener(e -> {
            handleRefresh();
        });

        view.addExportListener(e -> {
            handleExport();
        });

        view.addExitListener(e -> {
            System.exit(0);
        });
    }

    private void handleRefresh(){

    }

    private void handleExport(){

    }
}

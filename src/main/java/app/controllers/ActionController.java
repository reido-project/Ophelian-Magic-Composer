package app.controllers;

import app.models.interfaces.Refreshable;
import app.views.panels.ActionPanel;

public class ActionController {
    private final Refreshable[] consumer;

    public ActionController(ActionPanel view, Refreshable[] consumer) {
        this.consumer = consumer;

        view.addRefreshListener(e -> {
            handleRefresh();
        });

        view.addExportListener(e -> {
            handleExport();
        });

        view.addExitListener(e -> {
            System.exit(0);
        });

        for(Refreshable refreshable : consumer) {
            refreshable.setGlobalRefresh(this::handleRefresh);
        }

        handleRefresh();
    }

    private void handleRefresh(){
        for(Refreshable refreshable : consumer){
            refreshable.refresh();
        }
    }

    private void handleExport(){

    }
}

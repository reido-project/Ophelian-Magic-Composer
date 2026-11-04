package app.controllers;

import app.models.interfaces.Refreshable;
import app.views.panels.ActionPanel;
import tools.Tool;

import javax.swing.*;

public class ActionController {
    private final Tool tool;
    private final Refreshable[] consumer;

    public ActionController(ActionPanel view, Tool tool, Refreshable[] consumer) {
        this.tool = tool;
        this.consumer = consumer;

        view.addResetListener(e -> {
            handleReset();
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

    private void handleReset(){
        tool.migrateAndSeed();
        handleRefresh();
    }
}

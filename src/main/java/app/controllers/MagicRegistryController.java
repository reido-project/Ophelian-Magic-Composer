package app.controllers;

import app.models.database.tables.MagicTypeTable;
import app.models.interfaces.Refreshable;
import app.models.runtime.MagicRegistryRuntime;
import app.models.types.MagicClass;
import app.models.types.MagicType;
import app.utils.Text;
import app.views.panels.MagicRegistryPanel;

import javax.swing.*;

public class MagicRegistryController implements Refreshable {
    private final MagicRegistryPanel view;
    private final MagicRegistryRuntime runtime;
    private final MagicTypeTable table;

    private Runnable globalRefresh;

    public MagicRegistryController(MagicRegistryPanel magicRegistryPanel, MagicRegistryRuntime runtime, MagicTypeTable table) {
        this.view = magicRegistryPanel;
        this.table = table;
        this.runtime = runtime;

        view.addSubmitListener(e -> handleMagicTypeSubmit());
    }

    @Override
    public void refresh() {
        view.updateMagicClassCombo(runtime.magicClasses());
    }

    @Override
    public void setGlobalRefresh(Runnable globalRefresh) {
        this.globalRefresh = globalRefresh;
    }

    private void handleMagicTypeSubmit(){
        MagicClass magicClass = (MagicClass) view.getMagicClassCombo().getSelectedItem();

        if(magicClass == null){
            JOptionPane.showMessageDialog(view, "Please select a magic class.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int classID = magicClass.id();
        String name = Text.toTitleCase(view.getMagicTypeInput().trim());
        int level;
        String description = view.getDescriptionInput().trim();

        try{
            level = Integer.parseInt(view.getMagicLevelInput().trim());

            if(level < 1 || level > 4){
                throw new IllegalArgumentException("Magic level must be between 1 and 4.");
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(view, "Please enter a valid magic level (1 to 4)", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        table.write(new MagicType(classID, name, level, description));
        runtime.setMagicTypes(table.fetch());
        globalRefresh.run();
    }
}

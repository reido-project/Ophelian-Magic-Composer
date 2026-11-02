package app.controllers;

import app.models.database.tables.SpellTable;
import app.models.enums.Target;
import app.models.runtime.MagicRegistryRuntime;
import app.models.runtime.SpellRegistryRuntime;
import app.models.types.MagicType;
import app.models.types.Spell;
import app.utils.Text;
import app.views.panels.SpellRegistryPanel;

import javax.swing.*;

public class SpellRegistryController {
    private final SpellRegistryPanel view;
    private final SpellRegistryRuntime runtime;
    private final SpellTable table;

    public SpellRegistryController(SpellRegistryPanel view, SpellRegistryRuntime runtime, SpellTable table, MagicRegistryRuntime magicRegistryRuntime) {
        this.view = view;
        this.runtime = runtime;
        this.table = table;

        JComboBox<MagicType> combo = view.getMagicTypeCombo();

        for(MagicType type : magicRegistryRuntime.magicTypes()){
            combo.addItem(type);
        }

        view.addSubmitListener(e -> handleSpellSubmit());
    }

    private void handleSpellSubmit(){
        MagicType type = (MagicType) view.getMagicTypeCombo().getSelectedItem();

        if(type == null){
            JOptionPane.showMessageDialog(view, "Please select a Magic Type", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int typeID = type.id();
        String name = Text.toTitleCase(view.getSpellInput().trim());
        Target target = view.getTargetComboValue();
        boolean contact = view.isContactSelected();
        boolean shortRange = view.isShortRangeSelected();
        boolean longRange = view.isLongRangeSelected();
        boolean aoe = view.isAreaOfEffectSelected();
        int proficiency;
        long cost;
        String mechanism = view.getMechanismInput().trim();
        String reference = view.getReferenceInput().trim();

        try {
            proficiency = Integer.parseInt(view.getProficiencyInput().trim());

            if(proficiency <= 0 || proficiency > 3){
                throw new IllegalArgumentException("Proficiency level must be between 1 and 3.");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(view, "Please enter a valid proficiency level (1 to 3)", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            cost = Integer.parseInt(view.getProficiencyInput().trim());

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(view, "Please enter a valid cost using numeric value", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        table.write(new Spell(typeID, name, target, contact, shortRange,  longRange, aoe, proficiency, cost, mechanism, reference));
        runtime.set(table.fetch());
    }
}

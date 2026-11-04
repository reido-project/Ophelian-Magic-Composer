package app.views.panels;

import app.models.types.MagicType;
import app.models.types.Spell;

import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

public class CharacterSpellPanel extends JPanel {
    private final JLabel infoName;
    private final JLabel infoRole;
    private final JLabel infoAge;

    private final JComboBox<MagicType> magicTypeSelectCombo;
    private final JButton btnCharacterSpellSubmit;

    private final JPanel spellCheckboxPanel;
    private final List<JCheckBox> spellCheckboxes = new ArrayList<>();

    public CharacterSpellPanel() {
        setLayout(null);
        setBackground(new Color(36, 31, 49));

        JLabel lblCharacterSpellRegistry = new JLabel("Character Spell Registry");
        lblCharacterSpellRegistry.setForeground(Color.WHITE);
        lblCharacterSpellRegistry.setFont(new Font("SansSerif", Font.BOLD, 16));
        lblCharacterSpellRegistry.setBounds(84, 12, 191, 23);
        add(lblCharacterSpellRegistry);

        JLabel lblInfoName = new JLabel("Name:");
        lblInfoName.setForeground(Color.WHITE);
        lblInfoName.setFont(new Font("SansSerif", Font.BOLD, 13));
        lblInfoName.setBounds(12, 57, 54, 17);
        add(lblInfoName);

        infoName = new JLabel("");
        infoName.setForeground(Color.WHITE);
        infoName.setFont(new Font("SansSerif", Font.PLAIN, 12));
        infoName.setBounds(66, 57, 250, 17);
        add(infoName);

        JLabel lblInfoRole = new JLabel("Role:");
        lblInfoRole.setForeground(Color.WHITE);
        lblInfoRole.setFont(new Font("SansSerif", Font.BOLD, 13));
        lblInfoRole.setBounds(12, 78, 54, 17);
        add(lblInfoRole);

        infoRole = new JLabel("");
        infoRole.setForeground(Color.WHITE);
        infoRole.setFont(new Font("SansSerif", Font.PLAIN, 12));
        infoRole.setBounds(66, 78, 250, 17);
        add(infoRole);

        JLabel lblInfoAge = new JLabel("Age:");
        lblInfoAge.setForeground(Color.WHITE);
        lblInfoAge.setFont(new Font("SansSerif", Font.BOLD, 13));
        lblInfoAge.setBounds(12, 100, 54, 17);
        add(lblInfoAge);

        infoAge = new JLabel("");
        infoAge.setForeground(Color.WHITE);
        infoAge.setFont(new Font("SansSerif", Font.PLAIN, 12));
        infoAge.setBounds(66, 100, 250, 17);
        add(infoAge);

        JLabel lblSelectMagicType = new JLabel("Select Character's Magic Type");
        lblSelectMagicType.setForeground(Color.WHITE);
        lblSelectMagicType.setFont(new Font("SansSerif", Font.BOLD, 13));
        lblSelectMagicType.setBounds(84, 136, 199, 17);
        add(lblSelectMagicType);

        magicTypeSelectCombo = new JComboBox<>();
        magicTypeSelectCombo.setBounds(74, 165, 217, 26);
        add(magicTypeSelectCombo);

        // Spell Checkbox
        spellCheckboxPanel = new JPanel();
        spellCheckboxPanel.setLayout(new BoxLayout(spellCheckboxPanel, BoxLayout.Y_AXIS));
        spellCheckboxPanel.setBackground(new Color(50, 43, 67));

        JScrollPane characterSpellScrollPane = new JScrollPane(spellCheckboxPanel);
        characterSpellScrollPane.setBounds(12, 215, 341, 245);
        characterSpellScrollPane.getVerticalScrollBar().setUnitIncrement(16);
        characterSpellScrollPane.setBorder(BorderFactory.createEmptyBorder());
        add(characterSpellScrollPane);

        btnCharacterSpellSubmit = new JButton("Submit");
        btnCharacterSpellSubmit.setBounds(12, 482, 340, 27);
        add(btnCharacterSpellSubmit);
    }

    // Getters
    public JComboBox<MagicType> getMagicTypeSelectCombo() { return magicTypeSelectCombo; }
    public MagicType getMagicTypeSelectComboValue() { return (MagicType) magicTypeSelectCombo.getSelectedItem(); }

    public List<Spell> getSelectedSpells() {
        List<Spell> selectedSpells = new ArrayList<>();

        for (JCheckBox checkbox : spellCheckboxes) {
            if (checkbox.isSelected()) {
                selectedSpells.add((Spell) checkbox.getClientProperty("spell"));
            }
        }

        return selectedSpells;
    }

    // Setters
    public void updateMagicTypeCombo(List<MagicType> magicTypes) {
        magicTypeSelectCombo.setModel(new DefaultComboBoxModel<>(magicTypes.toArray(new MagicType[0])));
    }

    public void updateSpells(List<Spell> spells) {
        spellCheckboxPanel.removeAll();
        spellCheckboxes.clear();

        for (Spell spell : spells) {
            JCheckBox checkbox = new JCheckBox(spell.toString());
            checkbox.putClientProperty("spell", spell);

            checkbox.setForeground(Color.WHITE);
            checkbox.setBackground(new Color(50, 43, 67));
            checkbox.setFont(new Font("SansSerif", Font.PLAIN, 14));
            checkbox.setFocusPainted(false);
            checkbox.setOpaque(true);
            checkbox.setAlignmentX(Component.LEFT_ALIGNMENT);

            spellCheckboxes.add(checkbox);
            spellCheckboxPanel.add(checkbox);
        }

        spellCheckboxPanel.revalidate();
        spellCheckboxPanel.repaint();
    }

    public void updateSelectedSpells(List<Spell> spells) {
        for (JCheckBox checkbox : spellCheckboxes) {
            Spell spell = (Spell) checkbox.getClientProperty("spell");
            checkbox.setSelected(spells.contains(spell));
        }
    }

    public void updateInfoNameLabelText(String name) { infoName.setText(name); }
    public void updateInfoRoleLabelText(String role) { infoRole.setText(role); }
    public void updateInfoAgeLabelText(String age) { infoAge.setText(age); }

    public void addMagicTypeComboListener(ActionListener actionListener) { magicTypeSelectCombo.addActionListener(actionListener); }
    public void addSubmitListener(ActionListener listener) { btnCharacterSpellSubmit.addActionListener(listener); }
}
package app.views.panels;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.*;

import app.models.enums.Target;
import app.models.types.MagicType;
import app.utils.Decoration;

public class SpellRegistryPanel extends JPanel {
    private final JComboBox<MagicType> magicTypeCombo;
    private final JTextField spellInput;
    private final JComboBox<Target> targetCombo;
    private final JCheckBox chckbxContact;
    private final JCheckBox chckbxShortRange;
    private final JCheckBox chckbxLongRange;
    private final JCheckBox chckbxAreaOfEffect;
    private final JTextField proficiencyInput;
    private final JTextField costInput;
    private final JTextArea mechanismInput;
    private final JTextArea referenceInput;
    private final JButton btnSpellSubmit;

    public SpellRegistryPanel() {
        setBackground(new Color(36, 31, 49));
        setLayout(null);

        Color inputBgColor = new Color(48, 42, 65);
        Color inputFgColor = new Color(240, 240, 250);
        Color borderColor = new Color(80, 70, 115);
        Font labelFont = new Font("SansSerif", Font.BOLD, 13);
        Font inputFont = new Font("SansSerif", Font.PLAIN, 12);

        JLabel lblSpellRegistry = new JLabel("Spell Registry");
        lblSpellRegistry.setForeground(Color.WHITE);
        lblSpellRegistry.setFont(new Font("SansSerif", Font.BOLD, 16));
        lblSpellRegistry.setBounds(119, 12, 108, 23);
        add(lblSpellRegistry);

        // --- Magic Type ComboBox ---
        JLabel lblRegisteredMagicType = new JLabel("Magic Type");
        lblRegisteredMagicType.setForeground(Color.WHITE);
        lblRegisteredMagicType.setFont(labelFont);
        lblRegisteredMagicType.setBounds(12, 61, 91, 17);
        add(lblRegisteredMagicType);

        magicTypeCombo = new JComboBox<>();
        magicTypeCombo.setBounds(115, 56, 237, 26);
        Decoration.styleComboBox(magicTypeCombo, inputBgColor, inputFgColor, borderColor, inputFont);
        add(magicTypeCombo);

        // --- Spell Name Input ---
        JLabel lblSpellName = new JLabel("Spell Name");
        lblSpellName.setForeground(Color.WHITE);
        lblSpellName.setFont(labelFont);
        lblSpellName.setBounds(12, 95, 91, 17);
        add(lblSpellName);

        spellInput = new JTextField("Nyx Kalytra");
        spellInput.setColumns(10);
        spellInput.setBounds(115, 90, 237, 26);
        Decoration.styleTextField(spellInput, inputBgColor, inputFgColor, borderColor, inputFont);
        add(spellInput);

        // --- Target ComboBox ---
        JLabel lblTarget = new JLabel("Target");
        lblTarget.setForeground(Color.WHITE);
        lblTarget.setFont(labelFont);
        lblTarget.setBounds(12, 129, 91, 17);
        add(lblTarget);

        targetCombo = new JComboBox<>();
        targetCombo.setModel(new DefaultComboBoxModel<>(Target.values()));
        targetCombo.setBounds(115, 124, 237, 26);
        Decoration.styleComboBox(targetCombo, inputBgColor, inputFgColor, borderColor, inputFont);
        add(targetCombo);

        // --- Effect Range Checkboxes ---
        JLabel lblRange = new JLabel("Effect Range");
        lblRange.setForeground(Color.WHITE);
        lblRange.setFont(labelFont);
        lblRange.setBounds(12, 163, 91, 17);
        add(lblRange);

        chckbxContact = new JCheckBox("Contact");
        chckbxContact.setBounds(115, 158, 114, 25);
        Decoration.styleCheckBox(chckbxContact, inputFgColor, inputFont);
        add(chckbxContact);

        chckbxShortRange = new JCheckBox("Short Range");
        chckbxShortRange.setBounds(115, 187, 114, 25);
        Decoration.styleCheckBox(chckbxShortRange, inputFgColor, inputFont);
        add(chckbxShortRange);

        chckbxLongRange = new JCheckBox("Long Range");
        chckbxLongRange.setBounds(238, 158, 114, 25);
        Decoration.styleCheckBox(chckbxLongRange, inputFgColor, inputFont);
        add(chckbxLongRange);

        chckbxAreaOfEffect = new JCheckBox("Area of Effect");
        chckbxAreaOfEffect.setBounds(238, 187, 114, 25);
        Decoration.styleCheckBox(chckbxAreaOfEffect, inputFgColor, inputFont);
        add(chckbxAreaOfEffect);

        // --- Proficiency Input ---
        JLabel lblMagicProficiency = new JLabel("Proficiency");
        lblMagicProficiency.setForeground(Color.WHITE);
        lblMagicProficiency.setFont(labelFont);
        lblMagicProficiency.setBounds(12, 225, 91, 17);
        add(lblMagicProficiency);

        proficiencyInput = new JTextField("2");
        proficiencyInput.setHorizontalAlignment(SwingConstants.CENTER);
        proficiencyInput.setColumns(10);
        proficiencyInput.setBounds(115, 220, 50, 26);
        Decoration.styleTextField(proficiencyInput, inputBgColor, inputFgColor, borderColor, inputFont);
        add(proficiencyInput);

        // --- Cost Input ---
        JLabel lblCost = new JLabel("Cost");
        lblCost.setForeground(Color.WHITE);
        lblCost.setFont(labelFont);
        lblCost.setBounds(177, 225, 34, 17);
        add(lblCost);

        costInput = new JTextField("200000");
        costInput.setColumns(10);
        costInput.setBounds(213, 221, 139, 26);
        Decoration.styleTextField(costInput, inputBgColor, inputFgColor, borderColor, inputFont);
        add(costInput);

        // --- Mechanism TextArea ---
        JLabel lblMechanism = new JLabel("Mechanism");
        lblMechanism.setForeground(Color.WHITE);
        lblMechanism.setFont(labelFont);
        lblMechanism.setBounds(12, 259, 91, 17);
        add(lblMechanism);

        mechanismInput = new JTextArea();
        mechanismInput.setBounds(115, 254, 237, 60);
        mechanismInput.setBackground(inputBgColor);
        mechanismInput.setForeground(inputFgColor);
        mechanismInput.setCaretColor(Color.WHITE);
        mechanismInput.setFont(inputFont);
        mechanismInput.setBorder(BorderFactory.createLineBorder(borderColor, 1));
        mechanismInput.setLineWrap(true);
        mechanismInput.setWrapStyleWord(true);
        add(mechanismInput);

        // --- Reference TextArea ---
        JLabel lblReference = new JLabel("Reference");
        lblReference.setForeground(Color.WHITE);
        lblReference.setFont(labelFont);
        lblReference.setBounds(12, 326, 91, 17);
        add(lblReference);

        referenceInput = new JTextArea();
        referenceInput.setBounds(115, 321, 237, 60);
        referenceInput.setBackground(inputBgColor);
        referenceInput.setForeground(inputFgColor);
        referenceInput.setCaretColor(Color.WHITE);
        referenceInput.setFont(inputFont);
        referenceInput.setBorder(BorderFactory.createLineBorder(borderColor, 1));
        referenceInput.setLineWrap(true);
        referenceInput.setWrapStyleWord(true);
        add(referenceInput);

        // --- Submit Button ---
        btnSpellSubmit = new JButton("Submit");
        btnSpellSubmit.setBounds(12, 393, 340, 27);

        Color btnBg = new Color(55, 45, 85);
        Color btnHover = new Color(80, 65, 125);
        Color btnFg = new Color(230, 230, 250);

        btnSpellSubmit.setBackground(btnBg);
        btnSpellSubmit.setForeground(btnFg);
        btnSpellSubmit.setFont(new Font("SansSerif", Font.BOLD, 12));
        btnSpellSubmit.setFocusPainted(false);
        btnSpellSubmit.setBorder(BorderFactory.createLineBorder(borderColor, 1));
        btnSpellSubmit.setCursor(new Cursor(Cursor.HAND_CURSOR));

        btnSpellSubmit.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                btnSpellSubmit.setBackground(btnHover);
            }
            public void mouseExited(MouseEvent evt) {
                btnSpellSubmit.setBackground(btnBg);
            }
        });

        add(btnSpellSubmit);
    }

    // Getters
    public JComboBox<MagicType> getMagicTypeCombo() { return magicTypeCombo; }
    public String getSpellInput() { return spellInput.getText(); }
    public Target getTargetComboValue() { return (Target) targetCombo.getSelectedItem(); }
    public boolean isContactSelected() { return chckbxContact.isSelected(); }
    public boolean isShortRangeSelected() { return chckbxShortRange.isSelected(); }
    public boolean isLongRangeSelected() { return chckbxLongRange.isSelected(); }
    public boolean isAreaOfEffectSelected() { return chckbxAreaOfEffect.isSelected(); }
    public String getProficiencyInput() { return proficiencyInput.getText(); }
    public String getCostInput() { return costInput.getText(); }
    public String getMechanismInput() { return mechanismInput.getText(); }
    public String getReferenceInput() { return referenceInput.getText(); }

    // Setters
    public void updateMagicTypes(List<MagicType> magicTypes) {
        magicTypeCombo.setModel(new DefaultComboBoxModel<>(magicTypes.toArray(new MagicType[0])));
    }

    public void addSubmitListener(ActionListener listener) { btnSpellSubmit.addActionListener(listener); }
}
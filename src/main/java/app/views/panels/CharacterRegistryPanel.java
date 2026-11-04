package app.views.panels;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.*;

import app.models.enums.Role;
import app.models.types.MagicType;
import app.utils.Decoration;

public class CharacterRegistryPanel extends JPanel {
    private final JTextField characterNameInput;
    private final JComboBox<Role> characterRoleCombo;
    private final JTextField characterAgeInput;
    private final JComboBox<MagicType> primaryMagicTypeCombo;
    private final JTextField primaryProficiencyInput;
    private final JComboBox<MagicType> secondaryMagicTypeCombo;
    private final JTextField secondaryProficiencyInput;
    private final JComboBox<MagicType> tertiaryMagicTypeCombo;
    private final JTextField tertiaryProficiencyInput;
    private final JTextArea descriptionInput;
    private final JButton btnCharacterSubmit;

    public CharacterRegistryPanel() {
        setBackground(new Color(36, 31, 49));
        setLayout(null);

        // Colors
        Color inputBgColor = new Color(48, 42, 65);
        Color inputFgColor = new Color(240, 240, 250);
        Color borderColor = new Color(80, 70, 115);
        Font labelFont = new Font("SansSerif", Font.BOLD, 13);
        Font inputFont = new Font("SansSerif", Font.PLAIN, 12);

        // Panel
        JLabel lblCharacterRegistry = new JLabel("Character Registry");
        lblCharacterRegistry.setForeground(Color.WHITE);
        lblCharacterRegistry.setFont(new Font("SansSerif", Font.BOLD, 16));
        lblCharacterRegistry.setBounds(110, 12, 155, 23);
        add(lblCharacterRegistry);

        // --- Character Name ---
        JLabel characterName = new JLabel("Character Name");
        characterName.setForeground(Color.WHITE);
        characterName.setFont(labelFont);
        characterName.setBounds(12, 58, 109, 17);
        add(characterName);

        characterNameInput = new JTextField("");
        characterNameInput.setColumns(10);
        characterNameInput.setBounds(135, 53, 217, 26);
        Decoration.styleTextField(characterNameInput, inputBgColor, inputFgColor, borderColor, inputFont);
        add(characterNameInput);

        // --- Character Role ---
        JLabel lblCharacterRole = new JLabel("Character Role");
        lblCharacterRole.setForeground(Color.WHITE);
        lblCharacterRole.setFont(labelFont);
        lblCharacterRole.setBounds(12, 92, 109, 17);
        add(lblCharacterRole);

        characterRoleCombo = new JComboBox<>();
        characterRoleCombo.setModel(new DefaultComboBoxModel<>(Role.values()));
        characterRoleCombo.setBounds(135, 87, 217, 26);
        Decoration.styleComboBox(characterRoleCombo, inputBgColor, inputFgColor, borderColor, inputFont);
        add(characterRoleCombo);

        // --- Character Age ---
        JLabel lblCharacterAge = new JLabel("Character Age");
        lblCharacterAge.setForeground(Color.WHITE);
        lblCharacterAge.setFont(labelFont);
        lblCharacterAge.setBounds(12, 129, 109, 17);
        add(lblCharacterAge);

        characterAgeInput = new JTextField("");
        characterAgeInput.setHorizontalAlignment(SwingConstants.CENTER);
        characterAgeInput.setColumns(10);
        characterAgeInput.setBounds(135, 125, 50, 26);
        Decoration.styleTextField(characterAgeInput, inputBgColor, inputFgColor, borderColor, inputFont);
        add(characterAgeInput);

        // --- Labels Magic Type & Proficiency ---
        JLabel lblCharacterMagicType = new JLabel("Character's Magic Type");
        lblCharacterMagicType.setForeground(Color.WHITE);
        lblCharacterMagicType.setFont(labelFont);
        lblCharacterMagicType.setBounds(42, 163, 155, 17);
        add(lblCharacterMagicType);

        JLabel lblCharacterProficiency = new JLabel("Proficiency");
        lblCharacterProficiency.setForeground(Color.WHITE);
        lblCharacterProficiency.setFont(labelFont);
        lblCharacterProficiency.setBounds(280, 163, 73, 17);
        add(lblCharacterProficiency);

        // --- Primary Magic Type ---
        primaryMagicTypeCombo = new JComboBox<>();
        primaryMagicTypeCombo.setBounds(12, 192, 217, 26);
        Decoration.styleComboBox(primaryMagicTypeCombo, inputBgColor, inputFgColor, borderColor, inputFont);
        add(primaryMagicTypeCombo);

        primaryProficiencyInput = new JTextField("");
        primaryProficiencyInput.setHorizontalAlignment(SwingConstants.CENTER);
        primaryProficiencyInput.setColumns(10);
        primaryProficiencyInput.setBounds(292, 192, 50, 26);
        Decoration.styleTextField(primaryProficiencyInput, inputBgColor, inputFgColor, borderColor, inputFont);
        add(primaryProficiencyInput);

        // --- Secondary Magic Type ---
        secondaryMagicTypeCombo = new JComboBox<>();
        secondaryMagicTypeCombo.setBounds(12, 224, 217, 26);
        Decoration.styleComboBox(secondaryMagicTypeCombo, inputBgColor, inputFgColor, borderColor, inputFont);
        add(secondaryMagicTypeCombo);

        secondaryProficiencyInput = new JTextField("");
        secondaryProficiencyInput.setHorizontalAlignment(SwingConstants.CENTER);
        secondaryProficiencyInput.setColumns(10);
        secondaryProficiencyInput.setBounds(292, 224, 50, 26);
        Decoration.styleTextField(secondaryProficiencyInput, inputBgColor, inputFgColor, borderColor, inputFont);
        add(secondaryProficiencyInput);

        // --- Tertiary Magic Type ---
        tertiaryMagicTypeCombo = new JComboBox<>();
        tertiaryMagicTypeCombo.setBounds(12, 255, 217, 26);
        Decoration.styleComboBox(tertiaryMagicTypeCombo, inputBgColor, inputFgColor, borderColor, inputFont);
        add(tertiaryMagicTypeCombo);

        tertiaryProficiencyInput = new JTextField("");
        tertiaryProficiencyInput.setHorizontalAlignment(SwingConstants.CENTER);
        tertiaryProficiencyInput.setColumns(10);
        tertiaryProficiencyInput.setBounds(292, 255, 50, 26);
        Decoration.styleTextField(tertiaryProficiencyInput, inputBgColor, inputFgColor, borderColor, inputFont);
        add(tertiaryProficiencyInput);

        // --- Description ---
        JLabel lblCDescription = new JLabel("Description");
        lblCDescription.setForeground(Color.WHITE);
        lblCDescription.setFont(labelFont);
        lblCDescription.setBounds(12, 298, 91, 17);
        add(lblCDescription);

        descriptionInput = new JTextArea();
        descriptionInput.setBounds(115, 293, 237, 60);
        descriptionInput.setBackground(inputBgColor);
        descriptionInput.setForeground(inputFgColor);
        descriptionInput.setCaretColor(Color.WHITE);
        descriptionInput.setFont(inputFont);
        descriptionInput.setBorder(BorderFactory.createLineBorder(borderColor, 1));
        descriptionInput.setLineWrap(true);
        descriptionInput.setWrapStyleWord(true);
        add(descriptionInput);

        // --- Submit Button ---
        btnCharacterSubmit = new JButton("Submit");
        btnCharacterSubmit.setBounds(12, 365, 340, 27);

        Color btnBg = new Color(55, 45, 85);
        Color btnHover = new Color(80, 65, 125);
        Color btnFg = new Color(230, 230, 250);

        btnCharacterSubmit.setBackground(btnBg);
        btnCharacterSubmit.setForeground(btnFg);
        btnCharacterSubmit.setFont(new Font("SansSerif", Font.BOLD, 12));
        btnCharacterSubmit.setFocusPainted(false);
        btnCharacterSubmit.setBorder(BorderFactory.createLineBorder(borderColor, 1));
        btnCharacterSubmit.setCursor(new Cursor(Cursor.HAND_CURSOR));

        btnCharacterSubmit.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                btnCharacterSubmit.setBackground(btnHover);
            }
            public void mouseExited(MouseEvent evt) {
                btnCharacterSubmit.setBackground(btnBg);
            }
        });

        add(btnCharacterSubmit);
    }

    // Getters
    public String getNameInputValue() { return characterNameInput.getText(); }
    public Role getRoleValue() { return (Role) characterRoleCombo.getSelectedItem(); }
    public String getAgeInputValue() { return characterAgeInput.getText(); }
    public MagicType getPrimaryMagicType() { return (MagicType) primaryMagicTypeCombo.getSelectedItem(); }
    public String getPrimaryProficiencyInputValue() { return primaryProficiencyInput.getText(); }
    public MagicType getSecondaryMagicType() { return (MagicType) secondaryMagicTypeCombo.getSelectedItem(); }
    public String getSecondaryProficiencyInputValue() { return secondaryProficiencyInput.getText(); }
    public MagicType getTertiaryMagicType() { return (MagicType) tertiaryMagicTypeCombo.getSelectedItem(); }
    public String getTertiaryProficiencyInputValue() { return tertiaryProficiencyInput.getText(); }
    public String getDescriptionInputValue() { return descriptionInput.getText(); }

    // Setters
    public void updateMagicTypeCombo(List<MagicType> magicTypes) {
        primaryMagicTypeCombo.setModel(new DefaultComboBoxModel<>(magicTypes.toArray(new MagicType[0])));
        secondaryMagicTypeCombo.setModel(new DefaultComboBoxModel<>(magicTypes.toArray(new MagicType[0])));
        tertiaryMagicTypeCombo.setModel(new DefaultComboBoxModel<>(magicTypes.toArray(new MagicType[0])));
    }

    public void updateCharacterNameInputValue(String name) { characterNameInput.setText(name); }
    public void updateCharacterAgeInputValue(String age) { characterAgeInput.setText(age); }
    public void updateCharacterRoleSelection(Role role) { characterRoleCombo.setSelectedItem(role); }
    public void updatePrimaryMagicTypeSelection(MagicType magicType) { primaryMagicTypeCombo.setSelectedItem(magicType); }
    public void updatePrimaryProficiencyInputValue(String proficiency) { primaryProficiencyInput.setText(proficiency); }
    public void updateSecondaryMagicTypeSelection(MagicType magicType) { secondaryMagicTypeCombo.setSelectedItem(magicType); }
    public void updateSecondaryProficiencyInputValue(String proficiency) { secondaryProficiencyInput.setText(proficiency); }
    public void updateTertiaryMagicTypeSelection(MagicType magicType) { tertiaryMagicTypeCombo.setSelectedItem(magicType); }
    public void updateTertiaryProficiencyInputValue(String proficiency) { tertiaryProficiencyInput.setText(proficiency); }
    public void updateDescriptionInputValue(String description) { descriptionInput.setText(description); }

    public void addSubmitListener(ActionListener listener) { btnCharacterSubmit.addActionListener(listener); }
}
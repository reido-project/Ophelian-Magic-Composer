package app.views.panels;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import app.models.enums.Role;
import app.models.types.MagicType;

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

        JLabel lblCharacterRegistry = new JLabel("Character Registry");
        lblCharacterRegistry.setForeground(Color.WHITE);
        lblCharacterRegistry.setFont(new Font("SansSerif", Font.BOLD, 16));
        lblCharacterRegistry.setBounds(110, 12, 155, 23);
        add(lblCharacterRegistry);

        JLabel characterName = new JLabel("Character Name");
        characterName.setForeground(Color.WHITE);
        characterName.setFont(new Font("SansSerif", Font.BOLD, 13));
        characterName.setBounds(12, 58, 109, 17);
        add(characterName);

        characterNameInput = new JTextField("Apocryptia von Ophelius");
        characterNameInput.setColumns(10);
        characterNameInput.setBounds(135, 53, 217, 26);
        add(characterNameInput);

        JLabel lblCharacterRole = new JLabel("Character Role");
        lblCharacterRole.setForeground(Color.WHITE);
        lblCharacterRole.setFont(new Font("SansSerif", Font.BOLD, 13));
        lblCharacterRole.setBounds(12, 92, 109, 17);
        add(lblCharacterRole);

        characterRoleCombo = new JComboBox<>();
        characterRoleCombo.setModel(new DefaultComboBoxModel<>(Role.values()));
        characterRoleCombo.setBounds(135, 87, 217, 26);
        add(characterRoleCombo);

        JLabel lblCharacterAge = new JLabel("Character Age");
        lblCharacterAge.setForeground(Color.WHITE);
        lblCharacterAge.setFont(new Font("SansSerif", Font.BOLD, 13));
        lblCharacterAge.setBounds(12, 129, 109, 17);
        add(lblCharacterAge);

        characterAgeInput = new JTextField("53");
        characterAgeInput.setHorizontalAlignment(SwingConstants.CENTER);
        characterAgeInput.setColumns(10);
        characterAgeInput.setBounds(135, 125, 50, 26);
        add(characterAgeInput);

        JLabel lblCharacterMagicType = new JLabel("Character's Magic Type");
        lblCharacterMagicType.setForeground(Color.WHITE);
        lblCharacterMagicType.setFont(new Font("SansSerif", Font.BOLD, 13));
        lblCharacterMagicType.setBounds(42, 163, 155, 17);
        add(lblCharacterMagicType);

        JLabel lblCharacterProficiency = new JLabel("Proficiency");
        lblCharacterProficiency.setForeground(Color.WHITE);
        lblCharacterProficiency.setFont(new Font("SansSerif", Font.BOLD, 13));
        lblCharacterProficiency.setBounds(280, 163, 73, 17);
        add(lblCharacterProficiency);

        primaryMagicTypeCombo = new JComboBox<>();
        primaryMagicTypeCombo.setBounds(12, 192, 217, 26);
        add(primaryMagicTypeCombo);

        primaryProficiencyInput = new JTextField("3");
        primaryProficiencyInput.setHorizontalAlignment(SwingConstants.CENTER);
        primaryProficiencyInput.setColumns(10);
        primaryProficiencyInput.setBounds(292, 192, 50, 26);
        add(primaryProficiencyInput);

        secondaryMagicTypeCombo = new JComboBox<>();
        secondaryMagicTypeCombo.setBounds(12, 224, 217, 26);
        add(secondaryMagicTypeCombo);

        secondaryProficiencyInput = new JTextField("2");
        secondaryProficiencyInput.setHorizontalAlignment(SwingConstants.CENTER);
        secondaryProficiencyInput.setColumns(10);
        secondaryProficiencyInput.setBounds(292, 224, 50, 26);
        add(secondaryProficiencyInput);

        tertiaryMagicTypeCombo = new JComboBox<>();
        tertiaryMagicTypeCombo.setBounds(12, 255, 217, 26);
        add(tertiaryMagicTypeCombo);

        tertiaryProficiencyInput = new JTextField("1");
        tertiaryProficiencyInput.setHorizontalAlignment(SwingConstants.CENTER);
        tertiaryProficiencyInput.setColumns(10);
        tertiaryProficiencyInput.setBounds(292, 255, 50, 26);
        add(tertiaryProficiencyInput);

        JLabel lblCDescription = new JLabel("Description");
        lblCDescription.setForeground(Color.WHITE);
        lblCDescription.setFont(new Font("SansSerif", Font.BOLD, 13));
        lblCDescription.setBounds(12, 298, 91, 17);
        add(lblCDescription);

        descriptionInput = new JTextArea();
        descriptionInput.setBounds(115, 293, 237, 60);
        add(descriptionInput);

        btnCharacterSubmit = new JButton("Submit");
        btnCharacterSubmit.setBounds(12, 365, 340, 27);
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
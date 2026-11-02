package app.views.panels;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import app.models.enums.Role;

public class CharacterRegistryPanel extends JPanel {
    private JTextField characterNameInput;
    private JComboBox<Role> characterRoleCombo;
    private JTextField characterAgeInput;
    private JComboBox<Object> primaryMagicTypeCombo;
    private JTextField primaryProficiencyInput;
    private JComboBox<Object> secondaryMagicTypeCombo;
    private JTextField secondaryProficiencyInput;
    private JComboBox<Object> tertiaryMagicTypeCombo;
    private JTextField tertiaryProficiencyInput;
    private JTextArea cDescriptionInput;
    private JButton btnCharacterSubmit;

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

        cDescriptionInput = new JTextArea();
        cDescriptionInput.setBounds(115, 293, 237, 60);
        add(cDescriptionInput);

        btnCharacterSubmit = new JButton("Submit");
        btnCharacterSubmit.setBounds(12, 365, 340, 27);
        add(btnCharacterSubmit);
    }

    // Getters & Listeners
    public String getCharacterNameInput() { return characterNameInput.getText(); }
    public Role getCharacterRoleValue() { return (Role) characterRoleCombo.getSelectedItem(); }
    public String getCharacterAgeInput() { return characterAgeInput.getText(); }
    public JComboBox<Object> getPrimaryMagicTypeCombo() { return primaryMagicTypeCombo; }
    public String getPrimaryProficiencyInput() { return primaryProficiencyInput.getText(); }
    public JComboBox<Object> getSecondaryMagicTypeCombo() { return secondaryMagicTypeCombo; }
    public String getSecondaryProficiencyInput() { return secondaryProficiencyInput.getText(); }
    public JComboBox<Object> getTertiaryMagicTypeCombo() { return tertiaryMagicTypeCombo; }
    public String getTertiaryProficiencyInput() { return tertiaryProficiencyInput.getText(); }
    public String getCDescriptionInput() { return cDescriptionInput.getText(); }
    public void addSubmitListener(ActionListener listener) { btnCharacterSubmit.addActionListener(listener); }
}
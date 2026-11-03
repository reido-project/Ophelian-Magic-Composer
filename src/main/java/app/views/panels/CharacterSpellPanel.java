package app.views.panels;

import app.models.types.CharacterMagicType;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class CharacterSpellPanel extends JPanel {
    private JLabel infoName;
    private JLabel infoRole;
    private JLabel infoAge;
    private JComboBox<Object> magicTypeSelectCombo;
    private JButton btnCharacterSpellSubmit;
    private JPanel characterSpellScrollViewport;

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

        infoName = new JLabel("New label");
        infoName.setForeground(Color.WHITE);
        infoName.setFont(new Font("SansSerif", Font.PLAIN, 12));
        infoName.setBounds(66, 57, 60, 17);
        add(infoName);

        JLabel lblInfoRole = new JLabel("Role:");
        lblInfoRole.setForeground(Color.WHITE);
        lblInfoRole.setFont(new Font("SansSerif", Font.BOLD, 13));
        lblInfoRole.setBounds(12, 78, 54, 17);
        add(lblInfoRole);

        infoRole = new JLabel("New label");
        infoRole.setForeground(Color.WHITE);
        infoRole.setFont(new Font("SansSerif", Font.PLAIN, 12));
        infoRole.setBounds(66, 78, 60, 17);
        add(infoRole);

        JLabel lblInfoAge = new JLabel("Age:");
        lblInfoAge.setForeground(Color.WHITE);
        lblInfoAge.setFont(new Font("SansSerif", Font.BOLD, 13));
        lblInfoAge.setBounds(12, 100, 54, 17);
        add(lblInfoAge);

        infoAge = new JLabel("New label");
        infoAge.setForeground(Color.WHITE);
        infoAge.setFont(new Font("SansSerif", Font.PLAIN, 12));
        infoAge.setBounds(66, 100, 60, 17);
        add(infoAge);

        JLabel lblSelectMagicType = new JLabel("Select Character's Magic Type");
        lblSelectMagicType.setForeground(Color.WHITE);
        lblSelectMagicType.setFont(new Font("SansSerif", Font.BOLD, 13));
        lblSelectMagicType.setBounds(84, 136, 199, 17);
        add(lblSelectMagicType);

        magicTypeSelectCombo = new JComboBox<>();
        magicTypeSelectCombo.setBounds(74, 165, 217, 26);
        add(magicTypeSelectCombo);

        JScrollPane characterSpellScrollPane = new JScrollPane();
        characterSpellScrollPane.setBounds(12, 215, 341, 245);
        add(characterSpellScrollPane);

        characterSpellScrollViewport = new JPanel();
        characterSpellScrollPane.setViewportView(characterSpellScrollViewport);

        btnCharacterSpellSubmit = new JButton("Submit");
        btnCharacterSpellSubmit.setBounds(12, 482, 340, 27);
        add(btnCharacterSpellSubmit);
    }

    // Getters & Setters
    public JComboBox<Object> getMagicTypeSelectCombo() { return magicTypeSelectCombo; }
    public JLabel getInfoNameLabel() { return infoName; }
    public JLabel getInfoRoleLabel() { return infoRole; }
    public JLabel getInfoAgeLabel() { return infoAge; }
    public void addSubmitListener(ActionListener listener) { btnCharacterSpellSubmit.addActionListener(listener); }
}
package app.views.panels;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import app.models.enums.Target;
import app.models.types.MagicType;

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

        JLabel lblSpellRegistry = new JLabel("Spell Registry");
        lblSpellRegistry.setForeground(Color.WHITE);
        lblSpellRegistry.setFont(new Font("SansSerif", Font.BOLD, 16));
        lblSpellRegistry.setBounds(119, 12, 108, 23);
        add(lblSpellRegistry);

        JLabel lblRegisteredMagicType = new JLabel("Magic Type");
        lblRegisteredMagicType.setForeground(Color.WHITE);
        lblRegisteredMagicType.setFont(new Font("SansSerif", Font.BOLD, 13));
        lblRegisteredMagicType.setBounds(12, 61, 91, 17);
        add(lblRegisteredMagicType);

        magicTypeCombo = new JComboBox<>();
        magicTypeCombo.setBounds(115, 56, 237, 26);
        add(magicTypeCombo);

        JLabel lblSpellName = new JLabel("Spell Name");
        lblSpellName.setForeground(Color.WHITE);
        lblSpellName.setFont(new Font("SansSerif", Font.BOLD, 13));
        lblSpellName.setBounds(12, 95, 91, 17);
        add(lblSpellName);

        spellInput = new JTextField("Nyx Kalytra");
        spellInput.setColumns(10);
        spellInput.setBounds(115, 90, 237, 26);
        add(spellInput);

        JLabel lblTarget = new JLabel("Target");
        lblTarget.setForeground(Color.WHITE);
        lblTarget.setFont(new Font("SansSerif", Font.BOLD, 13));
        lblTarget.setBounds(12, 129, 91, 17);
        add(lblTarget);

        targetCombo = new JComboBox<>();
        targetCombo.setModel(new DefaultComboBoxModel<>(Target.values()));
        targetCombo.setBounds(115, 124, 237, 26);
        add(targetCombo);

        JLabel lblRange = new JLabel("Effect Range");
        lblRange.setForeground(Color.WHITE);
        lblRange.setFont(new Font("SansSerif", Font.BOLD, 13));
        lblRange.setBounds(12, 163, 91, 17);
        add(lblRange);

        chckbxContact = new JCheckBox("Contact");
        chckbxContact.setBounds(115, 158, 114, 25);
        add(chckbxContact);

        chckbxShortRange = new JCheckBox("Short Range");
        chckbxShortRange.setBounds(115, 187, 114, 25);
        add(chckbxShortRange);

        chckbxLongRange = new JCheckBox("Long Range");
        chckbxLongRange.setBounds(238, 158, 114, 25);
        add(chckbxLongRange);

        chckbxAreaOfEffect = new JCheckBox("Area of Effect");
        chckbxAreaOfEffect.setBounds(238, 187, 114, 25);
        add(chckbxAreaOfEffect);

        JLabel lblMagicProficiency = new JLabel("Proficiency");
        lblMagicProficiency.setForeground(Color.WHITE);
        lblMagicProficiency.setFont(new Font("SansSerif", Font.BOLD, 13));
        lblMagicProficiency.setBounds(12, 225, 91, 17);
        add(lblMagicProficiency);

        proficiencyInput = new JTextField("2");
        proficiencyInput.setHorizontalAlignment(SwingConstants.CENTER);
        proficiencyInput.setColumns(10);
        proficiencyInput.setBounds(115, 220, 50, 26);
        add(proficiencyInput);

        JLabel lblCost = new JLabel("Cost");
        lblCost.setForeground(Color.WHITE);
        lblCost.setFont(new Font("SansSerif", Font.BOLD, 13));
        lblCost.setBounds(177, 225, 34, 17);
        add(lblCost);

        costInput = new JTextField("200000");
        costInput.setColumns(10);
        costInput.setBounds(213, 221, 139, 26);
        add(costInput);

        JLabel lblMechanism = new JLabel("Mechanism");
        lblMechanism.setForeground(Color.WHITE);
        lblMechanism.setFont(new Font("SansSerif", Font.BOLD, 13));
        lblMechanism.setBounds(12, 259, 91, 17);
        add(lblMechanism);

        mechanismInput = new JTextArea();
        mechanismInput.setBounds(115, 254, 237, 60);
        add(mechanismInput);

        JLabel lblReference = new JLabel("Reference");
        lblReference.setForeground(Color.WHITE);
        lblReference.setFont(new Font("SansSerif", Font.BOLD, 13));
        lblReference.setBounds(12, 326, 91, 17);
        add(lblReference);

        referenceInput = new JTextArea();
        referenceInput.setBounds(115, 321, 237, 60);
        add(referenceInput);

        btnSpellSubmit = new JButton("Submit");
        btnSpellSubmit.setBounds(12, 393, 340, 27);
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
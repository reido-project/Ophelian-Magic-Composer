package app.views.panels;

import app.models.types.MagicClass;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.*;

public class MagicRegistryPanel extends JPanel {
    private final JComboBox<MagicClass> magicClassCombo;
    private final JTextField magicTypeInput;
    private final JTextField magicLevelInput;
    private final JTextArea descriptionInput;
    private final JButton btnMagicSubmit;

    public MagicRegistryPanel() {
        setBackground(new Color(36, 31, 49));
        setLayout(null);

        JLabel lblMagicTypeRegistry = new JLabel("Magic Type Registry");
        lblMagicTypeRegistry.setForeground(Color.WHITE);
        lblMagicTypeRegistry.setFont(new Font("SansSerif", Font.BOLD, 16));
        lblMagicTypeRegistry.setBounds(104, 12, 159, 23);
        add(lblMagicTypeRegistry);

        JLabel lblClass = new JLabel("Magic Class");
        lblClass.setForeground(Color.WHITE);
        lblClass.setFont(new Font("SansSerif", Font.BOLD, 13));
        lblClass.setBounds(12, 63, 91, 17);
        add(lblClass);

        magicClassCombo = new JComboBox<>();
        magicClassCombo.setBounds(115, 58, 237, 26);
        add(magicClassCombo);

        JLabel lblMagicType = new JLabel("Magic Type");
        lblMagicType.setForeground(Color.WHITE);
        lblMagicType.setFont(new Font("SansSerif", Font.BOLD, 13));
        lblMagicType.setBounds(12, 95, 91, 17);
        add(lblMagicType);

        magicTypeInput = new JTextField("Darkness");
        magicTypeInput.setBounds(115, 90, 237, 26);
        magicTypeInput.setColumns(10);
        add(magicTypeInput);

        JLabel lblMagicLevel = new JLabel("Magic Level");
        lblMagicLevel.setForeground(Color.WHITE);
        lblMagicLevel.setFont(new Font("SansSerif", Font.BOLD, 13));
        lblMagicLevel.setBounds(12, 130, 91, 17);
        add(lblMagicLevel);

        magicLevelInput = new JTextField("2");
        magicLevelInput.setHorizontalAlignment(SwingConstants.CENTER);
        magicLevelInput.setBounds(115, 125, 50, 26);
        magicLevelInput.setColumns(10);
        add(magicLevelInput);

        JLabel lblDescription = new JLabel("Description");
        lblDescription.setForeground(Color.WHITE);
        lblDescription.setFont(new Font("SansSerif", Font.BOLD, 13));
        lblDescription.setBounds(12, 165, 91, 17);
        add(lblDescription);

        descriptionInput = new JTextArea();
        descriptionInput.setBounds(115, 160, 237, 60);
        add(descriptionInput);

        btnMagicSubmit = new JButton("Submit");
        btnMagicSubmit.setBounds(12, 236, 340, 27);
        add(btnMagicSubmit);
    }

    // Getters
    public JComboBox<MagicClass> getMagicClassCombo() { return magicClassCombo; }
    public String getMagicTypeInput() { return magicTypeInput.getText(); }
    public String getMagicLevelInput() { return magicLevelInput.getText(); }
    public String getDescriptionInput() { return descriptionInput.getText(); }

    // Setters
    public void updateMagicClassCombo(List<MagicClass> magicClasses) {
        magicClassCombo.setModel(new DefaultComboBoxModel<>(magicClasses.toArray(new MagicClass[0])));
    }

    public void addSubmitListener(ActionListener listener) { btnMagicSubmit.addActionListener(listener); }
}
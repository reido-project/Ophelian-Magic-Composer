package app.views.panels;

import app.models.types.MagicClass;
import app.utils.Decoration;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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

        Color inputBgColor = new Color(48, 42, 65);
        Color inputFgColor = new Color(240, 240, 250);
        Color borderColor = new Color(80, 70, 115);
        Font labelFont = new Font("SansSerif", Font.BOLD, 13);
        Font inputFont = new Font("SansSerif", Font.PLAIN, 12);

        JLabel lblMagicTypeRegistry = new JLabel("Magic Type Registry");
        lblMagicTypeRegistry.setForeground(Color.WHITE);
        lblMagicTypeRegistry.setFont(new Font("SansSerif", Font.BOLD, 16));
        lblMagicTypeRegistry.setBounds(104, 12, 159, 23);
        add(lblMagicTypeRegistry);

        // --- Magic Class ComboBox ---
        JLabel lblClass = new JLabel("Magic Class");
        lblClass.setForeground(Color.WHITE);
        lblClass.setFont(labelFont);
        lblClass.setBounds(12, 63, 91, 17);
        add(lblClass);

        magicClassCombo = new JComboBox<>();
        magicClassCombo.setBounds(115, 58, 237, 26);
        Decoration.styleComboBox(magicClassCombo, inputBgColor, inputFgColor, borderColor, inputFont);
        add(magicClassCombo);

        // --- Magic Type Input ---
        JLabel lblMagicType = new JLabel("Magic Type");
        lblMagicType.setForeground(Color.WHITE);
        lblMagicType.setFont(labelFont);
        lblMagicType.setBounds(12, 95, 91, 17);
        add(lblMagicType);

        magicTypeInput = new JTextField("Darkness");
        magicTypeInput.setBounds(115, 90, 237, 26);
        magicTypeInput.setColumns(10);
        Decoration.styleTextField(magicTypeInput, inputBgColor, inputFgColor, borderColor, inputFont);
        add(magicTypeInput);

        // --- Magic Level Input ---
        JLabel lblMagicLevel = new JLabel("Magic Level");
        lblMagicLevel.setForeground(Color.WHITE);
        lblMagicLevel.setFont(labelFont);
        lblMagicLevel.setBounds(12, 130, 91, 17);
        add(lblMagicLevel);

        magicLevelInput = new JTextField("2");
        magicLevelInput.setHorizontalAlignment(SwingConstants.CENTER);
        magicLevelInput.setBounds(115, 125, 50, 26);
        magicLevelInput.setColumns(10);
        Decoration.styleTextField(magicLevelInput, inputBgColor, inputFgColor, borderColor, inputFont);
        add(magicLevelInput);

        // --- Description TextArea ---
        JLabel lblDescription = new JLabel("Description");
        lblDescription.setForeground(Color.WHITE);
        lblDescription.setFont(labelFont);
        lblDescription.setBounds(12, 165, 91, 17);
        add(lblDescription);

        descriptionInput = new JTextArea();
        descriptionInput.setBounds(115, 160, 237, 60);
        descriptionInput.setBackground(inputBgColor);
        descriptionInput.setForeground(inputFgColor);
        descriptionInput.setCaretColor(Color.WHITE);
        descriptionInput.setFont(inputFont);
        descriptionInput.setBorder(BorderFactory.createLineBorder(borderColor, 1));
        descriptionInput.setLineWrap(true);
        descriptionInput.setWrapStyleWord(true);
        add(descriptionInput);

        // --- Submit Button ---
        btnMagicSubmit = new JButton("Submit");
        btnMagicSubmit.setBounds(12, 236, 340, 27);

        Color btnBg = new Color(55, 45, 85);
        Color btnHover = new Color(80, 65, 125);
        Color btnFg = new Color(230, 230, 250);

        btnMagicSubmit.setBackground(btnBg);
        btnMagicSubmit.setForeground(btnFg);
        btnMagicSubmit.setFont(new Font("SansSerif", Font.BOLD, 12));
        btnMagicSubmit.setFocusPainted(false);
        btnMagicSubmit.setBorder(BorderFactory.createLineBorder(borderColor, 1));
        btnMagicSubmit.setCursor(new Cursor(Cursor.HAND_CURSOR));

        btnMagicSubmit.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                btnMagicSubmit.setBackground(btnHover);
            }
            public void mouseExited(MouseEvent evt) {
                btnMagicSubmit.setBackground(btnBg);
            }
        });

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
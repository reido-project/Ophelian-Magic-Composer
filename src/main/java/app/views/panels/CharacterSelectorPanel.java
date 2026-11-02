package app.views.panels;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class CharacterSelectorPanel extends JPanel {
    private JScrollPane scrollPane;
    private JPanel panel;

    public CharacterSelectorPanel() {
        setLayout(null);
        setBackground(new Color(36, 31, 49));

        JLabel lblCharacterSelector = new JLabel("Character Selector");
        lblCharacterSelector.setForeground(Color.WHITE);
        lblCharacterSelector.setFont(new Font("SansSerif", Font.BOLD, 16));
        lblCharacterSelector.setBounds(106, 12, 159, 23);
        add(lblCharacterSelector);

        scrollPane = new JScrollPane();
        scrollPane.setBounds(12, 47, 341, 214);
        add(scrollPane);

        panel = new JPanel();
        scrollPane.setViewportView(panel);
    }

    public JPanel getScrollViewportPanel() { return panel; }
}
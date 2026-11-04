package app.views.panels;

import app.models.enums.Role;
import app.models.types.Character;
import app.views.components.DarkScrollBar;

import java.awt.*;
import java.util.List;
import javax.swing.*;

public class CharacterSelectorPanel extends JPanel {
    private final JList<Character> characterList;
    private final DefaultListModel<Character> listModel;

    public CharacterSelectorPanel() {
        setLayout(null);
        setBackground(new Color(36, 31, 49));

        Color inputBgColor = new Color(48, 42, 65);
        Color inputFgColor = new Color(240, 240, 250);
        Color borderColor = new Color(80, 70, 115);
        Color selectionColor = new Color(80, 65, 125);

        Color trackColor = new Color(36, 31, 49);
        Color thumbColor = new Color(80, 70, 115);

        JLabel lblCharacterSelector = new JLabel("Character Selector");
        lblCharacterSelector.setForeground(Color.WHITE);
        lblCharacterSelector.setFont(new Font("SansSerif", Font.BOLD, 16));
        lblCharacterSelector.setBounds(106, 12, 159, 23);
        add(lblCharacterSelector);

        listModel = new DefaultListModel<>();
        characterList = new JList<>(listModel);

        characterList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        characterList.setBackground(inputBgColor);
        characterList.setForeground(inputFgColor);
        characterList.setFont(new Font("SansSerif", Font.PLAIN, 14));
        characterList.setSelectionBackground(selectionColor);
        characterList.setSelectionForeground(Color.WHITE);
        characterList.setFixedCellHeight(24);

        JScrollPane scrollPane = new JScrollPane(characterList);
        scrollPane.setBounds(12, 47, 341, 214);
        scrollPane.setBorder(BorderFactory.createLineBorder(borderColor, 1));
        scrollPane.getVerticalScrollBar().setUI(new DarkScrollBar(trackColor, thumbColor, selectionColor));
        scrollPane.getHorizontalScrollBar().setUI(new DarkScrollBar(trackColor, thumbColor, selectionColor));
        scrollPane.getVerticalScrollBar().setPreferredSize(new Dimension(10, 0));
        scrollPane.getHorizontalScrollBar().setPreferredSize(new Dimension(0, 10));
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);
        scrollPane.getViewport().setBackground(inputBgColor);
        scrollPane.setBackground(inputBgColor);
        scrollPane.setCorner(JScrollPane.LOWER_RIGHT_CORNER, cornerFiller(trackColor));
        add(scrollPane);
    }

    private JComponent cornerFiller(Color color) {
        JPanel p = new JPanel();
        p.setBackground(color);
        return p;
    }

    public void updateCharacters(List<Character> characters) {
        listModel.clear();
        for (Character character : characters) {
            listModel.addElement(character);
        }
        listModel.addElement(new Character(-1, "New Character", Role.Unspecified, 0, ""));
    }

    public Character getSelectedCharacter() {
        return characterList.getSelectedValue();
    }

    public JList<Character> getCharacterList() {
        return characterList;
    }
}
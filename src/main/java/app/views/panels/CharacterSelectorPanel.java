package app.views.panels;

import app.models.enums.Role;
import app.models.types.Character;

import java.awt.Color;
import java.awt.Font;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.DefaultListModel;

public class CharacterSelectorPanel extends JPanel {
    private final JList<Character> characterList;
    private final DefaultListModel<Character> listModel;

    public CharacterSelectorPanel() {
        setLayout(null);
        setBackground(new Color(36, 31, 49));

        JLabel lblCharacterSelector = new JLabel("Character Selector");
        lblCharacterSelector.setForeground(Color.WHITE);
        lblCharacterSelector.setFont(new Font("SansSerif", Font.BOLD, 16));
        lblCharacterSelector.setBounds(106, 12, 159, 23);
        add(lblCharacterSelector);

        listModel = new DefaultListModel<>();
        characterList = new JList<>(listModel);

        characterList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        characterList.setBackground(new Color(50, 43, 67));
        characterList.setForeground(Color.WHITE);
        characterList.setFont(new Font("SansSerif", Font.PLAIN, 14));

        JScrollPane scrollPane = new JScrollPane(characterList);
        scrollPane.setBounds(12, 47, 341, 214);
        add(scrollPane);
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
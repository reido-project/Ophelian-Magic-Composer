package app.views;

import app.views.panels.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class ComposerFrame extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;

    // Referensi Panel-panel modular
    private MagicRegistryPanel magicRegistryPanel;
    private SpellRegistryPanel spellRegistryPanel;
    private CharacterRegistryPanel characterRegistryPanel;
    private CharacterSelectorPanel characterSelectorPanel;
    private CharacterSpellPanel characterSpellPanel;
    private ActionPanel mainActionPanel;

    public ComposerFrame(MagicRegistryPanel magicRegistryPanel,  SpellRegistryPanel spellRegistryPanel, CharacterRegistryPanel characterRegistryPanel, CharacterSelectorPanel characterSelectorPanel, CharacterSpellPanel characterSpellPanel, ActionPanel mainActionPanel) {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1140, 832);
        setResizable(false);
        setTitle("Ophelian Magic Composer");

        this.magicRegistryPanel = magicRegistryPanel;
        this.spellRegistryPanel = spellRegistryPanel;
        this.characterRegistryPanel = characterRegistryPanel;
        this.characterSelectorPanel = characterSelectorPanel;
        this.characterSpellPanel = characterSpellPanel;
        this.mainActionPanel = mainActionPanel;

        contentPane = new JPanel();
        contentPane.setBackground(new Color(18, 18, 18));
        contentPane.setBorder(new EmptyBorder(30, 30, 30, 30));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel title = new JLabel("Ophelian Magic Composer");
        title.setForeground(new Color(255, 255, 255));
        title.setFont(new Font("SansSerif", Font.BOLD, 20));
        title.setBounds(406, 12, 262, 28);
        contentPane.add(title);

        // Panel Initializations
        magicRegistryPanel.setBounds(12, 64, 365, 273);
        contentPane.add(magicRegistryPanel);

        spellRegistryPanel.setBounds(12, 357, 365, 427);
        contentPane.add(spellRegistryPanel);

        characterSpellPanel.setBounds(382, 64, 365, 521);
        contentPane.add(characterSpellPanel);

        characterSelectorPanel.setBounds(753, 64, 365, 273);
        contentPane.add(characterSelectorPanel);

        characterRegistryPanel.setBounds(753, 357, 365, 427);
        contentPane.add(characterRegistryPanel);

        mainActionPanel.setBounds(389, 610, 352, 174);
        contentPane.add(mainActionPanel);
    }

    // Getter
    public MagicRegistryPanel getMagicRegistryPanel() { return magicRegistryPanel; }
    public SpellRegistryPanel getSpellRegistryPanel() { return spellRegistryPanel; }
    public CharacterRegistryPanel getCharacterRegistryPanel() { return characterRegistryPanel; }
    public CharacterSelectorPanel getCharacterSelectorPanel() { return characterSelectorPanel; }
    public CharacterSpellPanel getCharacterSpellPanel() { return characterSpellPanel; }
    public ActionPanel getMainActionPanel() { return mainActionPanel; }
}

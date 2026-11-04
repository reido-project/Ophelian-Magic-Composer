package app.views;

import app.views.panels.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.io.Serial;

public class ComposerFrame extends JFrame {

    @Serial
    private static final long serialVersionUID = 1L;

    public ComposerFrame(MagicRegistryPanel magicRegistryPanel,  SpellRegistryPanel spellRegistryPanel, CharacterRegistryPanel characterRegistryPanel, CharacterSelectorPanel characterSelectorPanel, CharacterSpellPanel characterSpellPanel, ActionPanel mainActionPanel) {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1140, 832);
        setResizable(false);
        setTitle("Ophelian Magic Composer");
        setIconImage(Toolkit.getDefaultToolkit().getImage(ComposerFrame.class.getResource("/icon.png")));

        JPanel contentPane = new JPanel();
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
}

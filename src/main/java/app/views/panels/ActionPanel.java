package app.views.panels;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.Objects;
import javax.imageio.ImageIO;
import javax.swing.*;

public class ActionPanel extends JPanel {
    private final JButton exportBtn;
    private final JButton exitBtn;

    public ActionPanel() {
        setLayout(null);
        setOpaque(false);

        int panelWidth = 352;
        int watermarkHeight = 70;

        JLabel watermarkLabel = new JLabel();
        watermarkLabel.setBounds(0, 0, panelWidth, watermarkHeight);

        try {
            Image img = ImageIO.read(Objects.requireNonNull(getClass().getResource("/watermark.png")));
            Image scaledImg = img.getScaledInstance(panelWidth, watermarkHeight, Image.SCALE_SMOOTH);
            watermarkLabel.setIcon(new ImageIcon(scaledImg));
        } catch (IOException | IllegalArgumentException e) {
            watermarkLabel.setText("");
        }
        add(watermarkLabel);

        exportBtn = new JButton("RESET DATABASE");
        exportBtn.setBounds(0, 80, panelWidth, 40);
        exportBtn.setBackground(new Color(40, 35, 60));
        exportBtn.setForeground(new Color(220, 220, 250));
        exportBtn.setFont(new Font("Segoe UI", Font.BOLD, 12));
        exportBtn.setFocusPainted(false);
        exportBtn.setBorder(BorderFactory.createLineBorder(new Color(90, 80, 140), 1));
        exportBtn.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                exportBtn.setBackground(new Color(70, 60, 105));
            }
            public void mouseExited(MouseEvent evt) {
                exportBtn.setBackground(new Color(40, 35, 60));
            }
        });
        add(exportBtn);

        exitBtn = new JButton("EXIT");
        exitBtn.setBounds(0, 128, panelWidth, 40);
        exitBtn.setBackground(new Color(60, 35, 40));
        exitBtn.setForeground(new Color(250, 220, 220));
        exitBtn.setFont(new Font("Segoe UI", Font.BOLD, 12));
        exitBtn.setFocusPainted(false);
        exitBtn.setBorder(BorderFactory.createLineBorder(new Color(140, 80, 80), 1));
        exitBtn.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                exitBtn.setBackground(new Color(105, 50, 55));
            }
            public void mouseExited(MouseEvent evt) {
                exitBtn.setBackground(new Color(60, 35, 40));
            }
        });
        add(exitBtn);
    }

    // Listeners
    public void addResetListener(ActionListener listener) { exportBtn.addActionListener(listener); }
    public void addExitListener(ActionListener listener) { exitBtn.addActionListener(listener); }
}
package app.utils;

import javax.swing.*;
import javax.swing.plaf.basic.BasicArrowButton;
import javax.swing.plaf.basic.BasicComboBoxUI;
import java.awt.*;

public class Decoration {
    public static void styleComboBox(JComboBox<?> cb, Color bg, Color fg, Color border, Font font) {
        cb.setBackground(bg);
        cb.setForeground(fg);
        cb.setFont(font);
        cb.setFocusable(false);

        cb.setUI(new BasicComboBoxUI() {
            @Override
            protected JButton createArrowButton() {
                JButton arrow = new BasicArrowButton(
                        BasicArrowButton.SOUTH, bg, bg, fg, bg);
                arrow.setBorder(BorderFactory.createEmptyBorder());
                return arrow;
            }

            @Override
            public void paintCurrentValueBackground(Graphics g, Rectangle r, boolean hasFocus) {
                g.setColor(bg);
                g.fillRect(r.x, r.y, r.width, r.height);
            }
        });

        cb.setBorder(BorderFactory.createLineBorder(border, 1));

        cb.setRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value,
                                                          int index, boolean isSelected, boolean cellHasFocus) {
                super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                setBackground(isSelected ? new Color(80, 65, 125) : bg);
                setForeground(fg);
                setBorder(BorderFactory.createEmptyBorder(2, 5, 2, 5));
                return this;
            }
        });
    }

    public static void styleTextField(JTextField tf, Color bg, Color fg, Color border, Font font) {
        tf.setBackground(bg);
        tf.setForeground(fg);
        tf.setCaretColor(Color.WHITE);
        tf.setFont(font);
        tf.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(border, 1),
                BorderFactory.createEmptyBorder(2, 5, 2, 5)
        ));
    }

    public static void styleCheckBox(JCheckBox cb, Color fg, Font font) {
        cb.setForeground(fg);
        cb.setFont(font);
        cb.setOpaque(false);
        cb.setFocusPainted(false);
    }
}

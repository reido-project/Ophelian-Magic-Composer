package app.views.panels;

import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

public class ActionPanel extends JPanel {
    private JButton refreshBtn;
    private JButton exportBtn;
    private JButton exitBtn;

    public ActionPanel() {
        setLayout(null);
        setOpaque(false);

        refreshBtn = new JButton("Refresh");
        refreshBtn.setBounds(0, 0, 352, 50);
        add(refreshBtn);

        exportBtn = new JButton("Export");
        exportBtn.setBounds(0, 62, 352, 50);
        add(exportBtn);

        exitBtn = new JButton("Exit");
        exitBtn.setBounds(0, 124, 352, 50);
        add(exitBtn);
    }

    // Listeners
    public void addRefreshListener(ActionListener listener) { refreshBtn.addActionListener(listener); }
    public void addExportListener(ActionListener listener) { exportBtn.addActionListener(listener); }
    public void addExitListener(ActionListener listener) { exitBtn.addActionListener(listener); }
}
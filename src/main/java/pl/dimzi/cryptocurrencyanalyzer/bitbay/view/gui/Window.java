package pl.dimzi.cryptocurrencyanalyzer.bitbay.view.gui;

import javax.swing.*;
import java.awt.*;

public class Window{
    private JPanel rootPanel;

    private PlotPanel plotPanel;
    private DetailsPanel detailsPanel;

    /**
     * Constructor of BitBayWindow class.
     * Starts manager of exchange, initializes elements and listeners.
     */
    public Window() {}

    /**
     * Returns main panel for attach
     *
     * @return panel to attach
     */
    public JPanel getRootPanel() {
        return rootPanel;
    }

    /**
     * Returns plot panel for controller
     *
     * @return panel to attach
     */
    public PlotPanel getPlotPanel() {
        return plotPanel;
    }

    /**
     * Returns details panel for controller
     *
     * @return panel to attach
     */
    public DetailsPanel getDetailsPanel() {
        return detailsPanel;
    }

    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        rootPanel = new JPanel();
        rootPanel.setLayout(new GridBagLayout());
        rootPanel.setBackground(new Color(-1513240));
        final JPanel panel1 = new JPanel();
        panel1.setLayout(new GridBagLayout());
        panel1.setMinimumSize(new Dimension(600, 600));
        GridBagConstraints gbc;
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(1, 1, 1, 1);
        rootPanel.add(panel1, gbc);
        plotPanel = new PlotPanel();
        plotPanel.setPreferredSize(new Dimension(600, 300));
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        panel1.add(plotPanel, gbc);
        final JPanel panel2 = new JPanel();
        panel2.setLayout(new GridBagLayout());
        panel2.setMinimumSize(new Dimension(400, 96));
        panel2.setPreferredSize(new Dimension(400, 96));
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.BOTH;
        rootPanel.add(panel2, gbc);
        final JLabel label1 = new JLabel();
        label1.setHorizontalAlignment(0);
        label1.setText("Start");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        panel2.add(label1, gbc);
        final JLabel label2 = new JLabel();
        label2.setHorizontalAlignment(0);
        label2.setText("Range");
        label2.setVerticalAlignment(0);
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel2.add(label2, gbc);
        final JPanel panel3 = new JPanel();
        panel3.setLayout(new GridBagLayout());
        panel3.setMinimumSize(new Dimension(24, 100));
        panel3.setOpaque(true);
        panel3.setPreferredSize(new Dimension(24, 100));
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(5, 5, 5, 5);
        rootPanel.add(panel3, gbc);
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return rootPanel;
    }
}

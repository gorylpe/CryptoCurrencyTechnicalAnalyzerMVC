package com.dimzi.cryptocurrencyanalyzer.BitBay;

import com.dimzi.cryptocurrencyanalyzer.CurrencyObserver;
import com.dimzi.cryptocurrencyanalyzer.ExchangeManager;
import model.BitBayCurrencyData;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.time.LocalDateTime;
import java.util.*;
import java.util.List;

public class BitBayWindow implements CurrencyObserver, BitBaySelectionListener {
    private BitBayPlotPanel plotPanel;
    private JPanel panelMain;
    private JSpinner startSpinner;
    private JSpinner rangeSpinner;
    private JLabel intervalEndLabel;
    private JCheckBox averagesCheckBox;
    private JCheckBox followingCheckBox;
    private BitBaySelectionPanel selectionPanel;
    private JButton updateValuesButton;
    private JLabel intervalStartLabel;

    private int intervalStart;
    private int intervalRange;
    private boolean isFollowing;

    private ArrayList<BitBayCurrencyData> currencyData;

    /**
     * Constructor of BitBayWindow class.
     * Starts manager of exchange, initializes elements and listeners.
     */
    public BitBayWindow() {
        BitBayManager.INSTANCE.attachObserver(this);
        BitBayManager.INSTANCE.notifyAllObservers();

        averagesCheckBox.addItemListener((ItemEvent e) -> {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                plotPanel.setDrawingAverages(true);
            } else {
                plotPanel.setDrawingAverages(false);
            }
            refresh();
        });

        followingCheckBox.addItemListener((ItemEvent e) -> {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                startSpinner.setEnabled(false);
                isFollowing = true;
            } else {
                startSpinner.setEnabled(true);
                isFollowing = false;
            }
            refresh();
        });

        updateValuesButton.addActionListener((ActionEvent e) -> {
            setRange((int) startSpinner.getValue(), (int) rangeSpinner.getValue());
        });

        selectionPanel.setSelectionListener(this);

        isFollowing = false;
        setRange(0, 50);
    }

    /**
     * Sets range of chosen data and takes care of wrong values
     *
     * @param start start of the interval
     * @param range range of the interval
     * @throws NullPointerException Whether data is null array
     */
    @Override
    public void setRange(int start, int range) {
        if (currencyData != null) {
            if (range < 1)
                range = 1;
            if (range >= currencyData.size()){
                range = currencyData.size();
            }

            

            this.intervalStart = start;
            this.intervalRange = end - start;

            refresh();
        }
    }

    private void refresh() {
        //debug
        plotPanel.setTradeType(BitBayManager.TradeType.ETHPLN);

        if (isFollowing) {
            intervalStart = currencyData.size() - 1 - intervalRange;
        }
        int intervalEnd = intervalStart + intervalRange;

        try {
            List<BitBayCurrencyData> rangedData = currencyData.subList(intervalStart, intervalEnd);

            LocalDateTime intervalStartDateTime = rangedData.get(0).getPeriodStart();
            LocalDateTime intervalEndDateTime = rangedData.get(rangedData.size() - 1).getPeriodStart();
            intervalStartLabel.setText(intervalStartDateTime.toLocalDate().toString() + " " + intervalStartDateTime.toLocalTime().toString());
            intervalEndLabel.setText(intervalEndDateTime.toLocalDate().toString() + " " + intervalEndDateTime.toLocalTime().toString());

            plotPanel.setData(rangedData);
            plotPanel.repaint();

            startSpinner.setValue(intervalStart);
            rangeSpinner.setValue(intervalEnd - intervalStart);

            selectionPanel.setRange(intervalStart, intervalEnd);
            selectionPanel.repaint();
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Wrong interval");
        }
    }

    /**
     * Returns main panel for attach
     *
     * @return panel to attach
     */
    public JPanel getPanelMain() {
        return panelMain;
    }

    @Override
    public void update() {
        System.out.println("BitBayWindow updating");

        currencyData = BitBayManager.INSTANCE.getCurrencyData(
                BitBayManager.TradeType.ETHPLN,
                ExchangeManager.CurrencyDataPeriodType.DAILY);

        selectionPanel.setData(currencyData);

        refresh();
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
        panelMain = new JPanel();
        panelMain.setLayout(new GridBagLayout());
        panelMain.setBackground(new Color(-1513240));
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
        panelMain.add(panel1, gbc);
        plotPanel = new BitBayPlotPanel();
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
        panelMain.add(panel2, gbc);
        rangeSpinner = new JSpinner();
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(5, 5, 5, 5);
        panel2.add(rangeSpinner, gbc);
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
        startSpinner = new JSpinner();
        startSpinner.setMinimumSize(new Dimension(36, 26));
        startSpinner.setPreferredSize(new Dimension(36, 26));
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(5, 5, 5, 5);
        panel2.add(startSpinner, gbc);
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
        intervalEndLabel = new JLabel();
        intervalEndLabel.setHorizontalAlignment(0);
        intervalEndLabel.setText("");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel2.add(intervalEndLabel, gbc);
        averagesCheckBox = new JCheckBox();
        averagesCheckBox.setBorderPaintedFlat(true);
        averagesCheckBox.setHorizontalAlignment(0);
        averagesCheckBox.setText("Averages");
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 1;
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel2.add(averagesCheckBox, gbc);
        followingCheckBox = new JCheckBox();
        followingCheckBox.setHorizontalAlignment(0);
        followingCheckBox.setText("Following");
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel2.add(followingCheckBox, gbc);
        updateValuesButton = new JButton();
        updateValuesButton.setText("Update");
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.BOTH;
        panel2.add(updateValuesButton, gbc);
        intervalStartLabel = new JLabel();
        intervalStartLabel.setHorizontalAlignment(0);
        intervalStartLabel.setText("");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.weighty = 2.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel2.add(intervalStartLabel, gbc);
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
        panelMain.add(panel3, gbc);
        selectionPanel = new BitBaySelectionPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        panel3.add(selectionPanel, gbc);
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return panelMain;
    }
}

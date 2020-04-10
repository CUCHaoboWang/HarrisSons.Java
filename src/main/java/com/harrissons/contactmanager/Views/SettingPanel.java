package com.harrissons.contactmanager.Views;

import com.harrissons.contactmanager.App;
import com.harrissons.contactmanager.Models.UIConsts;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Settings Panel
 *
 * @author Bob
 */
public class SettingPanel extends JPanel {

    private static final long serialVersionUID = 1L;
    public static JPanel settingPanelMain;
    private static JPanel panelOption;
    private static JPanel panelAbout;
    private static JPanel settingPanelOption;
    private static JPanel settingPanelAbout;

    /**
     * Constructor
     */
    public SettingPanel() {
        initialize();
        addComponent();
        addListener();
    }

    /**
     * Initialize
     */
    private void initialize() {
        this.setBackground(UIConsts.MAIN_BACK_COLOR);
        this.setLayout(new BorderLayout());
        settingPanelOption = new SettingPanelOption();
        settingPanelAbout = new SettingPanelAbout();
    }

    /**
     * Add Component
     */
    private void addComponent() {
        this.add(getUpPanel(), BorderLayout.NORTH);
        this.add(getCenterPanel(), BorderLayout.CENTER);
    }

    /**
     * Get Upper Panel
     *
     * @return
     */
    private JPanel getUpPanel() {
        JPanel panelUp = new JPanel();
        panelUp.setBackground(UIConsts.MAIN_BACK_COLOR);
        panelUp.setLayout(new FlowLayout(FlowLayout.LEFT, UIConsts.MAIN_H_GAP, 5));

        JLabel labelTitle = new JLabel("Settings");
        labelTitle.setFont(UIConsts.FONT_TITLE);
        labelTitle.setForeground(UIConsts.MAIN_FONT_COLOR);
        panelUp.add(labelTitle);

        return panelUp;
    }

    /**
     * Get Center Panel
     *
     * @return
     */
    private JPanel getCenterPanel() {
        // Center Panel
        JPanel panelCenter = new JPanel();
        panelCenter.setBackground(UIConsts.MAIN_BACK_COLOR);
        panelCenter.setLayout(new BorderLayout());

        // List Panel
        JPanel panelList = new JPanel();
        Dimension preferredSize = new Dimension(245, UIConsts.MAIN_WINDOW_HEIGHT);
        panelList.setPreferredSize(preferredSize);
        panelList.setBackground(UIConsts.LIST_BACK_COLOR);
        panelList.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));

        panelOption = new JPanel();
        panelOption.setBackground(UIConsts.TOOLBAR_BACK_COLOR);
        panelOption.setLayout(new FlowLayout(FlowLayout.LEFT, 30, 13));
        Dimension preferredSizeListItem = new Dimension(245, 48);
        panelOption.setPreferredSize(preferredSizeListItem);
        panelAbout = new JPanel();
        panelAbout.setBackground(UIConsts.TOOLBAR_BACK_COLOR);
        panelAbout.setLayout(new FlowLayout(FlowLayout.LEFT, 30, 13));
        panelAbout.setPreferredSize(preferredSizeListItem);

        JLabel labelOption = new JLabel("Option");
        JLabel labelAbout = new JLabel("About");
        labelOption.setFont(UIConsts.FONT_LIST);
        labelAbout.setFont(UIConsts.FONT_LIST);
        labelOption.setForeground(UIConsts.MAIN_FONT_COLOR);
        labelAbout.setForeground(UIConsts.MAIN_FONT_COLOR);
        panelOption.add(labelOption);
        panelAbout.add(labelAbout);

        panelList.add(panelOption);
        panelList.add(panelAbout);

        // Setting Panel
        settingPanelMain = new JPanel();
        settingPanelMain.setBackground(UIConsts.MAIN_BACK_COLOR);
        settingPanelMain.setLayout(new BorderLayout());
        settingPanelMain.add(settingPanelOption);

        panelCenter.add(panelList, BorderLayout.WEST);
        panelCenter.add(settingPanelMain, BorderLayout.CENTER);

        return panelCenter;
    }

    /**
     * Add Listener
     */
    private void addListener() {
        panelOption.addMouseListener(new MouseListener() {

            @Override
            public void mouseReleased(MouseEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mousePressed(MouseEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mouseExited(MouseEvent e) {
                // TODO Auto-generated method stub
                panelOption.setBackground(UIConsts.LABEL_BACK_COLOR);
                panelAbout.setBackground(UIConsts.TOOLBAR_BACK_COLOR);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                panelOption.setBackground(UIConsts.LABEL_BACK_COLOR);
                panelAbout.setBackground(UIConsts.TOOLBAR_BACK_COLOR);
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                panelOption.setBackground(UIConsts.LABEL_BACK_COLOR);
                panelAbout.setBackground(UIConsts.TOOLBAR_BACK_COLOR);

                SettingPanel.settingPanelMain.removeAll();
                SettingPanelOption.setCurrentOption();
                SettingPanel.settingPanelMain.add(settingPanelOption);
                App.settingPanel.updateUI();

            }
        });

        panelAbout.addMouseListener(new MouseListener() {

            @Override
            public void mouseReleased(MouseEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mousePressed(MouseEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mouseExited(MouseEvent e) {
                // TODO Auto-generated method stub
                panelAbout.setBackground(UIConsts.LABEL_BACK_COLOR);
                panelOption.setBackground(UIConsts.TOOLBAR_BACK_COLOR);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                panelAbout.setBackground(UIConsts.LABEL_BACK_COLOR);
                panelOption.setBackground(UIConsts.TOOLBAR_BACK_COLOR);
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                panelAbout.setBackground(UIConsts.LABEL_BACK_COLOR);
                panelOption.setBackground(UIConsts.TOOLBAR_BACK_COLOR);

                SettingPanel.settingPanelMain.removeAll();
                SettingPanel.settingPanelMain.add(settingPanelAbout);
                App.settingPanel.updateUI();
            }
        });
    }
}

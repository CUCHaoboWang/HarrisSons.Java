package com.harrissons.contactmanager.Views;

import com.harrissons.contactmanager.Models.UIConsts;
import com.harrissons.contactmanager.Views.Components.IconButton;

import javax.swing.*;
import java.awt.*;

/**
 * About Panel
 *
 * @author Bob
 */
public class SettingPanelAbout extends JPanel {

    private static final long serialVersionUID = 1L;

    /**
     * Constructor
     */
    public SettingPanelAbout() {
        initialize();
        addComponent();
    }

    /**
     * Initialize
     */
    private void initialize() {
        this.setBackground(UIConsts.MAIN_BACK_COLOR);
        this.setLayout(new BorderLayout());
    }

    /**
     * Add Component
     */
    private void addComponent() {

        this.add(getCenterPanel(), BorderLayout.CENTER);
        this.add(getBottomPanel(), BorderLayout.SOUTH);

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
        panelCenter.setLayout(new GridLayout(3, 1));

        // Icon Grid Panel
        JPanel panelGridIcon = new JPanel();
        panelGridIcon.setBackground(UIConsts.MAIN_BACK_COLOR);
        panelGridIcon.setLayout(new FlowLayout(FlowLayout.LEFT, UIConsts.MAIN_H_GAP, 0));

        // Initialize Panel
        IconButton icon = new IconButton(UIConsts.ICON_CONTACT_MANAGER, UIConsts.ICON_CONTACT_MANAGER,
                UIConsts.ICON_CONTACT_MANAGER, "");
        JLabel labelName = new JLabel(UIConsts.APP_NAME);
        JLabel labelVersion = new JLabel(UIConsts.APP_VERSION);

        // Font
        labelName.setFont(UIConsts.FONT_NORMAL);
        labelVersion.setFont(UIConsts.FONT_NORMAL);

        // Size
        Dimension size = new Dimension(200, 30);
        labelName.setPreferredSize(size);
        labelVersion.setPreferredSize(size);

        // Combine Component
        panelGridIcon.add(icon);
        panelGridIcon.add(labelName);
        panelGridIcon.add(labelVersion);

        panelCenter.add(panelGridIcon);
        return panelCenter;
    }

    /**
     * Bottom Panel
     *
     * @return
     */
    private JPanel getBottomPanel() {
        JPanel panelBottom = new JPanel();
        panelBottom.setBackground(UIConsts.MAIN_BACK_COLOR);
        panelBottom.setLayout(new FlowLayout(FlowLayout.LEFT, UIConsts.MAIN_H_GAP, 15));

        JLabel labelInfo = new JLabel("Copyright 2020 | All Rights Reserved | 212IT CU Coventry");
        labelInfo.setFont(UIConsts.FONT_NORMAL);
        labelInfo.setForeground(Color.gray);

        panelBottom.add(labelInfo);

        return panelBottom;
    }
}

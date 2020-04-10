package com.harrissons.contactmanager.Views.Components;

import javax.swing.*;
import java.awt.*;

/**
 * Customised Icon Button with normal icon, enabled icon, disabled icon, and tooltip.
 *
 * @author Bob
 */
public class IconButton extends JButton {

    private static final long serialVersionUID = 1L;
    private ImageIcon iconEnable, iconDisable;
    private String tip;

    /**
     * 构造
     *
     * @param iconNormal  normal icon
     * @param iconEnable  enabled icon
     * @param iconDisable disabled icon
     * @param tip         tooltip
     */
    public IconButton(ImageIcon iconNormal, ImageIcon iconEnable, ImageIcon iconDisable, String tip) {
        super(iconNormal);

        this.iconEnable = iconEnable;
        this.iconDisable = iconDisable;
        this.tip = tip;

        initialize();
        setUp();
    }

    /**
     * Initialize
     */
    private void initialize() {
        this.setBorderPainted(false);
        this.setFocusPainted(false);
        this.setContentAreaFilled(false);
        this.setFocusable(true);
        this.setMargin(new Insets(0, 0, 0, 0));
    }

    /**
     * Setup
     */
    private void setUp() {
        this.setRolloverIcon(iconEnable);
        this.setSelectedIcon(iconEnable);
        this.setPressedIcon(iconEnable);
        this.setDisabledIcon(iconDisable);

        if (!tip.equals("")) {
            this.setToolTipText(tip);
        }
    }
}

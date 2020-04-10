package com.harrissons.contactmanager.Views;

import com.harrissons.contactmanager.App;
import com.harrissons.contactmanager.Models.UIConsts;
import com.harrissons.contactmanager.Views.Components.IconButton;

import javax.swing.*;
import java.awt.*;

/**
 * Navigation Bar Panel
 *
 * @author Bob
 */
public class NavBarPanel extends JPanel {

    private static final long serialVersionUID = 1L;

    public static IconButton buttonPersonalContact;
    public static IconButton buttonManagePersonalContact;
    public static IconButton buttonBusinessContact;
    public static IconButton buttonManageBusinessContact;
    public static IconButton buttonSetting;

    /**
     * Constructor
     */
    public NavBarPanel() {
        initialize();
        addButtion();
        addListener();
    }

    public static void SwitchToPersonalContactManagePanel() {
        buttonPersonalContact.setIcon(UIConsts.ICON_VIEW_PERSONAL_CONTACT);
        buttonManagePersonalContact.setIcon(UIConsts.ICON_MANAGE_PERSONAL_CONTACT_ENABLE);
        buttonBusinessContact.setIcon(UIConsts.ICON_VIEW_BUSINESS_CONTACT);
        buttonManageBusinessContact.setIcon(UIConsts.ICON_MANAGE_BUSINESS_CONTACT);
        buttonSetting.setIcon(UIConsts.ICON_SETTING);

        App.mainPanelCenter.removeAll();

        App.mainPanelCenter.add(App.personalContactManagePanel, BorderLayout.CENTER);

        App.mainPanelCenter.updateUI();

        PersonalContactManagePanel.setContent();
    }

    public static void SwitchToBusinessContactManagePanel() {
        buttonPersonalContact.setIcon(UIConsts.ICON_VIEW_PERSONAL_CONTACT);
        buttonManagePersonalContact.setIcon(UIConsts.ICON_MANAGE_PERSONAL_CONTACT);
        buttonBusinessContact.setIcon(UIConsts.ICON_VIEW_BUSINESS_CONTACT);
        buttonManageBusinessContact.setIcon(UIConsts.ICON_MANAGE_BUSINESS_CONTACT_ENABLE);
        buttonSetting.setIcon(UIConsts.ICON_SETTING);

        App.mainPanelCenter.removeAll();

        App.mainPanelCenter.add(App.businessContactManagePanel, BorderLayout.CENTER);

        App.mainPanelCenter.updateUI();

        BusinessContactManagePanel.setContent();
    }

    /**
     * Initialize
     */
    private void initialize() {
        Dimension preferredSize = new Dimension(48, UIConsts.MAIN_WINDOW_HEIGHT);
        this.setPreferredSize(preferredSize);
        this.setMaximumSize(preferredSize);
        this.setMinimumSize(preferredSize);
        this.setBackground(UIConsts.TOOLBAR_BACK_COLOR);
        this.setLayout(new GridLayout(2, 1));
    }

    /**
     * Add Buttons
     */
    private void addButtion() {

        JPanel panelUp = new JPanel();
        panelUp.setBackground(UIConsts.TOOLBAR_BACK_COLOR);
        panelUp.setLayout(new FlowLayout(-2, -2, -4));
        JPanel panelDown = new JPanel();
        panelDown.setBackground(UIConsts.TOOLBAR_BACK_COLOR);
        panelDown.setLayout(new BorderLayout(0, 0));

        buttonPersonalContact = new IconButton(UIConsts.ICON_VIEW_PERSONAL_CONTACT_ENABLE, UIConsts.ICON_VIEW_PERSONAL_CONTACT_ENABLE,
                UIConsts.ICON_VIEW_PERSONAL_CONTACT, "View Personal Contacts");
        buttonManagePersonalContact = new IconButton(UIConsts.ICON_MANAGE_PERSONAL_CONTACT, UIConsts.ICON_MANAGE_PERSONAL_CONTACT_ENABLE,
                UIConsts.ICON_MANAGE_PERSONAL_CONTACT, "Manage Personal Contacts");
        buttonBusinessContact = new IconButton(UIConsts.ICON_VIEW_BUSINESS_CONTACT, UIConsts.ICON_VIEW_BUSINESS_CONTACT_ENABLE,
                UIConsts.ICON_VIEW_BUSINESS_CONTACT, "View Business Contacts");
        buttonManageBusinessContact = new IconButton(UIConsts.ICON_MANAGE_BUSINESS_CONTACT, UIConsts.ICON_MANAGE_BUSINESS_CONTACT_ENABLE,
                UIConsts.ICON_MANAGE_BUSINESS_CONTACT, "Manage Business Contacts");
        buttonSetting = new IconButton(UIConsts.ICON_SETTING, UIConsts.ICON_SETTING_ENABLE,
                UIConsts.ICON_SETTING, "Settings");

        panelUp.add(buttonPersonalContact);
        panelUp.add(buttonManagePersonalContact);
        panelUp.add(buttonBusinessContact);
        panelUp.add(buttonManageBusinessContact);
        panelDown.add(buttonSetting, BorderLayout.SOUTH);
        this.add(panelUp);
        this.add(panelDown);
    }

    /**
     * Add Event Listeners
     */
    private void addListener() {
        buttonPersonalContact.addActionListener(e -> {
            buttonPersonalContact.setIcon(UIConsts.ICON_VIEW_PERSONAL_CONTACT_ENABLE);
            buttonManagePersonalContact.setIcon(UIConsts.ICON_MANAGE_PERSONAL_CONTACT);
            buttonBusinessContact.setIcon(UIConsts.ICON_VIEW_BUSINESS_CONTACT);
            buttonManageBusinessContact.setIcon(UIConsts.ICON_MANAGE_BUSINESS_CONTACT);
            buttonSetting.setIcon(UIConsts.ICON_SETTING);

            App.mainPanelCenter.removeAll();

            App.mainPanelCenter.add(App.personalContactPanel, BorderLayout.CENTER);

            App.mainPanelCenter.updateUI();

            PersonalContactPanel.initializeTableData();

            PersonalContactPanel.tableContact.validate();
        });

        buttonManagePersonalContact.addActionListener(e -> {
            SwitchToPersonalContactManagePanel();
        });

        buttonBusinessContact.addActionListener(e -> {
            buttonPersonalContact.setIcon(UIConsts.ICON_VIEW_PERSONAL_CONTACT);
            buttonManagePersonalContact.setIcon(UIConsts.ICON_MANAGE_PERSONAL_CONTACT);
            buttonBusinessContact.setIcon(UIConsts.ICON_VIEW_BUSINESS_CONTACT_ENABLE);
            buttonManageBusinessContact.setIcon(UIConsts.ICON_MANAGE_BUSINESS_CONTACT);
            buttonSetting.setIcon(UIConsts.ICON_SETTING);

            App.mainPanelCenter.removeAll();

            App.mainPanelCenter.add(App.businessContactPanel, BorderLayout.CENTER);

            App.mainPanelCenter.updateUI();

            BusinessContactPanel.initializeTableData();
            BusinessContactPanel.tableContact.validate();
        });

        buttonManageBusinessContact.addActionListener(e -> {
            SwitchToBusinessContactManagePanel();
        });

        buttonSetting.addActionListener(e -> {
            buttonPersonalContact.setIcon(UIConsts.ICON_VIEW_PERSONAL_CONTACT);
            buttonManagePersonalContact.setIcon(UIConsts.ICON_MANAGE_PERSONAL_CONTACT);
            buttonBusinessContact.setIcon(UIConsts.ICON_VIEW_BUSINESS_CONTACT);
            buttonManageBusinessContact.setIcon(UIConsts.ICON_MANAGE_BUSINESS_CONTACT);
            buttonSetting.setIcon(UIConsts.ICON_SETTING_ENABLE);

            App.mainPanelCenter.removeAll();
            SettingPanelOption.setCurrentOption();
            App.mainPanelCenter.add(App.settingPanel, BorderLayout.CENTER);

            App.mainPanelCenter.updateUI();
        });
    }
}


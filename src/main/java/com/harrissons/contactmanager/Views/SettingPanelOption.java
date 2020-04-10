package com.harrissons.contactmanager.Views;

import com.harrissons.contactmanager.App;
import com.harrissons.contactmanager.Helpers.DESPlus;
import com.harrissons.contactmanager.Helpers.DbToolMySQL;
import com.harrissons.contactmanager.Helpers.FileTools;
import com.harrissons.contactmanager.Models.ToolConsts;
import com.harrissons.contactmanager.Models.UIConsts;
import com.harrissons.contactmanager.Views.Components.IconButton;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
import java.io.IOException;

/**
 * Option Panel
 *
 * @author Bob
 */
public class SettingPanelOption extends JPanel {

    private static final long serialVersionUID = 1L;
    private static final Logger logger = LoggerFactory.getLogger(SettingPanelOption.class);
    private static IconButton buttonOpenBackups;
    private static IconButton buttonClearBackups;
    private static IconButton buttonOpenLogs;
    private static IconButton buttonClearLogs;
    private static IconButton buttonSave;
    private static JComboBox<String> comboBoxDatabaseType;
    private static JTextField textFieldDatabaseAddress;
    private static JTextField textFieldDatabaseName;
    private static JTextField textFieldDatabaseUserName;
    private static JPasswordField textFieldDatabasePassword;
    private static String dbChoice = null;
    private static DbToolMySQL dbMySQL = DbToolMySQL.getInstance();

    /**
     * Constructor
     */
    public SettingPanelOption() {
        initialize();
        addComponent();
        setCurrentOption();
        addListener();
    }

    /**
     * Set Current Option
     */
    public static void setCurrentOption() {
        dbChoice = ToolConsts.CONFIGER.getDataBaseChoice();

        if (dbChoice.equals("MySQL")) {
            setMySQLOption();
        }

        if (dbChoice.equals("SQL Server")) {
            setSQLServerOption();
        }
    }

    /**
     * Set MySQL Option
     */
    public static void setMySQLOption() {
        String user = "";
        String password = "";
        comboBoxDatabaseType.setSelectedIndex(0);
        textFieldDatabaseAddress.setText(ToolConsts.CONFIGER.getHostMySQL());
        textFieldDatabaseName.setText(ToolConsts.CONFIGER.getNameMySQL());
        try {
            DESPlus des = new DESPlus();
            user = des.decrypt(ToolConsts.CONFIGER.getUserMySQL());
            password = des.decrypt(ToolConsts.CONFIGER.getPasswordMySQL());
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("Exception: " + e.getMessage());
        }
        textFieldDatabaseUserName.setText(user);
        textFieldDatabasePassword.setText(password);
    }

    /**
     * Set SQL Server Option
     */
    public static void setSQLServerOption() {
        String user = "";
        String password = "";
        comboBoxDatabaseType.setSelectedIndex(1);
        textFieldDatabaseAddress.setText(ToolConsts.CONFIGER.getHostSqlServer());
        textFieldDatabaseName.setText(ToolConsts.CONFIGER.getNameSqlServer());
        try {
            DESPlus des = new DESPlus();
            user = des.decrypt(ToolConsts.CONFIGER.getUserSqlServer());
            password = des.decrypt(ToolConsts.CONFIGER.getPasswordSqlServer());
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("Exception: " + e.getMessage());
        }
        textFieldDatabaseUserName.setText(user);
        textFieldDatabasePassword.setText(password);
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
        panelCenter.setLayout(new GridLayout(1, 1));

        // Set Grid
        JPanel panelGridOption = new JPanel();
        panelGridOption.setBackground(UIConsts.MAIN_BACK_COLOR);
        panelGridOption.setLayout(new GridLayout(12, 1));

        // Initialize Component
        JPanel panelItem1 = new JPanel(new FlowLayout(FlowLayout.LEFT, UIConsts.MAIN_H_GAP, 0));
        JPanel panelItem2 = new JPanel(new FlowLayout(FlowLayout.LEFT, UIConsts.MAIN_H_GAP, 0));
        JPanel panelItem3 = new JPanel(new FlowLayout(FlowLayout.LEFT, UIConsts.MAIN_H_GAP, 0));
        JPanel panelItem4 = new JPanel(new FlowLayout(FlowLayout.LEFT, UIConsts.MAIN_H_GAP, 0));
        JPanel panelItem5 = new JPanel(new FlowLayout(FlowLayout.LEFT, UIConsts.MAIN_H_GAP, 0));
        JPanel panelItem6 = new JPanel(new FlowLayout(FlowLayout.LEFT, UIConsts.MAIN_H_GAP, 0));
        JPanel panelItem7 = new JPanel(new FlowLayout(FlowLayout.LEFT, UIConsts.MAIN_H_GAP, 0));
        JPanel panelItem8 = new JPanel(new FlowLayout(FlowLayout.LEFT, UIConsts.MAIN_H_GAP, 0));
        JPanel panelItem9 = new JPanel(new FlowLayout(FlowLayout.LEFT, UIConsts.MAIN_H_GAP, 0));

        panelItem1.setBackground(UIConsts.MAIN_BACK_COLOR);
        panelItem2.setBackground(UIConsts.MAIN_BACK_COLOR);
        panelItem3.setBackground(UIConsts.MAIN_BACK_COLOR);
        panelItem4.setBackground(UIConsts.MAIN_BACK_COLOR);
        panelItem5.setBackground(UIConsts.MAIN_BACK_COLOR);
        panelItem6.setBackground(UIConsts.MAIN_BACK_COLOR);
        panelItem7.setBackground(UIConsts.MAIN_BACK_COLOR);
        panelItem8.setBackground(UIConsts.MAIN_BACK_COLOR);
        panelItem9.setBackground(UIConsts.MAIN_BACK_COLOR);

        panelItem1.setPreferredSize(UIConsts.PANEL_ITEM_SIZE);
        panelItem2.setPreferredSize(UIConsts.PANEL_ITEM_SIZE);
        panelItem3.setPreferredSize(UIConsts.PANEL_ITEM_SIZE);
        panelItem4.setPreferredSize(UIConsts.PANEL_ITEM_SIZE);
        panelItem5.setPreferredSize(UIConsts.PANEL_ITEM_SIZE);
        panelItem6.setPreferredSize(UIConsts.PANEL_ITEM_SIZE);
        panelItem7.setPreferredSize(UIConsts.PANEL_ITEM_SIZE);
        panelItem8.setPreferredSize(UIConsts.PANEL_ITEM_SIZE);
        panelItem9.setPreferredSize(UIConsts.PANEL_ITEM_SIZE);

        buttonOpenBackups = new IconButton(UIConsts.ICON_OPEN_BACKUP, UIConsts.ICON_OPEN_BACKUP_ENABLE,
                UIConsts.ICON_OPEN_BACKUP, "");
        panelItem1.add(buttonOpenBackups);

        buttonClearBackups = new IconButton(UIConsts.ICON_CLEAR_BACKUP, UIConsts.ICON_CLEAR_BACKUP_ENABLE,
                UIConsts.ICON_CLEAR_BACKUP, "");
        panelItem2.add(buttonClearBackups);

        buttonOpenLogs = new IconButton(UIConsts.ICON_OPEN_LOG, UIConsts.ICON_OPEN_LOG_ENABLE,
                UIConsts.ICON_OPEN_LOG, "");
        panelItem3.add(buttonOpenLogs);

        buttonClearLogs = new IconButton(UIConsts.ICON_CLEAR_LOG, UIConsts.ICON_CLEAR_LOG_ENABLE,
                UIConsts.ICON_CLEAR_LOG, "");
        panelItem4.add(buttonClearLogs);

        JLabel labelDatabaseType = new JLabel("Database Type:");
        labelDatabaseType.setFont(UIConsts.FONT_NORMAL);
        labelDatabaseType.setPreferredSize(UIConsts.LABLE_SIZE_LARGE_ITEM);
        comboBoxDatabaseType = new JComboBox<String>();
        comboBoxDatabaseType.setEditable(false);
        comboBoxDatabaseType.setFont(UIConsts.FONT_NORMAL);
        comboBoxDatabaseType.setPreferredSize(UIConsts.TEXT_FIELD_SIZE_ITEM);
        comboBoxDatabaseType.addItem("MySQL");
        comboBoxDatabaseType.addItem("SQL Server");
        panelItem5.add(labelDatabaseType);
        panelItem5.add(comboBoxDatabaseType);

        JLabel labelDatabaseAddress = new JLabel("Database Address:");
        labelDatabaseAddress.setFont(UIConsts.FONT_NORMAL);
        labelDatabaseAddress.setPreferredSize(UIConsts.LABLE_SIZE_LARGE_ITEM);
        textFieldDatabaseAddress = new JTextField();
        textFieldDatabaseAddress.setFont(UIConsts.FONT_NORMAL);
        textFieldDatabaseAddress.setPreferredSize(UIConsts.TEXT_FIELD_SIZE_ITEM);
        panelItem6.add(labelDatabaseAddress);
        panelItem6.add(textFieldDatabaseAddress);

        JLabel labelDatabaseName = new JLabel("Database Name:");
        labelDatabaseName.setFont(UIConsts.FONT_NORMAL);
        labelDatabaseName.setPreferredSize(UIConsts.LABLE_SIZE_LARGE_ITEM);
        textFieldDatabaseName = new JTextField();
        textFieldDatabaseName.setFont(UIConsts.FONT_NORMAL);
        textFieldDatabaseName.setPreferredSize(UIConsts.TEXT_FIELD_SIZE_ITEM);
        panelItem7.add(labelDatabaseName);
        panelItem7.add(textFieldDatabaseName);

        JLabel labelDatabaseUserName = new JLabel("User Name:");
        labelDatabaseUserName.setFont(UIConsts.FONT_NORMAL);
        labelDatabaseUserName.setPreferredSize(UIConsts.LABLE_SIZE_LARGE_ITEM);
        textFieldDatabaseUserName = new JTextField();
        textFieldDatabaseUserName.setFont(UIConsts.FONT_NORMAL);
        textFieldDatabaseUserName.setPreferredSize(UIConsts.TEXT_FIELD_SIZE_ITEM);
        panelItem8.add(labelDatabaseUserName);
        panelItem8.add(textFieldDatabaseUserName);

        JLabel labelDatabasePassword = new JLabel("Password:");
        labelDatabasePassword.setFont(UIConsts.FONT_NORMAL);
        labelDatabasePassword.setPreferredSize(UIConsts.LABLE_SIZE_LARGE_ITEM);
        textFieldDatabasePassword = new JPasswordField();
        textFieldDatabasePassword.setFont(UIConsts.FONT_NORMAL);
        textFieldDatabasePassword.setPreferredSize(UIConsts.TEXT_FIELD_SIZE_ITEM);
        panelItem9.add(labelDatabasePassword);
        panelItem9.add(textFieldDatabasePassword);

        // Combine Component
        panelGridOption.add(panelItem1);
        panelGridOption.add(panelItem2);
        panelGridOption.add(panelItem3);
        panelGridOption.add(panelItem4);
        panelGridOption.add(panelItem5);
        panelGridOption.add(panelItem6);
        panelGridOption.add(panelItem7);
        panelGridOption.add(panelItem8);
        panelGridOption.add(panelItem9);

        panelCenter.add(panelGridOption);
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
        panelBottom.setLayout(new FlowLayout(FlowLayout.RIGHT, UIConsts.MAIN_H_GAP, 15));

        buttonSave = new IconButton(UIConsts.ICON_SAVE, UIConsts.ICON_SAVE_ENABLE,
                UIConsts.ICON_SAVE, "");
        panelBottom.add(buttonSave);

        return panelBottom;
    }

    /**
     * Add Listener
     */
    private void addListener() {
        comboBoxDatabaseType.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    if (comboBoxDatabaseType.getSelectedIndex() == 0) {
                        dbChoice = comboBoxDatabaseType.getSelectedItem().toString();
                        setMySQLOption();
                    }
                    if (comboBoxDatabaseType.getSelectedIndex() == 1) {
                        dbChoice = comboBoxDatabaseType.getSelectedItem().toString();
                        setSQLServerOption();
                    }
                }
            }
        });

        buttonSave.addActionListener(e -> {
            String password = "";
            String user = "";
            try {
                if (dbChoice.equals("MySQL")) {
                    ToolConsts.CONFIGER.setDataBaseChoice(dbChoice);
                    ToolConsts.CONFIGER.setHostMySQL(textFieldDatabaseAddress.getText());
                    ToolConsts.CONFIGER.setNameMySQL(textFieldDatabaseName.getText());

                    try {
                        DESPlus des = new DESPlus();
                        user = des.encrypt(textFieldDatabaseUserName.getText());
                        password = des.encrypt(new String(textFieldDatabasePassword.getPassword()));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        logger.error("Exception: " + ex.getMessage());
                    }
                    ToolConsts.CONFIGER.setUserMySQL(user);
                    ToolConsts.CONFIGER.setPasswordMySQL(password);
                }

                if (dbChoice.equals("SQL Server")) {
                    ToolConsts.CONFIGER.setDataBaseChoice(dbChoice);
                    ToolConsts.CONFIGER.setHostSqlServer(textFieldDatabaseAddress.getText());
                    ToolConsts.CONFIGER.setNameSqlServer(textFieldDatabaseName.getText());

                    try {
                        DESPlus des = new DESPlus();
                        user = des.encrypt(textFieldDatabaseUserName.getText());
                        password = des.encrypt(new String(textFieldDatabasePassword.getPassword()));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        logger.error("Exception: " + ex.getMessage());
                    }
                    ToolConsts.CONFIGER.setUserSqlServer(user);
                    ToolConsts.CONFIGER.setPasswordSqlServer(password);
                }

                JOptionPane.showMessageDialog(App.settingPanel, "Settings Saved",
                        "Success", JOptionPane.PLAIN_MESSAGE);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(App.settingPanel, "Exception:" + "\n" + ex.getMessage(),
                        "Error", JOptionPane.ERROR_MESSAGE);
                logger.error("Exception: " + ex.getMessage());
            }
        });

        buttonOpenBackups.addActionListener(e -> {
            try {
                Desktop.getDesktop().open(new File(ToolConsts.PATH_MYSQL_BACKUP));
            } catch (IOException ex) {
                ex.printStackTrace();
                logger.error("Exception: " + ex.getMessage());
            }
        });

        buttonClearBackups.addActionListener(e -> {
            int answer = JOptionPane.showConfirmDialog(App.settingPanel, "Are you sure to clear all backup files?",
                    "Warning", 2);

            if (answer == 0) {
                try {
                    FileTools.clearDirectiory(ToolConsts.PATH_MYSQL_BACKUP);
                    JOptionPane.showMessageDialog(App.settingPanel, "Backups cleared",
                            "Success", JOptionPane.PLAIN_MESSAGE);
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(App.settingPanel, "Exception:" + "\n" + ex.getMessage(),
                            "Error", JOptionPane.ERROR_MESSAGE);
                    ex.printStackTrace();
                }
            }
        });

        buttonOpenLogs.addActionListener(e -> {
            try {
                Desktop.getDesktop().open(new File(ToolConsts.PATH_LOG));
            } catch (IOException ex) {
                ex.printStackTrace();
                logger.error("Exception: " + ex.getMessage());
            }
        });

        buttonClearLogs.addActionListener(e -> {
            int answer = JOptionPane.showConfirmDialog(App.settingPanel, "Are you sure to clear all log files?",
                    "Warning", 2);

            if (answer == 0) {
                try {
                    FileTools.clearDirectiory(ToolConsts.PATH_LOG);
                    JOptionPane.showMessageDialog(App.settingPanel, "Logs cleared",
                            "Success", JOptionPane.PLAIN_MESSAGE);
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(App.settingPanel, "Exception:" + "\n" + ex.getMessage(),
                            "Error", JOptionPane.ERROR_MESSAGE);
                    ex.printStackTrace();
                }
            }
        });
    }
}


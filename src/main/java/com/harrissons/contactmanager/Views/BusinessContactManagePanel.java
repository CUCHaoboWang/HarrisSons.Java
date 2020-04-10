package com.harrissons.contactmanager.Views;

import com.harrissons.contactmanager.App;
import com.harrissons.contactmanager.Helpers.DbToolMySQL;
import com.harrissons.contactmanager.Helpers.Tools;
import com.harrissons.contactmanager.Models.UIConsts;
import com.harrissons.contactmanager.Views.Components.IconButton;
import com.harrissons.contactmanager.Views.Components.JFormattedDateTextField;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.List;

/**
 * Personal Contact Manage Panel
 *
 * @author Bob
 */
public class BusinessContactManagePanel extends JPanel {

    private static final long serialVersionUID = 1L;
    private static final Logger logger = LoggerFactory.getLogger(PersonalContactManagePanel.class);
    private static IconButton buttonTestLink;
    private static IconButton buttonSave;
    private static JTextField textFieldFirstName;
    private static JTextField textFieldLastName;
    private static JFormattedDateTextField textFieldBirthDate;
    private static JTextField textFieldEmailAddress;
    private static JComboBox<String> comboBoxPosition;
    private static JComboBox<String> comboBoxDepartment;
    private static JTextField textFieldTelephone;
    private static JTextField textFieldBusinessTelephone;
    private static JTextField textFieldAddressLine1;
    private static JTextField textFieldAddressLine2;
    private static JTextField textFieldCity;
    private static JTextField textFieldState;
    private static JTextField textFieldCountry;
    private static JTextField textFieldPostalCode;
    private static String contactID = null;
    private static Integer positionID;
    private static List<List<Object>> comboBoxModel = null;
    private static Hashtable<String, String> positionTable = null;
    private static Hashtable<String, Integer> positionIDTable = null;
    private static Hashtable<String, Integer> departmentIDTable = null;
    private static DbToolMySQL dbMySQL = DbToolMySQL.getInstance();

    /**
     * Constructor
     */
    public BusinessContactManagePanel() {
        initialize();
        addComponent();
        setContent();
        addListener();
    }

    /**
     * Set ComboBox Model
     */
    public static void setComboBoxModel() {
        try {
            HashSet<String> departmentSet = new HashSet<>();
            Integer i = 0;

            ResultSet resultSet = dbMySQL.executeStoredProcedureQuery("spGetAllPosition");
            comboBoxModel = Tools.resultSetToNestedList(resultSet);
            positionTable = new Hashtable<>();
            positionIDTable = new Hashtable<>();
            departmentIDTable = new Hashtable<>();
            for (List<Object> row : comboBoxModel) {
                comboBoxPosition.addItem(row.get(1).toString());
                departmentSet.add(row.get(3).toString());
                positionTable.put(row.get(1).toString(), row.get(3).toString());
                positionIDTable.put(row.get(1).toString(), i);
                i++;
            }

            i = 0;
            for (String department : departmentSet) {
                departmentIDTable.put(department, i);
                comboBoxDepartment.addItem(department);
                i++;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(App.businessContactManagePanel, "Exception:" + "\n" + ex.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
            logger.error("Exception: " + ex.getMessage());
        }
    }

    /**
     * Update ComboBox Model
     */
    public static void updateComboBox() {
        positionID = comboBoxPosition.getSelectedIndex() + 1;
        String department = positionTable.get(comboBoxPosition.getSelectedItem().toString());
        Integer departmentID = departmentIDTable.get(department);
        comboBoxDepartment.setSelectedIndex(departmentID);
    }

    /**
     * Set Text Field Content Create Mode
     */
    public static void setContent() {
        setComboBoxModel();
        updateComboBox();
        contactID = null;
    }

    /**
     * Set Text Field Content Update Mode
     */
    public static void setContent(ArrayList<String> selectedContact) {
        setComboBoxModel();
        positionID = positionIDTable.get(selectedContact.get(5));
        contactID = selectedContact.get(0);
        textFieldFirstName.setText(selectedContact.get(1));
        textFieldLastName.setText(selectedContact.get(2));
        textFieldBirthDate.setValue(selectedContact.get(3));
        comboBoxPosition.setSelectedIndex(positionID);
        textFieldEmailAddress.setText(selectedContact.get(7));
        textFieldTelephone.setText(selectedContact.get(8));
        textFieldBusinessTelephone.setText(selectedContact.get(9));
        textFieldAddressLine1.setText(selectedContact.get(10));
        textFieldAddressLine2.setText(selectedContact.get(11));
        textFieldCity.setText(selectedContact.get(12));
        textFieldState.setText(selectedContact.get(13));
        textFieldCountry.setText(selectedContact.get(14));
        textFieldPostalCode.setText(selectedContact.get(15));
        updateComboBox();
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
        this.add(getTopPanel(), BorderLayout.NORTH);
        this.add(getCenterPanel(), BorderLayout.CENTER);
        this.add(getBottomPanel(), BorderLayout.SOUTH);
    }

    /**
     * Get Top Panel
     *
     * @return
     */
    private JPanel getTopPanel() {
        JPanel panelTop = new JPanel();
        panelTop.setBackground(UIConsts.MAIN_BACK_COLOR);
        panelTop.setLayout(new FlowLayout(FlowLayout.LEFT, UIConsts.MAIN_H_GAP, 5));

        JLabel labelTitle = new JLabel("Manage Business Contact");
        labelTitle.setFont(UIConsts.FONT_TITLE);
        labelTitle.setForeground(UIConsts.MAIN_FONT_COLOR);
        panelTop.add(labelTitle);

        return panelTop;
    }

    /**
     * Get Center Panel
     *
     * @return
     */
    private JPanel getCenterPanel() {
        // Panel
        JPanel panelCenter = new JPanel();
        panelCenter.setBackground(UIConsts.MAIN_BACK_COLOR);
        panelCenter.setLayout(new GridLayout(1, 2));

        JPanel panelContactFieldLeft = new JPanel();
        panelContactFieldLeft.setLayout(new GridLayout(10, 1));
        panelContactFieldLeft.setBackground(UIConsts.MAIN_BACK_COLOR);
        JPanel panelContactFieldRight = new JPanel();
        panelContactFieldRight.setLayout(new GridLayout(10, 1));
        panelContactFieldRight.setBackground(UIConsts.MAIN_BACK_COLOR);

        // Component
        JLabel labelFirstName = new JLabel("First Name:");
        JLabel labelLastName = new JLabel("Last Name:");
        JLabel labelBirthDate = new JLabel("Birth Date:");
        JLabel labelEmailAddress = new JLabel("Email Address:");
        JLabel labelPosition = new JLabel("Position:");
        JLabel labelDepartment = new JLabel("Department:");
        JLabel labelTelephone = new JLabel("Telephone:");
        JLabel labelBusinessTelephone = new JLabel("Telephone(B):");
        JLabel labelAddressLine1 = new JLabel("Address Line1:");
        JLabel labelAddressLine2 = new JLabel("Address Line2:");
        JLabel labelCity = new JLabel("City:");
        JLabel labelState = new JLabel("State:");
        JLabel labelCountry = new JLabel("Country:");
        JLabel labelPostalCode = new JLabel("Postal Code:");

        textFieldFirstName = new JTextField();
        textFieldLastName = new JTextField();
        textFieldBirthDate = new JFormattedDateTextField();
        textFieldEmailAddress = new JTextField();
        comboBoxPosition = new JComboBox<String>();
        comboBoxPosition.setEditable(false);
        comboBoxDepartment = new JComboBox<String>();
        comboBoxDepartment.setEditable(false);
        comboBoxDepartment.setEnabled(false);
        textFieldTelephone = new JTextField();
        textFieldBusinessTelephone = new JTextField();
        textFieldAddressLine1 = new JTextField();
        textFieldAddressLine2 = new JTextField();
        textFieldCity = new JTextField();
        textFieldState = new JTextField();
        textFieldCountry = new JTextField();
        textFieldPostalCode = new JTextField();

        // Font
        labelFirstName.setFont(UIConsts.FONT_NORMAL);
        labelLastName.setFont(UIConsts.FONT_NORMAL);
        labelBirthDate.setFont(UIConsts.FONT_NORMAL);
        labelEmailAddress.setFont(UIConsts.FONT_NORMAL);
        labelPosition.setFont(UIConsts.FONT_NORMAL);
        labelDepartment.setFont(UIConsts.FONT_NORMAL);
        labelTelephone.setFont(UIConsts.FONT_NORMAL);
        labelBusinessTelephone.setFont(UIConsts.FONT_NORMAL);
        labelAddressLine1.setFont(UIConsts.FONT_NORMAL);
        labelAddressLine2.setFont(UIConsts.FONT_NORMAL);
        labelCity.setFont(UIConsts.FONT_NORMAL);
        labelState.setFont(UIConsts.FONT_NORMAL);
        labelCountry.setFont(UIConsts.FONT_NORMAL);
        labelPostalCode.setFont(UIConsts.FONT_NORMAL);

        textFieldFirstName.setFont(UIConsts.FONT_NORMAL);
        textFieldLastName.setFont(UIConsts.FONT_NORMAL);
        textFieldBirthDate.setFont(UIConsts.FONT_NORMAL);
        textFieldEmailAddress.setFont(UIConsts.FONT_NORMAL);
        comboBoxPosition.setFont(UIConsts.FONT_NORMAL);
        comboBoxDepartment.setFont(UIConsts.FONT_NORMAL);
        textFieldTelephone.setFont(UIConsts.FONT_NORMAL);
        textFieldBusinessTelephone.setFont(UIConsts.FONT_NORMAL);
        textFieldAddressLine1.setFont(UIConsts.FONT_NORMAL);
        textFieldAddressLine2.setFont(UIConsts.FONT_NORMAL);
        textFieldCity.setFont(UIConsts.FONT_NORMAL);
        textFieldState.setFont(UIConsts.FONT_NORMAL);
        textFieldCountry.setFont(UIConsts.FONT_NORMAL);
        textFieldPostalCode.setFont(UIConsts.FONT_NORMAL);

        // Size
        labelFirstName.setPreferredSize(UIConsts.LABLE_SIZE_ITEM);
        labelLastName.setPreferredSize(UIConsts.LABLE_SIZE_ITEM);
        labelBirthDate.setPreferredSize(UIConsts.LABLE_SIZE_ITEM);
        labelEmailAddress.setPreferredSize(UIConsts.LABLE_SIZE_ITEM);
        labelPosition.setPreferredSize(UIConsts.LABLE_SIZE_ITEM);
        labelDepartment.setPreferredSize(UIConsts.LABLE_SIZE_ITEM);
        labelTelephone.setPreferredSize(UIConsts.LABLE_SIZE_ITEM);
        labelBusinessTelephone.setPreferredSize(UIConsts.LABLE_SIZE_ITEM);
        labelAddressLine1.setPreferredSize(UIConsts.LABLE_SIZE_ITEM);
        labelAddressLine2.setPreferredSize(UIConsts.LABLE_SIZE_ITEM);
        labelCity.setPreferredSize(UIConsts.LABLE_SIZE_ITEM);
        labelCountry.setPreferredSize(UIConsts.LABLE_SIZE_ITEM);
        labelState.setPreferredSize(UIConsts.LABLE_SIZE_ITEM);
        labelPostalCode.setPreferredSize(UIConsts.LABLE_SIZE_ITEM);

        textFieldFirstName.setPreferredSize(UIConsts.TEXT_FIELD_SIZE_ITEM);
        textFieldLastName.setPreferredSize(UIConsts.TEXT_FIELD_SIZE_ITEM);
        textFieldBirthDate.setPreferredSize(UIConsts.TEXT_FIELD_SIZE_ITEM);
        textFieldEmailAddress.setPreferredSize(UIConsts.TEXT_FIELD_SIZE_ITEM);
        comboBoxPosition.setPreferredSize(UIConsts.TEXT_FIELD_SIZE_ITEM);
        comboBoxDepartment.setPreferredSize(UIConsts.TEXT_FIELD_SIZE_ITEM);
        textFieldTelephone.setPreferredSize(UIConsts.TEXT_FIELD_SIZE_ITEM);
        textFieldBusinessTelephone.setPreferredSize(UIConsts.TEXT_FIELD_SIZE_ITEM);
        textFieldAddressLine1.setPreferredSize(UIConsts.TEXT_FIELD_SIZE_ITEM);
        textFieldAddressLine2.setPreferredSize(UIConsts.TEXT_FIELD_SIZE_ITEM);
        textFieldCity.setPreferredSize(UIConsts.TEXT_FIELD_SIZE_ITEM);
        textFieldState.setPreferredSize(UIConsts.TEXT_FIELD_SIZE_ITEM);
        textFieldCountry.setPreferredSize(UIConsts.TEXT_FIELD_SIZE_ITEM);
        textFieldPostalCode.setPreferredSize(UIConsts.TEXT_FIELD_SIZE_ITEM);

        // Combine Components
        JPanel panelContactFieldLeftRow1 = new JPanel();
        panelContactFieldLeftRow1.setBackground(UIConsts.MAIN_BACK_COLOR);
        panelContactFieldLeftRow1.setLayout(new FlowLayout(FlowLayout.LEFT, UIConsts.MAIN_H_GAP, 0));
        panelContactFieldLeftRow1.add(labelFirstName);
        panelContactFieldLeftRow1.add(textFieldFirstName);
        JPanel panelContactFieldRightRow1 = new JPanel();
        panelContactFieldRightRow1.setBackground(UIConsts.MAIN_BACK_COLOR);
        panelContactFieldRightRow1.setLayout(new FlowLayout(FlowLayout.LEFT, UIConsts.MAIN_H_GAP, 0));
        panelContactFieldRightRow1.add(labelLastName);
        panelContactFieldRightRow1.add(textFieldLastName);
        JPanel panelContactFieldLeftRow2 = new JPanel();
        panelContactFieldLeftRow2.setBackground(UIConsts.MAIN_BACK_COLOR);
        panelContactFieldLeftRow2.setLayout(new FlowLayout(FlowLayout.LEFT, UIConsts.MAIN_H_GAP, 0));
        panelContactFieldLeftRow2.add(labelBirthDate);
        panelContactFieldLeftRow2.add(textFieldBirthDate);
        JPanel panelContactFieldRightRow2 = new JPanel();
        panelContactFieldRightRow2.setBackground(UIConsts.MAIN_BACK_COLOR);
        panelContactFieldRightRow2.setLayout(new FlowLayout(FlowLayout.LEFT, UIConsts.MAIN_H_GAP, 0));
        panelContactFieldRightRow2.add(labelEmailAddress);
        panelContactFieldRightRow2.add(textFieldEmailAddress);
        JPanel panelContactFieldLeftRow3 = new JPanel();
        panelContactFieldLeftRow3.setBackground(UIConsts.MAIN_BACK_COLOR);
        panelContactFieldLeftRow3.setLayout(new FlowLayout(FlowLayout.LEFT, UIConsts.MAIN_H_GAP, 0));
        panelContactFieldLeftRow3.add(labelPosition);
        panelContactFieldLeftRow3.add(comboBoxPosition);
        JPanel panelContactFieldRightRow3 = new JPanel();
        panelContactFieldRightRow3.setBackground(UIConsts.MAIN_BACK_COLOR);
        panelContactFieldRightRow3.setLayout(new FlowLayout(FlowLayout.LEFT, UIConsts.MAIN_H_GAP, 0));
        panelContactFieldRightRow3.add(labelDepartment);
        panelContactFieldRightRow3.add(comboBoxDepartment);
        JPanel panelContactFieldLeftRow4 = new JPanel();
        panelContactFieldLeftRow4.setBackground(UIConsts.MAIN_BACK_COLOR);
        panelContactFieldLeftRow4.setLayout(new FlowLayout(FlowLayout.LEFT, UIConsts.MAIN_H_GAP, 0));
        panelContactFieldLeftRow4.add(labelTelephone);
        panelContactFieldLeftRow4.add(textFieldTelephone);
        JPanel panelContactFieldRightRow4 = new JPanel();
        panelContactFieldRightRow4.setBackground(UIConsts.MAIN_BACK_COLOR);
        panelContactFieldRightRow4.setLayout(new FlowLayout(FlowLayout.LEFT, UIConsts.MAIN_H_GAP, 0));
        panelContactFieldRightRow4.add(labelBusinessTelephone);
        panelContactFieldRightRow4.add(textFieldBusinessTelephone);
        JPanel panelContactFieldLeftRow5 = new JPanel();
        panelContactFieldLeftRow5.setBackground(UIConsts.MAIN_BACK_COLOR);
        panelContactFieldLeftRow5.setLayout(new FlowLayout(FlowLayout.LEFT, UIConsts.MAIN_H_GAP, 0));
        panelContactFieldLeftRow5.add(labelAddressLine1);
        panelContactFieldLeftRow5.add(textFieldAddressLine1);
        JPanel panelContactFieldRightRow5 = new JPanel();
        panelContactFieldRightRow5.setBackground(UIConsts.MAIN_BACK_COLOR);
        panelContactFieldRightRow5.setLayout(new FlowLayout(FlowLayout.LEFT, UIConsts.MAIN_H_GAP, 0));
        panelContactFieldRightRow5.add(labelAddressLine2);
        panelContactFieldRightRow5.add(textFieldAddressLine2);
        JPanel panelContactFieldLeftRow6 = new JPanel();
        panelContactFieldLeftRow6.setBackground(UIConsts.MAIN_BACK_COLOR);
        panelContactFieldLeftRow6.setLayout(new FlowLayout(FlowLayout.LEFT, UIConsts.MAIN_H_GAP, 0));
        panelContactFieldLeftRow6.add(labelCity);
        panelContactFieldLeftRow6.add(textFieldCity);
        JPanel panelContactFieldRightRow6 = new JPanel();
        panelContactFieldRightRow6.setBackground(UIConsts.MAIN_BACK_COLOR);
        panelContactFieldRightRow6.setLayout(new FlowLayout(FlowLayout.LEFT, UIConsts.MAIN_H_GAP, 0));
        panelContactFieldRightRow6.add(labelState);
        panelContactFieldRightRow6.add(textFieldState);
        JPanel panelContactFieldLeftRow7 = new JPanel();
        panelContactFieldLeftRow7.setBackground(UIConsts.MAIN_BACK_COLOR);
        panelContactFieldLeftRow7.setLayout(new FlowLayout(FlowLayout.LEFT, UIConsts.MAIN_H_GAP, 0));
        panelContactFieldLeftRow7.add(labelCountry);
        panelContactFieldLeftRow7.add(textFieldCountry);
        JPanel panelContactFieldRightRow7 = new JPanel();
        panelContactFieldRightRow7.setBackground(UIConsts.MAIN_BACK_COLOR);
        panelContactFieldRightRow7.setLayout(new FlowLayout(FlowLayout.LEFT, UIConsts.MAIN_H_GAP, 0));
        panelContactFieldRightRow7.add(labelPostalCode);
        panelContactFieldRightRow7.add(textFieldPostalCode);

        panelContactFieldLeft.add(panelContactFieldLeftRow1);
        panelContactFieldLeft.add(panelContactFieldLeftRow2);
        panelContactFieldLeft.add(panelContactFieldLeftRow3);
        panelContactFieldLeft.add(panelContactFieldLeftRow4);
        panelContactFieldLeft.add(panelContactFieldLeftRow5);
        panelContactFieldLeft.add(panelContactFieldLeftRow6);
        panelContactFieldLeft.add(panelContactFieldLeftRow7);
        panelContactFieldRight.add(panelContactFieldRightRow1);
        panelContactFieldRight.add(panelContactFieldRightRow2);
        panelContactFieldRight.add(panelContactFieldRightRow3);
        panelContactFieldRight.add(panelContactFieldRightRow4);
        panelContactFieldRight.add(panelContactFieldRightRow5);
        panelContactFieldRight.add(panelContactFieldRightRow6);
        panelContactFieldRight.add(panelContactFieldRightRow7);

        panelCenter.add(panelContactFieldLeft);
        panelCenter.add(panelContactFieldRight);

        return panelCenter;
    }

    /**
     * Get Bottom Panel
     *
     * @return
     */
    private JPanel getBottomPanel() {
        JPanel panelBottom = new JPanel();
        panelBottom.setBackground(UIConsts.MAIN_BACK_COLOR);
        panelBottom.setLayout(new FlowLayout(FlowLayout.RIGHT, UIConsts.MAIN_H_GAP, 15));

        buttonTestLink = new IconButton(UIConsts.ICON_TEST, UIConsts.ICON_TEST_ENABLE,
                UIConsts.ICON_TEST, "");
        buttonSave = new IconButton(UIConsts.ICON_SAVE, UIConsts.ICON_SAVE_ENABLE,
                UIConsts.ICON_SAVE, "");
        panelBottom.add(buttonTestLink);
        panelBottom.add(buttonSave);

        return panelBottom;
    }

    /**
     * Validate User Input
     */
    private boolean validateInput() {
        boolean isValid = true;
        if (textFieldFirstName.getText().isEmpty() || textFieldLastName.getText().isEmpty() ||
                textFieldEmailAddress.getText().isEmpty() || textFieldTelephone.getText().isEmpty() ||
                textFieldBusinessTelephone.getText().isEmpty() || textFieldAddressLine1.getText().isEmpty() ||
                textFieldAddressLine2.getText().isEmpty() || textFieldCity.getText().isEmpty() ||
                textFieldState.getText().isEmpty() || textFieldCountry.getText().isEmpty() ||
                textFieldPostalCode.getText().isEmpty()
        ) {
            isValid = false;
            JOptionPane.showMessageDialog(App.businessContactManagePanel, "Please fill in all required fields",
                    "Warning", JOptionPane.WARNING_MESSAGE);
        }
        if (textFieldBirthDate.toDate() == null) {
            isValid = false;
            JOptionPane.showMessageDialog(App.businessContactManagePanel, "Invalid Date",
                    "Warning", JOptionPane.WARNING_MESSAGE);
        }

        return isValid;
    }

    /**
     * Add Listener
     */
    private void addListener() {
        comboBoxPosition.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    updateComboBox();
                }
            }
        });

        buttonSave.addActionListener(e -> {
            if (validateInput()) {
                if (contactID == null) {
                    // Add new contact
                    try {
                        String[] params = new String[]{
                                textFieldFirstName.getText(), textFieldLastName.getText(), textFieldBirthDate.getValue(),
                                positionID.toString(), String.valueOf(comboBoxDepartment.getSelectedIndex() + 1),
                                textFieldEmailAddress.getText(), textFieldTelephone.getText(), textFieldBusinessTelephone.getText(),
                                textFieldAddressLine1.getText(), textFieldAddressLine2.getText(), textFieldCity.getText(),
                                textFieldState.getText(), textFieldCountry.getText(), textFieldPostalCode.getText()
                        };
                        dbMySQL.executeStoredProcedureUpdate("spAddBusinessContact", params);
                        JOptionPane.showMessageDialog(App.businessContactManagePanel, "Contact Saved",
                                "Success", JOptionPane.PLAIN_MESSAGE);
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(App.businessContactManagePanel, "Exception:" + "\n" + ex.getMessage(),
                                "Error", JOptionPane.ERROR_MESSAGE);
                        logger.error("Exception: " + ex.getMessage());
                    }
                } else {
                    // Update existing contact
                    try {
                        String[] params = new String[]{
                                contactID,
                                textFieldFirstName.getText(), textFieldLastName.getText(), textFieldBirthDate.getValue(),
                                positionID.toString(), String.valueOf(comboBoxDepartment.getSelectedIndex() + 1),
                                textFieldEmailAddress.getText(), textFieldTelephone.getText(), textFieldBusinessTelephone.getText(),
                                textFieldAddressLine1.getText(), textFieldAddressLine2.getText(), textFieldCity.getText(),
                                textFieldState.getText(), textFieldCountry.getText(), textFieldPostalCode.getText()
                        };
                        dbMySQL.executeStoredProcedureUpdate("spUpdateBusinessContact", params);
                        JOptionPane.showMessageDialog(App.businessContactManagePanel, "Contact Updated",
                                "Success", JOptionPane.PLAIN_MESSAGE);
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(App.businessContactManagePanel, "Exception:" + "\n" + ex.getMessage(),
                                "Error", JOptionPane.ERROR_MESSAGE);
                        logger.error("Exception: " + ex.getMessage());
                    }
                }
            }
        });

        buttonTestLink.addActionListener(e -> {
            try {
                Connection conn = dbMySQL.testConnection();
                if (conn == null) {
                    JOptionPane.showMessageDialog(App.personalContactManagePanel, "Disconnected", "Error",
                            JOptionPane.ERROR_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(App.personalContactManagePanel, "Connected To Database", "Success",
                            JOptionPane.PLAIN_MESSAGE);
                }

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(App.personalContactManagePanel, "Database Connection Exception:" + "\n" + ex.getMessage(), "Error",
                        JOptionPane.ERROR_MESSAGE);
                logger.error("Exception: " + ex.getMessage());
            }
        });
    }
}



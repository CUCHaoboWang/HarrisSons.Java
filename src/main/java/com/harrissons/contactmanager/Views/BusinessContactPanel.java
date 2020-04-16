package com.harrissons.contactmanager.Views;

import com.harrissons.contactmanager.App;
import com.harrissons.contactmanager.Helpers.DbToolMySQL;
import com.harrissons.contactmanager.Helpers.Tools;
import com.harrissons.contactmanager.Models.UIConsts;
import com.harrissons.contactmanager.Views.Components.IconButton;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.*;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Business Contact Panel
 *
 * @author Bob
 */
public class BusinessContactPanel extends JPanel {

    private static final long serialVersionUID = 1L;
    private static final Logger logger = LoggerFactory.getLogger(BusinessContactPanel.class);
    public static JTable tableContact;
    private static IconButton buttonAddContact;
    private static IconButton buttonEditContact;
    private static IconButton buttonDeleteContact;
    private static IconButton buttonRefreshContact;
    private static IconButton buttonSearchContact;
    private static JTextField textFieldSearch;
    private static TableModel tableModel;
    private static String contactID;
    private static String addressID;
    private static DbToolMySQL dbMySQL = DbToolMySQL.getInstance();

    /**
     * Constructor
     */
    public BusinessContactPanel() {
        initialize();
        addComponent();
        addListener();
        initializeTableData();
    }

    public static void initializeTableData() {
        try {
            ResultSet resultSet = dbMySQL.executeStoredProcedureQuery("spGetAllViewBusinessContactDetail");
            tableModel = Tools.resultSetToTableModel(resultSet);
            tableContact.setModel(tableModel);
        } catch (SQLException ex) {
            ex.printStackTrace();
            logger.error("Exception: " + ex.getMessage());
        }
    }

    /**
     * Initialize Panel
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

        JLabel labelTitle = new JLabel("Business Contacts");
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
        JPanel panelCenter = new JPanel();
        panelCenter.setBackground(UIConsts.MAIN_BACK_COLOR);
        panelCenter.setLayout(new GridLayout(1, 1));

        panelCenter.add(getContactTable());

        return panelCenter;
    }

    /**
     * Get Business Contact Table
     *
     * @return
     */
    private JPanel getContactTable() {
        JPanel panelContact = new JPanel();
        panelContact.setBackground(UIConsts.MAIN_BACK_COLOR);
        panelContact.setLayout(new BorderLayout());

        JPanel panelContactControl = new JPanel();
        panelContactControl.setLayout(new GridLayout(1, 2));
        JPanel panelContactTable = new JPanel();
        panelContactTable.setLayout(new BorderLayout());

        JPanel panelContactControlLeft = new JPanel();
        panelContactControlLeft.setLayout(new FlowLayout(FlowLayout.LEFT, UIConsts.MAIN_H_GAP, 5));
        panelContactControlLeft.setBackground(UIConsts.MAIN_BACK_COLOR);
        JPanel panelContactControlRight = new JPanel();
        panelContactControlRight.setLayout(new FlowLayout(FlowLayout.RIGHT, UIConsts.MAIN_H_GAP, 5));
        panelContactControlRight.setBackground(UIConsts.MAIN_BACK_COLOR);

        buttonAddContact = new IconButton(UIConsts.ICON_ADD, UIConsts.ICON_ADD_ENABLE,
                UIConsts.ICON_ADD, "");
        buttonEditContact = new IconButton(UIConsts.ICON_EDIT,
                UIConsts.ICON_EDIT_ENABLE, UIConsts.ICON_EDIT, "");
        buttonDeleteContact = new IconButton(UIConsts.ICON_DELETE,
                UIConsts.ICON_DELETE_ENABLE, UIConsts.ICON_DELETE, "");
        buttonRefreshContact = new IconButton(UIConsts.ICON_REFRESH,
                UIConsts.ICON_REFRESH_ENABLE, UIConsts.ICON_REFRESH, "");
        panelContactControlLeft.add(buttonAddContact);
        panelContactControlLeft.add(buttonEditContact);
        panelContactControlLeft.add(buttonDeleteContact);
        panelContactControlLeft.add(buttonRefreshContact);

        textFieldSearch = new JTextField();
        textFieldSearch.setFont(UIConsts.FONT_NORMAL);
        textFieldSearch.setPreferredSize(UIConsts.TEXT_SEARCH_FIELD_SIZE_ITEM);
        buttonSearchContact = new IconButton(UIConsts.ICON_SEARCH,
                UIConsts.ICON_SEARCH_ENABLE, UIConsts.ICON_SEARCH, "");
        panelContactControlRight.add(textFieldSearch);
        panelContactControlRight.add(buttonSearchContact);

        panelContactControl.add(panelContactControlLeft);
        panelContactControl.add(panelContactControlRight);

        panelContact.add(panelContactControl, BorderLayout.NORTH);

        // Initialize Table Components

        tableContact = new JTable();
        tableContact.setFont(UIConsts.FONT_NORMAL);
        tableContact.getTableHeader().setFont(UIConsts.FONT_NORMAL);
        tableContact.getTableHeader().setBackground(UIConsts.TOOLBAR_BACK_COLOR);
        tableContact.setRowHeight(31);
        tableContact.setGridColor(UIConsts.TABLE_LINE_COLOR);
        tableContact.setSelectionBackground(UIConsts.LIST_BACK_COLOR);

        JScrollPane panelScroll = new JScrollPane(tableContact);
        panelScroll.setBackground(UIConsts.MAIN_BACK_COLOR);
        panelContact.add(panelScroll, BorderLayout.CENTER);

        return panelContact;
    }

    private void addListener() {
        tableContact.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (tableContact.getSelectedRowCount() > 0) {
                    int row = tableContact.getSelectedRow();
                    contactID = tableContact.getValueAt(row, 0).toString();
                }
            }
        });

        buttonAddContact.addActionListener(e -> {
            NavBarPanel.SwitchToBusinessContactManagePanel();
        });

        buttonEditContact.addActionListener(e -> {
            if (tableContact.getSelectedRowCount() > 0) {
                ArrayList<String> selectedContact = new ArrayList<String>();
                int row = tableContact.getSelectedRow();
                for (int i = 0; i < tableContact.getColumnCount(); i++) {
                    selectedContact.add(tableContact.getValueAt(row, i).toString());
                }
                NavBarPanel.SwitchToBusinessContactManagePanel();
                BusinessContactManagePanel.setContent(selectedContact);
            } else {
                JOptionPane.showMessageDialog(App.businessContactPanel,
                        "Nothing Selected",
                        "Warning", JOptionPane.WARNING_MESSAGE);
            }
        });

        buttonDeleteContact.addActionListener(e -> {
            if (tableContact.getSelectedRowCount() > 0) {
                int answer = JOptionPane.showConfirmDialog(App.businessContactPanel,
                        "Are you sure to delete this contact?",
                        "Warning", 2);
                if (answer == 0) {
                    try {
                        ResultSet resultSet = dbMySQL.executeStoredProcedureQuery("spGetBusinessAddressID", new String[]{contactID});
                        while (resultSet.next()) {
                            addressID = resultSet.getString("AddressID");
                        }
                        dbMySQL.executeStoredProcedureUpdate("spDeleteAddress", new String[]{addressID});
                        initializeTableData();
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                        JOptionPane.showMessageDialog(App.businessContactPanel,
                                "Exception:" + "\n" + ex.getMessage(),
                                "Error", JOptionPane.ERROR_MESSAGE);
                        logger.error("Exception: " + ex.getMessage());
                    }
                }
            } else {
                JOptionPane.showMessageDialog(App.businessContactPanel,
                        "Nothing Selected",
                        "Warning", JOptionPane.WARNING_MESSAGE);
            }
        });

        buttonSearchContact.addActionListener(e -> {
            String text = textFieldSearch.getText();
            if (text.isEmpty()) {
                JOptionPane.showMessageDialog(App.businessContactPanel,
                        "Nothing Entered",
                        "Warning", JOptionPane.WARNING_MESSAGE);
            } else {
                try {
                    ResultSet resultSet = dbMySQL.executeStoredProcedureQuery("spSearchBusinessContact", new String[]{text});
                    tableModel = Tools.resultSetToTableModel(resultSet);
                    tableContact.setModel(tableModel);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    logger.error("Exception: " + ex.getMessage());
                }
            }
        });

        buttonRefreshContact.addActionListener(e -> {
            initializeTableData();
        });
    }
}

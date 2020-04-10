package com.harrissons.contactmanager.Models;

import com.harrissons.contactmanager.App;

import javax.swing.*;
import java.awt.*;

/**
 * UI Constants
 *
 * @author Bob
 */
public class UIConsts {

    /**
     * App Name App Version
     */
    public final static String APP_NAME = "Contact Manager";
    public final static String APP_VERSION = "v_1.0";

    /**
     * Main Window Size
     */
    public final static int MAIN_WINDOW_X = 240;
    public final static int MAIN_WINDOW_Y = 100;
    public final static int MAIN_WINDOW_WIDTH = 1280;
    public final static int MAIN_WINDOW_HEIGHT = 720;

    /**
     * System Path
     */
    public final static String CURRENT_DIR = System.getProperty("user.dir");

    /**
     * Main Frame Icon
     */
    public final static Image IMAGE_ICON = Toolkit.getDefaultToolkit()
            .getImage(App.class.getResource("/icon/HarrisSons.png"));

    /**
     * Main Font Color
     */
    public final static Color MAIN_FONT_COLOR = new Color(40, 40, 40);

    /**
     * Main Back Color
     */
    public final static Color MAIN_BACK_COLOR = Color.WHITE;

    /**
     * List Background Color
     */
    public final static Color LIST_BACK_COLOR = new Color(120, 120, 120);

    /**
     * Label Background Color
     */
    public final static Color LABEL_BACK_COLOR = new Color(160, 160, 160);

    /**
     * Toolbar Background Color
     */
    public final static Color TOOLBAR_BACK_COLOR = new Color(200, 200, 200);

    /**
     * Table Grid Line Color
     */
    public final static Color TABLE_LINE_COLOR = new Color(80, 80, 80);

    // Font
    /**
     * Title Font
     */
    public final static Font FONT_TITLE = new Font(Font.SANS_SERIF, 0, 24);
    /**
     * Normal Font
     */
    public final static Font FONT_NORMAL = new Font(Font.SANS_SERIF, 0, 14);
    /**
     * List Font
     */
    public final static Font FONT_LIST = new Font(Font.SANS_SERIF, 0, 18);

    /**
     * Main Icon
     */
    public final static ImageIcon ICON_CONTACT_MANAGER = new ImageIcon(
            App.class.getResource("/icon/HarrisSons.png"));
    // Toolbar Icon
    /**
     * View Personal Contact Default
     */
    public final static ImageIcon ICON_VIEW_PERSONAL_CONTACT = new ImageIcon(
            App.class.getResource("/icon/icons8-personal-contact-48.png"));
    /**
     * View Personal Contact Enable
     */
    public final static ImageIcon ICON_VIEW_PERSONAL_CONTACT_ENABLE = new ImageIcon(
            App.class.getResource("/icon/icons8-personal-contact-48-enable.png"));
    /**
     * Manage Personal Contact Default
     */
    public final static ImageIcon ICON_MANAGE_PERSONAL_CONTACT = new ImageIcon(
            App.class.getResource("/icon/icons8-personal-contact-manage-48.png"));
    /**
     * Manage Personal Contact Enable
     */
    public final static ImageIcon ICON_MANAGE_PERSONAL_CONTACT_ENABLE = new ImageIcon(
            App.class.getResource("/icon/icons8-personal-contact-manage-48-enable.png"));
    /**
     * View Business Contact Default
     */
    public final static ImageIcon ICON_VIEW_BUSINESS_CONTACT = new ImageIcon(
            App.class.getResource("/icon/icons8-business-contact-48.png"));
    /**
     * View Business Contact Enable
     */
    public final static ImageIcon ICON_VIEW_BUSINESS_CONTACT_ENABLE = new ImageIcon(
            App.class.getResource("/icon/icons8-business-contact-48-enable.png"));
    /**
     * Manage Business Contact Default
     */
    public final static ImageIcon ICON_MANAGE_BUSINESS_CONTACT = new ImageIcon(
            App.class.getResource("/icon/icons8-business-contact-manage-48.png"));
    /**
     * Manage Business Contact Enable
     */
    public final static ImageIcon ICON_MANAGE_BUSINESS_CONTACT_ENABLE = new ImageIcon(
            App.class.getResource("/icon/icons8-business-contact-manage-48-enable.png"));
    /**
     * Setting Default
     */
    public final static ImageIcon ICON_SETTING = new ImageIcon(
            App.class.getResource("/icon/icons8-settings-48.png"));
    /**
     * Setting Enable
     */
    public final static ImageIcon ICON_SETTING_ENABLE = new ImageIcon(
            App.class.getResource("/icon/icons8-settings-48-enable.png"));
    /**
     * Add Default
     */
    public final static ImageIcon ICON_ADD = new ImageIcon(
            App.class.getResource("/icon/button-add.png"));
    /**
     * Add Enable
     */
    public final static ImageIcon ICON_ADD_ENABLE = new ImageIcon(
            App.class.getResource("/icon/button-add-enable.png"));
    /**
     * Edit Default
     */
    public final static ImageIcon ICON_EDIT = new ImageIcon(
            App.class.getResource("/icon/button-edit.png"));
    /**
     * Edit Enable
     */
    public final static ImageIcon ICON_EDIT_ENABLE = new ImageIcon(
            App.class.getResource("/icon/button-edit-enable.png"));
    /**
     * Delete Default
     */
    public final static ImageIcon ICON_DELETE = new ImageIcon(
            App.class.getResource("/icon/button-delete.png"));
    /**
     * Delete Enable
     */
    public final static ImageIcon ICON_DELETE_ENABLE = new ImageIcon(
            App.class.getResource("/icon/button-delete-enable.png"));
    /**
     * Search Default
     */
    public final static ImageIcon ICON_SEARCH = new ImageIcon(
            App.class.getResource("/icon/button-search.png"));
    /**
     * Search Enable
     */
    public final static ImageIcon ICON_SEARCH_ENABLE = new ImageIcon(
            App.class.getResource("/icon/button-search-enable.png"));
    /**
     * Refresh Default
     */
    public final static ImageIcon ICON_REFRESH = new ImageIcon(
            App.class.getResource("/icon/button-refresh.png"));
    /**
     * Refresh Enable
     */
    public final static ImageIcon ICON_REFRESH_ENABLE = new ImageIcon(
            App.class.getResource("/icon/button-refresh-enable.png"));
    /**
     * Save Default
     */
    public final static ImageIcon ICON_SAVE = new ImageIcon(
            App.class.getResource("/icon/button-save.png"));
    /**
     * Save Enable
     */
    public final static ImageIcon ICON_SAVE_ENABLE = new ImageIcon(
            App.class.getResource("/icon/button-save-enable.png"));
    /**
     * Test Default
     */
    public final static ImageIcon ICON_TEST = new ImageIcon(
            App.class.getResource("/icon/button-test.png"));
    /**
     * Test Enable
     */
    public final static ImageIcon ICON_TEST_ENABLE = new ImageIcon(
            App.class.getResource("/icon/button-test-enable.png"));
    /**
     * Open Backup Default
     */
    public final static ImageIcon ICON_OPEN_BACKUP = new ImageIcon(
            App.class.getResource("/icon/button-openbackups.png"));
    /**
     * Open Backup Enable
     */
    public final static ImageIcon ICON_OPEN_BACKUP_ENABLE = new ImageIcon(
            App.class.getResource("/icon/button-openbackups-enable.png"));
    /**
     * Clear Backup Default
     */
    public final static ImageIcon ICON_CLEAR_BACKUP = new ImageIcon(
            App.class.getResource("/icon/button-clearbackups.png"));
    /**
     * Clear Backup Enable
     */
    public final static ImageIcon ICON_CLEAR_BACKUP_ENABLE = new ImageIcon(
            App.class.getResource("/icon/button-clearbackups-enable.png"));
    /**
     * Open Log Default
     */
    public final static ImageIcon ICON_OPEN_LOG = new ImageIcon(
            App.class.getResource("/icon/button-openlogs.png"));
    /**
     * Open Log Enable
     */
    public final static ImageIcon ICON_OPEN_LOG_ENABLE = new ImageIcon(
            App.class.getResource("/icon/button-openlogs-enable.png"));
    /**
     * Clear Log Default
     */
    public final static ImageIcon ICON_CLEAR_LOG = new ImageIcon(
            App.class.getResource("/icon/button-clearlogs.png"));
    /**
     * Clear Log Enable
     */
    public final static ImageIcon ICON_CLEAR_LOG_ENABLE = new ImageIcon(
            App.class.getResource("/icon/button-clearlogs-enable.png"));


    // Frame Layout
    /**
     * Main Frame Horizontal Gap
     */
    public final static int MAIN_H_GAP = 25;
    /**
     * Main Frame Label Size
     */
    public final static Dimension LABLE_SIZE = new Dimension(1300, 30);
    /**
     * Item Label Size
     */
    public final static Dimension LABLE_SIZE_ITEM = new Dimension(100, 30);
    /**
     * Item Label Size
     */
    public final static Dimension LABLE_SIZE_LARGE_ITEM = new Dimension(200, 30);
    /**
     * Item Text Field Size
     */
    public final static Dimension TEXT_FIELD_SIZE_ITEM = new Dimension(400, 30);
    /**
     * Item Text Field Size
     */
    public final static Dimension TEXT_SEARCH_FIELD_SIZE_ITEM = new Dimension(200, 24);
    /**
     * Radio Size
     */
    public final static Dimension RADIO_SIZE = new Dimension(1300, 60);
    /**
     * Item Panel Size
     */
    public final static Dimension PANEL_ITEM_SIZE = new Dimension(1300, 40);
}

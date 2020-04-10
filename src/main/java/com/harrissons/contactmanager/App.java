package com.harrissons.contactmanager;

import com.harrissons.contactmanager.Models.UIConsts;
import com.harrissons.contactmanager.Views.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

/**
 * Application Main Entrance，Main Frame
 *
 * @author Bob
 */
public class App {
    private static final Logger logger = LoggerFactory.getLogger(App.class);
    public static JPanel mainPanelCenter;
    public static PersonalContactPanel personalContactPanel;
    public static PersonalContactManagePanel personalContactManagePanel;
    public static BusinessContactPanel businessContactPanel;
    public static BusinessContactManagePanel businessContactManagePanel;
    public static SettingPanel settingPanel;
    public static NavBarPanel navBarPanel;
    private JFrame frame;

    /**
     * Constructor
     */
    public App() {
        initialize();
    }

    /**
     * Application Main Entrance
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                App window = new App();
                window.frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    /**
     * Initialize Frame Content
     */
    private void initialize() {
        logger.info("==================AppInitStart");
        // Set System Look and Feel
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        // Initialize Main Frame
        frame = new JFrame();
        frame.setBounds(UIConsts.MAIN_WINDOW_X, UIConsts.MAIN_WINDOW_Y, UIConsts.MAIN_WINDOW_WIDTH, UIConsts.MAIN_WINDOW_HEIGHT);
        frame.setTitle(UIConsts.APP_NAME);
        frame.setIconImage(UIConsts.IMAGE_ICON);
        frame.setBackground(UIConsts.MAIN_BACK_COLOR);
        JPanel mainPanel = new JPanel(true);
        mainPanel.setBackground(Color.white);
        mainPanel.setLayout(new BorderLayout());

        navBarPanel = new NavBarPanel();
        personalContactPanel = new PersonalContactPanel();
        personalContactManagePanel = new PersonalContactManagePanel();
        businessContactPanel = new BusinessContactPanel();
        businessContactManagePanel = new BusinessContactManagePanel();
        settingPanel = new SettingPanel();

        mainPanel.add(navBarPanel, BorderLayout.WEST);
        mainPanelCenter = new JPanel(true);
        mainPanelCenter.setLayout(new BorderLayout());
        mainPanelCenter.add(personalContactPanel, BorderLayout.CENTER);
        mainPanel.add(mainPanelCenter, BorderLayout.CENTER);

        frame.add(mainPanel);

        frame.addWindowListener(new WindowListener() {

            @Override
            public void windowOpened(WindowEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void windowIconified(WindowEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void windowDeiconified(WindowEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void windowDeactivated(WindowEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void windowClosing(WindowEvent e) {
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            }

            @Override
            public void windowClosed(WindowEvent e) {

            }

            @Override
            public void windowActivated(WindowEvent e) {

            }
        });
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        logger.info("==================AppInitEnd");
    }
}

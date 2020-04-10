package com.harrissons.contactmanager.Models;

import com.harrissons.contactmanager.Helpers.ConfigManager;

import java.io.File;

/**
 * Tool Constants
 *
 * @author Bob
 */
public class ToolConsts {

    // Config File
    /**
     * Config File Path
     */
    public final static String PATH_CONFIG = UIConsts.CURRENT_DIR + File.separator + "config" + File.separator
            + "config.xml";
    /**
     * Config File DOM Instance
     */
    public final static ConfigManager CONFIGER = ConfigManager.getConfigManager();
    /**
     * xpath
     */
    public final static String XPATH_DATABASE_CHOICE = "//contactManager/database/using/type";

    public final static String XPATH_TYPE_SQLSERVER = "//contactManager/database/sqlServer/type";
    public final static String XPATH_HOST_SQLSERVER = "//contactManager/database/sqlServer/host";
    public final static String XPATH_NAME_SQLSERVER = "//contactManager/database/sqlServer/name";
    public final static String XPATH_USER_SQLSERVER = "//contactManager/database/sqlServer/user";
    public final static String XPATH_PASSWORD_SQLSERVER = "//contactManager/database/sqlServer/password";

    public final static String XPATH_TYPE_MYSQL = "//contactManager/database/mySql/type";
    public final static String XPATH_HOST_MYSQL = "//contactManager/database/mySql/host";
    public final static String XPATH_NAME_MYSQL = "//contactManager/database/mySql/name";
    public final static String XPATH_USER_MYSQL = "//contactManager/database/mySql/user";
    public final static String XPATH_PASSWORD_MYSQL = "//contactManager/database/mySql/password";

    /**
     * Log File Path
     */
    public final static String PATH_LOG = UIConsts.CURRENT_DIR + File.separator + "logs";
    /**
     * MySQL Backup FIle Path
     */
    public final static String PATH_MYSQL_BACKUP = UIConsts.CURRENT_DIR + File.separator + "DB_Backup";
}


package com.harrissons.contactmanager.Helpers;

import com.harrissons.contactmanager.Models.ToolConsts;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;

/**
 * Config File Manager
 *
 * @author Bob
 */
public class ConfigManager {
    private static final Logger logger = LoggerFactory.getLogger(ConfigManager.class);
    private volatile static ConfigManager confManager;
    public Document document;

    /**
     * Private Constructor
     */
    private ConfigManager() {
        reloadDom();
    }

    /**
     * Get Instance
     *
     * @return
     */
    public static ConfigManager getConfigManager() {
        if (confManager == null) {
            synchronized (ConfigManager.class) {
                if (confManager == null) {
                    confManager = new ConfigManager();
                }
            }
        }
        return confManager;
    }

    /**
     * Read XML File Load Into Dom
     */
    public void reloadDom() {
        SAXReader reader = new SAXReader();
        try {
            document = reader.read(new File(ToolConsts.PATH_CONFIG));
        } catch (DocumentException e) {
            e.printStackTrace();
            logger.error("Read config xml error:" + e.toString());
        }
    }

    /**
     * Write To Xml
     *
     * @throws Exception
     */
    public void writeToXml() throws Exception {
        // Format Indentation
        OutputFormat format = OutputFormat.createPrettyPrint();
        // Set Encoding
        format.setEncoding("UTF-8");
        // Create XML Writer
        XMLWriter writer = null;
        writer = new XMLWriter(
                new OutputStreamWriter(new FileOutputStream(new File(ToolConsts.PATH_CONFIG)), StandardCharsets.UTF_8), format);

        // Write
        writer.write(document);
        writer.flush();
        writer.close();

    }

    public String getDataBaseChoice() {
        return this.document.selectSingleNode(ToolConsts.XPATH_DATABASE_CHOICE).getText();
    }

    public void setDataBaseChoice(String type) throws Exception {
        this.document.selectSingleNode(ToolConsts.XPATH_DATABASE_CHOICE).setText(type);
        writeToXml();
    }

    public String getTestField() {
        return this.document.selectSingleNode(ToolConsts.XPATH_TEST_FIELD).getText();
    }

    public void setTestField(String type) throws Exception {
        this.document.selectSingleNode(ToolConsts.XPATH_TEST_FIELD).setText(type);
        writeToXml();
    }

    public String getTypeSqlServer() {
        return this.document.selectSingleNode(ToolConsts.XPATH_TYPE_SQLSERVER).getText();
    }

    public void setTypeSqlServer(String type) throws Exception {
        this.document.selectSingleNode(ToolConsts.XPATH_TYPE_SQLSERVER).setText(type);
        writeToXml();
    }

    public String getHostSqlServer() {
        return this.document.selectSingleNode(ToolConsts.XPATH_HOST_SQLSERVER).getText();
    }

    public void setHostSqlServer(String host) throws Exception {
        this.document.selectSingleNode(ToolConsts.XPATH_HOST_SQLSERVER).setText(host);
        writeToXml();
    }

    public String getNameSqlServer() {
        return this.document.selectSingleNode(ToolConsts.XPATH_NAME_SQLSERVER).getText();
    }

    public void setNameSqlServer(String name) throws Exception {
        this.document.selectSingleNode(ToolConsts.XPATH_NAME_SQLSERVER).setText(name);
        writeToXml();
    }

    public String getUserSqlServer() {
        return this.document.selectSingleNode(ToolConsts.XPATH_USER_SQLSERVER).getText();
    }

    public void setUserSqlServer(String user) throws Exception {
        this.document.selectSingleNode(ToolConsts.XPATH_USER_SQLSERVER).setText(user);
        writeToXml();
    }

    public String getPasswordSqlServer() {
        return this.document.selectSingleNode(ToolConsts.XPATH_PASSWORD_SQLSERVER).getText();
    }

    public void setPasswordSqlServer(String password) throws Exception {
        this.document.selectSingleNode(ToolConsts.XPATH_PASSWORD_SQLSERVER).setText(password);
        writeToXml();
    }

    public String getTypeMySQL() {
        return this.document.selectSingleNode(ToolConsts.XPATH_TYPE_MYSQL).getText();
    }

    public void setTypeMySQL(String type) throws Exception {
        this.document.selectSingleNode(ToolConsts.XPATH_TYPE_MYSQL).setText(type);
        writeToXml();
    }

    public String getHostMySQL() {
        return this.document.selectSingleNode(ToolConsts.XPATH_HOST_MYSQL).getText();
    }

    public void setHostMySQL(String host) throws Exception {
        this.document.selectSingleNode(ToolConsts.XPATH_HOST_MYSQL).setText(host);
        writeToXml();
    }

    public String getNameMySQL() {
        return this.document.selectSingleNode(ToolConsts.XPATH_NAME_MYSQL).getText();
    }

    public void setNameMySQL(String name) throws Exception {
        this.document.selectSingleNode(ToolConsts.XPATH_NAME_MYSQL).setText(name);
        writeToXml();
    }

    public String getUserMySQL() {
        return this.document.selectSingleNode(ToolConsts.XPATH_USER_MYSQL).getText();
    }

    public void setUserMySQL(String user) throws Exception {
        this.document.selectSingleNode(ToolConsts.XPATH_USER_MYSQL).setText(user);
        writeToXml();
    }

    public String getPasswordMySQL() {
        return this.document.selectSingleNode(ToolConsts.XPATH_PASSWORD_MYSQL).getText();
    }

    public void setPasswordMySQL(String password) throws Exception {
        this.document.selectSingleNode(ToolConsts.XPATH_PASSWORD_MYSQL).setText(password);
        writeToXml();
    }
}


package com.harrissons.contactmanager.Helpers;

import com.harrissons.contactmanager.Models.ToolConsts;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;

/**
 * SQL Server Database Utility Tool
 *
 * @author Bob
 */
public class DbToolSQLServer {
    private static final Logger logger = LoggerFactory.getLogger(DbToolSQLServer.class);
    private static String DBUrl = null;
    private static String DBName = null;
    private static String DBUser = null;
    private static String DBPassword = null;
    private static DbToolSQLServer instance = null;
    private Connection connection = null;
    private Statement statement = null;
    private ResultSet resultSet = null;

    /**
     * Private Constructor
     */
    private DbToolSQLServer() {
        loadConfig();
    }

    /**
     * Get Instance
     *
     * @return
     */
    public static synchronized DbToolSQLServer getInstance() {
        if (instance == null) {
            instance = new DbToolSQLServer();
        }
        return instance;
    }

    /**
     * Load Database Info From Config File
     */
    private void loadConfig() {
        try {
            String dbclassname = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
            DBUrl = ToolConsts.CONFIGER.getHostSqlServer();
            DBName = ToolConsts.CONFIGER.getNameSqlServer();
            DBUser = ToolConsts.CONFIGER.getUserSqlServer();
            DBPassword = ToolConsts.CONFIGER.getPasswordSqlServer();

            Class.forName(dbclassname);
        } catch (Exception e) {

            logger.error(e.toString());
            e.printStackTrace();
        }
    }

    /**
     * Get Connection
     *
     * @return
     * @throws SQLException
     */
    public synchronized Connection getConnection() throws SQLException {
        String user = "";
        String password = "";
        try {
            DESPlus des = new DESPlus();
            user = des.decrypt(DBUser);
            password = des.decrypt(DBPassword);
        } catch (Exception e) {
            logger.error("Database Connection Exception: " + e.toString());
            e.printStackTrace();
        }
        // Get Connection When Database Config File Changes
        if (!ToolConsts.CONFIGER.getHostSqlServer().equals(DBUrl)
                || !ToolConsts.CONFIGER.getNameSqlServer().equals(DBName)
                || !ToolConsts.CONFIGER.getUserSqlServer().equals(DBUser)
                || !ToolConsts.CONFIGER.getPasswordSqlServer().equals(DBPassword)) {
            loadConfig();
            connection = DriverManager.getConnection("jdbc:sqlserver://" + DBUrl + ";DatabaseName=" + DBName, user,
                    password);
            // Set Auto Commit To False
            connection.setAutoCommit(false);
        }

        // Get Connection When Database Connection Is Invalid
        if (connection == null || connection.isValid(10) == false) {

            connection = DriverManager.getConnection("jdbc:sqlserver://" + DBUrl + ";DatabaseName=" + DBName, user,
                    password);
            // Set Auto Commit To False
            connection.setAutoCommit(false);
        }

        if (connection == null) {
            logger.error("Can not load SQL Server jdbc and get connection.");
        }
        return connection;
    }

    /**
     * Test Connection: Get Connection Info From Config File
     *
     * @return
     * @throws SQLException
     */
    public synchronized Connection testConnection() throws SQLException {
        loadConfig();
        String user = "";
        String password = "";
        try {
            DESPlus des = new DESPlus();
            user = des.decrypt(DBUser);
            password = des.decrypt(DBPassword);
        } catch (Exception e) {
            logger.error("Database Connection Exception: " + e.toString());
            e.printStackTrace();
        }
        connection = DriverManager.getConnection("jdbc:sqlserver://" + DBUrl + ";DatabaseName=" + DBName, user,
                password);
        // Set Auto Commit To False
        connection.setAutoCommit(false);

        if (connection == null) {
            logger.error("Can not load SQL Server jdbc and get connection.");
        }
        return connection;
    }

    /**
     * Test Connection: Get Connection Info From Parameters
     *
     * @return
     * @throws SQLException
     */
    public synchronized Connection testConnection(String dburl, String dbname, String dbuser, String dbpassword)
            throws SQLException {
        loadConfig();
        connection = DriverManager.getConnection("jdbc:sqlserver://" + dburl + ";DatabaseName=" + dbname, dbuser,
                dbpassword);
        // Set Auto Commit To False
        connection.setAutoCommit(false);

        if (connection == null) {
            logger.error("Can not load SQL Server jdbc and get connection.");
        }
        return connection;
    }

    /**
     * Get Statement
     *
     * @throws SQLException
     */
    private synchronized void getStatement() throws SQLException {
        getConnection();
        // Recreate Statement When Statement Is Invalid
        if (statement == null || statement.isClosed()) {
            statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        }
    }

    /**
     * Close Connection
     *
     * @throws SQLException
     */
    public synchronized void close() throws SQLException {
        if (resultSet != null) {
            resultSet.close();
            resultSet = null;
        }
        if (statement != null) {
            statement.close();
            statement = null;
        }
        if (connection != null) {
            connection.close();
            connection = null;
        }
    }

    /**
     * Execute Query
     *
     * @param sql
     * @return
     * @throws SQLException
     */
    public synchronized ResultSet executeQuery(String sql) throws SQLException {
        getStatement();
        if (resultSet != null && !resultSet.isClosed()) {
            resultSet.close();
        }
        resultSet = null;
        resultSet = statement.executeQuery(sql);
        return resultSet;
    }

    /**
     * Execute Update
     *
     * @param sql
     * @return
     * @throws SQLException
     */
    public synchronized int executeUpdate(String sql) throws SQLException {
        int result = 0;
        getStatement();
        result = statement.executeUpdate(sql);
        return result;
    }

    /**
     * Execute SQL
     *
     * @param sql
     * @return
     * @throws SQLException
     */
    public synchronized boolean execute(String sql) throws SQLException {
        boolean result;
        getStatement();
        result = statement.execute(sql);
        return result;
    }
}


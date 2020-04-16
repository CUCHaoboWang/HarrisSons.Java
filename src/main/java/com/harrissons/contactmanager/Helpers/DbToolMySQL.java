package com.harrissons.contactmanager.Helpers;

import com.harrissons.contactmanager.Models.ToolConsts;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;

/**
 * MySQL Database Utility Tool
 *
 * @author Bob
 */
public class DbToolMySQL {
    private static final Logger logger = LoggerFactory.getLogger(DbToolMySQL.class);
    private static String DBUrl = null;
    private static String DBName = null;
    private static String DBUser = null;
    private static String DBPassword = null;
    private static DbToolMySQL instance = null;
    private Connection connection = null;
    private Statement statement = null;
    private CallableStatement callableStatement = null;
    private ResultSet resultSet = null;

    /**
     * Private Constructor
     */
    private DbToolMySQL() {
        loadConfig();
    }

    /**
     * Get Instance
     *
     * @return
     */
    public static synchronized DbToolMySQL getInstance() {

        if (instance == null) {
            instance = new DbToolMySQL();
        }
        return instance;
    }

    /**
     * Load Database Info From Config File
     */
    private void loadConfig() {
        try {
            String dbClassName = "com.mysql.cj.jdbc.Driver";
            DBUrl = ToolConsts.CONFIGER.getHostMySQL();
            DBName = ToolConsts.CONFIGER.getNameMySQL();
            DBUser = ToolConsts.CONFIGER.getUserMySQL();
            DBPassword = ToolConsts.CONFIGER.getPasswordMySQL();

            Class.forName(dbClassName);
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
        if (!ToolConsts.CONFIGER.getHostMySQL().equals(DBUrl) || !ToolConsts.CONFIGER.getNameMySQL().equals(DBName)
                || !ToolConsts.CONFIGER.getUserMySQL().equals(DBUser)
                || !ToolConsts.CONFIGER.getPasswordMySQL().equals(DBPassword)) {
            loadConfig();
            connection = DriverManager.getConnection(
                    "jdbc:mysql://" + DBUrl + "/" + DBName + "?useUnicode=true&characterEncoding=utf8", user, password);
            // Set Auto Commit To False
            connection.setAutoCommit(false);
        }

        // Get Connection When Database Connection Is Invalid
        if (connection == null || !connection.isValid(10)) {
            connection = DriverManager.getConnection(
                    "jdbc:mysql://" + DBUrl + "/" + DBName + "?useUnicode=true&characterEncoding=utf8", user, password);
            // Set Auto Commit To False
            connection.setAutoCommit(false);
        }

        if (connection == null) {
            logger.error("Can not load MySQL jdbc and get connection.");
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
            logger.error("DES Error:" + e.toString());
            e.printStackTrace();
        }
        connection = DriverManager.getConnection("jdbc:mysql://" + DBUrl + "/" + DBName, user, password);
        // Set Auto Commit To False
        connection.setAutoCommit(false);

        if (connection == null) {
            logger.error("Can not load MySQL jdbc and get connection.");
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
        connection = DriverManager.getConnection("jdbc:mysql://" + dburl + "/" + dbname, dbuser, dbpassword);
        // Set Auto Commit To False
        connection.setAutoCommit(false);

        if (connection == null) {
            logger.error("Can not load MySQL jdbc and get connection.");
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
     * Get Callable Statement
     *
     * @throws SQLException
     */
    private synchronized void getCallableStatement(String sql) throws SQLException {
        getConnection();
        callableStatement = connection.prepareCall(sql);
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
     * Execute Stored Procedure Query
     *
     * @param spName
     * @return
     * @throws SQLException
     */
    public synchronized ResultSet executeStoredProcedureQuery(String spName) throws SQLException {
        String sql = "{call " + spName + "()}";
        getCallableStatement(sql);
        if (resultSet != null && !resultSet.isClosed()) {
            resultSet.close();
        }
        resultSet = null;
        resultSet = callableStatement.executeQuery();
        return resultSet;
    }

    /**
     * Execute Stored Procedure Query
     *
     * @param spName
     * @param params
     * @return
     * @throws SQLException
     */
    public synchronized ResultSet executeStoredProcedureQuery(String spName, String[] params) throws SQLException {
        StringBuilder builder = new StringBuilder("{call " + spName + "(");
        for (int i = 0; i < params.length; i++) {
            if (i == 0) {
                builder.append("?");
            } else {
                builder.append(",?");
            }
        }
        builder.append(")}");
        String sql = builder.toString();

        getCallableStatement(sql);
        for (int i = 0; i < params.length; i++) {
            callableStatement.setString(i + 1, params[i]);
        }

        if (resultSet != null && !resultSet.isClosed()) {
            resultSet.close();
        }
        resultSet = null;
        resultSet = callableStatement.executeQuery();
        return resultSet;
    }

    /**
     * Execute Stored Procedure Update
     *
     * @param spName
     * @return
     * @throws SQLException
     */
    public synchronized void executeStoredProcedureUpdate(String spName) throws SQLException {
        String sql = "{call " + spName + "()}";
        getCallableStatement(sql);
        callableStatement.executeQuery();
        connection.commit();
        callableStatement.close();
    }

    /**
     * Execute Stored Procedure Update
     *
     * @param spName
     * @param params
     * @return
     * @throws SQLException
     */
    public synchronized void executeStoredProcedureUpdate(String spName, String[] params) throws SQLException {
        StringBuilder builder = new StringBuilder("{call " + spName + "(");
        for (int i = 0; i < params.length; i++) {
            if (i == 0) {
                builder.append("?");
            } else {
                builder.append(",?");
            }
        }
        builder.append(")}");
        String sql = builder.toString();

        getCallableStatement(sql);
        for (int i = 0; i < params.length; i++) {
            callableStatement.setString(i + 1, params[i]);
        }
        callableStatement.executeQuery();
        connection.commit();
        callableStatement.close();
    }
}


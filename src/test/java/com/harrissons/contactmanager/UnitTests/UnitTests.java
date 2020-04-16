package com.harrissons.contactmanager.UnitTests;

import com.harrissons.contactmanager.Helpers.DESPlus;
import com.harrissons.contactmanager.Helpers.DbToolMySQL;
import com.harrissons.contactmanager.Models.ToolConsts;
import org.junit.Assert;
import org.junit.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UnitTests {
    @Test
    public void canReadFromXml() {
        String text = ToolConsts.CONFIGER.getDataBaseChoice();
        Boolean result = (text.equals("MySQL") || text.equals("SQL Server"));
        Assert.assertTrue(result);
    }

    @Test
    public void canEncryptText() {
        String text = "text";
        String cipher = "";
        try {
            DESPlus des = new DESPlus();
            cipher = des.encrypt(text);
            ToolConsts.CONFIGER.setTestField(cipher);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Assert.assertEquals(cipher, ToolConsts.CONFIGER.getTestField());
    }

    @Test
    public void canConnectToDatabase() {
        DbToolMySQL dbMySQL = DbToolMySQL.getInstance();
        Connection connection = null;
        try {
            connection = dbMySQL.testConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Assert.assertNotNull(connection);
    }

    @Test
    public void canReadFromDatabase() {
        DbToolMySQL dbMySQL = DbToolMySQL.getInstance();
        ResultSet resultSet = null;
        try {
            resultSet = dbMySQL.executeStoredProcedureQuery("spGetAllAddress");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Assert.assertNotNull(resultSet);
    }
}

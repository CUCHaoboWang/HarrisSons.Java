package com.harrissons.contactmanager.Helpers;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.text.SimpleDateFormat;
import java.util.*;


/**
 * Tools
 *
 * @author Bob
 */
public class Tools {

    /**
     * Get Current Time In The Format Of yyyy-MM-dd HH:mm:ss
     *
     * @return
     */
    public static String getCurrentTime() {
        // Set Date Format
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return df.format(new Date());
    }

    /**
     * Get String Index In A String Array
     *
     * @param arr
     * @param key
     * @return index
     */
    public static int getStrArrIndex(String[] arr, String key) {

        for (int i = 0; i < arr.length; i++) {
            if (key.equals(arr[i])) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Compare Map Keys
     *
     * @param map1
     * @param map2
     * @return
     */
    public static boolean mapComparePrimKey(Map<String, String> map1, Map<String, String> map2) {
        boolean ifEquals = true;
        for (String key : map1.keySet()) {
            if (!map1.get(key).equals(map2.get(key))) {
                ifEquals = false;
            }
        }

        return ifEquals;
    }

    /**
     * Get Element Index In a LinkedHashSet
     *
     * @param linkedHashSet
     * @param string
     * @return
     */
    public static int getIndexInLinkedHashSet(LinkedHashSet<String> linkedHashSet, String string) {
        int index = -1;
        Iterator<String> linkedSetStringIt = linkedHashSet.iterator();
        while (linkedSetStringIt.hasNext()) {
            index++;
            String temp = linkedSetStringIt.next();
            if (temp.equals(string)) {
                return index;
            }
        }
        return -1;
    }

    /**
     * Convert ResultSet To TableModel
     *
     * @param rs
     * @return TableModel
     */
    public static TableModel resultSetToTableModel(ResultSet rs) {
        try {
            ResultSetMetaData metaData = rs.getMetaData();
            int numberOfColumns = metaData.getColumnCount();
            Vector<String> columnNames = new Vector<String>();

            // Get the column names
            for (int column = 0; column < numberOfColumns; column++) {
                columnNames.addElement(metaData.getColumnLabel(column + 1));
            }

            // Get all rows.
            Vector<Vector<Object>> rows = new Vector<Vector<Object>>();

            while (rs.next()) {
                Vector<Object> newRow = new Vector<Object>();

                for (int i = 1; i <= numberOfColumns; i++) {
                    newRow.addElement(rs.getObject(i));
                }

                rows.addElement(newRow);
            }

            return new DefaultTableModel(rows, columnNames) {
                public boolean isCellEditable(int rowIndex, int mColIndex) {
                    return false;
                }
            };
        } catch (Exception e) {
            e.printStackTrace();

            return null;
        }
    }

    /**
     * Convert ResultSet To TableModel
     *
     * @param rs
     * @param includeColumnNames
     * @return List<List < Object>>
     */
    public static List<List<Object>> resultSetToNestedList(ResultSet rs, boolean includeColumnNames) {
        try {
            // To contain all rows.
            List<List<Object>> rows = new ArrayList<List<Object>>();
            ResultSetMetaData metaData = rs.getMetaData();
            int numberOfColumns = metaData.getColumnCount();

            // Include column headers as first row if required
            if (includeColumnNames) {
                List<Object> columnNames = new ArrayList<Object>();

                // Get the column names
                for (int column = 0; column < numberOfColumns; column++) {
                    columnNames.add(metaData.getColumnLabel(column + 1));
                }
                rows.add(columnNames);
            }

            // Get the data
            while (rs.next()) {
                List<Object> newRow = new ArrayList<Object>();

                for (int i = 1; i <= numberOfColumns; i++) {
                    newRow.add(rs.getObject(i));
                }

                rows.add(newRow);
            }
            return rows;
        } catch (Exception e) {
            e.printStackTrace();

            return null;
        }
    }

    /**
     * Convert ResultSet To TableModel
     *
     * @param rs
     * @return List<List < Object>>
     */
    public static List<List<Object>> resultSetToNestedList(ResultSet rs) {
        try {
            // To contain all rows.
            List<List<Object>> rows = new ArrayList<List<Object>>();
            ResultSetMetaData metaData = rs.getMetaData();
            int numberOfColumns = metaData.getColumnCount();

            // Get the data
            while (rs.next()) {
                List<Object> newRow = new ArrayList<Object>();

                for (int i = 1; i <= numberOfColumns; i++) {
                    newRow.add(rs.getObject(i));
                }

                rows.add(newRow);
            }
            return rows;
        } catch (Exception e) {
            e.printStackTrace();

            return null;
        }
    }
}

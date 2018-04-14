package org.aogiri.model;

import org.aogiri.objects.Address;
import org.aogiri.objects.CreditCard;
import org.aogiri.objects.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class PackageTable {


    /**
     * TODO: enforce foreign keys
     * @param conn
     * @param package_id
     * @param weight_class
     * @param package_type
     * @param hazardous
     * @param tracking_id
     * @param username
     * @return
     */
    public static boolean addPackage(Connection conn,
                                     int package_id,
                                     String weight_class,
                                     String package_type,
                                     boolean hazardous,
                                     int tracking_id,
                                     String username){

        String query = String.format("INSERT INTO package_db "
                                    + "VALUES(%d,\'%s\',\'%s\',%b,%d,\'%s\');",
                                    package_id, weight_class, package_type, hazardous, tracking_id, username);
        try {
            Statement stmt = conn.createStatement();
            stmt.execute(query);
        } catch (SQLException e){
            return false;
        }
        return true;
    }

    /**
     * See example code PersonTable file.
     * @param conn
     * @param columns
     * @param whereClauses
     * @return
     */
    public static ResultSet queryPackageTable(Connection conn,
                                                     ArrayList<String> columns,
                                                     ArrayList<String> whereClauses){

        String query = String.format("SELECT %s ", columns.get(0));
        for(int i = 1; i < columns.size(); i ++){
            query += String.format(", %s ", columns.get(i));
        }

        query += String.format("FROM package_db "
                                + "WHERE %s", whereClauses.get(0));
        for(int i = 1; i < whereClauses.size(); i ++){
            query += String.format("and %s ", whereClauses.get(i));
        }

        try {
            Statement stmt = conn.createStatement();
            return stmt.executeQuery(query);
        } catch (SQLException e){
            return null;
        }
    }

    // Loosely prototyped, feel free to change
    public static boolean updatePackage(Connection conn,
                                        String column,
                                        String newValue,
                                        ArrayList<String> whereClauses){

        String query = String.format("UPDATE package_db "
                                    + "SET %s = %s "
                                    + "WHERE %s",
                                    column, newValue, whereClauses.get(0));

        for(int i = 1; i < whereClauses.size(); i ++){
            query += String.format(" and %s", whereClauses.get(i));
        }
        query += String.format(";");

        try {
            Statement stmt = conn.createStatement();
            stmt.execute(query);
        } catch (SQLException e){
            return false;
        }
        return true;
    }
}

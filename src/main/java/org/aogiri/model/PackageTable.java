package org.aogiri.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

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

        String query = String.format("INSERT INTO non_contract_member "
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
        return null;
    }

    // Loosely prototyped, feel free to change
    public static boolean updatePackage(Connection conn,
                                        String column,
                                        String newValue,
                                        ArrayList<String> whereClauses){
        return false;
    }
}

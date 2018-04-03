package org.aogiri.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class LocationTable {

    /**
     * TODO: figure out how to enforce id, enforce that package and location both exist
     * @param conn
     * @param packageID
     * @param locationID
     * @return
     */
    public static boolean addLogEntry(Connection conn,
                                      int packageID,
                                      int locationID){

        String query = String.format("INSERT INTO location_log "
                                    + "VALUES(%d,%d);",
                                    packageID,locationID);
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
    public static ResultSet queryLocationLogTable(Connection conn,
                                                     ArrayList<String> columns,
                                                     ArrayList<String> whereClauses){
        return null;
    }

    // Loosely prototyped, feel free to change
    public static boolean updateLogEntry(Connection conn,
                                        String column,
                                        String newValue,
                                        ArrayList<String> whereClauses){
        return false;
    }
}
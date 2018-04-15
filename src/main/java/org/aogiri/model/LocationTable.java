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
     * @param time
     * @param date
     * @param trackingID
     * @return
     */
    public static boolean addLogEntry(Connection conn,
                                      int packageID,
                                      int locationID,
                                      String time,
                                      String date,
                                      int trackingID){

        String query = String.format("INSERT INTO location_log "
                                    + "VALUES(%d,%d,\'%s\',\'%s\',%d);",
                                    packageID,locationID,time,date,trackingID);
        String update_tracking = String.format("update tracking_db "
                + "set status = \'lost\' "
                + "where tracking_db.tracking_id = result.tracking_id and "
                + "result.days_left < 0;"
                + "update tracking_db "
                + "set status = \'lost\'"
                + "where tracking_db.tracking_id = result.tracking_id and "
                + "result.days_left <= -5;");
        try {
            Statement stmt = conn.createStatement();
            stmt.execute(query);
            stmt.execute(update_tracking);
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


        String query = String.format("SELECT %s ", columns.get(0));
        for(int i = 1; i < columns.size(); i ++){
            query += String.format(", %s ", columns.get(i));
        }

        query += String.format("FROM location_log "
                                + "WHERE %s", whereClauses.get(0));
        for(int i = 1; i < whereClauses.size(); i ++){
            query += String.format(" and %s", whereClauses.get(i));
        }
        query += String.format(";");

        try {
            Statement stmt = conn.createStatement();
            return stmt.executeQuery(query);
        } catch (SQLException e){
            return null;
        }
    }

    // Loosely prototyped, feel free to change
    public static boolean updateLogEntry(Connection conn,
                                        String column,
                                        String newValue,
                                        ArrayList<String> whereClauses){

        String query = String.format("UPDATE location_log "
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
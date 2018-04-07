package org.aogiri.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class TrackingTable{

    /**
     * TODO: enforce foreign keys & domain
     * @param conn
     * @param tracking_id
     * @param destination_number
     * @param destination_street
     * @param destination_city
     * @param destination_zipcode
     * @param shipping_days
     * @param status
     * @param vehicle_id
     * @return
     */
    public static boolean addTracking(Connection conn,
                                     int tracking_id,
                                     int destination_number,
                                     String destination_street,
                                     String destination_city,
                                     int destination_zipcode,
                                     int shipping_days,
                                     String status,
                                     int vehicle_id){

        String query = String.format("INSERT INTO tracking_db "
                                    + "VALUES(%d,%d,\'%s\',\'%s\',%d,%d,\'%s\',%d);",
                                    tracking_id, destination_number, destination_street, destination_city,
                                    destination_zipcode, shipping_days, status, vehicle_id);
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
    public static ResultSet queryTrackingTable(Connection conn,
                                              ArrayList<String> columns,
                                              ArrayList<String> whereClauses){

        String query = String.format("SELECT %s ", columns.get(0));
        for(int i = 1; i < columns.size(); i ++){
            query += String.format(", %s ", columns.get(i));
        }

        query += String.format("FROM tracking_db "
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
    public static boolean updateTracking(Connection conn,
                                        String column,
                                        String newValue,
                                        ArrayList<String> whereClauses){

        String query = String.format("UPDATE tracking_db "
                                    + "SET %s = %s "
                                    + "WHERE %s ",
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
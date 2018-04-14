package org.aogiri.model;

import org.aogiri.objects.Vehicle;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class VehicleTable{
    public static boolean addVehicle(Connection conn,
                                     int vehicle_id,
                                     String vehicle_type,
                                     int origin_id,
                                     int location_id,
                                     int destination_id){

        String query = String.format("INSERT INTO vehicle "
                                    + "VALUES(%d, \'%s\', %d, %d, %d);",
                                    vehicle_id, vehicle_type, origin_id, location_id, destination_id);
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
    public static ResultSet queryVehicleTable(Connection conn,
                                              ArrayList<String> columns,
                                              ArrayList<String> whereClauses){

        String query = String.format("SELECT %s ", columns.get(0));
        for(int i = 1; i < columns.size(); i ++){
            query += String.format(", %s ", columns.get(i));
        }

        query += String.format("FROM vehicle "
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

    /**
     * Gets a list of all vehicles and their columns
     */
    public static List<Object> allVehicles(Connection conn){
        List<Object> objects = new ArrayList<>();

        String query = "select * "
                        +"from vehicle;";

        try{
            Statement stmt = conn.createStatement();
            ResultSet result = stmt.executeQuery(query);
            while(result.next()){
                String id = result.getString("vehicle_id");
                String type = result.getString("vehicle_type");
                String origin = Integer.toString(result.getInt("origin_id"));
                String destination = Integer.toString(result.getInt("destination_id"));
                objects.add(new Vehicle(id,type,origin,null,destination));
            }
            return objects;
        }catch(SQLException e){
            return null;
        }
    }

    // Loosely prototyped, feel free to change
    public static boolean updateVehicle(Connection conn,
                                        String column,
                                        String newValue,
                                        ArrayList<String> whereClauses){

        String query = String.format("UPDATE vehicle "
                                    + "SET %s = "
                                    + "WHERE %s ",
                                    column, newValue, whereClauses.get(0));

        for(int i = 1; i < whereClauses.size(); i ++){
            query += String.format("and %s ", whereClauses.get(i));
        }

        try {
            Statement stmt = conn.createStatement();
            stmt.execute(query);
        } catch (SQLException e){
            return false;
        }
        return true;
    }
}
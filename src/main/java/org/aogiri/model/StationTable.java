package org.aogiri.model;

import org.aogiri.objects.Address;
import org.aogiri.objects.Station;
import org.aogiri.objects.Vehicle;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class StationTable {

    public static boolean addStation(Connection conn,
                                     int location_id,
                                     int location_number,
                                     String location_street,
                                     String location_city,
                                     int location_zipcode){

        String query = String.format("INSERT INTO station "
                                    + "VALUES(%d,%d,\'%s\',\'%s\',%d);",
                                    location_id, location_number, location_street, location_city, location_zipcode);
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
    public static ResultSet queryStationTable(Connection conn,
                                              ArrayList<String> columns,
                                              ArrayList<String> whereClauses){

        String query = String.format("SELECT %s ", columns.get(0));
        for(int i = 1; i < columns.size(); i ++){
            query += String.format(", %s ", columns.get(i));
        }

        query += String.format("FROM station "
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
     * Gets a list of all stations and their columns
     */
    public static List<Object> allStations(Connection conn){
        List<Object> objects = new ArrayList<>();

        String query = "select * "
                +"from station;";

        try{
            Statement stmt = conn.createStatement();
            ResultSet result = stmt.executeQuery(query);
            while(result.next()){
                String id = Integer.toString(result.getInt("location_id"));
                String city = result.getString("location_city");
                String street = Integer.toString(result.getInt("location_street"));
                String number = result.getString("location_number");
                String zipcode = Integer.toString(result.getInt("location_zipcode"));
                objects.add(new Station(id, number + street + city + zipcode));
            }
            return objects;
        }catch(SQLException e){
            return null;
        }
    }

    // Loosely prototyped, feel free to change
    public static boolean updateStation(Connection conn,
                                        String column,
                                        String newValue,
                                        ArrayList<String> whereClauses){

        String query = String.format("UPDATE station "
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
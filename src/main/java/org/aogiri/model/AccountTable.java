package org.aogiri.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class AccountTable {

    /**
     * TODO: automatically make new account a non-contract user
     * Adds a single user to the database
     * @param conn
     * @param username
     * @param password
     * @param session_token
     * @param first_name
     * @param last_name
     * @param address_number
     * @param address_street
     * @param address_city
     * @param address_zipcode
     * @return
     */
    public static boolean addAccount(Connection conn,
                                     String username,
                                     String password,
                                     String session_token,
                                     String first_name,
                                     String last_name,
                                     int address_number,
                                     String address_street,
                                     String address_city,
                                     int address_zipcode){

        String query = String.format("INSERT INTO account "
                                    + "VALUES(\'%s\',\'%s\',\'%s\',\'%s\',\'%s\',%d,\'%s\',\'%s\',%d);",
                                    username, password, session_token, first_name, last_name, address_number,
                                    address_street, address_city, address_zipcode);
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
    public static ResultSet queryAccountTable(Connection conn,
                                              ArrayList<String> columns,
                                              ArrayList<String> whereClauses){
        return null;
    }

    public static boolean isContractMember(Connection conn,
                                           String username){
        return false;
    }

    // Loosely prototyped, feel free to change
    public static boolean updateAccount(Connection conn,
                                        String column,
                                        String newValue,
                                        ArrayList<String> whereClauses){
        return false;
    }
}

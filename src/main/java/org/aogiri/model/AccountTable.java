package org.aogiri.model;

import org.aogiri.objects.Address;
import org.aogiri.objects.CreditCard;
import org.aogiri.objects.Station;
import org.aogiri.objects.User;

import javax.xml.transform.Result;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

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
                                     int address_zipcode,
                                     String profile_url,
                                     String credit_card_number,
                                     String credit_card_exp){

        String query = String.format("INSERT INTO account "
                                    + "VALUES(\'%s\',\'%s\',\'%s\',\'%s\',\'%s\',%d,\'%s\',\'%s\',%d,\'%s\',int,\'%s\');",
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

        String query = String.format("SELECT %s ", columns.get(0));
        for(int i = 1; i < columns.size(); i ++){
            query += String.format(", %s ", columns.get(i));
        }

        query += String.format("FROM account"
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

    public static boolean isContractMember(Connection conn,
                                           String username){

        String query = String.format("SELECT * "
                                    + "FROM contract_member "
                                    + "WHERE username = %s;",
                                    username);

        try {
            Statement stmt = conn.createStatement();
            ResultSet result = stmt.executeQuery(query);
            if(!result.isBeforeFirst()) {
                return false;
            }
        } catch (SQLException e){
            return false;
        }
        return true;
    }

    /**
     * Gets a list of accounts and all their columns
     */
    public static List<Object> allAccounts(Connection conn){
        List<Object> objects = new ArrayList<>();

        String query = "select * "
                +"from account;";

        try{
            Statement stmt = conn.createStatement();
            ResultSet result = stmt.executeQuery(query);
            SimpleDateFormat sdfr = new SimpleDateFormat("dd/MMM/yyyy");
            while(result.next()){
                String username = result.getString("username");
                String password = result.getString("password");
                String token = result.getString("session_token");
                String first = result.getString("first_name");
                String last = result.getString("last_name");
                String city = result.getString("adress_city");
                String street = result.getString("address_street");
                String number = Integer.toString(result.getInt("address_number"));
                String zipcode = Integer.toString(result.getInt("address_zipcode"));
                String url = result.getString("profile_url");
                String cardnumber = result.getString("credit_card_number");
                String exp = sdfr.format(result.getDate("credit_card_exp"));
                objects.add(new User(username, password, first, last, number +
                        " " + street + " " + city + " " + zipcode, new CreditCard(cardnumber,exp),url,null));
            }
            return objects;
        }catch(SQLException e){
            return null;
        }
    }

    // Loosely prototyped, feel free to change
    public static boolean updateAccount(Connection conn,
                                        String column,
                                        String newValue,
                                        ArrayList<String> whereClauses){

        String query = String.format("UPDATE account"
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

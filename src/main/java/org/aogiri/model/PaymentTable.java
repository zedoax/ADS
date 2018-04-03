package org.aogiri.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class PaymentTable {

    /**
     * TODO: enforce foreign keys
     * @param conn
     * @param payment
     * @param date
     * @param member_id
     * @return
     */
    public static boolean addPayment(Connection conn,
                                               float payment,
                                               String date,
                                               int member_id){

        String query = String.format("INSERT INTO payment "
                                    + "VALUES(%.2f,%s,%d);",
                                    payment, date, member_id);
        try {
            Statement stmt = conn.createStatement();
            stmt.execute(query);
        } catch (SQLException e){
            return false;
        }
        return true;
    }

    public static boolean deleteContractMember(Connection conn,
                                               String username) {
        String query = String.format("DELETE FROM test "
                        + "WHERE username=\'%s\';",
                username);
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
    public static ResultSet queryContractMemberTable(Connection conn,
                                                     ArrayList<String> columns,
                                                     ArrayList<String> whereClauses){
        return null;
    }

    // Loosely prototyped, feel free to change
    public static boolean updateAccount(Connection conn,
                                        String column,
                                        String newValue,
                                        ArrayList<String> whereClauses){
        return false;
    }
}
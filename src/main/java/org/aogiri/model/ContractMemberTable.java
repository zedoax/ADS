package org.aogiri.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;

public class ContractMemberTable {


    /**
     * TODO: enforce that username is in account table
     * @param conn
     * @param id
     * @param cycle_start
     * @param cycle_bill
     * @param username
     * @return
     */
    public static boolean addContractMember(Connection conn,
                                            int id,
                                            String cycle_start,
                                            float cycle_bill,
                                            String username){

        String query = String.format("INSERT INTO contract_member "
                                    + "VALUES(%d,\'%s\',%2f,\'%s\');",
                                    id, cycle_start, cycle_bill, username);
        try {
            Statement stmt = conn.createStatement();
            stmt.execute(query);
        } catch (SQLException e){
            return false;
        }
        return true;
    }

    /**
     * TODO: enforce that username is in non_contract_member table
     * ASSUMES users are already non-contract.
     * @param conn
     * @param cycle_start
     * @param cycle_bill
     * @param username
     * @return
     */
    public static boolean changeToContractMember(Connection conn,
                                     String cycle_start,
                                     float cycle_bill,
                                     String username){
        String query = String.format("INSERT INTO contract_member "
                                    + "SELECT   non_contract_member.member_id, \'%s\' , %2f, \'%s\' "
                                    + "FROM     non_contract_member "
                                    + "WHERE    non_contract_member.username=\'s\';",
                                    cycle_start, cycle_bill, username, username);
        try {
            Statement stmt = conn.createStatement();
            stmt.execute(query);
            if(!NonContractMemberTable.deleteContractMember(conn, username)) return false;
        } catch (SQLException e){
            return false;
        }
        return true;
    }

    public static boolean deleteContractMember(Connection conn,
                                               String username) {
        String query = String.format("DELETE FROM contract_member "
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
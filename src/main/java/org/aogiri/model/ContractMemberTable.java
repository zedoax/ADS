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
                                    + "VALUES(%d,%s,%2f,\'%s\');",
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
                                    + "SELECT   non_contract_member.member_id, %s, %2f, \'%s\' "
                                    + "FROM     non_contract_member "
                                    + "WHERE    non_contract_member.username=\'s\';",
                                    cycle_start, cycle_bill, username, username);
        try {
            Statement stmt = conn.createStatement();
            stmt.execute(query);
            if(!NonContractMemberTable.deleteNonContractMember(conn, username)) return false;
        } catch (SQLException e){
            return false;
        }
        return true;
    }

    /**
     * Switches user to regular contract
     * TODO: enforce that current bill is 0.00?
     * @param conn
     * @param username
     * @return
     */
    public static boolean cancelContract(Connection conn,
                                               String username) {
        String whereClause = String.format("username=\'%s\'",username);

        String query = String.format("DELETE FROM contract_member "
                                    + "WHERE username=\'%s\';",
                                    username);
        try {
            NonContractMemberTable.addNonContractMember(conn, queryContractMemberTable(conn,
                    new ArrayList<String>(Arrays.asList("member_id")),
                    new ArrayList<String>(Arrays.asList(whereClause))).getInt(1),
                                                        username);
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

        String query = String.format("SELECT %s "
                                    + "FROM contract_member"
                                    + "WHERE %s", columns, whereClauses);

        try {
            Statement stmt = conn.createStatement();
            return stmt.executeQuery(query);
        } catch (SQLException e){
            return null;
        }
    }

    // Loosely prototyped, feel free to change
    public static boolean updateAccount(Connection conn,
                                        String column,
                                        String newValue,
                                        ArrayList<String> whereClauses){

        String query = String.format("UPDATE contract_member "
                                    + "SET %s = "
                                    + "WHERE %s ",
                                    column, newValue, whereClauses);
        try {
            Statement stmt = conn.createStatement();
            stmt.execute(query);
        } catch (SQLException e){
            return false;
        }
        return true;
    }
}
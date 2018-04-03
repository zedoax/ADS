package org.aogiri.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class NonContractMemberTable{

    public static boolean addNonContractMember(Connection conn,
                                               int memberID,
                                               String username){

        String query = String.format("INSERT INTO non_contract_member "
                                    + "VALUES(%d,\'%s\');",
                                    memberID, username);
        try {
            Statement stmt = conn.createStatement();
            stmt.execute(query);
        } catch (SQLException e){
            return false;
        }
        return true;
    }

    public static boolean deleteNonContractMember(Connection conn,
                                               String username) {
        String query = String.format("DELETE FROM non_contract_member "
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
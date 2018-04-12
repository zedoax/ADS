package org.aogiri.model;

import java.sql.Connection;

/**
 * Created by Zedoax on 3/24/2018.
 */
public class Database {

    // Complex queries can live here. eg. All packages on x truck? All packages delivered x day? Total amount billed to each account?

    /**
    public boolean createUser(Connection conn, String [] data) {
        return false;
    }

    public boolean createTruck(Connection conn, String [] data) {
        return false;
    }

    public boolean createPackage(Connection conn, String [] data) {
        return false;
    }

    public boolean createPayment(Connection conn, String [] data) {
        return false;
    }

    public boolean createSCenter(Connection conn, String [] data) {
        return false;
    }

    public boolean updateProfile(Connection conn, String [] data) {
        return false;
    }

    public boolean updateMemType(Connection conn, String [] data) {
        return false;
    }

    public boolean updateTruck(Connection conn, String [] data) {
        return false;
    }

    public boolean updatePackage(Connection conn, String [] data) {
        return false;
    }

    public boolean logPackage(Connection conn, String [] data) {
        return false;
    }
     **/

    /**
     * Creates a trigger
     * Goes off after a vehicles location updates, all packages on truck update
     */
    public static void createVPTrigger(){
        return true;
    }
}

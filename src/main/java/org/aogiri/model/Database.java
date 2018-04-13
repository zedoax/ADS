package org.aogiri.model;

import org.h2.api.Trigger;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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

    }

    /**
     * Get all columns of a package by tracking number, whether it's international, and the cost
     */
    public static ResultSet getInternationalCostInfo(Connection conn, String trackingID){
        String query = "select * "
                        + "from package_db "
                        + "where package_db.tracking_id = trackingID";

        ResultSet packageitem;
        try {
            Statement stmt = conn.createStatement();
            packageitem = stmt.executeQuery(query);
            String columnI = "alter table packageitem add international boolean;";
            String columnC = "alter table packageitem add cost decimal(20,2);";
            stmt.execute(columnI);
            stmt.execute(columnC);

            String update = "update packageitem "
                    + "set packageitem.cost = 10.00;"
                    + "update packageitem "
                    + "set packageitem.international = 0;";
            stmt.execute(update);
        } catch (SQLException e){
            return null;
        }

        String zip = "packageitem inner join tracking_db on "
                + "packageitem.tracking_id = tracking_db.tracking_id;";
        String typemod = "packageitem inner join package_weight on "
                + "packageitem.weight_class = package_weight.weight_class;";
        String weightmod = "packageitem inner join package_class on "
                + "packageitem.package_type = package_class.package_type;";
        try {
            Statement stmt = conn.createStatement();
            packageitem = stmt.executeQuery(zip);
            String update = "update packageitem "
                    + "set packageitem.international = 1 "
                    + "where packageitem.destination_zipcode >= 00100 and"
                    + "packageitem.destination_zipcode < 00200;";
            stmt.execute(update);
            stmt.execute(typemod);
            stmt.execute(weightmod);

            //may need modification not sure if multipliers only apply to initial price
            String modifycost = "update tracking_db "
                                + "set cost = cost * packageitem.package_class.cost_modifier;"
                                + "update tracking_db "
                                + "set cost = cost * packageitem.package_weight.cost_modifier;"
                                + "update tracking_db "
                                + "set cost = cost * 2 "
                                + "where tracking_db.international = 1;";

            stmt.execute(modifycost);

            String filter = "select package_id, location_id, time, date, tracking_id, international, cost "
                            + "from packageitem;";

            return stmt.executeQuery(filter);
            
        } catch (SQLException e){
            return null;
        }
    }

    /**
     * Creates a Trigger that runs after a value is entered into the location_log
     *  sets package status: < 0 is late, <= -5 is lost
     */
    public static boolean statusTrigger(Connection conn){
        ResultSet result = getPackageTrackingInfo(conn, "*");

        String trigger = "update tracking_db "
                        + "set status = \'lost\' "
                        + "where tracking_db.tracking_id = result.tracking_id and "
                        + "result.days_left < 0;"
                        + "update tracking_db "
                        + "set status = \'lost\'"
                        + "where tracking_db.tracking_id = result.tracking_id and "
                        + "result.days_left <= -5;";

        try {
            Statement stmt = conn.createStatement();
            return stmt.execute(trigger);
        } catch (SQLException e){
            return false;
        }
    }

    /**
     * Gets information on packages grouped by package_id
     * Includes tracking data and package data
     * Includes days until delivery
     */
    public static ResultSet getPackageTrackingInfo(Connection conn,String packageID){
        String join = "package_db inner join tracking_db on "
                    + "package_db.tracking_id = tracking_db.tracking_id;";

        ResultSet result;
        ResultSet daysLeft = daysUntilDelivery(conn);
        try {
            Statement stmt = conn.createStatement();
            result = stmt.executeQuery(join);
        } catch (SQLException e){
            return null;
        }

        join = "result inner join daysLeft on "
                + "result.package_id = daysLeft.package_id;";

        try {
            Statement stmt = conn.createStatement();
            result = stmt.executeQuery(join);
        } catch (SQLException e){
            return null;
        }

        String query = "select * "
                        + "from result "
                        + "where result.package_id = packageID;";

        try {
            Statement stmt = conn.createStatement();
            return stmt.executeQuery(query);
        } catch (SQLException e){
            return null;
        }
    }

    /**
     * Calculates days until delivery for each package
     */
    public static ResultSet daysUntilDelivery(Connection conn){
        String query = "select distinct package_id, date,shipping_days, min(location_log.date) as start_date  "
                        + "from location_log, tracking_db"
                        + "group by package_id";

        ResultSet daysUntilDelivery;

        try {
            Statement stmt = conn.createStatement();
            daysUntilDelivery = stmt.executeQuery(query);
        } catch (SQLException e){
            return null;
        }

        query = "select package_id, DATEDIFF(day, daysUntilDelivery.start_date, GETDATE()) as days_left"
                +"from daysUntilDelivery;";
        try {
            Statement stmt = conn.createStatement();
            return stmt.executeQuery(query);
        } catch (SQLException e){
            return null;
        }
    }
}

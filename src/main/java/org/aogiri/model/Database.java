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

    /**
     * Gets a list of the vehicles a package has been on (log of the date, vehicle type, and locations logged only)
     */

    /**
     * Gets user who owns the most packages in the past year
     */
    public static ResultSet ownsMostPackages(Connection conn) {
        String join = "account inner join package_db on "
                + "account.username = package_db.username;";
        String query = "select username, count(username) as package_number"
                + "from account_packages;";
        String querytwo = "select distinct username "
                + "from account_package "
                + "where package_number = max(package_number);";

        try {
            Statement stmt = conn.createStatement();
            ResultSet account_package = stmt.executeQuery(join);
            account_package = stmt.executeQuery(query);
            return stmt.executeQuery(querytwo);
        } catch (SQLException e) {
            return null;
        }
    }

    /**
     * Gets user who spent the most money in the last year
     * (username, member_id, total_payments)
     */
    public static ResultSet spentMostMoney(Connection conn) {


        String join = "non_contract_member natural left outer join contract_member;";
        String query = "select member_id, total_payments "
                + "from ( select distinct member_id, sum(payment) as total_payments "
                + "from payment "
                + "group by member_id )"
                + "where total_payments = max(total_payments);";
        String jointwo = "result_query  inner join result_join on "
                + "result_query.member_id = result_join.member_id;";

        try

        {
            Statement stmt = conn.createStatement();
            ResultSet result_join = stmt.executeQuery(join);
            ResultSet result_query = stmt.executeQuery(query);
            return stmt.executeQuery(jointwo);
        } catch (SQLException e) {
            return null;
        }
    }


    /**
     * Gets most populated street
     */
    public static ResultSet getMostPopulated(Connection conn){
        String query = "select street"
                        + "from ( select *, count(street) as living "
                                + "from account "
                                + "group by street ) "
                        + "where living = max(living);";

        try {
            Statement stmt = conn.createStatement();
            return stmt.executeQuery(query);
        } catch (SQLException e){
            return null;
        }


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
     * Get all packages that missed their delivery date
     */
    public static ResultSet latePackages(Connection conn){
        String query = "select package_db.package_id "
                        + "from ( package_db inner join tracking_db on "
                                + "package_db.tracking_id = tracking_db.tracking_id ) "
                        + "where status = \'late\' or \'lost\';";

        try {
            Statement stmt = conn.createStatement();
            return stmt.executeQuery(query);
        } catch (SQLException e){
            return null;
        }
    }

    /**
     * Gets information on packages grouped by package_id
     * Includes tracking data and package data
     * Includes days until delivery
     */
    public static ResultSet getPackageTrackingInfo(Connection conn,String packageID){
        ResultSet result;
        ResultSet daysLeft = daysUntilDelivery(conn);

        String joinTracking = "package_db inner join tracking_db on "
                    + "package_db.tracking_id = tracking_db.tracking_id;";
        String joinDaysLeft = "result inner join daysLeft on "
                + "result.package_id = daysLeft.package_id;";
        String query = "select * "
                + "from result "
                + "where result.package_id = packageID;";

        try {
            Statement stmt = conn.createStatement();
            //unsure if these guys should be queries
            result = stmt.executeQuery(joinTracking);
            result = stmt.executeQuery(joinDaysLeft);
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
        String querySecond = "select package_id, DATEDIFF(day, daysUntilDelivery.start_date, GETDATE()) as days_left"
                            +"from daysUntilDelivery;";
        ResultSet daysUntilDelivery;

        try {
            Statement stmt = conn.createStatement();
            daysUntilDelivery = stmt.executeQuery(query);
            return stmt.executeQuery(query);
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

        String trigger = "create trigger statusTrigger after insert of location_log"
                + "update tracking_db "
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
     * Creates a Trigger that runs after a vehicle destination is updated.
     *  Updates the origin with the current location
     */
    public static boolean originTrigger(Connection conn){
        ResultSet result = getPackageTrackingInfo(conn, "*");

        String trigger = "create trigger originTrigger after update of vehicle on destination_id "
                        + "referencing old row as orow "
                        + "referencing new row as nrow "
                        + "for each row when(nrow != orow) "
                            + "begin atomic "
                                + "set nrow.origin_id = orow.destination_id "
                            + "end;";

        try {
            Statement stmt = conn.createStatement();
            return stmt.execute(trigger);
        } catch (SQLException e){
            return false;
        }
    }

}

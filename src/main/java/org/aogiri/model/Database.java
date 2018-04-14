package org.aogiri.model;

import org.aogiri.objects.*;
import org.aogiri.objects.Package;
import org.h2.api.Trigger;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Created by Zedoax on 3/24/2018.
 */
public class Database {

    // Complex queries can live here. eg. All packages on x truck? All packages delivered x day? Total amount billed to each account?

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
    public static List<Object> ownsMostPackages(Connection conn) {
        List<Object> objects = new ArrayList<>();
        String join = "account inner join package on "
                + "account.username = package.username;";
        String query = "select distinct * "
                + "from (select username, count(username) as package_number "
                + "from account_packages) "
                + "where package_number = max(package_number);";

        try {
            Statement stmt = conn.createStatement();
            ResultSet account_package = stmt.executeQuery(join);
            account_package = stmt.executeQuery(query);

            account_package.next();
            String username = account_package.getString("username");
            String num_packages = Integer.toString(account_package.getInt("package_number"));
            objects.add(new User(username,num_packages));
            return objects;
        } catch (SQLException e) {
            return null;
        }
    }

    /**
     * Gets user who spent the most money in the last year
     * (username, member_id, total_payments)
     */
    public static List<Object> spentMostMoney(Connection conn) {
        List<Object> objects = new ArrayList<>();

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
            ResultSet result = stmt.executeQuery(query);
            result = stmt.executeQuery(jointwo);

            result.next();
            String username = result.getString("username");
            String memberid = result.getString("memberid");
            String total_payments = result.getString("total_payments");
            objects.add(new User(username,memberid,total_payments));
            return objects;

        } catch (SQLException e) {
            return null;
        }
    }


    /**
     * Gets most populated street
     */
    public static List<Object> getMostPopulated(Connection conn){
        List<Object> objects = getPackageInfo(conn);
        String query = "select address_number, distinct adress_street, adress_city, address_zipcode"
                        + "from ( select *, count(address_street) as living "
                                + "from account "
                                + "group by address_street ) "
                        + "where living = max(living);";

        try {
            Statement stmt = conn.createStatement();
            ResultSet result = stmt.executeQuery(query);
            while(result.next()){
                String city = result.getString("address_city");
                String street = result.getString("address_street");
                String zipcode = result.getString("address_zipcode");
                objects.add(new Address(city,street,null,zipcode));
            }
            return objects;
        } catch (SQLException e){
            return null;
        }
    }

    /**
     * Gets a list of packages belonging to a user
     */
    public static List<Object> userPackages(Connection conn, String name){
        List<Object> objects = getPackageInfo(conn);
        for (Object pack:objects) {
            if(!((Package) pack).getOwner().equals(name)){
                objects.remove(pack);
            }
        }
        return objects;
    }

    /**
     * Gets information on packages by package_id
     * Includes tracking data and package data
     * Includes days until delivery
     */
    public static List<Object> getPackageTrackingInfo(Connection conn,String packageID){
        List<Object> objects = getPackageInfo(conn);
        for (Object pack:objects) {
            if(!((Package) pack).getId().equals(packageID)){
                objects.remove(pack);
            }
        }
        return objects;
    }

    /**
     * Get all columns of a package by tracking number, whether it's international, and the cost
     */
    public static List<Object> getPackageInfo(Connection conn, String trackingID){
        List<Object> objects = getPackageInfo(conn);
        for (Object pack:objects) {
            if(!((Package) pack).getTrackingid().equals(trackingID)){
                objects.remove(pack);
            }
        }
        return objects;
    }

    /**
     * Get all columns of a package by truckID, whether it's international, and the cost
     */
    public static List<Object> getTruckPackages(Connection conn,String vehicleID){
        List<Object> objects = getPackageInfo(conn);
        for (Object pack:objects) {
            if(!((Package) pack).getVehicleId().equals(vehicleID)){
                objects.remove(pack);
            }
        }
        return objects;
    }

    /**
     * Get all columns of a package by truckID, whether it's international, and the cost
     */
    public static List<Object> getDeliveredTruckPackages(Connection conn,String vehicleID){
        List<Object> objects = getPackageInfo(conn);
        for (Object pack:objects) {
            if(!((Package) pack).getVehicleId().equals(vehicleID) || !((Package) pack).getStatus().equals("delivered")){
                objects.remove(pack);
            }
        }
        return objects;
    }

    public static List<Object> getPackageInfo(Connection conn){
        ResultSet packageitem;
        List<Object> objects = new ArrayList<>();
        List<Object> arrival = getPackageInfo(conn);

        String addition = "alter table package add international boolean; "
                        + "alter table package add cost decimal(20,2);";
        String update = "update packageitem "
                        + "set packageitem.cost = 10.00;"
                        + "update packageitem "
                        + "set packageitem.international = 0;";
        String zip = "packageitem inner join tracking on "
                + "packageitem.tracking_id = tracking.tracking_id;";
        String typemod = "packageitem inner join package_weight on "
                + "packageitem.weight_class = package_weight.weight_class;";
        String weightmod = "packageitem inner join package_class on "
                + "packageitem.package_type = package_class.package_type;";
        String international = "update packageitem "
                + "set packageitem.international = 1 "
                + "where packageitem.destination_zipcode >= 00100 and"
                + "packageitem.destination_zipcode < 00200;";
        String dateMod = "packageitem inner join arrival on "
                        + "packageitem.package_id = arrival.package_id;";

        try {
            Statement stmt = conn.createStatement();
            packageitem = stmt.executeQuery(addition);
            packageitem = stmt.executeQuery(update);
            packageitem = stmt.executeQuery(zip);
            packageitem = stmt.executeQuery(typemod);
            packageitem = stmt.executeQuery(weightmod);
            packageitem = stmt.executeQuery(international);
            packageitem = stmt.executeQuery(dateMod);

            while(packageitem.next()) {
                String package_id = Integer.toString(packageitem.getInt("package_id"));
                String weight_class = packageitem.getString("weight_class");
                String package_type = packageitem.getString("package_type");
                Boolean hazardous = packageitem.getBoolean("hazardous");
                String username = packageitem.getString("username");
                String trackingid = Integer.toString(packageitem.getInt("trackingid"));
                Boolean national = packageitem.getBoolean("international");
                Float cost = packageitem.getFloat("cost");
                String truckid = Integer.toString(packageitem.getInt("vehicle_id"));
                String status = packageitem.getString("status");
                String city = packageitem.getString("address_city");
                String street = Integer.toString(packageitem.getInt("address_street"));
                String number = packageitem.getString("address_number");
                String zipcode = Integer.toString(packageitem.getInt("address_zipcode"));
                objects.add(new Package(package_id,username,truckid,new Address(city,street,number,zipcode),null,null,
                        dateMod,status,hazardous,national,weight_class,package_type,cost));
            }
        } catch (SQLException e){
            return null;
        }
        return objects;
    }

    /**
     * Get all packages that missed their delivery date
     */
    public static List<Object> latePackages(Connection conn){
        List<Object> objects = new ArrayList<>();
        String query = "select package_id, tracking_id"
                        + "from ( package inner join tracking on "
                                + "package.tracking_id = tracking.tracking_id ) "
                        + "where status = \'late\' or \'lost\';";

        try {
            Statement stmt = conn.createStatement();
            ResultSet result = stmt.executeQuery(query);
            while (result.next()) {
                List<Object> temp = getPackageInfo(conn,result.getString("tracking_id"));
                if(temp.size() > 0) {
                    objects.add(temp.get(0));
                }
            }
            return objects;
        } catch (SQLException e){
            return null;
        }
    }

    /**
     * Calculates days until delivery for each package
     * Finds first entry into the location log and subtracts the current
     * (int package_id, int DATEDIFF)
     */
    public static List<Object> daysUntilDelivery(Connection conn){
        ResultSet result;
        List<Object> objects = new ArrayList<>();


        String query = "select distinct package_id, date,shipping_days, min(location_log.date) as start_date  "
                        + "from location_log, tracking"
                        + "group by package_id";
        String querySecond = "select package_id, DATEDIFF(day, daysUntilDelivery.start_date, GETDATE()) as days_left"
                            +"from result;";

        try {
            Statement stmt = conn.createStatement();
            result = stmt.executeQuery(query);
            result = stmt.executeQuery(querySecond);

            while(result.next()) {
                String package_id = Integer.toString(result.getInt("package_id"));
                String DATEDIFF = Integer.toString(result.getInt("DATEDIFF"));
                objects.add(new Package(package_id,DATEDIFF));
            }
        } catch (SQLException e){
            return null;
        }

        return objects;
    }

    /**
     * Gets all packages at a shipping center
     */
    public static List<Object> shippingCenterPackages(Connection conn, String id){
        ResultSet result;
        List<Object> objects = new ArrayList<>();
        String query = "select vehicle.vehicle_id "
                        + "from tracking, vehicle "
                        + "where package.tracking_id = vehicle.tracking_id;";
        String querytwo = "select * "
                + "from vehicle "
                + "where vehicle.location = \'id\' ";
        String join = "packageResult inner join vehicleResult on "
                        +" packageResult.vehicle_id = vehicleResult.vehicle_id;";

        List<Object> pkgInfo = getPackageInfo(conn);
        try {
            Statement stmt = conn.createStatement();
            ResultSet packageResult = stmt.executeQuery(query);
            ResultSet vehicleResult = stmt.executeQuery(querytwo);
            result = stmt.executeQuery(join);
            while(result.next()){
                String vehicle_id = Integer.toString(result.getInt("vehicle_id"));
                for (Object object: pkgInfo) {
                    if(vehicle_id.equals(((Package) object).getVehicleId())){
                        objects.add(object);
                        pkgInfo.remove(object);
                        break;
                    }
                }
                Integer.toString(result.getInt("vehicle_id"));

            }
            return objects;
        }catch(SQLException e){
            return null;
        }


    }

    /**
     * Gets all trucks at a shipping center
     */
    public static List<Object> shippingCenterTrucks(Connection conn, String id){
        ResultSet result;
        List<Object> objects = new ArrayList<>();
        String query = "select * "
                        + "from vehicle "
                        + "where vehicle.id = \'id\' ";

        try {
            Statement stmt = conn.createStatement();
            result = stmt.executeQuery(query);

            while(result.next()) {
                String vehicle_id = Integer.toString(result.getInt("vehicle_id"));
                String vehicle_type = result.getString("vehicle_type");
                String origin_id = Integer.toString(result.getInt("origin_id"));
                String location = Integer.toString(result.getInt("location"));
                String destination_id = Integer.toString(result.getInt("destination_id"));
                objects.add(new Vehicle(vehicle_id,vehicle_type,origin_id,location,destination_id));
            }
            return objects;
        } catch (SQLException e){
            return null;
        }
    }

    /**
     * Get all weight classes
     */
    public static List<Object> getPackageWeights(Connection conn){
        ResultSet result;
        List<Object> objects = new ArrayList<>();
        String query = "select * "
                + "from package_weight;";

        try {
            Statement stmt = conn.createStatement();
            result = stmt.executeQuery(query);

            while(result.next()) {
                String weight_class = result.getString("weight_class");
                String cost_modifier = result.getString("cost_modifier");
                objects.add(new PackageType(weight_class,cost_modifier));
            }
            return objects;
        } catch (SQLException e){
            return null;
        }
    }

    /**
     * Get all package types
     */
    public static List<Object> getPackageTypes(Connection conn){
        ResultSet result;
        List<Object> objects = new ArrayList<>();
        String query = "select * "
                + "from package_class;";
        try {
            Statement stmt = conn.createStatement();
            result = stmt.executeQuery(query);

            while(result.next()) {
                String package_type = result.getString("package_type");
                String cost_modifier = result.getString("cost_modifier");
                objects.add(new PackageType(package_type,cost_modifier));
            }
            return objects;
        } catch (SQLException e){
            return null;
        }
    }

/*
    /**
     * Creates a Trigger that runs after a vehicle destination is updated.
     *  Updates the origin with the current location
     */
/*    public static boolean originTrigger(Connection conn){
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
    }*/

}

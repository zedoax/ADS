package org.aogiri.routes.ui;

import com.sun.xml.internal.bind.v2.runtime.reflect.Lister;
import org.aogiri.model.Database;
import org.aogiri.objects.*;
import org.aogiri.objects.Package;
import spark.*;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Zedoax on 1/27/2018.
 */
public class GetAdminRoute implements Route {

    // Static variables
    public static final String VIEW_NAME = "admin.ftl";
    public static final String PKG_VIEW_NAME = "pkg_admin.ftl";
    public static final String VEHICLE_VIEW_NAME = "vehicle_admin.ftl";
    public static final String STATION_VIEW_NAME = "station_admin.ftl";
    public static final String TITLE = "Amazan | Admin";

    // Instance variables
    private final TemplateEngine templateEngine;
    private final Connection conn;

    /**
     * Create the HTTP / GET Request Handle
     *
     * @param templateEngine - the HTML template rendering engine
     */
    public GetAdminRoute(final TemplateEngine templateEngine, final Connection conn) {
        this.templateEngine = templateEngine;
        this.conn = conn;
    }

    /**
     * Handles rendering the home screen
     *
     * @param request - the HTTP request
     * @param response - the HTTP response
     * @return the rendered HTML for the Home Page
     */
    public Object handle(Request request, Response response) throws Exception {

        // Retrieve the Session objects
        Session session = request.session();

        String pkg = request.queryParams("tracking");
        String vehicle = request.queryParams("vehicle");
        String station = request.queryParams("station");

        if(pkg != null) {
            // Build the view-model
            HashMap<String, Object> vm = new HashMap<>();

            // What must be populated
            vm.put("title", TITLE);
            Package sqlPkg = Database.getPackageInfo(conn, pkg);
            vm.put("package", sqlPkg);

            List<TrackingEntry> log = new ArrayList<>();
            // List<TrackingEntry> sqlLog = Database.
            // TODO; logger entries
            log.add(new TrackingEntry("aaaa", "01/01/18", "truck", "here"));
            vm.put("log", log);

            return templateEngine.render(new ModelAndView(vm, PKG_VIEW_NAME));
        }

        if(vehicle != null) {
            // Build the view-model
            HashMap<String, Object> vm = new HashMap<>();

            // What must be populated
            vm.put("title", TITLE);
            vm.put("vehicle", new Vehicle("a", "a", "a", "a", "a"));

            List<Package> current = new ArrayList<>();
            List<Package> sqlCurrent = Database.getTruckPackages(conn, vehicle);
            if(sqlCurrent != null) {
                current.addAll(sqlCurrent);
            }
            vm.put("current", current);

            List<Package> delivered = new ArrayList<>();
            List<Package> sqlDelivered = Database.getDeliveredTruckPackages(conn, vehicle);
            if(sqlDelivered != null) {
                delivered.addAll(sqlDelivered);
            }
            vm.put("delivered", delivered);

            return templateEngine.render(new ModelAndView(vm, VEHICLE_VIEW_NAME));
        }

        if(station != null) {
            // Build the view-model
            HashMap<String, Object> vm = new HashMap<>();

            // What must be populated
            vm.put("title", TITLE);
            // vm.put("station", new Station(station, "location"));
            List<Vehicle> vehicles = new ArrayList<>();
            vehicles.add(new Vehicle("a", "a", "a", "a", "a"));
            vm.put("vehicles", vehicles);
            List<Package> packages = new ArrayList<>();
            // packages.add(new Package("a","a","a","a","a","a","a","a",  true, true,"a","a", ((float)3.00)));
            vm.put("packages", packages);

            return templateEngine.render(new ModelAndView(vm, STATION_VIEW_NAME));
        }

        // Build the view-model
        HashMap<String, Object> vm = new HashMap<>();

        // What must be populated
        vm.put("title", TITLE);
        List<Vehicle> vehicles = new ArrayList<>();
//        List<Vehicle> sqlVehicles = Database.getTrucks(conn);
//        if(sqlVehicles != null) {
//            vehicles.addAll(sqlVehicles);
//        }
        vm.put("vehicles", vehicles);
        List<Station> stations = new ArrayList<>();
//        List<Station> sqlStations = Database.getStations(conn);
//        if(sqlStations != null) {
//            stations.addAll(sqlStations);
//        }
        vm.put("stations", stations);
        List<Package> packages = new ArrayList<>();
        List<Package> pkgs = Database.getPackageInfo(conn);
        if(pkgs != null) {
            packages.addAll(pkgs);
        }
        vm.put("packages", packages);
        List<User> users = new ArrayList<>();
//        List<User> sqlUsers = Database.getUsers();
//        if(sqlUsers != null) {
//            users.addAll(sqlUsers);
//        }
        vm.put("users", users);

        // Render the view
        return templateEngine.render(new ModelAndView(vm, VIEW_NAME));
    }
}

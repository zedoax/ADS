package org.aogiri.routes;

import com.sun.xml.internal.bind.v2.runtime.reflect.Lister;
import org.aogiri.objects.Station;
import org.aogiri.objects.User;
import org.aogiri.objects.Vehicle;
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

        // Build the view-model
        HashMap<String, Object> vm = new HashMap<>();

        // What must be populated
        vm.put("title", TITLE);
        List<Vehicle> vehicles = new ArrayList<>();
        vehicles.add(new Vehicle("0001", "truck", "sample", "sample 2", "sample 3"));
        vm.put("vehicles", vehicles);
        List<Station> stations = new ArrayList<>();
        stations.add(new Station("12220", "ayy"));
        vm.put("stations", stations);
        List<Package> packages = new ArrayList<>();
        vm.put("packages", packages);
        List<User> users = new ArrayList<>();
        vm.put("users", packages);

        // Render the view
        return templateEngine.render(new ModelAndView(vm, VIEW_NAME));
    }
}

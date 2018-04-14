package org.aogiri.routes.ui;

import org.aogiri.model.Database;
import org.aogiri.objects.Package;
import org.aogiri.objects.TrackingEntry;
import spark.*;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Zedoax on 1/26/2018
 */
public class GetTrackingRoute implements Route {

    // Static variables
    public static final String VIEW_NAME = "tracking.ftl";
    public static final String TITLE = "Amazan | Tracking";

    // Instance variables
    private final TemplateEngine templateEngine;
    private final Connection conn;

    /**
     * Create the HTTP / GET Request Handle
     *
     * @param templateEngine - the HTML template rendering engine
     */
    public GetTrackingRoute(final TemplateEngine templateEngine, final Connection conn) {
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

        // Retrieve session objects
        String id = request.queryParams("id");
        Package pkg;
        List<TrackingEntry> tracking = new ArrayList<>();

        if(id != null) {
            pkg = Database.getPackageInfo(conn, id);

            // TODO; Get package history
            tracking.add(new TrackingEntry("01/01/18","truck", "sample"));
        } else {
            pkg = null;
        }

        // Build the view-model
        HashMap<String, Object> vm = new HashMap<>();

        // What must be populated
        vm.put("title", TITLE);

        if(pkg != null) {
            vm.put("package", pkg);
            vm.put("tracking", tracking);
        }
        else {
            vm.put("invalid", 1);
            vm.put("message", "Tracking information not found");
        }

        // Render the view
        return templateEngine.render(new ModelAndView(vm, VIEW_NAME));
    }
}
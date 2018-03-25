package org.aogiri.routes;

import spark.*;

import java.sql.Connection;
import java.util.HashMap;

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

        // Retrieve the Session objects
        Session session = request.session();

        // Build the view-model
        HashMap<String, Object> vm = new HashMap<>();

        // What must be populated
        vm.put("title", TITLE);

         // vm.put("trackingid", "555555555555555555555555555");
         // vm.put("status", "ondewey");

//        vm.put("invalid", 1);
//        vm.put("message", "Tracking information not found");

        // Render the view
        return templateEngine.render(new ModelAndView(vm, VIEW_NAME));
    }
}
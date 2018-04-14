package org.aogiri.routes.ui;

import spark.*;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Zedoax on 1/25/2018
 */
public class GetPackagesRoute implements Route {

    // Static variables
    public static final String VIEW_NAME = "packages.ftl";
    public static final String TITLE = "Amazan | My Packages";

    // Instance variables
    private final TemplateEngine templateEngine;
    private final Connection conn;

    /**
     * Create the HTTP / GET Request Handle
     *
     * @param templateEngine - the HTML template rendering engine
     */
    public GetPackagesRoute(final TemplateEngine templateEngine, final Connection conn) {
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

        List<Package> packages = new ArrayList<>();
        vm.put("packages", packages);

        // Render the view
        return templateEngine.render(new ModelAndView(vm, VIEW_NAME));
    }
}

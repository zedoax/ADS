package org.aogiri.routes.ui;

import org.aogiri.model.Database;
import spark.*;

import java.sql.Connection;
import java.util.HashMap;

/**
 * Created by Zedoax on 1/26/2018
 */
public class GetProfileRoute implements Route {

    // Static variables
    public static final String VIEW_NAME = "profile.ftl";
    public static final String TITLE = "Amazan | My Profile";

    // Instance variables
    private final TemplateEngine templateEngine;
    private final Connection conn;

    /**
     * Create the HTTP / GET Request Handle
     *
     * @param templateEngine - the HTML template rendering engine
     */
    public GetProfileRoute(final TemplateEngine templateEngine, final Connection conn) {
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
        String username = session.attribute("username");

        // Build the view-model
        HashMap<String, Object> vm = new HashMap<>();

        // What must be populated
        vm.put("title", TITLE);
        vm.put("member", Database.getUserinfo(conn, username));

        // Render the view
        return templateEngine.render(new ModelAndView(vm, VIEW_NAME));
    }
}
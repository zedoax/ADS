package org.aogiri.routes;

import spark.*;

import java.util.HashMap;

/**
 * Created by Zedoax on 1/28/2018.
 */
public class GetLandingRoute implements Route {

    // Static variables
    public static final String VIEW_NAME = "landing.ftl";
    public static final String TITLE = "Amazan";

    // Instance variables
    private final TemplateEngine templateEngine;

    /**
     * Create the HTTP / GET Request Handle
     *
     * @param templateEngine - the HTML template rendering engine
     */
    public GetLandingRoute(final TemplateEngine templateEngine) {
        this.templateEngine = templateEngine;
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

        // Render the view
        return templateEngine.render(new ModelAndView(vm, VIEW_NAME));
    }
}

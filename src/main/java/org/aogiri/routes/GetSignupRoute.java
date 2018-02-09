package org.aogiri.routes;

import spark.*;

import java.util.HashMap;

/**
 * Created by Zedoax on 1/25/2018
 */
public class GetSignupRoute implements Route {

    // Static variables
    public static final String VIEW_NAME = "signup.ftl";
    public static final String TITLE = "Amazan | Sign Up";

    // Instance variables
    private final TemplateEngine templateEngine;

    /**
     * Create the HTTP / GET Request Handle
     *
     * @param templateEngine - the HTML template rendering engine
     */
    public GetSignupRoute(final TemplateEngine templateEngine) {
        this.templateEngine = templateEngine;
    }

    /**
     * Handles rendering the login
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
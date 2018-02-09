package org.aogiri.routes;

import com.google.gson.Gson;
import spark.*;

import java.util.HashMap;

/**
 * Created by Zedoax on 2/8/2018.
 */
public class PostSignupRoute implements Route{
    // Instance variables
    private final Gson gson;

    /**
     * Create the HTTP / GET Request Handle
     *
     * @param gson - Gson interpreter
     */
    public PostSignupRoute(final Gson gson) {
        this.gson = gson;
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

        // Personal Information
        String fname = request.queryParams("first-name");
        String lname = request.queryParams("last-name");
        String address = request.queryParams("address");
        String zipcode = request.queryParams("zipcode");

        // Account Information
        String username = request.queryParams("user");
        String passhash = request.queryParams("hash");
        String confirmPasshash = request.queryParams("hash-confirm");

        // Account Creation


        // Redirect the user after storing user information
        response.redirect("../", 302);
        return null;

    }
}

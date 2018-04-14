package org.aogiri.routes.creates;

import com.google.gson.Gson;
import spark.*;

import java.sql.Connection;
import java.util.HashMap;

/**
 * Created by Zedoax on 2/8/2018.
 */
public class PostSignupRoute implements Route{
    // Instance variables
    private final Gson gson;
    private final Connection conn;

    /**
     * Create the HTTP / GET Request Handle
     *
     * @param gson - Gson interpreter
     */
    public PostSignupRoute(final Gson gson, final Connection conn) {
        this.gson = gson;
        this.conn = conn;
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

        if(!passhash.equals(confirmPasshash)) {
            response.status(401);
            response.body("Invalid passwords");
            response.type("error");
            return null;
        }

        // Account Creation


        // Redirect the user after storing user information
        response.redirect("../", 302);
        return null;

    }
}

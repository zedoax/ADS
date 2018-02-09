package org.aogiri.routes;

import com.google.gson.Gson;
import spark.*;

/**
 * Created by Zedoax on 1/29/2018.
 */
public class PostLoginRoute implements Route{

    // Instance variables
    private final Gson gson;

    /**
     * Create the HTTP / GET Request Handle
     *
     * @param gson - the JSON parsing / creation tool
     */
    public PostLoginRoute(final Gson gson) {
        this.gson = gson;
    }

    /**
     * Handles rendering the home screen
     *
     * @param request - the HTTP request
     * @param response - the HTTP response
     * @return the POST response
     */
    public Object handle(Request request, Response response) throws Exception {

        // Retrieve the Session objects
        Session session = request.session();

        String hash = request.queryParams("hash");

        // Create and store a session token
        session.attribute("session_id", "test value");

        // Redirect the user to their profile
        response.redirect("../", 302);
        response.type("success");

        return null;

    }
}

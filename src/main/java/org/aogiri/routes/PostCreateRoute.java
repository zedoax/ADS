package org.aogiri.routes;

import com.google.gson.Gson;
import spark.Request;
import spark.Response;
import spark.Route;

/**
 * Created by Zedoax on 2/9/2018.
 */
public class PostCreateRoute implements Route {

    // Instance Variables
    private Gson gson;

    public PostCreateRoute(Gson gson) {
        this.gson = gson;
    }

    @Override
    public Object handle(Request request, Response response) throws Exception {
        // Retrieve creation arguments
        String destination;
        response.status(201);
        response.type("success");
        return response;
    }
}

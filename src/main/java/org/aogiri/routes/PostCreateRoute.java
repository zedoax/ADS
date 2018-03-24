package org.aogiri.routes;

import com.google.gson.Gson;
import spark.Request;
import spark.Response;
import spark.Route;

import java.sql.Connection;

/**
 * Created by Zedoax on 2/9/2018.
 */
public class PostCreateRoute implements Route {

    // Instance Variables
    private final Gson gson;
    private final Connection conn;

    public PostCreateRoute(final Gson gson, final Connection conn) {
        this.gson = gson;
        this.conn = conn;
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

package org.aogiri.routes.updates;

import com.google.gson.Gson;
import spark.Request;
import spark.Response;
import spark.Route;

import java.sql.Connection;

/**
 * Created by Zedoax on 4/13/2018.
 */
public class PostUpdateTruck implements Route {

    // Instance Variables
    private final Gson gson;
    private final Connection conn;

    public PostUpdateTruck(final Gson gson, final Connection conn) {
        this.gson = gson;
        this.conn = conn;
    }

    @Override
    public Object handle(Request request, Response response) throws Exception {
        // Retrieve change arguments
        String vehicle = request.queryParams("vehicle_id");
        String location = request.queryParams("location");
        String destination = request.queryParams("destination");

        //TODO; update truck in database


        response.status(201);
        response.type("success");
        return response;
    }
}

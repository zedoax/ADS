package org.aogiri.routes.creates;

import com.google.gson.Gson;
import spark.Request;
import spark.Response;
import spark.Route;

import java.sql.Connection;

/**
 * Created by Zedoax on 4/13/2018.
 */
public class PostCreateTruck implements Route {

    // Instance Variables
    private final Gson gson;
    private final Connection conn;

    public PostCreateTruck(final Gson gson, final Connection conn) {
        this.gson = gson;
        this.conn = conn;
    }

    @Override
    public Object handle(Request request, Response response) throws Exception {
        // Retrieve change arguments
        String address = request.queryParams("address");

        //TODO; update user's address in database


        response.status(201);
        response.type("success");
        return response;
    }
}

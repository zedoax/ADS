package org.aogiri.routes.updates;

import com.google.gson.Gson;
import spark.Request;
import spark.Response;
import spark.Route;

import java.sql.Connection;

/**
 * Created by Zedoax on 4/13/2018.
 */
public class PostUpdateBilling implements Route {

    // Instance Variables
    private final Gson gson;
    private final Connection conn;

    public PostUpdateBilling(final Gson gson, final Connection conn) {
        this.gson = gson;
        this.conn = conn;
    }

    @Override
    public Object handle(Request request, Response response) throws Exception {
        // Retrieve change arguments
        String billing = request.queryParams("cnumber")
                + " "
                + request.queryParams("expiry-m")
                + "/"
                + request.queryParams("expiry-y");

        //TODO; update user's billing in database

        response.status(201);
        response.type("success");
        return response;
    }

}

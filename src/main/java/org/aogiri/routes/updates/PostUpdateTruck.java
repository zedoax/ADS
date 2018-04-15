package org.aogiri.routes.updates;

import com.google.gson.Gson;
import org.aogiri.model.Database;
import org.aogiri.model.VehicleTable;
import spark.Request;
import spark.Response;
import spark.Route;
import spark.Session;

import java.sql.Connection;
import java.util.ArrayList;

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
        Session session = request.session();

        String vehicle = request.queryParams("vehicle_id");
        String location = request.queryParams("location");
        String destination = request.queryParams("destination");

        ArrayList<String> where = new ArrayList<>();
        where.add("id = '" + vehicle + "'");
        if(location != null) {
            VehicleTable.updateVehicle(conn, "location", location, where);
        }
        if(destination != null) {
            VehicleTable.updateVehicle(conn, "destination", destination, where);
        }

        response.status(201);
        response.type("success");
        return response;
    }
}

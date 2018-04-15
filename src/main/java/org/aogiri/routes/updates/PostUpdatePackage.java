package org.aogiri.routes.updates;

import com.google.gson.Gson;
import org.aogiri.model.PackageTable;
import spark.Request;
import spark.Response;
import spark.Route;
import spark.Session;

import java.sql.Connection;
import java.util.ArrayList;

/**
 * Created by Zedoax on 4/13/2018.
 */
public class PostUpdatePackage implements Route {

    // Instance Variables
    private final Gson gson;
    private final Connection conn;

    public PostUpdatePackage(final Gson gson, final Connection conn) {
        this.gson = gson;
        this.conn = conn;
    }

    @Override
    public Object handle(Request request, Response response) throws Exception {
        // Retrieve change arguments
        Session session = request.session();
        String username = session.attribute("username");

        String vehicle = request.queryParams("location");

        ArrayList<String> where = new ArrayList<>();
        where.add("username = '" + username + "'");
        PackageTable.updatePackage(conn, "location", vehicle, where);

        response.status(201);
        response.type("success");
        return response;
    }
}

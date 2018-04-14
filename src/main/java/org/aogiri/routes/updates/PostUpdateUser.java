package org.aogiri.routes.updates;

import com.google.gson.Gson;
import org.aogiri.model.AccountTable;
import org.aogiri.model.Database;
import spark.Request;
import spark.Response;
import spark.Route;
import spark.Session;

import java.sql.Connection;
import java.util.ArrayList;

/**
 * Created by Zedoax on 4/13/2018.
 */
public class PostUpdateUser implements Route{

    // Instance Variables
    private final Gson gson;
    private final Connection conn;

    public PostUpdateUser(final Gson gson, final Connection conn) {
        this.gson = gson;
        this.conn = conn;
    }

    @Override
    public Object handle(Request request, Response response) throws Exception {
        // Retrieve change arguments
        Session session = request.session();
        String member = request.queryParams("member");
        String membership = request.queryParams("membership");

        ArrayList<String> where = new ArrayList<>();
        where.add("username = '" + member + "'");
        AccountTable.updateAccount(conn, "membership", membership, where);

        response.status(201);
        response.type("success");
        return response;
    }
}

package org.aogiri.routes.updates;

import com.google.gson.Gson;
import org.aogiri.model.AccountTable;
import spark.Request;
import spark.Response;
import spark.Route;
import spark.Session;

import java.sql.Connection;
import java.util.ArrayList;

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
        Session session = request.session();
        String username = session.attribute("username");

        String cnum = request.queryParams("cnumber");
        String cexp = "parseDate("
                + request.queryParams("expiry-y")
                + "-"
                + request.queryParams("expiry-m")
                + "-"
                + "01)";

        ArrayList<String> where = new ArrayList<>();
        where.add("username = '" + username + "'");
        AccountTable.updateAccount(conn, "credit_card_number", cnum, where);
        AccountTable.updateAccount(conn, "credit_card_exp", cexp, where);

        response.status(201);
        response.type("success");
        return response;
    }

}

package org.aogiri.routes.updates;

import com.google.gson.Gson;
import org.aogiri.model.AccountTable;
import spark.Request;
import spark.Response;
import spark.Route;
import spark.Session;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Base64;

/**
 * Created by Zedoax on 4/13/2018.
 */
public class PostChangePassword  implements Route {

    // Instance Variables
    private final Gson gson;
    private final Connection conn;

    public PostChangePassword(final Gson gson, final Connection conn) {
        this.gson = gson;
        this.conn = conn;
    }

    @Override
    public Object handle(Request request, Response response) throws Exception {
        // Retrieve change arguments
        Session session = request.session();
        String username = session.attribute("username");

        String password = request.queryParams("password");
        String new_password = request.queryParams("new-password");
        String new_password_confirm = request.queryParams("new-password-confirm");

        if(!new_password.equals(new_password_confirm)) {
            response.status(400);
            response.type("error");
            response.body("Passwords do not match");
            return response;
        }

        ArrayList<String> where = new ArrayList<>();
        where.add("username = '" + username + "'");
        AccountTable.updateAccount(conn, "password", new String(Base64.getEncoder().encode((username + ":" + password).getBytes())), where);

        response.status(201);
        response.type("success");
        return response;
    }
}

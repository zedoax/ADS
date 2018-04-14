package org.aogiri.routes.updates;

import com.google.gson.Gson;
import spark.Request;
import spark.Response;
import spark.Route;

import java.sql.Connection;

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
        String password = request.queryParams("password");
        String new_password = request.queryParams("new-password");
        String new_password_confirm = request.queryParams("new-password-confirm");

        if(!new_password.equals(new_password_confirm)) {
            response.status(400);
            response.type("error");
            response.body("Passwords do not match");
            return response;
        }

        if(!password.equals("TODO; password check")) {
            response.status(401);
            response.type("error");
            response.body("Password invalid");
            return response;
        }

        //TODO; update user's password in database

        response.status(201);
        response.type("success");
        return response;
    }
}

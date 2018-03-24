package org.aogiri;

import com.google.gson.Gson;
import org.aogiri.routes.*;
import spark.TemplateEngine;

import java.sql.Connection;

import static spark.Spark.get;
import static spark.Spark.post;
import static spark.SparkBase.staticFileLocation;

/**
 * Created by Zedoax on 1/25/2018.
 *
 * The Class Responsible for declaring how content will be served
 */
public class WebServer {

    // Route Controller Constants
    private static final String HOME_URL = "/";
    private static final String LOGIN_URL = "/login";
    private static final String PACKAGES_URL = "/packages";
    private static final String PROFILE_URL = "/profile";
    private static final String TRACKING_URL = "/tracking";
    private static final String SIGN_UP_URL = "/signup";
    private static final String ADMIN_URL = "/admin";
    private static final String LANDING_URL = "/landing";
    private static final String CREATE_URL = "/create";
    private static final String LOGOUT_URL = "/logout";

    // Attributes
    private final TemplateEngine templateEngine;
    private final Connection conn;
    private final Gson gson;

    public WebServer(TemplateEngine templateEngine, Connection conn, Gson gson) {
        this.templateEngine = templateEngine;
        this.conn = conn;
        this.gson = gson;
    }

    /**
     * Method to declare the routes **SHOULD ONLY BE USED ONCE**
     */
    public void initialize() {
        // Configuration to serve static files
        staticFileLocation("/public");

        // Declare route handlers //
        get(HOME_URL, new GetHomeRoute(templateEngine, conn));
        get(LOGIN_URL, new GetLoginRoute(templateEngine, conn));
        post(LOGIN_URL, new PostLoginRoute(gson, conn));
        get(PACKAGES_URL, new GetPackagesRoute(templateEngine, conn));
        get(PROFILE_URL, new GetProfileRoute(templateEngine, conn));
        get(TRACKING_URL, new GetTrackingRoute(templateEngine, conn));
        get(SIGN_UP_URL, new GetSignupRoute(templateEngine, conn));
        post(SIGN_UP_URL, new PostSignupRoute(gson, conn));
        get(ADMIN_URL, new GetAdminRoute(templateEngine, conn));
        get(LANDING_URL, new GetLandingRoute(templateEngine, conn));
        post(CREATE_URL, new PostCreateRoute(gson, conn));

    }
}

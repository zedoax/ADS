package org.aogiri;

import com.google.gson.Gson;
import org.aogiri.routes.*;
import spark.TemplateEngine;

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

    // Attributes
    private final TemplateEngine templateEngine;
    private final Gson gson;

    public WebServer(TemplateEngine templateEngine, Gson gson) {
        this.templateEngine = templateEngine;
        this.gson = gson;
    }

    /**
     * Method to declare the routes **SHOULD ONLY BE USED ONCE**
     */
    public void initialize() {
        // Configuration to serve static files
        staticFileLocation("/public");

        // Declare route handlers //
        get(HOME_URL, new GetHomeRoute(templateEngine));
        get(LOGIN_URL, new GetLoginRoute(templateEngine));
        get(PACKAGES_URL, new GetPackagesRoute(templateEngine));
        get(PROFILE_URL, new GetProfileRoute(templateEngine));
        get(TRACKING_URL, new GetTrackingRoute(templateEngine));

    }
}

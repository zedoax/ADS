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
    private static final String TRUCK_URL = "/truck";
    private static final String PACKAGE_URL = "/package";
    private static final String PAYMENT_URL = "/pay";
    private static final String SCENTER_URL = "/shippingCenter";
    private static final String USER_URL = "/user";
    private static final String MEMBER_URL = "/membership";

    // Attributes
    private final TemplateEngine templateEngine;
    private final Connection user;
    private final Connection useradd;
    private final Connection tracking;
    private final Connection employee;
    private final Gson gson;

    public WebServer(
            TemplateEngine templateEngine,
            Connection user,
            Connection useradd,
            Connection tracking,
            Connection employee,
            Gson gson) {
        this.templateEngine = templateEngine;
        this.user = user;
        this.useradd = useradd;
        this.tracking = tracking;
        this.employee = employee;
        this.gson = gson;
    }

    /**
     * Method to declare the routes **SHOULD ONLY BE USED ONCE**
     */
    public void initialize() {
        // Configuration to serve static files
        staticFileLocation("/public");

        // Declare route handlers //
        get(HOME_URL, new GetHomeRoute(templateEngine, user));
        get(LOGIN_URL, new GetLoginRoute(templateEngine, user));
        post(LOGIN_URL, new PostLoginRoute(gson, user));
        get(PACKAGES_URL, new GetPackagesRoute(templateEngine, user));
        get(PROFILE_URL, new GetProfileRoute(templateEngine, user));
        get(TRACKING_URL, new GetTrackingRoute(templateEngine, tracking));
        get(SIGN_UP_URL, new GetSignupRoute(templateEngine, user));
        post(SIGN_UP_URL, new PostSignupRoute(gson, useradd));
        get(ADMIN_URL, new GetAdminRoute(templateEngine, employee));
        get(LANDING_URL, new GetLandingRoute(templateEngine));
        post(CREATE_URL, new PostCreateRoute(gson, user));

    }
}

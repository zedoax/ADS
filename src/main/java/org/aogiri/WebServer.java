package org.aogiri;

import com.google.gson.Gson;
import org.aogiri.routes.*;
import org.aogiri.routes.creates.PostCreateRoute;
import org.aogiri.routes.creates.PostCreateStation;
import org.aogiri.routes.creates.PostCreateTruck;
import org.aogiri.routes.creates.PostSignupRoute;
import org.aogiri.routes.ui.*;
import org.aogiri.routes.updates.*;
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
    private static final String PAYMENT_URL = "/pay";
    private static final String STATS_URL = "/admin/stats";
    private static final String MEMBER_URL = "/updateUser";
    private static final String ADDRESS_URL = "/updateAddress";
    private static final String PASSWORD_URL = "/updatePassword";
    private static final String BILING_URL = "/updateBilling";
    private static final String PACKAGE_URL = "/updatePackage";
    private static final String TRUCK_URL = "/updateTruck";
    private static final String USER_URL = "/updateUser";
    private static final String STATION_URL = "/createStation";
    private static final String CREATE_TRUCK_URL = "/createTruck";

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
        get(TRACKING_URL, new GetTrackingRoute(templateEngine, employee));
        get(SIGN_UP_URL, new GetSignupRoute(templateEngine, user));
        post(SIGN_UP_URL, new PostSignupRoute(gson, useradd));
        get(ADMIN_URL, new GetAdminRoute(templateEngine, employee));
        get(STATS_URL, new GetStatsRoute(templateEngine, employee));
        get(LANDING_URL, new GetLandingRoute(templateEngine));

        post(CREATE_URL, new PostCreateRoute(gson, user));
        post(STATION_URL, new PostCreateStation(gson, employee));
        post(CREATE_TRUCK_URL, new PostCreateTruck(gson, employee));

        post(ADDRESS_URL, new PostChangeAddress(gson, user));
        post(PASSWORD_URL, new PostChangePassword(gson, user));
        post(BILING_URL, new PostUpdateBilling(gson, user));
        post(PACKAGE_URL, new PostUpdatePackage(gson, user));
        post(TRUCK_URL, new PostUpdateTruck(gson, user));

    }
}

package org.aogiri.routes.ui;

import org.aogiri.model.Database;
import org.aogiri.objects.Package;
import spark.*;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Zedoax on 4/12/2018.
 */
public class GetStatsRoute implements Route {
    // Static variables
    public static final String VIEW_NAME = "stats.ftl";
    public static final String TITLE = "Amazan | Stats";

    // Instance variables
    private final TemplateEngine templateEngine;
    private final Connection conn;

    /**
     * Create the HTTP / GET Request Handle
     *
     * @param templateEngine - the HTML template rendering engine
     */
    public GetStatsRoute(final TemplateEngine templateEngine, final Connection conn) {
        this.templateEngine = templateEngine;
        this.conn = conn;
    }

    /**
     * Handles rendering the home screen
     *
     * @param request - the HTTP request
     * @param response - the HTTP response
     * @return the rendered HTML for the Home Page
     */
    public Object handle(Request request, Response response) throws Exception {

        // Retrieve the Session objects
        Session session = request.session();
        String sessionId = session.attribute("session_id");

        // Decide if a redirect is required
        if(sessionId == null) {
            response.redirect("../landing", 302);
        }

        // Build the view-model
        HashMap<String, Object> vm = new HashMap<>();

        // What must be populated
        vm.put("title", TITLE);

//        vm.put("order_user", Database.ownsMostPackages(conn));
//        vm.put("money_user",  Database.spentMostMoney(conn));
//        vm.put("street",  Database.getMostPopulated(conn));

        vm.put("order_user", "SaraJones");
        vm.put("money_user", "SaraJones");
        vm.put("street", "Money street New York 00521");

        List<Package> packages = new ArrayList<>();
        List<Package> sqlPackages = Database.latePackages(conn);
        if(sqlPackages != null) {
            packages.addAll(sqlPackages);
        }
        vm.put("packages", packages);

        // Render the view
        return templateEngine.render(new ModelAndView(vm, VIEW_NAME));
    }
}

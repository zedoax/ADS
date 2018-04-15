package org.aogiri.routes.ui;

import org.aogiri.model.Database;
import org.aogiri.objects.Package;
import org.aogiri.objects.PackageType;
import org.aogiri.objects.PackageWeight;
import spark.*;

import javax.xml.crypto.Data;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Zedoax on 1/25/2018
 */
public class GetHomeRoute implements Route {

    // Static variables
    public static final String VIEW_NAME = "index.ftl";
    public static final String TITLE = "Amazan | Home";

    // Instance variables
    private final TemplateEngine templateEngine;
    private final Connection conn;

    /**
     * Create the HTTP / GET Request Handle
     *
     * @param templateEngine - the HTML template rendering engine
     */
    public GetHomeRoute(final TemplateEngine templateEngine, final Connection conn) {
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

        // Billing
        List<Package> packages = new ArrayList<>();
        packages.add(new Package("11111", ((float)2.00)));
        vm.put("packages", packages);

        // Creation
        List<String> weights = new ArrayList<>();
        List<PackageWeight> sqlWeights = Database.getPackageWeights(conn);
        if(sqlWeights != null) {
            sqlWeights.forEach(t -> {weights.add(t.getWeightclass());});
        }
        vm.put("weights", weights);

        List<String> types = new ArrayList<>();
        List<PackageType> sqlTypes = Database.getPackageTypes(conn);
        if(sqlTypes != null) {
            sqlTypes.forEach(t -> {types.add(t.getPackagetype());});
        }
        vm.put("types", types);


        // Render the view
        return templateEngine.render(new ModelAndView(vm, VIEW_NAME));
    }
}

package org.aogiri;

import com.google.gson.Gson;
import spark.TemplateEngine;
import spark.template.freemarker.FreeMarkerEngine;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
  * Created by Zedoax on 1/25/2018.
 */
public class Application {

        // Attributes
        private final WebServer webServer;

        /**
         * Entry point for the web app
         * @param args cmd args
         */
        public static void main(String[] args){

            // Freemarker templates to generate HTML responses sent to client
            final TemplateEngine templateEngine = new FreeMarkerEngine();

            // H2 Database connection
            Connection conn = null;

            // Gson for converting ajax requests to json and vise versa
            final Gson gson = new Gson();

            // H2 Database
            try {
                // Database URL
                String url = "jdbc:h2:~/resources/db";

                // Use H2 Driver
                Class.forName("org.h2.Driver");

                // Database Connection
                conn = DriverManager.getConnection(url, "amazan", "amazingy");

                // Class.forName("org.h2.Driver");
            } catch (SQLException | ClassNotFoundException e) {
                e.printStackTrace();
                System.exit(1);
            }

            // Check for errors in H2 initialization
            if(conn == null) {
                // TODO: Initialization Error Handling
                System.exit(1);
            }

            // Inject the game center and freemarker engine into web server
            final WebServer webServer = new WebServer(templateEngine, conn, gson);

            // inject web server into application
            final Application application = new Application(webServer);

            // launch application
            application.initialize();
        }

        /**
         * Constructor for Application
         * @param webServer The webserver instance defined by the Application
         */
        public Application(WebServer webServer) {
            this.webServer = webServer;
        }

    /**
     * Method to declare the routes **SHOULD ONLY BE USED ONCE**
     */
    private void initialize() {
            // Configure Spark and startup Jetty web server
            webServer.initialize();
        }
}

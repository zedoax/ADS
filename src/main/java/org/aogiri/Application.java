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
     * Constructor for Application
     * @param webServer The webserver instance defined by the Application
     */
    public Application(WebServer webServer) {
        this.webServer = webServer;
    }

        private static Connection createConnection(String location,
                                 String user,
                                 String password){
            Connection conn;

            try {

                //This needs to be on the front of your location
                String url = "jdbc:h2:" + location;

                //This tells it to use the h2 driver
                Class.forName("org.h2.Driver");

                //creates the connection
                conn = DriverManager.getConnection(url,
                        user,
                        password);

                return conn;
            } catch (SQLException | ClassNotFoundException e) {
                //You should handle this better
                e.printStackTrace();
            }

            return null;
        }

        private static void closeConnection(Connection conn) {
            try {
                conn.close();
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
        }

        /**
         * Entry point for the web app
         * @param args cmd args
         */
        public static void main(String[] args){

            // Freemarker templates to generate HTML responses sent to client
            final TemplateEngine templateEngine = new FreeMarkerEngine();

            String location = "~/ads/ads";

            // H2 Database connection
            Connection user = createConnection(location, System.getenv("USER_USERNAME"), System.getenv("USER_PASSWORD"));
            Connection useradd = createConnection(location, System.getenv("USERADD_USERNAME"), System.getenv("USERADD_PASSWORD"));
            Connection tracking = createConnection(location, System.getenv("TRACKING_USERNAME"), "TRACKING_PASSWORD");
            Connection employee = createConnection(location, System.getenv("EMPLOYEE_USERNAME"), System.getenv("EMPLOYEE_PASSWORD"));

            // Check for errors in H2 initialization
            if(user == null || tracking == null || employee == null) {
                // TODO: Initialization Error Handling
                System.exit(1);
            }

            // Add shutdown closing
            Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        user.close();
                        tracking.close();
                        employee.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }));

            // Gson for converting ajax requests to json and vise versa
            final Gson gson = new Gson();

            // Inject the game center and freemarker engine into web server
            final WebServer webServer = new WebServer(templateEngine, user, useradd, tracking, employee, gson);

            // inject web server into application
            final Application application = new Application(webServer);

            // launch application
            application.initialize();
        }

    /**
     * Method to declare the routes **SHOULD ONLY BE USED ONCE**
     */
    private void initialize() {
            // Configure Spark and startup Jetty web server
            webServer.initialize();
        }

}

package org.aogiri;

import com.google.gson.Gson;
import org.h2.command.dml.RunScriptCommand;
import org.h2.tools.RunScript;
import spark.TemplateEngine;
import spark.template.freemarker.FreeMarkerEngine;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
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
                String url = "jdbc:h2:mem:" + location;

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

            // H2 Connection location and setup
            String url = "./ads";
            String cargs =  ";INIT=create schema if not exists ads\\;runscript from '" +
                    "classpath:public/sql/creation/createTables.sql'\\;runscript from '" +
                     "classpath:public/sql/population/account_population.sql'\\;runscript from '" +
                    "classpath:public/sql/population/contract_member_population.sql'\\;runscript from '" +
                    "classpath:public/sql/population/non_contract_member_population.sql'\\;runscript from '" +
                    "classpath:public/sql/population/package_class_population.sql'\\;runscript from '" +
                    "classpath:public/sql/population/package_weight_population.sql'\\;runscript from '" +
                    "classpath:public/sql/population/payment_population.sql'\\;runscript from '" +
                    "classpath:public/sql/population/station_population.sql'\\;runscript from '" +
                    "classpath:public/sql/population/vehicle_population.sql'\\;runscript from '" +
                    "classpath:public/sql/population/package_population.sql'\\;runscript from '" +
                    "classpath:public/sql/population/tracking_population.sql'\\;runscript from '" +
                    "classpath:public/sql/population/location_population.sql'\\;runscript from '" +
                    "classpath:public/sql/users/user_creation.sql'";

            // H2 Database connection
            Connection setup = createConnection(url + cargs, "root", "password");
            Connection user = createConnection(url, System.getenv("MEMBER_USERNAME"), System.getenv("MEMBER_PASSWORD"));
            Connection useradd = createConnection(url, System.getenv("MEMBERADD_USERNAME"), System.getenv("MEMBERADD_PASSWORD"));
            Connection tracking = createConnection(url, System.getenv("TRACKING_USERNAME"), System.getenv("TRACKING_PASSWORD"));
            Connection employee = createConnection(url, System.getenv("EMPLOYEE_USERNAME"), System.getenv("EMPLOYEE_PASSWORD"));

            // Check for errors in H2 initialization
            if(user == null || tracking == null || employee == null) {
                // TODO: Initialization Error Handling
                // System.exit(1);
            }

            // Add shutdown closing
            Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
                @Override
                public void run() {
                    closeConnection(user);
                    closeConnection(useradd);
                    closeConnection(tracking);
                    closeConnection(employee);
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

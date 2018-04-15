# ADS
Amazan Delivery Service: A Data Management Project with the goal of creating a Shipping Fulfillment Service

# Build Instructions
 - Download project using `git clone https://github.com/zedoax/ADS.git`
 - Enter the directory with a terminal and run maven using `mvn clean build` then `mvn exec:java -Dexec.mainClass="org.aogiri.Application"`
 - Navigate to http://localhost:4567 to begin
# Usage Instructions

When a user first navigates to the application, they will be greeted by a streamlined interface designed for the users to navigate where they need to go easily.  They can choose to track a package, login, or sign up.

When a user chooses to signup they are given this screen:

This screen is where the users enter their personal information, and submit the data to be entered into the database as a user.  We chose to enforce the restrictions for data here, instead of adding computational power to the backend to run information checks.


After a user signs up, they may click on the login navigation.

Here, they enter their login credentials to be authenticated against the database.  Passwords are hashed against the username in base64 so they are never stored in the database as plaintext.
After a user signs in, they will be taken to their home screen.  Here, they are shown their billing history, and are able to create a new package (package must be dropped off manually no teleporting).  If a user is not logged in and tries to access this page, they will be sent to the landing page.

A user can then navigate to their packages page.  This is where they are able to see all of the packages they have created and their delivery status.

When a user clicks on their profile, they will be taken to a page where they can update their billing information, and other aspects of their profile.  They can also see their name, address, and username

On the tracking page, both users and non users can enter in a tracking number to see the status of a package.  If there is no package with that number, the user will be shown an error message informing them of the issue.  Otherwise, they will see the package information, it’s status, and a list of locations it’s been and when.

---------------------------------------------------------------------------------------------------------------------

When an employee is on site, they can navigate to the admin panel.  This is where they can see all backend information, update trucks and delivery points, move packages between trucks, update user’s membership status, see stats on everything, and so on.


When a user clicks on the id of a truck, they can see the truck’s information, a list of packages it’s carrying, and a list of packages it’s delivered

The admin can also navigate to stats and see top statistics and packages that ended up missing their deadline.


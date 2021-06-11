/**
 * REFERENCES:
 * https://stackoverflow.com/questions/19605150/regex-for-password-must-contain-at-least-eight-characters-at-least-one-number-a - regex password matching (Srinivas, 2014).
 * https://www.geeksforgeeks.org/check-email-address-valid-not-java/ - email validation/regex (GeeksForGeeks, No Date).
 * https://doraprojects.net/blog/?p=2277 - tutorial how to setup sql driver (DoraProjects, 2016).
 * https://www.sqlitetutorial.net/sqlite-java/select/ - tutorial how to setup sql connection (SQLite Tutorial, No Date).
 * https://www.codejava.net/java-se/swing/jpasswordfield-basic-tutorial-and-examples - best practice on retrieving passwords (Minh, 2019).
 * https://examples.javacodegeeks.com/core-java/sql/getting-column-names-of-a-database-table/ - how to extract column names dynamically from a DB (Tsagklis, 2012).
 * https://stackoverflow.com/questions/2408541/align-the-values-of-the-cells-in-jtable - how to align specific columns in a JTable (camickr, 2010).
 * https://stackoverflow.com/questions/44432037/basicscrollbarui-how-to-use-it - custom scrollbar creation (Ansharja, 2017).
 * https://stackoverflow.com/questions/7633354/how-to-hide-the-arrow-buttons-in-a-jscrollbar/7661467 - how to hide arrows in scrollbar (Harry Lime, 2011).
 * https://stackoverflow.com/questions/1990817/how-to-make-a-jtable-non-editable - how to make cell in table editable/not editable (nelson eldoro, 2010).
 * https://stackoverflow.com/questions/38336113/jtable-if-any-row-is-selected - how to ensure that an empty table selection is not considered (user140547, 2016).
 * http://tutorials.jenkov.com/java-internationalization/decimalformat.html - how to format a string of numbers in a specific way (Jenkov, 2014).
 * https://www.youtube.com/watch?v=Jz8-ap--ZUA - how to create a JFreeChart and add to Form Editor Panel (zFlexSW, 2013).
 * https://stackoverflow.com/questions/9799494/jfreechart-how-to-improve-the-labels-in-a-pie-chart - how to update labels of pie chart (Grenier, 2012).
 * http://buttonoptimizer.com/ - used to create customised button images.
 * https://www.youtube.com/watch?v=fFhcOaVGioE&t=450s - how to send a verification code email from java application (TechSupportNep, 2019).
 * https://stackoverflow.com/questions/16115453/javamail-could-not-convert-socket-to-tls-gmail - how to fix convertin to socket error when trying to send verification code (Rafael, 2018).
 */
package cordismain;

/**
 * class from which the program starts by instantiating an object of CordisServer
 *
 * @author dim6ata
 * @author Michal
 * @author Iqram
 * @author Hayder
 */
public class CordisMain {

    /**
     *
     * @param args
     */
    public static void main(String[] args) {

        User user = new User();
        LoginUser loginUser = new LoginUser("Cordis Login");
        Gui gui = new Gui("Cordis Main");

        UserDB userDB = new UserDB();
        CordisDB cordisDB = new CordisDB();
        CordisServer cServer = new CordisServer(user, loginUser, gui, userDB, cordisDB);

        cServer.loginUser();//start with login.     

////////////////////////////////////////////////////////////////////////////////////////////
//FOR DEBUGGING PURPOSES:
//!!!!!!!!!!!!!!!!!!
//comment/uncomment lines that you want to run for quicker testing, when all ready it will start with loginUser.        
//when testing individual dashboards make sure that openGui below is always enabled, 
//because it sets the click listeners for the dashboards to work:
//        cServer.openGui();//start with openGui. 
//         cServer.openDashboard1();//start with Dashboard1;
//         cServer.openDashboard2();//start with Dashboard2;
//         cServer.openDashboard3();//start with Dashboard3;
//         cServer.openAdminPanel();//start with admin panel. //not yet working.Do not uncomment.
//         cordisDB.testConnection("999547074");//uncomment to test connection with CordisData
//            
    }

}

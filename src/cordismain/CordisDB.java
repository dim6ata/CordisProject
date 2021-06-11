package cordismain;

import SQL_Loader.Project;
import SQL_Loader.YearData;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * class that creates connection and retrieves information from the Cordis Database.
 *
 * @author Michal
 * @author dim6ata
 * @author Iqram
 * @author Hayder
 *
 */
public class CordisDB {

    private Map<String, String> allData;
    private Map<String, String> dashboard1Data;
    private Map<String, String> dashboard2Data;
    private Map<String, String> dashboard3Data;

    public CordisDB() {

    }

    /**
     * Method that creates a connection to database.
     *
     * @return {Connection}
     */
    private Connection connect() {

        String url = "jdbc:sqlite:CordisData.sqlite";
        Connection conn = null;

        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {

            System.out.println(e.getMessage());
        }
        return conn;
    }

    /**
     * Tests the connection with Cordis Database and
     * shows an example of how write safe queries.
     *
     * @param e is the value that you would like to be searched for in the DB.
     */
    public void testConnection(String e) {

        //example of working query.
        String select = "SELECT orgName, orgCountry "
                + "FROM Organization WHERE orgID = ?";

        try (Connection conn = this.connect();
                PreparedStatement ps = conn.prepareStatement(select);) {

            ps.setString(1, e);
            ResultSet resultSet = ps.executeQuery();

            while (resultSet.next()) {

                //number of queried columns has to match the number of getStrings below:
                System.out.println("Organisation Name is: " + resultSet.getString("orgName"));
                System.out.println("Organisation Country is: " + resultSet.getString("orgCountry"));

            }

        } catch (SQLException ex) {

            System.out.println(ex.getMessage());

        }

    }

    ////////////////////////////////////////////////////////////////////////////////////////
    //dim6ata START
    ////////////////////////////////////////////////////////////////////////////////////////
    /**
     * Retrieves data sets for Home page graphs and puts them in a map.
     *
     * @param selectOption
     * @return returns map that is retrieved when database is queried.
     * @author dim6ata
     */
    public Map<String, String> retrieveDataSetHomePage(int selectOption) {

        String select;
        Map<String, String> dataMap = new HashMap<>();

        switch (selectOption) {

            case 1:
                //query that selects a set of country codes, paired with the number of participants per selected country - TOP 10 selected:                 
                select = "SELECT orgCountry AS COUNTRY, COUNT(orgCountry) AS \"NUMBER OF PARTICIPANTS\" "
                        + "FROM Organization "
                        + "GROUP BY orgCountry "
                        + "ORDER BY \"NUMBER OF PARTICIPANTS\" DESC "
                        + "LIMIT 10";

                dataMap = homePageConnect(select, "COUNTRY", "NUMBER OF PARTICIPANTS");

                break;

            case 2:

                //query that selects the number of projects that end in a particular year:
                select = "SELECT strftime('%Y',(substr(projectEndDate, 7, 4) || '-' || "
                        + "substr(projectEndDate, 4, 2) || '-' || "
                        + "substr(projectEndDate, 1, 2))) as YEAR, "
                        + "COUNT(projectID) AS \"NUMBER OF PROJECTS\" "
                        + "FROM Project "
                        + "WHERE projectID IN (SELECT DISTINCT p.projectID "
                        + "FROM Organization o JOIN Project_Participant pp "
                        + "ON o.orgID = pp.orgID "
                        + "JOIN Project p "
                        + "ON pp.projectID = p.projectID) "
                        + "GROUP BY YEAR";

                dataMap = homePageConnect(select, "YEAR", "NUMBER OF PROJECTS");

                break;

            default:

        }

        return dataMap;
    }

    /**
     *
     * Retrieves individual elements from CordisDB for use in Home Page dashboard.
     *
     * @param selectOption
     * @return {String}
     * @author dim6ata
     */
    public String retrieveDataHomePage(int selectOption) {

        String select;
        String result = "";
        switch (selectOption) {

            //query that selects the total number of projects:
            case 1:

                select = "SELECT COUNT(projectID) AS TotalNumberProjects FROM Project "
                        + "WHERE projectID IN (SELECT DISTINCT p.projectID "
                        + "FROM Organization o JOIN Project_Participant pp "
                        + "ON o.orgID = pp.orgID "
                        + "JOIN Project p "
                        + "ON pp.projectID = p.projectID)";

                result = homePageConnect(select, "TotalNumberProjects");

                break;

            //query that selects the total cost of all projects:    
            case 2:

                select = "SELECT SUM(projectTotalCost) AS \"Total Cost\" "
                        + "FROM Project "
                        + "WHERE projectID IN (SELECT DISTINCT p.projectID "
                        + "FROM Organization o JOIN Project_Participant pp "
                        + "ON o.orgID = pp.orgID "
                        + "JOIN Project p "
                        + "ON pp.projectID = p.projectID)";

                result = homePageConnect(select, "Total Cost");

                break;

            //query that selects the number of participants:
            case 3:

                select = "SELECT COUNT(*) AS NumberParticipants "
                        + "FROM Organization";

                result = homePageConnect(select, "NumberParticipants");

                break;

            default:
                select = "";

        }

        return result;
    }

    /**
     * Method that connects to CordisDB and retrieves individual pieces of information for Home Page
     * data visualisation.
     *
     * @param select {String - a select statement that will be used to query database}
     * @param statement {String - a statement that is used to select a specific table from database}
     * @return {returns the value retrieved from database in String format}
     * @author dim6ata
     */
    private String homePageConnect(String select, String statement) {

        String result = "";

        try (Connection conn = this.connect();
                PreparedStatement ps = conn.prepareStatement(select);) {

            ResultSet resultSet = ps.executeQuery();

            while (resultSet.next()) {

                result = resultSet.getString(statement);

            }

        } catch (SQLException ex) {

            System.out.println(ex.getMessage());

        } finally {

            return result;
        }

    }

    /**
     * Method that connects to CordisDB and retrieves a set of key and value pairs.
     *
     * @param select {String - a select statement that will be used to query database}
     * @param keyStatement {String - a statement that is used to select a value from database that is saved as a key in a map}
     * @param valueStatement {String - a statement that is used to select a value from database that is saved as a value in a map}
     * @return {Map used for HomePage data visualisation}
     * @author dim6ata
     */
    private Map<String, String> homePageConnect(String select, String keyStatement, String valueStatement) {

        String key, value;
        Map<String, String> result = new HashMap<>();

        try (Connection conn = this.connect();
                PreparedStatement ps = conn.prepareStatement(select);) {

            ResultSet resultSet = ps.executeQuery();

            while (resultSet.next()) {

                key = resultSet.getString(keyStatement);
                value = resultSet.getString(valueStatement);

                result.put(key, value);

            }

        } catch (SQLException ex) {

            System.out.println(ex.getMessage());

        } finally {

            return result;
        }

    }//end homePageConnect();
    ////////////////////////////////////////////////////////////////////////////////////////
    //dim6ata END
    ////////////////////////////////////////////////////////////////////////////////////////

    ////////////////////////////////////////////////////////////////////////////////////////
    //IQRAM START
    ////////////////////////////////////////////////////////////////////////////////////////            
    /**
     * max query connection
     *
     * @return {ResultSet}
     * @author Iqram
     */
    public ResultSet SelectLineQuery() {

        // query
        String sql = "select MAX(p.projectTotalCost) as projectTotalCost, o.orgCountry from Project p join Project_Participant pp on p.projectID = pp.projectID join Organization o on pp.orgID = o.orgID group by o.orgCountry ORDER BY p.projectTotalCost DESC LIMIT 15";
        // Trying in case to handle exception
        try {
            // Getting connection
            Connection conn = connect();
            // Checking connection to database
            if (conn != null) {
                // Creating statement to start executing queries
                Statement stmt = conn.createStatement();
                // Creating query
                ResultSet ResultSetVar = stmt.executeQuery(sql);
                // Returning query with results
                return ResultSetVar;
            }
            // Null in case of no connection
            return null;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            // Null in case of no connection
            return null;
        }

    }

    /**
     * min query connection
     *
     * @return {ResultSet}
     * @author Iqram
     */
    public ResultSet SelectLineQuery2() {

        // query
        String sql = "select MIN(p.projectTotalCost) as projectTotalCost, o.orgCountry from Project p join Project_Participant pp on p.projectID = pp.projectID join Organization o on pp.orgID = o.orgID group by o.orgCountry ORDER BY p.projectTotalCost ASC LIMIT 15 ";
        // Trying in case to handle exception
        try {
            // Getting connection
            Connection conn = connect();
            // Checking connection to database
            if (conn != null) {
                // Creating statement to start executing queries
                Statement stmt = conn.createStatement();
                // Creating query
                ResultSet ResultSetVar = stmt.executeQuery(sql);
                // Returning query with results
                return ResultSetVar;
            }
            // Null in case of no connection
            return null;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            // Null in case of no connection
            return null;
        }

    }

    /**
     * average query connection
     *
     * @return {ResultSet}
     * @author Iqram
     */
    public ResultSet SelectBarQuery() {

        String sql = "select AVG(p.projectTotalCost) as projectTotalCost , o.orgCountry from Project p join Project_Participant pp on p.projectID = pp.projectID join Organization o on pp.orgID = o.orgID group by o.orgCountry";
        try {
            Connection conn = connect();
            if (conn != null) {
                //System.out.println(conn.getMetaData());
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
                return rs;
            }
            return null;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }

    }

    //most expensive seach query
    public ResultSet SearchMaxQuery(String text) {
        try {

            String sql = "select o.orgCountry, o.orgCity , p.projectID , MAX(p.projectTotalCost) as projectMaxCost , AVG(p.projectTotalCost) as averageCost from Project p join Project_Participant pp on p.projectID = pp.projectID join Organization o on pp.orgID = o.orgID "
                    + "where o.orgCountry like ?";

            Connection conn = connect();

            if (conn != null) {
                PreparedStatement pst = conn.prepareStatement(sql);
//                  pst.setString(1, SearchText.getText());
                pst.setString(1, text);
                ResultSet rs = pst.executeQuery();

                return rs;
            }

        } catch (Exception e) {

        }

        return null;
    }

    //most expensive seach query
    public ResultSet SearchMinQuery(String text) {
        try {

            String sql = "select o.orgCountry, o.orgCity , p.projectID , MIN(p.projectTotalCost) as projectMinCost from Project p join Project_Participant pp on p.projectID = pp.projectID join Organization o on pp.orgID = o.orgID "
                    + "where o.orgCountry like ?";

            Connection conn = connect();

            if (conn != null) {
                PreparedStatement pst = conn.prepareStatement(sql);
//                  pst.setString(1, SearchText.getText());
                pst.setString(1, text);
                ResultSet rs = pst.executeQuery();

                return rs;
            }

        } catch (Exception e) {

        }

        return null;
    }

    ////////////////////////////////////////////////////////////////////////////////////////
    //IQRAM END
    ////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////
    //MICHAL START
    ////////////////////////////////////////////////////////////////////////////////////////
    /**
     * Run SQL query, populate Array with YearData objects, this is later used for
     * data analysis with utility methods
     *
     * @return Array<YearData> - to create Data for Line chart
     */
    public ArrayList<YearData> displayQueryForLineGraph() {
        String sql = "Select DISTINCT p.projectID, p.projectStartDate, p.projectTotalCost "
                + "FROM Organization o JOIN Project_Participant pp "
                + "ON o.orgID = pp.orgID "
                + "JOIN Project p "
                + "ON p.projectID = pp.projectID "
                + "WHERE p.projectStatus = \"SIGNED\" OR p.projectStatus = \"CLOSED\"";

        List<Project> projectList = getAll(sql);

        double january = 0;
        double february = 0;
        double march = 0;
        double april = 0;
        double may = 0;
        double june = 0;
        double july = 0;
        double august = 0;
        double september = 0;
        double october = 0;
        double november = 0;
        double december = 0;

        int first = 0;

        ArrayList<YearData> dashArr = new ArrayList<>();

        YearData year2015 = new YearData("2015", january, february, march, april, may, june, july, august, september, october, november, december);
        YearData year2016 = new YearData("2016", january, february, march, april, may, june, july, august, september, october, november, december);
        YearData year2017 = new YearData("2017", january, february, march, april, may, june, july, august, september, october, november, december);
        YearData year2018 = new YearData("2018", january, february, march, april, may, june, july, august, september, october, november, december);
        YearData year2019 = new YearData("2019", january, february, march, april, may, june, july, august, september, october, november, december);

        for (Project project : projectList) {
            if (project.getProjectStartDate().contains("2015")) {
                //Split date 01/01/2015  Day/Month/Year
                String[] splitArr = project.getProjectStartDate().split("/");
                String month = splitArr[1];

                updateYearData(year2015, month, project.getProjectTotalCost());

            } else if (project.getProjectStartDate().contains("2016")) {
                String[] splitArr = project.getProjectStartDate().split("/");
                String month = splitArr[1];

                updateYearData(year2016, month, project.getProjectTotalCost());
            } else if (project.getProjectStartDate().contains("2017")) {
                String[] splitArr = project.getProjectStartDate().split("/");
                String month = splitArr[1];

                updateYearData(year2017, month, project.getProjectTotalCost());
            } else if (project.getProjectStartDate().contains("2018")) {
                String[] splitArr = project.getProjectStartDate().split("/");
                String month = splitArr[1];

                updateYearData(year2018, month, project.getProjectTotalCost());
            } else if (project.getProjectStartDate().contains("2019")) {
                String[] splitArr = project.getProjectStartDate().split("/");
                String month = splitArr[1];

                updateYearData(year2019, month, project.getProjectTotalCost());
            }
        }
        // rather costly method how to add all values in array for analysis
        year2015.loadINtoArray();
        year2016.loadINtoArray();
        year2017.loadINtoArray();
        year2018.loadINtoArray();
        year2019.loadINtoArray();

        //pass all YearData into an Array which is later used to build LineGraph data
        dashArr.add(year2015);
        dashArr.add(year2016);
        dashArr.add(year2017);
        dashArr.add(year2018);
        dashArr.add(year2019);

        return dashArr;
    }

    /**
     * After Object is loaded, Array is created inside the same object for further
     * analysis and visualisation
     *
     * @param yearToUpdate
     * @param month
     * @param maxCost
     */
    public void updateYearData(YearData yearToUpdate, String month, int maxCost) {
        switch (month) {
            case "01":
                yearToUpdate.setJanuary(yearToUpdate.getJanuary() + maxCost);
                break;
            case "02":
                yearToUpdate.setFebruary(yearToUpdate.getFebruary() + maxCost);
                break;
            case "03":
                yearToUpdate.setMarch(yearToUpdate.getMarch() + maxCost);
                break;
            case "04":
                yearToUpdate.setApril(yearToUpdate.getApril() + maxCost);
                break;
            case "05":
                yearToUpdate.setMay(yearToUpdate.getMay() + maxCost);
                break;
            case "06":
                yearToUpdate.setJune(yearToUpdate.getJune() + maxCost);
                break;
            case "07":
                yearToUpdate.setJuly(yearToUpdate.getJuly() + maxCost);
                break;
            case "08":
                yearToUpdate.setAugust(yearToUpdate.getAugust() + maxCost);
                break;
            case "09":
                yearToUpdate.setSeptember(yearToUpdate.getSeptember() + maxCost);
                break;
            case "10":
                yearToUpdate.setOctober(yearToUpdate.getOctober() + maxCost);
                break;
            case "11":
                yearToUpdate.setNovember(yearToUpdate.getNovember() + maxCost);
                break;
            case "12":
                yearToUpdate.setDecember(yearToUpdate.getDecember() + maxCost);
                break;
        }
    }

    /**
     * Get List to store the SQL query, each value is accessed by index
     * Get Set of all Countries which took a part in research, this is to
     * exclude duplicates
     * Get HashMap <STRING, INTEGER> alias (<Country, Amount of projects>)
     * This will add 1 project per country if country is either participant
     * or coordinator. For Example:
     * Project 1234 has 5 participants, 2 from CZ, CZ will
     * receive only 1 point.
     * This scans whole Query, then sorts the map in order from high to low
     *
     * @return HashMap - this is later used to display top 15 countries
     * as a data for bar graph
     */
    public HashMap<String, Integer> displayCountriesQuery() {
        String sql = "Select p.projectID , o.orgCountry "
                + "FROM Organization o JOIN Project_Participant pp "
                + "ON o.orgID = pp.orgID "
                + "JOIN Project p "
                + "ON p.projectID = pp.projectID "
                + "ORDER BY p.projectID ASC";

        List<Project> projectList = getCountries(sql);
        Set<String> countrySet = new HashSet<>();
        HashMap<String, Integer> myMap = new HashMap<>();

        int currentID = projectList.get(0).getProjectID();
        int previousID = currentID;

        for (Project project : projectList) {
            currentID = project.getProjectID();

            if (currentID == previousID) {
                String countryName = project.getCountryName();
                countrySet.add(countryName);
            } else if (currentID != previousID) {
                for (String country : countrySet) {
                    if (!myMap.containsKey(country)) {
                        myMap.put(country, 1);
                    } else if (myMap.containsKey(country)) {
                        myMap.put(country, myMap.get(country) + 1);
                    }
                }
                countrySet.clear();
            }
            previousID = currentID;
        }
        // run utility sort map function to order map from highest to lowest
        HashMap<String, Integer> sortedMap = sortByValues(myMap);

        return sortedMap;
    }

    /**
     * Reading all values from map taken from:
     * https://beginnersbook.com/2013/12/how-to-sort-hashmap-in-java-by-keys-and-values/
     *
     * @param myMap to sort from highest to lowest
     * @return sortedMap
     */
    public HashMap sortByValues(HashMap myMap) {
        List list = new LinkedList(myMap.entrySet());
        Collections.sort(list, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return ((Comparable) ((Map.Entry) (o2)).getValue()).compareTo(((Map.Entry) (o1)).getValue());
            }
        });

        HashMap sortedHashMap = new LinkedHashMap();

        for (Iterator it = list.iterator(); it.hasNext();) {
            Map.Entry entry = (Map.Entry) it.next();
            sortedHashMap.put(entry.getKey(), entry.getValue());
        }

        return sortedHashMap;
    }

    /**
     * **** Previous Utility Class ProjectDB *******
     */
    private Project getProjectRow(ResultSet rs) throws SQLException {
        int projectID = rs.getInt(1);
        String projectStartDate = rs.getString(2);
        int projectTotalCost = rs.getInt(3);

        Project project = new Project(projectID, projectStartDate, projectTotalCost);
        return project;
    }

    public List<Project> getAll(String sql) {
        List<Project> projectList = new ArrayList<>();

        try {
            Connection conn = connect();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Project project = getProjectRow(rs);
                projectList.add(project);
            }
            return projectList;
        } catch (SQLException e) {
            System.out.println("EXC: " + e);
            return null;
        }
    }

    public List<Project> getCountries(String sql) {
        List<Project> projectList = new ArrayList<>();

        try {
            Connection conn = connect();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Project project = getProjectRowForCountries(rs);
                projectList.add(project);
            }
            return projectList;
        } catch (SQLException e) {
            System.out.println("EXC: " + e);
            return null;
        }
    }

    private Project getProjectRowForCountries(ResultSet rs) throws SQLException {
        int projectID = rs.getInt(1);
        String countryName = rs.getString(2);
        Project project = new Project(projectID, countryName);
        return project;
    }
    ////////////////////////////////////////////////////////////////////////////////////////
    //MICHAL END
    ////////////////////////////////////////////////////////////////////////////////////////

    ////////////////////////////////////////////////////////////////////////////////////////
    //HAYDER START
    ////////////////////////////////////////////////////////////////////////////////////////
    /**
     * method that retrieves top 10 and lowest 10 contributors, their names, country and contribution.
     *
     * @param option - selector of which select statement to be ran.
     * @return Array List of Contributor, holding all queried information.
     */
    public ArrayList<Contributor> retrieveContributionData(int option) {

        String select;
        ArrayList<Contributor> contributorList = new ArrayList<>();

        switch (option) {

            case 1://max

                select = "SELECT orgName AS \"Organisation Name\", orgShortName as \"Short Name\", orgCountry AS Country, "
                        + "ecContribution as Contribution "
                        + "FROM Organization o JOIN Project_Participant p "
                        + "ON o.orgID == p.orgID "
                        + "AND Contribution != \"\" "
                        + "GROUP BY Contribution "
                        + "ORDER BY Contribution DESC "
                        + "LIMIT 10;";

                try {
                    Connection conn = connect();
                    PreparedStatement ps = conn.prepareStatement(select);
                    ResultSet rs = ps.executeQuery();

                    while (rs.next()) {
                        Contributor contributor = new Contributor();

                        contributor.setOrgName(rs.getString("Organisation Name"));
                        contributor.setOrgShortName(rs.getString("Short Name"));
                        contributor.setOrgCountry(rs.getString("Country"));
                        contributor.setContribution(rs.getDouble("Contribution"));

                        contributorList.add(contributor);

                    }
                    return contributorList;
                } catch (SQLException e) {
                    System.out.println("Exception 1: " + e);
                }

                break;

            case 2://min

                select = "SELECT orgName AS \"Organisation Name\", orgShortName as \"Short Name\", "
                        + "orgCountry AS Country, ecContribution as Contribution "
                        + "FROM Organization o JOIN Project_Participant p "
                        + "ON o.orgID == p.orgID "
                        + "AND Contribution != \"\" "
                        + "GROUP BY Contribution "
                        + "ORDER BY Contribution ASC "
                        + "LIMIT 10;";

                try {
                    Connection conn = connect();
                    PreparedStatement ps = conn.prepareStatement(select);
                    ResultSet rs = ps.executeQuery();

                    while (rs.next()) {
                        Contributor contributor = new Contributor();

                        contributor.setOrgName(rs.getString("Organisation Name"));
                        contributor.setOrgShortName(rs.getString("Short Name"));
                        contributor.setOrgCountry(rs.getString("Country"));
                        contributor.setContribution(rs.getDouble("Contribution"));

                        contributorList.add(contributor);

                    }
                    return contributorList;
                } catch (SQLException e) {
                    System.out.println("Exception 2: " + e);
                }

                break;

        }

        return null;

    }

    ////////////////////////////////////////////////////////////////////////////////////////
    //HAYDER END
    ////////////////////////////////////////////////////////////////////////////////////////
}

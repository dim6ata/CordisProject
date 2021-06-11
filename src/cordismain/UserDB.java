package cordismain;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.time.LocalDateTime;

/**
 *
 * Class that connects to User database and provides queries to retrieve and write data to database.
 *
 * @author dim6ata
 * Salt implementation referenced from lecture notes Week 8 (Girish Lukka, 2020);
 */
public class UserDB {

    private static final SecureRandom RANDOM = new SecureRandom();
    private static final String CHARACTERS = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz@#!£&*^";
    private static final int CYCLES = 1000;
    private static final int KEY_LENGTH = 512;
    private static final String ALGORITHM = "PBKDF2WithHmacSHA512";
    private ArrayList<User> allUsersData;
    private User userInfo;
    private ArrayList<DataUsage> dataUsage;
    private ArrayList<String> tableNames;

    /**
     * Method that creates a connection to database.
     *
     * @return {Connection}
     */
    private Connection connect() {

        String url = "jdbc:sqlite:userDB.db";
        Connection conn = null;

        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {

            System.out.println(e.getMessage());
        }
        return conn;
    }

    /**
     * verifies a user's password against a specific email.
     *
     * @param email {String - user's email}
     * @param password {char[] holding users password}
     * @return {int[] -
     * first value holds user's status - 1 for admin, 2 for user;
     * second value holds a number that corresponds to a message that the query returns}
     */
    public int[] verifyUser(String email, char[] password) {

        String select = "SELECT User.userEmail, User.userPassword, User.userStatus, User.accessCounter, User.userSalt "
                + "FROM USER WHERE User.userEmail = ?";
        boolean flag = false;
        boolean flagCounter = false;
        int status = 0;
        int message = 0;//means no message will be passed
        int tempCounter = 0;
        try (Connection conn = this.connect();
                PreparedStatement ps = conn.prepareStatement(select);) {

            ps.setString(1, email);
            ResultSet resultSet = ps.executeQuery();

            while (resultSet.next()) {

                if (resultSet.getString("userEmail").equals(email)) {//goes ahead only when email matches

                    String accessCounter = resultSet.getString("accessCounter");
                    if (accessCounter != null) {
                        tempCounter = Integer.parseInt(accessCounter);
                    }

                    if (tempCounter < 20) {//number of wrong attempts allowed for a customer per password.

                        String storedPassword = resultSet.getString("userPassword");
                        String salt = resultSet.getString("userSalt");

                        if (verifyPassword(password, storedPassword, salt)) {

                            if (resultSet.getString("userStatus").equals("admin")) {
                                status = 1;//when userStatus is admin
                            } else if (resultSet.getString("userStatus").equals("user")) {
                                status = 2;//when userStatus is user
                            }

                        } else {//when password is wrong

                            message = 2;//for message that will return wrong password value
                            flagCounter = true;
                        }

                    } else {

                        message = 3;//your account will now be blocked until you change the password. 

                    }

                    flag = true;

                }//end check email.

            }//end while

            if (!flag) {

                message = 1;//in case the email is wrong. 
            }
            if (flagCounter) {

                setAccessCounter(email, tempCounter);//update accessCounter  
            }

        } catch (SQLException e) {

            System.out.println(e.getMessage());

        }

        int[] array = {status, message};
        //returning 1 for admin, 2 for user, 0 for none; 
        return array;
    }//end verifyUser();

    /**
     * registers user. Checks if email exists and if not, creates a user in database.
     *
     * @param name {String - user's name}
     * @param email {String - user's email}
     * @param password {char[] - user's password}
     * @return {returns a value that represents message which the query returns}
     */
    public int registerUser(String name, String email, char[] password) {

        //performing check if email exists before anything else is done:            
        String select = "SELECT User.userEmail FROM USER WHERE User.userEmail = ?";

        boolean flag = true;
        int message = 0;
        try (Connection conn = this.connect();
                PreparedStatement ps = conn.prepareStatement(select);) {

            ps.setString(1, email);
            ResultSet resultSet = ps.executeQuery();

            while (resultSet.next()) {

                if (resultSet.getString("userEmail").equals(email)) {

                    flag = false;
                    message = 2;//email already on our system message

                }
            }//end loop

        } catch (SQLException e) {

            System.out.println(e.getMessage());

        }

        if (flag) {

            String salt = getSalt(30);

            String sql = "INSERT INTO User(userName, userEmail, userPassword, userStatus, accessCounter, userSalt) Values(?,?,?,?,?,?)";
            try (Connection conn = this.connect();
                    PreparedStatement st = conn.prepareStatement(sql)) {

                st.setString(1, name);
                st.setString(2, email);
                st.setString(3, generateSecurePassword(password, salt));
                st.setString(4, "user");
                st.setString(5, "0");
                st.setString(6, salt);
                st.executeUpdate();
                message = 1;//successful registration. 

            } catch (SQLException e) {

                System.out.println(e.getMessage());

            }
        }

        return message;

    }

    /**
     * verifies user's email.
     *
     * @param email {String email}
     * @return {returns true if the user is verified and false if not}
     */
    public boolean verifyUserEmail(String email) {

        String select = "SELECT User.userEmail "
                + "FROM USER WHERE User.userEmail = ?";

        boolean flag = false;

        try (Connection conn = this.connect();
                PreparedStatement ps = conn.prepareStatement(select);) {

            ps.setString(1, email);
            ResultSet resultSet = ps.executeQuery();

            while (resultSet.next()) {

                if (resultSet.getString("userEmail").equals(email)) {

                    //if it is means we go ahead and send the code - so a new message will be generated
                    flag = true;
                }
            }

        } catch (SQLException e) {

            System.out.println(e.getMessage());

        }

        return flag;
    }

    /**
     * updates user's password and encrypts it. 
     *
     * @param email {String - user's email}
     * @param password {char[] user's password}
     * 
     */
    public void updatePassword(String email, char[] password) {

        String salt = getSalt(30);
        String select = "UPDATE User SET userPassword = ?, accessCounter = ?, userSalt = ? WHERE User.userEmail = ?";

        try (Connection conn = this.connect();
                PreparedStatement st = conn.prepareStatement(select);) {

            st.setString(1, generateSecurePassword(password, salt));//stores salted password
            st.setString(2, "0");//stores initial counter 
            st.setString(3, salt);//stores salt that is used to encrypt user's password
            st.setString(4, email);
            st.execute();

        } catch (SQLException e) {

            System.out.println(e.getMessage());

        }

    }

    /**
     * Starts a new session when the user logs in. 
     * Stores login details to database.
     * 
     * @param email {String - user's email}
     * @return {returns session ID number.}
     */
    public int startNewSession(String email) {

        LocalDateTime timeStamp = getDateTime();

        int userId = getUserId(email);

        int sessionID = 0;

        String sql = "INSERT INTO DataUsage(dateIn, uID) Values(?,?)";
        String sql2 = "SELECT sessionID FROM DataUsage WHERE dateIn >= ? AND uID = ?";

        try {
            Connection conn = this.connect();

            try {
                PreparedStatement st = conn.prepareStatement(sql);

                st.setObject(1, timeStamp);
                st.setInt(2, userId);
                st.executeUpdate();

            } catch (SQLException e) {

                System.out.println(e.getMessage());

            } finally {

                try {
                    PreparedStatement st2 = conn.prepareStatement(sql2);
                    st2.setObject(1, timeStamp);
                    st2.setInt(2, userId);
                    ResultSet resultSet = st2.executeQuery();

                    while (resultSet.next()) {

                        sessionID = resultSet.getInt("sessionID");

                    }

                } catch (SQLException e) {

                    System.out.println(e.getMessage());

                }

            }

            conn.close();
        } catch (SQLException ex) {

        }

        return sessionID;
    }

    /**
     * ends session when a user logs out. 
     * Stores session data to database
     * 
     * @param sessionID {updates current records that correspond to that sessionID}
     */
    public void endSession(int sessionID) {

        LocalDateTime logOutTime = getDateTime();
        String select = "UPDATE DataUsage SET dateOut = ? WHERE sessionID = ?";

        try (Connection conn = this.connect();
                PreparedStatement ps = conn.prepareStatement(select)) {

            ps.setObject(1, logOutTime);
            ps.setInt(2, sessionID);
            ps.executeUpdate();

        } catch (SQLException e) {

            System.out.println(e.getMessage());

        }

    }

    /**
     * retrieves all available activities stored in database.
     * 
     * @return {ArrayList - returns a list of activityID numbers that are used for user's activity monitoring}
     */
    public ArrayList<Integer> populateActivityList() {

        String select = "SELECT activityID FROM ActivityType";
        ArrayList<Integer> tempList = new ArrayList<>();

        try (Connection conn = this.connect();
                PreparedStatement ps = conn.prepareStatement(select)) {

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                tempList.add(rs.getInt("activityID"));
            }

        } catch (SQLException e) {

        }
        return tempList;

    }

    /**
     * inserts user's activity into database.
     * @param sessionID {the current session's ID number}
     * @param activity {the ID of the activity that the user has selected}
     */
    public void setCurrentActivity(int sessionID, int activity) {

        String insert = "INSERT INTO LogActivity(activityID,sessionID,timeStamp) Values(?,?,?)";
        LocalDateTime timeStamp = getDateTime();

        try (Connection conn = this.connect();
                PreparedStatement ps = conn.prepareStatement(insert)) {

            ps.setInt(1, activity);
            ps.setInt(2, sessionID);
            ps.setObject(3, timeStamp);
            ps.execute();

        } catch (SQLException e) {

            System.out.println(e.getMessage());
        }

    }

    /**
     * retrieves user's ID number
     * 
     * @param email {String - user's email}
     * @return {returns user's ID number}
     */
    public int getUserId(String email) {

        String select = "SELECT User.userID "
                + "FROM USER WHERE User.userEmail = ?";

        String tempId = null;
        int userId = 0;

        try (Connection conn = this.connect();
                PreparedStatement ps = conn.prepareStatement(select);) {

            ps.setString(1, email);
            ResultSet resultSet = ps.executeQuery();

            while (resultSet.next()) {

                tempId = resultSet.getString("userID");
            }

        } catch (SQLException e) {

            System.out.println(e.getMessage());

        } finally {

            userId = Integer.parseInt(tempId);

            return userId;
        }

    }

    /**    
     * @return {returns the current LocalDateTime}
     */
    public LocalDateTime getDateTime() {

        LocalDateTime newDate = LocalDateTime.now().withNano(0);

        return newDate;

    }

    /**
     * retrieves a list of all user's session details
     * @param userID
     * @return {returns an ArrayList of SessionDetails that hold user's session information}
     */
    public ArrayList<SessionDetails> getSessionDetals(int userID) {

        ArrayList<SessionDetails> sDetails = new ArrayList<>();
        tableNames = new ArrayList<>();
        String select = "SELECT sessionID AS 'SESSION ID', dateIn AS 'LOGIN TIME', dateOut AS 'LOGOUT TIME' "
                + "FROM DataUsage "
                + "WHERE uID = ?";

        SessionDetails sD;
        try (Connection conn = this.connect();
                PreparedStatement ps = conn.prepareStatement(select)) {

            ps.setInt(1, userID);

            ResultSet rs = ps.executeQuery();
            createTableNames(rs);

            while (rs.next()) {

                sD = new SessionDetails();

                sD.setSessionID(rs.getInt("SESSION ID"));
                sD.setDateTimeIn(rs.getString("LOGIN TIME"));
                sD.setDateTimeOut(rs.getString("LOGOUT TIME"));
                sDetails.add(sD);

            }

        } catch (SQLException e) {

            System.out.println(e.getMessage());
        }

        return sDetails;

    }

    /**
     * retrieves activity list for a selected user.
     * Dynamic column name extraction referenced from (Tsagklis, 2012);
     *
     * @param sessionID
     * @return {returns an ArrayList of DataUsage that holds user's activity information}
     */
    public ArrayList<DataUsage> getUserActivity(int sessionID) {

        dataUsage = new ArrayList<>();
        tableNames = new ArrayList<>();

        String select = "SELECT l.logID AS 'LOG ID', a.activityName AS 'SELECTED', "
                + "l.timeStamp AS 'TIME STAMP' "
                + "FROM LogActivity l JOIN ActivityType a "
                + "ON l.activityID = a.activityID "
                + "AND l.sessionID = ? ";

        try (Connection conn = this.connect();
                PreparedStatement ps = conn.prepareStatement(select)) {

            ps.setInt(1, sessionID);

            ResultSet rs = ps.executeQuery();

            createTableNames(rs);
            DataUsage dU;

            while (rs.next()) {

                dU = new DataUsage();

                dU.setLogId(rs.getInt("LOG ID"));
                dU.setActivityName(rs.getString("SELECTED"));
                dU.setTimeStamp(rs.getString("TIME STAMP"));

                dataUsage.add(dU);

            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return dataUsage;

    }

    /**
     * retrieves user information from database.
     * 
     * @param email {user's email}
     * @return {returns User}
     */
    public User retrieveUserFromDB(String email) {

        userInfo = new User();

        String select = "SELECT userID, userEmail, userName, userStatus "
                + "FROM USER WHERE User.userEmail = ?";

        //set time for login
        try (Connection conn = this.connect();
                PreparedStatement ps = conn.prepareStatement(select);) {

            ps.setString(1, email);
            ResultSet resultSet = ps.executeQuery();

            while (resultSet.next()) {

                userInfo.setUserId(resultSet.getInt("userID"));
                userInfo.setEmail(resultSet.getString("userEmail"));
                userInfo.setName(resultSet.getString("userName"));
                userInfo.setUserStatus(resultSet.getString("userStatus"));

            }

        } catch (SQLException e) {

            System.out.println(e.getMessage());

        }

        return this.userInfo;
    }

    /**
     * retrieves a list of all users
     * @return {returns an ArrayList of User objects}
     */
    public ArrayList<User> retrieveAllUsers() {

        this.allUsersData = new ArrayList<>();
        tableNames = new ArrayList<>();

        String select = "SELECT userName AS 'NAME', userID AS 'ID', userEmail AS 'EMAIL',"
                + " userStatus AS 'STATUS', accessCounter AS 'PASS ERRORS'"
                + " FROM User";

        User user;
        try (Connection conn = this.connect();
                PreparedStatement ps = conn.prepareStatement(select)) {

            ResultSet rs = ps.executeQuery();
            createTableNames(rs);

            while (rs.next()) {

                user = new User();

                user.setName(rs.getString("NAME"));
                user.setUserId(rs.getInt("ID"));
                user.setEmail(rs.getString("EMAIL"));
                user.setUserStatus(rs.getString("STATUS"));
                user.setPasswordErrors(rs.getInt("PASS ERRORS"));
                allUsersData.add(user);

            }

        } catch (SQLException e) {

            System.out.println(e.getMessage());
        }

        return this.allUsersData;
    }

    /**
     *
     * updates user's information. 
     * Used when admin edits user data in admin panel.
     * 
     * @param name 
     * @param userID
     * @param email
     * @param passCount
     * @param status
     * @return {returns true if the data has been updated and false if there has been a problem and update could not be completed.}
     */
    public boolean updateUserData(String name, int userID, String email, int passCount, String status) {

        String select = "UPDATE User SET userName = ? , userEmail = ?,"
                + " accessCounter = ?, userStatus = ?  WHERE userID = ?";

        try (Connection conn = this.connect();
                PreparedStatement ps = conn.prepareStatement(select)) {

            ps.setString(1, name);
            ps.setString(2, email);
            ps.setInt(3, passCount);
            ps.setString(4, status);
            ps.setInt(5, userID);

            ps.executeUpdate();

            return true;

        } catch (SQLException e) {

            System.out.println(e.getMessage());
        }

        return false;

    }

    /**
     * deletes user. 
     * 
     * @param userID
     * @return {returns true if user has been deleted and false if there has been a problem and delete could not be completed.}
     */
    public boolean deleteUser(int userID) {

        String select = "DELETE FROM User WHERE userID = ?";

        try (Connection conn = this.connect();
                PreparedStatement ps = conn.prepareStatement(select)) {

            ps.setInt(1, userID);

            ps.executeUpdate();

            return true;
        } catch (SQLException e) {

            System.out.println(e.getMessage());
        }

        return false;//when something goes wrong

    }

    /**
     * updates access counter every time a user enters an incorrect password.
     *
     * @param email value that is searched with in the query
     * @param currentValue the value of access counter that is retrieved from database in previous query.
     */
    private void setAccessCounter(String email, int currentValue) {

        String select = "UPDATE User SET accessCounter = ? WHERE User.userEmail = ?";

        try (Connection conn = this.connect();
                PreparedStatement st = conn.prepareStatement(select);) {

            String s = String.valueOf(currentValue + 1);

            st.setString(1, s);
            st.setString(2, email);
            st.execute();

        } catch (SQLException e) {

            System.out.println(e.getMessage());

        }

    }

    /**
     * sets a new value for salt in DB when a new password is created
     * Referenced from Lukka(2020);
     *
     * @param email
     */
    private String getSalt(int length) {

        StringBuilder salt = new StringBuilder(length);
        for (int i = 0; i < length; i++) {

            salt.append(CHARACTERS.charAt(RANDOM.nextInt(CHARACTERS.length())));
        }

        return salt.toString();

    }

    /**
     * creates a hash associated with a given salt value and a specific user's password.
     * Referenced from Lukka(2020);
     *
     * @param password {user's password}
     * @param salt {salt associated with the password}
     * @return {returns byte[] which holds the hashed password}
     */
    private byte[] hash(char[] password, byte[] salt) {

        PBEKeySpec spec = new PBEKeySpec(password, salt, CYCLES, KEY_LENGTH);
        Arrays.fill(password, Character.MIN_VALUE);
        try {
            SecretKeyFactory key = SecretKeyFactory.getInstance(ALGORITHM);
            return key.generateSecret(spec).getEncoded();

        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            throw new AssertionError("Password hashing error: " + e.getMessage(), e);

        } finally {
            spec.clearPassword();
            System.gc();//calls garbage collector to clear memory and secure password.
        }

    }

    /**
     * generates a secure password by hashing it and adding salt to it.
     * Referenced form Lukka (2020).
     *
     * @param password {user's password}
     * @param salt {salt associated with password}
     * @return {returns new encrypted password}
     */
    private String generateSecurePassword(char[] password, String salt) {

        String securePassword = null;

        byte[] generatedPassword = hash(password, salt.getBytes());
        securePassword = Base64.getEncoder().encodeToString(generatedPassword);
        return securePassword;

    }

    /**
     * verifies if password that is entered by user matches password that is kept on the system.
     * Referenced by Lukka(2020).
     *
     * @param enteredPassword
     * @param storedPassword
     * @param salt
     * @return {returns true if verification passes}
     */
    private boolean verifyPassword(char[] enteredPassword, String storedPassword, String salt) {

        boolean isValid = false;

        String checkPassword = generateSecurePassword(enteredPassword, salt);

        isValid = checkPassword.equalsIgnoreCase(storedPassword);

        return isValid;

    }

    /**
     * sets up the column names of tables that will be displayed in GUI/ADMIN
     *
     * @param rs result set that contains retrieved database values.
     * @throws SQLException
     */
    private void createTableNames(ResultSet rs) throws SQLException {

        tableNames = new ArrayList<>();
        try {
            ResultSetMetaData metadata = rs.getMetaData();

            int columnCount = metadata.getColumnCount();

            // Get the column names; column indices start from 1
            for (int i = 1; i <= columnCount; i++) {

                String columnName = metadata.getColumnName(i);

                tableNames.add(columnName);

            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    /**
     * 
     * @return {returns an ArrayList with the table names queried in createTableNames() method}
     */
    public ArrayList<String> getTableNames() {
        return tableNames;
    }

}

package cordismain;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Properties;
import java.util.Random;
import java.util.regex.Pattern;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 * Class that acts as a controller in an MVC design pattern.
 *
 * @author dim6ata
 * @author Michal
 * @author Iqram
 * @author Hayder
 */
public class CordisServer {

    private User userControl;
    private LoginUser loginControl;
    private Gui guiControl;
    private UserDB userDBControl;
    private CordisDB cordisDBControl;
    private int buttonSwitcher;
    private RegisterUser regUser;
    private ForgottenPassword forgetPassPanel;
    private ChangePassword changePass;
    private int randomCode;
    private boolean isButtonClicked = false;
    private VerifyUser verifyUser;
    private static int counter = 5;//used for number of wrong attempts allowed when entering login verification code.
    private String emailForPassChange;
    private AdminPanel adminPanel;
    private boolean checkStatus;
    private ArrayList<Integer> activityOptions;
    private SessionDetails currentSession = new SessionDetails();

    private final String EMAIL_REGEX = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";

    private final String PASSWORD_REGEX = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,15}$";//requires 8-15 characters 
    //at least 1 capital letter, at least one of @$!%*?& symbols and at least one digit. 

    private final String NAME_REGEX = "^[a-zA-Z][a-zA-Z\\s\\-]*[a-zA-Z]$";//does not allow numbers or characters except for - and empty space

    /**
     * Constructor
     *
     * @param user
     * @param login
     * @param gui
     * @param uDb
     * @param cDb
     */
    public CordisServer(User user, LoginUser login, Gui gui, UserDB uDb, CordisDB cDb) {
        this.userControl = user;
        //this.loginControl = login;
        this.guiControl = gui;
        this.userDBControl = uDb;
        this.cordisDBControl = cDb;
        checkStatus = true;//in case it is a user.
        activityOptions = userDBControl.populateActivityList();

    }

    ////////////////////////////////////////////////////////////////////////////////////////
    /**
     * is called every time a button is pressed in login sequence windows.
     *
     * @param evt receives a mouse click event
     * @param button determines which button has been pressed. Each different operation will send a different button code;
     * Button 1 - Login button on Login Page;
     * Button 2 - Register button on Registration Page;
     * Button 3 - OK button in Registration Page;
     * Button 4 - Cancel button in Registration Page;
     * Button 5 - Forgotten Password button in Login Page;
     * Button 6 - Send button on Forgotten Password Page;
     * Button 7 - Confirm button on Forgotten Password Page;
     * Button 8 - Remembered password button on Forgotten Password Page. ;
     * Button 9 - Confirm button on Change Password Page;
     * Button 10 - Cancel button on Change Password Page;
     */
    public void buttonMouseClicked(MouseEvent evt, int button) {

        switch (button) {

            case 1: {
                //login button

                String enteredEmail = loginControl.getEnteredEmail();
                char[] enteredPassword = loginControl.getEnteredPassword();

                if (isValid(enteredEmail, EMAIL_REGEX)) {//checks email
                    if (isValid(String.valueOf(enteredPassword), PASSWORD_REGEX)) {//checks password

                        int[] returnArray = userDBControl.verifyUser(enteredEmail, enteredPassword);

                        if (returnArray[1] != 0) {

                            switch (returnArray[1]) {
                                case 1:
                                    loginControl.setMessage("This email does not match our records");
                                    break;
                                case 2:
                                    loginControl.setMessage("This Password is incorrect");//check in DB                                  
                                    break;
                                case 3:
                                    loginControl.setMessage("<html><div style='text-align: center;'>You have entered an incorrect password too many times<br> "
                                            + "For your security, access to your account will be stopped "
                                            + "until you have changed your password<br>"
                                            + "Click on forgotten password below to be allowed to login again!</div></html>");
                                    break;
                                default:
                                    break;
                            }
                        } else {
                            int checkUserStatus = returnArray[0];

                            if (checkUserStatus == 1) {

                                startSessionSequence(enteredEmail);
                                openAdminPanel();

                            } else if (checkUserStatus == 2) {

                                startSessionSequence(enteredEmail);
                                openGui();

                            }
                        }

                    } else {
                        loginControl.setMessage("Password is invalid");
                    }
                } else {
                    loginControl.setMessage("Email is invalid");

                }

                break;
            }

            case 2:
                //registration button

                registerUser();
                break;

            case 3: {
                //okButton in Registration

                String enteredName = regUser.getEnteredName();
                String enteredEmail = regUser.getEnteredEmail();
                String confirmedEmail = regUser.getConfirmEmailField();
                char[] enteredPassword = regUser.getEnteredPassword();
                char[] confirmedPassword = regUser.getConfirmPassField();

                //Validation:
                if (registrationValidation(enteredName, enteredEmail, confirmedEmail,
                        enteredPassword, confirmedPassword)) {
                    if (!userDBControl.verifyUserEmail(enteredEmail)) {

                        if (sendVerificationCode(enteredEmail, "Your Sign Up Code is: ")) { //re-enable when testing is done.{
                            //for testing only:
//                        Random rand = new Random();
//                        randomCode = rand.nextInt(999999);
//                        System.out.println("Random code is " + randomCode);
//                        regUser.setMessage("<html><div style='text-align: center;'>"//remove print here as well with the generator. 
//                                + "A verification code has been sent to your email: " + enteredEmail + "</div></html>");

                            //create a new window for verification
                            regUser.dispose();
                            verifyUser = new VerifyUser("Authorise Account");
                            verifyUser.setResizable(false);
                            verifyUser.setLocationRelativeTo(null);
                            verifyUser.setVisible(true);
                            counter = 5;//allows only 5 attempts
                            verifyUser.getConfirmButton().addMouseListener(new MouseAdapter() {
                                @Override
                                public void mouseClicked(MouseEvent evt) {

                                    if (counter > 0) {
                                        try {
                                            String verifyField = verifyUser.getEnteredCode();
                                            int enteredCode = Integer.parseInt(verifyField);

                                            if (randomCode == enteredCode) {
                                                int message = userDBControl.registerUser(enteredName, enteredEmail, enteredPassword);

                                                if (message == 1) {
                                                    verifyUser.setMessage("You have successfully registered!");
                                                    verifyUser.dispose();
                                                    loginUser();
                                                } else if (message == 2) {
                                                    verifyUser.setMessage("Email is already on our system.");
                                                }

                                            } else {
                                                //here is when the code is not correct

                                                counter--;
                                                //display that you have 1 less attempt remaning.
                                                if (counter > 1) {
                                                    verifyUser.setMessage("<html><div style='text-align: center;'>"
                                                            + "The code is incorrect!\nYou have " + counter + " attempts remaining!</div><html>");
                                                } else if (counter == 1) {
                                                    verifyUser.setMessage("<html><div style='text-align: center;'>"
                                                            + "The code is incorrect!\nYou have " + counter + " attempt remaining!</div><html>");
                                                } else {
                                                    //here we will say to user that he has reached the maximum number of attempts
                                                    //redirect to regUser again - so make a method for regUser so that the code doesn't duplicate
                                                    verifyUser.setMessage("<html><div style='text-align: center;'>You have tried verification too many times."
                                                            + "<br>For Security purposes you will be redirected to fill form again!</div></html>");
                                                    setRandomCode();
                                                    verifyUser.dispose();
                                                    forgottenPassword();

                                                }

                                            }
                                        } catch (Exception e) {

                                            verifyUser.setMessage("<html><div style='text-align: center;'>Please, "
                                                    + "enter the correct number in the verification field</div></html>");//message to let the user know they should enter digits and not strings.

                                        }
                                    }

                                }

                            });

                        }//end if email could not be sent.

                    } else {

                        regUser.setMessage("Email is already on our system");
                    }

                }//end registrationVerification

                break;
            }

            case 4:
                //cancelButton registration.

                regUser.dispose();
                loginUser();
                break;

            case 5:
                //creates a forgotten password window
                loginControl.dispose();
                forgottenPassword();
                break;

            case 6:
                //code for send button

                //first confirm and retrieve the email address.
                //then if it is on the system make sure you send
                String email = forgetPassPanel.getEnteredEmail();
                if (isValid(email, EMAIL_REGEX)) {

                    if (userDBControl.verifyUserEmail(email)) {
                        //means if it is on the system
                        this.emailForPassChange = email;
                        sendVerificationCode(email, "Your reset code is: ");//re-enable when testing is done.
                        //for testing only:
//                        Random rand = new Random();
//                        randomCode = rand.nextInt(999999);
//                        System.out.println("Random code is " + randomCode);
//                        forgetPassPanel.setMessage("A verification code has been sent to your email!");//comment out with above code

                    } else {

                        forgetPassPanel.setMessage("This email does not match our records");
                    }
                } else {

                    forgetPassPanel.setMessage("The email is not correct.");

                }
                break;

            case 7:
                //code for confirm button

                if (isButtonClicked) {

                    if (counter > 0) {
                        try {
                            String verifyField = forgetPassPanel.getEnteredCode();
                            int enteredCode = Integer.parseInt(verifyField);

                            if (randomCode == enteredCode) {

                                //open verification passwords.
                                changePassword();

                            } else {

                                //when the verification code is not correct
                                counter--;
                                //display that you have 1 less attempt remaning.
                                if (counter > 1) {
                                    forgetPassPanel.setMessage("<html><div style='text-align: center;'>"
                                            + "The code is incorrect!\nYou have " + counter + " attempts remaining!</div><html>");

                                } else if (counter == 1) {
                                    forgetPassPanel.setMessage("<html><div style='text-align: center;'>"
                                            + "The code is incorrect!\nYou have " + counter + " attempt remaining!</div><html>");
                                } else {
                                    //here we will say to user that he has reached the maximum number of attempts
                                    //redirect to regUser again - so make a method for regUser so that the code doesn't duplicate
                                    forgetPassPanel.setMessage("<html><div style='text-align: center;'>You have tried verification too many times."
                                            + "<br>For Security purposes you will be redirected to fill form again!</div></html>");
                                    setRandomCode();
                                    forgetPassPanel.dispose();
                                    forgottenPassword();
                                }

                            }

                        } catch (Exception e) {

                            forgetPassPanel.setMessage("<html><div style='text-align: center;'>"
                                    + "Please, enter the correct number in the verification field</div></html>");//message to let the user know they should enter digits and not strings.
                        }
                    }

                }//end if isButtonClicked
                else {

                    forgetPassPanel.setMessage("Press Send to receive a verification code");//when confirm button is clicked before send

                }
                break;
            case 8://remembered password button 
                loginUser();
                forgetPassPanel.dispose();
                break;

            //when ok button of change password window is changed
            case 9://confirm on password change

                //take the password values, make sure they match and send it to update password in db
                //do validation as well 
                char[] enteredPassword = changePass.getPasswordEntered();
                char[] confirmedPassword = changePass.getConfirmPassword();

                if (Arrays.equals(enteredPassword, confirmedPassword)) {

                    if (isValid(String.valueOf(enteredPassword), PASSWORD_REGEX)) {
                        // do a check - method that compares the two arrays
                        this.userDBControl.updatePassword(emailForPassChange, enteredPassword);

                        changePass.setMessage("<html><div style='text-align: center;'>You have successfully changed your password for " + emailForPassChange + "</div></html>");

                        changePass.dispose();
                        loginUser();

                        emailForPassChange = "";
                    } else {

                        changePass.setMessage("<html><div style='text-align: center;'>The password is not valid! Must have one of the following:<br>"
                                + "8 characters minimum, 1 upper case letter, 1 digit, at least 1 symbol(@$!%*?&)</div></html>");
                    }
                } else {

                    changePass.setMessage("The passwords do not match!");
                }

                break;

            case 10://cancel on password change
                //when cancel button is pressed
                changePass.dispose();
                emailForPassChange = "";
                loginUser();
                break;

            default:
                break;
        }

    }

    ////////////////////////////////////////////////////////////////////////////////////////
    /**
     * is called every time a new Login Window is to be created
     */
    public void loginUser() {//has to stay public as it is the first item to access from main.

        loginControl = new LoginUser("Cordis Login");
        loginControl.setResizable(false);
        loginControl.setLocationRelativeTo(null);
        loginControl.setVisible(true);

        loginControl.getLoginButtonC().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                buttonSwitcher = 1;
                buttonMouseClicked(evt, buttonSwitcher);
            }

        });
        loginControl.getRegButtonC().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                buttonSwitcher = 2;

                buttonMouseClicked(evt, buttonSwitcher);
            }

        });

        loginControl.getForgottenPassword().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                buttonSwitcher = 5;

                buttonMouseClicked(evt, buttonSwitcher);
            }

        });

    }

    ////////////////////////////////////////////////////////////////////////////////////////
    /**
     * is called every time a registration window is to be created.
     */
    private void registerUser() {

        regUser = new RegisterUser("Cordis Registration");
        regUser.setResizable(false);
        regUser.setLocationRelativeTo(null);
        regUser.setVisible(true);
        loginControl.dispose();
        if (regUser != null) {
            regUser.getOkButton().addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent evt) {
                    buttonSwitcher = 3;
                    buttonMouseClicked(evt, buttonSwitcher);
                }

            });

            regUser.getCancelButton().addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent evt) {
                    buttonSwitcher = 4;
                    buttonMouseClicked(evt, buttonSwitcher);
                }

            });

        }
    }

    ////////////////////////////////////////////////////////////////////////////////////////
    /**
     * is used to invoke Forgotten Password Window.
     */
    private void forgottenPassword() {
        forgetPassPanel = new ForgottenPassword("Forgotten Password");
        forgetPassPanel.setResizable(false);
        forgetPassPanel.setLocationRelativeTo(null);
        forgetPassPanel.setVisible(true);
        isButtonClicked = false;

        forgetPassPanel.getSendButton().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                buttonSwitcher = 6;
                counter = 5;
                isButtonClicked = true;//change back to false when exiting forgetPassPanel.
                buttonMouseClicked(evt, buttonSwitcher);

            }

        });
        forgetPassPanel.getConfirmButton().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                buttonSwitcher = 7;

                buttonMouseClicked(evt, buttonSwitcher);
            }

        });
        forgetPassPanel.getBackToLogin().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                buttonSwitcher = 8;

                buttonMouseClicked(evt, buttonSwitcher);
            }
        });

    }

    ////////////////////////////////////////////////////////////////////////////////////////
    /**
     * is used to create a Change Password window and relevant event handlers.
     */
    private void changePassword() {

        changePass = new ChangePassword("Cordis Change Password");
        changePass.setResizable(false);
        changePass.setLocationRelativeTo(null);
        changePass.setVisible(true);
        forgetPassPanel.dispose();
        isButtonClicked = false;

        //add on click here for both buttons:
        changePass.getOkButtonCh().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                buttonSwitcher = 9;
                buttonMouseClicked(evt, buttonSwitcher);
            }

        });

        changePass.getCancelButtonCh().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                buttonSwitcher = 10;
                buttonMouseClicked(evt, buttonSwitcher);
            }
        });
    }

    ////////////////////////////////////////////////////////////////////////////////////////
    /**
     * validates a given string against a specific regex pattern.
     *
     * @param stringToMatch {String to be matched by pattern}
     * @param regex {String containing REGEX pattern }
     * @return {returns true if the pattern matching is successful, or false if the pattern has not been satisfied}
     */
    public boolean isValid(String stringToMatch, String regex) {

        Pattern pattern = Pattern.compile(regex);
        if (stringToMatch == null) {
            return false;
        }
        return pattern.matcher(stringToMatch).matches();

    }

    /**
     * checks input in registration window and validates all fields.
     *
     * @param name uses regex pattern to determine if the name is correct.
     * @param email is used to check first if it is equal to confirmEmail and then to match a regex pattern.
     * @param confirmEmail is used to check first if it is equal to email and then to match a regex pattern.
     * @param password is compared with confirmPassword and then checked against regex pattern.
     * @param confirmPassword is compared with password and then checked against regex pattern.
     * @return
     */
    public boolean registrationValidation(String name, String email, String confirmEmail,
            char[] password, char[] confirmPassword) {

        if (email.equals(confirmEmail)) {

            if (Arrays.equals(password, confirmPassword)) {

                if (isValid(name, NAME_REGEX)) {

                    if (isValid(email, EMAIL_REGEX)) {

                        if (isValid(String.valueOf(password), PASSWORD_REGEX)) {

                            return true;//only if all three are valid do we return true.

                        } else {

                            regUser.setMessage("<html><div style='text-align: center;'>The password is not valid! Must have one of the following:<br>"
                                    + "8 characters minimum, 1 upper case letter, 1 digit, at least 1 symbol(@$!%*?&)</div></html>");

                        }

                    } else {
                        regUser.setMessage("The email is not valid!");
                    }

                } else {

                    regUser.setMessage("The name is not valid!");
                }

            } else {
                regUser.setMessage("Passwords do not match");
            }

        } else {

            regUser.setMessage("Email entries do not match!");
        }

        return false;
    }

    ////////////////////////////////////////////////////////////////////////////////////////
    /**
     * is used to send a verification code(generated randomly) to a specific user's email address
     *
     * @param email receives the email of a user from database.
     * @param text used to change the text that will be displayed in the sent
     * email.
     * Code referenced from (TechSupportNep, 2019).
     * Connection error fixed with code referenced by (Rafael, 2018).
     */
    private boolean sendVerificationCode(String email, String text) {

        LoginUser logIn = new LoginUser("Login");//used for display purposes.
        boolean flag = false;
        try {
            setRandomCode();
            String host = "smtp.gmail.com";
            String user = "cordis.group.project@gmail.com";//add your email here. 
            String pass = "";//removed password for security reasons.
            String to = email;
            String subject = "Verification Code";
            String message = text + randomCode;
            boolean sessionDebug = false;
            Properties properties = System.getProperties();
//            properties.put("mail.smtp.starttls.enable", "true");
            properties.put("mail.smtp.host", "host");
            properties.put("mail.smtp.user", user);
            properties.put("mail.smtp.password", pass);
            properties.put("mail.smtp.port", "587");
            properties.put("mail.smtp.auth", "true");
            properties.put("mail.smtp.starttls.required", "true");
            properties.put("mail.smtp.ssl.trust", "smtp.gmail.com");
            
            java.security.Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
            Session mailSession = Session.getDefaultInstance(properties);
//            mailSession.setDebug(sessionDebug);
            Message msg = new MimeMessage(mailSession);
            msg.setFrom(new InternetAddress(user));
            InternetAddress[] address = {new InternetAddress(to)};
            msg.addRecipients(Message.RecipientType.TO, address);
            msg.setSubject(subject);
            msg.setText(message);
            try (Transport transport = mailSession.getTransport("smtp")) {
                transport.connect(host, user, pass);
                transport.sendMessage(msg, msg.getAllRecipients());
            }

            logIn.setMessage("<html><div style='text-align: center;'>Verification code has been sent to your email " + email + "</div></html>");
            flag = true;
            //make sure this is printed from the LoginUser
        } catch (MessagingException e) {

            System.out.println("the error is " + e);
            logIn.setMessage("<html><div style='text-align: center;'>Verification code could not be sent. <br>Check values of entered email</div></html>");
        }

        logIn.dispose();
        return flag;

    }

    public void setRandomCode() {

        Random rand = new Random();
        randomCode = rand.nextInt(999999);

    }

    ////////////////////////////////////////////////////////////////////////////////////////
    /**
     * starts the admin/user gui page, depending on what is the status of a given user.
     *
     * @param enteredEmail is the identifier.
     */
    private void startSessionSequence(String enteredEmail) {
        userControl = userDBControl.retrieveUserFromDB(enteredEmail);
        currentSession.setSessionID(userDBControl.startNewSession(enteredEmail));
        loginControl.dispose();
    }

    ////////////////////////////////////////////////////////////////////////////////////////
    /**
     * opens main User window.
     */
    public void openGui() {

        guiControl = new Gui("Cordis Main");
        guiControl.setResizable(false);
        guiControl.setLocationRelativeTo(null);
        initialiseHomePage(guiControl);
        guiControl.setVisible(true);
        guiControl.getHomePanel().setVisible(true);
        checkStatus = true;

        setPanelState(guiControl.getHomePanel(), guiControl.getDashboard1Panel(),
                guiControl.getDashboard2Panel(), guiControl.getDashboard3Panel());

        if (userControl.getName() != null) {

            guiControl.setUserSign(userControl.getName());

        }

        /**
         * Gui Listeners:
         */
        guiControl.getLogOutButton().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {

                userDBControl.endSession(currentSession.getSessionID());
                guiControl.dispose();
                loginUser();

            }

        });

        guiControl.getDash1Button().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {

                openDashboard1();
                userDBControl.setCurrentActivity(currentSession.getSessionID(), activityOptions.get(0));
            }

        });

        guiControl.getDash2Button().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {

                openDashboard2();
                userDBControl.setCurrentActivity(currentSession.getSessionID(), activityOptions.get(1));
            }

        });

        guiControl.getDash3Button().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {

                openDashboard3();
                userDBControl.setCurrentActivity(currentSession.getSessionID(), activityOptions.get(2));
            }

        });

        guiControl.getImageLabel().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {

                if (checkStatus) {
                    guiControl.getHomePanel().setVisible(true);
                    guiControl.getDash3Button().setEnabled(true);
                    guiControl.getDash2Button().setEnabled(true);
                    guiControl.getDash1Button().setEnabled(true);
                } else {
                    //enter code for admin panel. 
                }

                userDBControl.setCurrentActivity(currentSession.getSessionID(), activityOptions.get(15));
            }

        });

    }//end openGui();

    ////////////////////////////////////////////////////////////////////////////////////////
    private static final int NUMBER_OF_PROJECTS = 1;
    private static final int TOTAL_COST = 2;
    private static final int NUMBER_OF_PARTICIPANTS = 3;

    /**
     * Retrieves required information from CordisDB.
     * Sends retrieved information to Gui/Admin.
     */
    private void initialiseHomePage(Gui frame) {

        frame.setNumberOfProjects(cordisDBControl.retrieveDataHomePage(NUMBER_OF_PROJECTS));
        frame.setNumberOfParticipants(cordisDBControl.retrieveDataHomePage(NUMBER_OF_PARTICIPANTS));
        frame.setTotalCostOfAllProjects(cordisDBControl.retrieveDataHomePage(TOTAL_COST));

        frame.setParticipantPerCountry(cordisDBControl.retrieveDataSetHomePage(1));
        frame.setYearEndProjects(cordisDBControl.retrieveDataSetHomePage(2));

        frame.setHomePageParticipantGraph();
        frame.setHomePageYearEndGraph();

    }

    ////////////////////////////////////////////////////////////////////////////////////////
    /**
     * enables dashboard 1 panel, sets dashboard 1 button to disabled.
     * if more elements are added to dashboard 1 - clicks should be handled in this method.
     * use cordisDBControl to invoke calls from CordisDB
     * NOTE: when checkStatus is true is for GUI and when it is false is for ADMIN.
     */
    public void openDashboard1() {

        if (checkStatus) {//when gui window enabled

            setPanelState(guiControl.getDashboard1Panel(), guiControl.getDashboard2Panel(),
                    guiControl.getDashboard3Panel(), guiControl.getHomePanel());

            setButtonState(guiControl.getDash1Button(), guiControl.getDash2Button(), guiControl.getDash3Button());

            setDashboard1Widgets(guiControl);

        } else {//when admin window enabled

            setPanelState(adminPanel.getDashboard1Panel(), adminPanel.getDashboard2Panel(),
                    adminPanel.getDashboard3Panel(), adminPanel.getHomePanel(), adminPanel.getAdminPanel());

            setButtonState(adminPanel.getDash1Button(), adminPanel.getDash2Button(),
                    adminPanel.getDash3Button(), adminPanel.getAdminButton());

            setDashboard1Widgets(adminPanel);

        }

    }//end openDashboard1();

    /**
     * sets up the widgets and listeners for dashboard 1
     *
     * @param frame - receives either Gui or AdminPanel objects.
     */
    public void setDashboard1Widgets(Gui frame) {

        //enter code here if more methods and handlers are required for dashboard 1:
        int maximumBars = 15;

        frame.createBarChart(maximumBars);

        frame.getCountryButton().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                //updates database when Country button is pressed
                userDBControl.setCurrentActivity(currentSession.getSessionID(), activityOptions.get(18));
                //System.out.println("clicked on Country");
            }
        });

        frame.getYearsButton().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                //updates database when Year button is pressed
                userDBControl.setCurrentActivity(currentSession.getSessionID(), activityOptions.get(19));
                //System.out.println("clicked on Years");
            }
        });

        /*                  ******* Logging BarChart displayed by Slider - to reduce spamming Activity_Log table. Michal *******
            frame.getSlider().addMouseListener(new MouseAdapter()
            {
                @Override
                public void mouseReleased(MouseEvent evt)
                {
                    System.out.println("Mouse released at: " + frame.getSlider().getValue());
                    userDBControl.setCurrentActivity(currentSession.getSessionID(), activityOptions.get(20)); 
                }
            });
         */
//            frame.setMap(cordisDBControl.retrieveDataDash1(1));//this will return a map
    }

    /**
     *
     * enables dashboard 2 panel, sets dashboard 2 button to disabled.
     * NOTE: when checkStatus is true is for GUI and when it is false is for ADMIN.
     *
     * @author W1669138
     */
    public void openDashboard2() {

        if (checkStatus) {//when gui window enabled

            setPanelState(guiControl.getDashboard2Panel(), guiControl.getDashboard1Panel(),
                    guiControl.getDashboard3Panel(), guiControl.getHomePanel());

            setButtonState(guiControl.getDash2Button(), guiControl.getDash1Button(), guiControl.getDash3Button());

            setDashboard2Widgets(guiControl);

        } else {//when admin window enabled

            setPanelState(adminPanel.getDashboard2Panel(), adminPanel.getDashboard1Panel(),
                    adminPanel.getDashboard3Panel(), adminPanel.getHomePanel(), adminPanel.getAdminPanel());

            setButtonState(adminPanel.getDash2Button(), adminPanel.getDash1Button(),
                    adminPanel.getDash3Button(), adminPanel.getAdminButton());

            setDashboard2Widgets(adminPanel);

        }

    }//end openDashboard2();

    /**
     * sets up the widgets and listeners for dashboard 2
     *
     * @param frame - receives either Gui or AdminPanel objects.
     */
    public void setDashboard2Widgets(Gui frame) {

        frame.setRS(cordisDBControl.SelectBarQuery());
        frame.setResultSetVar(cordisDBControl.SelectLineQuery());
        frame.setResultSetVar1(cordisDBControl.SelectLineQuery2());

        //creates graphs:
        frame.createLineTrail();

        //dashboard 2 button click listeners
        frame.getAverageButton().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {

                frame.setSearchPanel(false);
                //shows average bar chart and hides the rest
                setPanelState(frame.getD2Chart1(), frame.getD2Chart2(), frame.getD2Chart3(), frame.getD2SearchPanel());
                //disables average button and enables the rest
                setButtonState(frame.getAverageButton(), frame.getMostExpensiveButton(), frame.getLeastExpensiveButton(), frame.getSearchMenuButton());

                //updates database when average button is pressed
                userDBControl.setCurrentActivity(currentSession.getSessionID(), activityOptions.get(5));

            }

        });

        frame.getMostExpensiveButton().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {

                frame.setSearchPanel(false);
                //shows most expensive line chart and hides the rest
                setPanelState(frame.getD2Chart2(), frame.getD2Chart3(), frame.getD2Chart1(), frame.getD2SearchPanel());
                //disables most expensive button and enables the rest
                setButtonState(frame.getMostExpensiveButton(), frame.getLeastExpensiveButton(), frame.getAverageButton(), frame.getSearchMenuButton());

                //updates database when most expensive button is pressed
                userDBControl.setCurrentActivity(currentSession.getSessionID(), activityOptions.get(16));
            }

        });

        frame.getLeastExpensiveButton().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {

                frame.setSearchPanel(false);
                //shows least expensive line chart and hides the rest
                setPanelState(frame.getD2Chart3(), frame.getD2Chart1(), frame.getD2Chart2(), frame.getD2SearchPanel());
                //disables least expensive button and enables the rest
                setButtonState(frame.getLeastExpensiveButton(), frame.getAverageButton(), frame.getMostExpensiveButton(), frame.getSearchMenuButton());

                //updates database when least expensive button is pressed
                userDBControl.setCurrentActivity(currentSession.getSessionID(), activityOptions.get(17));

            }

        });

        frame.getSearchMenuButton().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {

                frame.setSearchPanel(true);
                //shows least expensive line chart and hides the rest
                setPanelState(frame.getD2SearchPanel(), frame.getD2Chart3(), frame.getD2Chart1(), frame.getD2Chart2());
                //disables least expensive button and enables the rest
                setButtonState(frame.getSearchMenuButton(), frame.getLeastExpensiveButton(), frame.getAverageButton(), frame.getMostExpensiveButton());

                //updates database when least expensive button is pressed
                userDBControl.setCurrentActivity(currentSession.getSessionID(), activityOptions.get(21));

            }

        });

        frame.getSearchButton().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {

                String search = frame.getSearchText();
                if (!search.equals("")) {

                    frame.setRsSearchMax(cordisDBControl.SearchMaxQuery(search));
                    frame.setRsSearchMin(cordisDBControl.SearchMinQuery(search));

                    frame.createSearchFunction();

                }
                userDBControl.setCurrentActivity(currentSession.getSessionID(), activityOptions.get(22));

            }

        });

    }

    /**
     * enables dashboard 3 panel, sets dashboard 3 button to disabled.
     * if more elements are added to dashboard 3 - clicks should be handled in this method.
     * use cordisDBControl to invoke calls from CordisDB
     * NOTE: when checkStatus is true is for GUI and when it is false is for ADMIN.
     */
    public void openDashboard3() {

        if (checkStatus) {//when gui window enabled

            setPanelState(guiControl.getDashboard3Panel(), guiControl.getDashboard2Panel(),
                    guiControl.getDashboard1Panel(), guiControl.getHomePanel());

            setButtonState(guiControl.getDash3Button(), guiControl.getDash2Button(), guiControl.getDash1Button());

            setDashboard3Widgets(guiControl);

        } else {//when admin window enabled

            setPanelState(adminPanel.getDashboard3Panel(), adminPanel.getDashboard1Panel(),
                    adminPanel.getDashboard2Panel(), adminPanel.getHomePanel(), adminPanel.getAdminPanel());

            setButtonState(adminPanel.getDash3Button(), adminPanel.getDash1Button(),
                    adminPanel.getDash2Button(), adminPanel.getAdminButton());

            setDashboard3Widgets(adminPanel);

        }

    }//end openDashboard3()

    /**
     * sets up the widgets and listeners for dashboard 3
     *
     * @param frame - receives either Gui or AdminPanel objects.
     */
    public void setDashboard3Widgets(Gui frame) {

        ArrayList<Contributor> maxList = cordisDBControl.retrieveContributionData(1);
        ArrayList<Contributor> minList = cordisDBControl.retrieveContributionData(2);
        frame.setContributorsPiePanel(maxList, "Highest Contributors", frame.getD3MaxPiePanel());
        frame.setContributorsPiePanel(minList, "Lowest Contributors", frame.getD3MinPiePanel());

        frame.setContributorsBarPanel(maxList, "Highest Contribution", frame.getD3MaxBarPanel());
        frame.setContributorsBarPanel(minList, "Lowest Contribution", frame.getD3MinBarPanel());

        frame.getD3Tabs().addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {

                if (frame.getD3Tabs().getSelectedIndex() == 0) {//MAX

                    userDBControl.setCurrentActivity(currentSession.getSessionID(), activityOptions.get(6));

                } else {//MIN
                    userDBControl.setCurrentActivity(currentSession.getSessionID(), activityOptions.get(23));
                }

            }

        });

    }

    ////////////////////////////////////////////////////////////////////////////////////////
    /**
     * opens admin window
     */
    public void openAdminPanel() {

        adminPanel = new AdminPanel("Cordis Admin");
        adminPanel.setResizable(false);
        adminPanel.setLocationRelativeTo(null);
        initialiseHomePage(adminPanel);
        adminPanel.setVisible(true);
        adminPanel.getHomePanel();
        adminButtonsSetup(false);
        checkStatus = false;

        setPanelState(adminPanel.getHomePanel(), adminPanel.getDashboard1Panel(),
                adminPanel.getDashboard2Panel(), adminPanel.getDashboard3Panel(),
                adminPanel.getAdminPanel());

        if (userControl.getName() != null) {

            adminPanel.setUserSign(userControl.getName());

        }

        ArrayList<User> allUsers = userDBControl.retrieveAllUsers();
        ArrayList<String> tableName = userDBControl.getTableNames();
        adminPanel.setUpTableUsers(tableName);
        adminPanel.setupRowsUsers(allUsers);

        userDBControl.getSessionDetals(0);
        ArrayList<String> tableName2 = userDBControl.getTableNames();
        adminPanel.setUpTableSession(tableName2);

        userDBControl.getUserActivity(0);
        ArrayList<String> tableName3 = userDBControl.getTableNames();
        adminPanel.setUpTableDetails(tableName3);

        /**
         * Admin Panel Listeners:
         */
        adminPanel.getImageLabel().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {

                adminButtonsSetup(false);
                adminPanel.getHomePanel().setVisible(true);
                adminPanel.getDash3Button().setEnabled(true);
                adminPanel.getDash2Button().setEnabled(true);
                adminPanel.getDash1Button().setEnabled(true);
                adminPanel.getAdminButton().setEnabled(true);

                userDBControl.setCurrentActivity(currentSession.getSessionID(), activityOptions.get(15));
            }

        });

        adminPanel.getLogOutButton().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {

                userDBControl.endSession(currentSession.getSessionID());
                adminPanel.dispose();
                loginUser();

            }

        });

        adminPanel.getDash1Button().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                //guiControl.dispose();                
                adminButtonsSetup(false);
                openDashboard1();
                userDBControl.setCurrentActivity(currentSession.getSessionID(), activityOptions.get(0));
            }

        });
        adminPanel.getDash2Button().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {

                adminButtonsSetup(false);
                openDashboard2();
                userDBControl.setCurrentActivity(currentSession.getSessionID(), activityOptions.get(1));

            }

        });
        adminPanel.getDash3Button().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {

                adminButtonsSetup(false);
                openDashboard3();
                userDBControl.setCurrentActivity(currentSession.getSessionID(), activityOptions.get(2));
            }

        });
        adminPanel.getAdminButton().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {

                if (adminPanel.getAdminButton().isEnabled()) {
                    adminPanel.setAdminLabel("USER LIST");
                    adminPanel.setEditable(false);
                    adminPanel.getCancelButton1().setVisible(false);
                    adminPanel.getOkButton().setVisible(false);
                    adminPanel.getCancelButton().setVisible(false);
                    adminPanel.getViewUserButton().setEnabled(true);
                    adminPanel.getUserListTable().editCellAt(-1, -1);
                    adminPanel.getUserListTable().clearSelection();
                    adminPanel.getTable1Panel().setVisible(true);
                    adminPanel.getTable2Panel().setVisible(false);
                    adminPanel.getEditUserButton().setEnabled(true);
                    adminPanel.getDeleteUserButton().setEnabled(true);

                    displayAdminPanel();
                    userDBControl.setCurrentActivity(currentSession.getSessionID(), activityOptions.get(3));//allows activity to be recorded to DB.
                }
            }
        });//end admin button listener     

        adminPanel.getEditUserButton().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                if (adminPanel.getEditUserButton().isEnabled()) {

                    adminPanel.getViewUserButton().setEnabled(false);
                    adminPanel.getOkButton().setVisible(true);
                    adminPanel.getCancelButton().setVisible(true);
                    adminPanel.setEditable(true);
                    adminPanel.setAdminLabel("EDIT USER");
                    userDBControl.setCurrentActivity(currentSession.getSessionID(), activityOptions.get(8));

                }
            }

        });

        adminPanel.getOkButton().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent evt) {

                if (!adminPanel.getUserListTable().getSelectionModel().isSelectionEmpty()) {

                    String name = (String) adminPanel.getUserListTable().getValueAt(adminPanel.getUserListTable().getSelectedRow(), 0);//string name
                    String id = adminPanel.getUserListTable().getValueAt(adminPanel.getUserListTable().getSelectedRow(), 1).toString();//number
                    String email = (String) adminPanel.getUserListTable().getValueAt(adminPanel.getUserListTable().getSelectedRow(), 2);//string email                                    
                    String countPass = adminPanel.getUserListTable().getValueAt(adminPanel.getUserListTable().getSelectedRow(), 4).toString();//number - count pass
                    boolean isAdmin = (boolean) adminPanel.getUserListTable().getValueAt(adminPanel.getUserListTable().getSelectedRow(), 5);//value of checkbox

                    String status;
                    if (isAdmin) {
                        status = "admin";
                    } else {
                        status = "user";
                    }
                    //code that prevents user from editing empty fields.
                    if (!name.equals("") && !id.equals("") && !email.equals("") && !countPass.equals("")) {
                        adminPanel.getMessageWindow().cancelWindow();
                        adminPanel.setMessage(false, "<html><div style='text-align: center;'>Are sure you want to edit: <br>"
                                + name + "?<br>"
                                + "</div></html>");

                        adminPanel.getMessageWindow().getOkButton2().addMouseListener(new MouseAdapter() {

                            @Override
                            public void mouseReleased(MouseEvent evt) {

                                userDBControl.setCurrentActivity(currentSession.getSessionID(), activityOptions.get(11));

                                //
                                if (userDBControl.updateUserData(name, Integer.parseInt(id), email, Integer.parseInt(countPass), status)) {

                                    adminPanel.getMessageWindow().cancelWindow();
                                    adminPanel.setMessage(true, "You have successfully edited the selected user");

                                } else {
                                    adminPanel.getMessageWindow().cancelWindow();
                                    adminPanel.setMessage(true, "Something went wrong, we could not update the user");
                                    adminPanel.getUserListTable().editCellAt(-1, -1);
                                    adminPanel.getUserListTable().clearSelection();
                                }

                                ArrayList<User> allUsers = userDBControl.retrieveAllUsers();
                                adminPanel.getUserModel().setRowCount(0);
                                adminPanel.setupRowsUsers(allUsers);
                            }

                        });

                    } else {

                        adminPanel.setMessage(true, "<html><div style='text-align: center;'>You cannot edit an empty field </div></html>");

                    }

                } else {//statement that runs when fields are empty.
                    adminPanel.setMessage(true, "You must select an element to edit before continuing.");

                }

            }

        });

        adminPanel.getCancelButton().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {

                adminPanel.setAdminLabel("USER LIST");
                adminPanel.setEditable(false);
                adminPanel.getOkButton().setVisible(false);
                adminPanel.getCancelButton().setVisible(false);
                adminPanel.getViewUserButton().setEnabled(true);
                adminPanel.getUserListTable().editCellAt(-1, -1);
                adminPanel.getUserListTable().clearSelection();
                ArrayList<User> allUsers = userDBControl.retrieveAllUsers();
                adminPanel.getUserModel().setRowCount(0);
                adminPanel.setupRowsUsers(allUsers);
                userDBControl.setCurrentActivity(currentSession.getSessionID(), activityOptions.get(10));

            }

        });

        adminPanel.getViewUserButton().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                if (!adminPanel.getUserListTable().getSelectionModel().isSelectionEmpty()) {
                    if (adminPanel.getViewUserButton().isEnabled()) {

                        adminPanel.getTable1Panel().setVisible(false);
                        adminPanel.getTable2Panel().setVisible(true);
                        adminPanel.getEditUserButton().setEnabled(false);
                        adminPanel.getDeleteUserButton().setEnabled(false);
                        adminPanel.getCancelButton1().setVisible(true);
                        adminPanel.setAdminLabel("VIEW USER");//change to exact selected user details.

                        Integer check = (Integer) adminPanel.getUserListTable().getValueAt(adminPanel.getUserListTable().getSelectedRow(), 1);
                        String name = (String) adminPanel.getUserListTable().getValueAt(adminPanel.getUserListTable().getSelectedRow(), 0);
                        adminPanel.setAdminLabel("USER DETAILS FOR " + name.toUpperCase());

                        adminPanel.getSessionModel().setRowCount(0);
                        ArrayList<SessionDetails> sessionDetails = userDBControl.getSessionDetals(check);
                        adminPanel.setUpRowsSession(sessionDetails);

                        userDBControl.setCurrentActivity(currentSession.getSessionID(), activityOptions.get(7));

                    }//end if enabled
                } else {

                    adminPanel.setMessage(true, "You must select an element to view before continuing.");
                }
            }

        });//end view listener

        adminPanel.getSessionTable().getSelectionModel().addListSelectionListener(new ListSelectionListener() {

            @Override
            public void valueChanged(ListSelectionEvent e) {
                Integer check;
                if (adminPanel.getSessionTable().getRowCount() != 0) {
                    check = (Integer) adminPanel.getSessionTable().getValueAt(adminPanel.getSessionTable().getSelectedRow(), 0);

                    ArrayList<DataUsage> dataUsage = new ArrayList<>();
                    dataUsage = userDBControl.getUserActivity(check);

                    adminPanel.getDetailsModel().setRowCount(0);

                    adminPanel.setUpRowsDetails(dataUsage);

                }

            }
        });

        adminPanel.getCancelButton1().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {

                adminPanel.getSessionModel().setRowCount(0);
                adminPanel.getDetailsModel().setRowCount(0);
                adminPanel.setAdminLabel("USER LIST");
                adminPanel.getEditUserButton().setEnabled(true);
                adminPanel.getDeleteUserButton().setEnabled(true);
                adminPanel.getViewUserButton().setEnabled(true);
                adminPanel.getTable1Panel().setVisible(true);
                adminPanel.getTable2Panel().setVisible(false);
                adminPanel.setEditable(false);
                adminPanel.getOkButton().setVisible(false);
                adminPanel.getCancelButton1().setVisible(false);
                adminPanel.getUserListTable().editCellAt(-1, -1);
                adminPanel.getUserListTable().clearSelection();
                userDBControl.setCurrentActivity(currentSession.getSessionID(), activityOptions.get(14));

            }

        });

        adminPanel.getDeleteUserButton().addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent evt) {

                if (!adminPanel.getUserListTable().getSelectionModel().isSelectionEmpty()) {

                    userDBControl.setCurrentActivity(currentSession.getSessionID(), activityOptions.get(9));
                    adminPanel.setMessage(false, "<html><div style='text-align: center;'>Are sure you want to delete: <br>"
                            + adminPanel.getUserListTable().getValueAt(adminPanel.getUserListTable().getSelectedRow(), 0) + "?<br>"
                            + "</div></html>");

                    adminPanel.getMessageWindow().getOkButton2().addMouseListener(new MouseAdapter() {

                        @Override
                        public void mouseClicked(MouseEvent evt) {

                            userDBControl.setCurrentActivity(currentSession.getSessionID(), activityOptions.get(13));

                            Integer id = (Integer) adminPanel.getUserListTable().getValueAt(adminPanel.getUserListTable().getSelectedRow(), 1);

                            boolean deleteStatus = userDBControl.deleteUser(id);

                            adminPanel.getMessageWindow().cancelWindow();

                            if (deleteStatus) {

                                ArrayList<User> allUsers = userDBControl.retrieveAllUsers();
                                adminPanel.getUserModel().setRowCount(0);
                                adminPanel.setupRowsUsers(allUsers);

                                adminPanel.setMessage(true, "You have successfully deleted the user");

                            } else {

                                adminPanel.setMessage(true, "Something went wrong, user could not be deleted");

                            }
                        }

                    });

                } else {
                    adminPanel.setMessage(true, "You must select an element to delete before continuing.");

                }

            }

        }
        );

    }//end openAdminPanel();

    ////////////////////////////////////////////////////////////////////////////////////////
    /**
     * initialises the admin panel. This method acts as a selector between tabs, so that only
     * one is selected at a time, in this case admin.
     */
    public void displayAdminPanel() {

        setPanelState(adminPanel.getAdminPanel(), adminPanel.getDashboard2Panel(), adminPanel.getDashboard1Panel(),
                adminPanel.getDashboard3Panel(), adminPanel.getHomePanel());

        setButtonState(adminPanel.getAdminButton(), adminPanel.getDash2Button(),
                adminPanel.getDash1Button(), adminPanel.getDash3Button());

        adminButtonsSetup(true);

    }

    /**
     * shows/hides additional admin buttons that appear when admin tab is pressed.
     *
     * @param isSelected shows the view, edit and delete buttons when admin tab is pressed and hides them otherwise.
     */
    public void adminButtonsSetup(boolean isSelected) {

        adminPanel.getViewUserButton().setVisible(isSelected);
        adminPanel.getEditUserButton().setVisible(isSelected);
        adminPanel.getDeleteUserButton().setVisible(isSelected);
    }

    ////////////////////////////////////////////////////////////////////////////////////////
    /**
     * sets the button state to enabled or disabled, depending on when it has been selected.
     * The three parameter version of this method is for regular user tabs as they only have 3 buttons.
     *
     * @param toStop the button that will be disabled when being selected.
     * @param toEnable1 button to be enabled.
     * @param toEnable2 button to be enabled.
     *
     *
     */
    public void setButtonState(JLabel toStop, JLabel toEnable1, JLabel toEnable2) {

        toStop.setEnabled(false);
        toEnable1.setEnabled(true);
        toEnable2.setEnabled(true);

    }

    ////////////////////////////////////////////////////////////////////////////////////////   
    /**
     * sets the button state to enabled or disabled, depending on when it has been selected.
     * The four parameter version of this method is for admin tabs as they have 4 buttons.
     *
     * @param toStop the button that will be disabled when being selected.
     * @param toEnable1 button to be enabled.
     * @param toEnable2 button to be enabled.
     * @param toEnable3 button to be enabled.
     */
    public void setButtonState(JLabel toStop, JLabel toEnable1,
            JLabel toEnable2, JLabel toEnable3) {

        toStop.setEnabled(false);
        toEnable1.setEnabled(true);
        toEnable2.setEnabled(true);
        toEnable3.setEnabled(true);
    }

    ////////////////////////////////////////////////////////////////////////////////////////
    /**
     * shows/hides panels according to which one has been pressed.
     * 4 parameter one is used for user.
     * The extra one is for the home page.
     *
     * @param toEnable
     * @param toHide1
     * @param toHide2
     * @param toHide3
     */
    public void setPanelState(JPanel toEnable, JPanel toHide1, JPanel toHide2,
            JPanel toHide3) {

        toEnable.setVisible(true);
        toHide1.setVisible(false);
        toHide2.setVisible(false);
        toHide3.setVisible(false);

    }

    ////////////////////////////////////////////////////////////////////////////////////////
    /**
     * shows/hides panels according to which one has been pressed.
     * 5 parameter one is used for admin.
     * The extra one is for the home page.
     *
     * @param toEnable
     * @param toHide1
     * @param toHide2
     * @param toHide3
     * @param toHide4
     */
    public void setPanelState(JPanel toEnable, JPanel toHide1, JPanel toHide2,
            JPanel toHide3, JPanel toHide4) {

        toEnable.setVisible(true);
        toHide1.setVisible(false);
        toHide2.setVisible(false);
        toHide3.setVisible(false);
        toHide4.setVisible(false);

    }

}

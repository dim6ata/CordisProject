package cordismain;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.JFrame;
import javax.swing.text.DefaultHighlighter;

/**
 * Class that is responsible for the displaying of visual content for the login functionality.
 *
 * @author dim6ata
 */
public class LoginUser extends JFrame {

    // Variables declaration:                           
    private ImageIcon logo;
    private JCheckBox checkBox;
    private JPanel containerPanel;
    private JTextField emailField;
    private JButton forgottenPassword;
    private JLabel imageLabel;
    private JLabel jLabel1;
    private JPanel lightBluePanel;
    private JButton loginButton;
    private JLabel loginButtonC;
    private JPasswordField passwordField;
    private JLabel regButtonC;
    private JButton registerButton;
    private MessageWindow messageWindow;
    // End of variables declaration  

    //Constructor:
    public LoginUser(String name) {

        super(name);

        initComponents();

    }

    //Getters and Setters:
    
    /**
     *
     * @return {JButton - used to communicate button object with server/controller class}
     */
    public JButton getForgottenPassword() {
        return forgottenPassword;
    }

    /**
     *
     * @return {JLabel - used to communicate button object with server/controller class}
     */
    public JLabel getLoginButtonC() {
        return loginButtonC;
    }

    /**
     *
     * @return {JLabel - used to communicate button object with server/controller class}
     */
    public JLabel getRegButtonC() {
        return regButtonC;
    }

    /**
     *
     * @return {String - retrieves text entered in email text field.
     * Used to communicate button object with server/controller class}
     */
    public String getEnteredEmail() {

        return this.emailField.getText();
    }

    /**
     * 
     * @return {char[] - retrieves the data entered in passwordField. 
     * char[] is the preferred object as it is more secure than string}
     */
    public char[] getEnteredPassword() {

        return this.passwordField.getPassword();
    }

    /**
     * Sets message in message window.
     *
     * @param text {String - value to be displayed in message window}
     */
    public void setMessage(String text) {

        messageWindow = new MessageWindow(true);//only confirmatory messages are required here.        
        messageWindow.setAlwaysOnTop(true);
        messageWindow.setResizable(false);
        messageWindow.setLocationRelativeTo(null);
        messageWindow.setText(text);
        messageWindow.setVisible(true);

        /**
         * transforms the appearance of text according to its length
         * by shifting its distance to the logo:
         */
        if (text.length() > 150 && text.length() <= 200) {

            messageWindow.getLogo().setIconTextGap(35);

        } else if (text.length() > 200) {

            messageWindow.getLogo().setIconTextGap(3);

        } else {

            messageWindow.getLogo().setIconTextGap(45);

        }

    }

    /**
     * Method which initialises and is responsible for accurately displaying
     * gui contents on screen.
     */
    public void initComponents() {

        containerPanel = new JPanel();
        jLabel1 = new JLabel();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBackground(new Color(0, 99, 178));
        setName("Cordis Login");

        containerPanel.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        containerPanel.setBackground(new java.awt.Color(0, 99, 178));
        containerPanel.setAlignmentX(0.0F);
        containerPanel.setAlignmentY(0.0F);
        containerPanel.setMaximumSize(new java.awt.Dimension(600, 600));
        containerPanel.setPreferredSize(null);

        contentsPanel();

        jLabel1.setFont(new Font("Verdana", 1, 52));
        jLabel1.setForeground(new Color(0, 0, 0));
        jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel1.setText("CORDIS");
        jLabel1.setToolTipText("");

        GroupLayout containerPanelLayout = new GroupLayout(containerPanel);
        containerPanel.setLayout(containerPanelLayout);
        containerPanelLayout.setHorizontalGroup(
                containerPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(GroupLayout.Alignment.TRAILING, containerPanelLayout.createSequentialGroup()
                                .addGap(61, 61, 61)
                                .addComponent(lightBluePanel, GroupLayout.PREFERRED_SIZE, 360, GroupLayout.PREFERRED_SIZE)
                                .addGap(61, 61, 61))
        );
        containerPanelLayout.setVerticalGroup(
                containerPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, containerPanelLayout.createSequentialGroup()
                                .addContainerGap(40, Short.MAX_VALUE)
                                .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lightBluePanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(39, 39, 39))
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);

        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(containerPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(containerPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        containerPanel.getAccessibleContext().setAccessibleName("");

        pack();
    }//end initComponents()                       

    /**
     * Event handler for selection of show password check box
     *
     * @param evt {ActionEvent object}
     */
    private void checkBoxActionPerformed(ActionEvent evt) {

        if (checkBox.isSelected()) {
            passwordField.setEchoChar((char) 0);
        } else {

            passwordField.setEchoChar('\u25cf');
        }
    }

    /**
     * Event handler method that transforms the button appearance when mouse hovers over the button
     *
     * @param evt {ActionEvent object}
     */
    private void loginButtonCMouseEntered(MouseEvent evt) {

        loginButtonC.setIcon(new ImageIcon(getClass().getResource("log-button-blue.png")));

    }

    /**
     * Event handler method that transforms the button appearance when mouse exits the button
     *
     * @param evt {ActionEvent object}
     */
    private void loginButtonCMouseExited(MouseEvent evt) {
        // TODO add your handling code here:
        loginButtonC.setIcon(new ImageIcon(getClass().getResource("log-btn-w.png")));
    }

    /**
     * Event handler method that transforms the button appearance when mouse hovers over the button
     *
     * @param evt {ActionEvent object}
     */
    private void regButtonCMouseEntered(MouseEvent evt) {
        // TODO add your handling code here:

        regButtonC.setIcon(new ImageIcon(getClass().getResource("reg-button-blu.png")));
    }

    /**
     * Event handler method that transforms the button appearance when mouse exits the button
     *
     * @param evt {ActionEvent object}
     */
    private void regButtonCMouseExited(MouseEvent evt) {
        // TODO add your handling code here:
        regButtonC.setIcon(new ImageIcon(getClass().getResource("reg-btn-w.png")));

    }

    /**
     * Event handler method that transforms the button appearance when mouse hovers over the button
     *
     * @param evt {ActionEvent object}
     * @param button {JButton object - button whose colour will be changed when hovered over}
     */
    public void forgottenPasswordMouseEntered(MouseEvent evt, JButton button) {
        // TODO add your handling code here:

        button.setForeground(new Color(255, 255, 255));

    }

    /**
     * Event handler method that transforms the button appearance when mouse exits the button
     *
     * @param evt {ActionEvent object}
     * @param button {JButton object - button whose colour will be changed when exited}
     */
    public void forgottenPasswordMouseExited(MouseEvent evt, JButton button) {
        // TODO add your handling code here:                   

        button.setForeground(new Color(0, 99, 178));

    }

    /**
     * Event handler method that transforms the text size of text and password fields
     * the more the number of characters is entered.
     *
     * @param evt {KeyEvent object - listening for a key to be released}
     * @param obj {Object, which is either JTextField or JPasswordField}
     */
    public void fieldKeyReleased(KeyEvent evt, Object obj) {

        if (obj instanceof JTextField) {
            JTextField tf = (JTextField) obj;

            int emailLength = tf.getText().length();
            //adjusts font sizes.
            if (emailLength > 14 && emailLength <= 25) {
                tf.setFont(new Font("Helvetica Neue", 0, 14));
            } else if (emailLength > 25) {
                tf.setFont(new Font("Helvetica Neue", 0, 12));
            } else {
                tf.setFont(new Font("Helvetica Neue", 0, 18));
            }

        } else if (obj instanceof JPasswordField) {
            JPasswordField pf = (JPasswordField) obj;

            int emailLength = pf.getPassword().length;
            //adjusts font sizes.
            if (emailLength > 14 && emailLength <= 25) {
                pf.setFont(new Font("Helvetica Neue", 0, 14));
            } else if (emailLength > 25) {
                pf.setFont(new Font("Helvetica Neue", 0, 12));
            } else {
                pf.setFont(new Font("Helvetica Neue", 0, 18));
            }

        }

    }

    /**
     * Event handler method that deals with highlighting the JTextField/JPasswordField when it has been selected
     *
     * @param evt {FocusEvent}
     * @param obj {Object, which is either JTextField or JPasswordField}
     */
    public void fieldFocusGained(FocusEvent evt, Object obj) {

        if (obj instanceof JTextField) {
            JTextField tf = (JTextField) obj;
            tf.setBorder(BorderFactory.createLineBorder(new Color(0, 99, 178), 3));
        } else if (obj instanceof JPasswordField) {
            JPasswordField pf = (JPasswordField) obj;
            pf.setBorder(BorderFactory.createLineBorder(new Color(0, 99, 178), 3));
        }

    }

    /**
     * Event handler method that deals with removing highlighting of the JTextField/JPasswordField
     * when focus has been lost.
     *
     * @param evt {FocusEvent}
     * @param obj {Object, which is either JTextField or JPasswordField}
     * @param s {String - set field text to this value if the field is empty when focus is lost}
     */
    public void fieldFocusLost(FocusEvent evt, Object obj, String s) {

        if (obj instanceof JTextField) {
            JTextField tf = (JTextField) obj;
            tf.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0), 1));
            if (tf.getText().equals("")) {
                tf.setText(s);
            }
        } else if (obj instanceof JPasswordField) {
            JPasswordField pf = (JPasswordField) obj;
            pf.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0), 1));
            if (pf.getText().equals("")) {
                pf.setText(s);
            }

        }
    }

    /**
     * Event handler method that deals with clearing JTextField/JPasswordField when it has been clicked.
     *
     * @param evt {MouseEvent}
     * @param obj {Object, which is either JTextField or JPasswordField}
     * @param s {String - clear field when it has been clicked and it contains the string s}
     */
    public void fieldMouseClicked(MouseEvent evt, Object obj, String s) {
        // TODO add your handling code here:
        if (obj instanceof JTextField) {
            JTextField name = (JTextField) obj;
            if (name.getText().equals(s)) {

                name.setText("");

            }
        } else if (obj instanceof JPasswordField) {
            JPasswordField pass = (JPasswordField) obj;
            if (pass.getText().equals(s)) {

                pass.setText("");

            }
        }

    }

    /**
     * Method that sets visual elements locations and gui element listeners.
     */
    public void contentsPanel() {

        lightBluePanel = new JPanel();
        emailField = new JTextField();
        loginButton = new JButton();
        registerButton = new JButton();
        checkBox = new JCheckBox();
        passwordField = new JPasswordField();
        imageLabel = new JLabel();
        forgottenPassword = new JButton();
        regButtonC = new JLabel();
        loginButtonC = new JLabel();

        lightBluePanel.setBackground(new Color(156, 195, 213));
        lightBluePanel.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        lightBluePanel.setPreferredSize(new Dimension(400, 400));

        try {

            logo = new ImageIcon(getClass().getResource("design1-small2.png"));
               
        } catch (NullPointerException e) {
            System.out.println("image not found.");
        }

        imageLabel.setIcon(logo);
        emailField.setHighlighter(null);
        emailField.setBackground(new Color(202, 204, 208));
        emailField.setFont(new Font("Helvetica Neue", 0, 18)); // NOI18N
        emailField.setForeground(new Color(0, 0, 0));
        emailField.setHorizontalAlignment(JTextField.CENTER);
        emailField.setText("EMAIL");
        emailField.setToolTipText("Enter Your Email Address");
        emailField.setAlignmentX(0.0F);
        emailField.setAlignmentY(0.0F);
        emailField.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        emailField.setSelectedTextColor(new Color(0, 0, 0));
        emailField.setSelectionEnd(0);
        emailField.setSelectionStart(0);

        /**
         * Key listener for email field
         */
        emailField.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyPressed(java.awt.event.KeyEvent evt) {
                fieldKeyReleased(evt, emailField);
            }

        });

        /**
         * Focus Listeners for email field
         */
        emailField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent evt) {
                //userNameFocusGained(evt);
                fieldFocusGained(evt, emailField);
            }

            @Override
            public void focusLost(FocusEvent evt) {
                //userNameFocusLost(evt);
                emailField.setHighlighter(new DefaultHighlighter());
                fieldFocusLost(evt, emailField, "EMAIL");
            }
        });

        /**
         * Mouse Click listener for email field
         */
        emailField.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                fieldMouseClicked(evt, emailField, "EMAIL");
            }
        });

        loginButton.requestFocusInWindow();
        loginButton.setVisible(true);
        loginButton.setBackground(new Color(255, 255, 255));
        loginButton.setFont(new Font("Verdana", 0, 13)); // NOI18N
        loginButton.setForeground(new Color(0, 0, 0));
        loginButton.setText("LOGIN");
        loginButton.setToolTipText("");
        loginButton.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        loginButton.setContentAreaFilled(false);
        loginButton.setOpaque(true);
        loginButton.setBackground(new Color(255, 255, 255));
        loginButton.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        loginButton.setVisible(false);

        checkBox.setSelected(false);
        checkBox.setBackground(new Color(156, 195, 213));
        checkBox.setFont(new Font("Helvetica", 0, 13)); // NOI18N
        checkBox.setForeground(new Color(0, 0, 0));
        checkBox.setText("Show Password");
        checkBox.setToolTipText("Select to Show Password From Password Boxes.");
        checkBox.setAlignmentY(0.0F);
        checkBox.setHorizontalAlignment(SwingConstants.CENTER);
        checkBox.setIconTextGap(1);
        checkBox.setMargin(new Insets(0, 0, 0, 0));
        checkBox.setOpaque(false);

        /**
         * Action Listener for check box
         */
        checkBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                checkBoxActionPerformed(evt);
            }
        });

        passwordField.setBackground(new Color(202, 204, 208));
        passwordField.setFont(new Font("Helvetica Neue", 0, 18)); // NOI18N
        passwordField.setForeground(new Color(0, 0, 0));
        passwordField.setHorizontalAlignment(JTextField.CENTER);
        passwordField.setText("PASSWORD");
        passwordField.setToolTipText("Enter Password");
        passwordField.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        passwordField.setCaretPosition(0);
        passwordField.setCursor(new Cursor(Cursor.TEXT_CURSOR));
        passwordField.setEchoChar('\u25cf');

        /**
         * Focus listeners for password field
         */
        passwordField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent evt) {
                //userNameFocusGained(evt);
                fieldFocusGained(evt, passwordField);
            }

            @Override
            public void focusLost(FocusEvent evt) {
                //userNameFocusLost(evt);
                fieldFocusLost(evt, passwordField, "PASSWORD");
            }
        });

        /**
         * Mouse Click listener for password field
         */
        passwordField.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                fieldMouseClicked(evt, passwordField, "PASSWORD");
            }
        });

        /**
         * Key listener for password field
         */
        passwordField.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyPressed(java.awt.event.KeyEvent evt) {
                fieldKeyReleased(evt, passwordField);
            }

        });

        imageLabel.setHorizontalAlignment(SwingConstants.CENTER);

        forgottenPassword.setBackground(new Color(255, 255, 255));
        forgottenPassword.setFont(new Font("Helvetica", 0, 13)); // NOI18N
        forgottenPassword.setForeground(new Color(0, 99, 178));
        forgottenPassword.setText("Forgot your password? Click here.");
        forgottenPassword.setToolTipText("");
        forgottenPassword.setBorder(null);
        forgottenPassword.setOpaque(false);
        registerButton.setOpaque(true);

        /**
         * Mouse listeners for entering and exiting forgotten password field
         */
        forgottenPassword.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent evt) {
                forgottenPasswordMouseExited(evt, forgottenPassword);
            }

            @Override
            public void mouseEntered(MouseEvent evt) {
                forgottenPasswordMouseEntered(evt, forgottenPassword);
            }
        });
        regButtonC.setIcon(new ImageIcon(getClass().getResource("reg-btn-w.png"))); // NOI18N

        /**
         * Mouse listeners for entering and exiting registration button
         */
        regButtonC.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent evt) {
                regButtonCMouseExited(evt);
            }

            @Override
            public void mouseEntered(MouseEvent evt) {
                regButtonCMouseEntered(evt);
            }
        });

        /**
         * Mouse listeners for entering and exiting login button
         */
        loginButtonC.setIcon(new ImageIcon(getClass().getResource("log-btn-w.png"))); // NOI18N
        loginButtonC.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent evt) {
                loginButtonCMouseExited(evt);
            }

            @Override
            public void mouseEntered(MouseEvent evt) {
                loginButtonCMouseEntered(evt);
            }
        });

        GroupLayout lightBluePanelLayout = new GroupLayout(lightBluePanel);
        lightBluePanel.setLayout(lightBluePanelLayout);
        lightBluePanelLayout.setHorizontalGroup(
                lightBluePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(lightBluePanelLayout.createSequentialGroup()
                                .addContainerGap(78, Short.MAX_VALUE)
                                .addGroup(lightBluePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(GroupLayout.Alignment.TRAILING, lightBluePanelLayout.createSequentialGroup()
                                                .addGroup(lightBluePanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                                        .addComponent(imageLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(passwordField)
                                                        .addGroup(GroupLayout.Alignment.LEADING, lightBluePanelLayout.createSequentialGroup()
                                                                .addComponent(loginButtonC, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(regButtonC, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE))
                                                        .addComponent(emailField))
                                                .addGap(78, 78, 78))
                                        .addGroup(GroupLayout.Alignment.TRAILING, lightBluePanelLayout.createSequentialGroup()
                                                .addGroup(lightBluePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(forgottenPassword)
                                                        .addGroup(lightBluePanelLayout.createSequentialGroup()
                                                                .addComponent(loginButton, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(registerButton, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)))
                                                .addGap(77, 77, 77))))
                        .addGroup(lightBluePanelLayout.createSequentialGroup()
                                .addGap(122, 122, 122)
                                .addComponent(checkBox)
                                .addGap(0, 0, Short.MAX_VALUE))
        );
        lightBluePanelLayout.setVerticalGroup(
                lightBluePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, lightBluePanelLayout.createSequentialGroup()
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(imageLabel, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(emailField, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(passwordField, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(checkBox)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(lightBluePanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addComponent(loginButtonC, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(regButtonC, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(forgottenPassword, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(lightBluePanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(loginButton, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(registerButton, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
                                .addGap(42, 42, 42))
        );

        registerButton.setVisible(false);

    }

}

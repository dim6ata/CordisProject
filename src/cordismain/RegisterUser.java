package cordismain;

import javax.swing.JTextField;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.text.DefaultHighlighter;

/**
 * Class that extends LoginUser and is responsible for the displaying of
 * visual content for the registration functionality.
 *
 * @author dim6ata
 */
public class RegisterUser extends LoginUser {

    // Variables declaration  
    protected JLabel cancelButton;
    private JCheckBox checkBox;
    private JTextField confirmEmailField;
    private JPasswordField confirmPassField;
    private JPanel containerPanel;
    private JTextField emailField;
    private JLabel imageLabel;
    private JLabel jLabel1;
    private JPanel lightBluePanel;
    protected JButton loginButton;
    protected JLabel okButton;
    private JPasswordField passwordField;
    protected JButton registerButton;
    private JTextField userName;
    private ImageIcon logo;
    // End of variables declaration 

    //Constructor:
    public RegisterUser(String name) {
        super(name);

    }

    /**
     *
     * @return {JLabel - used to communicate button object with server/controller class}
     */
    public JLabel getCancelButton() {
        return cancelButton;
    }

    /**
     *
     * @return {JLabel - used to communicate button object with server/controller class}
     */
    public JLabel getOkButton() {
        return okButton;
    }

    /**
     *
     * @return {String - retrieves text entered in name text field.
     * Used to communicate button object with server/controller class}
     */
    public String getEnteredName() {

        return userName.getText();

    }

    /**
     *
     * @return {String - retrieves text entered in email text field.
     * Used to communicate button object with server/controller class}
     */
    @Override
    public String getEnteredEmail() {

        return emailField.getText();
    }

    /**
     *
     * @return {String - retrieves text entered in confirm email text field.
     * Used to communicate button object with server/controller class}
     */
    public String getConfirmEmailField() {

        return confirmEmailField.getText();

    }

    /**
     *
     * @return {char[] - retrieves the data entered in passwordField.
     * char[] is the preferred object as it is more secure than string}
     */
    @Override
    public char[] getEnteredPassword() {
        return passwordField.getPassword();
    }

    /**
     *
     * @return {char[] - retrieves the data entered in confirmPassField.
     * char[] is the preferred object as it is more secure than string}
     */
    public char[] getConfirmPassField() {
        return confirmPassField.getPassword();
    }

    /**
     * Method which initialises and is responsible for accurately displaying
     * gui contents on screen.
     * <p>
     * It overrides initComponents of LoginUser class.
     */
    @Override
    public void initComponents() {

        containerPanel = new JPanel();
        jLabel1 = new JLabel();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBackground(new Color(0, 99, 178));
        setName("Cordis Login"); // NOI18N

        containerPanel.setBackground(new Color(0, 99, 178));
        containerPanel.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        containerPanel.setPreferredSize(null);

        contentsPanel();

        jLabel1.setFont(new Font("Verdana", 1, 52)); // NOI18N
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
            confirmPassField.setEchoChar((char) 0);
        } else {

            passwordField.setEchoChar('\u25cf');
            confirmPassField.setEchoChar('\u25cf');
        }
    }

    /**
     * Event handler method that transforms the button appearance when mouse hovers over the button
     *
     * @param evt {ActionEvent object}
     */
    private void okButtonMouseEntered(MouseEvent evt) {

        okButton.setIcon(new ImageIcon(getClass().getResource("ok-btn-bl.png")));

    }

    /**
     * Event handler method that transforms the button appearance when mouse exits the button
     *
     * @param evt {ActionEvent object}
     */
    private void okButtonMouseExited(MouseEvent evt) {

        okButton.setIcon(new ImageIcon(getClass().getResource("ok-btn-w.png")));
    }

    /**
     * Event handler method that transforms the button appearance when mouse hovers over the button
     *
     * @param evt {ActionEvent object}
     */
    private void cancelButtonMouseEntered(MouseEvent evt) {

        cancelButton.setIcon(new ImageIcon(getClass().getResource("cancel-btn-bl.png")));
    }

    /**
     * Event handler method that transforms the button appearance when mouse exits the button
     *
     * @param evt {ActionEvent object}
     */
    private void cancelButtonMouseExited(MouseEvent evt) {

        cancelButton.setIcon(new ImageIcon(getClass().getResource("cancel-btn-w.png")));
    }

    /**
     * Method that sets visual elements locations and gui element listeners.
     * Overridden contentsPanel() from LoginUser
     */
    @Override
    public void contentsPanel() {

        lightBluePanel = new JPanel();
        confirmEmailField = new JTextField();
        loginButton = new JButton();
        registerButton = new JButton();
        checkBox = new JCheckBox();
        passwordField = new JPasswordField();
        imageLabel = new JLabel();
        okButton = new JLabel();
        emailField = new JTextField();
        confirmPassField = new JPasswordField();
        userName = new JTextField();
        cancelButton = new JLabel();

        try {

            logo = new ImageIcon(getClass().getResource("design1-small.png"));

        } catch (NullPointerException e) {
            System.out.println("image not found.");
        }

        imageLabel.setIcon(logo);

        lightBluePanel.setBackground(new Color(156, 195, 213));
        lightBluePanel.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        lightBluePanel.setPreferredSize(new Dimension(400, 400));

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

        registerButton.setBackground(new Color(255, 255, 255));
        registerButton.setFont(new Font("Verdana", 0, 13)); // NOI18N
        registerButton.setForeground(new Color(0, 0, 0));
        registerButton.setText("REGISTER");
        registerButton.setToolTipText("");
        registerButton.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        registerButton.setOpaque(true);

        imageLabel.setHorizontalAlignment(SwingConstants.CENTER);

        userName.setHighlighter(null);
        userName.setBackground(new Color(202, 204, 208));
        userName.setFont(new Font("Helvetica Neue", 0, 16)); // NOI18N
        userName.setForeground(new Color(0, 0, 0));
        userName.setHorizontalAlignment(JTextField.CENTER);
        userName.setText("NAME");
        userName.setToolTipText("Enter Your Name");
        userName.setAlignmentX(0.0F);
        userName.setAlignmentY(0.0F);
        userName.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        userName.setSelectedTextColor(new Color(0, 0, 0));
        userName.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyPressed(java.awt.event.KeyEvent evt) {
                fieldKeyReleased(evt, userName);
            }
        });

        /**
         * Focus Listeners for name text field
         */
        userName.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent evt) {

                fieldFocusGained(evt, userName);
            }

            @Override
            public void focusLost(FocusEvent evt) {
                userName.setHighlighter(new DefaultHighlighter());
                fieldFocusLost(evt, userName, "NAME");
            }
        });

        /**
         * Mouse Click listener for name text field
         */
        userName.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                fieldMouseClicked(evt, userName, "NAME");
            }
        });

        emailField.setBackground(new Color(202, 204, 208));
        emailField.setFont(new Font("Helvetica Neue", 0, 16)); // NOI18N
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

                fieldFocusGained(evt, emailField);
            }

            @Override
            public void focusLost(FocusEvent evt) {

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

        confirmEmailField.setBackground(new Color(202, 204, 208));
        confirmEmailField.setFont(new Font("Helvetica Neue", 0, 16)); // NOI18N
        confirmEmailField.setForeground(new Color(0, 0, 0));
        confirmEmailField.setHorizontalAlignment(JTextField.CENTER);
        confirmEmailField.setText("CONFIRM EMAIL");
        confirmEmailField.setToolTipText("Confirm Your Email Address");
        confirmEmailField.setAlignmentX(0.0F);
        confirmEmailField.setAlignmentY(0.0F);
        confirmEmailField.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        confirmEmailField.setSelectedTextColor(new Color(0, 0, 0));

        /**
         * Key listener for confirm email field
         */
        confirmEmailField.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyPressed(java.awt.event.KeyEvent evt) {
                fieldKeyReleased(evt, confirmEmailField);
            }
        });

        /**
         * Focus Listeners for confirm email field
         */
        confirmEmailField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent evt) {
                //userNameFocusGained(evt);
                fieldFocusGained(evt, confirmEmailField);
            }

            @Override
            public void focusLost(FocusEvent evt) {
                //userNameFocusLost(evt);
                fieldFocusLost(evt, confirmEmailField, "CONFIRM EMAIL");
            }
        });

        /**
         * Mouse Click listener for confirm email field
         */
        confirmEmailField.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                fieldMouseClicked(evt, confirmEmailField, "CONFIRM EMAIL");
            }
        });

        passwordField.setBackground(new Color(202, 204, 208));
        passwordField.setFont(new Font("Helvetica Neue", 0, 16)); // NOI18N
        passwordField.setForeground(new Color(0, 0, 0));
        passwordField.setHorizontalAlignment(JTextField.CENTER);
        passwordField.setText("PASSWORD");
        passwordField.setToolTipText("Enter Password: Case sensitive, 8 characters minimum,\nmust include at least 1 symbol(@$!%*?&), 1 capital letter, 1 digit.");
        passwordField.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        passwordField.setCaretPosition(0);
        passwordField.setCursor(new Cursor(Cursor.TEXT_CURSOR));
        passwordField.setEchoChar((char) 0);

        /**
         * Key listener for password field
         */
        passwordField.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyPressed(java.awt.event.KeyEvent evt) {
                fieldKeyReleased(evt, passwordField);
            }
        });

        /**
         * Focus Listeners for password field
         */
        passwordField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent evt) {

                fieldFocusGained(evt, passwordField);
            }

            @Override
            public void focusLost(FocusEvent evt) {

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

        confirmPassField.setBackground(new Color(202, 204, 208));
        confirmPassField.setFont(new Font("Helvetica Neue", 0, 16)); // NOI18N
        confirmPassField.setForeground(new Color(0, 0, 0));
        confirmPassField.setHorizontalAlignment(JTextField.CENTER);
        confirmPassField.setText("CONFIRM PASSWORD");
        confirmPassField.setToolTipText("Confirm Password");
        confirmPassField.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        confirmPassField.setCursor(new Cursor(Cursor.TEXT_CURSOR));
        confirmPassField.setEchoChar((char) 0);

        /**
         * Key listener for confirm password field
         */
        confirmPassField.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyPressed(java.awt.event.KeyEvent evt) {
                fieldKeyReleased(evt, confirmPassField);
            }
        });

        /**
         * Focus Listeners for confirm password field
         */
        confirmPassField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent evt) {

                fieldFocusGained(evt, confirmPassField);
            }

            @Override
            public void focusLost(FocusEvent evt) {

                fieldFocusLost(evt, confirmPassField, "CONFIRM PASSWORD");
            }
        });

        /**
         * Mouse Click listener for confirm password field
         */
        confirmPassField.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                fieldMouseClicked(evt, confirmPassField, "CONFIRM PASSWORD");
            }
        });

        okButton.setIcon(new ImageIcon(getClass().getResource("ok-btn-w.png"))); // NOI18N
        okButton.setToolTipText("Press Ok to Confirm Registration");
        okButton.setAlignmentY(0.0F);

        /**
         * Listener for ok button hovering effect
         */
        okButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent evt) {
                okButtonMouseExited(evt);
            }

            @Override
            public void mouseEntered(MouseEvent evt) {
                okButtonMouseEntered(evt);
            }
        });

        cancelButton.setIcon(new ImageIcon(getClass().getResource("cancel-btn-w.png"))); // NOI18N
        cancelButton.setToolTipText("Press Cancel to Return to Login");
        cancelButton.setAlignmentY(0.0F);
        cancelButton.setAutoscrolls(true);

        /**
         * Listeners for cancel button hovering effect
         */
        cancelButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent evt) {
                cancelButtonMouseExited(evt);
            }

            @Override
            public void mouseEntered(MouseEvent evt) {
                cancelButtonMouseEntered(evt);
            }
        });

        checkBox.setSelected(true);
        checkBox.setBackground(new Color(156, 195, 213));
        checkBox.setFont(new Font("Helvetica", 0, 13)); // NOI18N
        checkBox.setForeground(new Color(0, 0, 0));
        checkBox.setText("Show Password");
        checkBox.setToolTipText("Show Password From Password Boxes, untick to hide.");
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

        GroupLayout lightBluePanelLayout = new GroupLayout(lightBluePanel);
        lightBluePanel.setLayout(lightBluePanelLayout);
        lightBluePanelLayout.setHorizontalGroup(
                lightBluePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(lightBluePanelLayout.createSequentialGroup()
                                .addContainerGap(78, Short.MAX_VALUE)
                                .addGroup(lightBluePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(lightBluePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                .addGroup(GroupLayout.Alignment.TRAILING, lightBluePanelLayout.createSequentialGroup()
                                                        .addComponent(imageLabel, GroupLayout.PREFERRED_SIZE, 202, GroupLayout.PREFERRED_SIZE)
                                                        .addGap(78, 78, 78))
                                                .addGroup(GroupLayout.Alignment.TRAILING, lightBluePanelLayout.createSequentialGroup()
                                                        .addComponent(loginButton, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                        .addComponent(registerButton, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
                                                        .addGap(77, 77, 77)))
                                        .addGroup(lightBluePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                .addGroup(GroupLayout.Alignment.TRAILING, lightBluePanelLayout.createSequentialGroup()
                                                        .addGroup(lightBluePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                .addComponent(emailField, GroupLayout.PREFERRED_SIZE, 202, GroupLayout.PREFERRED_SIZE)
                                                                .addGroup(lightBluePanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                                                        .addComponent(passwordField)
                                                                        .addComponent(confirmEmailField)
                                                                        .addComponent(confirmPassField, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 202, GroupLayout.PREFERRED_SIZE))
                                                                .addComponent(userName, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 202, GroupLayout.PREFERRED_SIZE))
                                                        .addGap(78, 78, 78))
                                                .addGroup(GroupLayout.Alignment.TRAILING, lightBluePanelLayout.createSequentialGroup()
                                                        .addComponent(okButton, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                        .addComponent(cancelButton, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
                                                        .addGap(77, 77, 77)))))
                        .addGroup(lightBluePanelLayout.createSequentialGroup()
                                .addGap(125, 125, 125)
                                .addComponent(checkBox)
                                .addGap(0, 0, Short.MAX_VALUE))
        );
        lightBluePanelLayout.setVerticalGroup(
                lightBluePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, lightBluePanelLayout.createSequentialGroup()
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(imageLabel, GroupLayout.PREFERRED_SIZE, 134, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(userName, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(emailField, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(confirmEmailField, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(passwordField, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(confirmPassField, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                .addGap(7, 7, 7)
                                .addComponent(checkBox)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(lightBluePanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addComponent(okButton, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(cancelButton, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
                                .addGap(48, 48, 48)
                                .addGroup(lightBluePanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(loginButton, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(registerButton, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
                                .addGap(42, 42, 42))
        );

        registerButton.setVisible(false);

    }

}

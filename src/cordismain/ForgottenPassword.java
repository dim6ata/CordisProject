package cordismain;

import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.*;
import javax.swing.text.DefaultHighlighter;

/**
 * Class that creates a frame for forgotten password functionality.
 * It extends LoginUser.
 *
 * @author dim6ata
 */
public class ForgottenPassword extends LoginUser {

    // Variables declaration                    
    protected JLabel confirmButton;
    private JPanel containerPanel;
    private JTextField emailField;
    protected JTextField verificationField;
    private JLabel imageLabel;
    private JLabel jLabel1;
    private JPanel lightBluePanel;
    protected JLabel sendButton;
    protected JButton backToLogin;
    private ImageIcon logo;
    // End of variables declaration   

    //Constructor:
    public ForgottenPassword(String name) {
        super(name);

    }

    /**
     * Getters:
     * <p>
     */
    public JLabel getConfirmButton() {
        return confirmButton;
    }

    public JLabel getSendButton() {
        return sendButton;
    }

    public JButton getBackToLogin() {
        return backToLogin;
    }

    public String getEnteredCode() {

        return verificationField.getText();
    }

    @Override
    public String getEnteredEmail() {
        return emailField.getText();
    }

    @Override
    public void initComponents() {

        containerPanel = new JPanel();
        lightBluePanel = new JPanel();
        emailField = new JTextField();
        imageLabel = new JLabel();
        confirmButton = new JLabel();
        sendButton = new JLabel();
        verificationField = new JTextField();
        jLabel1 = new JLabel();
        backToLogin = new JButton();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBackground(new Color(0, 99, 178));

        containerPanel.setBackground(new Color(0, 99, 178));
        containerPanel.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        containerPanel.setPreferredSize(null);

        try {

            logo = new ImageIcon(getClass().getResource("design1-small2.png"));

        } catch (NullPointerException e) {
            System.out.println("image not found.");
        }

        imageLabel.setIcon(logo);

        lightBluePanel.setBackground(new Color(156, 195, 213));
        lightBluePanel.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        lightBluePanel.setPreferredSize(new Dimension(400, 400));

        GroupLayout lightBluePanelLayout = new GroupLayout(lightBluePanel);
        lightBluePanel.setLayout(lightBluePanelLayout);
        lightBluePanelLayout.setHorizontalGroup(
                lightBluePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, lightBluePanelLayout.createSequentialGroup()
                                .addContainerGap(78, Short.MAX_VALUE)
                                .addGroup(lightBluePanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(imageLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(GroupLayout.Alignment.LEADING, lightBluePanelLayout.createSequentialGroup()
                                                .addComponent(sendButton, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(confirmButton, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE))
                                        .addComponent(emailField)
                                        .addComponent(verificationField)
                                        .addComponent(backToLogin, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(78, 78, 78))
        );
        lightBluePanelLayout.setVerticalGroup(
                lightBluePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, lightBluePanelLayout.createSequentialGroup()
                                .addContainerGap(37, Short.MAX_VALUE)
                                .addComponent(imageLabel, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(emailField, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(verificationField, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20)
                                .addGroup(lightBluePanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addComponent(sendButton, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(confirmButton, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(backToLogin, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
                                .addGap(37, 37, 37))
        );

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
        emailField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent evt) {
                fieldKeyReleased(evt, emailField);
            }

        });

        emailField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent evt) {

                fieldFocusGained(evt, emailField);
            }

            @Override
            public void focusLost(FocusEvent evt) {

                emailField.setHighlighter(new DefaultHighlighter());
                fieldFocusLost(evt, emailField, "EMAIL");
            }
        });
        emailField.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                fieldMouseClicked(evt, emailField, "EMAIL");
            }
        });

        imageLabel.setHorizontalAlignment(SwingConstants.CENTER);

        confirmButton.setIcon(new ImageIcon(getClass().getResource("confirm-btn-w.png"))); // NOI18N
        confirmButton.setToolTipText("Confirm verification");
        confirmButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent evt) {
                confirmButtonMouseExited(evt);
            }

            @Override
            public void mouseEntered(MouseEvent evt) {
                confirmButtonMouseEntered(evt);
            }
        });

        sendButton.setIcon(new ImageIcon(getClass().getResource("send-btn-w.png"))); // NOI18N
        sendButton.setToolTipText("Send a new verification code to your email");
        sendButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent evt) {
                sendButtonMouseExited(evt);
            }

            @Override
            public void mouseEntered(MouseEvent evt) {
                sendButtonMouseEntered(evt);
            }
        });

        verificationField.setBackground(new Color(202, 204, 208));
        verificationField.setFont(new Font("Helvetica Neue", 0, 18)); // NOI18N
        verificationField.setForeground(new Color(0, 0, 0));
        verificationField.setHorizontalAlignment(JTextField.CENTER);
        verificationField.setText("VERIFICATION CODE");
        verificationField.setToolTipText("Enter Verification Code that you received in your mail box");
        verificationField.setAlignmentX(0.0F);
        verificationField.setAlignmentY(0.0F);
        verificationField.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        verificationField.setSelectedTextColor(new Color(0, 0, 0));

        verificationField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent evt) {
                fieldKeyReleased(evt, verificationField);
            }

        });

        verificationField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent evt) {

                fieldFocusGained(evt, verificationField);
            }

            @Override
            public void focusLost(FocusEvent evt) {

                verificationField.setHighlighter(new DefaultHighlighter());
                fieldFocusLost(evt, verificationField, "VERIFICATION CODE");
            }
        });
        verificationField.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                fieldMouseClicked(evt, verificationField, "VERIFICATION CODE");
            }
        });

        backToLogin.setBackground(new Color(255, 255, 255));
        backToLogin.setFont(new Font("Helvetica", 0, 13)); // NOI18N
        backToLogin.setForeground(new Color(0, 99, 178));
        backToLogin.setText("Remembered Your Password?");
        backToLogin.setToolTipText("");
        backToLogin.setBorder(null);
        backToLogin.setOpaque(false);
        backToLogin.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent evt) {

                forgottenPasswordMouseExited(evt, backToLogin);

            }

            @Override
            public void mouseEntered(MouseEvent evt) {

                forgottenPasswordMouseEntered(evt, backToLogin);
            }
        });
        backToLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {

//                backToLoginActionPerformed(evt);
            }
        });

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
    }// </editor-fold>                        

    /**
     * Event handlers:
     * <p>
     */
    private void sendButtonMouseEntered(MouseEvent evt) {

        sendButton.setIcon(new ImageIcon(getClass().getResource("send-btn-bl.png")));

    }

    private void sendButtonMouseExited(MouseEvent evt) {

        sendButton.setIcon(new ImageIcon(getClass().getResource("send-btn-w.png")));
    }

    private void confirmButtonMouseEntered(MouseEvent evt) {

        confirmButton.setIcon(new ImageIcon(getClass().getResource("confirm-btn-bl.png")));
    }

    private void confirmButtonMouseExited(MouseEvent evt) {

        confirmButton.setIcon(new ImageIcon(getClass().getResource("confirm-btn-w.png")));

    }

}

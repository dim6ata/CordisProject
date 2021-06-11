package cordismain;

import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Insets;
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

/**
 * Class that is used for displaying change password frame extending LoginUser.
 *
 * @author dim6ata
 */
public class ChangePassword extends LoginUser {

    private ImageIcon logo;
    // Variables declaration - do not modify                     
    protected JLabel cancelButtonCh;
    protected JCheckBox checkBox;
    protected JPasswordField confirmPassField;
    private JPanel containerPanel;
    private JLabel imageLabel;
    private JLabel jLabel1;
    private JPanel lightBluePanel;
    protected JLabel okButtonCh;
    protected JPasswordField passwordField;
    // End of variables declaration                

    //Constructor:
    public ChangePassword(String name) {
        super(name);
    }

    //Getters:
    public JLabel getCancelButtonCh() {
        return cancelButtonCh;
    }

    public char[] getConfirmPassword() {

        return confirmPassField.getPassword();
    }

    public JLabel getOkButtonCh() {
        return okButtonCh;
    }

    public char[] getPasswordEntered() {

        return passwordField.getPassword();
    }

    @Override
    public void initComponents() {

        containerPanel = new JPanel();
        lightBluePanel = new JPanel();
        checkBox = new JCheckBox();
        passwordField = new JPasswordField();
        imageLabel = new JLabel();
        okButtonCh = new JLabel();
        confirmPassField = new JPasswordField();
        cancelButtonCh = new JLabel();
        jLabel1 = new JLabel();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBackground(new Color(0, 99, 178));
        setName("Cordis Login"); // NOI18N

        containerPanel.setBackground(new Color(0, 99, 178));
        containerPanel.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        containerPanel.setPreferredSize(null);

        lightBluePanel.setBackground(new Color(156, 195, 213));
        lightBluePanel.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        lightBluePanel.setPreferredSize(new Dimension(400, 400));

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
        checkBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                checkBoxActionPerformed(evt);
            }
        });

        try {

            logo = new ImageIcon(getClass().getResource("design1-small2.png"));

        } catch (NullPointerException e) {
            System.out.println("image not found.");
        }

        imageLabel.setIcon(logo);

        passwordField.setBackground(new Color(202, 204, 208));
        passwordField.setFont(new Font("Helvetica Neue", 0, 16)); // NOI18N
        passwordField.setForeground(new Color(0, 0, 0));
        passwordField.setHorizontalAlignment(JTextField.CENTER);
        passwordField.setText("PASSWORD");
        passwordField.setToolTipText("Enter Password: Case sensitive, 8 characters minimum, must include at least 1 symbol, 1 capital letter, 1 digit.");
        passwordField.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        passwordField.setCaretPosition(0);
        passwordField.setCursor(new Cursor(Cursor.TEXT_CURSOR));
        passwordField.setEchoChar((char) 0);
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

        passwordField.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                fieldMouseClicked(evt, passwordField, "PASSWORD");
            }
        });
        passwordField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent evt) {
                fieldKeyReleased(evt, passwordField);
            }

        });

        imageLabel.setHorizontalAlignment(SwingConstants.CENTER);

        okButtonCh.setIcon(new ImageIcon(getClass().getResource("ok-btn-w.png"))); // NOI18N
        okButtonCh.setToolTipText("Press OK to change your password");
        okButtonCh.setAlignmentY(0.0F);
        okButtonCh.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent evt) {
                okButtonChMouseExited(evt);
            }

            @Override
            public void mouseEntered(MouseEvent evt) {
                okButtonChMouseEntered(evt);
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
         * Listener methods:
         */
        confirmPassField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent evt) {
                //userNameFocusGained(evt);
                fieldFocusGained(evt, confirmPassField);
            }

            @Override
            public void focusLost(FocusEvent evt) {
                //userNameFocusLost(evt);
                fieldFocusLost(evt, confirmPassField, "CONFIRM PASSWORD");
            }
        });

        confirmPassField.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                fieldMouseClicked(evt, confirmPassField, "CONFIRM PASSWORD");
            }
        });
        confirmPassField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent evt) {
                fieldKeyReleased(evt, confirmPassField);
            }

        });

        cancelButtonCh.setIcon(new ImageIcon(getClass().getResource("cancel-btn-w.png"))); // NOI18N
        cancelButtonCh.setToolTipText("Press Cancel to Return to Login");
        cancelButtonCh.setAlignmentY(0.0F);
        cancelButtonCh.setAutoscrolls(true);
        cancelButtonCh.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent evt) {
                cancelButtonChMouseExited(evt);
            }

            @Override
            public void mouseEntered(MouseEvent evt) {
                cancelButtonChMouseEntered(evt);
            }
        });

        GroupLayout lightBluePanelLayout = new GroupLayout(lightBluePanel);
        lightBluePanel.setLayout(lightBluePanelLayout);
        lightBluePanelLayout.setHorizontalGroup(
                lightBluePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, lightBluePanelLayout.createSequentialGroup()
                                .addContainerGap(79, Short.MAX_VALUE)
                                .addGroup(lightBluePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(lightBluePanelLayout.createSequentialGroup()
                                                .addGap(47, 47, 47)
                                                .addComponent(checkBox))
                                        .addGroup(lightBluePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                .addGroup(GroupLayout.Alignment.TRAILING, lightBluePanelLayout.createSequentialGroup()
                                                        .addComponent(okButtonCh, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                        .addComponent(cancelButtonCh, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE))
                                                .addGroup(GroupLayout.Alignment.TRAILING, lightBluePanelLayout.createSequentialGroup()
                                                        .addGroup(lightBluePanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                                .addComponent(imageLabel, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 202, GroupLayout.PREFERRED_SIZE)
                                                                .addGroup(lightBluePanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                                                        .addComponent(passwordField)
                                                                        .addComponent(confirmPassField, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 202, GroupLayout.PREFERRED_SIZE)))
                                                        .addGap(1, 1, 1))))
                                .addGap(76, 76, 76))
        );
        lightBluePanelLayout.setVerticalGroup(
                lightBluePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, lightBluePanelLayout.createSequentialGroup()
                                .addContainerGap(33, Short.MAX_VALUE)
                                .addComponent(imageLabel, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20)
                                .addComponent(passwordField, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(confirmPassField, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                                .addGap(7, 7, 7)
                                .addComponent(checkBox)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(lightBluePanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addComponent(okButtonCh, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(cancelButtonCh, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
                                .addGap(46, 46, 46))
        );

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
    }

    /**
     * Event handler method for checkBox:
     *
     * @param evt {ActionEvent}
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
     * Event handler method for ok button entered:
     *
     * @param evt {MouseEvent}
     */
    private void okButtonChMouseEntered(MouseEvent evt) {

        okButtonCh.setIcon(new ImageIcon(getClass().getResource("ok-btn-bl.png")));

    }

    /**
     * Event handler method for ok button exited:
     *
     * @param evt {MouseEvent}
     */
    private void okButtonChMouseExited(MouseEvent evt) {

        okButtonCh.setIcon(new ImageIcon(getClass().getResource("ok-btn-w.png")));
    }

    /**
     * Event handler method for cancel button entered:
     *
     * @param evt {MouseEvent}
     */
    private void cancelButtonChMouseEntered(MouseEvent evt) {

        cancelButtonCh.setIcon(new ImageIcon(getClass().getResource("cancel-btn-bl.png")));
    }

    /**
     * Event handler method for cancel button exited:
     *
     * @param evt {MouseEvent}
     */
    private void cancelButtonChMouseExited(MouseEvent evt) {

        cancelButtonCh.setIcon(new ImageIcon(getClass().getResource("cancel-btn-w.png")));
    }

}

package cordismain;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
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
 * Class that creates a frame for User verification functionality.
 * Extends LoginUser
 *
 * @author dim6ata
 */
public class VerifyUser extends LoginUser {

    // Variables declaration                    
    private JLabel verifyButton;
    private JPanel containerPanel;
    private JTextField verificationField;
    private JLabel imageLabel;
    private JLabel jLabel1;
    private JPanel lightBluePanel;
    private ImageIcon logo;
    // End of variables declaration   

    //Constrtuctor:
    public VerifyUser(String name) {
        super(name);

    }

    /**
     * Getters:
     * <p>
     */
    public JLabel getConfirmButton() {
        return verifyButton;
    }

    public String getEnteredCode() {

        return verificationField.getText();
    }

    @Override
    public void initComponents() {

        containerPanel = new JPanel();
        lightBluePanel = new JPanel();
        imageLabel = new JLabel();
        verifyButton = new JLabel();
        verificationField = new JTextField();
        jLabel1 = new JLabel();

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

        imageLabel.setHorizontalAlignment(SwingConstants.CENTER);

        verifyButton.setIcon(new ImageIcon(getClass().getResource("confirm-btn-w.png"))); // NOI18N
        verifyButton.setToolTipText("Confirm verification");
        verifyButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent evt) {
                verifyButtonMouseExited(evt);
            }

            @Override
            public void mouseEntered(MouseEvent evt) {
                verifyButtonMouseEntered(evt);
            }
        });

        verificationField.setHighlighter(null);
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

        GroupLayout lightBluePanelLayout = new GroupLayout(lightBluePanel);
        lightBluePanel.setLayout(lightBluePanelLayout);
        lightBluePanelLayout.setHorizontalGroup(
                lightBluePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, lightBluePanelLayout.createSequentialGroup()
                                .addContainerGap(78, Short.MAX_VALUE)
                                .addGroup(lightBluePanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(imageLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(verificationField, GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE))
                                .addGap(78, 78, 78))
                        .addGroup(lightBluePanelLayout.createSequentialGroup()
                                .addGap(131, 131, 131)
                                .addComponent(verifyButton, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        lightBluePanelLayout.setVerticalGroup(
                lightBluePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, lightBluePanelLayout.createSequentialGroup()
                                .addContainerGap(64, Short.MAX_VALUE)
                                .addComponent(imageLabel, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(verificationField, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(verifyButton, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                .addGap(64, 64, 64))
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
     * Event handlers:
     * <p>
     */
    private void verifyButtonMouseEntered(MouseEvent evt) {

        verifyButton.setIcon(new ImageIcon(getClass().getResource("confirm-btn-bl.png")));
    }

    private void verifyButtonMouseExited(MouseEvent evt) {

        verifyButton.setIcon(new ImageIcon(getClass().getResource("confirm-btn-w.png")));

    }

}

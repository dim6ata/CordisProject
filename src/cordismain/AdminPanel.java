package cordismain;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.plaf.basic.BasicScrollBarUI;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;

/**
 * generates visual representation for admin page functionality
 *
 * @author dim6ata
 * @author Michal
 * @author Iqram
 * @author Hayder
 * 
 */
public class AdminPanel extends Gui {
    
    /**
     * Constructor:
     * Creates new form Admin
     * @param name frame name.
     */
    public AdminPanel(String name) {

        super(name);
        editable = false;       

    }
    
    /**
     * sets up visual components for AdminPanel
     */ 
    @Override
    public void initComponents() {

        backgroundPanel = new javax.swing.JPanel();
        cordisLabel = new javax.swing.JLabel();
        imageLabel = new javax.swing.JLabel();
        dash1Button = new javax.swing.JLabel();
        dash2Button = new javax.swing.JLabel();
        dash3Button = new javax.swing.JLabel();
        adminButton = new javax.swing.JLabel();
        userSign = new javax.swing.JLabel();
        viewUserButton = new javax.swing.JLabel();
        editUserButton = new javax.swing.JLabel();
        deleteUserButton = new javax.swing.JLabel();
        logOutButton = new javax.swing.JLabel();
        layerPanel = new javax.swing.JLayeredPane();
        homePanel = new javax.swing.JPanel();
        cordisTextArea = new javax.swing.JTextArea();
        cordisLabel1 = new javax.swing.JLabel();
        homeChartContainerPanel = new javax.swing.JPanel();
        homeChartPanel1 = new javax.swing.JPanel();
        homeMidPanel = new javax.swing.JPanel();
        homeNumProjectsLabel = new javax.swing.JTextField();
        homeNumProjects = new javax.swing.JTextField();
        homeNumParticipantsLabel = new javax.swing.JTextField();
        homeNumParticipants = new javax.swing.JTextField();
        homeTotalCostLabel = new javax.swing.JTextField();
        homeTotalCost = new javax.swing.JTextField();
        homeChartPanel2 = new javax.swing.JPanel();
        dashboard1Panel = new javax.swing.JPanel();
        pnl_tabbed = new javax.swing.JTabbedPane();
        bar_option_panel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        countryButton = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jSlider1 = new javax.swing.JSlider();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        display_value = new javax.swing.JLabel();
        line_option_panel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        LineGraphButton = new javax.swing.JButton();
        jCheck2015 = new javax.swing.JCheckBox();
        jCheck2016 = new javax.swing.JCheckBox();
        jCheck2017 = new javax.swing.JCheckBox();
        jCheck2018 = new javax.swing.JCheckBox();
        jCheck2019 = new javax.swing.JCheckBox();
        jLabel3 = new javax.swing.JLabel();
        pnl_chart = new javax.swing.JPanel();
        pnl_table = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        dashboard2Panel = new javax.swing.JPanel();
        dash2ButtonPanel = new javax.swing.JPanel();
        averageButton = new javax.swing.JLabel();
        mostExpensiveButton = new javax.swing.JLabel();
        leastExpensiveButton = new javax.swing.JLabel();
        searchMenuButton = new javax.swing.JLabel();
        dash2DataPanel = new javax.swing.JPanel();
        d2Chart1 = new javax.swing.JPanel();
        d2Chart2 = new javax.swing.JPanel();
        d2Chart3 = new javax.swing.JPanel();
        d2SearchPanel = new javax.swing.JPanel();
        searchTitleLabel = new javax.swing.JLabel();
        searchPanel = new javax.swing.JPanel();
        d2Countrytext = new javax.swing.JTextField();
        d2SearchMost = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        mostExpProjCost = new javax.swing.JLabel();
        SearchButton = new javax.swing.JButton();
        SearchText = new javax.swing.JTextField();
        leastExpProjCost = new javax.swing.JLabel();
        d2SearchLeast = new javax.swing.JTextField();
        d2SearchAverage = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        avgProjCosts = new javax.swing.JLabel();
        d2expensiveCity = new javax.swing.JTextField();
        d2LeastCity = new javax.swing.JTextField();
        cityLabel = new javax.swing.JLabel();
        d2Mproject = new javax.swing.JTextField();
        d2Lproject = new javax.swing.JTextField();
        projectIDLabel = new javax.swing.JLabel();
        dashboard3Panel = new javax.swing.JPanel();
        dashboard3Label = new javax.swing.JLabel();
        d3Tabs = new javax.swing.JTabbedPane();
        maxContributors = new javax.swing.JPanel();
        d3MaxPiePanel = new javax.swing.JPanel();
        d3MaxBarPanel = new javax.swing.JPanel();
        minContributors = new javax.swing.JPanel();
        d3MinPiePanel = new javax.swing.JPanel();
        d3MinBarPanel = new javax.swing.JPanel();
        adminPanel = new javax.swing.JPanel();
        adminLabel = new javax.swing.JLabel();
        buttonPanel = new javax.swing.JPanel();
        buttons2 = new javax.swing.JPanel();
        cancelButton1 = new javax.swing.JLabel();
        buttons1 = new javax.swing.JPanel();
        cancelButton = new javax.swing.JLabel();
        okButton = new javax.swing.JLabel();
        tableContainer = new javax.swing.JPanel();
        table2Panel = new javax.swing.JPanel();
        jScrollPane2 = new CordisScrollPane();
        sessionTable = new javax.swing.JTable();
        jScrollPane3 = new CordisScrollPane();
        detailsTable = new javax.swing.JTable();
        table1Panel = new javax.swing.JPanel();
        jScrollPane1 = new CordisScrollPane();
        userListTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBounds(new java.awt.Rectangle(0, 0, 0, 0));
        setSize(new java.awt.Dimension(0, 0));

        backgroundPanel.setBackground(new java.awt.Color(0, 99, 178));
        backgroundPanel.setAlignmentX(0.0F);
        backgroundPanel.setAlignmentY(0.0F);
        backgroundPanel.setMaximumSize(new java.awt.Dimension(1280, 700));

        cordisLabel.setFont(new java.awt.Font("Verdana", 1, 52)); // NOI18N
        cordisLabel.setForeground(new java.awt.Color(0, 0, 0));
        cordisLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cordisLabel.setText("CORDIS");       
        cordisLabel.setToolTipText("");
        cordisLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        imageLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        imageLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cordismain/design1-sml3.png"))); // NOI18N
        imageLabel.setAlignmentY(0.0F);
        imageLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        imageLabel.setIconTextGap(0);

        dash1Button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cordismain/dashboard1-btn-wb.png"))); // NOI18N
        dash1Button.setToolTipText("Click to display dashboard 1 details");
        dash1Button.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/cordismain/dash-grey1.png"))); // NOI18N
        dash1Button.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                dash1ButtonMouseExited(evt);
            }
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                dash1ButtonMouseEntered(evt);
            }
        });

        dash2Button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cordismain/dashboard2-btn-wb.png"))); // NOI18N
        dash2Button.setToolTipText("Click to display dashboard 2 details");
        dash2Button.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/cordismain/dash-grey2.png"))); // NOI18N
        dash2Button.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                dash2ButtonMouseExited(evt);
            }
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                dash2ButtonMouseEntered(evt);
            }
        });

        dash3Button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cordismain/dashboard3-btn-wb.png"))); // NOI18N
        dash3Button.setToolTipText("Click to display dashboard 3 details");
        dash3Button.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/cordismain/dash-grey3.png"))); // NOI18N
        dash3Button.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                dash3ButtonMouseExited(evt);
            }
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                dash3ButtonMouseEntered(evt);
            }
        });

        adminButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cordismain/admin-bl.png"))); // NOI18N
        adminButton.setToolTipText("Click to display User details");
        adminButton.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/cordismain/admin-gr.png"))); // NOI18N
        adminButton.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                adminButtonMouseExited(evt);
            }
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                adminButtonMouseEntered(evt);
            }
        });

        userSign.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        userSign.setForeground(new java.awt.Color(202, 204, 208));
        userSign.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        userSign.setText("You are signed in as John Jones");
        userSign.setAlignmentY(0.0F);
        userSign.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        userSign.setIconTextGap(0);
        userSign.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                userSignMouseExited(evt);
            }
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                userSignMouseEntered(evt);
            }
        });

        viewUserButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cordismain/view-bl.png"))); // NOI18N
        viewUserButton.setToolTipText("View usAdmin to browse through and edit User's details");
        viewUserButton.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/cordismain/view-gr.png"))); // NOI18N
        viewUserButton.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                viewUserButtonMouseExited(evt);
            }
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                viewUserButtonMouseEntered(evt);
            }
        });

        editUserButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cordismain/edit-bl.png"))); // NOI18N
        editUserButton.setToolTipText("Edits currently selected user details");
        editUserButton.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/cordismain/edit-gr.png"))); // NOI18N
        editUserButton.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                editUserButtonMouseExited(evt);
            }
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                editUserButtonMouseEntered(evt);
            }
        });

        deleteUserButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cordismain/delete-bl.png"))); // NOI18N
        deleteUserButton.setToolTipText("Deletes a user");
        deleteUserButton.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/cordismain/delete-gr.png"))); // NOI18N
        deleteUserButton.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                deleteUserButtonMouseExited(evt);
            }
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                deleteUserButtonMouseEntered(evt);
            }
        });

        logOutButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cordismain/logout-mix.png"))); // NOI18N
        logOutButton.setToolTipText("Log out of Cordis.");
        logOutButton.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                logOutButtonMouseExited(evt);
            }
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                logOutButtonMouseEntered(evt);
            }
        });

        layerPanel.setBackground(new java.awt.Color(255, 255, 160));
        layerPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        layerPanel.setOpaque(true);
        layerPanel.setPreferredSize(new java.awt.Dimension(972, 498));
        layerPanel.setLayout(new javax.swing.OverlayLayout(layerPanel));

        homePanel.setBackground(new java.awt.Color(255, 255, 160));
        homePanel.setPreferredSize(new java.awt.Dimension(972, 498));

        cordisTextArea.setEditable(false);
        cordisTextArea.setBackground(new java.awt.Color(255, 255, 160));
        cordisTextArea.setColumns(20);
        cordisTextArea.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        cordisTextArea.setRows(15);
        cordisTextArea.setText("The CORDIS Projects repository stores information about research and development projects, financed wholly or partly from \nthe European Union budget. These projects are usually implemented through contractual agreements between the European \nCommission and commercial organizations, research institutes, universities and other bodies. Such projects operate within the \nstructure of a specific Commission programme and are linked to entries in the Programmes repository.The CORDIS Projects \nrepository includes projects dating from the 1980s to the present. Click on individual dashboards to see the data visualised!\n");
        cordisTextArea.setBorder(null);

        cordisLabel1.setFont(new java.awt.Font("Verdana", 1, 52)); // NOI18N
        cordisLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cordisLabel1.setText("Welcome to CORDIS!");
        cordisLabel1.setForeground(Color.BLACK);
        cordisLabel1.setToolTipText("");
        cordisLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        homeChartContainerPanel.setBackground(new java.awt.Color(255, 255, 160));
        homeChartContainerPanel.setLayout(new java.awt.GridLayout());

        homeChartPanel1.setLayout(new java.awt.BorderLayout());
        homeChartContainerPanel.add(homeChartPanel1);

        homeMidPanel.setBackground(new java.awt.Color(255, 255, 160));

        homeNumProjectsLabel.setEditable(false);
        homeNumProjectsLabel.setBackground(new java.awt.Color(255, 255, 160));
        homeNumProjectsLabel.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        homeNumProjectsLabel.setText("Total Number of Projects:");
        homeNumProjectsLabel.setBorder(null);

        homeNumProjects.setEditable(false);
        homeNumProjects.setBackground(new java.awt.Color(255, 255, 160));
        homeNumProjects.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        homeNumProjects.setForeground(new java.awt.Color(0, 0, 178));
        homeNumProjects.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        homeNumProjects.setText("");
        homeNumProjects.setBorder(null);

        homeNumParticipantsLabel.setEditable(false);
        homeNumParticipantsLabel.setBackground(new java.awt.Color(255, 255, 160));
        homeNumParticipantsLabel.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        homeNumParticipantsLabel.setText("Number of Participants:");
        homeNumParticipantsLabel.setBorder(null);

        homeNumParticipants.setEditable(false);
        homeNumParticipants.setBackground(new java.awt.Color(255, 255, 160));
        homeNumParticipants.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        homeNumParticipants.setForeground(new java.awt.Color(0, 0, 178));
        homeNumParticipants.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        homeNumParticipants.setText("");
        homeNumParticipants.setBorder(null);

        homeTotalCostLabel.setEditable(false);
        homeTotalCostLabel.setBackground(new java.awt.Color(255, 255, 160));
        homeTotalCostLabel.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        homeTotalCostLabel.setText("Total Cost of All Projects:");
        homeTotalCostLabel.setBorder(null);

        homeTotalCost.setEditable(false);
        homeTotalCost.setBackground(new java.awt.Color(255, 255, 160));
        homeTotalCost.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        homeTotalCost.setForeground(new java.awt.Color(0, 0, 178));
        homeTotalCost.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        homeTotalCost.setText("");
        homeTotalCost.setBorder(null);

        javax.swing.GroupLayout homeMidPanelLayout = new javax.swing.GroupLayout(homeMidPanel);
        homeMidPanel.setLayout(homeMidPanelLayout);
        homeMidPanelLayout.setHorizontalGroup(
            homeMidPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(homeMidPanelLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(homeMidPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(homeNumProjectsLabel)
                    .addComponent(homeNumParticipantsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(homeNumProjects)
                    .addComponent(homeNumParticipants)
                    .addComponent(homeTotalCost)
                    .addComponent(homeTotalCostLabel))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        homeMidPanelLayout.setVerticalGroup(
            homeMidPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(homeMidPanelLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(homeNumProjectsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(homeNumProjects, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(homeNumParticipantsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(homeNumParticipants, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(homeTotalCostLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(homeTotalCost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(31, Short.MAX_VALUE))
        );

        homeNumProjects.setVisible(true);

        homeChartContainerPanel.add(homeMidPanel);

        homeChartPanel2.setLayout(new java.awt.BorderLayout());
        homeChartContainerPanel.add(homeChartPanel2);

        javax.swing.GroupLayout homePanelLayout = new javax.swing.GroupLayout(homePanel);
        homePanel.setLayout(homePanelLayout);
        homePanelLayout.setHorizontalGroup(
            homePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(homePanelLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(homePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(homeChartContainerPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cordisLabel1)
                    .addComponent(cordisTextArea, javax.swing.GroupLayout.PREFERRED_SIZE, 900, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32))
        );
        homePanelLayout.setVerticalGroup(
            homePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(homePanelLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(cordisLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(cordisTextArea, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(homeChartContainerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(32, Short.MAX_VALUE))
        );

        layerPanel.add(homePanel);

        dashboard1Panel.setBackground(new java.awt.Color(255, 255, 160));
        dashboard1Panel.setToolTipText("");
        dashboard1Panel.setPreferredSize(new java.awt.Dimension(972, 498));

        pnl_tabbed.setBackground(new java.awt.Color(255, 255, 160));
        pnl_tabbed.setToolTipText("");
        pnl_tabbed.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        pnl_tabbed.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        pnl_tabbed.addChangeListener(new javax.swing.event.ChangeListener() {
            @Override
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                pnl_tabbedStateChanged(evt);
            }
        });

        bar_option_panel.setToolTipText("15");
        bar_option_panel.setFocusable(false);
        bar_option_panel.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        bar_option_panel.setMinimumSize(new java.awt.Dimension(142, 142));
        bar_option_panel.setName(""); // NOI18N

        jLabel2.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel2.setText("Display Top 15 Countries");

        countryButton.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        countryButton.setText("Countries");
        countryButton.setAlignmentX(0.5F);
        countryButton.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                countryButtonActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel4.setText("Display Top ");

        jSlider1.setMaximum(15);
        jSlider1.setMinimum(1);
        jSlider1.addChangeListener(new javax.swing.event.ChangeListener() {
            @Override
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSlider1StateChanged(evt);
            }
        });
        jSlider1.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jSlider1MouseReleased(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel5.setText("1");

        jLabel6.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel6.setText("15");

        display_value.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        display_value.setText("15");
        display_value.setMaximumSize(new java.awt.Dimension(25, 25));
        display_value.setMinimumSize(new java.awt.Dimension(25, 25));
        display_value.setName(""); // NOI18N

        javax.swing.GroupLayout bar_option_panelLayout = new javax.swing.GroupLayout(bar_option_panel);
        bar_option_panel.setLayout(bar_option_panelLayout);
        bar_option_panelLayout.setHorizontalGroup(
            bar_option_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bar_option_panelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(bar_option_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(bar_option_panelLayout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(display_value, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 104, Short.MAX_VALUE)
                        .addComponent(jLabel5)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(bar_option_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jSlider1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(countryButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addContainerGap())
        );
        bar_option_panelLayout.setVerticalGroup(
            bar_option_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bar_option_panelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(bar_option_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(countryButton)
                    .addComponent(jLabel2))
                .addGap(27, 27, 27)
                .addGroup(bar_option_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bar_option_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(display_value, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jSlider1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(46, Short.MAX_VALUE))
        );

        pnl_tabbed.addTab("Bar Chart", bar_option_panel);

        jLabel1.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel1.setText("Display Line Graph");

        LineGraphButton.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        LineGraphButton.setText("Years");
        LineGraphButton.setAlignmentX(0.5F);
        LineGraphButton.setMaximumSize(new java.awt.Dimension(95, 25));
        LineGraphButton.setMinimumSize(new java.awt.Dimension(95, 25));
        LineGraphButton.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mousePressed(java.awt.event.MouseEvent evt) {
                LineGraphButtonMousePressed(evt);
            }
        });
        LineGraphButton.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LineGraphButtonActionPerformed(evt);
            }
        });

        jCheck2015.setFont(new java.awt.Font("Verdana", 0, 13)); // NOI18N
        jCheck2015.setSelected(true);
        jCheck2015.setText("2015");
        jCheck2015.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheck2015ActionPerformed(evt);
            }
        });

        jCheck2016.setFont(new java.awt.Font("Verdana", 0, 13)); // NOI18N
        jCheck2016.setSelected(true);
        jCheck2016.setText("2016");
        jCheck2016.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheck2016ActionPerformed(evt);
            }
        });

        jCheck2017.setFont(new java.awt.Font("Verdana", 0, 13)); // NOI18N
        jCheck2017.setSelected(true);
        jCheck2017.setText("2017");
        jCheck2017.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheck2017ActionPerformed(evt);
            }
        });

        jCheck2018.setFont(new java.awt.Font("Verdana", 0, 13)); // NOI18N
        jCheck2018.setSelected(true);
        jCheck2018.setText("2018");
        jCheck2018.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheck2018ActionPerformed(evt);
            }
        });

        jCheck2019.setFont(new java.awt.Font("Verdana", 0, 13)); // NOI18N
        jCheck2019.setSelected(true);
        jCheck2019.setText("2019");
        jCheck2019.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheck2019ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel3.setText("Select Year to Display");

        javax.swing.GroupLayout line_option_panelLayout = new javax.swing.GroupLayout(line_option_panel);
        line_option_panel.setLayout(line_option_panelLayout);
        line_option_panelLayout.setHorizontalGroup(
            line_option_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(line_option_panelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(line_option_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(line_option_panelLayout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, line_option_panelLayout.createSequentialGroup()
                        .addGroup(line_option_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(line_option_panelLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jCheck2015)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCheck2016)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCheck2017)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(line_option_panelLayout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(85, 85, 85)))
                        .addGroup(line_option_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(line_option_panelLayout.createSequentialGroup()
                                .addComponent(jCheck2018)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCheck2019)
                                .addGap(42, 42, 42))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, line_option_panelLayout.createSequentialGroup()
                                .addComponent(LineGraphButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(40, 40, 40))))))
        );
        line_option_panelLayout.setVerticalGroup(
            line_option_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(line_option_panelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(line_option_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(LineGraphButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(line_option_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(line_option_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jCheck2019)
                        .addComponent(jCheck2018))
                    .addGroup(line_option_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jCheck2016)
                        .addComponent(jCheck2017))
                    .addComponent(jCheck2015))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        pnl_tabbed.addTab("Line Chart", line_option_panel);

        pnl_chart.setBackground(new java.awt.Color(255, 255, 160));
        pnl_chart.setLayout(new java.awt.BorderLayout());

        pnl_table.setBackground(new java.awt.Color(255, 255, 160));
        pnl_table.setMaximumSize(new java.awt.Dimension(398, 219));

        jScrollPane4.setBackground(new java.awt.Color(255, 255, 160));

        jTable1.setFont(new java.awt.Font("Verdana", 0, 13)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable1.setEnabled(false);
        jTable1.setMaximumSize(new java.awt.Dimension(330, 64));
        jScrollPane4.setViewportView(jTable1);

        javax.swing.GroupLayout pnl_tableLayout = new javax.swing.GroupLayout(pnl_table);
        pnl_table.setLayout(pnl_tableLayout);
        pnl_tableLayout.setHorizontalGroup(
            pnl_tableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_tableLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 513, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnl_tableLayout.setVerticalGroup(
            pnl_tableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_tableLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout dashboard1PanelLayout = new javax.swing.GroupLayout(dashboard1Panel);
        dashboard1Panel.setLayout(dashboard1PanelLayout);
        dashboard1PanelLayout.setHorizontalGroup(
            dashboard1PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dashboard1PanelLayout.createSequentialGroup()
                .addGroup(dashboard1PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(dashboard1PanelLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(pnl_chart, javax.swing.GroupLayout.PREFERRED_SIZE, 960, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(dashboard1PanelLayout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(pnl_tabbed, javax.swing.GroupLayout.PREFERRED_SIZE, 384, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(pnl_table, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        dashboard1PanelLayout.setVerticalGroup(
            dashboard1PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dashboard1PanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnl_chart, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(dashboard1PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnl_table, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnl_tabbed, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        layerPanel.add(dashboard1Panel);

        dashboard2Panel.setBackground(new java.awt.Color(255, 255, 160));
        dashboard2Panel.setPreferredSize(new java.awt.Dimension(972, 498));
        dashboard2Panel.setRequestFocusEnabled(false);

        dash2ButtonPanel.setBackground(new java.awt.Color(255, 255, 160));

        averageButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cordismain/average-bl.png"))); // NOI18N
        averageButton.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/cordismain/average-gr.png"))); // NOI18N
        averageButton.setEnabled(false);
        averageButton.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                averageButtonMouseExited(evt);
            }
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                averageButtonMouseEntered(evt);
            }
        });

        mostExpensiveButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cordismain/most-exp-bl.png"))); // NOI18N
        mostExpensiveButton.setToolTipText("");
        mostExpensiveButton.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/cordismain/most-exp-gr.png"))); // NOI18N
        mostExpensiveButton.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                mostExpensiveButtonMouseExited(evt);
            }
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                mostExpensiveButtonMouseEntered(evt);
            }
        });

        leastExpensiveButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cordismain/least-exp-bl.png"))); // NOI18N
        leastExpensiveButton.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/cordismain/least-exp-gr.png"))); // NOI18N
        leastExpensiveButton.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                leastExpensiveButtonMouseExited(evt);
            }
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                leastExpensiveButtonMouseEntered(evt);
            }
        });

        searchMenuButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cordismain/search-bl.png"))); // NOI18N
        searchMenuButton.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/cordismain/search-gr.png"))); // NOI18N
        searchMenuButton.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                searchMenuButtonMouseExited(evt);
            }
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                searchMenuButtonMouseEntered(evt);
            }
        });

        javax.swing.GroupLayout dash2ButtonPanelLayout = new javax.swing.GroupLayout(dash2ButtonPanel);
        dash2ButtonPanel.setLayout(dash2ButtonPanelLayout);
        dash2ButtonPanelLayout.setHorizontalGroup(
            dash2ButtonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dash2ButtonPanelLayout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(averageButton)
                .addGap(78, 78, 78)
                .addComponent(mostExpensiveButton)
                .addGap(78, 78, 78)
                .addComponent(leastExpensiveButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(searchMenuButton)
                .addGap(62, 62, 62))
        );
        dash2ButtonPanelLayout.setVerticalGroup(
            dash2ButtonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dash2ButtonPanelLayout.createSequentialGroup()
                .addGap(0, 12, Short.MAX_VALUE)
                .addGroup(dash2ButtonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(searchMenuButton)
                    .addComponent(leastExpensiveButton)
                    .addComponent(mostExpensiveButton)
                    .addComponent(averageButton)))
        );

        dash2DataPanel.setLayout(new javax.swing.OverlayLayout(dash2DataPanel));

        d2Chart1.setLayout(new java.awt.BorderLayout());
        dash2DataPanel.add(d2Chart1);

        d2Chart2.setLayout(new java.awt.BorderLayout());
        dash2DataPanel.add(d2Chart2);

        d2Chart3.setLayout(new java.awt.BorderLayout());
        dash2DataPanel.add(d2Chart3);

        d2SearchPanel.setBackground(new java.awt.Color(255, 255, 160));

        searchTitleLabel.setFont(new java.awt.Font("Verdana", 0, 24)); // NOI18N
        searchTitleLabel.setText("Search for a country to check project information");
        searchTitleLabel.setToolTipText("");

        searchPanel.setBackground(new java.awt.Color(156, 195, 213));
        searchPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        searchPanel.setVisible(false);

        d2Countrytext.setEditable(false);
        d2Countrytext.setBackground(new java.awt.Color(202, 204, 208));
        d2Countrytext.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        d2Countrytext.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        d2Countrytext.setFocusable(false);
        d2Countrytext.setRequestFocusEnabled(false);

        d2SearchMost.setEditable(false);
        d2SearchMost.setBackground(new java.awt.Color(202, 204, 208));
        d2SearchMost.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        d2SearchMost.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        d2SearchMost.setFocusable(false);

        jLabel7.setFont(new java.awt.Font("Verdana", 0, 13)); // NOI18N
        jLabel7.setText("Country ");

        mostExpProjCost.setFont(new java.awt.Font("Verdana", 0, 13)); // NOI18N
        mostExpProjCost.setText("Most expensive project cost (€)");

        SearchButton.setBackground(new java.awt.Color(156, 195, 213));
        SearchButton.setFont(new java.awt.Font("Verdana", 0, 13)); // NOI18N
        SearchButton.setText("SEARCH");

        SearchText.setBackground(new java.awt.Color(202, 204, 208));
        SearchText.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        SearchText.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        leastExpProjCost.setFont(new java.awt.Font("Verdana", 0, 13)); // NOI18N
        leastExpProjCost.setText("Least Expensive project cost (€)");

        d2SearchLeast.setEditable(false);
        d2SearchLeast.setBackground(new java.awt.Color(202, 204, 208));
        d2SearchLeast.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        d2SearchLeast.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        d2SearchLeast.setFocusable(false);

        d2SearchAverage.setEditable(false);
        d2SearchAverage.setBackground(new java.awt.Color(202, 204, 208));
        d2SearchAverage.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        d2SearchAverage.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        d2SearchAverage.setFocusable(false);

        avgProjCosts.setFont(new java.awt.Font("Verdana", 0, 13)); // NOI18N
        avgProjCosts.setText("Average projects costs");

        d2expensiveCity.setEditable(false);
        d2expensiveCity.setBackground(new java.awt.Color(202, 204, 208));
        d2expensiveCity.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        d2expensiveCity.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        d2expensiveCity.setFocusable(false);

        d2LeastCity.setEditable(false);
        d2LeastCity.setBackground(new java.awt.Color(202, 204, 208));
        d2LeastCity.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        d2LeastCity.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        d2LeastCity.setFocusable(false);

        cityLabel.setFont(new java.awt.Font("Verdana", 0, 13)); // NOI18N
        cityLabel.setText("City");

        d2Mproject.setEditable(false);
        d2Mproject.setBackground(new java.awt.Color(202, 204, 208));
        d2Mproject.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        d2Mproject.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        d2Mproject.setFocusable(false);

        d2Lproject.setEditable(false);
        d2Lproject.setBackground(new java.awt.Color(202, 204, 208));
        d2Lproject.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        d2Lproject.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        d2Lproject.setFocusable(false);

        projectIDLabel.setFont(new java.awt.Font("Verdana", 0, 13)); // NOI18N
        projectIDLabel.setText("ProjectID");

        javax.swing.GroupLayout searchPanelLayout = new javax.swing.GroupLayout(searchPanel);
        searchPanel.setLayout(searchPanelLayout);
        searchPanelLayout.setHorizontalGroup(
            searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(searchPanelLayout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(mostExpProjCost)
                    .addComponent(leastExpProjCost)
                    .addComponent(jLabel8)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(avgProjCosts, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SearchText, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(searchPanelLayout.createSequentialGroup()
                        .addComponent(SearchButton)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(searchPanelLayout.createSequentialGroup()
                        .addGroup(searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(d2Countrytext, javax.swing.GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
                            .addComponent(d2SearchAverage, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(d2SearchLeast, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(d2SearchMost))
                        .addGap(49, 49, 49)
                        .addGroup(searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(d2Mproject)
                                .addComponent(d2Lproject, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(projectIDLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                        .addGroup(searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(d2expensiveCity)
                                .addComponent(d2LeastCity, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(cityLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(13, 13, 13))))
        );
        searchPanelLayout.setVerticalGroup(
            searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(searchPanelLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SearchButton)
                    .addComponent(SearchText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(d2Countrytext, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cityLabel)
                    .addComponent(projectIDLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(searchPanelLayout.createSequentialGroup()
                        .addGroup(searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(searchPanelLayout.createSequentialGroup()
                                .addGroup(searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(d2SearchMost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(mostExpProjCost))
                                .addGap(18, 18, 18)
                                .addGroup(searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(leastExpProjCost)
                                    .addComponent(d2SearchLeast, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(20, 20, 20))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, searchPanelLayout.createSequentialGroup()
                                .addComponent(d2Mproject, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(d2Lproject, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)))
                        .addGroup(searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(d2SearchAverage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)
                            .addComponent(avgProjCosts)))
                    .addGroup(searchPanelLayout.createSequentialGroup()
                        .addComponent(d2expensiveCity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(d2LeastCity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(35, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout d2SearchPanelLayout = new javax.swing.GroupLayout(d2SearchPanel);
        d2SearchPanel.setLayout(d2SearchPanelLayout);
        d2SearchPanelLayout.setHorizontalGroup(
            d2SearchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(d2SearchPanelLayout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(searchPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(62, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, d2SearchPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(searchTitleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 606, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(176, 176, 176))
        );
        d2SearchPanelLayout.setVerticalGroup(
            d2SearchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(d2SearchPanelLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(searchTitleLabel)
                .addGap(18, 18, 18)
                .addComponent(searchPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        dash2DataPanel.add(d2SearchPanel);

        javax.swing.GroupLayout dashboard2PanelLayout = new javax.swing.GroupLayout(dashboard2Panel);
        dashboard2Panel.setLayout(dashboard2PanelLayout);
        dashboard2PanelLayout.setHorizontalGroup(
            dashboard2PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dashboard2PanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(dashboard2PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dash2DataPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(dash2ButtonPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        dashboard2PanelLayout.setVerticalGroup(
            dashboard2PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dashboard2PanelLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(dash2DataPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(dash2ButtonPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12))
        );

        layerPanel.add(dashboard2Panel);

        dashboard3Panel.setBackground(new java.awt.Color(255, 255, 160));
        dashboard3Panel.setPreferredSize(new java.awt.Dimension(972, 498));

        dashboard3Label.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        dashboard3Label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        dashboard3Label.setText("Contributions of Organisations:");

        d3Tabs.setBackground(new java.awt.Color(255, 255, 160));
        d3Tabs.setFont(new java.awt.Font("Verdana", 0, 13)); // NOI18N

        maxContributors.setBackground(new java.awt.Color(255, 255, 160));

        d3MaxPiePanel.setBackground(new java.awt.Color(255, 255, 160));
        d3MaxPiePanel.setLayout(new java.awt.BorderLayout());

        d3MaxBarPanel.setBackground(new java.awt.Color(255, 255, 160));
        d3MaxBarPanel.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout maxContributorsLayout = new javax.swing.GroupLayout(maxContributors);
        maxContributors.setLayout(maxContributorsLayout);
        maxContributorsLayout.setHorizontalGroup(
            maxContributorsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(maxContributorsLayout.createSequentialGroup()
                .addComponent(d3MaxPiePanel, javax.swing.GroupLayout.PREFERRED_SIZE, 472, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(d3MaxBarPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 472, Short.MAX_VALUE))
        );
        maxContributorsLayout.setVerticalGroup(
            maxContributorsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(d3MaxPiePanel, javax.swing.GroupLayout.DEFAULT_SIZE, 408, Short.MAX_VALUE)
            .addComponent(d3MaxBarPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        d3Tabs.addTab("MAX", maxContributors);

        minContributors.setBackground(new java.awt.Color(255, 255, 160));

        d3MinPiePanel.setBackground(new java.awt.Color(255, 255, 160));
        d3MinPiePanel.setLayout(new java.awt.BorderLayout());

        d3MinBarPanel.setBackground(new java.awt.Color(255, 255, 160));
        d3MinBarPanel.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout minContributorsLayout = new javax.swing.GroupLayout(minContributors);
        minContributors.setLayout(minContributorsLayout);
        minContributorsLayout.setHorizontalGroup(
            minContributorsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(minContributorsLayout.createSequentialGroup()
                .addComponent(d3MinPiePanel, javax.swing.GroupLayout.PREFERRED_SIZE, 472, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(d3MinBarPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 472, Short.MAX_VALUE))
        );
        minContributorsLayout.setVerticalGroup(
            minContributorsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(d3MinBarPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 408, Short.MAX_VALUE)
            .addComponent(d3MinPiePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        d3Tabs.addTab("MIN", minContributors);

        javax.swing.GroupLayout dashboard3PanelLayout = new javax.swing.GroupLayout(dashboard3Panel);
        dashboard3Panel.setLayout(dashboard3PanelLayout);
        dashboard3PanelLayout.setHorizontalGroup(
            dashboard3PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(dashboard3Label, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(dashboard3PanelLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(d3Tabs, javax.swing.GroupLayout.PREFERRED_SIZE, 946, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );
        dashboard3PanelLayout.setVerticalGroup(
            dashboard3PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dashboard3PanelLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(dashboard3Label)
                .addGap(1, 1, 1)
                .addComponent(d3Tabs, javax.swing.GroupLayout.PREFERRED_SIZE, 433, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        layerPanel.add(dashboard3Panel);

        adminPanel.setBackground(new java.awt.Color(255, 255, 160));
        adminPanel.setPreferredSize(new java.awt.Dimension(972, 498));

        adminLabel.setFont(new java.awt.Font("Verdana", 1, 36)); // NOI18N
        adminLabel.setForeground(new java.awt.Color(0, 0, 0));
        adminLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        adminLabel.setText("USER LIST");

        buttonPanel.setOpaque(false);
        buttonPanel.setLayout(new javax.swing.OverlayLayout(buttonPanel));

        buttons2.setOpaque(false);

        cancelButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cordismain/cancel-btn-bl.png"))); // NOI18N
        cancelButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                cancelButton1MouseExited(evt);
            }
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                cancelButton1MouseEntered(evt);
            }
        });

        javax.swing.GroupLayout buttons2Layout = new javax.swing.GroupLayout(buttons2);
        buttons2.setLayout(buttons2Layout);
        buttons2Layout.setHorizontalGroup(
            buttons2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(buttons2Layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addComponent(cancelButton1)
                .addContainerGap(63, Short.MAX_VALUE))
        );
        buttons2Layout.setVerticalGroup(
            buttons2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(buttons2Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(cancelButton1)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        cancelButton1.setVisible(false);

        buttonPanel.add(buttons2);

        buttons1.setOpaque(false);

        cancelButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cordismain/cancel-btn-bl.png"))); // NOI18N
        cancelButton.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                cancelButtonMouseExited(evt);
            }
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                cancelButtonMouseEntered(evt);
            }
        });

        okButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cordismain/confirm-btn-bl.png"))); // NOI18N
        okButton.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                okButtonMouseExited(evt);
            }
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                okButtonMouseEntered(evt);
            }
        });
        okButton.setVisible(false);

        javax.swing.GroupLayout buttons1Layout = new javax.swing.GroupLayout(buttons1);
        buttons1.setLayout(buttons1Layout);
        buttons1Layout.setHorizontalGroup(
            buttons1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(buttons1Layout.createSequentialGroup()
                .addComponent(okButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addComponent(cancelButton))
        );
        buttons1Layout.setVerticalGroup(
            buttons1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(buttons1Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(buttons1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cancelButton)
                    .addComponent(okButton))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        cancelButton.setVisible(false);

        buttonPanel.add(buttons1);

        tableContainer.setLayout(new javax.swing.OverlayLayout(tableContainer));

        table2Panel.setBackground(new java.awt.Color(255, 255, 160));

        jScrollPane2.setBackground(new java.awt.Color(0, 99, 178));
        jScrollPane2.setBorder(BorderFactory.createEmptyBorder());
        jScrollPane2.setForeground(new java.awt.Color(156, 195, 213));
        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane2.setWheelScrollingEnabled(true);
        Border border2 = new LineBorder(new Color(0,99,178), 4, true);
        jScrollPane2.setBorder(border2);

        sessionTable.setAutoCreateRowSorter(true);
        sessionTable.setBackground(new java.awt.Color(156, 195, 213));
        sessionTable.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        sessionModel = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex){
                return editable;
            }
            @Override
            public Class<?> getColumnClass(int column) {

                switch (column) {

                    case 0:

                    return Integer.class;
                    case 1:

                    return String.class;

                    case 2:

                    return String.class;

                    default:
                    return String.class;
                }

            }
        };
        sessionTable.setModel(sessionModel);
        sessionTable.setFillsViewportHeight(true);
        sessionTable.setGridColor(new java.awt.Color(0, 99, 178));
        sessionTable.setRowHeight(40);
        sessionTable.setSelectionBackground(new java.awt.Color(202, 204, 208));
        sessionTable.setSelectionForeground(new java.awt.Color(0, 0, 0));
        jScrollPane2.setViewportView(sessionTable);
        sessionTable.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        sessionTable.getTableHeader().setBackground(new java.awt.Color(0, 99, 178));
        sessionTable.setBorder(BorderFactory.createEmptyBorder());

        JTableHeader header2= sessionTable.getTableHeader();

        header2.setForeground(new Color(255,255,160));
        header2.setFont(new Font("Helvetica Neue", Font.PLAIN, 20));
        //Font font = UIManager.getFont("TableHeader.font");
        //font = font.deriveFont(30f);
        //UIManager.put("TableHeader.font", font);
        ((DefaultTableCellRenderer)header2.getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);

        jScrollPane3.setBackground(new java.awt.Color(0, 99, 178));
        jScrollPane3.setBorder(BorderFactory.createEmptyBorder());
        jScrollPane3.setForeground(new java.awt.Color(156, 195, 213));
        jScrollPane3.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane3.setWheelScrollingEnabled(true);
        Border border3 = new LineBorder(new Color(0,99,178), 4, true);
        jScrollPane3.setBorder(border3);

        detailsTable.setAutoCreateRowSorter(true);
        detailsTable.setBackground(new java.awt.Color(156, 195, 213));
        detailsTable.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        detailsModel = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex){
                return editable;
            }
            @Override
            public Class<?> getColumnClass(int column) {

                switch (column) {

                    case 0:

                    return Integer.class;
                    case 1:

                    return String.class;

                    case 2:

                    return String.class;

                    default:
                    return String.class;
                }

            }
        };
        detailsTable.setModel(detailsModel);
        detailsTable.setFillsViewportHeight(true);
        detailsTable.setGridColor(new java.awt.Color(0, 99, 178));
        detailsTable.setRowHeight(40);
        detailsTable.setSelectionBackground(new java.awt.Color(202, 204, 208));
        detailsTable.setSelectionForeground(new java.awt.Color(0, 0, 0));
        jScrollPane3.setViewportView(detailsTable);
        detailsTable.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        detailsTable.getTableHeader().setBackground(new java.awt.Color(0, 99, 178));
        detailsTable.setBorder(BorderFactory.createEmptyBorder());

        JTableHeader header3= detailsTable.getTableHeader();

        header3.setForeground(new Color(255,255,160));
        header3.setFont(new Font("Helvetica Neue", Font.PLAIN, 20));
        
        ((DefaultTableCellRenderer)header3.getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);

        javax.swing.GroupLayout table2PanelLayout = new javax.swing.GroupLayout(table2Panel);
        table2Panel.setLayout(table2PanelLayout);
        table2PanelLayout.setHorizontalGroup(
            table2PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, table2PanelLayout.createSequentialGroup()
                .addContainerGap(463, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 428, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(table2PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(table2PanelLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 428, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(463, Short.MAX_VALUE)))
        );
        table2PanelLayout.setVerticalGroup(
            table2PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE)
            .addGroup(table2PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE))
        );

        //UIManager.put("ScrollBar.thumb", new ColorUIResource(Color.RED));
        //jScrollPane1.getVerticalScrollBar().setUI(new BasicScrollBarUI(){
            //
            //} );
    //jScrollPane1.getHorizontalScrollBar().setUI(new BasicScrollBarUI());
    //jScrollPane1.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
    //jScrollPane1.getVerticalScrollBar().getModel().setValue(10);
    //UIManager.put("ScrollBar.thumb", new ColorUIResource(Color.RED));
    //jScrollPane1.getVerticalScrollBar().setUI(new BasicScrollBarUI(){
        //
        //} );
//jScrollPane1.getHorizontalScrollBar().setUI(new BasicScrollBarUI());
//jScrollPane1.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
//jScrollPane1.getVerticalScrollBar().getModel().setValue(10);

tableContainer.add(table2Panel);

table1Panel.setBackground(new java.awt.Color(255, 255, 160));

jScrollPane1.setBackground(new java.awt.Color(0, 99, 178));
jScrollPane1.setBorder(BorderFactory.createEmptyBorder());
jScrollPane1.setForeground(new java.awt.Color(156, 195, 213));
jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
jScrollPane1.setWheelScrollingEnabled(true);
Border border = new LineBorder(new Color(0,99,178), 4, true);
jScrollPane1.setBorder(border);

userListTable.setAutoCreateRowSorter(true);
userListTable.setBackground(new java.awt.Color(156, 195, 213));
userListTable.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
userModel = new DefaultTableModel() {
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex){
        return editable;
    }
    @Override
    public Class<?> getColumnClass(int column) {

        switch (column) {

            case 0:

            return String.class;
            case 1:

            return String.class;

            case 2:

            return String.class;
            case 3:

            return String.class;

            case 4:

            return String.class;

            case 5:

            return Boolean.class;
            default:
            return String.class;
        }

    }
    };
    userListTable.setModel(userModel);
    userListTable.setFillsViewportHeight(true);
    userListTable.setGridColor(new java.awt.Color(0, 99, 178));
    userListTable.setRowHeight(40);
    userListTable.setSelectionBackground(new java.awt.Color(202, 204, 208));
    userListTable.setSelectionForeground(new java.awt.Color(0, 0, 0));
    jScrollPane1.setViewportView(userListTable);
    userListTable.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
    userListTable.getTableHeader().setBackground(new java.awt.Color(0, 99, 178));
    userListTable.setBorder(BorderFactory.createEmptyBorder());

    JTableHeader header= userListTable.getTableHeader();

    header.setForeground(new Color(255,255,160));
    header.setFont(new Font("Helvetica Neue", Font.PLAIN, 20));
    //Font font = UIManager.getFont("TableHeader.font");
    //font = font.deriveFont(30f);
    //UIManager.put("TableHeader.font", font);
    ((DefaultTableCellRenderer)header.getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);
    jScrollPane1.getViewport().setBackground(Color.RED);

    javax.swing.GroupLayout table1PanelLayout = new javax.swing.GroupLayout(table1Panel);
    table1Panel.setLayout(table1PanelLayout);
    table1PanelLayout.setHorizontalGroup(
        table1PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGap(0, 897, Short.MAX_VALUE)
        .addGroup(table1PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(table1PanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 885, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
    );
    table1PanelLayout.setVerticalGroup(
        table1PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGap(0, 388, Short.MAX_VALUE)
        .addGroup(table1PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE))
    );
   

tableContainer.add(table1Panel);

javax.swing.GroupLayout adminPanelLayout = new javax.swing.GroupLayout(adminPanel);
adminPanel.setLayout(adminPanelLayout);
adminPanelLayout.setHorizontalGroup(
    adminPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
    .addComponent(adminLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 970, Short.MAX_VALUE)
    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, adminPanelLayout.createSequentialGroup()
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addComponent(buttonPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(375, 375, 375))
    .addGroup(adminPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(adminPanelLayout.createSequentialGroup()
            .addGap(37, 37, 37)
            .addComponent(tableContainer, javax.swing.GroupLayout.PREFERRED_SIZE, 897, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(36, Short.MAX_VALUE)))
    );
    adminPanelLayout.setVerticalGroup(
        adminPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(adminPanelLayout.createSequentialGroup()
            .addContainerGap()
            .addComponent(adminLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 401, Short.MAX_VALUE)
            .addComponent(buttonPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap())
        .addGroup(adminPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, adminPanelLayout.createSequentialGroup()
                .addContainerGap(64, Short.MAX_VALUE)
                .addComponent(tableContainer, javax.swing.GroupLayout.PREFERRED_SIZE, 388, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)))
    );

    layerPanel.add(adminPanel);

    javax.swing.GroupLayout backgroundPanelLayout = new javax.swing.GroupLayout(backgroundPanel);
    backgroundPanel.setLayout(backgroundPanelLayout);
    backgroundPanelLayout.setHorizontalGroup(
        backgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(backgroundPanelLayout.createSequentialGroup()
            .addGap(26, 26, 26)
            .addGroup(backgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                .addGroup(backgroundPanelLayout.createSequentialGroup()
                    .addComponent(imageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(cordisLabel)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(viewUserButton)
                    .addGap(18, 18, 18)
                    .addComponent(editUserButton)
                    .addGap(18, 18, 18)
                    .addComponent(deleteUserButton)
                    .addGap(18, 18, 18)
                    .addComponent(logOutButton))
                .addGroup(backgroundPanelLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(userSign, javax.swing.GroupLayout.PREFERRED_SIZE, 972, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(backgroundPanelLayout.createSequentialGroup()
                    .addGroup(backgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(backgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dash1Button, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(adminButton)
                            .addComponent(dash3Button))
                        .addComponent(dash2Button, javax.swing.GroupLayout.Alignment.LEADING))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                    .addComponent(layerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addContainerGap(26, Short.MAX_VALUE))
    );
    backgroundPanelLayout.setVerticalGroup(
        backgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(backgroundPanelLayout.createSequentialGroup()
            .addGap(26, 26, 26)
            .addGroup(backgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(backgroundPanelLayout.createSequentialGroup()
                    .addComponent(imageLabel)
                    .addGap(26, 26, 26)
                    .addComponent(dash1Button)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(dash2Button)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(dash3Button)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(adminButton))
                .addGroup(backgroundPanelLayout.createSequentialGroup()
                    .addGap(61, 61, 61)
                    .addGroup(backgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(cordisLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(editUserButton)
                        .addComponent(viewUserButton)
                        .addComponent(deleteUserButton)
                        .addComponent(logOutButton))
                    .addGap(26, 26, 26)
                    .addComponent(layerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(userSign)
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(backgroundPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );
    layout.setVerticalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(backgroundPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );

    pack();
    }// end initComponents();                        

    /**
     * Event handlers:
     * <p>
     */
    private void dash1ButtonMouseEntered(java.awt.event.MouseEvent evt) {                                         

        dash1Button.setIcon(new ImageIcon(getClass().getResource("dash-grey1.png")));

    }                                        

    private void dash1ButtonMouseExited(java.awt.event.MouseEvent evt) {                                        

        dash1Button.setIcon(new ImageIcon(getClass().getResource("dashboard1-btn-wb.png")));

    }                                       

    private void dash2ButtonMouseEntered(java.awt.event.MouseEvent evt) {                                         

        dash2Button.setIcon(new ImageIcon(getClass().getResource("dash-grey2.png")));

    }                                        

    private void dash2ButtonMouseExited(java.awt.event.MouseEvent evt) {                                        

        dash2Button.setIcon(new ImageIcon(getClass().getResource("dashboard2-btn-wb.png")));

    }                                       

    private void dash3ButtonMouseEntered(java.awt.event.MouseEvent evt) {                                         

        dash3Button.setIcon(new ImageIcon(getClass().getResource("dash-grey3.png")));

    }                                        

    private void dash3ButtonMouseExited(java.awt.event.MouseEvent evt) {                                        

        dash3Button.setIcon(new ImageIcon(getClass().getResource("dashboard3-btn-wb.png")));

    }                                       

    private void userSignMouseEntered(java.awt.event.MouseEvent evt) {                                      

        userSign.setForeground(new Color(255, 255, 255));

    }                                     

    private void userSignMouseExited(java.awt.event.MouseEvent evt) {                                     

        userSign.setForeground(new Color(202, 204, 208));

    }                                    

    private void logOutButtonMouseEntered(java.awt.event.MouseEvent evt) {                                          

        logOutButton.setIcon(new ImageIcon(getClass().getResource("logout-gr.png")));

    }                                         

    private void logOutButtonMouseExited(java.awt.event.MouseEvent evt) {                                         

        logOutButton.setIcon(new ImageIcon(getClass().getResource("logout-mix.png")));

    }                                        

    private void adminButtonMouseExited(java.awt.event.MouseEvent evt) {                                        

        adminButton.setIcon(new ImageIcon(getClass().getResource("admin-bl.png")));

    }                                       

    private void adminButtonMouseEntered(java.awt.event.MouseEvent evt) {                                         

        adminButton.setIcon(new ImageIcon(getClass().getResource("admin-gr.png")));

    }                                        

    private void viewUserButtonMouseExited(java.awt.event.MouseEvent evt) {                                           

        viewUserButton.setIcon(new ImageIcon(getClass().getResource("view-bl.png")));

    }                                          

    private void viewUserButtonMouseEntered(java.awt.event.MouseEvent evt) {                                            

        viewUserButton.setIcon(new ImageIcon(getClass().getResource("view-gr.png")));

    }                                           

    private void editUserButtonMouseExited(java.awt.event.MouseEvent evt) {                                           

        editUserButton.setIcon(new ImageIcon(getClass().getResource("edit-bl.png")));

    }                                          

    private void editUserButtonMouseEntered(java.awt.event.MouseEvent evt) {                                            

        editUserButton.setIcon(new ImageIcon(getClass().getResource("edit-gr.png")));

    }                                           

    private void deleteUserButtonMouseExited(java.awt.event.MouseEvent evt) {                                             

        deleteUserButton.setIcon(new ImageIcon(getClass().getResource("delete-bl.png")));

    }                                            

    private void deleteUserButtonMouseEntered(java.awt.event.MouseEvent evt) {                                              

        deleteUserButton.setIcon(new ImageIcon(getClass().getResource("delete-gr.png")));

    }                                             

    private void okButtonMouseEntered(java.awt.event.MouseEvent evt) {                                      

        okButton.setIcon(new ImageIcon(getClass().getResource("confirm-btn-w.png")));

    }                                     

    private void okButtonMouseExited(java.awt.event.MouseEvent evt) {                                     

        okButton.setIcon(new ImageIcon(getClass().getResource("confirm-btn-bl.png")));

    }                                    

    private void cancelButtonMouseEntered(java.awt.event.MouseEvent evt) {                                          

        cancelButton.setIcon(new ImageIcon(getClass().getResource("cancel-btn-w.png")));

    }                                         

    private void cancelButtonMouseExited(java.awt.event.MouseEvent evt) {                                         

        cancelButton.setIcon(new ImageIcon(getClass().getResource("cancel-btn-bl.png")));

    }                                        

    private void cancelButton1MouseExited(java.awt.event.MouseEvent evt) {                                          

        cancelButton1.setIcon(new ImageIcon(getClass().getResource("cancel-btn-bl.png")));

    }                                         

    private void cancelButton1MouseEntered(java.awt.event.MouseEvent evt) {                                           

        cancelButton1.setIcon(new ImageIcon(getClass().getResource("cancel-btn-w.png")));

    }                                          

    private void countryButtonActionPerformed(java.awt.event.ActionEvent evt) {                                              
        int displayTop15 = 15;
        createBarChart(displayTop15);
    }                                             

    private void jSlider1StateChanged(javax.swing.event.ChangeEvent evt) {                                      
        int amountSelected = jSlider1.getValue();
        display_value.setText(Integer.toString(amountSelected));
    }                                     

    private void jSlider1MouseReleased(java.awt.event.MouseEvent evt) {                                       
        int amountSelected = jSlider1.getValue();
        createBarChart(amountSelected);
    }                                      

    private void LineGraphButtonMousePressed(java.awt.event.MouseEvent evt) {                                             
        // TODO add your handling code here:
    }                                            

    private void LineGraphButtonActionPerformed(java.awt.event.ActionEvent evt) {                                                

        //Create First Graph here - > project cost / years
        basicLineGraph(queryList);
    }                                               

    private void jCheck2015ActionPerformed(java.awt.event.ActionEvent evt) {                                           

        if (!jCheck2015.isSelected()) {
            int toRemove = findYearToRemove("2015");
            //            System.out.println("Remove: " + toRemove);
            barChartArray.remove(toRemove);

        } else if (jCheck2015.isSelected()) {
            barChartArray.add(queryList.get(0));
            Collections.sort(barChartArray);           
        }
        basicLineGraph(barChartArray);
    }                                          

    private void jCheck2016ActionPerformed(java.awt.event.ActionEvent evt) {                                           

        if (!jCheck2016.isSelected()) {
            int toRemove = findYearToRemove("2016");
            barChartArray.remove(toRemove);
        } else if (jCheck2016.isSelected()) {
            barChartArray.add(queryList.get(1));
            Collections.sort(barChartArray);
            //            System.out.println("Arr " + testQueryList.toString());
        }
        basicLineGraph(barChartArray);
    }                                          

    private void jCheck2017ActionPerformed(java.awt.event.ActionEvent evt) {                                           

        if (!jCheck2017.isSelected()) {
            int toRemove = findYearToRemove("2017");
            //            System.out.println("Remove: " + toRemove);
            barChartArray.remove(toRemove);
        } else if (jCheck2017.isSelected()) {
            barChartArray.add(queryList.get(2));
            Collections.sort(barChartArray);
            //            System.out.println("Arr " + testQueryList.toString());
        }
        basicLineGraph(barChartArray);
    }                                          

    private void jCheck2018ActionPerformed(java.awt.event.ActionEvent evt) {                                           

        if (!jCheck2018.isSelected()) {
            int toRemove = findYearToRemove("2018");
            //            System.out.println("Remove: " + toRemove);
            barChartArray.remove(toRemove);
        } else if (jCheck2018.isSelected()) {
            barChartArray.add(queryList.get(3));
            Collections.sort(barChartArray);
            //            System.out.println("Arr " + testQueryList.toString());
        }
        basicLineGraph(barChartArray);
    }                                          

    private void jCheck2019ActionPerformed(java.awt.event.ActionEvent evt) {                                           
        if (!jCheck2019.isSelected()) {
            int toRemove = findYearToRemove("2019");
            //            System.out.println("Remove: " + toRemove);
            barChartArray.remove(toRemove);
        } else if (jCheck2019.isSelected()) {
            barChartArray.add(queryList.get(4));
            Collections.sort(barChartArray);
            //            System.out.println("Arr " + testQueryList.toString());
        }
        basicLineGraph(barChartArray);
    }                                          

    private void pnl_tabbedStateChanged(javax.swing.event.ChangeEvent evt) {                                        
        if (pnl_tabbed.getSelectedIndex() == 0) {
            int top15 = 15;
            createBarChart(top15);
        } else if (pnl_tabbed.getSelectedIndex() == 1) {
            basicLineGraph(queryList);
        }
    }                                       

    private void averageButtonMouseExited(java.awt.event.MouseEvent evt) {                                          
        averageButton.setIcon(new ImageIcon(getClass().getResource("average-bl.png")));
    }                                         

    private void averageButtonMouseEntered(java.awt.event.MouseEvent evt) {                                           
        averageButton.setIcon(new ImageIcon(getClass().getResource("average-gr.png")));
    }                                          

    private void mostExpensiveButtonMouseExited(java.awt.event.MouseEvent evt) {                                                
        mostExpensiveButton.setIcon(new ImageIcon(getClass().getResource("most-exp-bl.png")));
    }                                               

    private void mostExpensiveButtonMouseEntered(java.awt.event.MouseEvent evt) {                                                 
        mostExpensiveButton.setIcon(new ImageIcon(getClass().getResource("most-exp-gr.png")));
    }                                                

    private void leastExpensiveButtonMouseExited(java.awt.event.MouseEvent evt) {                                                 
        leastExpensiveButton.setIcon(new ImageIcon(getClass().getResource("least-exp-bl.png")));
    }                                                

    private void leastExpensiveButtonMouseEntered(java.awt.event.MouseEvent evt) {                                                  
        leastExpensiveButton.setIcon(new ImageIcon(getClass().getResource("least-exp-gr.png")));
    }                                                 

    private void searchMenuButtonMouseExited(java.awt.event.MouseEvent evt) {                                             

        searchMenuButton.setIcon(new ImageIcon(getClass().getResource("search-bl.png")));
    }                                            

    private void searchMenuButtonMouseEntered(java.awt.event.MouseEvent evt) {                                              
        searchMenuButton.setIcon(new ImageIcon(getClass().getResource("search-gr.png")));
    }                                             


    // Variables declaration                     

    private javax.swing.JLabel adminButton;
    private javax.swing.JLabel adminLabel;
    private javax.swing.JPanel adminPanel;
    private javax.swing.JPanel buttonPanel;
    private javax.swing.JPanel buttons1;
    private javax.swing.JPanel buttons2;
    private javax.swing.JLabel cancelButton;
    private javax.swing.JLabel cancelButton1;
    private javax.swing.JLabel deleteUserButton;
    private javax.swing.JTable detailsTable;
    private javax.swing.JLabel editUserButton;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
//    private javax.swing.JLabel logOutButton;
    private javax.swing.JLabel okButton;
    private javax.swing.JTable sessionTable;
    private javax.swing.JPanel table1Panel;
    private javax.swing.JPanel table2Panel;
    private javax.swing.JPanel tableContainer;
    private javax.swing.JTable userListTable;
//    private javax.swing.JLabel userSign;
    private javax.swing.JLabel viewUserButton;
    
    private DefaultTableModel userModel;
    private DefaultTableModel sessionModel;
    private DefaultTableModel detailsModel;
    private boolean editable;
    private MessageWindow messageWindow;

    /**
     * Method that sets up Details Table headers
     *
     * @param tableHeader {ArrayList carrying values for column headers}
     */
    public void setUpTableDetails(ArrayList<String> tableHeader) {

        for (int i = 0; i < tableHeader.size(); i++) {

            detailsModel.addColumn(tableHeader.get(i));

        }

    }

    /**
     * Method that sets up rows for Details Table.
     *
     * @param dataUsage {ArrayList holding values of user's usage details}
     */
    public void setUpRowsDetails(ArrayList<DataUsage> dataUsage) {

        for (int i = 0; i < dataUsage.size(); i++) {
            detailsModel.addRow(new Object[0]);
            detailsModel.setValueAt(dataUsage.get(i).getLogId(), i, 0);
            detailsModel.setValueAt(dataUsage.get(i).getActivityName(), i, 1);
            detailsModel.setValueAt(dataUsage.get(i).getTimeStamp(), i, 2);
        }

    }

    /**
     * Method that sets up column headers for Session Table.
     *
     * @param tableHeader {ArrayList holding values for column headers}
     */
    public void setUpTableSession(ArrayList<String> tableHeader) {

        for (int i = 0; i < tableHeader.size(); i++) {

            sessionModel.addColumn(tableHeader.get(i));

        }

    }

    /**
     * Method that sets up rows for Session Table.
     *
     * @param sessionDetails {ArrayList holding values of session data per user}
     */
    public void setUpRowsSession(ArrayList<SessionDetails> sessionDetails) {

        for (int i = 0; i < sessionDetails.size(); i++) {
            sessionModel.addRow(new Object[0]);
            sessionModel.setValueAt(sessionDetails.get(i).getSessionID(), i, 0);
            sessionModel.setValueAt(sessionDetails.get(i).getDateTimeIn(), i, 1);
            sessionModel.setValueAt(sessionDetails.get(i).getDateTimeOut(), i, 2);
        }

    }

    /**
     * Method that sets up column headers for User Table.
     *
     * @param tableHeader {ArrayList holding values for column headers}
     */
    public void setUpTableUsers(ArrayList<String> tableHeader) {

        //create columns
        for (int i = 0; i < tableHeader.size(); i++) {

            userModel.addColumn(tableHeader.get(i));

        }
        userModel.addColumn("MAKE ADMIN");

    }

    /**
     * Method that sets up rows for User Table.
     *
     * @param userList {ArrayList holding values user's data}
     */
    public void setupRowsUsers(ArrayList<User> userList) {

        boolean flag;

        //create rows
        for (int i = 0; i < userList.size(); i++) {

            userModel.addRow(new Object[0]);
            userModel.setValueAt(userList.get(i).getName(), i, 0);//value + row + column
            userModel.setValueAt(userList.get(i).getUserId(), i, 1);
            userModel.setValueAt(userList.get(i).getEmail(), i, 2);
            userModel.setValueAt(userList.get(i).getStatus(), i, 3);
            userModel.setValueAt(userList.get(i).getPasswordErrors(), i, 4);           

            flag = userList.get(i).getStatus().equals("admin");

            userModel.setValueAt(flag, i, 5);

        }

        ///////////////////////////////////////////////////////////////////////////////////
        //aligns Integer Columns to left. Referenced by (camickr, 2010).
        DefaultTableCellRenderer leftRenderer = new DefaultTableCellRenderer();
        leftRenderer.setHorizontalAlignment(SwingConstants.LEFT);
        userListTable.getColumnModel().getColumn(1).setCellRenderer(leftRenderer);
        userListTable.getColumnModel().getColumn(4).setCellRenderer(leftRenderer);

        ///////////////////////////////////////////////////////////////////////////////////
        //set up column width:
        TableColumnModel columnModel = userListTable.getColumnModel();
        columnModel.getColumn(1).setPreferredWidth(15);
        columnModel.getColumn(2).setPreferredWidth(170);
        columnModel.getColumn(3).setPreferredWidth(25);
        columnModel.getColumn(4).setPreferredWidth(120);

    }

    /**
     * Getters and Setters:
     * <p>
     */
    public DefaultTableModel getUserModel() {
        return userModel;
    }

    public DefaultTableModel getSessionModel() {
        return sessionModel;
    }

    public DefaultTableModel getDetailsModel() {
        return detailsModel;
    }

    public JTable getDetailsTable() {
        return detailsTable;
    }

    public JTable getSessionTable() {
        return sessionTable;
    }

    public JPanel getTable2Panel() {
        return table2Panel;
    }

    public void setTable2Panel(JPanel table2Panel) {
        this.table2Panel = table2Panel;
    }

    public JLabel getCancelButton() {
        return cancelButton;
    }

    public JLabel getOkButton() {
        return okButton;
    }

    public JPanel getTable1Panel() {
        return table1Panel;
    }

    public JLabel getAdminLabel() {
        return adminLabel;
    }

    public void setAdminLabel(String adminLabel) {
        this.adminLabel.setText(adminLabel);
    }

    public JTable getUserListTable() {
        return userListTable;
    }

    public void setEditable(boolean isEditable) {

        editable = isEditable;
    }

    public JLabel getAdminButton() {

        return adminButton;
    }

    public JPanel getAdminPanel() {
        return adminPanel;
    }

    public JLabel getDeleteUserButton() {
        return deleteUserButton;
    }

    public JLabel getEditUserButton() {
        return editUserButton;
    }

    public JLabel getViewUserButton() {
        return viewUserButton;
    }

    @Override
    public JLabel getDash1Button() {
        return dash1Button;
    }

    @Override
    public JLabel getDash2Button() {
        return dash2Button;
    }

    @Override
    public JLabel getDash3Button() {
        return dash3Button;
    }

    @Override
    public JLabel getLogOutButton() {
        return logOutButton;
    }

    @Override
    public void setUserSign(String userName) {
        userSign.setText("You are logged in as " + userName);
    }

    @Override
    public JPanel getDashboard1Panel() {
        return dashboard1Panel;
    }

    @Override
    public JPanel getDashboard2Panel() {
        return dashboard2Panel;
    }

    @Override
    public JPanel getDashboard3Panel() {
        return dashboard3Panel;
    }

    @Override
    public JPanel getHomePanel() {
        return homePanel;
    }

    public void setDashboard1Panel(JPanel dashboard1Panel) {
        this.dashboard1Panel = dashboard1Panel;
    }

    public void setDashboard2Panel(JPanel dashboard2Panel) {
        this.dashboard2Panel = dashboard2Panel;
    }

    public void setDashboard3Panel(JPanel dashboard3Panel) {
        this.dashboard3Panel = dashboard3Panel;
    }

    public JLabel getCancelButton1() {
        return cancelButton1;
    }

    public void setCancelButton1(JLabel cancelButton1) {
        this.cancelButton1 = cancelButton1;
    }

    /**
     * 
     * Sets message in message window.    
     * 
     * @param messageType {String - value that determines if it is a confirm dialogue or an option dialogue}
     * @param text {String - value to be displayed in message window}
     */
    public void setMessage(boolean messageType, String text) {

        messageWindow = new MessageWindow(messageType);
        messageWindow.setAlwaysOnTop(true);
        messageWindow.setResizable(false);
        messageWindow.setLocationRelativeTo(null);
        messageWindow.setText(text);
        messageWindow.setVisible(true);

        if (text.length() > 150 && text.length() <= 200) {

            messageWindow.getLogo().setIconTextGap(35);
        
        } else if (text.length() > 200) {
            
            messageWindow.getLogo().setIconTextGap(3);
            
        } else {

            messageWindow.getLogo().setIconTextGap(45);
        
        }

    }

    /**    
     * @return {MessageWindow}
     */
    public MessageWindow getMessageWindow() {
        return messageWindow;
    }

    /**
     * Inner class that is responsible for setting up the custom scroll pane used at admin tables.
     * Code referenced from Ansharja, 2017.
     */
    private class CordisScrollPane extends JScrollPane {

        public CordisScrollPane() {
            super(VERTICAL_SCROLLBAR_AS_NEEDED, HORIZONTAL_SCROLLBAR_AS_NEEDED);
            Image imageThumb = createImage(16, 16, new Color(0, 99, 178));
            Image imageThumbPressed = createImage(16, 16, new Color(255, 255, 160));
            Image imageTrack = createImage(16, 16, new Color(156, 195, 213));

            setVerticalScrollBar(new CordisScrollBar(JScrollBar.VERTICAL, imageThumb, imageThumbPressed, imageTrack));

        }

        private Image createImage(int width, int height, Color color) {
            BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
            Graphics g = image.getGraphics();
            g.setColor(color);
            g.fillRect(0, 0, width, height);
            g.dispose();
            return image;
        }
    }

    /**
     * Inner class that is responsible for setting up the custom scroll bar used at admin tables.
     * Code referenced from Ansharja, 2017.
     */
    private class CordisScrollBar extends JScrollBar {

        private boolean isThumbPressed;

        public CordisScrollBar(final int orientation, final Image thumb, final Image thumbPressed, final Image track) {
            super(orientation);
            
            addMouseListener(new MouseAdapter(){
                @Override
                public void mousePressed(MouseEvent e) {
                    isThumbPressed = true;
                }

                @Override
                public void mouseReleased(MouseEvent e) {
                    isThumbPressed = false;
                }
            });

            setUI(new BasicScrollBarUI() {
                @Override
                protected void paintThumb(Graphics g, JComponent c, Rectangle r) {
                    if (isThumbPressed) {

                        g.drawImage(thumbPressed, r.x + 4, r.y, r.width / 2, r.height, null);

                    } else {

                        g.drawImage(thumb, r.x + 4, r.y, r.width / 2, r.height, null);

                    }
                }

                @Override
                protected void paintTrack(Graphics g, JComponent c, Rectangle r) {
                    g.drawImage(track, r.x, r.y, r.width, r.height, null);
                }

                @Override
                protected JButton createDecreaseButton(int orientation) {
                    return createZeroButton();
                }

                @Override
                protected JButton createIncreaseButton(int orientation) {
                    return createZeroButton();
                }

                private JButton createZeroButton() {
                    JButton jbutton = new JButton();
                    jbutton.setPreferredSize(new Dimension(0, 0));
                    jbutton.setMinimumSize(new Dimension(0, 0));
                    jbutton.setMaximumSize(new Dimension(0, 0));
                    return jbutton;
                }

            });//end setUI()
        }
    }//end CordisScrollBar
   
}

package cordismain;

import SQL_Loader.YearData;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.labels.PieSectionLabelGenerator;
import org.jfree.chart.labels.StandardCategoryToolTipGenerator;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

/**
 * generates visual representation for user interface.
 * 
 * @author Michal
 * @author dim6ata
 * @author Iqram
 * @author Hayder
 * 
 */
public class Gui extends javax.swing.JFrame {

    /**
     * Creates new form Gui
     */
    public Gui(String name) {
        super(name);
        initComponents();
    }

    /**
     * sets up visual components for Gui
     */                         
    public void initComponents() {

        backgroundPanel = new javax.swing.JPanel();
        cordisLabel = new javax.swing.JLabel();
        imageLabel = new javax.swing.JLabel();
        dash1Button = new javax.swing.JLabel();
        dash2Button = new javax.swing.JLabel();
        dash3Button = new javax.swing.JLabel();
        logOutButton = new javax.swing.JLabel();
        userSign = new javax.swing.JLabel();
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
        jScrollPane1 = new javax.swing.JScrollPane();
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        backgroundPanel.setBackground(new java.awt.Color(0, 99, 178));
        backgroundPanel.setMaximumSize(new java.awt.Dimension(1259, 700));

        cordisLabel.setFont(new java.awt.Font("Verdana", 1, 52)); // NOI18N
        cordisLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cordisLabel.setText("CORDIS");
        cordisLabel.setForeground(Color.BLACK);
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
            public void mouseExited(java.awt.event.MouseEvent evt) {
                dash1ButtonMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                dash1ButtonMouseEntered(evt);
            }
        });

        dash2Button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cordismain/dashboard2-btn-wb.png"))); // NOI18N
        dash2Button.setToolTipText("Click to display dashboard 2 details");
        dash2Button.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/cordismain/dash-grey2.png"))); // NOI18N
        dash2Button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                dash2ButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                dash2ButtonMouseExited(evt);
            }
        });

        dash3Button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cordismain/dashboard3-btn-wb.png"))); // NOI18N
        dash3Button.setToolTipText("Click to display dashboard 3 details");
        dash3Button.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/cordismain/dash-grey3.png"))); // NOI18N
        dash3Button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                dash3ButtonMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                dash3ButtonMouseEntered(evt);
            }
        });

        logOutButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cordismain/logout-mix.png"))); // NOI18N
        logOutButton.setToolTipText("Log out of Cordis");
        logOutButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                logOutButtonMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                logOutButtonMouseEntered(evt);
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
            public void mouseExited(java.awt.event.MouseEvent evt) {
                userSignMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                userSignMouseEntered(evt);
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
        homeChartContainerPanel.setLayout(new java.awt.GridLayout(1, 0));

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
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                countryButtonActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel4.setText("Display Top ");

        jSlider1.setMaximum(15);
        jSlider1.setMinimum(1);
        jSlider1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSlider1StateChanged(evt);
            }
        });
        jSlider1.addMouseListener(new java.awt.event.MouseAdapter() {
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
            public void mousePressed(java.awt.event.MouseEvent evt) {
                LineGraphButtonMousePressed(evt);
            }
        });
        LineGraphButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LineGraphButtonActionPerformed(evt);
            }
        });

        jCheck2015.setFont(new java.awt.Font("Verdana", 0, 13)); // NOI18N
        jCheck2015.setSelected(true);
        jCheck2015.setText("2015");
        jCheck2015.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheck2015ActionPerformed(evt);
            }
        });

        jCheck2016.setFont(new java.awt.Font("Verdana", 0, 13)); // NOI18N
        jCheck2016.setSelected(true);
        jCheck2016.setText("2016");
        jCheck2016.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheck2016ActionPerformed(evt);
            }
        });

        jCheck2017.setFont(new java.awt.Font("Verdana", 0, 13)); // NOI18N
        jCheck2017.setSelected(true);
        jCheck2017.setText("2017");
        jCheck2017.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheck2017ActionPerformed(evt);
            }
        });

        jCheck2018.setFont(new java.awt.Font("Verdana", 0, 13)); // NOI18N
        jCheck2018.setSelected(true);
        jCheck2018.setText("2018");
        jCheck2018.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheck2018ActionPerformed(evt);
            }
        });

        jCheck2019.setFont(new java.awt.Font("Verdana", 0, 13)); // NOI18N
        jCheck2019.setSelected(true);
        jCheck2019.setText("2019");
        jCheck2019.addActionListener(new java.awt.event.ActionListener() {
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

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 160));

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
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout pnl_tableLayout = new javax.swing.GroupLayout(pnl_table);
        pnl_table.setLayout(pnl_tableLayout);
        pnl_tableLayout.setHorizontalGroup(
            pnl_tableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_tableLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 513, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnl_tableLayout.setVerticalGroup(
            pnl_tableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_tableLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
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
            public void mouseExited(java.awt.event.MouseEvent evt) {
                averageButtonMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                averageButtonMouseEntered(evt);
            }
        });

        mostExpensiveButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cordismain/most-exp-bl.png"))); // NOI18N
        mostExpensiveButton.setToolTipText("");
        mostExpensiveButton.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/cordismain/most-exp-gr.png"))); // NOI18N
        mostExpensiveButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                mostExpensiveButtonMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                mostExpensiveButtonMouseEntered(evt);
            }
        });

        leastExpensiveButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cordismain/least-exp-bl.png"))); // NOI18N
        leastExpensiveButton.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/cordismain/least-exp-gr.png"))); // NOI18N
        leastExpensiveButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                leastExpensiveButtonMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                leastExpensiveButtonMouseEntered(evt);
            }
        });

        searchMenuButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cordismain/search-bl.png"))); // NOI18N
        searchMenuButton.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/cordismain/search-gr.png"))); // NOI18N
        searchMenuButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                searchMenuButtonMouseExited(evt);
            }
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

        d3Tabs.getAccessibleContext().setAccessibleName("MAX");

        layerPanel.add(dashboard3Panel);

        javax.swing.GroupLayout backgroundPanelLayout = new javax.swing.GroupLayout(backgroundPanel);
        backgroundPanel.setLayout(backgroundPanelLayout);
        backgroundPanelLayout.setHorizontalGroup(
            backgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundPanelLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(backgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(userSign, javax.swing.GroupLayout.PREFERRED_SIZE, 972, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(backgroundPanelLayout.createSequentialGroup()
                        .addGroup(backgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(dash1Button)
                            .addComponent(imageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dash2Button)
                            .addComponent(dash3Button))
                        .addGroup(backgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(backgroundPanelLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(cordisLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 591, Short.MAX_VALUE)
                                .addComponent(logOutButton))
                            .addGroup(backgroundPanelLayout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addComponent(layerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        backgroundPanelLayout.setVerticalGroup(
            backgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundPanelLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(backgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(backgroundPanelLayout.createSequentialGroup()
                        .addComponent(imageLabel)
                        .addGap(29, 29, 29)
                        .addComponent(dash1Button)
                        .addGap(53, 53, 53)
                        .addComponent(dash2Button)
                        .addGap(53, 53, 53)
                        .addComponent(dash3Button))
                    .addGroup(backgroundPanelLayout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addGroup(backgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cordisLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(logOutButton))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 27, Short.MAX_VALUE)
                        .addComponent(layerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(userSign)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(backgroundPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(backgroundPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// end initComponents()                       

    /**
     * Section that creates event listeners for Mouse entered and mouse exited elements.
     * It is responsible for changing the view when hovering over buttons
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

        userSign.setForeground(cordisGrey);
    }                                    

    private void logOutButtonMouseEntered(java.awt.event.MouseEvent evt) {                                          

        logOutButton.setIcon(new ImageIcon(getClass().getResource("logout-gr.png")));
    }                                         

    private void logOutButtonMouseExited(java.awt.event.MouseEvent evt) {                                         

        logOutButton.setIcon(new ImageIcon(getClass().getResource("logout-mix.png")));
    }                                        

    private void averageButtonMouseEntered(java.awt.event.MouseEvent evt) {                                           
        averageButton.setIcon(new ImageIcon(getClass().getResource("average-gr.png")));
    }                                          

    private void averageButtonMouseExited(java.awt.event.MouseEvent evt) {                                          
        averageButton.setIcon(new ImageIcon(getClass().getResource("average-bl.png")));
    }                                         

    private void mostExpensiveButtonMouseEntered(java.awt.event.MouseEvent evt) {                                                 
        mostExpensiveButton.setIcon(new ImageIcon(getClass().getResource("most-exp-gr.png")));
    }                                                

    private void mostExpensiveButtonMouseExited(java.awt.event.MouseEvent evt) {                                                
        mostExpensiveButton.setIcon(new ImageIcon(getClass().getResource("most-exp-bl.png")));
    }                                               

    private void leastExpensiveButtonMouseEntered(java.awt.event.MouseEvent evt) {                                                  
        leastExpensiveButton.setIcon(new ImageIcon(getClass().getResource("least-exp-gr.png")));
    }                                                 

    private void leastExpensiveButtonMouseExited(java.awt.event.MouseEvent evt) {                                                 
        leastExpensiveButton.setIcon(new ImageIcon(getClass().getResource("least-exp-bl.png")));
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
            //            System.out.println("Arr " + testQueryList.toString());
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

    private void searchMenuButtonMouseExited(java.awt.event.MouseEvent evt) {                                             

        searchMenuButton.setIcon(new ImageIcon(getClass().getResource("search-bl.png")));

    }                                            

    private void searchMenuButtonMouseEntered(java.awt.event.MouseEvent evt) {                                              
        searchMenuButton.setIcon(new ImageIcon(getClass().getResource("search-gr.png")));
    }                                             


    // Variables declaration - do not modify                     
    protected javax.swing.JButton LineGraphButton;
    protected javax.swing.JButton SearchButton;
    protected javax.swing.JTextField SearchText;
    protected javax.swing.JLabel averageButton;
    protected javax.swing.JLabel avgProjCosts;
    protected javax.swing.JPanel backgroundPanel;
    protected javax.swing.JPanel bar_option_panel;
    protected javax.swing.JLabel cityLabel;
    protected javax.swing.JLabel cordisLabel;
    protected javax.swing.JLabel cordisLabel1;
    protected javax.swing.JTextArea cordisTextArea;
    protected javax.swing.JButton countryButton;
    protected javax.swing.JPanel d2Chart1;
    protected javax.swing.JPanel d2Chart2;
    protected javax.swing.JPanel d2Chart3;
    protected javax.swing.JTextField d2Countrytext;
    protected javax.swing.JTextField d2LeastCity;
    protected javax.swing.JTextField d2Lproject;
    protected javax.swing.JTextField d2Mproject;
    protected javax.swing.JTextField d2SearchAverage;
    protected javax.swing.JTextField d2SearchLeast;
    protected javax.swing.JTextField d2SearchMost;
    protected javax.swing.JPanel d2SearchPanel;
    protected javax.swing.JTextField d2expensiveCity;
    protected javax.swing.JPanel d3MaxBarPanel;
    protected javax.swing.JPanel d3MaxPiePanel;
    protected javax.swing.JPanel d3MinBarPanel;
    protected javax.swing.JPanel d3MinPiePanel;
    protected javax.swing.JTabbedPane d3Tabs;
    protected javax.swing.JLabel dash1Button;
    protected javax.swing.JLabel dash2Button;
    protected javax.swing.JPanel dash2ButtonPanel;
    protected javax.swing.JPanel dash2DataPanel;
    protected javax.swing.JLabel dash3Button;
    protected javax.swing.JPanel dashboard1Panel;
    protected javax.swing.JPanel dashboard2Panel;
    protected javax.swing.JLabel dashboard3Label;
    protected javax.swing.JPanel dashboard3Panel;
    protected javax.swing.JLabel display_value;
    protected javax.swing.JPanel homeChartContainerPanel;
    protected javax.swing.JPanel homeChartPanel1;
    protected javax.swing.JPanel homeChartPanel2;
    protected javax.swing.JPanel homeMidPanel;
    protected javax.swing.JTextField homeNumParticipants;
    protected javax.swing.JTextField homeNumParticipantsLabel;
    protected javax.swing.JTextField homeNumProjects;
    protected javax.swing.JTextField homeNumProjectsLabel;
    protected javax.swing.JPanel homePanel;
    protected javax.swing.JTextField homeTotalCost;
    protected javax.swing.JTextField homeTotalCostLabel;
    protected javax.swing.JLabel imageLabel;
    protected javax.swing.JCheckBox jCheck2015;
    protected javax.swing.JCheckBox jCheck2016;
    protected javax.swing.JCheckBox jCheck2017;
    protected javax.swing.JCheckBox jCheck2018;
    protected javax.swing.JCheckBox jCheck2019;
    protected javax.swing.JLabel jLabel1;
    protected javax.swing.JLabel jLabel2;
    protected javax.swing.JLabel jLabel3;
    protected javax.swing.JLabel jLabel4;
    protected javax.swing.JLabel jLabel5;
    protected javax.swing.JLabel jLabel6;
    protected javax.swing.JLabel jLabel7;
    protected javax.swing.JLabel jLabel8;
    protected javax.swing.JScrollPane jScrollPane1;
    protected javax.swing.JSlider jSlider1;
    protected javax.swing.JTable jTable1;
    protected javax.swing.JLayeredPane layerPanel;
    protected javax.swing.JLabel leastExpProjCost;
    protected javax.swing.JLabel leastExpensiveButton;
    protected javax.swing.JPanel line_option_panel;
    protected javax.swing.JLabel logOutButton;
    protected javax.swing.JPanel maxContributors;
    protected javax.swing.JPanel minContributors;
    protected javax.swing.JLabel mostExpProjCost;
    protected javax.swing.JLabel mostExpensiveButton;
    protected javax.swing.JPanel pnl_chart;
    protected javax.swing.JTabbedPane pnl_tabbed;
    protected javax.swing.JPanel pnl_table;
    protected javax.swing.JLabel projectIDLabel;
    protected javax.swing.JLabel searchMenuButton;
    protected javax.swing.JPanel searchPanel;
    protected javax.swing.JLabel searchTitleLabel;
    protected javax.swing.JLabel userSign;
    // End of variables declaration                   

    protected Color cordisYellow = new Color(255, 255, 160);
    protected Color cordisGrey = new Color(202, 204, 208);
    protected Color cordisLightBlue = new Color(156, 195, 213);

    public JLabel getDash1Button() {
        return dash1Button;
    }

    public JLabel getDash2Button() {
        return dash2Button;
    }

    public JLabel getDash3Button() {
        return dash3Button;
    }

    public JLabel getLogOutButton() {
        return logOutButton;
    }

    public void setUserSign(String userName) {
        userSign.setText("You are logged in as " + userName);
    }

    public JPanel getDashboard1Panel() {
        return dashboard1Panel;
    }

    public JPanel getDashboard2Panel() {
        return dashboard2Panel;
    }

    public JPanel getDashboard3Panel() {
        return dashboard3Panel;
    }

    public JPanel getHomePanel() {
        return homePanel;
    }

    public JLabel getImageLabel() {
        return imageLabel;
    }

    public void setButtonIcon(int picker, JLabel button) {

        switch (picker) {

            case 1:

                button.setIcon(new ImageIcon(getClass().getResource("dash-grey1.png")));
                break;

            case 2:
                button.setIcon(new ImageIcon(getClass().getResource("dash-grey1.png")));
                break;

            case 3:
                button.setIcon(new ImageIcon(getClass().getResource("dash-grey1.png")));
            default:
                break;
        }

    }

    
    ////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////
    //MICHAL START - w1703164
    ////////////////////////////////////////////////////////////////////////////////////////
    //Initialize DB
    CordisDB CDB = new CordisDB();
    // Initialize Variables / Data structures 
    // From here, Datasets will be created
    ArrayList<YearData> queryList = CDB.displayQueryForLineGraph();
    HashMap<String, Integer> barMap = CDB.displayCountriesQuery();
    ArrayList<YearData> barChartArray = (ArrayList<YearData>) queryList.clone();

    //********************* Methods Bellow ********************************//
    // Getters & Setters
    public JButton getCountryButton() {
        return countryButton;
    }

    public JButton getYearsButton() {
        return LineGraphButton;
    }

    public JSlider getSlider() {
        return jSlider1;
    }

    /**
     * Clean panel, then calls for new data set -> re-populate with new BarChart
     *
     * @param amountToDisplay
     */
    public void createBarChart(int amountToDisplay) {
        pnl_chart.removeAll();
        // Create DataSet with map
        DefaultCategoryDataset barDataset = createBarChartDataset(amountToDisplay);

        //Create Graph
        JFreeChart barChart = ChartFactory.createBarChart("Projects per Country",
                "Country",
                "Country",
                barDataset,
                PlotOrientation.VERTICAL,
                true, true, false);
        barChart.setBackgroundPaint(new Color(255, 255, 160));

        // Set Title and Label font
        barChart.getLegend().setItemFont(new Font("Verdana", 1, 16));
        barChart.getTitle().setFont(new Font("Verdana", 0, 20));

        // Set Y Axis
        final NumberAxis myAxis = new NumberAxis("Projects");
        myAxis.setInverted(false);
        myAxis.setRange(0.0, 60);

        CategoryPlot chartPlot = barChart.getCategoryPlot();
        ValueAxis yAxis = chartPlot.getRangeAxis();

        yAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        barChart.getCategoryPlot().setRangeAxis(myAxis);

        // Set up min bar width and categoryMargin to display graph in good dimension
        BarRenderer br = (BarRenderer) barChart.getCategoryPlot().getRenderer();
        br.setMaximumBarWidth(0.05);
        chartPlot.getDomainAxis().setCategoryMargin(-2);
        chartPlot.getDomainAxis().setVisible(false);

        // Create JPanel and add it to panel
        ChartPanel cp = new ChartPanel(barChart);
        pnl_chart.add(cp);
        pnl_chart.validate();

        // Create Table Model
        CustomTableModelCountries cmt = new CustomTableModelCountries(barMap, 15);
        jTable1.setModel(cmt);

    }

    /**
     * Create Dataset for barchart, data range is 1 - 15, default 15
     * addValue( DATAVALUE, KEY, KEY to group Data - can be independent)
     * @param amountToDisplay
     * @return DefaultCategoryDataset
     */
    public DefaultCategoryDataset createBarChartDataset(int amountToDisplay) {

        final DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        int counter = 0;
        for (Map.Entry<String, Integer> entry : barMap.entrySet()) {

            if (counter < amountToDisplay) {
                dataset.addValue(entry.getValue(), entry.getKey(), entry.getKey());

                counter++;
            } else if (counter == amountToDisplay) {
                return dataset;
            }
        }

        return dataset;
    }

    /**
     * Additional functionality for Line Chart
     * Allows user to select/deselect years he/she would
     * like to display
     *
     * @param yearName
     * @return -1
     */
    public int findYearToRemove(String yearName) {

        for (int i = 0; i < barChartArray.size(); i++) {
            if (barChartArray.get(i).getYearName() == yearName) {
                int toRem = i;
                return toRem;
            }
        }
        return -1;
    }

    /**
     * Create simple line Data
     * X -> Years
     * Y -> Values
     * Another lines can be used with different key addVallue(data, key, X axis)
     * ArrayList holds objects YearData, which has double[]. Iterate through
     *
     * @param firstArr
     * @param secArr
     * @return data -> used for Chart
     */
    public DefaultCategoryDataset categoryDataset(ArrayList<YearData> dataArr) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        String[] months = {"Jan", "Feb", "Mar", "Apr", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};

        for (int y = 0; y < dataArr.size(); y++) {
            double[] monthsOfYear = dataArr.get(y).getArray();
            String name = dataArr.get(y).getYearName();

            for (int i = 0; i < months.length; i++) {
                double monthValue = monthsOfYear[i];
                dataset.addValue(monthValue / 1000, name, months[i]);
            }
        }
        return dataset;
    }

    /**
     * Creates Line Chart, first cleans panel and creates dataset
     * Then re-populates panel with new line chart
     *
     * @param dataset_array
     */
    public void basicLineGraph(ArrayList<YearData> dataset_array) {
        pnl_chart.removeAll();

        // Create Dataset
        DefaultCategoryDataset data_set = categoryDataset(dataset_array);

        // Create Bar Chart
        JFreeChart lineChart = ChartFactory.createLineChart("Contribution Per Month",
                "",
                "Amount of € * 1000",
                data_set,
                PlotOrientation.VERTICAL,
                true, true, false);
        lineChart.setBackgroundPaint(new Color(255, 255, 160));

        // Set Title and Label font
        lineChart.getLegend().setItemFont(new Font("Verdana", 1, 16));
        lineChart.getTitle().setFont(new Font("Verdana", 0, 20));

        // Set up Y Axis
        final NumberAxis myAxis = new NumberAxis("Amount of € * 1000");
        myAxis.setInverted(false);
        myAxis.setRange(0.0, 60000);

        lineChart.getCategoryPlot().setRangeAxis(myAxis);

        CategoryPlot chartPlot = lineChart.getCategoryPlot();
        ValueAxis yAxis = chartPlot.getRangeAxis();
        yAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());

        // Create Chart
        ChartPanel cp = new ChartPanel(lineChart);
        pnl_chart.add(cp);
        pnl_chart.validate();

        // Create Table
        CustomModelTable cmt = new CustomModelTable(queryList);
        jTable1.setModel(cmt);
    }
    ////////////////////////////////////////////////////////////////////////////////////////
    // MICHAL END
    ////////////////////////////////////////////////////////////////////////////////////////
    //-------------------------------------------------------------------------------------//
    ////////////////////////////////////////////////////////////////////////////////////////
    //IQRAM START - W1669138
    ////////////////////////////////////////////////////////////////////////////////////////
    private ResultSet ResultSetVar;
    private ResultSet ResultSetVar1;
    private ResultSet RS;
    private ResultSet rsSearchMax;
    private ResultSet rsSearchMin;

    //Getters and setters:
    public void setResultSetVar(ResultSet ResultSetVar) {
        this.ResultSetVar = ResultSetVar;
    }

    public void setResultSetVar1(ResultSet ResultSetVar1) {
        this.ResultSetVar1 = ResultSetVar1;
    }

    public void setRS(ResultSet RS) {
        this.RS = RS;
    }

    public void setRsSearchMax(ResultSet rsSearchMax) {
        this.rsSearchMax = rsSearchMax;
    }

    public void setRsSearchMin(ResultSet rsSearchMin) {
        this.rsSearchMin = rsSearchMin;
    }

    public JLabel getAverageButton() {
        return averageButton;
    }

    public JPanel getD2Chart1() {
        return d2Chart1;
    }

    public JPanel getD2Chart2() {
        return d2Chart2;
    }

    public JPanel getD2Chart3() {
        return d2Chart3;
    }

    public JLabel getLeastExpensiveButton() {
        return leastExpensiveButton;
    }

    public JLabel getMostExpensiveButton() {
        return mostExpensiveButton;
    }

    public JButton getSearchButton() {
        return SearchButton;
    }

    public String getSearchText() {
        return SearchText.getText();
    }

    public JPanel getD2SearchPanel() {
        return d2SearchPanel;
    }

    public JLabel getSearchMenuButton() {
        return searchMenuButton;
    }

    public void setSearchPanel(boolean set) {
        this.searchPanel.setVisible(set);
    }

    public void setD2Countrytext(JTextField d2Countrytext) {
        this.d2Countrytext = d2Countrytext;
    }

    public void setD2LeastCity(JTextField d2LeastCity) {
        this.d2LeastCity = d2LeastCity;
    }

    public void setD2Lproject(JTextField d2Lproject) {
        this.d2Lproject = d2Lproject;
    }

    public void setD2Mproject(JTextField d2Mproject) {
        this.d2Mproject = d2Mproject;
    }

    public void setD2SearchAverage(JTextField d2SearchAverage) {
        this.d2SearchAverage = d2SearchAverage;
    }

    public void setD2SearchLeast(JTextField d2SearchLeast) {
        this.d2SearchLeast = d2SearchLeast;
    }

    public void setD2SearchMost(JTextField d2SearchMost) {
        this.d2SearchMost = d2SearchMost;
    }

    public void setD2expensiveCity(JTextField d2expensiveCity) {
        this.d2expensiveCity = d2expensiveCity;
    }

    /**
     * creating dataset for max query for linechart 1
     *
     * @return
     * @author W1669138
     */
    private DefaultCategoryDataset createLineDataset() {

        // Creating database for storing the values of rows of database
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        try {
            // Looping through all the values of sqlite rows
            while (ResultSetVar.next()) {
                // Adding values sqlite rows to dataset
                dataset.addValue(ResultSetVar.getDouble("projectTotalCost"), "cost", ResultSetVar.getString("orgCountry"));
            }
            // returning database to use it on bar chart
        } catch (SQLException e) {

        }

        return dataset;

    }

    /**
     * creating dataset for min query for linechart 2
     *
     * @return
     * @author W1669138
     */
    private DefaultCategoryDataset createLineDataset2() {

        // Creating database for storing the values of rows of database
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        // Looping through all the values of sqlite rows
        try {
            while (ResultSetVar1.next()) {
                // Adding values sqlite rows to dataset
                dataset.addValue(ResultSetVar1.getDouble("projectTotalCost"), " cost", ResultSetVar1.getString("orgCountry"));
            }
            // returning database to use it on bar chart

        } catch (SQLException e) {

        }
        return dataset;

    }

    /**
     * dataset for bar chart
     *
     * @return
     * @author W1669138
     */
    private DefaultCategoryDataset createBarDataset() {

        //Creating database for storing the values of rows of database
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        try {

            //Looping through all the values of sqlite rows
            while (RS.next()) {
                //Adding values sqlite rows to dataset
                dataset.addValue(RS.getDouble("projectTotalCost"), RS.getString("orgCountry"), "Cost");
            }
            //returning database to use it on bar chart
        } catch (SQLException e) {

        }
        return dataset;
    }

    /**
     * creates charts
     *
     * @author W1669138
     */
    public void createLineTrail() {

        // Creating bar chart with parameter 3d
        JFreeChart barChart = ChartFactory.createBarChart3D(
                "Average cost per country", "orgCountry", "Average  cost",
                createBarDataset(),
                PlotOrientation.VERTICAL,
                true, true, false);
        barChart.setBackgroundPaint(cordisYellow);

        // Set Title and Label font
        barChart.getLegend().setItemFont(new Font("Verdana", 1, 13));
        barChart.getTitle().setFont(new Font("Verdana", 0, 20));

        // Creating line chart with parameters
        //most expensive line chart
        JFreeChart lineChart = ChartFactory.createLineChart(" Most Expensive Project Costs", "orgCountry", "projectTotalCost",
                createLineDataset(), PlotOrientation.VERTICAL, true, true, false);
        //lineChart.getPlot().setBackgroundPaint(Color.yellow);
        lineChart.setBackgroundPaint(cordisYellow);

        // Set Title and Label font
        lineChart.getLegend().setItemFont(new Font("Verdana", 1, 16));
        lineChart.getTitle().setFont(new Font("Verdana", 0, 20));

        //least expensive line chart                
        JFreeChart lineChart2 = ChartFactory.createLineChart("Least Expensive sProject Costs", "orgCountry", "projectTotalCost",
                createLineDataset2(), PlotOrientation.VERTICAL, true, true, false);
        lineChart2.getPlot().setBackgroundPaint(cordisLightBlue);
        lineChart2.setBackgroundPaint(cordisYellow);

        // Set Title and Label font
        lineChart2.getLegend().setItemFont(new Font("Verdana", 1, 16));
        lineChart2.getTitle().setFont(new Font("Verdana", 0, 20));

        // Creating bar chart here
        ChartPanel BCP = new ChartPanel(barChart);
        // Creating line chart here
        ChartPanel LCP = new ChartPanel(lineChart);
        ChartPanel LCP2 = new ChartPanel(lineChart2);

        // Adding bar chart in the screen
        d2Chart1.add(BCP, BorderLayout.CENTER);
        // Adding line chart in the screen
        d2Chart2.add(LCP, BorderLayout.CENTER);
        d2Chart3.add(LCP2, BorderLayout.CENTER);

    }

    /**
     * populates data in search tab dashboard 2
     */
    public void createSearchFunction() {

        try {
            // Looping through all the values of sqlite rows
            while (rsSearchMax.next()) {//max
                // Adding values sqlite rows to dataset

                d2Countrytext.setText(rsSearchMax.getString("orgCountry"));

                d2SearchMost.setText(rsSearchMax.getString("projectMaxCost"));

                d2expensiveCity.setText(rsSearchMax.getString("orgCity"));

                d2Mproject.setText(rsSearchMax.getString("projectID"));

                d2SearchAverage.setText(rsSearchMax.getString("averageCost"));

            }

            while (rsSearchMin.next()) {//min

                this.d2LeastCity.setText(rsSearchMin.getString("orgCity"));
                this.d2Lproject.setText(rsSearchMin.getString("projectID"));
                this.d2SearchLeast.setText(rsSearchMin.getString("projectMinCost"));

            }
            // returning database to use it on bar chart
        } catch (SQLException e) {

        }

    }
    ////////////////////////////////////////////////////////////////////////////////////////
    //IQRAM END
    ////////////////////////////////////////////////////////////////////////////////////////
    //-------------------------------------------------------------------------------------//

    ////////////////////////////////////////////////////////////////////////////////////////
    //HAYDER START
    ////////////////////////////////////////////////////////////////////////////////////////
    //Getters + Setters
    public JPanel getD3MaxBarPanel() {
        return d3MaxBarPanel;
    }

    public JPanel getD3MaxPiePanel() {
        return d3MaxPiePanel;
    }

    public JPanel getD3MinBarPanel() {
        return d3MinBarPanel;
    }

    public JPanel getD3MinPiePanel() {
        return d3MinPiePanel;
    }

    public JTabbedPane getD3Tabs() {
        return d3Tabs;
    }

    /**
     * creates dashboard 3 pie charts
     *
     * @param list
     * @param chartName
     * @param panel
     */
    public void setContributorsPiePanel(ArrayList<Contributor> list, String chartName, JPanel panel) {

        //creates and populates new dataset:
        DefaultPieDataset pd = new DefaultPieDataset();

        for (Contributor contr : list) {

            pd.setValue(contr.getOrgShortName(), contr.getContribution());

        }

        JFreeChart contrChart = ChartFactory.createPieChart3D(chartName, pd, true, true, true);//new pie chart in 3D

        PiePlot3D contrPlot = (PiePlot3D) contrChart.getPlot();//new plot used to customize visualisation

        ChartPanel contrPanel = new ChartPanel(contrChart);//panel that is used to connect chart to regular JPanel

        //change font size of pie chart legend and floating text boxes: 
        contrChart.getLegend().setItemFont(new Font("Verdana", 1, 9));
        contrPlot.setLabelFont(new Font("Verdana", 1, 9));
        contrChart.getTitle().setFont(new Font("Verdana", 0, 20));

        contrPlot.setInteriorGap(0.035);//sets gap inside chart frame - difference between round and oval.
        contrPlot.setMaximumLabelWidth(0.13);//sets length of labels.

        //set background of chart and plot:
        contrPlot.setBackgroundPaint(cordisYellow);
        contrChart.setBackgroundPaint(cordisGrey);

        panel.add(contrPanel, BorderLayout.CENTER);//assign contrPanel to JPanel
        panel.validate();

    }

    /**
     * creates dashboard 3 bar charts
     *
     * @param list
     * @param chartName
     * @param panel
     */
    public void setContributorsBarPanel(ArrayList<Contributor> list, String chartName, JPanel panel) {

        //creates and populates new dataset:
        DefaultCategoryDataset ds = new DefaultCategoryDataset();

        for (Contributor contr : list) {

            ds.addValue(((double) contr.getContribution() / 1000), contr.getOrgName(), "");

        }

        //create chart:
        JFreeChart chart
                = ChartFactory.createBarChart(chartName, "Organisation",
                        "Amount * €1000", ds, PlotOrientation.HORIZONTAL, false, true, false);

        chart.getTitle().setFont(new Font("Verdana", 0, 20));//set chart title font

        CategoryPlot plot = chart.getCategoryPlot();//panel that is used to connect chart to regular JPanel

        BarRenderer br = (BarRenderer) plot.getRenderer();
        br.setBaseToolTipGenerator(new StandardCategoryToolTipGenerator("{0}: €{2}", new DecimalFormat("#,###.###")));//displays organisation name and contribution amount.

        
        //set colours:
        plot.setRangeGridlinePaint(Color.BLACK);
        plot.setBackgroundPaint(cordisYellow);
        chart.setBackgroundPaint(cordisGrey);

        ChartPanel chartPanel = new ChartPanel(chart);//create chart panel that is used to connect chart to JPanel:

        //reset form editor panel and assign panelParticipants to it:
        panel.add(chartPanel, BorderLayout.CENTER);
        panel.validate();

    }

    ////////////////////////////////////////////////////////////////////////////////////////
    //HAYDER END
    ////////////////////////////////////////////////////////////////////////////////////////
    //-------------------------------------------------------------------------------------//
    
    ////////////////////////////////////////////////////////////////////////////////////////
    //dim6ata START
    ////////////////////////////////////////////////////////////////////////////////////////
    //enter code here
    /**
     * Home Page:
     * Section that contains code that deals with displaying home page:
     * <p>
     *
     * @author dim6ata
     *
     */
    private Map<String, String> participantPerCountry = new HashMap<>();
    private Map<String, String> yearEndProjects = new HashMap<>();
    private int numberOfProjects;
    private int numberOfParticipants;
    private double totalCostOfAllProjects;

    /**
     * Method that is responsible for creating a Pie Chart containing data for projects that
     * end in particular years.
     */
    public void setHomePageYearEndGraph() {

        //sort data:
        ArrayList<String> orderedKeys = new ArrayList<>(yearEndProjects.keySet());
        Collections.sort(orderedKeys);

        //create dataset:
        DefaultPieDataset yearEndDataset = new DefaultPieDataset();

        //add data to dataset:
        for (String key : orderedKeys) {

            yearEndDataset.setValue(key, Integer.parseInt(yearEndProjects.get(key)));

        }

        //create Pie chart
        JFreeChart yearEndPieChart = ChartFactory.createPieChart("NUMBER OF PROJECTS ENDING PER YEAR", yearEndDataset, true, true, true);

        //create a PiePlot that is used to customize chart visualisation:
        PiePlot piePlot = (PiePlot) yearEndPieChart.getPlot();

        //create chart panel that is used to connect chart to JPanel:
        ChartPanel panelYearEnd = new ChartPanel(yearEndPieChart);

        //set the label of pie chart to display number of projects as well as percentage:
        PieSectionLabelGenerator gen = new StandardPieSectionLabelGenerator(
                "{0}:{1}({2})", new DecimalFormat("0"), new DecimalFormat("0%"));
        piePlot.setLabelGenerator(gen);
        piePlot.setInteriorGap(0.001);
        piePlot.setMaximumLabelWidth(0.27);

        //set the font size of pie chart legend and floating text boxes: 
        yearEndPieChart.getLegend().setItemFont(new Font("Verdana", 1, 9));
        piePlot.setLabelFont(new Font("Verdana", 1, 9));

        //set background of chart:
        piePlot.setBackgroundPaint(cordisYellow);
        yearEndPieChart.setBackgroundPaint(cordisGrey);

        //reset form editor panel and assign panelYearEnd to it:
        homeChartPanel2.removeAll();
        homeChartPanel2.add(panelYearEnd, BorderLayout.CENTER);
        homeChartPanel2.validate();

    }

    /**
     * Method that is responsible for creating a Bar Chart containing data for the top 10 countries with
     * highest participants of projects.
     */
    public void setHomePageParticipantGraph() {

        //sort data:
        ArrayList<String> orderedKeys = new ArrayList<>(participantPerCountry.keySet());
        Collections.sort(orderedKeys);

        //create dataset:
        DefaultCategoryDataset participantDataSet = new DefaultCategoryDataset();

        //add data to dataset:
        for (String key : orderedKeys) {

            participantDataSet.setValue(Double.parseDouble(participantPerCountry.get(key)), "Number of Participants", key);

        }

        //create Bar Chart:
        JFreeChart participantChart
                = ChartFactory.createBarChart("TOP 10 PARTICIPATING COUNTRIES", "Country Code",
                        "Number of Participants", participantDataSet, PlotOrientation.VERTICAL, false, true, false);

        //create a plot that is used to customize chart visualisation:
        CategoryPlot plotParticipants = participantChart.getCategoryPlot();

        //set colour of chart and background:
        plotParticipants.setRangeGridlinePaint(Color.BLACK);
        plotParticipants.setBackgroundPaint(cordisYellow);
        participantChart.setBackgroundPaint(cordisGrey);
        plotParticipants.getRenderer().setSeriesPaint(0, cordisLightBlue);

        //create chart panel that is used to connect chart to JPanel:
        ChartPanel panelParticipants = new ChartPanel(participantChart);

        //reset form editor panel and assign panelParticipants to it:
        homeChartPanel1.removeAll();
        homeChartPanel1.add(panelParticipants, BorderLayout.CENTER);
        homeChartPanel1.validate();

    }

    /**
     * Sets Map with data for participants per country.
     *
     * @param participantPerCountry {A map of string keys and values}
     */
    public void setParticipantPerCountry(Map<String, String> participantPerCountry) {
        this.participantPerCountry = participantPerCountry;
    }

    /**
     * Sets Map with data for projects that end in particular years.
     *
     * @param yearEndProjects {A map of string keys and values}
     */
    public void setYearEndProjects(Map<String, String> yearEndProjects) {
        this.yearEndProjects = yearEndProjects;
    }

    /**
     * Shows value of numberOfProjects in JPanel(homeNumProjects).
     * Converts numberOfProjects to an Integer.
     *
     * @param numberOfProjects {String}
     */
    public void setNumberOfProjects(String numberOfProjects) {

        this.numberOfProjects = Integer.parseInt(numberOfProjects);
        homeNumProjects.setText(numberOfProjects);
    }

    /**
     * Shows value of numberOfParticipants in JPanel(homeNumParticipants).
     * Converts numberOfParticipants to an Integer.
     *
     * @param numberOfParticipants {String}
     */
    public void setNumberOfParticipants(String numberOfParticipants) {
        this.numberOfParticipants = Integer.parseInt(numberOfParticipants);
        homeNumParticipants.setText(numberOfParticipants);
    }

    /**
     * Shows value of totalCostOfAllProjects in JPanel(homeTotalCost).
     * Converts totalCostOfAllProjects to a Double.
     * Formats the double value and displays it in an appropriate way.
     *
     * @param totalCostOfAllProjects {String}
     * String formatting code referenced from @author Jenkov, 2014.
     */
    public void setTotalCostOfAllProjects(String totalCostOfAllProjects) {

        this.totalCostOfAllProjects = Double.parseDouble(totalCostOfAllProjects);
        String pattern = "#,###.###";
        DecimalFormat decimalFormat = new DecimalFormat(pattern);
        String totalCost = decimalFormat.format(this.totalCostOfAllProjects);
        homeTotalCost.setText(totalCost);
    }

    ////////////////////////////////////////////////////////////////////////////////////////
    // dim6ata END
    ////////////////////////////////////////////////////////////////////////////////////////
    //-------------------------------------------------------------------------------------//
}

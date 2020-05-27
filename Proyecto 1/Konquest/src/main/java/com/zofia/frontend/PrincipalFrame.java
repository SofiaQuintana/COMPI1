/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zofia.frontend;

import com.zofia.dummyclasses.Box;
import com.zofia.dummyclasses.Planet;
import com.zofia.dummyclasses.Player;
import com.zofia.lexers.XMLlexer;
import com.zofia.mapstructure.FileDriver;
import com.zofia.mapstructure.GameDriver;
import com.zofia.mapstructure.LoadStructure;
import com.zofia.mapstructure.MapDriver;
import com.zofia.mapstructure.StructureDriver;
import com.zofia.parsers.SAVING.XMLParser;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author zofia
 */
public class PrincipalFrame extends javax.swing.JFrame {
    private boolean started;
    private MessageStructure structure;
    private FileDriver fileDriver;
    private StructureDriver mapStructure;
    private List<Player> players;
    private List<Planet> planets;
    private MapDriver mapDriver;
    private boolean showStadistics;
    private boolean showSpaceships;
    private boolean accumulative;
    private GameDriver gameDriver;
    private int counter;
    private Player playerInTurn;
    private Box[] grid;
    private boolean blindMap;
    private MapEditor mapEditor;
    private int measurementCounter;
    private boolean measurement;
    private String path;
    private String file;
    private XMLlexer lexer;
    private XMLParser parser;
    private LoadStructure loading;
    /**
     * Creates new form PrincipalFrame
     */
    public PrincipalFrame() {
        initComponents();
        this.started = false;
        componentsVisibility(started);
        this.structure = new MessageStructure();
        this.fileDriver = new FileDriver();
        this.players = new ArrayList<>();
        this.planets = new ArrayList<>();
        this.mapEditor = new MapEditor(this);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        principalPanel = new javax.swing.JPanel();
        toolbarPanel = new javax.swing.JPanel();
        createButton = new javax.swing.JButton();
        endButton = new javax.swing.JButton();
        measureButton = new javax.swing.JButton();
        saveButton = new javax.swing.JButton();
        fleetButton = new javax.swing.JButton();
        playerLabel = new javax.swing.JLabel();
        standingLabel = new javax.swing.JLabel();
        orderField = new javax.swing.JPasswordField();
        endTurnButton = new javax.swing.JButton();
        messageLabel = new javax.swing.JLabel();
        turnLabel = new javax.swing.JLabel();
        scroll = new javax.swing.JScrollPane();
        messageArea = new javax.swing.JTextPane();
        layeredPanel = new javax.swing.JLayeredPane();
        centralPanel = new javax.swing.JPanel();
        background = new javax.swing.JLabel();
        menuBar = new javax.swing.JMenuBar();
        gameMenu = new javax.swing.JMenu();
        newGameItem = new javax.swing.JMenuItem();
        loadItem = new javax.swing.JMenuItem();
        saveItem = new javax.swing.JMenuItem();
        separator = new javax.swing.JPopupMenu.Separator();
        endItem = new javax.swing.JMenuItem();
        secondSeparator = new javax.swing.JPopupMenu.Separator();
        quitItem = new javax.swing.JMenuItem();
        moveMenu = new javax.swing.JMenu();
        endTurnItem = new javax.swing.JMenuItem();
        settingsMenu = new javax.swing.JMenu();
        showToolbar = new javax.swing.JCheckBoxMenuItem();
        showStatusbar = new javax.swing.JCheckBoxMenuItem();
        helpMenu = new javax.swing.JMenu();
        abouItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        principalPanel.setBackground(new java.awt.Color(0, 0, 0));

        toolbarPanel.setBackground(new java.awt.Color(255, 255, 255));

        createButton.setBackground(new java.awt.Color(255, 255, 255));
        createButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edit.png"))); // NOI18N
        createButton.setText("Create Map");
        createButton.setBorder(null);
        createButton.setEnabled(false);
        createButton.setOpaque(false);
        createButton.setPreferredSize(new java.awt.Dimension(75, 40));
        createButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createButtonActionPerformed(evt);
            }
        });

        endButton.setBackground(new java.awt.Color(255, 255, 255));
        endButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/close.png"))); // NOI18N
        endButton.setText("End Game");
        endButton.setBorder(null);
        endButton.setEnabled(false);
        endButton.setOpaque(false);
        endButton.setPreferredSize(new java.awt.Dimension(75, 40));

        measureButton.setBackground(new java.awt.Color(255, 255, 255));
        measureButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/measure.png"))); // NOI18N
        measureButton.setText("Measure Distance");
        measureButton.setBorder(null);
        measureButton.setEnabled(false);
        measureButton.setOpaque(false);
        measureButton.setPreferredSize(new java.awt.Dimension(75, 40));
        measureButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                measureButtonActionPerformed(evt);
            }
        });

        saveButton.setBackground(new java.awt.Color(255, 255, 255));
        saveButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/save.png"))); // NOI18N
        saveButton.setText("Save");
        saveButton.setBorder(null);
        saveButton.setEnabled(false);
        saveButton.setOpaque(false);
        saveButton.setPreferredSize(new java.awt.Dimension(75, 40));
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        fleetButton.setBackground(new java.awt.Color(255, 255, 255));
        fleetButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rocket.png"))); // NOI18N
        fleetButton.setText("Fleet Overview");
        fleetButton.setBorder(null);
        fleetButton.setEnabled(false);
        fleetButton.setOpaque(false);
        fleetButton.setPreferredSize(new java.awt.Dimension(75, 40));

        javax.swing.GroupLayout toolbarPanelLayout = new javax.swing.GroupLayout(toolbarPanel);
        toolbarPanel.setLayout(toolbarPanelLayout);
        toolbarPanelLayout.setHorizontalGroup(
            toolbarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(toolbarPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(createButton, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(endButton, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(128, 128, 128)
                .addComponent(saveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(140, 140, 140)
                .addComponent(measureButton, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(120, 120, 120)
                .addComponent(fleetButton, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42))
        );
        toolbarPanelLayout.setVerticalGroup(
            toolbarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, toolbarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(endButton, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
                .addComponent(saveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addComponent(measureButton, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addComponent(createButton, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addComponent(fleetButton, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
        );

        playerLabel.setForeground(new java.awt.Color(255, 153, 255));
        playerLabel.setText("Player:");

        standingLabel.setForeground(new java.awt.Color(255, 255, 255));
        standingLabel.setText("Standing order");

        orderField.setBackground(new java.awt.Color(0, 0, 0));
        orderField.setForeground(new java.awt.Color(255, 153, 255));
        orderField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 153, 255)));
        orderField.setMaximumSize(new java.awt.Dimension(1, 15));
        orderField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                orderFieldKeyPressed(evt);
            }
        });

        endTurnButton.setBackground(new java.awt.Color(0, 0, 0));
        endTurnButton.setForeground(new java.awt.Color(255, 153, 255));
        endTurnButton.setText("End Turn");
        endTurnButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 153, 255)));
        endTurnButton.setOpaque(false);
        endTurnButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                endTurnButtonMouseClicked(evt);
            }
        });

        messageLabel.setBackground(new java.awt.Color(255, 255, 255));
        messageLabel.setText("Messages");
        messageLabel.setOpaque(true);

        turnLabel.setText("Turn #");
        turnLabel.setOpaque(true);

        scroll.setBackground(new java.awt.Color(0, 0, 0));
        scroll.setBorder(null);

        messageArea.setBackground(new java.awt.Color(0, 0, 0));
        messageArea.setBorder(null);
        messageArea.setForeground(new java.awt.Color(255, 153, 255));
        scroll.setViewportView(messageArea);

        centralPanel.setBackground(new java.awt.Color(255, 255, 255));
        centralPanel.setOpaque(false);

        background.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/universe.jpg"))); // NOI18N

        layeredPanel.setLayer(centralPanel, javax.swing.JLayeredPane.DRAG_LAYER);
        layeredPanel.setLayer(background, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout layeredPanelLayout = new javax.swing.GroupLayout(layeredPanel);
        layeredPanel.setLayout(layeredPanelLayout);
        layeredPanelLayout.setHorizontalGroup(
            layeredPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background, javax.swing.GroupLayout.PREFERRED_SIZE, 1150, Short.MAX_VALUE)
            .addGroup(layeredPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layeredPanelLayout.createSequentialGroup()
                    .addContainerGap(294, Short.MAX_VALUE)
                    .addComponent(centralPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 530, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(306, Short.MAX_VALUE)))
        );
        layeredPanelLayout.setVerticalGroup(
            layeredPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layeredPanelLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(background, javax.swing.GroupLayout.PREFERRED_SIZE, 449, Short.MAX_VALUE))
            .addGroup(layeredPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layeredPanelLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(centralPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 430, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        javax.swing.GroupLayout principalPanelLayout = new javax.swing.GroupLayout(principalPanel);
        principalPanel.setLayout(principalPanelLayout);
        principalPanelLayout.setHorizontalGroup(
            principalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(messageLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(turnLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(toolbarPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(scroll)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, principalPanelLayout.createSequentialGroup()
                .addComponent(playerLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(standingLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(orderField, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(endTurnButton, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6))
            .addComponent(layeredPanel, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        principalPanelLayout.setVerticalGroup(
            principalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, principalPanelLayout.createSequentialGroup()
                .addComponent(toolbarPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addGroup(principalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(principalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(endTurnButton)
                        .addComponent(orderField, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, principalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(standingLabel)
                        .addComponent(playerLabel)))
                .addGap(0, 0, 0)
                .addComponent(layeredPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(messageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scroll, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(turnLabel))
        );

        menuBar.setBackground(new java.awt.Color(102, 102, 102));
        menuBar.setOpaque(false);
        menuBar.setPreferredSize(new java.awt.Dimension(220, 25));

        gameMenu.setText("Game");

        newGameItem.setText("New");
        newGameItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newGameItemActionPerformed(evt);
            }
        });
        gameMenu.add(newGameItem);

        loadItem.setText("Load Game");
        loadItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loadItemActionPerformed(evt);
            }
        });
        gameMenu.add(loadItem);

        saveItem.setText("Save Game");
        gameMenu.add(saveItem);
        gameMenu.add(separator);

        endItem.setText("End Game");
        gameMenu.add(endItem);
        gameMenu.add(secondSeparator);

        quitItem.setText("Quit");
        gameMenu.add(quitItem);

        menuBar.add(gameMenu);

        moveMenu.setText("Move");

        endTurnItem.setText("End Turn");
        moveMenu.add(endTurnItem);

        menuBar.add(moveMenu);

        settingsMenu.setText("Settings");

        showToolbar.setSelected(true);
        showToolbar.setText("Show Toolbar");
        showToolbar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showToolbarActionPerformed(evt);
            }
        });
        settingsMenu.add(showToolbar);

        showStatusbar.setSelected(true);
        showStatusbar.setText("Show Statusbar");
        showStatusbar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showStatusbarActionPerformed(evt);
            }
        });
        settingsMenu.add(showStatusbar);

        menuBar.add(settingsMenu);

        helpMenu.setText("Help");

        abouItem.setText("About Konquest");
        helpMenu.add(abouItem);

        menuBar.add(helpMenu);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(principalPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(principalPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void newGameItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newGameItemActionPerformed
        // TODO add your handling code here:
        this.mapEditor.setVisible(true);
        this.mapStructure = mapEditor.getMapStructure();
        
        this.measurement = false;
        this.started = true;
        this.showSpaceships = mapStructure.getNeutral().isShowSpaceships();
        this.showStadistics = mapStructure.getNeutral().isShowstadistics();
        this.accumulative = mapStructure.getMap().isAccumulate();
        this.blindMap = mapStructure.getMap().isBlindMap();
        this.players = mapStructure.getPlayers();
        this.path = mapEditor.getPath();
        startGame();
            
        components(started);
    }//GEN-LAST:event_newGameItemActionPerformed

    private void endTurnButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_endTurnButtonMouseClicked
        // TODO add your handling code here:
        changeTurn();
    }//GEN-LAST:event_endTurnButtonMouseClicked

    private void orderFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_orderFieldKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode() == KeyEvent.VK_ENTER) {
            int spaceships;
            String temporal = "";
            char[] chars = orderField.getPassword();
            for (int i = 0; i < chars.length; i++) {
                temporal += chars[i];
            }
            try {
                spaceships = Integer.valueOf(temporal);
                gameDriver.verifySpaceshipInput(spaceships);
                gameDriver.turnDriver(spaceships, showStadistics, showSpaceships, blindMap, 
                        playerInTurn.getName(), mapStructure.getMap().getRows(), mapStructure.getMap().getColumns());
                enableGrid();
            } catch (NumberFormatException e) {
                structure.appendError(Color.RED, "Solo se puede ingresar cantidad entera de naves a enviar.", gameDriver.getTurnCounter(), messageArea);
            } catch (Exception ex) {
                structure.appendError(Color.RED, ex.getMessage(), gameDriver.getTurnCounter(), messageArea);
            }
            orderField.setText("");
        }
    }//GEN-LAST:event_orderFieldKeyPressed

    private void showToolbarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showToolbarActionPerformed
        // TODO add your handling code here:
        if(showToolbar.isSelected()) {
            this.toolbarPanel.setVisible(true);
        } else {
            this.toolbarPanel.setVisible(false);
        }
    }//GEN-LAST:event_showToolbarActionPerformed

    private void showStatusbarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showStatusbarActionPerformed
        // TODO add your handling code here:
        if(showStatusbar.isSelected()) {
            this.turnLabel.setVisible(true);
        } else {
            this.turnLabel.setVisible(false);
        }
    }//GEN-LAST:event_showStatusbarActionPerformed

    private void createButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createButtonActionPerformed
        // TODO add your handling code here:
        this.mapEditor.setVisible(true);
    }//GEN-LAST:event_createButtonActionPerformed

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        // TODO add your handling code here:
        for (int i = 0; i < grid.length; i++) {
            Box box = grid[i];
            if(box.getPlanet() != null) {
                planets.add(box.getPlanet());
            }
        }
        JFileChooser saver = new JFileChooser();
        saver.showSaveDialog(this);
        saver.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        if(saver.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            try {
                this.path = saver.getSelectedFile().toString();
                fileDriver.writeSaveFile(path, mapStructure.getMap(), mapStructure.getNeutral(), planets, players);
                path += "/" + mapStructure.getMap().getId() + ".save";
                
            } catch (IOException ex) {
                Logger.getLogger(MapEditor.class.getName()).log(Level.SEVERE, null, ex);
            } catch (Exception ex) {
                Logger.getLogger(MapEditor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_saveButtonActionPerformed

    private void measureButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_measureButtonActionPerformed
        // TODO add your handling code here:
        measureButton.setEnabled(false);
        measurement = true;
        this.measurementCounter = 1;
        setPlayerInstructions(playerInTurn, measurementCounter);
        measurementCounter++;
    }//GEN-LAST:event_measureButtonActionPerformed

    private void loadItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loadItemActionPerformed
        // TODO add your handling code here:
        this.file = "";
        JFileChooser chooser = new JFileChooser();
        chooser.setDialogTitle("Open .save file");
        if(chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            this.path = chooser.getSelectedFile().getPath();
            try {
                this.file = fileDriver.readInputFile(path);
                this.lexer = new XMLlexer(new StringReader(file), this);
                this.parser = new XMLParser(lexer, this);
                this.parser.parse();
                //Obtiene datos a usar en el frame principal relacionados al funcionamiento del juego.
                this.loading = parser.getStructure();
                this.mapStructure = loading.getStructure();
                this.players = mapStructure.getPlayers();
                //Coloca los datos obtenidos en la UI.
                this.measurement = false;
                this.started = true;
                this.showSpaceships = mapStructure.getNeutral().isShowSpaceships();
                this.showStadistics = mapStructure.getNeutral().isShowstadistics();
                this.accumulative = mapStructure.getMap().isAccumulate();
                this.blindMap = mapStructure.getMap().isBlindMap();
                this.players = mapStructure.getPlayers();
                this.path = mapEditor.getPath();
                startGame();
            } catch (IOException ex) {
                System.out.println("No se encontro el archivo");
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
    }//GEN-LAST:event_loadItemActionPerformed
    
    public void generateMap(StructureDriver map) {
        if(this.mapStructure.getMap().isRandomMap()) {
            mapDriver = new MapDriver(map.getMap(), mapStructure.getNeutral().getProduction(), players);
            gameDriver = new GameDriver(mapDriver.getPlayers(), generateCards(mapDriver.createdMap()), map.getMap().getRows(), map.getMap().getColumns());
        } else {
            mapDriver = new MapDriver(map.getMap(), map.getPlanets(), players);
            gameDriver = new GameDriver(map.getPlayers(), generateCards(mapDriver.createdMap()), map.getMap().getRows(), map.getMap().getColumns());
        }
    }
    
    public void enableGrid() {
        for (int i = 0; i < grid.length; i++) {
            Box box = grid[i];
            box.setEnabled(true);
        }
    }
    
    public Box[] generateCards(Box[] grid) {
        this.grid = grid;
        centralPanel.setLayout(new GridLayout(mapStructure.getMap().getRows(), mapStructure.getMap().getColumns()));
        for (int i = 0; i < grid.length; i++) {
            Box card = grid[i];
            centralPanel.add(card);  
            card.addMouseListener(new java.awt.event.MouseAdapter() {
                @Override
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    cardMouseClicked(evt);
                }
            });
        }
        return grid;
    }
    
    public void changeToolTipText() {
        for (int i = 0; i < grid.length; i++) {
            Box box = grid[i];
            box.setToolTipText(box.toString(showStadistics, showSpaceships, blindMap, playerInTurn.getName()));
        }
    }
    
    public void distanceMeasurement(Box box) {
        switch(measurementCounter) {
            case 2:
                gameDriver.setOrigin(box);
                setPlayerInstructions(playerInTurn, measurementCounter);
                measurementCounter++;
            break;
            case 3:
                gameDriver.setDestination(box);
                int distance = gameDriver.distanceBetweenPlanets(mapStructure.getMap().getRows(), mapStructure.getMap().getColumns());
                String message = "Distance between planets is: " + distance + " light years.\n"
                        + "A ship leaving in this turn will arrive on turn " + (gameDriver.getTurnCounter()+ distance);
                JOptionPane.showMessageDialog(this, message, "Distance", JOptionPane.INFORMATION_MESSAGE);
                measurementCounter = 0;
                measureButton.setEnabled(true);
                measurement = false;
                setPlayerInstructions(playerInTurn, counter);
            break;
        }
    }
    
    public void cardMouseClicked(java.awt.event.MouseEvent evt) {
        restartCounter();
        Box card = (Box) evt.getSource();
        if(measurement) {
            distanceMeasurement(card);
        } else {
            switch(counter) {
            case 1:
                if(card.getPlanet() != null && !card.getPlanet().getOwner().equals("") && card.getPlanet().getOwner().equals(playerInTurn.getName())) {
                    gameDriver.setOrigin(card);
                    card.setEnabled(false);
                    counter++;
                    setPlayerInstructions(playerInTurn, counter);
                } else if(card.getPlanet() != null && !card.getPlanet().getOwner().equals(playerInTurn.getName())){
                    structure.appendError(Color.yellow, "Debe seleccionar un planeta origen, de su propiedad.", gameDriver.getTurnCounter(), messageArea);
                } else {
                    structure.appendError(Color.yellow, "Debe seleccionar un planeta origen.", gameDriver.getTurnCounter(), messageArea);
                }
            break;
            case 2:
                if(card.getPlanet()!= null) {
                    gameDriver.setDestination(card);
                    counter++;
                    setPlayerInstructions(playerInTurn, counter);
                    enableOrderButton();
                }
            break;           
            } 
        }
    }

    public void restartCounter() {
        if(counter == 3) {
            counter = 1;
        }
    }
    
    public void turn() {
        String turn = "Turn #" + gameDriver.getTurnCounter();
        turnLabel.setText(turn);
    }
    
    public void setPlayerInstructions(Player player, int counter) {
        String text = getHtmlColorCode(player);
        switch (counter) {
            case 1:
                text += "</font><font color = white> Select source planet...</font></html>";
                break;
            case 2:
                text += "</font><font color = white> Select destination planet...</font></html>";
                break;
            case 3:
                text += "</font><font color = white> How many ships?</font></html>";
                break;
            default:
                text = "Ocurrio un error.";
        }
        this.playerLabel.setText(text);
    }
    
    private String getHtmlColorCode(Player player) {
        String text = null;
        if(player.getColor() == Color.CYAN) {
            text = "<html><font color = Aqua>Player "+player.getName().replaceAll("\"", "")+":";
        } else if(player.getColor() == Color.ORANGE) {
            text = "<html><font color = #FF6600>Player "+player.getName().replaceAll("\"", "")+":";
        } else if(player.getColor() == Color.GREEN) {
            text = "<html><font color = #145a32>Player "+player.getName().replaceAll("\"", "")+":";
        } else if(player.getColor() == Color.GRAY) {
            text = "<html><font color = #808b96>Player "+player.getName().replaceAll("\"", "")+":";
        } else if(player.getColor() == Color.MAGENTA) {
            text = "<html><font color = #d81b60>Player "+player.getName().replaceAll("\"", "")+":";
        } else if(player.getColor() == Color.PINK) {
            text = "<html><font color = #f4d03f>Player "+player.getName().replaceAll("\"", "")+":";           
        } else if(player.getColor() == Color.YELLOW) {
            text = "<html><font color = #f1c40f>Player "+player.getName().replaceAll("\"", "")+":";
        }
        return text;
    }
    
    public void verifyIfGameEnded() {
        if(mapStructure.getMap().getEnding() > 0) {
            if(gameDriver.endGame(mapStructure.getMap().getEnding())) {
            //Mostramos resultados
            //Limpiamos juego 
            }
        } 
    }
    
    public void changeTurn() {
        restartCounter();
        gameDriver.conqueringManagement(structure, messageArea);
        enableOrderButton();
        gameDriver.registerRound(showStadistics, started, accumulative, blindMap, playerInTurn.getName());
        playerInTurn = gameDriver.getPlayerInTurn(showStadistics,showSpaceships,accumulative);
        changeToolTipText();
        verifyIfGameEnded();
        setPlayerInstructions(playerInTurn, counter);
        turn();
    }
    
    public void startGame() {       
        generateMap(mapStructure);
        this.counter = 1;
        enableOrderButton();
        playerInTurn = gameDriver.getPlayerInTurn(showStadistics,showSpaceships,accumulative);
        changeToolTipText();
        setPlayerInstructions(playerInTurn, counter);  
        turn();
    }
    
    public void enableOrderButton() {
        switch (counter) {
            case 3:
               orderField.setEnabled(true);
            break;
            default:
               orderField.setEnabled(false);
        }
    }
    
    public void components(boolean started) {
        enableButtons(started);
        componentsVisibility(started);
    }
    
    public void enableButtons(boolean enabled) {
       createButton.setEnabled(enabled);
       endButton.setEnabled(enabled);
       measureButton.setEnabled(enabled);
       saveButton.setEnabled(enabled);
       fleetButton.setEnabled(enabled);
   }
    
    public void componentsVisibility(boolean show) {
        standingLabel.setVisible(show);
        playerLabel.setVisible(show);
        endTurnButton.setVisible(show);
        turnLabel.setVisible(show);
        centralPanel.setVisible(show);
        orderField.setVisible(show);
    }
    
    /*Imprime un mensaje informativo, al momento de que el parser detecta un error sintactico en el archivo JSON.
     *Indica el token en el que se presento el error.  */
    public void printSyntaxError(String value, String token, int column, int row) {
        structure.appendString(Color.YELLOW, "Se presento un error en la estructura en: ", messageArea);
        structure.appendString(Color.RED, value, messageArea);
        structure.appendString(Color.YELLOW, ", se esperaba el token: ", messageArea);
        structure.appendString(Color.yellow, "en la columna: " + column + " y en la fila: " + row, messageArea);
        structure.appendString(Color.RED, token + "\n", messageArea);
    }
    
    public void printLexicalError(String value, int line, int column) {
        structure.appendString(Color.WHITE, "Error Lexico en valor: ", messageArea);
        structure.appendString(Color.RED, value, messageArea);
        structure.appendString(Color.WHITE, " , Dado en linea: ", messageArea);
        structure.appendString(Color.RED, String.valueOf(line), messageArea);
        structure.appendString(Color.WHITE, " y en columna: ", messageArea);
        structure.appendString(Color.RED, String.valueOf(column) + "\n", messageArea);
    }
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem abouItem;
    private javax.swing.JLabel background;
    private javax.swing.JPanel centralPanel;
    private javax.swing.JButton createButton;
    private javax.swing.JButton endButton;
    private javax.swing.JMenuItem endItem;
    private javax.swing.JButton endTurnButton;
    private javax.swing.JMenuItem endTurnItem;
    private javax.swing.JButton fleetButton;
    private javax.swing.JMenu gameMenu;
    private javax.swing.JMenu helpMenu;
    private javax.swing.JLayeredPane layeredPanel;
    private javax.swing.JMenuItem loadItem;
    private javax.swing.JButton measureButton;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JTextPane messageArea;
    private javax.swing.JLabel messageLabel;
    private javax.swing.JMenu moveMenu;
    private javax.swing.JMenuItem newGameItem;
    private javax.swing.JPasswordField orderField;
    private javax.swing.JLabel playerLabel;
    private javax.swing.JPanel principalPanel;
    private javax.swing.JMenuItem quitItem;
    private javax.swing.JButton saveButton;
    private javax.swing.JMenuItem saveItem;
    private javax.swing.JScrollPane scroll;
    private javax.swing.JPopupMenu.Separator secondSeparator;
    private javax.swing.JPopupMenu.Separator separator;
    private javax.swing.JMenu settingsMenu;
    private javax.swing.JCheckBoxMenuItem showStatusbar;
    private javax.swing.JCheckBoxMenuItem showToolbar;
    private javax.swing.JLabel standingLabel;
    private javax.swing.JPanel toolbarPanel;
    private javax.swing.JLabel turnLabel;
    // End of variables declaration//GEN-END:variables
}

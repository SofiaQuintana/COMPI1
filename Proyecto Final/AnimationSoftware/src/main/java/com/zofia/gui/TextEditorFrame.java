/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zofia.gui;

import com.zofia.drivers.CanvasDriver;
import com.zofia.drivers.FileDriver;
import com.zofia.drivers.ImageDriver;
import com.zofia.dummyclasses.Canvas;
import com.zofia.dummyclasses.Image;
import com.zofia.lexers.CanvasLexer;
import com.zofia.lexers.ColorsLexer;
import com.zofia.lexers.TimeLexer;
import com.zofia.parsers.canvas.CanvasParser;
import com.zofia.parsers.colors.ColorsParser;
import com.zofia.parsers.timers.TimeParser;
import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import com.zofia.logic.Error;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author zofia
 */
public class TextEditorFrame extends javax.swing.JInternalFrame {
    private String[] titles;
    private File[] files; //Para los paths de archivos seleccionados y/o de guardado de archivos vacios.
    private String[] fileExtentions;
    private boolean[] selectedFiles;
    private File selectedFile;
    private FileDriver fileDriver;
    private UntitledFile[] openedTabs;
    private UntitledFile tab;
    private JFileChooser chooser;
    private CanvasLexer canvasLexer;
    private ColorsLexer colorsLexer;
    private TimeLexer timeLexer;
    private CanvasParser canvasParser;
    private ColorsParser colorsParser;
    private TimeParser timeParser;
    private CanvasDriver canvasDriver;
    private GraphicalEditorFrame graphic;
    private HashMap<String, String> table;
    private PrincipalFrame frame;
    private ErrorDialog errores;
    private ImageDriver imageDriver;
    private static final int CANVAS_VALUE = 0;
    private static final int COLORS_VALUE = 1;
    private static final int TIME_VALUE = 2;
    private static final int PAINT_VALUE = 3;
    private static final int EXIT_VALUE = 0;
    private static final String OPEN_BUTTON = "Open";
    private static final String SAVING_BUTTON = "Save";
    private static final FileNameExtensionFilter canvasFilter = new FileNameExtensionFilter("LIENZO", "lnz");
    private static final FileNameExtensionFilter colorsFilter = new FileNameExtensionFilter("COLORES", "clrs");
    private static final FileNameExtensionFilter timeFilter = new FileNameExtensionFilter("TIEMPO", "tmp");
    private static final FileNameExtensionFilter paintFilter = new FileNameExtensionFilter("PINTAR", "pnt");

    
    /**
     * Creates new form TextEditorFrame
     */
    public TextEditorFrame(PrincipalFrame frame) {
        initComponents();
        setInitialValues();
        this.frame = frame;
    }
    
    private void setInitialValues() {
        this.selectedFiles = new boolean[]{false, false, false, false};
        this.titles = new String[]{"Lienzo", "Colores", "Tiempo", "Pintura"};
        this.openedTabs = new UntitledFile[]{null, null, null, null};
        this.files = new File[]{null, null, null, null};
        this.fileExtentions = new String[]{".lnz", ".clrs", ".tmp", ".pnt"};
        this.fileDriver = new FileDriver();
        this.table = new HashMap();
        this.canvasDriver = new CanvasDriver();
        this.imageDriver = new ImageDriver();
    }
    
    private void restartTabValues(int type) {
        tabbedPanel.remove(openedTabs[type]);
        this.openedTabs[type] = null;
        this.selectedFiles[type] = false;
    }
   
    private void setChooserFilters(JFileChooser fileChooser, int type) {
        fileChooser.setAcceptAllFileFilterUsed(false);
        switch (type) {
            case 0:
                fileChooser.setFileFilter(canvasFilter);
            break;
            case 1:
                fileChooser.setFileFilter(colorsFilter);
            break;
            case 2:
                fileChooser.setFileFilter(timeFilter);
            break;
            case 3:
                fileChooser.setFileFilter(paintFilter);
            break;
            default:
                fileChooser.setFileFilter(canvasFilter);
                fileChooser.setFileFilter(colorsFilter);
                fileChooser.setFileFilter(timeFilter);
                fileChooser.setFileFilter(paintFilter);
            break;
        }
        
    } 
    
    private void setSavingConfigurations(JFileChooser fileChooser) {
        fileChooser.setDialogTitle("Save file");
        fileChooser.setApproveButtonText(SAVING_BUTTON);
    }
    
    /* Configuraciones para el chooser en caso de que se necesite 
       elegir un archivo para ser abierto por el editor.
    */
    private void setOpeningConfigurations(JFileChooser fileChooser) {
        fileChooser.setDialogTitle("Open file");
        fileChooser.setApproveButtonText(OPEN_BUTTON);
    }
    
    private void openFile() {
        this.chooser = new JFileChooser();
        setOpeningConfigurations(chooser);
        setChooserFilters(chooser, Integer.SIZE);
        int option = chooser.showOpenDialog(this);
        if(option == JFileChooser.APPROVE_OPTION) {
            File file = chooser.getSelectedFile();
            String fileName = file.getName();
            if(fileName.endsWith(fileExtentions[0])) {
                setTab(0, file);
            } else if(fileName.endsWith(fileExtentions[1])) {
                setTab(1, file);
            } else if(fileName.endsWith(fileExtentions[2])) {
                setTab(2, file);
            } else if(fileName.endsWith(fileExtentions[3])) {
                setTab(3, file);
            }
        }
        
    }
    
    private void readFile(int type, File file) {
        try {
            String content = fileDriver.readInputFile(file);
            this.tab = new UntitledFile(type, true, content);
            this.openedTabs[type] = tab;
            this.tabbedPanel.addTab(titles[type], tab);
            this.files[type] = file;
            this.selectedFiles[type] = true;
        } catch (IOException ex) {
            Logger.getLogger(TextEditorFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void setTab(int type, File file) {
        if(verifyIfOpened(type)) {
            /*Lanzamos un mensaje preguntando si el usuario desea guardas los cambios del archivo abierto. 
                1. Si la respuesta es si, guardamos los cambios del archivo y abrimos una nueva tab.
                2. Si la respuesta es no, omitimos la accion y cerramos el archivo.
            */
            String message = "Desea guardar los cambios del \narchivo de " + titles[type] + " abierto (?)";
            int selected = JOptionPane.showConfirmDialog(this, message, "Save File", JOptionPane.YES_NO_CANCEL_OPTION, 2);
            switch (selected) {
                case 0:
                    try {
                        saveFile(type);
                        restartTabValues(type);
                        setTab(type, file);
                        JOptionPane.showMessageDialog(this, "Archivo guardado con exito.", "Informacion", JOptionPane.INFORMATION_MESSAGE);
                    } catch (IOException ex) {
                        Logger.getLogger(TextEditorFrame.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    /* Obtener todos los datos y guardar.*/
                break;
                case 1:
                    /* remove tab */
                    /* set tab null */
                    restartTabValues(type);
                    setTab(type, file);
                break;
                case 2:
                    /* do nothing */
                break;
            }
        } else {
            /* 1. Instanciamos una nueva pestana, enviandole como parametro el tipo de pestana que se esta abriendo.
               2. Agregamos la tab a nuestro panel de pestanas, colocandole el titulo correspondiente segun el tipo.
               3. Le asignamos un valor de seleccion verdadero al archivo recien abierto. 
            */
            readFile(type, file);
        }
    }
    
    private void newFile(int type) {
        if(verifyIfOpened(type)) {
            /*Lanzamos un mensaje preguntando si el usuario desea guardas los cambios del archivo abierto. 
                1. Si la respuesta es si, guardamos los cambios del archivo y abrimos una nueva tab.
                2. Si la respuesta es no, omitimos la accion y cerramos el archivo.
            */
            String message = "Desea guardar los cambios del \narchivo de " + titles[type] + " abierto (?)";
            int selected = JOptionPane.showConfirmDialog(this, message, "Save File", JOptionPane.YES_NO_CANCEL_OPTION, 2);
            switch (selected) {
                case 0:
                    try {
                        saveFile(type);
                        restartTabValues(type);
                        newFile(type);
                        JOptionPane.showMessageDialog(this, "Archivo guardado con exito.", "Informacion", JOptionPane.INFORMATION_MESSAGE);
                    } catch (IOException ex) {
                        Logger.getLogger(TextEditorFrame.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    /*Jalar todos los datos y guardar.*/
                break;

                case 1:
                    /* remove tab */
                    /* set tab null */
                    restartTabValues(type);
                    newFile(type);
                break;
                case 2:
                    /* do nothing */
                break;
            }
        } else {
            /* 1. Instanciamos una nueva pestana, enviandole como parametro el tipo de pestana que se esta abriendo.
               2. Agregamos la tab a nuestro panel de pestanas, colocandole el titulo correspondiente segun el tipo.
               3. Le asignamos un valor de seleccion verdadero al archivo recien abierto. 
            */
            openNewTab(type);
        }
    }
    
    private void saveFile(int type) throws IOException {
        this.chooser = new JFileChooser();
        setChooserFilters(chooser, type);
        setSavingConfigurations(chooser);
        /* Distintas opciones de guardado 
            1. Si el archivo no ha sido guardado con anterioridad ni una sola vez
               1.1 Si es un archivo que no existe en el storage del usuario, es decir 'archivo nuevo'.
               2.1 Si es un archivo que ya existe en el storage del usuario.
            2. De lo contrario si ya ha sido guardado
        */
        if(!openedTabs[type].isSaved()) {
            int response = chooser.showSaveDialog(this);
            if(response == JFileChooser.APPROVE_OPTION) {
                selectedFile = chooser.getSelectedFile();
                if(selectedFile.exists()) {
                    response = JOptionPane.showConfirmDialog(this, "El archivo ya existe, desea sobreescribir los datos?", "Informacion", JOptionPane.YES_NO_CANCEL_OPTION, 2);
                    if(response == JOptionPane.YES_OPTION) {
                        fileDriver.saveFileContent(openedTabs[type].getAreaContent(), selectedFile);
                    } else if(response == JOptionPane.NO_OPTION) {
                        saveFile(type);
                    }
                } else {
                    fileDriver.saveFileContent(openedTabs[type].getAreaContent(), selectedFile);
                }
            }
            openedTabs[type].setSaved(true);
        } else {
            fileDriver.saveFileContent(openedTabs[type].getAreaContent(), files[type]);
        }
    }
    
    private void openNewTab(int type) {
        this.tab = new UntitledFile(type, false);
        this.openedTabs[type] = tab;
        this.tabbedPanel.addTab(titles[type], tab);
        this.selectedFiles[type] = true;
    }
    
    private boolean verifyIfOpened(int type) {
        return selectedFiles[type];
    }
    
    private LinkedList<Error> getFatalErrors(LinkedList<Error> errors) {
        LinkedList<Error> temporal = new LinkedList<>();
        for(Error error : errors) {
            if(!error.getType().equals("Semantico")) {
                temporal.add(error);
            }
        }
        return temporal;
    }
    
    private void testFiles() throws Exception {
        if(openedTabs[0] == null || openedTabs[1] == null || openedTabs[2] == null || openedTabs[3] == null) {
            JOptionPane.showMessageDialog(this, "Debe abrir los 4 tipos de archivo para poder realizar el analisis.", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            //Llamar a los 4 analizadores lexicos y sintacticos.
            this.canvasLexer = new CanvasLexer(new StringReader(openedTabs[0].getAreaContent()));
            this.colorsLexer = new ColorsLexer(new StringReader(openedTabs[1].getAreaContent()));
            this.timeLexer = new TimeLexer(new StringReader(openedTabs[2].getAreaContent()));
            this.canvasParser = new CanvasParser(canvasLexer, table, canvasDriver);
            this.colorsParser = new ColorsParser(colorsLexer, table, canvasDriver);
            this.timeParser = new TimeParser(timeLexer, table, canvasDriver);
            this.canvasParser.parse();
            this.colorsParser.parse();
            this.timeParser.parse();
            System.out.println("Leido adecuadamente, cantidas de canvas: " + canvasDriver.getCanvases().size());
            System.out.println("Colores leidos adecuadamente: " + canvasDriver.getCanvases().get(0).getColorsTable().size());
            System.out.println("Tiempos leidos adecuadamente: " + canvasDriver.getCanvases().get(0).getTime());
            
            if(getFatalErrors(canvasDriver.getErrors()).isEmpty() && canvasDriver.getErrors().isEmpty()) {
                enableButtons(true);
            } else if(getFatalErrors(canvasDriver.getErrors()).isEmpty() && !canvasDriver.getErrors().isEmpty()) {
                enableButtons(true);
                createErrorFrame(true);
            } else {
                JOptionPane.showMessageDialog(this, "Se encontraron errores fatales en los archivos.", "Error", JOptionPane.ERROR_MESSAGE);
                createErrorFrame(true);
            }
        }
    }
    
    private void enableButtons(boolean visible) {
        this.generateMenu.setEnabled(visible);
        this.generateButton.setEnabled(visible);
    }
    
    private void createErrorFrame(boolean visibility) {
        this.errores = new ErrorDialog(true, canvasDriver.getErrors());
        this.errores.setVisible(visibility);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        secondaryBar = new javax.swing.JPanel();
        saveButton = new javax.swing.JButton();
        firstSeparator = new javax.swing.JSeparator();
        openButton = new javax.swing.JButton();
        testButton = new javax.swing.JButton();
        secondSeparator = new javax.swing.JSeparator();
        generateButton = new javax.swing.JButton();
        canvasButton = new javax.swing.JButton();
        timeButton = new javax.swing.JButton();
        colorsButton = new javax.swing.JButton();
        paintButton = new javax.swing.JButton();
        secondSeparator1 = new javax.swing.JSeparator();
        tabbedPanel = new javax.swing.JTabbedPane();
        bar = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        newMenu = new javax.swing.JMenu();
        canvasItem = new javax.swing.JMenuItem();
        colorItem = new javax.swing.JMenuItem();
        timeItem = new javax.swing.JMenuItem();
        paintItem = new javax.swing.JMenuItem();
        openItem = new javax.swing.JMenuItem();
        saveItem = new javax.swing.JMenuItem();
        exit = new javax.swing.JMenuItem();
        analyzeMenu = new javax.swing.JMenu();
        test = new javax.swing.JMenuItem();
        generateMenu = new javax.swing.JMenu();
        graphicEditorItem = new javax.swing.JMenuItem();
        generateItem = new javax.swing.JMenuItem();
        helpMenu = new javax.swing.JMenu();
        userManual = new javax.swing.JMenuItem();
        techManual = new javax.swing.JMenuItem();
        about = new javax.swing.JMenuItem();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setPreferredSize(new java.awt.Dimension(1050, 600));

        secondaryBar.setBackground(new java.awt.Color(132, 165, 157));

        saveButton.setBackground(new java.awt.Color(132, 165, 157));
        saveButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/save16.png"))); // NOI18N
        saveButton.setBorder(null);
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        firstSeparator.setBackground(new java.awt.Color(0, 0, 0));
        firstSeparator.setOrientation(javax.swing.SwingConstants.VERTICAL);

        openButton.setBackground(new java.awt.Color(132, 165, 157));
        openButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/open16.png"))); // NOI18N
        openButton.setBorder(null);
        openButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openButtonActionPerformed(evt);
            }
        });

        testButton.setBackground(new java.awt.Color(132, 165, 157));
        testButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/test.png"))); // NOI18N
        testButton.setBorder(null);
        testButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                testButtonActionPerformed(evt);
            }
        });

        secondSeparator.setBackground(new java.awt.Color(0, 0, 0));
        secondSeparator.setOrientation(javax.swing.SwingConstants.VERTICAL);

        generateButton.setBackground(new java.awt.Color(132, 165, 157));
        generateButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/play.png"))); // NOI18N
        generateButton.setBorder(null);
        generateButton.setEnabled(false);
        generateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                generateButtonActionPerformed(evt);
            }
        });

        canvasButton.setBackground(new java.awt.Color(132, 165, 157));
        canvasButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/canvas.png"))); // NOI18N
        canvasButton.setBorder(null);
        canvasButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                canvasButtonActionPerformed(evt);
            }
        });

        timeButton.setBackground(new java.awt.Color(132, 165, 157));
        timeButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/time.png"))); // NOI18N
        timeButton.setBorder(null);
        timeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                timeButtonActionPerformed(evt);
            }
        });

        colorsButton.setBackground(new java.awt.Color(132, 165, 157));
        colorsButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/color.png"))); // NOI18N
        colorsButton.setBorder(null);
        colorsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                colorsButtonActionPerformed(evt);
            }
        });

        paintButton.setBackground(new java.awt.Color(132, 165, 157));
        paintButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/paint.png"))); // NOI18N
        paintButton.setBorder(null);
        paintButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                paintButtonActionPerformed(evt);
            }
        });

        secondSeparator1.setBackground(new java.awt.Color(0, 0, 0));
        secondSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        javax.swing.GroupLayout secondaryBarLayout = new javax.swing.GroupLayout(secondaryBar);
        secondaryBar.setLayout(secondaryBarLayout);
        secondaryBarLayout.setHorizontalGroup(
            secondaryBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(secondaryBarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(saveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(openButton, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(firstSeparator, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(canvasButton, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59)
                .addComponent(timeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(paintButton, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(secondSeparator, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(testButton, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(secondSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(generateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(596, Short.MAX_VALUE))
            .addGroup(secondaryBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(secondaryBarLayout.createSequentialGroup()
                    .addGap(170, 170, 170)
                    .addComponent(colorsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(826, Short.MAX_VALUE)))
        );
        secondaryBarLayout.setVerticalGroup(
            secondaryBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(saveButton, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
            .addComponent(openButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(testButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(firstSeparator)
            .addComponent(secondSeparator)
            .addComponent(generateButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(timeButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(canvasButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(paintButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(secondSeparator1)
            .addGroup(secondaryBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(colorsButton, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE))
        );

        tabbedPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabbedPanelMouseClicked(evt);
            }
        });

        bar.setBackground(new java.awt.Color(132, 165, 157));

        fileMenu.setText("File");

        newMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/new16.png"))); // NOI18N
        newMenu.setText("New");

        canvasItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/canvas.png"))); // NOI18N
        canvasItem.setText("Canvas");
        canvasItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                canvasItemActionPerformed(evt);
            }
        });
        newMenu.add(canvasItem);

        colorItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/color.png"))); // NOI18N
        colorItem.setText("Color");
        colorItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                colorItemActionPerformed(evt);
            }
        });
        newMenu.add(colorItem);

        timeItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/time.png"))); // NOI18N
        timeItem.setText("Time");
        timeItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                timeItemActionPerformed(evt);
            }
        });
        newMenu.add(timeItem);

        paintItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/paint.png"))); // NOI18N
        paintItem.setText("Paint");
        paintItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                paintItemActionPerformed(evt);
            }
        });
        newMenu.add(paintItem);

        fileMenu.add(newMenu);

        openItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/open16.png"))); // NOI18N
        openItem.setText("Open");
        openItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openItemActionPerformed(evt);
            }
        });
        fileMenu.add(openItem);

        saveItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/save16.png"))); // NOI18N
        saveItem.setText("Save");
        saveItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveItemActionPerformed(evt);
            }
        });
        fileMenu.add(saveItem);

        exit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/close.png"))); // NOI18N
        exit.setText("Exit");
        exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitActionPerformed(evt);
            }
        });
        fileMenu.add(exit);

        bar.add(fileMenu);

        analyzeMenu.setText("Analyze");

        test.setIcon(new javax.swing.ImageIcon(getClass().getResource("/test.png"))); // NOI18N
        test.setText("Test");
        test.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                testActionPerformed(evt);
            }
        });
        analyzeMenu.add(test);

        bar.add(analyzeMenu);

        generateMenu.setText("Generate");
        generateMenu.setEnabled(false);

        graphicEditorItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/graph.png"))); // NOI18N
        graphicEditorItem.setText("Graphic Editor");
        graphicEditorItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                graphicEditorItemActionPerformed(evt);
            }
        });
        generateMenu.add(graphicEditorItem);

        generateItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/play.png"))); // NOI18N
        generateItem.setText("Generate");
        generateItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                generateItemActionPerformed(evt);
            }
        });
        generateMenu.add(generateItem);

        bar.add(generateMenu);

        helpMenu.setText("Help");

        userManual.setIcon(new javax.swing.ImageIcon(getClass().getResource("/user.png"))); // NOI18N
        userManual.setText("User Manual");
        userManual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userManualActionPerformed(evt);
            }
        });
        helpMenu.add(userManual);

        techManual.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tech.png"))); // NOI18N
        techManual.setText("Technical Manual");
        techManual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                techManualActionPerformed(evt);
            }
        });
        helpMenu.add(techManual);

        about.setIcon(new javax.swing.ImageIcon(getClass().getResource("/about.png"))); // NOI18N
        about.setText("About");
        about.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aboutActionPerformed(evt);
            }
        });
        helpMenu.add(about);

        bar.add(helpMenu);

        setJMenuBar(bar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(secondaryBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(tabbedPanel)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(secondaryBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(tabbedPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 507, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void openItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openItemActionPerformed
        // TODO add your handling code here:
        openFile();
    }//GEN-LAST:event_openItemActionPerformed

    private void canvasItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_canvasItemActionPerformed
        // TODO add your handling code here:
        newFile(CANVAS_VALUE);
    }//GEN-LAST:event_canvasItemActionPerformed

    private void colorItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_colorItemActionPerformed
        // TODO add your handling code here:
        newFile(COLORS_VALUE);
    }//GEN-LAST:event_colorItemActionPerformed

    private void timeItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_timeItemActionPerformed
        // TODO add your handling code here:
        newFile(TIME_VALUE);
    }//GEN-LAST:event_timeItemActionPerformed

    private void paintItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_paintItemActionPerformed
        // TODO add your handling code here:
        newFile(PAINT_VALUE);
    }//GEN-LAST:event_paintItemActionPerformed

    private void canvasButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_canvasButtonActionPerformed
        // TODO add your handling code here:
        newFile(CANVAS_VALUE);
    }//GEN-LAST:event_canvasButtonActionPerformed

    private void colorsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_colorsButtonActionPerformed
        // TODO add your handling code here:
        newFile(COLORS_VALUE);
    }//GEN-LAST:event_colorsButtonActionPerformed

    private void timeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_timeButtonActionPerformed
        // TODO add your handling code here:
        newFile(TIME_VALUE);
    }//GEN-LAST:event_timeButtonActionPerformed

    private void paintButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_paintButtonActionPerformed
        // TODO add your handling code here:
        newFile(PAINT_VALUE);
    }//GEN-LAST:event_paintButtonActionPerformed

    private void exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitActionPerformed
        // TODO add your handling code here:
        System.exit(EXIT_VALUE);
    }//GEN-LAST:event_exitActionPerformed

    private void saveItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveItemActionPerformed
        // TODO add your handling code here:
        savingForButtons();
    }//GEN-LAST:event_saveItemActionPerformed

    private void tabbedPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabbedPanelMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tabbedPanelMouseClicked

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        // TODO add your handling code here:
        savingForButtons();
    }//GEN-LAST:event_saveButtonActionPerformed

    private void openButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openButtonActionPerformed
        // TODO add your handling code here:
        openFile();
    }//GEN-LAST:event_openButtonActionPerformed

    private void testActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_testActionPerformed
        try {
            // TODO add your handling code here:
            testFiles();
        } catch (Exception ex) {
            Logger.getLogger(TextEditorFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_testActionPerformed

    private void testButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_testButtonActionPerformed
        try {
            // TODO add your handling code here:
            testFiles();
        } catch (Exception ex) {
            Logger.getLogger(TextEditorFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_testButtonActionPerformed

    private void graphicEditorItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_graphicEditorItemActionPerformed
        // TODO add your handling code here:
        openGraphicEditor();
    }//GEN-LAST:event_graphicEditorItemActionPerformed

    private void aboutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aboutActionPerformed
        // TODO add your handling code here:
        String information = "Desarrollado por: Sofia Quintana\n" + 
                             "Organizacion: USAC-CUNOC\n";
        JOptionPane.showMessageDialog(this, information, "About", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_aboutActionPerformed

    private void userManualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userManualActionPerformed
        // TODO add your handling code here:
        fileDriver.openPDF("user_manual.pdf");
    }//GEN-LAST:event_userManualActionPerformed

    private void techManualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_techManualActionPerformed
        // TODO add your handling code here:
        fileDriver.openPDF("tech_manual.pdf");
    }//GEN-LAST:event_techManualActionPerformed

    private void generateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_generateButtonActionPerformed
        // TODO add your handling code here:
        generateImage();
    }//GEN-LAST:event_generateButtonActionPerformed

    private void generateItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_generateItemActionPerformed
        // TODO add your handling code here:
        generateImage();
    }//GEN-LAST:event_generateItemActionPerformed

    private void openGraphicEditor() {
        graphic = new GraphicalEditorFrame(canvasDriver);
        frame.getDesktopPane().add(graphic);
        graphic.setVisible(true);
    }
    
    private void savingForButtons() {
        UntitledFile temporal = (UntitledFile) tabbedPanel.getSelectedComponent();
        for (int i = 0; i < openedTabs.length; i++) {
            if(openedTabs[i] == temporal) {
                try {
                    saveFile(i);
                    JOptionPane.showMessageDialog(this, "Archivo guardado con exito.", "Informacion", JOptionPane.INFORMATION_MESSAGE);
                } catch (IOException ex) {
                    Logger.getLogger(TextEditorFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    private int getIndex(Canvas canvas, String id) {
        int start = canvas.getTime().getIndex(id);
        return start;
    }
    
    private void generateImage() {
        Thread thread = new Thread() {
            @Override
            public void run() {
                ArrayList<Integer> duration;
                ArrayList<BufferedImage> images;
                try {
                    ImagePanel image;
                    for(Canvas canvas : canvasDriver.getCanvases()) {
                        images  = new ArrayList<>();
                        duration = new ArrayList<>();
                        int start = getIndex(canvas, canvas.getTime().getStart());
                        int end = getIndex(canvas, canvas.getTime().getEnd());
                        
                        for (int i = start; i <= end; i++) {
                            Image current = canvas.getTime().getImages().get(i);
                            image = current.getImage();
                            image.setBorder(true);
                            images.add(imageDriver.createBufferedImage(image, canvas.getSquare()));
                            duration.add(current.getDuration());
                        }
                        String path = canvas.getId() + "." + canvas.getType();
                        if(!images.isEmpty()) {
                            imageDriver.createGif(images, duration, path);
                        }
                    }
                } catch(Exception e) {
                    System.out.println(e.getStackTrace());
                }
            }
        }; thread.start();
        JOptionPane.showMessageDialog(this, "Las imagenes fueron creadas exitosamente.", "Informacion", JOptionPane.INFORMATION_MESSAGE);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem about;
    private javax.swing.JMenu analyzeMenu;
    private javax.swing.JMenuBar bar;
    private javax.swing.JButton canvasButton;
    private javax.swing.JMenuItem canvasItem;
    private javax.swing.JMenuItem colorItem;
    private javax.swing.JButton colorsButton;
    private javax.swing.JMenuItem exit;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JSeparator firstSeparator;
    private javax.swing.JButton generateButton;
    private javax.swing.JMenuItem generateItem;
    private javax.swing.JMenu generateMenu;
    private javax.swing.JMenuItem graphicEditorItem;
    private javax.swing.JMenu helpMenu;
    private javax.swing.JMenu newMenu;
    private javax.swing.JButton openButton;
    private javax.swing.JMenuItem openItem;
    private javax.swing.JButton paintButton;
    private javax.swing.JMenuItem paintItem;
    private javax.swing.JButton saveButton;
    private javax.swing.JMenuItem saveItem;
    private javax.swing.JSeparator secondSeparator;
    private javax.swing.JSeparator secondSeparator1;
    private javax.swing.JPanel secondaryBar;
    private javax.swing.JTabbedPane tabbedPanel;
    private javax.swing.JMenuItem techManual;
    private javax.swing.JMenuItem test;
    private javax.swing.JButton testButton;
    private javax.swing.JButton timeButton;
    private javax.swing.JMenuItem timeItem;
    private javax.swing.JMenuItem userManual;
    // End of variables declaration//GEN-END:variables
}

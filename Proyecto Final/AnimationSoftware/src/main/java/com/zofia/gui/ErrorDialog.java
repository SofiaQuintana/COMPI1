/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zofia.gui;

import java.util.LinkedList;
import com.zofia.logic.Error;
import java.awt.Color;

/**
 *
 * @author zofia
 */
public class ErrorDialog extends javax.swing.JDialog {
    private LinkedList<com.zofia.logic.Error> errors;
    private MessageStructure messages;
    private static final String LEXICO = "Lexico";
    private static final String SINTACTICO = "Sintactico";
    private static final String SEMANTICO = "Semantico";
    /**
     * Creates new form ErrorDialog
     */
    public ErrorDialog(boolean modal, LinkedList<Error> errors) {
        setModal(modal);
        initComponents();
        this.errors = errors;
        this.messages = new MessageStructure();
        printErrors();
    }
    
    private void printErrors() {
        for(Error error : errors) {
            switch (error.getType()) {
                case LEXICO:
                    messages.appendError(Color.YELLOW, error.getType(), error.getDescription(), error.getLine(), error.getColumn(), erroresPane);
                break;
                case SINTACTICO:
                    messages.appendError(Color.RED, error.getType(), error.getDescription(), error.getLine(), error.getColumn(), erroresPane);
                break;
                case SEMANTICO:
                    messages.appendError(Color.ORANGE, error.getType(), error.getDescription(), error.getLine(), error.getColumn(), erroresPane);
                break;
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelPrincipal = new javax.swing.JPanel();
        scroll = new javax.swing.JScrollPane();
        erroresPane = new javax.swing.JTextPane();
        errorLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Errores");

        panelPrincipal.setBackground(new java.awt.Color(244, 241, 222));

        scroll.setViewportView(erroresPane);

        errorLabel.setText("Errores:");

        javax.swing.GroupLayout panelPrincipalLayout = new javax.swing.GroupLayout(panelPrincipal);
        panelPrincipal.setLayout(panelPrincipalLayout);
        panelPrincipalLayout.setHorizontalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scroll)
                    .addGroup(panelPrincipalLayout.createSequentialGroup()
                        .addComponent(errorLabel)
                        .addGap(0, 669, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panelPrincipalLayout.setVerticalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelPrincipalLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(errorLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scroll, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(panelPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel errorLabel;
    private javax.swing.JTextPane erroresPane;
    private javax.swing.JPanel panelPrincipal;
    private javax.swing.JScrollPane scroll;
    // End of variables declaration//GEN-END:variables
}
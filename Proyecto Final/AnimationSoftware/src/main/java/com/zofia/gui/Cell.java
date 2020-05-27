/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zofia.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JPanel;

/**
 *
 * @author zofia
 */
public class Cell extends JPanel implements MouseListener {
    private ImagePanel canvasPanel;
    private Color color;
    private int size;

    public Cell(ImagePanel canvasPanel, Color color, int size) {
        this.canvasPanel = canvasPanel;
        this.color = color;
        this.size = size;
        this.setBackground(color);
        this.addMouseListener(this);
    }
    
    @Override
    public Dimension getPreferredSize() {
        return new Dimension(size, size);
    }
    
    @Override
    public void mouseClicked(MouseEvent me) { 
        canvasPanel.paintCell(this);
    }

    @Override
    public void mousePressed(MouseEvent me) {
    }

    @Override
    public void mouseReleased(MouseEvent me) {
    }

    @Override
    public void mouseEntered(MouseEvent me) {
    }

    @Override
    public void mouseExited(MouseEvent me) {
    }
    
}

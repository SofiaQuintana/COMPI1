/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zofia.gui;

import com.zofia.dummyclasses.CanvasColor;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.util.HashMap;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JList;

/**
 *
 * @author zofia
 */
public class Renderer extends JLabel implements javax.swing.ListCellRenderer {
    private HashMap<String, CanvasColor> colors;
    
    public Renderer(HashMap<String, CanvasColor> colors) {
        this.setOpaque(true);
        this.colors = colors;
    }
    
    @Override
    public Component getListCellRendererComponent(JList list, Object key, int index, boolean isSelected, boolean cellHasFocus) {
        CanvasColor color = colors.get(key);;
        String name = key.toString();
        list.setSelectionBackground(null);
        list.setSelectionForeground(null);
        if(isSelected){
            setBorder(BorderFactory.createEtchedBorder());
        } 
        else {
            setBorder(null);
        }
        setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 12));
        setBackground(color.getColor());
        setText(name);
        setForeground(Color.BLACK);
        return this;
    }
}

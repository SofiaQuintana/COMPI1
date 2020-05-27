/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zofia.gui;

import com.zofia.dummyclasses.CanvasColor;
import java.awt.Color;
import java.awt.Font;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import org.apache.commons.collections.iterators.IteratorEnumeration;

/**
 *
 * @author zofia
 */
public class Colors extends JComboBox {
    
    private HashMap<String, CanvasColor> colors;

    public Colors(HashMap<String, CanvasColor> colors) {
        super();
        this.colors = colors;
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        Enumeration colorNames = new IteratorEnumeration(colors.keySet().iterator());
        while(colorNames.hasMoreElements()){
            String temp = colorNames.nextElement().toString();
            model.addElement(temp);
        }
        setModel(model);
        setRenderer(new Renderer(colors));
        this.setOpaque(true);
        this.setSelectedIndex(0);
    }
    
    @Override
    public void setSelectedItem(Object anObject) {
        super.setSelectedItem(anObject);
        setBackground(colors.get((String) anObject).getColor());
        setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 12));
    }
    
    public Color getSelectedColor(){
        return colors.get(this.getSelectedItem().toString()).getColor();
    } 
}

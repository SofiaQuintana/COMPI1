/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zofia.dummyclasses;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JLabel;

/**
 *
 * @author zofia
 */
public class Box extends JButton{
    private static final int PANEL_HEIGHT = 430;
    private static final int PANEL_WIDTH = 550;
    private int height;
    private int width;
    private Planet planet;

    public Box(int row, int column, Color color, Planet planet) {
        setWidth(column);
        setHeight(row);
        setPreferredSize(new Dimension(width, height));
        setFocusPainted(false);
        setBackground(color);
        setBorder(null);
        this.planet = planet;
    }

    public Planet getPlanet() {
        return planet;
    }
    
    @Override
    public void setLabel(String name) {
        name = name.replaceAll("\"", "");
        JLabel label = new JLabel(name);
        label.setFont(new Font("Dialog", Font.PLAIN, 10));
        label.setForeground(Color.BLACK);
        label.setOpaque(false);
        this.add(label);
    }

    public void setPlanet(Planet planet) {
        setLabel(planet.getName());
        this.planet = planet;
    }

    @Override
    public int getHeight() {
        return height;
    }

    public void setHeight(int row) {
        if(row > 9) {
            this.height = PANEL_HEIGHT/(row+2);
        } else if(row > 12) {
            this.height = PANEL_HEIGHT/(row+6);
        } else {
            this.height = PANEL_HEIGHT/(row+1);
        }
    }

    @Override
    public int getWidth() {
        return width;
    }

    public void setWidth(int column) {
        if(column > 9) {
            this.width = PANEL_WIDTH/(column+2);
        } else if(column > 12) {
            this.width = PANEL_WIDTH/(column+6);
        } else{
            this.width = PANEL_WIDTH/(column+1);
        }
    }

    public String toString(boolean stadistics, boolean spaceships, boolean blindMap, String playerName) {
        if(planet == null) {
            return "";
        } else  {
            return planet.toString(stadistics, spaceships, blindMap, playerName);
        }
    }
    
}

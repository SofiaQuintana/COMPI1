/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zofia.dummyclasses;

import java.awt.Color;
import java.util.HashMap;

/**
 *
 * @author zofia
 */
public class Canvas {
    private String id;
    private String name;
    private String type;
    private Color color;
    private Square square;
    private Time time;
    private HashMap<String, CanvasColor> colorsTable;

    public Canvas(String id, String name, String type, Color background, Square square, Time time, HashMap<String, CanvasColor> colorsTable) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.color = background;
        this.square = square;
        this.time = time;
        this.colorsTable = new HashMap<>();
    }

    public Canvas(String id, String name, String type, Color background, Square square) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.color = background;
        this.square = square;
        this.time = null;
        this.colorsTable = new HashMap<>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Square getSquare() {
        return square;
    }

    public void setSquare(Square square) {
        this.square = square;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public HashMap<String, CanvasColor> getColorsTable() {
        return colorsTable;
    }

    public void setColorsTable(HashMap<String, CanvasColor> colorsTable) {
        this.colorsTable = colorsTable;
    }
}

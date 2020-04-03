/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zofia.dummyclasses;

import java.awt.Color;
import java.util.List;

/**
 *
 * @author zofia
 */
public class Player {
    private String name;
    private List<Planet> starterPlanets; //Arreglo de planetas con los que inicia un jugador.
    private String type;
    private Color color; 

    public Player(String name, List<Planet> starterPlanets, String type, Color color) {
        this.name = name;
        this.starterPlanets = starterPlanets;
        this.type = type;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Planet> getStarterPlanets() {
        return starterPlanets;
    }

    public void setStarterPlanets(List<Planet> starterPlanets) {
        this.starterPlanets = starterPlanets;
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
    
}

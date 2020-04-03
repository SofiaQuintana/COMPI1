/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zofia.mapstructure;

import com.zofia.dummyclasses.Map;
import com.zofia.dummyclasses.Neutral;
import com.zofia.dummyclasses.Planet;
import com.zofia.dummyclasses.Player;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author zofia
 */
public class LoadStructure {
    private StructureDriver structure;
    private Map map;
    private Neutral neutral;
    private boolean temporal;
    private List<Planet> planets;
    private List<Player> players;
    private String color;
    private String name;
    
    public LoadStructure() {
        this.structure = new StructureDriver();
        this.map = new Map("", 0, 0, false, 0, false, false, 0);
        this.neutral = new Neutral(false, false, 0);
        this.planets = new ArrayList<>();
        this.players = new ArrayList<>();
    }

    public void setTemporal(boolean temporal) {
        this.temporal = temporal;
    }
    
    public void setSize(int rows, int columns) {
        this.map.setRows(rows);
        this.map.setColumns(columns);
    }
    
    public void addPlanet(String name, int ships, int production, double deathRate, String owner) {
        this.planets.add(new Planet(name, ships, production, deathRate, owner));
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setColor(String color) {
        this.color = color;
    }
    
    public Color getColor(String color) {
        Color aux = null;
        switch (color) {
            case "MAGENTA":
                aux = Color.MAGENTA;
                return aux;
            case "ORANGE":
                aux = Color.ORANGE;
                return aux;
            case "CYAN":
                aux = Color.CYAN;
                return aux;
            case "YELLOW":
                aux = Color.YELLOW;
                return aux;
            case "PINK":
                aux = Color.PINK;
                return aux;
            case "GREEN":
                aux = Color.GREEN;
                return aux;
            case "GRAY":
                aux = Color.GRAY;
                return aux;
        }
        return aux;
    }
    
    public void setPlayerAttributes(String type) {
        Player player = new Player(name, new ArrayList<Planet>(), type, getColor(color));
        for (int i = 0; i < planets.size(); i++) {
            Planet planet = planets.get(i);
            if(planet.getOwner().equals(name)) {
                player.getStarterPlanets().add(planet);
                planets.remove(i);
            }
        }
        players.add(player);
        this.structure.setMap(map);
        this.structure.setNeutral(neutral);
        this.structure.setPlanets(planets);
        this.structure.setPlayers(players);
    }
    
    public void setNeutralValues(String id, int value) {
        switch (id) {
            case "mostrarNaves":
                this.neutral.setShowSpaceships(temporal);
            break;
            case "mostrarEstadisticas":
                this.neutral.setShowstadistics(temporal);
            break;
            case "produccion":
                this.neutral.setProduction(value);
            break;
        }
    }
    
    public void setMapValues(String id, String name, int value) {
        switch (id) {
            case "id":
                map.setId(name);
            break;
            case "alAzar":
                this.map.setRandomMap(temporal);
            break;
            case "planetasNeutrales":
                this.map.setNeutralPlanets(value);
            break;
            case "mapaCiego":
                map.setBlindMap(temporal);
            break;
            case "acumular":
                map.setAccumulate(temporal);
            break;
            case "finalizacion":
                map.setEnding(value);
            break;
        }
    }
    public StructureDriver getStructure() {
        return structure;
    }

    public void setStructure(StructureDriver structure) {
        this.structure = structure;
    }

    
}

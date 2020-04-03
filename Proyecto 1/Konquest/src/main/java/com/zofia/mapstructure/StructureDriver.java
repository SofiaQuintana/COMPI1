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
public class StructureDriver {
    private Map map;
    private Planet planet;
    private Neutral neutral;
    private Player player;
    private boolean temporal;
    private String playerName;
    private List<Planet> planets;
    private List<Player> players;
    private List<Planet> ownedPlanets;
    private int production;
    private double deathRate;
    
    public StructureDriver() {
        this.map = new Map("", 0, 0, false, 0, false, false, 0);
        this.neutral = new Neutral(false, false, 0);
        this.planets = new ArrayList<>();
        this.ownedPlanets = new ArrayList<>();
        this.players = new ArrayList<>();
    }
    
    public void setMapId(String id) {
        this.map.setId(id);
    }
    
    public void setMapLimits(int rows, int columns) {
        this.map.setRows(rows);
        this.map.setColumns(columns);
    }
    
    public void setOptionalAttributes(String identifier, int ending) {
        System.out.println(identifier + " " + temporal);
        switch(identifier) {
            case "alAzar":
                this.map.setRandomMap(temporal);
            break;
            case "mapaCiego":
                this.map.setBlindMap(temporal);
            break;
            case "acumular":
                this.map.setAccumulate(temporal);
            break;
            case "finalizacion":
                this.map.setEnding(ending);
            break;
        }
    }

    public void setNeutralPlanets(int value) {
        this.map.setNeutralPlanets(value);
    }
    
    public void setNeutrals(String identifier, int value) {
        switch(identifier) {
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
    
    public void setTemporal(boolean temporal) {
        this.temporal = temporal;
    }
    
    public void setPlanetAttributes(String name, int spaceships, int production, double deathRate) {
        this.planet = new Planet(name, spaceships, production, deathRate, true);
        this.planets.add(planet);
    }
    
    public void setNeutralPlanets(String name, int spaceships) {
        this.planet = new Planet(name, spaceships, production, deathRate, true);
        this.planets.add(planet);
    }
    
    public void setProductionAndDeathRate(int production, double deathRate) {
        if(production < 0) {
            this.production = this.neutral.getProduction();
        } else {
            this.production = production;
        }
        this.deathRate = deathRate;
    }
    
    public void setOwnedPlanets(String name) {
        for(int i = 0; i < planets.size(); i++){
            if(name.equals(planets.get(i).getName())){
                planets.get(i).setOwner(playerName);
                ownedPlanets.add(planets.get(i));
                planets.remove(i);
                i--;
            }
        }
    }
    
    public Color getPlayerColor() {
        int counter = (int) (Math.random() * 7 + 1);
        switch(counter) {
            case 1: 
                return Color.MAGENTA;
            case 2:
                return Color.GREEN;
            case 3:
                return Color.CYAN;
            case 4:
                return Color.PINK;
            case 5:
                return Color.GRAY;
            case 6:
                return Color.YELLOW;
            default:
                return Color.ORANGE;
        }
    }
  
    public void setPlayerAttributes(String type) {
        this.player = new Player(playerName, new ArrayList<Planet>(), type, getPlayerColor());
        for(int i = 0; i < ownedPlanets.size(); i++){
            if(playerName.equals(ownedPlanets.get(i).getOwner())){
                player.getStarterPlanets().add(ownedPlanets.get(i));
                ownedPlanets.remove(i);
                i--;
            }
        }
        this.players.add(player);
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public List<Planet> getPlanets() {
        return planets;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
    }

    public Neutral getNeutral() {
        return neutral;
    }

    public void setNeutral(Neutral neutral) {
        this.neutral = neutral;
    }

    public List<Planet> getOwnedPlanets() {
        return ownedPlanets;
    }

    public void setOwnedPlanets(List<Planet> ownedPlanets) {
        this.ownedPlanets = ownedPlanets;
    }

    public void setPlanets(List<Planet> planets) {
        this.planets = planets;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }
    
}

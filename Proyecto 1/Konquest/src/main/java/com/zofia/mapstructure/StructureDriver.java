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
    
    public void setOwnedPlanets(String name) {
        for(Planet temporalPlanet : this.planets) {
            if(temporalPlanet.getName().equals(name)) {
                this.ownedPlanets.add(temporalPlanet);
                this.planets.remove(temporalPlanet);
            }
        }
    }
  
    public void setPlayerAttributes(String type) {
        this.ownedPlanets.forEach((temporalPlanet) -> {
            temporalPlanet.setOwner(playerName);
        });
        this.player = new Player(playerName, ownedPlanets, type);
        this.players.add(player);
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }
}

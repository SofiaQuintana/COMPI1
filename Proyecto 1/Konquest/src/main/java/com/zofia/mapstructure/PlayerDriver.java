/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zofia.mapstructure;

import com.zofia.dummyclasses.Planet;
import com.zofia.dummyclasses.Player;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author zofia
 */
public class PlayerDriver {
    private List<Planet> ownedPlanets;
    private List<Player> players;
    private StructureDriver structure;

    public PlayerDriver(StructureDriver structure) {
        this.structure = structure;
        this.ownedPlanets = Collections.synchronizedList(new ArrayList<>());
        this.players = Collections.synchronizedList(new ArrayList<>());
    }
    
    private void setPlayerPlanet() {
        getOwnedPlanets();
        this.players = structure.getPlayers();
        for(Player player : players) {
            for(Planet planet : ownedPlanets) {
                if(player.getName().equals(planet.getOwner())) {
                    player.getStarterPlanets().add(planet);
                }
            }
        } 
    }

    public List<Player> getPlayers() {
        setPlayerPlanet();
        return players;
    }
    
    private void getOwnedPlanets() {
       List<Planet> auxiliar = structure.getPlanets();
       for(Planet planet : auxiliar) {
           if(!planet.getOwner().equals("")) {
               ownedPlanets.add(planet);
           }
       }
    }
}

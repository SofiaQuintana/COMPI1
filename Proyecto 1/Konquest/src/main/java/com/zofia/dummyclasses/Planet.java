/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zofia.dummyclasses;

/**
 *
 * @author zofia
 */
public class Planet {
    private String name;
    private int spaceships;
    private int production;
    private double deathRate;
    private boolean neutral;
    private String owner;

    //Constructor para planetas neutrales
    public Planet(String name, int spaceships, int production, double deathRate, boolean neutral) {
        this.name = name;
        this.spaceships = spaceships;
        this.production = production;
        this.deathRate = deathRate;
        this.neutral = neutral;
        this.owner = "";
    }
    
    //Constructor para planetas iniciales para jugadores
    public Planet(String name, int spaceShips, int production, double deathRate, String owner) {
        this.name = name;
        this.spaceships = spaceShips;
        this.production = production;
        this.deathRate = deathRate;
        this.neutral = false;
        this.owner = owner;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSpaceships() {
        return spaceships;
    }

    public void setSpaceships(int spaceships) {
        this.spaceships = spaceships;
    }

    public int getProduction() {
        return production;
    }

    public void setProduction(int production) {
        this.production = production;
    }

    public double getDeathRate() {
        return deathRate;
    }

    public void setDeathRate(double deathRate) {
        this.deathRate = deathRate;
    }

    public boolean isNeutral() {
        return neutral;
    }

    public void setNeutral(boolean neutral) {
        this.neutral = neutral;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "Planet{" + "name=" + name + ", spaceships=" + spaceships + ", production=" + production + ", deathRate=" + deathRate + ", neutral=" + neutral + ", owner=" + owner + '}';
    }
    
}

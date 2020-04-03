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
public class Attack {
    private Planet origin;
    private Planet destination;
    private int spaceships;
    private int distance;

    public Attack(Planet origin, Planet destination, int spaceships, int distance) {
        this.origin = origin;
        this.destination = destination;
        this.spaceships = spaceships;
        this.distance = distance;
    }

    public Planet getOrigin() {
        return origin;
    }

    public void setOrigin(Planet origin) {
        this.origin = origin;
    }

    public Planet getDestination() {
        return destination;
    }

    public void setDestination(Planet destination) {
        this.destination = destination;
    }

    public int getSpaceships() {
        return spaceships;
    }

    public void setSpaceships(int spaceships) {
        this.spaceships = spaceships;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }
    
}

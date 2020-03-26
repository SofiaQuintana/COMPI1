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
public class Map {
    /*Atributos Obligatorios*/
    private String id; //identificador del mapa
    private int rows; //filas
    private int columns; //columnas
    private boolean randomMap; //alAzar
    
     /*Valor entero de planetas neutrales, obligatorio 
      *si y solo si randomMap es verdadero.*/
    private int neutralPlanets;
    
    /*Atributos Opcionales*/
    private boolean blindMap; //Mapa ciego
    private boolean accumulate; //Acumular
    private int ending; //Numero de turnos con los que se finaliza el juego.

    public Map(String id, int rows, int columns, boolean randomMap, int neutralPlanets, boolean blindMap, boolean accumulate, int ending) {
        this.id = id;
        this.rows = rows;
        this.columns = columns;
        this.randomMap = randomMap;
        this.neutralPlanets = neutralPlanets;
        this.blindMap = blindMap;
        this.accumulate = accumulate;
        this.ending = ending;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getColumns() {
        return columns;
    }

    public void setColumns(int columns) {
        this.columns = columns;
    }

    public boolean isRandomMap() {
        return randomMap;
    }

    public void setRandomMap(boolean randomMap) {
        this.randomMap = randomMap;
    }

    public int getNeutralPlanets() {
        return neutralPlanets;
    }

    public void setNeutralPlanets(int neutralPlanets) {
        this.neutralPlanets = neutralPlanets;
    }

    public boolean isBlindMap() {
        return blindMap;
    }

    public void setBlindMap(boolean blindMap) {
        this.blindMap = blindMap;
    }

    public boolean isAccumulate() {
        return accumulate;
    }

    public void setAccumulate(boolean accumulate) {
        this.accumulate = accumulate;
    }

    public int getEnding() {
        return ending;
    }

    public void setEnding(int ending) {
        this.ending = ending;
    }
    
}

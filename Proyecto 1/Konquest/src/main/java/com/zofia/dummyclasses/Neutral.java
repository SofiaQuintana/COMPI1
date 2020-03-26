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
public class Neutral {
    private boolean showSpaceships; //Mostrar naves
    private boolean showstadistics; //Mostrar Estadisticas
    private int production; //Produccion 'Global'

    public Neutral(boolean showSpaceships, boolean showstadistics, int production) {
        this.showSpaceships = showSpaceships;
        this.showstadistics = showstadistics;
        this.production = production;
    }

    public boolean isShowSpaceships() {
        return showSpaceships;
    }

    public void setShowSpaceships(boolean showSpaceships) {
        this.showSpaceships = showSpaceships;
    }

    public boolean isShowstadistics() {
        return showstadistics;
    }

    public void setShowstadistics(boolean showstadistics) {
        this.showstadistics = showstadistics;
    }

    public int getProduction() {
        return production;
    }

    public void setProduction(int production) {
        this.production = production;
    }
    
}

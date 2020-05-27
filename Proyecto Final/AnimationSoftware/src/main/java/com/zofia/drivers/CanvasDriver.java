/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zofia.drivers;

import com.zofia.dummyclasses.Canvas;
import com.zofia.dummyclasses.CanvasColor;
import com.zofia.dummyclasses.Time;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import com.zofia.logic.Error;
import java.util.LinkedList;
/**
 *
 * @author zofia
 */
public class CanvasDriver {
    private List<Canvas> canvases;
    private LinkedList<Error> errors; 
    
    public CanvasDriver() {
        this.canvases = new ArrayList<>();
        this.errors = new LinkedList<>();
    }
    
    public void addCanvas(Canvas canvas) {
        canvases.add(canvas);
    }
    
    public boolean isCanvasUsed(String id) {
        for(Canvas canvas : canvases) {
            if(canvas.getId().equals(id)) {
                if(canvas.getColorsTable().isEmpty()) {
                    return false;
                } else {
                    return true;
                }
            }
        }
        return false;
    }
    
    public void addColors(String id, HashMap<String, CanvasColor> colors) {
        Canvas temporal = null;
        for(Canvas canvas : canvases) {
            if(canvas.getId().equals(id)) {
                temporal = canvas;
            }
        }
        temporal.setColorsTable(colors);
    }
    
    public void addTime(Time time) {
        for(Canvas canvas : canvases) {
            if(canvas.getId().equals(time.getId())) {
                canvas.setTime(time);
            }
        }
    }

    public List<Canvas> getCanvases() {
        return canvases;
    }

    public LinkedList<Error> getErrors() {
        return errors;
    }
}

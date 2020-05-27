/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zofia.logic;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author zofia
 */
public class Environment {
    private HashMap<String, Sym> variables;
    private Environment previous;
    private ArrayList<Error> errors;

    public Environment(Environment previous) {
        this.variables = new HashMap<>();
        this.errors = new ArrayList<>();
        this.previous = previous;
    }
    
    public boolean insert(String name, Sym sym) {
        name = name.toLowerCase();
        if(variables.containsKey(name)) {
            return false;
        } else {
            variables.put(name, sym);
            return true;
        }
    }
    
    public Sym search(String name) {
        name = name.toLowerCase();
        for(Environment temporal = this; temporal != null; temporal.getPrevious()) {
            if(temporal.getVariables().containsKey(name)) {
                Sym sym = temporal.getVariables().get(name);
                return sym;
            }
        }
        return null;
    }
    
    public void update(String name, Sym sym, int line, int column) {
        name = name.toLowerCase();
        for(Environment temporal = this; temporal != null; temporal = temporal.getPrevious()) {
            if(temporal.getVariables().containsKey(name)) {
                temporal.getVariables().replace(name, sym);
                return;
            }
        } 
    }

    public HashMap<String, Sym> getVariables() {
        return variables;
    }

    public void setVariables(HashMap<String, Sym> variables) {
        this.variables = variables;
    }

    public Environment getPrevious() {
        return previous;
    }

    public void setPrevious(Environment previous) {
        this.previous = previous;
    }

    public ArrayList<Error> getErrors() {
        return errors;
    }

    public void setErrors(ArrayList<Error> errors) {
        this.errors = errors;
    }
}

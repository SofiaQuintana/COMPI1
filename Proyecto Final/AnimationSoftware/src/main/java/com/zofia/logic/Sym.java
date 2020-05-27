/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zofia.logic;

/**
 *
 * @author zofia
 */
public class Sym {
    private Type type;
    private Object value;

    public enum Type {
        integer,
        string, 
        bool,
        instruction,
        paint,
        error
    }

    public Sym() {
    }
    
    public Sym(Type type, Object value) {
        this.type = type;
        this.value = value;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    @Override
    public String toString() {
        if(value != null ) return value.toString();
        return "null";
    }
    
}

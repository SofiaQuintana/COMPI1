/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zofia.lexers;

/**
 *
 * @author zofia
 */
public class Node {
    private String type;
    private String name;
    private String path;

    public Node(String type, String name, String path) {
        this.type = type;
        this.name = name;
        this.path = path;
    }

    public Node(String type, String name) {
        this.type = type;
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public String toString() {
        return type + ": " + name;
    }

}

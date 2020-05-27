/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zofia.dummyclasses;

import java.awt.Dimension;

/**
 *
 * @author zofia
 */
public class Square {
    private Dimension dimension;
    private int size;

    public Square(Dimension dimension, int size) {
        this.dimension = dimension;
        this.size = size;
    }

    public Dimension getDimension() {
        return dimension;
    }

    public void setDimension(Dimension dimension) {
        this.dimension = dimension;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zofia.dummyclasses;

import com.zofia.gui.ImagePanel;

/**
 *
 * @author zofia
 */
public class Image {
    private String id;
    private int duration;
    private ImagePanel image;

    public Image(String id, int duration) {
        this.id = id;
        this.duration = duration;
        this.image = null;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public ImagePanel getImage() {
        return image;
    }

    public void setImage(ImagePanel image) {
        this.image = image;
    }

}

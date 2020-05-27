/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zofia.dummyclasses;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author zofia
 */
public class Time {
    private String start;
    private String end;
    private String id;
    private List<Image> images;

    public Time(String start, String end, String id, List<Image> images) {
        this.start = start;
        this.end = end;
        this.id = id;
        this.images = new ArrayList<>();
        this.images = images;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }
    
    public int getIndex(String id){
        for(int index = 0; index < images.size(); index++){
            if(images.get(index).getId().equals(id)){
                return index;
            }
        }
        return -1;
    }

    @Override
    public String toString() {
        return "Time{" + "start=" + start + ", end=" + end + ", id=" + id + ", images=" + images.size() + '}';
    }
    
}

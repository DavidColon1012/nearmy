package com.example.nearmy.bean;

import android.graphics.Bitmap;

import java.util.ArrayList;

public class Category {

    private String title;
    private ArrayList<Element> listElements;
    private boolean isEvento;
    private Bitmap btmCategory;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ArrayList<Element> getListElements() {
        return listElements;
    }

    public void setListElements(ArrayList<Element> listElements) {
        this.listElements = listElements;
    }

    public boolean isEvento() {
        return isEvento;
    }

    public void setEvento(boolean evento) {
        isEvento = evento;
    }

    public Bitmap getBtmCategory() {
        return btmCategory;
    }

    public void setBtmCategory(Bitmap btmCategory) {
        this.btmCategory = btmCategory;
    }
}

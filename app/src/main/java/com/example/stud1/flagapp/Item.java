package com.example.stud1.flagapp;

public class Item {
    private  String txtItem;
    private int imageItem;

    public Item(String txtItem, int imageItem) {
        this.txtItem = txtItem;
        this.imageItem = imageItem;
    }

    public String getTxtItem() {
        return txtItem;
    }

    public int getImageItem() {
        return imageItem;
    }
}

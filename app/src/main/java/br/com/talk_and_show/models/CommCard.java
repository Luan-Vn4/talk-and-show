package com.example.myapplication.models;

public class CommCard {

    private String name;
    private CommCardCategories category;
    private int image;

    public CommCard(String name, CommCardCategories category, int image) {
        this.setName(name);
        this.setCategory(category);
        this.setImage(image);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CommCardCategories getCategory() {
        return category;
    }

    public void setCategory(CommCardCategories category) {
        this.category = category;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}

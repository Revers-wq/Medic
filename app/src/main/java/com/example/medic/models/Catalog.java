package com.example.medic.models;

public class Catalog {
    String id;
    String name;

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setTime_result(String time_result) {
        this.time_result = time_result;
    }

    public void setPreparation(String preparation) {
        this.preparation = preparation;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    String description;

    public Catalog(String id, String name, String description, String price, String category, String time_result, String preparation, String bio) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.category = category;
        this.time_result = time_result;
        this.preparation = preparation;
        this.bio = bio;
    }

    String price;
    String category;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getPrice() {
        return price;
    }

    public String getCategory() {
        return category;
    }

    public String getTime_result() {
        return time_result;
    }

    public String getPreparation() {
        return preparation;
    }

    public String getBio() {
        return bio;
    }

    String time_result;
    String preparation;
    String bio;
}

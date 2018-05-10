package com.seckin.foodtracking.model;

public class Food {

    private String name;
    private String category;
    private String content;
    private int calories;

    public Food() {
    }

    public Food(String name, String category, String content, int calories) {
        this.name = name;
        this.category = category;
        this.content = content;
        this.calories = calories;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }
}

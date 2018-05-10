package com.seckin.foodtracking.model;

public class EatEntry {

    private User user;
    private Food food;
    private int amounth;
    private int calories;

    public EatEntry() {
    }

    public EatEntry(User user, Food food, int amounth, int calories) {
        this.user = user;
        this.food = food;
        this.amounth = amounth;
        this.calories = calories;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Food getFood() {
        return food;
    }

    public void setFood(Food food) {
        this.food = food;
    }

    public int getAmounth() {
        return amounth;
    }

    public void setAmounth(int amounth) {
        this.amounth = amounth;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }
}

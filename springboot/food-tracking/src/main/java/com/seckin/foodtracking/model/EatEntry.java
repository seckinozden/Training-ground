package com.seckin.foodtracking.model;

public class EatEntry {

    private User user;
    private Food food;
    private int amount;
    private int calories;

    public EatEntry() {
    }

    public EatEntry(User user, Food food, int amount, int calories) {
        this.user = user;
        this.food = food;
        this.amount = amount;
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

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }
}

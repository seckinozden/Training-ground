package com.seckin.foodtracking.model;

public class User {

    private Long ssn;
    private String name;
    private String surname;
    private String gender;
    private int weight;
    private int height;

    public User() {
    }

    public User(Long ssn, String name, String surname, String gender, int weight, int height) {
        this.ssn = ssn;
        this.name = name;
        this.surname = surname;
        this.gender = gender;
        this.weight = weight;
        this.height = height;
    }

    public Long getSsn() {
        return ssn;
    }

    public void setSsn(Long ssn) {
        this.ssn = ssn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}

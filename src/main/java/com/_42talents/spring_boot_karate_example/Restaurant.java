package com._42talents.spring_boot_karate_example;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

class Address {

    @JsonProperty("building")
    private String building;
    @JsonProperty("coord")
    private List<Double> coord;
    @JsonProperty("street")
    private String street;
    @JsonProperty("zipcode")
    private String zipcode;

    @JsonProperty("building")
    public String getBuilding() {
        return building;
    }

    @JsonProperty("building")
    public void setBuilding(String building) {
        this.building = building;
    }

    @JsonProperty("coord")
    public List<Double> getCoord() {
        return coord;
    }

    @JsonProperty("coord")
    public void setCoord(List<Double> coord) {
        this.coord = coord;
    }

    @JsonProperty("street")
    public String getStreet() {
        return street;
    }

    @JsonProperty("street")
    public void setStreet(String street) {
        this.street = street;
    }

    @JsonProperty("zipcode")
    public String getZipcode() {
        return zipcode;
    }

    @JsonProperty("zipcode")
    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

}

@Document("restaurants")
public class Restaurant {

    @JsonProperty("address")
    private Address address;
    @JsonProperty("borough")
    private String borough;
    @JsonProperty("cuisine")
    private String cuisine;
    @JsonProperty("grades")
    private List<Grade> grades;
    @JsonProperty("name")
    private String name;
    @JsonProperty("restaurant_id")
    private String restaurantId;

    @JsonProperty("address")
    public Address getAddress() {
        return address;
    }

    @JsonProperty("address")
    public void setAddress(Address address) {
        this.address = address;
    }

    @JsonProperty("borough")
    public String getBorough() {
        return borough;
    }

    @JsonProperty("borough")
    public void setBorough(String borough) {
        this.borough = borough;
    }

    @JsonProperty("cuisine")
    public String getCuisine() {
        return cuisine;
    }

    @JsonProperty("cuisine")
    public void setCuisine(String cuisine) {
        this.cuisine = cuisine;
    }

    @JsonProperty("grades")
    public List<Grade> getGrades() {
        return grades;
    }

    @JsonProperty("grades")
    public void setGrades(List<Grade> grades) {
        this.grades = grades;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("restaurant_id")
    public String getRestaurantId() {
        return restaurantId;
    }

    @JsonProperty("restaurant_id")
    public void setRestaurantId(String restaurantId) {
        this.restaurantId = restaurantId;
    }

}

class Grade {

    @JsonProperty("date")
    private Date date;
    @JsonProperty("grade")
    private String grade;
    @JsonProperty("score")
    private Integer score;

    @JsonProperty("date")
    public Date getDate() {
        return date;
    }

    @JsonProperty("date")
    public void setDate(Date date) {
        this.date = date;
    }

    @JsonProperty("grade")
    public String getGrade() {
        return grade;
    }

    @JsonProperty("grade")
    public void setGrade(String grade) {
        this.grade = grade;
    }

    @JsonProperty("score")
    public Integer getScore() {
        return score;
    }

    @JsonProperty("score")
    public void setScore(Integer score) {
        this.score = score;
    }

}



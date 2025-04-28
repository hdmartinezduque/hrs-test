package com.example.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Rule {

    @JsonProperty("type")
    private String type;

    @JsonProperty("subtype")
    private String subtype;

    @JsonProperty("threshold")
    private double threshold;

    @JsonProperty("comparison")
    private String comparison; 

    @JsonProperty("id")
    private int id;

    // Constructors
    public Rule() {}

    public Rule(String type, String subtype, double threshold, String comparison, int id) {
        this.type = type;
        this.subtype = subtype;
        this.threshold = threshold;
        this.comparison = comparison;
        this.id = id;
    }

    // Getters and Setters
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSubtype() {
        return subtype;
    }

    public void setSubtype(String subtype) {
        this.subtype = subtype;
    }

    public double getThreshold() {
        return threshold;
    }

    public void setThreshold(double threshold) {
        this.threshold = threshold;
    }

    public String getComparison() {
        return comparison;
    }

    public void setComparison(String comparison) {
        this.comparison = comparison;
    }

    public int getId() 
    { 
        return id; 
    }
    public void setId(int id) 
    { 
        this.id = id; 
    }

}
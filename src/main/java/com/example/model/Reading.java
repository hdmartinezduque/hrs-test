package com.example.model;

//import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Reading {

    @JsonProperty("id")
    private String id;

    @JsonProperty("type")
    private String type;

    @JsonProperty("subtype")
    private String subtype;

    @JsonProperty("value")
    private double value;

    @JsonProperty("patientId")
    private String patientId;

    @JsonProperty("timestamp")
    private String timestamp;

    // Constructors
    public Reading() {}

    public Reading(String id, String type, String subtype, double value, String patientId, String timestamp) {
        this.id = id;
        this.type = type;
        this.subtype = subtype;
        this.value = value;
        this.patientId = patientId;
        this.timestamp = timestamp;
    }

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}
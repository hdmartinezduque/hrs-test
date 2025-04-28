package com.example.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Result {

    @JsonProperty("readingId")
    private String readingId;

    @JsonProperty("type")
    private String type;

    @JsonProperty("subtype")
    private String subtype;

    @JsonProperty("value")
    private double value;

    @JsonProperty("triggeredRule")
    private String triggeredRule; 

    // Constructors
    public Result() {}

    public Result(String readingId, String type, String subtype, double value, String triggeredRule) {
        this.readingId = readingId;
        this.type = type;
        this.subtype = subtype;
        this.value = value;
        this.triggeredRule = triggeredRule;
    }

    // Getters and Setters
    public String getReadingId() {
        return readingId;
    }

    public void setReadingId(String readingId) {
        this.readingId = readingId;
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

    public String getTriggeredRule() {
        return triggeredRule;
    }

    public void setTriggeredRule(String triggeredRule) {
        this.triggeredRule = triggeredRule;
    }
}

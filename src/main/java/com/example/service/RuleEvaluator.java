package com.example.service;

import com.example.model.Reading;
import com.example.model.Result;
import com.example.model.Rule;

import java.util.ArrayList;
import java.util.List;

public class RuleEvaluator {

    public List<Result> evaluate(List<Reading> readings, List<Rule> rules) {
        List<Result> results = new ArrayList<>();

        for (Reading reading : readings) {
            for (Rule rule : rules) {
                if (matches(reading, rule)) {
                    results.add(new Result(
                        reading.getId(),
                        reading.getType(),
                        reading.getSubtype(),
                        reading.getValue(),
                        rule.getType() + "." + rule.getSubtype()
                    ));
                }
            }
        }
        return results;
    }

    private boolean matches(Reading reading, Rule rule) {
        // Primero, verificar tipo y subtipo
        if (!reading.getType().equalsIgnoreCase(rule.getType()) ||
            !reading.getSubtype().equalsIgnoreCase(rule.getSubtype())) {
            return false;
        }

        // Luego, comparar el valor según la comparación

        String comparison = rule.getComparison();
        if (comparison == null) {
            throw new IllegalArgumentException("Comparison in rule " + rule.getId() + " is null");
        }

        switch (comparison.toLowerCase()) {
            case "greater_than":
                return reading.getValue() > rule.getThreshold();
            case "less_than":
                return reading.getValue() < rule.getThreshold();
            case "equal_to":
                return reading.getValue() == rule.getThreshold();
            default:
                throw new IllegalArgumentException("Unknown comparison: " + comparison);
        }
    }
}

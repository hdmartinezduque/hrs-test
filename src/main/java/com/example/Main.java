package com.example;

import com.example.model.Reading;
import com.example.model.Result;
import com.example.model.Rule;
import com.example.parser.FileParser;
import com.example.parser.JsonParser;
import com.example.parser.ParserFactory;
import com.example.service.RuleEvaluator;
import com.example.util.HttpClientStub;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.fasterxml.jackson.databind.SerializationFeature;

//import java.io.File;
import java.nio.file.Paths;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        try {
            String readingsFile = System.getenv("READINGS_FILE");
            String rulesFile = System.getenv("RULES_FILE");

            if (readingsFile == null || rulesFile == null) {
                System.out.println("Missing environment variables READINGS_FILE and/or RULES_FILE.");
                return;
            }

            System.out.println("Readings File: " + readingsFile);
            System.out.println("Rules File: " + rulesFile);

            // Parse rules
            JsonParser rulesParser = new JsonParser();
            List<Rule> rules = rulesParser.parseRules(Paths.get("/code", rulesFile).toString());

            // Parse readings
            FileParser readingsParser = ParserFactory.getParser(readingsFile);
            List<Reading> readings = readingsParser.parse(Paths.get("/code", readingsFile).toString());

            // Evaluate
            RuleEvaluator evaluator = new RuleEvaluator();
            List<Result> results = evaluator.evaluate(readings, rules);

            // Simulate HTTP POST with HttpClientStub
            HttpClientStub httpClientStub = new HttpClientStub();
            httpClientStub.sendData(results);

            // Write to /code/results.json (already handled by HttpClientStub)
            // This is redundant since HttpClientStub already writes the file
            // mapper.writeValue(new File("/code/results.json"), results);

            System.out.println("Results written to /code/results.json");

        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
            e.printStackTrace();
        }
    }
}

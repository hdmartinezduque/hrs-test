package com.example.parser;

import com.example.model.Reading;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.example.model.Rule;

import java.nio.file.Paths;
import java.util.List;

public class JsonParser implements FileParser {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public List<Reading> parse(String filePath) throws Exception {
        return objectMapper.readValue(
                Paths.get(filePath).toFile(),
                new TypeReference<List<Reading>>() {}
        );
    }

    public List<Rule> parseRules(String filePath) throws Exception {
        return objectMapper.readValue(
                Paths.get(filePath).toFile(),
                new com.fasterxml.jackson.core.type.TypeReference<List<Rule>>() {}
        );
    }

}

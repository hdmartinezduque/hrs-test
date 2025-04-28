package com.example.parser;

import com.example.model.Reading;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.nio.file.Paths;
import java.util.List;

public class YamlParser implements FileParser {

    private final ObjectMapper objectMapper = new ObjectMapper(new YAMLFactory());

    @Override
    public List<Reading> parse(String filePath) throws Exception {
        return objectMapper.readValue(
                Paths.get(filePath).toFile(),
                new TypeReference<List<Reading>>() {}
        );
    }
}

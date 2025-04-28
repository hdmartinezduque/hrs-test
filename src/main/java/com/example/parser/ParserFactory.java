package com.example.parser;

public class ParserFactory {

    public static FileParser getParser(String filePath) throws IllegalArgumentException {
        if (filePath.endsWith(".json")) {
            return new JsonParser();
        } else if (filePath.endsWith(".yml") || filePath.endsWith(".yaml")) {
            return new YamlParser();
        } else {
            throw new IllegalArgumentException("Unsupported file format: " + filePath);
        }
    }
}
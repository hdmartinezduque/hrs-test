package com.example.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.example.model.Result;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class HttpClientStub {

    public void sendData(List<Result> results) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            
            String jsonPayload = objectMapper.writeValueAsString(results);
            
            System.out.println("Data Sync Success:");
            System.out.println(jsonPayload);
            
            saveToFile(jsonPayload);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void saveToFile(String data) {
        try {

            java.nio.file.Files.write(java.nio.file.Paths.get("results.json"), data.getBytes());
            Files.write(Paths.get("/code/results.json"), data.getBytes());
            //String resultContent = "Result File";
            //String outputPath = System.getenv().getOrDefault("OUTPUT_DIR", "/code") + "/result.json";
            //Files.writeString(Paths.get(outputPath), resultContent);

            try {
                Path path = Paths.get("/code/results.json");
                Files.write(path, data.getBytes());
                System.out.println("File results.json succesful: " + path.toAbsolutePath());
            } catch (IOException e) {
                System.err.println("Error file results.json: " + e.getMessage());
                e.printStackTrace();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

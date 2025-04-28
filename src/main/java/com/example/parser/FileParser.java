package com.example.parser;

import com.example.model.Reading;
import java.util.List;

public interface FileParser {

    List<Reading> parse(String filePath) throws Exception;

}

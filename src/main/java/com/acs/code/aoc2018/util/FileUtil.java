package com.acs.code.aoc2018.util;

import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class FileUtil {

    public static List<String> readStringList(String filePath){
        try {
            return Files.readAllLines(Paths.get(URI.create(filePath)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}

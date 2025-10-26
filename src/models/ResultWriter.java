package models;

import com.google.gson.*;
import java.io.FileWriter;
import java.util.*;

public class ResultWriter {
    public static void write(String file, List<Map<String, Object>> results) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try (FileWriter fw = new FileWriter(file)) {
            gson.toJson(Map.of("results", results), fw);
        } catch (Exception e) {
            System.out.println("Error writing output.json: " + e.getMessage());
        }
    }
}
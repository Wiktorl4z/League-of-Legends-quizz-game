package com.example.l4z.quizapp;

import android.content.res.AssetManager;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

public class FileHelper {

    private static String QUESTIONS_FILENAME = "questions.json";
    private static String DATABASE_FILENAME = "database.json";
    private AssetManager assets;

    public FileHelper(AssetManager assets) {
        this.assets = assets;
    }

    public List<Question2> getQuestions() {
        try {
            String json = getString(QUESTIONS_FILENAME);
            ObjectMapper mapper = new ObjectMapper();
            List<Question2> list = mapper.readValue(json, new TypeReference<List<Question2>>() {
            });
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public String[] getNames() {
        try {
            String json = getString(DATABASE_FILENAME);
            ObjectMapper mapper = new ObjectMapper();
            Map<String, String[]> map = mapper.readValue(json, new TypeReference<Map<String, String[]>>() {
            });
            return map.get("names");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private String getString(String filename) {
        String json;
        try {
            InputStream is = assets.open(filename);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }
}

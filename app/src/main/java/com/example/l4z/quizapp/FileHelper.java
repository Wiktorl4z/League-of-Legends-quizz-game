package com.example.l4z.quizapp;

import android.content.res.AssetManager;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class FileHelper {
    private static String QUESTIONS_FILENAME = "questions.json";
    private static String DATABASE_FILENAME = "database.json";
    private AssetManager assets;

    public FileHelper(AssetManager assets) {
        this.assets = assets;
    }

    public List<Question> getQuestions(){
        try {
        String json=getString(QUESTIONS_FILENAME);
        ObjectMapper mapper = new ObjectMapper();
        List<Question> list = mapper.readValue(json, new TypeReference<List<Question>>(){});
        return list;
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

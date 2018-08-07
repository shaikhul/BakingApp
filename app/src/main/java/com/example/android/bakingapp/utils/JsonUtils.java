package com.example.android.bakingapp.utils;

import com.example.android.bakingapp.models.Recipe;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.Collection;
import java.util.List;

public class JsonUtils {

    public static List<Recipe> deserializeRecipesJson(String recipes_json) {
        Gson gson = new Gson();
        Type collectionType = new TypeToken<Collection<Recipe>>(){}.getType();
        return gson.fromJson(recipes_json, collectionType);
    }
}

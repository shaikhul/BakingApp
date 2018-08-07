package com.example.android.bakingapp;

import com.example.android.bakingapp.models.Recipe;
import com.example.android.bakingapp.utils.JsonUtils;
import com.example.android.bakingapp.utils.NetworkUtils;

import java.io.IOException;
import java.util.List;

public class RecipeService {

    public List<Recipe> fetch() {
        String url = "https://d17h27t6h515a5.cloudfront.net/topher/2017/May/59121517_baking/baking.json";
        try {
            String response = NetworkUtils.get(url);
            return JsonUtils.deserializeRecipesJson(response);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}

package com.example.android.bakingapp;

import com.example.android.bakingapp.models.Recipe;

import java.util.List;

public class RecipeRepository {

    public List<Recipe> getAll() {
        return new RecipeService().fetch();
    }
}

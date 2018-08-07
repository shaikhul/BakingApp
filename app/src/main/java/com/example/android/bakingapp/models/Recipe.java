package com.example.android.bakingapp.models;

import java.util.List;

public class Recipe {
    int id;
    String name;
    List<Ingredient> ingredients;
    List<RecipeStep> steps;
    int servings;
    String image;

    public Recipe() {
    }

    public Recipe(int id, String name, int servings, String image) {
        this.id = id;
        this.name = name;
        this.servings = servings;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public List<RecipeStep> getSteps() {
        return steps;
    }

    public int getServings() {
        return servings;
    }

    public String getImage() {
        return image;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public void setSteps(List<RecipeStep> steps) {
        this.steps = steps;
    }
}

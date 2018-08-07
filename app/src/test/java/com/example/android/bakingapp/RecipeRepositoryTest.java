package com.example.android.bakingapp;

import com.example.android.bakingapp.models.Recipe;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import java.util.List;

public class RecipeRepositoryTest {

    private RecipeRepository recipeRepository;

    @Before
    public void setup() {
        recipeRepository = new RecipeRepository();
    }

    @Test
    public void test_getAll() {
        List<Recipe> recipes = recipeRepository.getAll();
        assertEquals(4, recipes.size());
    }
}

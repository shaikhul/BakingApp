package com.example.android.bakingapp;

import com.example.android.bakingapp.models.Ingredient;
import com.example.android.bakingapp.models.Recipe;
import com.example.android.bakingapp.models.RecipeStep;
import com.example.android.bakingapp.utils.JsonUtils;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class JsonUtilsTest {
    private Gson gson;

    @Before
    public void setup() {
        gson = new Gson();
    }

    @Test
    public void testDeserializeRecipesJson() {
        RecipeStep step = new RecipeStep(1, "Recipe Introduction", "Recipe Introduction", "foobar.com", "");


        String step_json = gson.toJson(step);

        assertEquals("{\"id\":1,\"shortDescription\":\"Recipe Introduction\",\"description\":\"Recipe Introduction\",\"videoURL\":\"foobar.com\",\"thumbnailURL\":\"\"}", step_json);

        Ingredient ingredient = new Ingredient(1, "CUP", "Graham Cracker crumbs");
        String ingredient_json = gson.toJson(ingredient);
        assertEquals("{\"quantity\":1,\"measure\":\"CUP\",\"ingredient\":\"Graham Cracker crumbs\"}", ingredient_json);

        Recipe recipe = new Recipe(1, "Nutella Pie", 8, "");
        List<RecipeStep> steps = new ArrayList<>();
        steps.add(step);
        recipe.setSteps(steps);

        List<Ingredient> ingredients = new ArrayList<>();
        ingredients.add(ingredient);
        recipe.setIngredients(ingredients);

        String recipe_json = gson.toJson(recipe);
        assertEquals("{\"id\":1,\"name\":\"Nutella Pie\",\"ingredients\":[{\"quantity\":1,\"measure\":\"CUP\",\"ingredient\":\"Graham Cracker crumbs\"}],\"steps\":[{\"id\":1,\"shortDescription\":\"Recipe Introduction\",\"description\":\"Recipe Introduction\",\"videoURL\":\"foobar.com\",\"thumbnailURL\":\"\"}],\"servings\":8,\"image\":\"\"}", recipe_json);

        Recipe recipe_from_json = gson.fromJson(recipe_json, Recipe.class);
        assertEquals(recipe.getId(), recipe_from_json.getId());

        // collection of recipes
        List<Recipe> recipes = new ArrayList<>();
        recipes.add(recipe);

        String recipes_json = gson.toJson(recipes);
        assertEquals("[{\"id\":1,\"name\":\"Nutella Pie\",\"ingredients\":[{\"quantity\":1,\"measure\":\"CUP\",\"ingredient\":\"Graham Cracker crumbs\"}],\"steps\":[{\"id\":1,\"shortDescription\":\"Recipe Introduction\",\"description\":\"Recipe Introduction\",\"videoURL\":\"foobar.com\",\"thumbnailURL\":\"\"}],\"servings\":8,\"image\":\"\"}]", recipes_json);

        List<Recipe> recipes_from_json = JsonUtils.deserializeRecipesJson(recipes_json);
        assertEquals(recipes.size(), recipes_from_json.size());
    }
}

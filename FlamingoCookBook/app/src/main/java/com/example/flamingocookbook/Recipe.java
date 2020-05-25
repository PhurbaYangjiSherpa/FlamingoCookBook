package com.example.flamingocookbook;

public class Recipe {

    private String recipe_title_ID;
    private String recipe_title;
    private String recipe_ingredients;
    private String recipe_time;
    private String recipe_description;
    private String recipe_directions;

    //default constructor for firebase
    public Recipe() {
    }


    //parameterized constructor

    public Recipe(String recipe_title_ID, String recipe_title, String recipe_ingredients, String recipe_time, String recipe_description, String recipe_directions) {
        this.recipe_title_ID = recipe_title_ID;
        this.recipe_title = recipe_title;
        this.recipe_ingredients = recipe_ingredients;
        this.recipe_time = recipe_time;
        this.recipe_description = recipe_description;
        this.recipe_directions = recipe_directions;
    }

    //getter

    public String getRecipe_title_ID() {
        return recipe_title_ID;
    }

    public String getRecipe_title() {
        return recipe_title;
    }

    public String getRecipe_ingredients() {
        return recipe_ingredients;
    }

    public String getRecipe_time() {
        return recipe_time;
    }

    public String getRecipe_description() {
        return recipe_description;
    }

    public String getRecipe_directions() {
        return recipe_directions;
    }
}

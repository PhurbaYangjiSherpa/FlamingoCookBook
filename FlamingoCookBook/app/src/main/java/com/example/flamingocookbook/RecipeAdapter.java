package com.example.flamingocookbook;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class RecipeAdapter extends ArrayAdapter<Recipe> {

    //variables
    private Activity context;
    private List<Recipe> recipeList;


    public RecipeAdapter(Activity context, List<Recipe> recipeList) {
        super(context,R.layout.item_layout,recipeList);
        this.context = context;
        this. recipeList = recipeList;

    }
    //function
    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View view = inflater.inflate(R.layout.item_layout,null,true);

        TextView tvTitle = view.findViewById(R.id.title_id);
        TextView tvIngredients = view.findViewById(R.id.ingredients_id);
        TextView tvTime = view.findViewById(R.id.spin_time_id);
        TextView tvDescription = view.findViewById(R.id.description_id);
        TextView tvDirections = view.findViewById(R.id.directions_id);

        Recipe obj = recipeList.get(position);
        tvTitle.setText(obj.getRecipe_title());
        tvIngredients.setText(obj.getRecipe_ingredients());
        tvTime.setText(obj.getRecipe_time());
        tvDescription.setText(obj.getRecipe_description());
        tvDirections.setText(obj.getRecipe_directions());



        return view;
    }
}

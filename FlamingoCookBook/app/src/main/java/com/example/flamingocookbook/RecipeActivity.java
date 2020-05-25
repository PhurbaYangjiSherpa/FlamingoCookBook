package com.example.flamingocookbook;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class RecipeActivity extends AppCompatActivity {

    private EditText recipe_title, recipe_ingredients, recipe_description, recipe_directions;
    private ListView lv;
    private Spinner spin_time;
    private DatabaseReference databaseRef;
    private List<Recipe> listRecipe;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe);

        recipe_title = findViewById(R.id.title_id);
        recipe_ingredients = findViewById(R.id.ingredients_id);
        recipe_description = findViewById(R.id.description_id);
        recipe_directions = findViewById(R.id.directions_id);
        spin_time = findViewById(R.id.spin_time_id);
        lv = findViewById(R.id.recipe_list);

        listRecipe = new ArrayList<>();
        databaseRef = FirebaseDatabase.getInstance().getReference("Recipe");
    }

    @Override
    protected void onStart() {
        super.onStart();

        databaseRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                for (DataSnapshot recipeSnapshot : dataSnapshot.getChildren()){

                    Recipe recipeObj = recipeSnapshot.getValue(Recipe.class);
                    listRecipe.add(recipeObj);
                }

                //adapter setting

                RecipeAdapter adapter = new RecipeAdapter(RecipeActivity.this,listRecipe);
                lv.setAdapter(adapter);
                //if firebase root access is done
                Toast.makeText(RecipeActivity.this, "Firebase database accessible", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(RecipeActivity.this, "Firebase database not accessible", Toast.LENGTH_SHORT).show();

            }
        });

    }

    public void post(View view) {
        //to push data in firebase

        String recipeTitle = recipe_title.getText().toString();
        String recipeDescription = recipe_description.getText().toString();
        String recipeIngredients = recipe_ingredients.getText().toString();
        String recipeDirections = recipe_directions.getText().toString();
        String spinTime = spin_time.getSelectedItem().toString();


        if (TextUtils.isEmpty(recipeTitle)){
            Toast.makeText(this, "Recipe title is empty", Toast.LENGTH_SHORT).show();
            return;
        }
        else
        {
            //firebase
            String id = databaseRef.push().getKey();
            Recipe recipeObj = new Recipe(id, recipeTitle, recipeDescription, recipeIngredients, recipeDirections, spinTime);
            databaseRef.child(id).setValue(recipeObj);
            Toast.makeText(this, "Recipe added to firebase Database", Toast.LENGTH_SHORT).show();
        }

    }
}

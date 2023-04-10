package org.eronen.viikko11;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class AddGroceriesActivity extends AppCompatActivity {

    private EditText textGroceries;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_groceries);

        textGroceries = findViewById(R.id.editTextAddGroceries);

    }

    public void addGrocery(View view) {
        GroceryList.getInstance().addGrocery(new Grocery(textGroceries.getText().toString(), Grocery.groceryCounter));

    }

    public void switchToMain(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }


}
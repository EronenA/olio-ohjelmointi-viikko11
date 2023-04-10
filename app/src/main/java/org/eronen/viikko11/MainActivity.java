package org.eronen.viikko11;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    GroceriesListAdapter adapter;
    private boolean sortedById = true;
    Button btnSort;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GroceryList gl = GroceryList.getInstance();

        recyclerView = findViewById(R.id.rvGroceriesList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new GroceriesListAdapter(getApplicationContext(), gl.getGroceries());
        recyclerView.setAdapter(adapter);

        btnSort = findViewById(R.id.btnSortList);

    }

    @Override
    public void onResume() {
        super.onResume();
        adapter.notifyDataSetChanged();
    }

    public void switchToAddGroceries(View view) {
        Intent intent = new Intent(this, AddGroceriesActivity.class);
        startActivity(intent);
    }

    public void sortList(View view) {
        if (sortedById == true) {
            GroceryList.getInstance().sortByAlphabet();
            sortedById = false;
            btnSort.setText("Aakkosjärjestys");
        } else {
            GroceryList.getInstance().sortById();
            sortedById = true;
            btnSort.setText("Aikajärjestys");
        }

        adapter.notifyDataSetChanged();

    }


}
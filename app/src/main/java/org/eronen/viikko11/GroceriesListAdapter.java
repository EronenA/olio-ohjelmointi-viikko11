package org.eronen.viikko11;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class GroceriesListAdapter extends RecyclerView.Adapter<GroceriesViewHolder> {

    private Context context;
    private ArrayList<Grocery> groceries = new ArrayList<>();

    public GroceriesListAdapter(Context context, ArrayList<Grocery> groceries) {
        this.context = context;
        this.groceries = groceries;
    }

    @NonNull
    @Override
    public GroceriesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new GroceriesViewHolder(LayoutInflater.from(context).inflate(R.layout.groceries_view, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull GroceriesViewHolder holder, int position) {
        holder.groceriesName.setText(groceries.get(position).getName());
        holder.editGroceriesName.setText(groceries.get(position).getName());

        holder.removeImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int pos = holder.getAdapterPosition();
                GroceryList.getInstance().removeGroceries(pos);
                notifyItemRemoved(pos);
            }
        });

        holder.editImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int pos = holder.getAdapterPosition();

                if (holder.editGroceriesName.getVisibility() == View.VISIBLE) {
                    Grocery grocery = GroceryList.getInstance().getGroceryById(pos);
                    grocery.setName(holder.editGroceriesName.getText().toString());
                    holder.editGroceriesName.setVisibility(View.GONE);
                    notifyDataSetChanged();
                }
                else {
                    holder.editGroceriesName.setVisibility(View.VISIBLE);
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return groceries.size();
    }

}

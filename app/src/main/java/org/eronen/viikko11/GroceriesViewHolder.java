package org.eronen.viikko11;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class GroceriesViewHolder extends RecyclerView.ViewHolder {

    TextView groceriesName;
    ImageView removeImage, editImage;
    EditText editGroceriesName;

    public GroceriesViewHolder(@NonNull View itemView){
        super(itemView);
        groceriesName = itemView.findViewById(R.id.txtGroceries);
        removeImage = itemView.findViewById(R.id.imgDelete);
        editImage = itemView.findViewById(R.id.imgEdit);
        editGroceriesName = itemView.findViewById(R.id.editTextGroceries);


    }

}

package com.example.myFragments;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerViewHolder extends RecyclerView.ViewHolder {
    TextView textView;



    public RecyclerViewHolder(@NonNull View itemView) {
        super(itemView);

        textView = itemView.findViewById(R.id.viewholder_text);
    }

    void setText(String s){
        textView.setText(s);
    }
}

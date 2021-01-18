package com.example.workshopsorter;


import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class NameViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
    private TextView tv_with_Name;


    private NameClick clickListener;


    public NameViewHolder(@NonNull View itemView, NameClick listener){
        super(itemView);
        this.clickListener=listener;
        tv_with_Name=itemView.findViewById(R.id.tvName);

        itemView.setOnClickListener(this);
    }

    public void setName(String name){
        tv_with_Name.setText(name);
    }

    @Override
    public void onClick(View view){

        clickListener.onNameClick(getAdapterPosition());
    }
}
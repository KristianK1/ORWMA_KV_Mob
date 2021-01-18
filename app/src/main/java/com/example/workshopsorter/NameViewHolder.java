package com.example.workshopsorter;


import android.view.View;
import android.view.ViewParent;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

public class NameViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
    private TextView tv_with_Name;
    private Button b_plus;
    private Button b_minus;

    private NameButtonClick clickListener;


    public NameViewHolder(@NonNull View itemView, NameButtonClick listener){
        super(itemView);
        this.clickListener=listener;
        tv_with_Name=itemView.findViewById(R.id.tvName);
        b_plus=itemView.findViewById(R.id.b_plus);
        b_minus=itemView.findViewById(R.id.b_minus);
        b_plus.setOnClickListener(this);
    }

    public void setName(String name){
        tv_with_Name.setText(name);
    }

    @Override
    public void onClick(View view){
        clickListener.onNameClick(getAdapterPosition());
    }
}
package com.example.workshopsorter;


import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class NameViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
    private TextView tv_with_Name;
    private NameClick clicklistener;




    public NameViewHolder(@NonNull View itemView, NameClick listener){
        super(itemView);
        this.clicklistener=listener;
        tv_with_Name=itemView.findViewById(R.id.tvName);
        itemView.setOnClickListener(this);
    }

    public void setName(String name){
        tv_with_Name.setText(name);
    }


    @Override
    public void onClick(View view){
        clicklistener.onNameClick(getAdapterPosition());
        //treba otvoriti novi ekran sa pojedinostima
    }

}
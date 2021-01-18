package com.example.workshopsorter;

import android.content.SharedPreferences;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class search_activity {
    private RecyclerView recycler;
    private RecyclerAdapter Adapter;
    private EditText searchText;
    private Button searchButton;

    private void setupRecycler(){
        recycler=findViewById(R.id.rvLista);
        recycler.setLayoutManager(new LinearLayoutManager(this));
        Adapter= new RecyclerAdapter(this);
        recycler.setAdapter(Adapter);
    }

    private void setupRecyclerData(){
        SharedPreferences mPrefs = getSharedPreferences("label", 0);
        int number_of_components = mPrefs.getInt("tag", 0);
        Toast.makeText(getBaseContext(), "lol"+number_of_components, Toast.LENGTH_LONG).show();
        //Toast.makeText(this, "ojjj", Toast.LENGTH_SHORT).show();
        if(number_of_components==0){
            complete_list.add(new Component("Otpornik 220Ω"));
            complete_list.add(new Component("Otpornik 230Ω"));
            complete_list.add(new Component("Otpornik 240Ω"));
            complete_list.add(new Component("Otpornik 250Ω"));
            complete_list.add(new Component("Otpornik 260Ω"));
        }
        else{
            complete_list=Load_state();
        }
        Adapter.addData(complete_list);
    }

    public void addCell(View view){
        Adapter.addNewCell(new Component("Otpornik 700"), this.Adapter.getItemCount());
        complete_list.add(new Component("Otpornik 700"));
    }


    public void search_button_pressed(View view){
        String text=searchText.getText().toString();
        Adapter.ClearAll();

        List<Component> found = new ArrayList<>();
        for(int i=0;i<complete_list.size();i++){
            if(complete_list.get(i).getName().contains(text)){
                found.add(complete_list.get(i));
            }
        }
        Adapter.addData(found);
    }

    public void removeCell(int position) {
        //Adapter.removeCell(position);
    }


    public void onNameClick(int position){
        Toast.makeText(this, "pozicija"+position, Toast.LENGTH_SHORT).show();
        //openCell(position);
    }



}

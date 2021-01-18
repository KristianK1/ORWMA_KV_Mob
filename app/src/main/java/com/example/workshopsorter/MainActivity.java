package com.example.workshopsorter;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity implements NameClick{
    List<Component> complete_list=new ArrayList<>();
    private ViewPager mViewPager;
    private TabLayout mTabLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_activity);
        setupRecycler();
        setupRecyclerData();
        this.searchText=(EditText) findViewById(R.id.edit_search);
        this.searchButton=(Button) findViewById(R.id.button_search);
    }


    public void onPause() {
        save_state();
        Toast.makeText(getApplicationContext(), "onPause called", Toast.LENGTH_LONG).show();
        super.onPause();

    }





    public void save_state(){
        int number_of_components=complete_list.size();
        List<Component> list=complete_list;
        //Toast.makeText(getBaseContext(), "Number of saved:" + number_of_components, Toast.LENGTH_LONG).show();

        SharedPreferences mPrefs=getSharedPreferences("label", 0);

        SharedPreferences.Editor mEditor = mPrefs.edit();
        mEditor.putInt("tag", number_of_components).commit();
        for(int i=0;i<number_of_components;i++){
            mEditor.putString("tag"+i+"_name", list.get(i).getName()).commit();
            mEditor.putString("tag"+i+"_location", list.get(i).getLocation()).commit();
            mEditor.putString("tag"+i+"_link", list.get(i).getLink()).commit();
            mEditor.putString("tag"+i+"_group", list.get(i).getGroup()).commit();
            mEditor.putInt("tag"+i+"_quantity", list.get(i).getQuantity()).commit();
        }
        mEditor.commit();
        //Load_state();
    }

    public void setupAppData() {
        SharedPreferences mPrefs = getSharedPreferences("label", 0);
        int number_of_components = mPrefs.getInt("tag", 0);
        Toast.makeText(getBaseContext(), "lol" + number_of_components, Toast.LENGTH_LONG).show();
        //Toast.makeText(this, "ojjj", Toast.LENGTH_SHORT).show();
        if (number_of_components == 0) {
            complete_list.add(new Component("Otpornik 220Ω"));
            complete_list.add(new Component("Otpornik 230Ω"));
            complete_list.add(new Component("Otpornik 240Ω"));
            complete_list.add(new Component("Otpornik 250Ω"));
            complete_list.add(new Component("Otpornik 260Ω"));
        } else {
            complete_list = Load_state();
        }
    }
    public List<Component> Load_state(){
        List<Component> list = new ArrayList<>();

        SharedPreferences mPrefs = getSharedPreferences("label", 0);
        int number_of_components = mPrefs.getInt("tag", 0);
        //Toast.makeText(getBaseContext(), "number of loaded: "+number_of_components, Toast.LENGTH_LONG).show();
        for(int i=0;i<number_of_components;i++){
            Component load = new Component("");
            load.setName(mPrefs.getString("tag"+i+"_name", ""));
            load.setLocation(mPrefs.getString("tag"+i+"_location", ""));
            load.setLink(mPrefs.getString("tag"+i+"_link", ""));
            load.setGroup(mPrefs.getString("tag"+i+"_group", ""));
            load.setQuantity(mPrefs.getInt("tag"+i+"_quantity", 0));
            list.add(load);
        }
        return list;
    }
}
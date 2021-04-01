package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ImageView search_img;
    RecyclerView recyclerView;
    Spinner spinner;

    BedroomAdapter bedroomAdapter;
    List<BedroomUtil> bedroomUtilList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        search_img = findViewById(R.id.search_img);
        recyclerView = findViewById(R.id.recycler_view);
        spinner = (Spinner) findViewById(R.id.spinner);

        LinearLayoutManager layout = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(layout);
        recyclerView.setHasFixedSize(false);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        bedroomUtilList = new ArrayList<>();

        bedroomUtilList.add(new BedroomUtil("Sofa Baleria", "$849", ""));
        bedroomUtilList.add(new BedroomUtil("Dining Table", "$949", ""));
        bedroomUtilList.add(new BedroomUtil("Fabric Sofa", "$999", ""));
        bedroomUtilList.add(new BedroomUtil("Sofa Baleria", "$749", ""));
        bedroomUtilList.add(new BedroomUtil("Dining Table", "$249", ""));

        bedroomAdapter = new BedroomAdapter(MainActivity.this, bedroomUtilList);
        recyclerView.setAdapter(bedroomAdapter);

        // Spinner Drop down items
        List<String> categories = new ArrayList<String>();
        categories.add("Gurgaan");
        categories.add("Bedroom");
        categories.add("Sofa");

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories);

        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(dataAdapter);


        search_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}
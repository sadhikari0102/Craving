package com.example.powerhouse.craving;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("MainAct", "Before Gridview!");
        GridView gridview = (GridView) findViewById(R.id.gridview);
        Log.d("MainAct", "in Between!!");
        gridview.setAdapter(new ImageAdapter(this));
        Log.d("MainAct", "Gridview Initialized !!");
        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                Toast.makeText(getApplicationContext(), "clicked " + position, Toast.LENGTH_SHORT).show();
            }
        });


    }
}

package com.example.truthanddare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;


public class Truth extends AppCompatActivity {
    DataBaseHelper myDb;
    Button btnAdd;
    ArrayList<String> list = new ArrayList<String>();

    EditText atruthToSave;
    //= (EditText) findViewById(R.id.writeATruthToSave);

    //public static ArrayList<String> truthList1 = new ArrayList<>();


    // Button addATruth = findViewById(R.id.addToButton);



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_truth);

        atruthToSave = (EditText) findViewById(R.id.writeATruthToSave);
        btnAdd = (Button) findViewById(R.id.addToButton);

        myDb = new DataBaseHelper(this);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String entry = atruthToSave.getText().toString();
                if(entry.length() !=0){
                    addData(entry);
                    atruthToSave.setText(" ");
                }else{
                    Toast.makeText(Truth.this,"you must put something in the text field",Toast.LENGTH_LONG).show();
                }
            }
        });

        showList();






    }
    public void showList(){
        ListView listView = (ListView)findViewById(R.id.truthListView);
        myDb = new DataBaseHelper(this);

        list = new ArrayList<String>();

        Cursor data = myDb.getListContents();

        if(data.getCount() ==0){
            Toast.makeText(Truth.this,"The Database was empty",Toast.LENGTH_LONG).show();
        }else{
            while(data.moveToNext()){
                list.add(data.getString(1));
            }
        }

        ListAdapter arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list);

        listView.setAdapter(arrayAdapter);
    }

    public void addData(String newEntry){
        boolean insetData = myDb.addData(newEntry);

        if(insetData){
            Toast.makeText(Truth.this,"SuccesFully Entered Data!",Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(Truth.this,"Something went wrong",Toast.LENGTH_LONG).show();

        }
    }


    }



package com.example.truthanddare;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class Dare extends AppCompatActivity {

       DataBaseHelper2 myDb;
        Button btnAdd;
        ArrayList<String> list = new ArrayList<String>();

        EditText editText;
        //= (EditText) findViewById(R.id.writeATruthToSave);

        //public static ArrayList<String> truthList1 = new ArrayList<>();


        // Button addATruth = findViewById(R.id.addToButton);



        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_dare);


            editText = (EditText) findViewById(R.id.editTextDare);
            btnAdd = (Button) findViewById(R.id.addDareButton);

            myDb = new DataBaseHelper2(this);

            btnAdd.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String entry = editText.getText().toString();
                    if(entry.length() !=0){
                        addData(entry);
                        editText.setText(" ");
                    }else{
                        Toast.makeText(Dare.this,"you must put something in the text field",Toast.LENGTH_LONG).show();
                    }
                }
            });

            showList();






        }

        public void showList(){
            ListView listView = (ListView)findViewById(R.id.dareListView);
            myDb = new DataBaseHelper2(this);

            list = new ArrayList<String>();

            Cursor data = myDb.getListContents();

            if(data.getCount() ==0){
                Toast.makeText(Dare.this,"The Database was empty",Toast.LENGTH_LONG).show();
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
                Toast.makeText(Dare.this,"SuccesFully Entered Data!",Toast.LENGTH_LONG).show();
            }else{
                Toast.makeText(Dare.this,"Something went wrong",Toast.LENGTH_LONG).show();

            }
        }



    }



package com.example.truthanddare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;

public class MainActivity extends AppCompatActivity  {


    public void BottleScreen(View view){
        Intent intent = new Intent(getApplicationContext(), GameScreen.class);

        startActivity(intent);
    }
    public void truthDare(View view){
        Intent intent2 = new Intent(getApplicationContext(), Truth.class);

        startActivity(intent2);
    }

    public void truthDare2(View view){
        Intent intent2 = new Intent(getApplicationContext(), Dare.class);

        startActivity(intent2);
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }


}
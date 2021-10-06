package com.example.truthanddare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Random;

public class GameScreen extends AppCompatActivity  {

    Button bSpin;
    ImageView bottle;
    Button dare;
    Button truth;
    private int lastDirection;
    private MediaPlayer mp;


    private Random random = new Random();
    ImageView imgView;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_screen);

        truth = (Button) findViewById(R.id.showTurthListButton);

        dare = findViewById(R.id.showsDareListButton);

        bSpin = (Button) findViewById(R.id.spinButton);

        bottle = (ImageView) findViewById(R.id.imageView3);

        imgView = findViewById(R.id.imageView3);

//        bSpin.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                int spinDegrees;
//
//                Random r = new Random();
//
//                spinDegrees = r.nextInt(3600);
//
//
//                RotateAnimation rotateBottle = new RotateAnimation(0, spinDegrees,
//                        Animation.RELATIVE_TO_SELF, 0.5f,
//                        Animation.RELATIVE_TO_SELF, 0.5f
//                );
//                rotateBottle.setDuration(2000);
//                rotateBottle.setFillAfter(true);
//
//                rotateBottle.setInterpolator(new AccelerateDecelerateInterpolator());
//                bottle.startAnimation(rotateBottle);

                dare.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(new Intent(getApplicationContext(),Dare.class));
                    }
                });

                truth.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(new Intent(getApplicationContext(),Truth.class));
                    }
                });
            }



@Override
protected void onResume() {
        super.onResume();
        truth.setEnabled(false);
        dare.setEnabled(false);
        bSpin.setEnabled(true);
        }

public void spin(View view) {

        int newDirection = random.nextInt(5400);
        float pivotX = imgView.getWidth()/2;
        float pivotY = imgView.getHeight()/2;

        Animation rotate = new RotateAnimation(lastDirection, newDirection, pivotX, pivotY);
        rotate.setDuration(2000);
        rotate.setFillAfter(true);
        rotate.setAnimationListener(new Animation.AnimationListener() {
@Override
public void onAnimationStart(Animation animation) {
    mp = MediaPlayer.create(GameScreen.this, R.raw.audio);
    mp.start();
        bSpin.setEnabled(false);
        }

@Override
public void onAnimationEnd(Animation animation) {
    mp.stop();
    mp.release();
    mp = null;
        truth.setEnabled(true);
        dare.setEnabled(true);
        }

@Override
public void onAnimationRepeat(Animation animation) {
        }
        });
        lastDirection = newDirection;
        imgView.startAnimation(rotate);
        }



//public void truthList(View view){
//        Intent intent = new Intent(getApplicationContext(), Truth.class);
//
//        startActivity(intent);
//    }
//
//    public void DareList(View view){
//        Intent intent = new Intent(getApplicationContext(), Dare.class);
//
//        startActivity(intent);
//    }
}


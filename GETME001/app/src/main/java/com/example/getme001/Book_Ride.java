package com.example.getme001;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

public class Book_Ride extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_ride);
        int Book_Ride_id = R.id.book_ride; //id of
        int rotor_id = R.anim.rot; //id of rotor
        Rotate(Book_Ride_id,rotor_id); // calling Rotate Method to Rotate this View
    }
    public void  Rotate(int id_page, int id_rot)
    {
        Animation rotation = AnimationUtils.loadAnimation(this, id_rot); // Resource in res>anim>rot.xml
        rotation.setRepeatCount(Animation.INFINITE);
        View rot = findViewById(id_page); // getting view to be Rotated e.g R.id.book_ride
        rot.setScaleX(77);
        rot.setScaleY(77);
        rot.startAnimation(rotation);
    }
}

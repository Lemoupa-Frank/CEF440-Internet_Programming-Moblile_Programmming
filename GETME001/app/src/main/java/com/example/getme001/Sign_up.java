package com.example.getme001;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

public class Sign_up extends AppCompatActivity {

    Button verify_butt; Button skip_butt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        verify_butt = findViewById(R.id.verify_signup);
        skip_butt = findViewById(R.id.skip_button);
        verify_butt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog verify_dial;
                verify_dial = openDialog();
                verify_dial.show();
                Display display = getWindowManager().getDefaultDisplay();
                Point size = new Point();
                display.getSize(size);
                int width = size.x;
                int height = size.y;
                verify_dial.getWindow().setLayout(5*(width)/7,5*(height)/7);
                verify_dial.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            }
        });
        skip_butt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Dashboard_intent = new Intent(Sign_up.this, Dashboard.class);
                startActivity(Dashboard_intent);
            }
        });
    }
    public Dialog openDialog() {
        //Define Dialog
        final Dialog dialog = new Dialog(Sign_up.this);
        dialog.setContentView(R.layout.verify_num);
        return dialog;
    }
}
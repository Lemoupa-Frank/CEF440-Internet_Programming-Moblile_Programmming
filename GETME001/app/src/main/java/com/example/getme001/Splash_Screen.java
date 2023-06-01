package com.example.getme001;

import static android.os.SystemClock.sleep;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.splashscreen.SplashScreen;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnticipateInterpolator;

public class Splash_Screen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        SplashScreen.installSplashScreen(Splash_Screen.this);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            getSplashScreen().setOnExitAnimationListener(splashScreenView -> {
                final ObjectAnimator slideUp = ObjectAnimator.ofFloat(
                        splashScreenView,
                        View.TRANSLATION_Y,
                        0f,
                        -splashScreenView.getHeight()
                );
                slideUp.setInterpolator(new AnticipateInterpolator());
                slideUp.setDuration(1800L);
                // Call SplashScreenView.remove at the end of your custom animation.
                slideUp.addListener(new AnimatorListenerAdapter() {
                    @RequiresApi(api = Build.VERSION_CODES.S)
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        splashScreenView.remove();
                    }
                });

                // Run your animation.
                slideUp.start();
            });
        }
        else sleep(1800);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        Intent sign_up = new Intent(Splash_Screen.this, Sign_up.class);
        startActivity(sign_up);
    }
}
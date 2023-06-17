package Activity.Activity;

import static android.os.SystemClock.sleep;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.AnticipateInterpolator;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.splashscreen.SplashScreen;

import com.example.getme001.R;

public class Splash_Screen extends AppCompatActivity {
    private static int SPLASH_SCREEN = 2500;
    ImageView imageview;
    TextView text1,text2;
    Animation top,bottom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        imageview = findViewById(R.id.imageview);
        text1 = findViewById(R.id.text1);
        text2 = findViewById(R.id.text2);

        top = AnimationUtils.loadAnimation(this, R.anim.top);
        bottom = AnimationUtils.loadAnimation(this, R.anim.bottom);

        imageview.setAnimation(top);
        text1.setAnimation(bottom);
        text2.setAnimation(bottom);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(Splash_Screen.this, Sign_up.class);
                startActivity(intent);
                finish();
            }
        },SPLASH_SCREEN);
    }
}
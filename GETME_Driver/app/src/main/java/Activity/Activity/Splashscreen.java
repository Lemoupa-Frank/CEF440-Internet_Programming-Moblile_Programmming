package Activity.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import com.example.getme_driver.R;

public class Splashscreen extends AppCompatActivity {
    private static int SPLASH_TIME_OUT = 5000;
    Animation top,bottom,middle;
    View first,second,third,fouth,fifth,sixth,seventh;
    TextView a,slogan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.splashscreen);
        top= AnimationUtils.loadAnimation(this, R.anim.top);
        bottom= AnimationUtils.loadAnimation(this, R.anim.bottom);
        middle= AnimationUtils.loadAnimation(this, R.anim.middle);

        //Hooks
       first=findViewById(R.id.firstline);
       second=findViewById(R.id.secondline);
       third=findViewById(R.id.thirdline);
       fouth=findViewById(R.id.fouthline);
       fifth=findViewById(R.id.fifthline);
       sixth=findViewById(R.id.sixthline);
       seventh=findViewById(R.id.seventhline);

       a= findViewById(R.id.a);
       slogan= findViewById(R.id.slogan);

       first.setAnimation(top);
       second.setAnimation(top);
       third.setAnimation(top);
        fouth.setAnimation(top);
        fifth.setAnimation(top);
        sixth.setAnimation(top);
        seventh.setAnimation(top);

        a.setAnimation(middle);
        slogan.setAnimation(bottom);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent=new Intent(Splashscreen.this, Login.class);
                startActivity(intent);
                finish();
            }
        },SPLASH_TIME_OUT);
    }
}
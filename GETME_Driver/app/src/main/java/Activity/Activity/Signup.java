package Activity.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.getme_driver.R;

public class Signup extends AppCompatActivity {
    TextView signup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        EditText fname,lname,phone_num,companyname,licence_nu,carplate, enterpass, confirmpass;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);
        // Find the "Sign up" button and add a click listener
        signup= findViewById(R.id.signuptolog);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start the SignupActivity
                Intent intent = new Intent(Signup.this, Login.class);
                startActivity(intent);
            }
        });

    }
}
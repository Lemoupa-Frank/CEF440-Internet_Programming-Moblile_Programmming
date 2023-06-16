package Activity.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.getme_driver.R;

public class Signup extends AppCompatActivity {
    TextView LOG; Button signup;
    EditText fname,lname,phone_num,companyname,licence_nu,carplate, enterpass, confirmpass;
    String Sfname,Slname,Sphone_num,Scompanyname,Slicence_nu,Scarplate, Senterpass, Sconfirmpass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);
        fname = findViewById(R.id.firstname);
        lname = findViewById(R.id.lastname);
        phone_num = findViewById(R.id.phone_number);
        companyname = findViewById(R.id.companyname);
        licence_nu = findViewById(R.id.uploadlicence);
        carplate = findViewById(R.id.carplate);
        enterpass = findViewById(R.id.enter_pass);
        confirmpass = findViewById(R.id.confirmpass);

        // Find the "Sign up" button and add a click listener
        signup = findViewById(R.id.signupbtn);
        LOG= findViewById(R.id.log);
        LOG.setOnClickListener(v -> {
            // Start the SignupActivity
            Intent intent = new Intent(Signup.this, Login.class);
            startActivity(intent);
        });
        signup.setOnClickListener( s ->
        {
            Sfname = fname.getText().toString();
            Slname = lname.getText().toString();
            Sphone_num = phone_num.getText().toString();
            Scompanyname = companyname.getText().toString();
            Slicence_nu = licence_nu.getText().toString();
            Scarplate = carplate.getText().toString();
            Senterpass = enterpass.getText().toString();
            Sconfirmpass = confirmpass.getText().toString();
            if(Sfname.length() > 0 && Slname.length() > 0 && Sphone_num.length() > 0 && Scompanyname.length() > 0 && Slicence_nu.length() > 0 && Scarplate.length() > 0 && Senterpass.length() > 0 && Sconfirmpass.length() > 0 )
            {
                Toast.makeText(Signup.this, "Ready", Toast.LENGTH_SHORT).show();
                if(Senterpass.equals(Sconfirmpass))
                {
                    Toast.makeText(Signup.this, "You can Create an Account", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(Signup.this, "Passwords don't match", Toast.LENGTH_SHORT).show();
                }
            }
            else
            {
                Toast.makeText(Signup.this, "Please Fill all fields", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
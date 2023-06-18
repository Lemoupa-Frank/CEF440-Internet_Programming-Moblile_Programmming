package Activity.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.getme_driver.R;

import API_Handler.CustomResponse;
import API_Handler.Interface_Request;
import API_Handler.Retrofit_Base_Class;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class Login extends AppCompatActivity {
    TextView signup; EditText username,password, lastname;
    Button log; String Username, Password,Lastname;
    Retrofit retro_obj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        // Find the "Sign up" button and add a click listener
        signup= findViewById(R.id.signup);
        log = findViewById(R.id.login);
        lastname = findViewById(R.id.lme);
        password = findViewById(R.id.password);
        username = findViewById(R.id.username);

        retro_obj= Retrofit_Base_Class.getClient();
        signup.setOnClickListener(v -> {
            Intent intent = new Intent(Login.this, Signup.class);
            startActivity(intent);
        });
        log.setOnClickListener(d->
        {
            Username = username.getText().toString();
            Password = password.getText().toString();
            Lastname = lastname.getText().toString();
            if(Username.length() > 0 && password.length() > 0 && Lastname.length() > 0)
            {
                //login(Username,Password,Lastname);
                login("hired1","123password","name");
            }
            else
            {
                Toast.makeText(Login.this, "Enter all Fields", Toast.LENGTH_SHORT).show();
            }

        });
    }
    public void login(String setUsername, String setPassword,String setLastname )
    {
        Interface_Request interface_request = retro_obj.create(Interface_Request.class);
        //Call<Void> passenger_call = interface_request.Send_Logs(passenger);
        Call<CustomResponse> passenger_call = interface_request.logd(setPassword,setUsername,setLastname);
        passenger_call.enqueue(new Callback<CustomResponse>() {
            @Override
            public void onResponse(@NonNull Call<CustomResponse> call, @NonNull Response<CustomResponse> response) {

                if(response.isSuccessful())
                {
                    CustomResponse custom = response.body();
                    //CustomResponse customResponse = response.body();
                    //assert customResponse != null;
                    assert custom != null;
                    Toast.makeText(Login.this, custom.getMessage(), Toast.LENGTH_SHORT).show();
                    // Intent intent = new Intent(Login.this, Dashboard.class);
                    //startActivity(intent);
                }
                else
                {
                    Toast.makeText(Login.this, response.message(), Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(@NonNull Call<CustomResponse> call, @NonNull Throwable t) {
                Toast.makeText(Login.this, t.toString(), Toast.LENGTH_SHORT).show();
                System.out.println(t + "********************************************************************");
            }
        });
    }
}
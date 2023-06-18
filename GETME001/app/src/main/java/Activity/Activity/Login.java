package Activity.Activity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.getme001.R;

import API_Handler.CustomResponse;
import API_Handler.Interface_Request;
import API_Handler.Retrofit_Base_Class;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class Login extends AppCompatActivity {
    EditText name,pass; Button log;
    Retrofit retro_obj;
    String names,ppass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        name = findViewById(R.id.username);
        pass = findViewById(R.id.password);
        log = findViewById(R.id.signupbtn);
        retro_obj = Retrofit_Base_Class.getClient();
        log.setOnClickListener(v->
        {
            names = name.getText().toString();
            ppass = pass.getText().toString();
            if(names.length() == 0 || ppass.length() == 0 )
            {
                Toast.makeText(Login.this, "Empty Field",Toast.LENGTH_LONG).show();
            }
            else
            {
                Create_user(names,ppass);
            }
        });

    }
    public void Create_user(String setUsername, String setPassword )
    {
        Interface_Request interface_request = retro_obj.create(Interface_Request.class);
        //Call<Void> passenger_call = interface_request.Send_Logs(passenger);
        Call<CustomResponse> passenger_call = interface_request.Send_Logs(setUsername,setPassword);
        passenger_call.enqueue(new Callback<CustomResponse>() {
            @Override
            public void onResponse(@NonNull Call<CustomResponse> call, @NonNull Response<CustomResponse> response) {

                if(response.isSuccessful())
                {
                    CustomResponse custom = response.body();
                    assert custom != null;
                    Toast.makeText(Login.this, custom.getMessage(), Toast.LENGTH_SHORT).show();
                    if(custom.getMessage().toString().equals("LOGGED"))
                    {
                        Intent intent = new Intent(Login.this, Dashboard.class);
                        startActivity(intent);
                    }
                }
                else
                {
                    Toast.makeText(Login.this, response.message(), Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(@NonNull Call<CustomResponse> call, Throwable t) {
                Toast.makeText(Login.this, t.toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
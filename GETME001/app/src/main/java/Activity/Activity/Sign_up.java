package Activity.Activity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Display;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.getme001.R;

import API_Handler.Interface_Request;
import API_Handler.Retrofit_Base_Class;
import Activity.Activity.Location.GpsTracker;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class Sign_up extends AppCompatActivity {

    Button verify_butt; Button skip_butt; Retrofit retro_obj; Button verify_number; EditText Creat_pass, Confirm_pass, phone_num, Username ;
    String phone_number, username;

    TextView user_num;
    double[] Plocation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        verify_butt = findViewById(R.id.verify_signup);
        skip_butt = findViewById(R.id.skip_button);
        phone_num = findViewById(R.id.phone_num);
        Username= findViewById(R.id.User_Name);
        Plocation = new double[2];
        Plocation = getLocation();
        // instantiating an object of type Retrofit
        retro_obj = Retrofit_Base_Class.getClient();
        // Use the Retrofit object to create an interface object
        verify_butt.setOnClickListener(v -> {
            phone_number = phone_num.getText().toString();
            username = Username.getText().toString();
            if(username.length() == 0 && phone_number.length() == 0 )
            {
                Toast.makeText(Sign_up.this, "Phone Number or Name is empty",Toast.LENGTH_LONG).show();
            }
            else
            {
                Dialog verify_dial;
                verify_dial = openDialog();
                verify_dial.show();
            }
        });
        skip_butt.setOnClickListener(v -> {
            Intent Dashboard_intent = new Intent(Sign_up.this, Dashboard.class);
            startActivity(Dashboard_intent);
        });
    }
    public Dialog openDialog() {
        //Define Dialog
        final Dialog dialog = new Dialog(Sign_up.this);
        dialog.setContentView(R.layout.verify_num);
        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int width = size.x;
        int height = size.y;
        dialog.getWindow().setLayout(5*(width)/7,5*(height)/7);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        verify_number = dialog.findViewById(R.id.verify_num);
        Creat_pass = dialog.findViewById(R.id.create_pass);
        Confirm_pass = dialog.findViewById(R.id.Conf_pass);
        user_num = dialog.findViewById(R.id.nummmmm);
        user_num.setText(phone_number);
        verify_number.setOnClickListener(a->
        {
            if(Confirm_pass.getText().length() != 0 && Creat_pass.getText().length() != 0)
            {
                if(Confirm_pass.getText().toString().equals(Creat_pass.getText().toString()))
                {
                    Toast.makeText(Sign_up.this, "User Created",Toast.LENGTH_LONG).show();
                    Create_user(username,phone_number,Confirm_pass.getText().toString());
                    Intent intent = new Intent(Sign_up.this, Login.class);
                    startActivity(intent);
                }
                else
                {
                    Toast.makeText(Sign_up.this, "Passwords don't match",Toast.LENGTH_LONG).show();
                }

            }
            else
            {
                Toast.makeText(Sign_up.this, "No Password",Toast.LENGTH_LONG).show();
            }
        });
        return dialog;
    }

    public void Create_user(String setUsername, String setPassword,String setContact )
    {
        Interface_Request interface_request = retro_obj.create(Interface_Request.class);
        //Call<Void> passenger_call = interface_request.Send_Logs(passenger);
        Call<Void> passenger_call = interface_request.Send_Logs(setUsername,setPassword,setContact,Plocation[0],Plocation[1]);
        passenger_call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(@NonNull Call<Void> call, @NonNull Response<Void> response) {

                if(response.isSuccessful())
                {
                    Toast.makeText(Sign_up.this, "User Created", Toast.LENGTH_SHORT).show();

                }
                else
                {
                    Toast.makeText(Sign_up.this, response.message(), Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(@NonNull Call<Void> call, Throwable t) {
                Toast.makeText(Sign_up.this, t.toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }
    public double[] getLocation() {
        double latitude = 0,longitude = 0;
        double[] Location = new double[2];
        GpsTracker gpsTracker = new GpsTracker(this);
        if (gpsTracker.canGetLocation()) {
            latitude = gpsTracker.getLatitude();
            longitude = gpsTracker.getLongitude();
        } else {
            //gpsTracker.showSettingsAlert();
            //might cause application to crash
            Toast.makeText(Sign_up.this,"Enable internet access for better experience",Toast.LENGTH_LONG).show();
        }
        Location[0] = longitude;
        Location[1] = latitude;
        return Location;
    }
}

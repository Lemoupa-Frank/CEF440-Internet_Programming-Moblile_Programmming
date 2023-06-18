package Activity.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.getme_driver.R;
import com.google.android.gms.maps.MapView;

import API_Handler.Interface_Request;
import API_Handler.Retrofit_Base_Class;
import Activity.Activity.Location.GpsTracker;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class Signup extends AppCompatActivity {
    TextView LOG; Button signup;
    EditText fname,lname,phone_num,licence_nu,carplate, enterpass, confirmpass;
    String Sfname,Slname,Sphone_num,Scompanyname,Slicence_nu,Scarplate, Senterpass, Sconfirmpass;
    Retrofit retro_obj;
    Spinner sort_spinner;
    private MapView maps;
    double[] Plocation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);
        retro_obj = Retrofit_Base_Class.getClient();
        fname = findViewById(R.id.firstname);
        lname = findViewById(R.id.lastname);
        phone_num = findViewById(R.id.phone_number);
        licence_nu = findViewById(R.id.uploadlicence);
        carplate = findViewById(R.id.carplate);
        enterpass = findViewById(R.id.enter_pass);
        confirmpass = findViewById(R.id.confirmpass);
        sort_spinner = findViewById(R.id.sort_spiner);
        Plocation = new double[2];
        Plocation = getLocation();
        ArrayAdapter<CharSequence> sort_adapter = ArrayAdapter.createFromResource(this,
                R.array.sort_spinner_array, R.layout.spinner_design);
        sort_adapter .setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sort_spinner.setAdapter(sort_adapter );
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
            Slicence_nu = licence_nu.getText().toString();
            Scarplate = carplate.getText().toString();
            Senterpass = enterpass.getText().toString();
            Sconfirmpass = confirmpass.getText().toString();
            Scompanyname =  sort_spinner.getSelectedItem().toString();
            if(Sfname.length() > 0 && Slname.length() > 0 && Sphone_num.length() > 0 && Scompanyname.length() > 0 && Slicence_nu.length() > 0 && Scarplate.length() > 0 && Senterpass.length() > 0 && Sconfirmpass.length() > 0 )
            {
                Toast.makeText(Signup.this, "Ready", Toast.LENGTH_SHORT).show();
                if(Senterpass.equals(Sconfirmpass))
                {
                    Toast.makeText(Signup.this, "You can Create an Account", Toast.LENGTH_SHORT).show();
                    Create_user(1,Slicence_nu,Senterpass,Slname,Plocation[1],Plocation[0],Sfname,Scarplate,4,Scompanyname);
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
    public void Create_user(int admin_id,String SSlicence_nu, String SSenterpass,String SSlname, double lat, double lon, String SSfname, String SScarplate, int seats, String SScompanyname )
    {

        Interface_Request interface_request = retro_obj.create(Interface_Request.class);
        //Call<Void> passenger_call = interface_request.Send_Logs(passenger);
        if(Scompanyname.equals("Free Lance")) {
            Call<Void> passenger_call = interface_request.createDriver(admin_id, SSlicence_nu, SSenterpass,  SSfname , Plocation[1],Plocation[0],SSlname , SScarplate, seats,Sphone_num);
            passenger_call.enqueue(new Callback<Void>() {
                @Override
                public void onResponse(@NonNull Call<Void> call, @NonNull Response<Void> response) {

                    if (response.isSuccessful()) {
                        Toast.makeText(Signup.this, "User Created", Toast.LENGTH_SHORT).show();

                    } else
                    {
                        Toast.makeText(Signup.this, response.message(), Toast.LENGTH_SHORT).show();
                    }

                }

                @Override
                public void onFailure(@NonNull Call<Void> call, @NonNull Throwable t) {
                    Toast.makeText(Signup.this, t.toString(), Toast.LENGTH_SHORT).show();
                }
            });
        }
        else
        {
            Call<Void> passenger_call = interface_request.createHiredDriver(admin_id, SSlicence_nu, SSenterpass,  SSfname , Plocation[1],Plocation[0],SSlname , SScompanyname,SScarplate);
            passenger_call.enqueue(new Callback<Void>() {
                @Override
                public void onResponse(@NonNull Call<Void> call, @NonNull Response<Void> response) {

                    if (response.isSuccessful()) {
                        Toast.makeText(Signup.this, "User Created", Toast.LENGTH_SHORT).show();
                        Intent sign_up = new Intent(Signup.this, Login.class);
                        startActivity(sign_up);

                    } else {
                        Toast.makeText(Signup.this, response.message(), Toast.LENGTH_SHORT).show();
                    }

                }

                @Override
                public void onFailure(@NonNull Call<Void> call, @NonNull Throwable t) {
                    Toast.makeText(Signup.this, t.toString(), Toast.LENGTH_SHORT).show();
                }
            });
        }
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
            Toast.makeText(Signup.this,"Enable internet access for better experience",Toast.LENGTH_LONG).show();
        }
        Location[0] = longitude;
        Location[1] = latitude;
        return Location;
    }
}
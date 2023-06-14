package Activity.Activity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Display;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.getme001.R;

import API_Handler.Interface_Request;
import API_Handler.PassengerModel;
import API_Handler.Retrofit_Base_Class;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class Sign_up extends AppCompatActivity {

    Button verify_butt; Button skip_butt; Retrofit retro_obj; Button verify_number;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        verify_butt = findViewById(R.id.verify_signup);
        skip_butt = findViewById(R.id.skip_button);
        // instantiating an object of type Retrofit
        retro_obj = Retrofit_Base_Class.getClient();
        // Use the Retrofit object to create an interface object
        verify_butt.setOnClickListener(v -> {
            Dialog verify_dial;
            verify_dial = openDialog();
            verify_dial.show();
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
        verify_number.setOnClickListener(a->
                Create_user());
        return dialog;
    }

    public void Create_user()
    {
        PassengerModel passenger = new PassengerModel();
        passenger.setUsername("Noghue Lemoupa");
        passenger.setPassword("3312002");
        passenger.setContact("675934405");
        passenger.setPassId(131346);
        Interface_Request interface_request = retro_obj.create(Interface_Request.class);
        Call<PassengerModel> passenger_call = interface_request.Send_Logs(passenger);
        passenger_call.enqueue(new Callback<PassengerModel>() {
            @Override
            public void onResponse(@NonNull Call<PassengerModel> call, @NonNull Response<PassengerModel> response) {

                if(response.isSuccessful())
                {
                    Toast.makeText(Sign_up.this, "WORKS", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(Sign_up.this, response.message(), Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(@NonNull Call<PassengerModel> call, Throwable t) {
                Toast.makeText(Sign_up.this, t.toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
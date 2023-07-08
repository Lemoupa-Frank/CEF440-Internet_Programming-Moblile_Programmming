package Activity.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.getme001.R;

public class Book_Ride extends AppCompatActivity {
Button but; EditText Name, phone, destination;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_ride);
        but = findViewById(R.id.Book_A_Cap);
        Name = findViewById(R.id.User_Name);
        phone = findViewById(R.id.Telephone);
        destination = findViewById(R.id.Pick_Location);
        but.setOnClickListener(v->{
            if(Name.getText().toString().length() >  0 && phone.getText().toString().length() > 0  && destination.getText().toString().length() > 0 )
            {
                Toast.makeText(Book_Ride.this, "A Driver will contact you Shortly", Toast.LENGTH_SHORT).show();
                Intent Dashboard_intent = new Intent(Book_Ride.this, Dashboard.class);
                startActivity(Dashboard_intent);
            }
            else {
                Toast.makeText(Book_Ride.this, "Fill all Fields", Toast.LENGTH_SHORT).show();
            }

        });
    }

}

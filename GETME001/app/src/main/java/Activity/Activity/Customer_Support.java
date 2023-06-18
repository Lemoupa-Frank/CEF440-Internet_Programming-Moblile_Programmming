package Activity.Activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.getme001.R;

public class Customer_Support extends AppCompatActivity {

    private EditText editTextName;
    private EditText editTextPhoneNumber;
    private EditText editTextMessage;
    private Button buttonSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_support);


        editTextName = findViewById(R.id.editTextName);
        editTextPhoneNumber = findViewById(R.id.editTextPhoneNumber);
        editTextMessage = findViewById(R.id.editTextMessage);
        buttonSubmit = findViewById(R.id.login);
        buttonSubmit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                sendEmail();
                Toast.makeText(Customer_Support.this, "The form is submitted ", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void sendEmail() {
        String name = editTextName.getText().toString();
        String email = editTextPhoneNumber.getText().toString();
        String message = editTextMessage.getText().toString();

        // Create the email intent
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("message/rfc822");
        intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"tamahjustin@gmail.com"});
        intent.putExtra(Intent.EXTRA_SUBJECT, "Email Form Submission");
        intent.putExtra(Intent.EXTRA_TEXT, "Name: " + name + "\nEmail: " + email + "\nMessage: " + message);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
}

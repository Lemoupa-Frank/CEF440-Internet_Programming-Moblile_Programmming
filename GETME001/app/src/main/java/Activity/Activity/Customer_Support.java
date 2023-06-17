package Activity.Activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.getme001.R;

public class Customer_Support extends AppCompatActivity {

    private EditText editTextName;
    private EditText editTextPhoneNumber;
    private EditText editTextMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_support);

        editTextName = findViewById(R.id.editTextName);
        editTextPhoneNumber = findViewById(R.id.editTextPhoneNumber);
        editTextMessage = findViewById(R.id.editTextMessage);
    }

    public void sendMessage(View view) {
        String name = editTextName.getText().toString();
        String phoneNumber = editTextPhoneNumber.getText().toString();
        String message = editTextMessage.getText().toString();

        // Compose the email intent
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:https://mail.google.com/mail/u/0/#inbox"));
        intent.putExtra(Intent.EXTRA_SUBJECT, "Customer Support Request");
        intent.putExtra(Intent.EXTRA_TEXT, "Name: " + name + "\nPhone Number: " + phoneNumber + "\n\n" + message);

        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
}

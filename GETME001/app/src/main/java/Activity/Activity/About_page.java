package Activity.Activity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.getme001.R;

public class About_page extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_page);

        ImageView logoImageView = findViewById(R.id.image_logo);
        TextView appNameTextView = findViewById(R.id.text_app_name);
        TextView versionTextView = findViewById(R.id.text_version);
        TextView descriptionTextView = findViewById(R.id.text_description);

        //Enable scrool view
//        ScrollView scrollView = findViewById(R.id.scrollView);
//        scrollView.setScrollbarFadingEnabled(false);

        // Set the logo image
        logoImageView.setImageResource(R.mipmap.jetme_dark_icon);

        // Set the app name
        appNameTextView.setText(getString(R.string.app_name));

        // Set the app version
        versionTextView.setText(getString(R.string.version));

        // Set the description text
        descriptionTextView.setText(getString(R.string.about_description));
        descriptionTextView.setText(getString(R.string.about_description1));
        descriptionTextView.setText(getString(R.string.about_description2));
        descriptionTextView.setText(getString(R.string.about_description3));
        descriptionTextView.setText(getString(R.string.about_description4));
        descriptionTextView.setText(getString(R.string.about_description5));
    }
}

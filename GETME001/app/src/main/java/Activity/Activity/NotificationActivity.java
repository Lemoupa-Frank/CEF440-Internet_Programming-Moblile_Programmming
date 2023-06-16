package Activity.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import com.example.getme001.R;

public class NotificationActivity extends AppCompatActivity {

    private LinearLayout notificationContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

        notificationContainer = findViewById(R.id.notification_container);

        // Add sample notifications
        addNotification("Welcome", "Welcome to JETME, a passenger possitioning system thatwill aid in making your search for taxi easy. Thank you for trusting us. If you need help, contact our support team. ");
        addNotification("New Company", "A new company called Taxi union has been created ");
        addNotification("Booking", "Your taxi booking with Buea Taxi Union was successful. Keep your tickets for verifications. ");
    }

    private void addNotification(String title, String message) {
        View notificationView = LayoutInflater.from(this).inflate(R.layout.activity_list_item_notification, null);
        TextView titleText = notificationView.findViewById(R.id.notification_title);
        TextView messageText = notificationView.findViewById(R.id.notification_message);

        titleText.setText(title);
        messageText.setText(message);

        notificationContainer.addView(notificationView);
    }
}

package Activity.Activity;

import android.Manifest;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.speech.RecognizerIntent;
import android.speech.tts.TextToSpeech;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.example.getme001.R;

import java.util.ArrayList;
import java.util.Locale;

public class blind_book_ride extends AppCompatActivity implements TextToSpeech.OnInitListener {

    private static final int SPEECH_TO_TEXT_REQUEST_CODE = 1;
    private EditText nameEditText, phoneEditText, locationEditText, destinationEditText;
    private TextToSpeech textToSpeech;
    private CountDownTimer timer;
    private int currentFieldIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blind_book_ride);

        // Request RECORD_AUDIO permission if not granted
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.RECORD_AUDIO) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.RECORD_AUDIO}, SPEECH_TO_TEXT_REQUEST_CODE);
        }

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

        textToSpeech = new TextToSpeech(this, this);

        nameEditText = findViewById(R.id.nameEditText);
        phoneEditText = findViewById(R.id.phoneEditText);
        locationEditText = findViewById(R.id.locationEditText);
        destinationEditText = findViewById(R.id.destinationEditText);

        Button submitButton = findViewById(R.id.submitButton);
        submitButton.setOnClickListener(v -> {
            submitButton.setEnabled(false);
            startConversation();
        });

        // Start the conversation automatically when the activity starts
        new CountDownTimer(3000, 1000) {
            public void onTick(long millisUntilFinished) {
                // Timer is counting down (3 seconds)
            }

            public void onFinish() {
                speak("Welcome! Now, let's get started.");
                new CountDownTimer(5000, 1000) {
                    public void onTick(long millisUntilFinished) {
                        // Timer is counting down (5 seconds)
                    }

                    public void onFinish() {
                        startConversation();
                    }
                }.start();
            }
        }.start();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (textToSpeech != null) {
            textToSpeech.stop();
            textToSpeech.shutdown();
        }
        if (timer != null) {
            timer.cancel();
        }
    }

    private void startConversation() {
        switch (currentFieldIndex) {
            case 0:
                askForInput("What is your name?");
                break;
            case 1:
                askForInput("What is your phone number?");
                break;
            case 2:
                askForInput("Where are you presently?");
                break;
            case 3:
                askForInput("Where do you want to go?");
                break;

        }
    }

    private void askForInput(String question) {
        speak(question);
        new CountDownTimer(6000, 1000) {
            public void onTick(long millisUntilFinished) {
                // Timer is counting down (6 seconds)
            }

            public void onFinish() {
                startListening();
            }
        }.start();
    }

    private void startListening() {
        // Start listening for speech input
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
        intent.putExtra(RecognizerIntent.EXTRA_PROMPT, "Listening...");
        try {
            startActivityForResult(intent, SPEECH_TO_TEXT_REQUEST_CODE);
        } catch (ActivityNotFoundException e) {
            Toast.makeText(this, "Speech-to-text not supported on this device", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onInit(int status) {
        if (status == TextToSpeech.SUCCESS) {
            int result = textToSpeech.setLanguage(Locale.getDefault());
            if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                Toast.makeText(this, "Text-to-speech not supported on this device", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, "Text-to-speech initialization failed", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == SPEECH_TO_TEXT_REQUEST_CODE) {
            if (resultCode == RESULT_OK && data != null) {
                ArrayList<String> speechResults = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                processSpeechInput(speechResults);
            } else {
                processSpeechInput(null);
            }
        }
    }

    private void processSpeechInput(ArrayList<String> speechResults) {
        if (speechResults != null && !speechResults.isEmpty()) {
            String userInput = speechResults.get(0);
            setCurrentFieldText(userInput);
            currentFieldIndex++;
            if (currentFieldIndex < 4) {
                startConversation();
            } else {
                confirmInformation();
            }
        } else {
            speak("Sorry, I didn't catch that. Please try again.");
            new CountDownTimer(7000, 1000) {
                public void onTick(long millisUntilFinished) {
                    // Timer is counting down (3 seconds)
                }

                public void onFinish() {
                    startListening();
                }
            }.start();
        }
    }

    private void confirmInformation() {
        String name = nameEditText.getText().toString();
        String phone = phoneEditText.getText().toString();
        String location = locationEditText.getText().toString();
        String destination = destinationEditText.getText().toString();

        String confirmationMessage = "Your information:\n" +
                "Name: " + name + "\n" +
                "Phone Number: " + phone + "\n" +
                "Location: " + location + "\n" +
                "Destination: " + destination + "\n" +
                "Is this information correct?";

        speak(confirmationMessage);

        new CountDownTimer(6000, 1000) {
            public void onTick(long millisUntilFinished) {
                // Timer is counting down (6 seconds)
            }

            public void onFinish() {
                startListening();
            }
        }.start();
    }

    private void setCurrentFieldText(String text) {
        switch (currentFieldIndex) {
            case 0:
                nameEditText.setText(text);
                break;
            case 1:
                phoneEditText.setText(text);
                break;
            case 2:
                locationEditText.setText(text);
                break;
            case 3:
                destinationEditText.setText(text);
                break;
        }
    }

    private void speak(String message) {
        textToSpeech.speak(message, TextToSpeech.QUEUE_FLUSH, null, null);
    }
}

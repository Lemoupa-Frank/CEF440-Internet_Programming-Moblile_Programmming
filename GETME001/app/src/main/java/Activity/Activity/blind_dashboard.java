package Activity.Activity;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.speech.RecognitionListener;
import android.speech.RecognizerIntent;
import android.speech.SpeechRecognizer;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Toast;

import com.example.getme001.R;

import java.util.ArrayList;
import java.util.Locale;

public class blind_dashboard extends Activity implements TextToSpeech.OnInitListener, RecognitionListener {

    private TextToSpeech tts;
    private SpeechRecognizer speechRecognizer;
    private Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blind_dashboard);

        // Initialize Text-to-Speech engine
        tts = new TextToSpeech(this, this);

        // Initialize Speech Recognizer
        speechRecognizer = SpeechRecognizer.createSpeechRecognizer(this);
        speechRecognizer.setRecognitionListener(this);

        // Handler to delay listening mode
        handler = new Handler();

        // Welcome message
        speak("Welcome to the Blind Assistance App. What would you like to do?");
        startListening();



        new CountDownTimer(5000, 1000) {
            public void onTick(long millisUntilFinished) {
                // Timer is counting down (3 seconds)
            }

            public void onFinish() {
                speak("Welcome to the Blind Assistance dashboard! Here, you can book ride, view ride history, see your notifications, and contact custumer support service. Which one will you want to do?, ");

            }
        }.start();






        // Delayed start of listening mode after 10 seconds
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startListening();
            }
        }, 10000);
    }

    @Override
    public void onInit(int status) {
        if (status == TextToSpeech.SUCCESS) {
            // Set the language to English
            int result = tts.setLanguage(Locale.ENGLISH);

            if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                Toast.makeText(this, "Text-to-Speech language not supported.", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, "Failed to initialize Text-to-Speech.", Toast.LENGTH_SHORT).show();
        }
    }

    // Function to speak the provided text
    private void speak(String text) {
        tts.speak(text, TextToSpeech.QUEUE_FLUSH, null, null);
    }

    // Function to start listening for voice input
    private void startListening() {
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        speechRecognizer.startListening(intent);
    }

    // Restarts the listening mode after a delay
    private void restartListeningDelayed() {
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startListening();
            }
        }, 5000); // Wait for 5 seconds before re-entering listening mode
    }

    @Override
    public void onReadyForSpeech(Bundle params) {
        // Called when the speech recognition is ready for the user to start speaking
    }

    @Override
    public void onBeginningOfSpeech() {
        // Called when the user starts speaking
    }

    @Override
    public void onRmsChanged(float rmsdB) {

    }

    @Override
    public void onBufferReceived(byte[] buffer) {

    }

    @Override
    public void onEndOfSpeech() {
        // Called when the user finishes speaking
    }

    @Override
    public void onResults(Bundle results) {
        // Called when speech recognition results are available

        ArrayList<String> matches = results.getStringArrayList(SpeechRecognizer.RESULTS_RECOGNITION);
        if (matches != null && !matches.isEmpty()) {
            String userChoice = matches.get(0).toLowerCase();

            // Process user's spoken command
            if (userChoice.contains("book") || userChoice.contains("ride")) {
                speak("Launching book ride page.");
                startActivity(new Intent(blind_dashboard.this,blind_book_ride.class));
                // Code to launch book ride page goes here
            } else if (userChoice.contains("view notifications") || userChoice.contains("notifications")) {
                speak("Launching notifications page.");
                // Code to launch notifications page goes here
            } else if (userChoice.contains("view ride history") || userChoice.contains("history")) {
                speak("Launching view ride history page.");
                // Code to launch view history page goes here
            } else if (userChoice.contains("contact") || userChoice.contains("support") || userChoice.contains("service") || userChoice.contains("customer support service")) {
                speak("Launching contact customer support page.");
                // Code to launch contact customer support page goes here
            } else {
                speak("Invalid input. Please try again.");
                restartListeningDelayed();
            }
        } else {
            speak("Sorry, I didn't catch that. Please try again.");
            restartListeningDelayed();
        }
    }

    @Override
    public void onError(int error) {
        // Called when an error occurs during speech recognition
        restartListeningDelayed();
    }

    @Override
    public void onPartialResults(Bundle partialResults) {
        // Called when partial recognition results are available
    }

    @Override
    public void onEvent(int eventType, Bundle params) {
        // Called when an event related to the recognition service occurs
    }

    @Override
    protected void onDestroy() {
        if (tts != null) {
            tts.stop();
            tts.shutdown();
        }

        if (speechRecognizer != null) {
            speechRecognizer.stopListening();
            speechRecognizer.destroy();
        }

        handler.removeCallbacksAndMessages(null); // Remove all pending delayed actions

        super.onDestroy();
    }
}

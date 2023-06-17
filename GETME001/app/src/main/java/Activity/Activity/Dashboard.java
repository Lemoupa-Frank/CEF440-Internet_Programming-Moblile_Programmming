package Activity.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.getme001.R;
import android.view.MenuItem;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import android.widget.Toast;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;


// Text to speach import

import android.Manifest;
import android.content.pm.PackageManager;
import android.speech.tts.TextToSpeech;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import java.util.Locale;

import Activity.Activity.Location.GpsTracker;

public class Dashboard extends AppCompatActivity implements OnMapReadyCallback, TextToSpeech.OnInitListener{
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    BottomNavigationView navigationViewdown;
    ActionBarDrawerToggle toggle;
    private MapView maps;
    double[] Plocation;

    // text to speach declarations

    private TextToSpeech textToSpeech;
    private static final int REQUEST_CODE_PERMISSION = 1;
    //end of textto speach declarations


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (toggle.onOptionsItemSelected(item))
            return true;
        return super.onOptionsItemSelected(item);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        Plocation = new double[2];
        Plocation = getLocation();
        //Text to speach
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.INTERNET) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.INTERNET}, REQUEST_CODE_PERMISSION);
        } else {
            initializeTextToSpeech();
        }


        //mapp parts
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.maps);
        if (mapFragment != null) {
            mapFragment.getMapAsync(this);
        }
        maps = findViewById(R.id.mapView);
        maps.onCreate(savedInstanceState);
        maps.getMapAsync(this);

        //menu parts
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        toggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        setSupportActionBar(findViewById(R.id.toolbar));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //nav down

        navigationViewdown = findViewById(R.id.bottomNavigationView);
        navigationViewdown.setOnNavigationItemSelectedListener(item -> {
            int item1 = item.getItemId();
            switch (item1)
            {
                case R.id.Book:
                {
                    startActivity(new Intent(Dashboard.this, Book_Ride.class));
                    break;
                }
                case R.id.history:
                {
                    Toast.makeText(Dashboard.this, "History page selected", Toast.LENGTH_SHORT).show();
                    break;
                }
                case R.id.notification:
                {
                    startActivity(new Intent(Dashboard.this, NotificationActivity.class));
                    break;
                }
            }
            return false;
        });
        // Set up the toolbar

        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(item -> {
            int itemId = item.getItemId();
            switch (itemId)
            {
                case R.id.about:
                {
                    startActivity(new Intent(Dashboard.this, About_page.class));
                    break;
                }
                case R.id.home:
                {
                    startActivity(new Intent(Dashboard.this, Dashboard.class));
                    break;
                }
                case R.id.setting:
                {
                    Toast.makeText(Dashboard.this, "Settings selected", Toast.LENGTH_SHORT).show();
                    break;
                }
                case R.id.support:
                {
                    startActivity(new Intent(Dashboard.this, Customer_Support.class));
                    break;
                }
                case R.id.account:
                {
                    Toast.makeText(Dashboard.this, " selected", Toast.LENGTH_SHORT).show();
                    break;
                }
                case R.id.logout:
                {
                    finishAffinity();
                    return true;
                }


            }
            drawerLayout.closeDrawer(GravityCompat.START);
            return false;
        });


    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        LatLng location = new LatLng(Plocation[1], Plocation[0]); // Set the latitude and longitude of the desired location
        googleMap.addMarker(new MarkerOptions().position(location).title("Marker"));
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(location, 12));
    }

    @Override
    protected void onResume() {
        super.onResume();
        maps.onResume();
    }
    @Override
    protected void onPause() {
        super.onPause();
        maps.onPause();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        maps.onLowMemory();
    }
    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START))
        {
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        else
        {
            super.onBackPressed();
        }

    }


    //start of text to speach

    private void initializeTextToSpeech() {
        textToSpeech = new TextToSpeech(this, this);
    }

    @Override
    public void onInit(int status) {
        if (status == TextToSpeech.SUCCESS) {
            int result = textToSpeech.setLanguage(Locale.getDefault());

            if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                Toast.makeText(this, "Language not supported", Toast.LENGTH_SHORT).show();
            } else {
                speak("Welcome to JET-ME, Here, you can book a ride, view freelance taxi positions, see your ride history, determine your arrival time, and many more. ");
            }
        } else {
            Toast.makeText(this, "TextToSpeech initialization failed", Toast.LENGTH_SHORT).show();
        }
    }
    private void speak(String text) {
        textToSpeech.speak(text, TextToSpeech.QUEUE_FLUSH, null, null);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        maps.onDestroy();
        // text to speach

        if (textToSpeech != null) {
            textToSpeech.stop();
            textToSpeech.shutdown();
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
            Toast.makeText(Dashboard.this,"Enable internet access for better experience",Toast.LENGTH_LONG).show();
        }
        Location[0] = longitude;
        Location[1] = latitude;
        return Location;
    }

}
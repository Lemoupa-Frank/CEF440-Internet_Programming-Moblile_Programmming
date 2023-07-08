package Activity.Activity;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.example.getme_driver.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.material.navigation.NavigationView;

import java.util.Locale;
import java.util.Objects;

import API_Handler.Interface_Request;
import API_Handler.Retrofit_Base_Class;
import API_Handler.responsemodel;
import Activity.Activity.Location.GpsTracker;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class Dashboard extends AppCompatActivity implements OnMapReadyCallback, TextToSpeech.OnInitListener{
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ActionBarDrawerToggle toggle;
    private MapView maps;
    double[] Plocation;

    String Closestpss = "No Close Passenger or Crowd";
    responsemodel custom;
    Retrofit retro_obj;

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
        setContentView(R.layout.driver_dashboard);
        Plocation = new double[2];
        Plocation = getLocation();
        retro_obj = Retrofit_Base_Class.getClient();
        Interface_Request interface_request = retro_obj.create(Interface_Request.class);
        //Call<Void> passenger_call = interface_request.Send_Logs(passenger);
        Call<responsemodel> passenger_call = interface_request.Send_Logs(Plocation[0],Plocation[1]);
        passenger_call.enqueue(new Callback<responsemodel>() {
            @Override
            public void onResponse(@NonNull Call<responsemodel> call, @NonNull Response<responsemodel> response) {

                if(response.isSuccessful())
                {
                    custom = response.body();
                    assert custom != null;
                    Closestpss = custom.getD1Name();
                    Toast.makeText(Dashboard.this, "Welcome", Toast.LENGTH_SHORT).show();

                }
                else
                {
                    Toast.makeText(Dashboard.this, response.message(), Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(@NonNull Call<responsemodel> call, Throwable t) {
                Toast.makeText(Dashboard.this, t.toString(), Toast.LENGTH_SHORT).show();
            }
        });
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
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        // Set up the toolbar

        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(item -> {
            int itemId = item.getItemId();
            switch (itemId)
            {
                case 1000004:
                {
                    Toast.makeText(Dashboard.this, "Home selected", Toast.LENGTH_SHORT).show();
                    break;
                }
                case 1000001:
                {
                    Toast.makeText(Dashboard.this, "Gallery selected", Toast.LENGTH_SHORT).show();
                    break;
                }
                case 1000000:
                {
                    Toast.makeText(Dashboard.this, "Settings selected", Toast.LENGTH_SHORT).show();
                    break;
                }
            }
            drawerLayout.closeDrawer(GravityCompat.START);
            return false;
        });


    }

    






    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        LatLng location = new LatLng(Plocation[1], Plocation[0]); // Set the latitude and longitude of the desired location
        googleMap.addMarker(new MarkerOptions().position(location).title("Marker").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE)));
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(location, 12));
        if(custom != null)
        {
            LatLng locationa = new LatLng(custom.getD1Long(), custom.getD1Lat()); // Set the latitude and longitude of the desired location
            googleMap.addMarker(new MarkerOptions().position(locationa).title(custom.getD1Name()));
            LatLng locationb = new LatLng(custom.getD2Long(), custom.getD2Lat()); // Set the latitude and longitude of the desired location
            googleMap.addMarker(new MarkerOptions().position(locationb).title(custom.getD2Name()));
            LatLng locationc = new LatLng(custom.getD3Long(), custom.getD3Lat()); // Set the latitude and longitude of the desired location
            googleMap.addMarker(new MarkerOptions().position(locationc).title(custom.getD3Name()));
            Closestpss = custom.getD1Name();
        }
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
              //  speak("Welcome to JET-ME, Here, you can book a ride, view freelance taxi positions, see your ride history, determine your arrival time, and many more. ");
                speak( Closestpss + "Is close By, Check map to for a crowd ");
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
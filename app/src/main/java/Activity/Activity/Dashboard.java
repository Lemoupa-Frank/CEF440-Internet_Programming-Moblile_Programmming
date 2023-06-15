package Activity.Activity;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.example.getme001.R;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.material.navigation.NavigationView;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class Dashboard extends AppCompatActivity implements OnMapReadyCallback {
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ActionBarDrawerToggle toggle;
NavigationView nav;
    private GoogleMap googleMap;
    private MapView maps;
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
        //mapp parts
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.maps);
        mapFragment.getMapAsync(this);
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
        // Set up the toolbar

        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
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

            }
        });

    }


    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        googleMap = googleMap;
        LatLng location = new LatLng(4.1560, 9.2632); // Set the latitude and longitude of the desired location
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
    protected void onDestroy() {
        super.onDestroy();
        maps.onDestroy();
    }
    @Override
    public void onLowMemory() {
        super.onLowMemory();
        maps.onLowMemory();
    }

    //implementing menu bar back press
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
}
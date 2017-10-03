package edu.byu.loganmc.youpick;

import android.app.Activity;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;

public class LocationActivity extends Activity {
    private static final int MY_PERMISSIONS_REQUEST_COURSE_LOCATION = 0;
    EditText lat = null;
    EditText lng = null;
    private FusedLocationProviderClient mFusedLocationClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location);

        mFusedLocationClient = LocationServices.getFusedLocationProviderClient(this);

        lat = (EditText) findViewById(R.id.lat_debug);
        lng = (EditText) findViewById(R.id.lng_debug);

        Button currentLocation = (Button) findViewById(R.id.currentLocationButton);
        currentLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(LocationActivity.this, "Button clicked", Toast.LENGTH_LONG).show();
                getLocation();
            }
        });


    }

    private void getLocation() {
        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            String[] permissions = {android.Manifest.permission.ACCESS_COARSE_LOCATION, android.Manifest.permission.ACCESS_FINE_LOCATION};
            ActivityCompat.requestPermissions(LocationActivity.this, permissions, MY_PERMISSIONS_REQUEST_COURSE_LOCATION);
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.

        }
        mFusedLocationClient.getLastLocation()
                .addOnSuccessListener(this, new OnSuccessListener<Location>() {
                    @Override
                    public void onSuccess(Location location) {
                        // Got last known location. In some rare situations this can be null.
                        Toast.makeText(LocationActivity.this, "GETTING LOCATION", Toast.LENGTH_SHORT).show();
                        if (location != null) {
                            lat.setText(Double.toString(location.getLatitude()));
                            lng.setText(Double.toString(location.getLongitude()));
                            Toast.makeText(LocationActivity.this, "Lat: ", Toast.LENGTH_LONG).show();
                        } else {
                            Toast.makeText(LocationActivity.this, "Location is null", Toast.LENGTH_LONG).show();
                        }
                    }
                });
    }
}

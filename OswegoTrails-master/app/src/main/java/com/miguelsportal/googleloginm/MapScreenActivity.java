package com.miguelsportal.googleloginm;

import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;

import static com.miguelsportal.googleloginm.R.id.map;

public class MapScreenActivity extends FragmentActivity implements OnMapReadyCallback {

    //private GoogleMap mMap;



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map_screen);
//         Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */

    @Override
    public void onMapReady(GoogleMap googleMap) {


        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setComponent(ComponentName.unflattenFromString("com.google.android.apps.maps/com.google.android.maps.MapsActivity"));
        intent.addCategory("android.intent.category.LAUNCHER");
        Uri myUri = Uri.parse("https://www.google.com/maps/d/u/0/edit?mid=14yPhjw2mg8i4pm4GmLhDGnK2Aak&ll=43.380786449624686%2C-76.60614119252932&z=13");
        intent.setData(myUri);
        startActivity(intent);

/*
        mMap = googleMap;

        LatLng NEWARK = new LatLng(40.714086, -74.228697);

        GroundOverlayOptions newarkMap = new GroundOverlayOptions()
                .image(BitmapDescriptorFactory.fromResource(R.drawable.menupic))
                .position(NEWARK, 8600f, 6500f);
        mMap.addGroundOverlay(newarkMap);


        // Add a marker in Sydney and move the camera
        LatLng startLocation = new LatLng(43.488916, -76.153589);
        mMap.addMarker(new MarkerOptions().position(startLocation).title("SUNY Oswego"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(startLocation));

        // Add a marker in Sydney and move the camera
        LatLng SUNYoswego = new LatLng(43.45, -76.54);
        mMap.addMarker(new MarkerOptions().position(SUNYoswego).title("SUNY Oswego"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(SUNYoswego));

        // Add a marker in Sydney and move the camera
        LatLng greatBear = new LatLng(43.266124, -76.351925);
        mMap.addMarker(new MarkerOptions().position(greatBear).title("Great Bear Trail"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(greatBear));

        // Add a marker in Sydney and move the camera
        LatLng breitbeck = new LatLng(43.461391, -76.523101);
        mMap.addMarker(new MarkerOptions().position(breitbeck).title("Breitbeck Park"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(breitbeck));

        // Add a marker in Sydney and move the camera
        LatLng indPark = new LatLng(43.500850, -76.451709);
        mMap.addMarker(new MarkerOptions().position(indPark).title("Independance Trail"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(indPark));

        // Add a marker in Sydney and move the camera
        LatLng derbyHill = new LatLng(43.527744, -76.238848);
        mMap.addMarker(new MarkerOptions().position(derbyHill).title("Derby Hill Bird Sanctuary"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(derbyHill));

        // Add a marker in Sydney and move the camera
        LatLng selkirkPark = new LatLng(43.545942, -76.191063);
        mMap.addMarker(new MarkerOptions().position(selkirkPark).title("Selkirk Park"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(selkirkPark));

        // Add a marker in Sydney and move the camera
        LatLng canalLanding = new LatLng(43.323894, -76.418331);
        mMap.addMarker(new MarkerOptions().position(canalLanding).title("Canal Landing"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(canalLanding));

        // Add a marker in Sydney and move the camera
        LatLng altmarForest = new LatLng(43.514129, -76.067537);
        mMap.addMarker(new MarkerOptions().position(altmarForest).title("Altmar Forest"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(altmarForest));

        // Add a marker in Sydney and move the camera
        LatLng chateugayForest = new LatLng(43.601130, -75.964567);
        mMap.addMarker(new MarkerOptions().position(chateugayForest).title("Chateugay Forest"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(chateugayForest));


        float zoomLevel = 9; //This goes up to 21
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(startLocation, zoomLevel));
    */
    }
}

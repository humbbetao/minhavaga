package com.utfpr.hgoncalves.minhavaga.Activity;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RelativeLayout;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.utfpr.hgoncalves.minhavaga.R;

public class Main2Activity extends FragmentActivity implements OnMapReadyCallback {


    private GoogleMap mMap;
    private Marker markerVagaVazia;
    private Marker markerVagaOcupada;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync((OnMapReadyCallback) this);

//        GoogleMap map = mapFragment.getMap();
//        LatLng sydney = new LatLng(-24.043190, -52.378492);
//        map.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
//        map.moveCamera(CameraUpdateFactory.newLatLng(sydney));

    }

    public LatLng getLocalizacaoVagaVaziaMarker() {
        LatLng latlonge = markerVagaVazia.getPosition();
        return latlonge;
    }

    public LatLng getLocalizacaoVagaOcupadaMarker() {
        LatLng latlonge = markerVagaOcupada.getPosition();
        return latlonge;
    }


    @Override
    public void onMapReady(GoogleMap map) {
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(
                new LatLng(-24.043190, -52.378492), 6));
        map.addMarker(new MarkerOptions()
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.number2green))
                .anchor(0.0f, 1.0f) // Anchors the marker on the bottom left
                .position(new LatLng(-24.043190, -52.378492)));
        map.addMarker(new MarkerOptions()
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.number1red))
                .anchor(0.0f, 1.0f) // Anchors the marker on the bottom left
                .position(new LatLng(-24.043190, -52.378491)));

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        RelativeLayout mainLayout =
                (RelativeLayout) findViewById(R.id.map);
        switch (item.getItemId()) {
            case R.id.action_settings:
//                if (item.isChecked()) item.setChecked(false);
//                else item.setChecked(true);
//                mainLayout.setBackgroundColor(android.graphics.Color.RED);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

}


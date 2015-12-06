package com.utfpr.hgoncalves.minhavaga.Activity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.method.KeyListener;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageButton;
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

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Main2Activity extends FragmentActivity implements OnMapReadyCallback {


    private GoogleMap mMap;
    private Marker markerVagaVazia;
    private Marker markerVagaOcupada;

    private ImageButton btnAdd;
    private ImageButton btnSearch;
    private EditText edtBuscar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync((OnMapReadyCallback) this);


        btnAdd = (ImageButton) findViewById(R.id.btnAdd);
        btnSearch = (ImageButton) findViewById(R.id.btnSearch);
        edtBuscar = (EditText) findViewById(R.id.edtPesquisa);

        final KeyListener originalKeyListener = edtBuscar.getKeyListener();
        edtBuscar.setKeyListener(null);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edtBuscar.setKeyListener(originalKeyListener);
                edtBuscar.requestFocus();
                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.showSoftInput(edtBuscar, InputMethodManager.SHOW_IMPLICIT);



                String dePesquisa = edtBuscar.getText().toString();
                //ve como passa essa string para o asynck ali embaixo, eh uma thread de pesquisa tem se qser assim
                //pq se nao da pau no app
                //ve tbm como pega a string do campo depois de tirar o focus
                //no asynck eh uma request para o maps, ve se ta certo,
                //to com sono pakas
                // acho q vc consegue dodo;

            }
        });

        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Uri gmmIntentUri = Uri.parse("geo:37.7749,-122.4194?q=101+main+street");
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                startActivity(mapIntent);

            }
        });


        edtBuscar.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    // Hide soft keyboard.
                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(edtBuscar.getWindowToken(), 0);
                    // Make it non-editable again.
                    edtBuscar.setKeyListener(null);
                }
            }

           // public void onFocus

        });

        edtBuscar.setOnFocusChangeListener(new View);


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

    private class GetPlaces extends AsyncTask<String, Void, String> {
//fetch and parse place data

        protected String doInBackground(String... placesURL) {
            StringBuilder placesBuilder = new StringBuilder();
            for (String placeSearchURL : placesURL) {
                try {
                    HttpGet placesGet = new HttpGet(placeSearchURL);
                    HttpClient placesClient = new DefaultHttpClient();
                    HttpResponse placesResponse = placesClient.execute(placesGet);
                    StatusLine placeSearchStatus = placesResponse.getStatusLine();
                    if (placeSearchStatus.getStatusCode() == 200) {
                        HttpEntity placesEntity = placesResponse.getEntity();
                        InputStream placesContent = placesEntity.getContent();
                        InputStreamReader placesInput = new InputStreamReader(placesContent);
                        BufferedReader placesReader = new BufferedReader(placesInput);
                        String lineIn;
                        while ((lineIn = placesReader.readLine()) != null) {
                            placesBuilder.append(lineIn);
                        }
                        return placesBuilder.toString();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            return null;
        }
    }
}


package com.utfpr.hgoncalves.minhavaga.Activity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.method.KeyListener;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageButton;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestFactory;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.HttpResponse;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.JsonObjectParser;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.util.Key;
import com.utfpr.hgoncalves.minhavaga.R;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends FragmentActivity implements OnMapReadyCallback {


    private static final String PLACES_API_AUTOCOMPLETION = "Campo Mourão" ;
    private GoogleMap mMap;
    private Marker markerVagaVazia;
    private Marker markerVagaOcupada;
    private ImageButton btnAdd;
    private ImageButton btnSearch;
    private EditText edtBuscar;


    private static final String PLACES_API_KEY = "AIzaSyB1k1X5cGfk1Wma3ewD2Xg-FmFSOOnK_J4";


    private static final HttpTransport HTTP_TRANSPORT = AndroidHttp.newCompatibleTransport();
    private static final JsonFactory JSON_FACTORY = new JacksonFactory();

    private static final String PLACES_AUTOCOMPLETE_API = "https://maps.googleapis.com/maps/api/place/autocomplete/json";

    protected static final int RESULT_CODE = 123;
    private AutoCompleteTextView from;
    private AutoCompleteTextView to;

    @Override
    protected void onCreate(Bundle arg0) {
        super.onCreate(arg0);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync((OnMapReadyCallback) this);


        btnAdd = (ImageButton) findViewById(R.id.btnAdd);
        btnSearch = (ImageButton) findViewById(R.id.btnSearch);
        edtBuscar = (EditText) findViewById(R.id.edtPesquisa);


        //to = (EditText) findViewById(R.id.to);
//        Button btnLoadDirections = (Button) findViewById(R.id.load_directions);


        btnSearch.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent data = new Intent();
                data.putExtra("from", from.getText().toString());
                data.putExtra("to", to.getText().toString());
                Main2Activity.this.setResult(RESULT_CODE, data);
                Main2Activity.this.finish();
            }
        });

        final KeyListener originalKeyListener = edtBuscar.getKeyListener();
        edtBuscar.setKeyListener(null);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edtBuscar.setKeyListener(originalKeyListener);
                edtBuscar.requestFocus();
                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.showSoftInput(edtBuscar, InputMethodManager.SHOW_IMPLICIT);


            }
        });

        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Uri gmmIntentUri = Uri.parse("geo:37.7749,-122.4194?q=101+main+street");
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                startActivity(mapIntent);


                GenericUrl url = new GenericUrl(PLACES_API_AUTOCOMPLETION);
                url.put("input", input);
                url.put("key", PLACES_API_KEY);
                url.put("sensor", false);


                HttpRequestFactory requestFactory;
                url  = "https://maps.googleapis.com/maps/api/place/autocomplete/json?input=Fisher&key=[YOUR API KEY]&sensor=false"


                HttpRequest request = requestFactory.buildGetRequest(url);

                HttpResponse httpResponse = request.execute();
                PlacesResult directionsResult = null;
                try {
                    directionsResult = httpResponse.parseAs(PlacesResult.class);
                } catch (IOException e) {
                    e.printStackTrace();
                }

                List<Prediction> predictions = directionsResult.predictions;
                for (Prediction prediction : predictions) {
                    resultList.add(prediction.description);
                }

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

       // edtBuscar.setOnFocusChangeListener(new View);


//        GoogleMap map = mapFragment.getMap();
//        LatLng sydney = new LatLng(-24.043190, -52.378492);
//        map.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
//        map.moveCamera(CameraUpdateFactory.newLatLng(sydney));




//        from = (AutoCompleteTextView) findViewById(R.id.from);
//        to = (AutoCompleteTextView) findViewById(R.id.to);

        //   from.setText("Fisherman's Wharf, San Francisco, CA, United States");
//        to.setText("The Moscone Center, Howard Street, San Francisco, CA, United States");
        edtBuscar.setAdapter(new PlacesAutoCompleteAdapter(this, android.R.layout.simple_dropdown_item_1line));
      //  to.setAdapter(new PlacesAutoCompleteAdapter(this, android.R.layout.simple_dropdown_item_1line));

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

    private class PlacesAutoCompleteAdapter extends ArrayAdapter<String> implements Filterable {
        private ArrayList<String> resultList;

        public PlacesAutoCompleteAdapter(Context context, int textViewResourceId) {
            super(context, textViewResourceId);
        }

        @Override
        public int getCount() {
            return resultList.size();
        }

        @Override
        public String getItem(int index) {
            return resultList.get(index);
        }

        @Override
        public Filter getFilter() {
            Filter filter = new Filter() {
                @Override
                protected FilterResults performFiltering(CharSequence constraint) {
                    FilterResults filterResults = new FilterResults();
                    if (constraint != null) {
                        // Retrieve the autocomplete results.
                        resultList = autocomplete(constraint.toString());

                        // Assign the data to the FilterResults
                        filterResults.values = resultList;
                        filterResults.count = resultList.size();
                    }
                    return filterResults;
                }

                @Override
                protected void publishResults(CharSequence constraint, FilterResults results) {
                    if (results != null && results.count > 0) {
                        notifyDataSetChanged();
                    } else {
                        notifyDataSetInvalidated();
                    }
                }
            };
            return filter;
        }
    }

    private ArrayList<String> autocomplete(String input) {

        ArrayList<String> resultList = new ArrayList<String>();

        try {

            HttpRequestFactory requestFactory = HTTP_TRANSPORT.createRequestFactory(new HttpRequestInitializer() {
                                                                                        @Override
                                                                                        public void initialize(com.google.api.client.http.HttpRequest request) throws IOException {
                                                                                            request.setParser(new JsonObjectParser(JSON_FACTORY));
                                                                                        }

//                                                                                        @Override
//                                                                                        public void initialize(HttpRequest request) {
//
//                                                                                        }
                                                                                    }
            );

            GenericUrl url = new GenericUrl(PLACES_AUTOCOMPLETE_API);
            url.put("input", input);
            url.put("key", PLACES_API_KEY);
            url.put("sensor", false);

            com.google.api.client.http.HttpRequest request = requestFactory.buildGetRequest(url);
            com.google.api.client.http.HttpResponse httpResponse = request.execute();
            PlacesResult directionsResult = httpResponse.parseAs(PlacesResult.class);

            List<Prediction> predictions = directionsResult.predictions;
            for (Prediction prediction : predictions) {
                resultList.add(prediction.description);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return resultList;
    }

    public static class PlacesResult {

        @Key("predictions")
        public List<Prediction> predictions;

    }

    public static class Prediction {
        @Key("description")
        public String description;

        @Key("id")
        public String id;

    }


//
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main2);
//
//        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
//                .findFragmentById(R.id.map);
//        mapFragment.getMapAsync((OnMapReadyCallback) this);
//
//
//        btnAdd = (ImageButton) findViewById(R.id.btnAdd);
//        btnSearch = (ImageButton) findViewById(R.id.btnSearch);
//        edtBuscar = (EditText) findViewById(R.id.edtPesquisa);
//
//        final KeyListener originalKeyListener = edtBuscar.getKeyListener();
//        edtBuscar.setKeyListener(null);
//        btnAdd.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                edtBuscar.setKeyListener(originalKeyListener);
//                edtBuscar.requestFocus();
//                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
//                imm.showSoftInput(edtBuscar, InputMethodManager.SHOW_IMPLICIT);
//
//
//
////                String dePesquisa = edtBuscar.getText().toString();
////                String getPlaces = new GetPlaces().toString();
////                Log.e("ERRO", getPlaces);
//
//                //ve como passa essa string para o asynck ali embaixo, eh uma thread de pesquisa tem se qser assim
//                //pq se nao da pau no app
//                //ve tbm como pega a string do campo depois de tirar o focus
//                //no asynck eh uma request para o maps, ve se ta certo,
//                //to com sono pakas
//                // acho q vc consegue dodo;
//
//
//
//
//
//
//            }
//        });
//
//        btnSearch.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//
//                Uri gmmIntentUri = Uri.parse("geo:37.7749,-122.4194?q=101+main+street");
//                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
//                mapIntent.setPackage("com.google.android.apps.maps");
//                startActivity(mapIntent);
//
//
//                GenericUrl url = new GenericUrl(PLACES_API_AUTOCOMPLETION);
//                url.put("input", input);
//                url.put("key", PLACES_API_KEY);
//                url.put("sensor", false);
//
//
//
//                https://maps.googleapis.com/maps/api/place/autocomplete/json?input=Fisher&key=[YOUR API KEY]&sensor=false
//
//
//                HttpRequest request = requestFactory.buildGetRequest(url);
//
//                HttpResponse httpResponse = request.execute();
//                PlacesResult directionsResult = httpResponse.parseAs(PlacesResult.class);
//
//                List<Prediction> predictions = directionsResult.predictions;
//                for (Prediction prediction : predictions) {
//                    resultList.add(prediction.description);
//                }
//
//            }
//        });
//
//
//        edtBuscar.setOnFocusChangeListener(new View.OnFocusChangeListener() {
//            @Override
//            public void onFocusChange(View v, boolean hasFocus) {
//                if (!hasFocus) {
//                    // Hide soft keyboard.
//                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
//                    imm.hideSoftInputFromWindow(edtBuscar.getWindowToken(), 0);
//                    // Make it non-editable again.
//                    edtBuscar.setKeyListener(null);
//                }
//            }
//
//           // public void onFocus
//
//        });
//
//       // edtBuscar.setOnFocusChangeListener(new View);
//
//
////        GoogleMap map = mapFragment.getMap();
////        LatLng sydney = new LatLng(-24.043190, -52.378492);
////        map.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
////        map.moveCamera(CameraUpdateFactory.newLatLng(sydney));
//
//    }
//
//
//    HttpRequestFactory requestFactory = HTTP_TRANSPORT.createRequestFactory(new HttpRequestInitializer() {
//                                                                                @Override
//                                                                                public void initialize(HttpRequest request) {
//                                                                                    request.setParser(new JsonObjectParser(JSON_FACTORY));
//                                                                                }
//                                                                            }
//    );
//
//
//    public LatLng getLocalizacaoVagaVaziaMarker() {
//        LatLng latlonge = markerVagaVazia.getPosition();
//        return latlonge;
//    }
//
//    public LatLng getLocalizacaoVagaOcupadaMarker() {
//        LatLng latlonge = markerVagaOcupada.getPosition();
//        return latlonge;
//    }
//
//

//
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.main, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        RelativeLayout mainLayout =
//                (RelativeLayout) findViewById(R.id.map);
//        switch (item.getItemId()) {
//            case R.id.action_settings:
////                if (item.isChecked()) item.setChecked(false);
////                else item.setChecked(true);
////                mainLayout.setBackgroundColor(android.graphics.Color.RED);
//                return true;
//
//            default:
//                return super.onOptionsItemSelected(item);
//        }
//    }
//
//    private class GetPlaces extends AsyncTask<String, Void, String> {
//        protected String doInBackground(URL... urls) {
//            try {
//                HttpRequestFactory requestFactory = HTTP_TRANSPORT.createRequestFactory(new HttpRequestInitializer() {
//                    @Override
//                    public void initialize(HttpRequest request) {
//                        request.setParser(new JsonObjectParser(JSON_FACTORY));
//                    }
//                });
//
//                GenericUrl url = new GenericUrl("http://maps.googleapis.com/maps/api/directions/json");
//                url.put("origin", "Chicago,IL");
//                url.put("destination", "Los Angeles,CA");
//                url.put("sensor",false);
//
//                HttpRequest request = requestFactory.buildGetRequest(url);
//                HttpResponse httpResponse = request.execute();
//                DirectionsResult directionsResult = httpResponse.parseAs(DirectionsResult.class);
//                String encodedPoints = directionsResult.routes.get(0).overviewPolyLine.points;
//                latLngs = PolyUtil.decode(encodedPoints);
//            } catch (Exception ex) {
//                ex.printStackTrace();
//            }
//            return null;
//        }
//
//        protected void onProgressUpdate(Integer... progress) {
//        }
//
//        protected void onPostExecute(String result) {
//            clearMarkers();
//            addMarkersToMap(latLngs);
//        }
//    }
//
//
//
//    private class PlacesAutoCompleteAdapter extends ArrayAdapter<String> implements Filterable {
//        private ArrayList<String> resultList;
//
//        public PlacesAutoCompleteAdapter(Context context, int textViewResourceId) {
//            super(context, textViewResourceId);
//        }
//
//        @Override
//        public int getCount() {
//            return resultList.size();
//        }
//
//        @Override
//        public String getItem(int index) {
//            return resultList.get(index);
//        }
//
//        @Override
//        public Filter getFilter() {
//            Filter filter = new Filter() {
//                @Override
//                protected FilterResults performFiltering(CharSequence constraint) {
//                    FilterResults filterResults = new FilterResults();
//                    if (constraint != null) {
//                        // Retrieve the autocomplete results.
//                        resultList = autocomplete(constraint.toString());
//
//                        // Assign the data to the FilterResults
//                        filterResults.values = resultList;
//                        filterResults.count = resultList.size();
//                    }
//                    return filterResults;
//                }
//
//                @Override
//                protected void publishResults(CharSequence constraint, FilterResults results) {
//                    if (results != null && results.count > 0) {
//                        notifyDataSetChanged();
//                    }
//                    else {
//                        notifyDataSetInvalidated();
//                    }
//                }};
//            return filter;
//        }
//    }
}


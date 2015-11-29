//package com.utfpr.hgoncalves.minhavaga.Activity;
//
//import android.os.Bundle;
//import android.support.v7.app.AppCompatActivity;
//import android.util.Log;
//import android.view.MotionEvent;
//
//import com.google.android.gms.maps.GoogleMap;
//import com.google.android.gms.maps.OnMapReadyCallback;
//import com.google.android.gms.maps.SupportMapFragment;
//import com.google.android.gms.maps.model.LatLng;
//import com.google.android.gms.maps.model.Marker;
//import com.utfpr.hgoncalves.minhavaga.R;
//
//import java.util.ArrayList;
//
//public class MapsActivity extends AppCompatActivity implements OnMapReadyCallback {
//
//    private GoogleMap mMap;
//    private Marker markerVagaVazia;
//    private Marker markerVagaOcupada;
//
//    private ArrayList<com.utfpr.hgoncalves.minhavaga.Model.Vaga> vagas;
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//
//        setContentView(R.layout.activity_maps);
//        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
//        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
//                .findFragmentById(R.id.map);
//        mapFragment.getMapAsync(this);
//
//
//}
//
//
//
//    @Override
//    public void onMapReady(GoogleMap googleMap) {
//        mMap = googleMap;
//        if(mMap!=null){
//            mMap.setMyLocationEnabled(true);
//        }
//
//
////    // Google map init block
//    CustomMapFragment customMapFragment = ((CustomMapFragment) getSupportFragmentManager().findFragmentById(R.id.map));
//    customMapFragment.setOnDragListener(new MapWrapperLayout.OnDragListener() {
//        @Override
//        public void onDrag(MotionEvent motionEvent) {
//            Log.d("ON_DRAG", String.format("ME: %s", motionEvent));
//        }
//
//
////    });
//    GoogleMap map = customMapFragment.getMap();
//        LatLng sydney = new LatLng(-24.043190, -52.378492);
//        map.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
//        map.moveCamera(CameraUpdateFactory.newLatLng(sydney));
//
////        mMap.addMarker(new MarkerOptions()
////                .icon(BitmapDescriptorFactory.fromResource(R.drawable.number34))
////                .anchor(0.0f, 1.0f) // Anchors the marker on the bottom left
////                .position(new LatLng(-24.043190, -52.378492)));
////
////
//////        MapFragment mapFrag = (MapFragment) FragmentManager.FindFragmentById(Resource.Id.my_mapfragment_container);
////
////
////        map.addMarker(new MarkerOptions()
////                .icon(BitmapDescriptorFactory.fromResource(R.drawable.number36))
////                .anchor(0.0f, 1.0f) // Anchors the marker on the bottom left
////                .position(new LatLng(-24.043190, -52.378491)));
//
//
//        UiSettings ui = mMap.getUiSettings();
//        ui.setZoomControlsEnabled(true);
//
//        MarkerOptions MVagaVazia =  new MarkerOptions()
//                .icon(BitmapDescriptorFactory
//                        .fromResource(R.drawable.number7green))
//                .anchor(0.0f, 1.0f); // Anchors the marker on the bottom left
//
//        MVagaVazia.position(new LatLng(-24.043190, -52.378492));
//        MVagaVazia.draggable(true);
//
//
//
//        MarkerOptions MvagaOcupada  = new MarkerOptions()
//                .icon((BitmapDescriptorFactory
//                        .fromResource(R.drawable.number1red)))
//                .anchor(0.0f, 1.0f);
//        MvagaOcupada.position(new LatLng(-24.02, -52.378492));
//        MvagaOcupada.draggable(true);
////        MarkerOptions mo = new MarkerOptions();
////        mo.position(new LatLng(-24.045833, -52.382778));
////        mo.draggable(true);
//
//        markerVagaVazia = mMap.addMarker(MVagaVazia);
//        markerVagaVazia.setDraggable(true);
//
//        markerVagaOcupada = mMap.addMarker(MvagaOcupada);
//        markerVagaOcupada.setDraggable(true);
//
//        if( markerVagaVazia.isDraggable()){
//            Log.e("Draggable", "Sim");
//            markerVagaVazia.setTitle("Vaga Vazias");
//            LatLng ln = getLocalizacaoVagaVaziaMarker();
//            markerVagaVazia.setPosition(ln);
//       } else {
//            Log.e("Draggable","No");
//        }
//
//        if( markerVagaOcupada.isDraggable()){
//            Log.e("Draggable", "Sim");
//            markerVagaOcupada.setTitle("Vaga Ocupadas");
//            LatLng ln = getLocalizacaoVagaOcupadaMarker();
//            markerVagaOcupada.setPosition(ln);
//        } else {
//            Log.e("Draggable","No");
//        }
//
//    }
//
//    public LatLng getLocalizacaoVagaVaziaMarker() {
//        LatLng latlonge =  markerVagaVazia.getPosition();
//        return latlonge;
//    }
//    public LatLng getLocalizacaoVagaOcupadaMarker() {
//        LatLng latlonge =  markerVagaOcupada.getPosition();
//        return latlonge;
//    }
//
//
////    @Override
////    public void onMapReady(GoogleMap map) {
////        map.moveCamera(CameraUpdateFactory.newLatLngZoom(
////                new LatLng(-24.043190, -52.378492), 6));
////
////        // You can customize the marker image using images bundled with
////        // your app, or dynamically generated bitmaps.
////        map.addMarker(new MarkerOptions()
////                .icon(BitmapDescriptorFactory.fromResource(R.drawable.number34))
////                .anchor(0.0f, 1.0f) // Anchors the marker on the bottom left
////                .position(new LatLng(-24.043190, -52.378492)));
////
////
//////        MapFragment mapFrag = (MapFragment) FragmentManager.FindFragmentById(Resource.Id.my_mapfragment_container);
////
////
////        map.addMarker(new MarkerOptions()
////                .icon(BitmapDescriptorFactory.fromResource(R.drawable.number36))
////                .anchor(0.0f, 1.0f) // Anchors the marker on the bottom left
////                .position(new LatLng(-24.043190, -52.378491)));
////
////    }
//
//    /**
//     * Manipulates the map once available.
//     * This callback is triggered when the map is ready to be used.
//     * This is where we can add markers or lines, add listeners or move the camera. In this case,
//     * we just add a marker near Sydney, Australia.
//     * If Google Play services is not installed on the device, the user will be prompted to install
//     * it inside the SupportMapFragment. This method will only be triggered once the user has
//     * installed Google Play services and returned to the app.
//     */
////    @Override
////    public void onMapReady(GoogleMap googleMap) {
////        mMap = googleMap;
////
////        // Add a marker in Sydney and move the camera
////        LatLng sydney = new LatLng(-24.043190, -52.378492);
////        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
////        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
////    }
//}

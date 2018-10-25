package com.valencia.ambulanceroute;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class ActivityMapa extends FragmentActivity implements OnMapReadyCallback, GoogleMap.OnMarkerClickListener {

    private GoogleMap mMap;
    private MarkerOptions marcador;
    private MarkerOptions marcador2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mapa);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;LatLng posicion = new LatLng(2.483312, -76.561909);

        marcador = new MarkerOptions();
        marcador.position(posicion);
        marcador.title("Sena Norte");

        LatLng posicion2 = new LatLng(2.487001, -76.560365);
        marcador2 = new MarkerOptions();
        marcador2.position(posicion2);
        marcador2.title("Terraplaza");

        mMap.addMarker(new MarkerOptions().icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_launcher_marcador)).anchor(0.0f,1.0f).position(posicion).title("Sena Norte"));
        mMap.addMarker(new MarkerOptions().icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_launcher_marcador)).anchor(0.0f,1.0f).position(posicion2).title("Terraplaza"));

        mMap.setOnMarkerClickListener(this);

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(posicion,16));
    }

    @Override
    public boolean onMarkerClick(Marker marker) {
        if (marker.getTitle().equalsIgnoreCase(marcador.getTitle())){

            Intent siguiente = new Intent(ActivityMapa.this, ActivityImagen.class);
            startActivity(siguiente);

        }else if (marker.getTitle().equalsIgnoreCase(marcador2.getTitle())){

            Intent siguiente = new Intent(ActivityMapa.this, ActivityImagen.class);
            startActivity(siguiente);
        }

        return false;
    }
}

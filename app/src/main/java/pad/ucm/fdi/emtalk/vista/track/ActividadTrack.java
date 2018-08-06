package pad.ucm.fdi.emtalk.vista.track;

import android.app.Activity;
import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import pad.ucm.fdi.emtalk.R;
import pad.ucm.fdi.emtalk.modelo.GestorConexion;
import pad.ucm.fdi.emtalk.modelo.tiposApi.Arrive;
import pad.ucm.fdi.emtalk.modelo.tiposApi.ListaLinea;
import pad.ucm.fdi.emtalk.modelo.tiposApi.ListaLlegadas;
import pad.ucm.fdi.emtalk.modelo.tiposApi.RouteLineItem;
import pad.ucm.fdi.emtalk.modelo.tiposApi.SnappedPoint;
import pad.ucm.fdi.emtalk.modelo.tiposApi.SnappedPoints;
import pad.ucm.fdi.emtalk.vista.Observer;

public class ActividadTrack extends AppCompatActivity implements OnMapReadyCallback, Observer {

    //Objetos vista
    private GoogleMap mMap;
    private Marker parada;
    private List<Marker> marcadores;
    private PolylineOptions lines, lines2;

    //logica
    private GestorConexion gestor;
    private Timer alarm;

    //datos
    private String  idBus, idLine;
    private int idStop;

    private boolean cuadrao;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R .layout.activity_actividad_track2);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        marcadores = new ArrayList<>();
        gestor = (GestorConexion) getApplication();
        idBus = getIntent().getStringExtra("idBus");
        idStop = getIntent().getIntExtra("idStop", 0);
        idLine = getIntent().getStringExtra("idLine");
        gestor.getLlegadas(String.valueOf(idStop));
        gestor.addObserver(this);
        alarm = new Timer();
        alarm.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                gestor.getLlegadas(String.valueOf(idStop));
                Log.d("PRUEBA", "NUEVA UBI");
            }
        }, 0, 3000);
        gestor.getRouteLine(idLine);
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
        mMap = googleMap;

        // Add a marker in Sydney and move the camera

    }

    @Override
    public void updateStop(ListaLlegadas llegadas) {
        int j = 0;
        for (Arrive i: llegadas.getArrives()) {
            if (i.getLineId().equals(idLine)) {
                LatLng sydney = new LatLng(i.getLatitude(), i.getLongitude());
                if (marcadores.size() > 1) {
                    AnimationUtil.animateMarkerToGB(marcadores.get(j), sydney,new LatLngInterpolator.LinearFixed());
                    j++;
                } else {
                    marcadores.add(mMap.addMarker(new MarkerOptions().position(sydney).title("Bus "+ i.getLineId()).icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE))));
                }
            }

        }
        cuadrar();
    }

    @Override
    public void updateRoute(ListaLinea route) {
        lines = new PolylineOptions();
        for (RouteLineItem i: route.getResultValues()) {
            if (i.getSecDetail() == 19) {
                lines.add(new LatLng(i.getLatitude(),i.getLongitude()));
            } else if(i.getSecDetail() == 10) {
                if (i.getNode() == idStop) {
                    parada = mMap.addMarker(new MarkerOptions().icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_stop2)).anchor(0.5f, 0.5f).position(new LatLng(i.getLatitude(),i.getLongitude())));
                    lines.color(getResources().getColor(R.color.colorPrimary));
                }
                else mMap.addMarker(new MarkerOptions().icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_stop)).anchor(0.5f, 0.5f).position(new LatLng(i.getLatitude(),i.getLongitude())));
            }
        }
        lines.width(6);
        lines.geodesic(true);
        mMap.addPolyline(lines);

        lines = new PolylineOptions();
        for (RouteLineItem i: route.getResultValues()) {
            if (i.getSecDetail() == 29) {
                lines.add(new LatLng(i.getLatitude(),i.getLongitude()));
            } else if(i.getSecDetail() == 20) {
                if (i.getNode() == idStop) {
                    parada = mMap.addMarker(new MarkerOptions().icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_stop2)).anchor(0.5f, 0.5f).position(new LatLng(i.getLatitude(),i.getLongitude())));
                    lines.color(getResources().getColor(R.color.colorPrimary));
                }
                else mMap.addMarker(new MarkerOptions().icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_stop)).anchor(0.5f, 0.5f).position(new LatLng(i.getLatitude(),i.getLongitude())));
            }
        }
        lines.width(6);
        lines.geodesic(true);
        mMap.addPolyline(lines);

        cuadrar();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    @Override
    public void onBackPressed() {
        alarm.cancel();
        super.onBackPressed();
    }
    private void cuadrar() {
        if (!cuadrao) {
            if (marcadores.size() > 1 && parada != null) {
                LatLngBounds.Builder builder = LatLngBounds.builder();
                builder.include(parada.getPosition());
                builder.include(marcadores.get(0).getPosition());
                builder.include(marcadores.get(1).getPosition());
                mMap.animateCamera(CameraUpdateFactory.newLatLngBounds(builder.build(), 10));
                cuadrao = true;
            }
        }
    }
}

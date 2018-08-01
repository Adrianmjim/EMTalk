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

import java.util.Timer;
import java.util.TimerTask;

import pad.ucm.fdi.emtalk.R;
import pad.ucm.fdi.emtalk.modelo.GestorConexion;
import pad.ucm.fdi.emtalk.modelo.tiposApi.ListaLinea;
import pad.ucm.fdi.emtalk.modelo.tiposApi.ListaLlegadas;
import pad.ucm.fdi.emtalk.modelo.tiposApi.RouteLineItem;
import pad.ucm.fdi.emtalk.vista.Observer;

public class ActividadTrack extends AppCompatActivity implements OnMapReadyCallback, Observer {

    private GoogleMap mMap;
    private GestorConexion gestor;
    private Timer alarm;

    private String  idBus, idLine;
    private int idStop;
    private PolylineOptions lines;


    private Marker marcador;
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
        int i = 0;
        while (i < llegadas.getArrives().size() && !llegadas.getArrives().get(i).getBusId().equals(idBus)) i++;
        if (i < llegadas.getArrives().size()) {
            LatLng sydney = new LatLng(llegadas.getArrives().get(i).getLatitude(), llegadas.getArrives().get(i).getLongitude());
            if (marcador == null) marcador = mMap.addMarker(new MarkerOptions().position(sydney).title("Bus "+ llegadas.getArrives().get(i).getLineId()));
            else AnimationUtil.animateMarkerToGB(marcador, sydney,new LatLngInterpolator.Spherical()
            );

        } else {
            Snackbar mySnackbar = Snackbar.make(getWindow().getDecorView().getRootView(), "No se puede seguir trackeando este autobus.", Snackbar.LENGTH_INDEFINITE);
            mySnackbar.show();
        }
    }

    @Override
    public void updateRoute(ListaLinea route) {
        lines = new PolylineOptions();
        LatLngBounds.Builder builder = LatLngBounds.builder();
        for (RouteLineItem i: route.getResultValues()) {
            if(i.getSecDetail() == 19){
                builder.include(new LatLng(i.getLatitude(),i.getLongitude()));
                lines.add(new LatLng(i.getLatitude(), i.getLongitude()));
            } else if (i.getSecDetail() == 10) {
                mMap.addMarker(new MarkerOptions().title(i.getName()).position(new LatLng(i.getLatitude(), i.getLongitude())).icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_circle)));
            }

        }

        for (RouteLineItem i: route.getResultValues()) {
            if(i.getSecDetail() == 29){
                builder.include(new LatLng(i.getLatitude(),i.getLongitude()));
                lines.add(new LatLng(i.getLatitude(), i.getLongitude()));
            } else if (i.getSecDetail() == 20) {
                mMap.addMarker(new MarkerOptions().title(i.getName()).position(new LatLng(i.getLatitude(), i.getLongitude())).icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_circle)));
            }

        }
        lines.geodesic(true);
        CameraUpdate cu = CameraUpdateFactory.newLatLngBounds(builder.build(), 0);
        mMap.animateCamera(cu);
        Polyline line = mMap.addPolyline(lines);
        line.setColor(getResources().getColor(R.color.colorPrimary));
        line.setWidth(8);
        line.setGeodesic(true);
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
}

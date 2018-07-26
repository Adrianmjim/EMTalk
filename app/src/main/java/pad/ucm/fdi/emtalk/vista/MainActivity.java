package pad.ucm.fdi.emtalk.vista;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.MenuInflater;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.prefs.Preferences;

import pad.ucm.fdi.emtalk.R;
import pad.ucm.fdi.emtalk.modelo.GestorConexion;
import pad.ucm.fdi.emtalk.modelo.ParadaFavorita;
import pad.ucm.fdi.emtalk.modelo.tiposApi.Arrive;
import pad.ucm.fdi.emtalk.modelo.tiposApi.ListaLlegadas;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener , Observer{
    private static final int MY_CHILD_ACTIVITY = 123;
    private GestorConexion modelo;
    private RecyclerView lista;
    private AdaptadorFavoritas adaptadorFavoritas;

    private int numStop;
    private List<ParadaFavorita> stops;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar mySnackbar = Snackbar.make(view, "Este es el botón que pulsan todos los tontos. Te he pillao eh.", 15);
                mySnackbar.show();
                addStop(1512);
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        modelo = new GestorConexion();
        lista = (RecyclerView) findViewById(R.id.favoritas);
        lista.setHasFixedSize(true);
        stops = new ArrayList<>();
        // use a linear layout manager
        lista.setLayoutManager(new LinearLayoutManager(this));
        SharedPreferences set = getPreferences(0);
        numStop = set.getInt("numStop", 0);
        for (int i = 0; i < numStop; i++) {
            modelo.getLlegadas(String.valueOf(set.getInt("value"+i, 0)));
        }
        adaptadorFavoritas = new AdaptadorFavoritas(stops);

        lista.setAdapter(adaptadorFavoritas);
        modelo.addObserver(this);

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main, menu);

        final MenuItem searchItem = menu.findItem(R.id.action_search);
        final SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchItem);
        //permite modificar el hint que el EditText muestra por defecto

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                lanzar(query);
                //se oculta el EditText
                searchView.setQuery("", false);
                searchView.setIconified(true);
                return true;
            }
            @Override
            public boolean onQueryTextChange(String newText) {

                return true;
            }
        });


        return super.onCreateOptionsMenu(menu);
    }
    private void lanzar(String query) {
        Intent i = new Intent(this, ActividadParada.class);
        i.putExtra("parada", query);
        startActivityForResult(i, MY_CHILD_ACTIVITY);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    private void addStop(int stop) {
        SharedPreferences set = getPreferences(0);
        SharedPreferences.Editor editor = set.edit();
        editor.putInt("value"+numStop, stop);
        editor.putInt("numStop", ++numStop);
        modelo.getLlegadas(String.valueOf(stop));
        editor.commit();
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch(requestCode) {
            case (MY_CHILD_ACTIVITY) : {
                if (resultCode == Activity.RESULT_OK) {
                    // TODO Extract the data returned from the child Activity.
                    int returnValue = data.getIntExtra("stop", 0);
                    addStop(returnValue);

                }
                break;
            }
        }
    }

    @Override
    public void updateStop(ListaLlegadas llegadas) {
        String aux = "";
        List<String> list = new ArrayList<>();
        for (Arrive i: llegadas.getArrives()) {
            if (!list.contains(i.getBusId())) list.add(i.getBusId());
        }
        for (int i = 0; i < list.size(); i++) {
            aux += list.get(i);
            if(i < list.size()-1) aux += " - ";
        }
        stops.add(new ParadaFavorita(llegadas.getArrives().get(0).getStopId(), aux));
        adaptadorFavoritas.notifyItemInserted(stops.size());
    }
}

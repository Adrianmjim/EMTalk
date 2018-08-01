package pad.ucm.fdi.emtalk.vista.main;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.text.InputType;
import android.util.Log;
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
import android.widget.TextView;

import com.github.clans.fab.FloatingActionButton;
import com.github.clans.fab.FloatingActionMenu;

import java.util.ArrayList;
import java.util.List;

import pad.ucm.fdi.emtalk.R;
import pad.ucm.fdi.emtalk.modelo.GestorConexion;
import pad.ucm.fdi.emtalk.modelo.tiposApi.Arrive;
import pad.ucm.fdi.emtalk.modelo.tiposApi.ListaLinea;
import pad.ucm.fdi.emtalk.modelo.tiposApi.ListaLlegadas;
import pad.ucm.fdi.emtalk.vista.Observer;
import pad.ucm.fdi.emtalk.vista.llegadas.ActividadParada;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener , Observer, View.OnClickListener{
    private static final int MY_CHILD_ACTIVITY = 123;
    private GestorConexion modelo;
    private RecyclerView lista;
    private AdaptadorFavoritas adaptadorFavoritas;
    private  SwipeRefreshLayout swipeRefreshLayout;

    private int numStop;
    private List<ParadaFavorita> stops;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        final FloatingActionMenu menufab = (FloatingActionMenu) findViewById(R.id.menu);
        FloatingActionButton fab1 = (FloatingActionButton) findViewById(R.id.menu_item2);
        getSupportActionBar().setTitle("Mis paradas");
        fab1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar mySnackbar = Snackbar.make(view, "Para añadir una parada, búscala y pulsa en el botón de la parte superior derecha. Arbolito idiota.", Snackbar.LENGTH_INDEFINITE);
                mySnackbar.show();
                menufab.close(true);

            }
        });
        FloatingActionButton fab2 = (FloatingActionButton) findViewById(R.id.menu_item);
        fab2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar mySnackbar = Snackbar.make(view, "¿Eliminar todas las paradas guardadas?", Snackbar.LENGTH_INDEFINITE);
                mySnackbar.setAction("Eliminar", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        stops.removeAll(stops);
                        adaptadorFavoritas.notifyItemRangeRemoved(0, numStop);
                        SharedPreferences set = getPreferences(0);
                        SharedPreferences.Editor editor = set.edit();
                        numStop = 0;
                        editor.putInt("numStop", numStop);
                        editor.commit();
                    }
                });
                mySnackbar.show();
                menufab.close(true);
            }
        });
        swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swiperefresh2);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                int ult = stops.size();
                stops.removeAll(stops);
                adaptadorFavoritas.notifyItemRangeRemoved(0, ult);
                SharedPreferences set = getPreferences(0);
                numStop = set.getInt("numStop", 0);
                if (numStop ==  0) swipeRefreshLayout.setRefreshing(false);
                for (int i = 0; i < numStop; i++) {
                    modelo.getLlegadas(String.valueOf(set.getInt("value"+i, 0)));
                }

            }
        });
        swipeRefreshLayout.setColorSchemeColors(getResources().getColor(R.color.colorPrimary));
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        View header = navigationView.getHeaderView(0);
        ((TextView)header.findViewById(R.id.textView)).setText("Arbolito");
        ((TextView)header.findViewById(R.id.textView2)).setText("Se aceptan donaciones y vinilos. PAY ME, BITCH <3");
        modelo = (GestorConexion) getApplication();
        lista = (RecyclerView) findViewById(R.id.favoritas);
        lista.setHasFixedSize(true);
        stops = new ArrayList<>();
        // use a linear layout manager
        lista.setLayoutManager(new LinearLayoutManager(this));

        SharedPreferences set = getPreferences(0);
        numStop = set.getInt("numStop", 0);
        if (numStop > 0) swipeRefreshLayout.setRefreshing(true);
        for (int i = 0; i < numStop; i++) {
            modelo.getLlegadas(String.valueOf(set.getInt("value"+i, 0)));
        }
        adaptadorFavoritas = new AdaptadorFavoritas(this, stops);

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
        searchView.setInputType(InputType.TYPE_CLASS_NUMBER);
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
        modelo.delObserver(this);
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
        modelo.addObserver(this);
        switch(requestCode) {
            case (MY_CHILD_ACTIVITY) : {
                if (resultCode == Activity.RESULT_OK) {
                    // TODO Extract the data returned from the child Activity.
                    int returnValue = data.getIntExtra("stop", 0);
                    List<Integer> save = new ArrayList<>();
                    for (ParadaFavorita i: stops) save.add(i.getParada());
                    if (save.contains(returnValue)) {
                        AlertDialog.Builder builder = new AlertDialog.Builder(this);

// 2. Chain together various setter methods to set the dialog characteristics
                        builder.setMessage("Esta parada ya se encuentra añadida.")
                                .setTitle("ERROR DE BOBOS");

                        builder.setPositiveButton("Vale Adri. Soy tonto, no lo volveré a hacer.", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                // User clicked OK button
                                dialog.dismiss();
                            }
                        });
                        AlertDialog dialog = builder.create();
                        dialog.setCancelable(false);
                        dialog.show();
                    } else addStop(returnValue);


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
            aux += "\n"+"    "+i.getLineId()+": "+fixTime(i.getBusTimeLeft());
       }
        stops.add(new ParadaFavorita(llegadas.getArrives().get(0).getStopId(), aux));
        adaptadorFavoritas.notifyItemInserted(stops.size());
        if (stops.size() == numStop) swipeRefreshLayout.setRefreshing(false);
    }

    @Override
    public void updateRoute(ListaLinea route) {
        Log.d("PRUEBA", "LLEGAN LINEAS");
    }

    private String fixTime(Integer time) {
        if (time < 60) {
            return time.toString() + " segundos.";
        } else if (time == 999999) {
            return "Más de 20 minutos.";
        } else {
            Integer minutos = time / 60;
            Integer segundos = time % 60;
            return minutos.toString() + " minutos y " + segundos.toString() + " segundos.";
        }
    }

    @Override
    public void onClick(View view) {
        int itemPosition = lista.getChildLayoutPosition(view);
        ParadaFavorita item = stops.get(itemPosition);
        lanzar(String.valueOf(item.getParada()));
    }
}

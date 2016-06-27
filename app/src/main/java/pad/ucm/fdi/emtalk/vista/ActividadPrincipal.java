package pad.ucm.fdi.emtalk.vista;


import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;


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

import java.util.List;

import pad.ucm.fdi.emtalk.R;
import pad.ucm.fdi.emtalk.modelo.GestorConexion;
import pad.ucm.fdi.emtalk.modelo.tiposApi.Arrive;
import pad.ucm.fdi.emtalk.modelo.tiposApi.ListaLineas;
import pad.ucm.fdi.emtalk.modelo.tiposApi.ListaLlegadas;
import pad.ucm.fdi.emtalk.modelo.tiposApi.ListaParadas;

public class ActividadPrincipal extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, FragmentoBusqueda.OnFragmentInteractionListener {
    private static TextView texto;
    private GestorConexion gestor;
    private static ListaLlegadas lista;
    private static ListaLineas listaLineas;
    private static ListaParadas paradas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad_principal);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
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
        getMenuInflater().inflate(R.menu.actividad_principal, menu);
        return true;
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

        } else if (id == R.id.nav_gallery) {
            FragmentManager f = getFragmentManager();
            FragmentTransaction t = f.beginTransaction();
            FragmentoBusqueda b = FragmentoBusqueda.newInstance(null, null);
            t.add(R.id.contenedor, b);
            t.commit();
        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    public static void setLlegadas(ListaLlegadas lista2) {
        lista = lista2;
        String aux = "";
        for (int i = 0; i < lista.getArrives().size(); i++) {
            aux += lista.getArrives().get(i).toString();
            aux += "\n";
        }
        texto.setText(aux);
    }
    public static void setLineas(ListaLineas lista) {
        listaLineas = lista;
        texto.setText(lista.getResultDescription());
    }
    public static void setParadas(ListaParadas lista3) {
        paradas = lista3;
        texto.setText(paradas.getDestination()+ paradas.getLabel());
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}

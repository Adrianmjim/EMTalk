package pad.ucm.fdi.emtalk.vista;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Canvas;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import pad.ucm.fdi.emtalk.modelo.GestorConexion;
import pad.ucm.fdi.emtalk.modelo.tiposApi.Arrive;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import pad.ucm.fdi.emtalk.R;
import pad.ucm.fdi.emtalk.modelo.tiposApi.ListaLlegadas;


public class ActividadParada extends AppCompatActivity implements Observer{

    private static TextView parada;
    private RecyclerView vistaPrueba;
    private AdaptadorLlegada adapter;
    private RecyclerView.LayoutManager layout;
    private List<Arrive> info;
    private SwipeRefreshLayout swipeRefreshLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {



        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad_parada);
        Bundle b = getIntent().getExtras();
        final String parada = b.getString("parada");
        final GestorConexion g = new GestorConexion();
        this.parada = (TextView) findViewById(R.id.paradaAsiganada);
        vistaPrueba = (RecyclerView) findViewById(R.id.my_recycler_view);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        vistaPrueba.setHasFixedSize(true);
        swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swiperefresh);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                int ult = info.size();
                info.removeAll(info);
                adapter.notifyItemRangeRemoved(0, ult);
                g.getLlegadas(parada);
            }
        });
        swipeRefreshLayout.setColorSchemeColors(getResources().getColor(R.color.colorPrimary));
        // use a linear layout manager
        layout = new LinearLayoutManager(this);
        vistaPrueba.setLayoutManager(layout);
        info = new ArrayList<Arrive>();
        // specify an adapter (see also next example)
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        swipeRefreshLayout.setRefreshing(true);
        g.getLlegadas(parada);
        g.addObserver(this);


    }
    private void setInfo(ListaLlegadas l) {
        info = l.getArrives();
        adapter = new AdaptadorLlegada(l.getArrives());
        vistaPrueba.setAdapter(adapter);
        String aux = "Parada "+ info.get(0).getStopId().toString();
        this.parada.setText(aux);
        Log.d("PRUEBA", "LLEGA");

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.parada, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
            case R.id.add_phrase:
                Intent resultIntent = new Intent();
                resultIntent.putExtra("stop", info.get(0).getStopId());
                setResult(Activity.RESULT_OK, resultIntent);
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void updateStop(ListaLlegadas llegadas) {
        setInfo(llegadas);
        swipeRefreshLayout.setRefreshing(false);
    }
}
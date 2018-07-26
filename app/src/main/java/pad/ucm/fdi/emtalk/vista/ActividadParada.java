package pad.ucm.fdi.emtalk.vista;

import android.graphics.Canvas;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import pad.ucm.fdi.emtalk.modelo.GestorConexion;
import pad.ucm.fdi.emtalk.modelo.tiposApi.Arrive;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import pad.ucm.fdi.emtalk.R;
import pad.ucm.fdi.emtalk.modelo.tiposApi.ListaLlegadas;
import pad.ucm.fdi.emtalk.vista.AdaptadorLlegada;

public class ActividadParada extends AppCompatActivity {

    private static TextView parada;
    private RecyclerView vistaPrueba;
    private AdaptadorLlegada adapter;
    private RecyclerView.LayoutManager layout;
    private List<Arrive> info;


    @Override
    protected void onCreate(Bundle savedInstanceState) {



        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad_parada);
        Bundle b = getIntent().getExtras();
        String parada = b.getString("parada");
        GestorConexion g = new GestorConexion(this);
        this.parada = (TextView) findViewById(R.id.paradaAsiganada);
        vistaPrueba = (RecyclerView) findViewById(R.id.my_recycler_view);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        vistaPrueba.setHasFixedSize(true);

        // use a linear layout manager
        layout = new LinearLayoutManager(this);
        vistaPrueba.setLayoutManager(layout);
        info = new ArrayList<Arrive>();
        // specify an adapter (see also next example)


        g.getLlegadas(parada);



    }
    public void setInfo(ListaLlegadas l) {
        info = l.getArrives();
        adapter = new AdaptadorLlegada(l.getArrives());
        vistaPrueba.setAdapter(adapter);
        String aux = "Parada "+ info.get(0).getStopId().toString();
        this.parada.setText(aux);
        Log.d("PRUEBA", "LLEGA");

    }




}
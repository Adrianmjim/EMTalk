package pad.ucm.fdi.emtalk.vista;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import pad.ucm.fdi.emtalk.modelo.GestorConexion;
import pad.ucm.fdi.emtalk.modelo.tiposApi.Arrive;

import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import pad.ucm.fdi.emtalk.R;
import pad.ucm.fdi.emtalk.modelo.tiposApi.ListaLlegadas;
import pad.ucm.fdi.emtalk.vista.adaptadores.AdaptadorLlegada;

public class ActividadParada extends AppCompatActivity {
    private ListView lista;
    private static TextView parada;
    private static List<Arrive> info;
    private static AdaptadorLlegada adaptador;
    private static ListView vista;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad_parada);
        Bundle b = getIntent().getExtras();
        String parada = b.getString("parada");
        GestorConexion g = new GestorConexion(this);
        this.parada = (TextView) findViewById(R.id.paradaAsiganada);
        vista = (ListView) findViewById(R.id.listaLLegada);
        info = new ArrayList<Arrive>();

        g.getLlegadas(parada);







    }
    public void setInfo(ListaLlegadas l) {
        info = l.getArrives();
        adaptador = new AdaptadorLlegada(this, info);
        vista.setAdapter(adaptador);
        String aux = "Parada "+ info.get(0).getStopId().toString();
        this.parada.setText(aux);

    }




}

package pad.ucm.fdi.emtalk.vista.adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import pad.ucm.fdi.emtalk.R;
import pad.ucm.fdi.emtalk.modelo.tiposApi.Arrive;
/**
 * Created by adrian on 27/06/16.
 */
public class AdaptadorLlegada extends ArrayAdapter<Arrive> {

    public AdaptadorLlegada(Context context, List<Arrive> llegada) {
        super(context, R.layout.view_lista, llegada);
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        Arrive a = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.view_lista, parent, false);
        }
        // Lookup view for data population
        TextView autobus = (TextView) convertView.findViewById(R.id.autobus);
        TextView tiempo = (TextView) convertView.findViewById(R.id.tiempo);
        // Populate the data into the template view using the data object
        autobus.setText(a.getLineId());
        tiempo.setText(fixTime(a.getBusTimeLeft()));
        // Return the completed view to render on screen
        return convertView;
    }
    private String fixTime(Integer time) {
        if (time < 60) {
            return time.toString() + " seg.";
        } else if (time == 999999) {
            return ">20 min.";
        } else {
            Integer minutos = time / 60;
            Integer segundos = time % 60;
            return minutos.toString() + " min. y " + segundos.toString() + " seg.";
        }
    }
}

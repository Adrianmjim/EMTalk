package pad.ucm.fdi.emtalk.vista.adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import pad.ucm.fdi.emtalk.R;
import pad.ucm.fdi.emtalk.modelo.tiposApi.Arrive;
import pad.ucm.fdi.emtalk.modelo.tiposApi.ResultValue;

/**
 * Created by adrian on 27/06/16.
 */
public class AdaptadorParadas extends ArrayAdapter<Integer> {
    public AdaptadorParadas(Context context, List<Integer> a) {
        super(context, R.layout.view_parada, a);
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        Integer i = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.view_parada, parent, false);
        }
        // Lookup view for data population
        TextView parada = (TextView) convertView.findViewById(R.id.ParadaFavorita);

        // Populate the data into the template view using the data object
        parada.setText(i);
        // Return the completed view to render on screen
        return convertView;
    }
}

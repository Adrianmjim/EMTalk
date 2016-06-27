package pad.ucm.fdi.emtalk.vista.adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import pad.ucm.fdi.emtalk.R;
import pad.ucm.fdi.emtalk.modelo.tiposApi.ResultValue;

/**
 * Created by adrian on 27/06/16.
 */
public class AdaptadorLinea extends ArrayAdapter<ResultValue>{

    public AdaptadorLinea(Context context, List<ResultValue> a) {
        super(context, R.layout.view_linea, a);
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        ResultValue a = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.view_linea, parent, false);
        }
        // Lookup view for data population
        TextView numero = (TextView) convertView.findViewById(R.id.numeroLinea);
        TextView direccion = (TextView) convertView.findViewById(R.id.direccion);
        // Populate the data into the template view using the data object
        if (a != null) {
            numero.setText(a.getLabel());
            direccion.setText(a.getNameA()+ "-"+a.getNameB());
        }

        // Return the completed view to render on screen
        return convertView;
    }
}

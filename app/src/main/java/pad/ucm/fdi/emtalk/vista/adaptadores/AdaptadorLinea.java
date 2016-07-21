package pad.ucm.fdi.emtalk.vista.adaptadores;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
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
public class AdaptadorLinea extends RecyclerView.Adapter<AdaptadorLinea.ViewHolder> {
    private List<ResultValue> lineas;

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.view_linea, parent, false);
        // set the view's size, margins, paddings and layout parameters

        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.mTextView.setText(lineas.get(position).getLine());
        holder.mTextView2.setText(lineas.get(position).getNameA() + lineas.get(position).getNameB());
    }

    @Override
    public int getItemCount() {
        return lineas.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView mTextView;
        public TextView mTextView2;

        public ViewHolder(TextView v, TextView v2) {
            super(v);
            mTextView = v;
            mTextView2 = v2;
        }

        public ViewHolder(View v) {
            super(v);
            mTextView = (TextView) itemView.findViewById(R.id.numeroLinea);
            mTextView2 = (TextView) itemView.findViewById(R.id.direccion);
        }
    }
}
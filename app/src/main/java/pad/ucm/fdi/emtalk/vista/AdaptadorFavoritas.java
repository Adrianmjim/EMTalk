package pad.ucm.fdi.emtalk.vista;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import pad.ucm.fdi.emtalk.R;
import pad.ucm.fdi.emtalk.vista.AdaptadorLlegada;

public class AdaptadorFavoritas extends RecyclerView.Adapter<AdaptadorFavoritas.ViewHolder> {
    private List<Integer> list;
    public AdaptadorFavoritas(List<Integer> list) {
        this.list = list;
    }
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.view_parada, parent, false);
        // set the view's size, margins, paddings and layout parameters

        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.mTextView.setText(String.valueOf(list.get(position)));
    }



    @Override
    public int getItemCount() {
        return list.size();
    }
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView mTextView;
        public ViewHolder(TextView v, TextView v2) {
            super(v);
            mTextView = v;
        }

        public ViewHolder(View v) {
            super(v);
            mTextView = (TextView) itemView.findViewById(R.id.info_text);

        }
    }
}

package pad.ucm.fdi.emtalk.vista.main;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import pad.ucm.fdi.emtalk.R;

public class AdaptadorFavoritas extends RecyclerView.Adapter<AdaptadorFavoritas.ViewHolder> {
    private List<ParadaFavorita> list;
    private View.OnClickListener listener;
    public AdaptadorFavoritas(View.OnClickListener listener, List<ParadaFavorita> list) {
        this.list = list;
        this.listener = listener;
    }
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.view_parada, parent, false);
        // set the view's size, margins, paddings and layout parameters
        v.setOnClickListener(listener);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.mTextView.setText("Parada "+String.valueOf(list.get(position).getParada()));
        holder.mTextView2.setText("Lineas: "+list.get(position).getLineas());
    }



    @Override
    public int getItemCount() {
        return list.size();
    }
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView mTextView;
        public TextView mTextView2;
        public ViewHolder(TextView v, TextView v2) {
            super(v);
            mTextView = v;
        }

        public ViewHolder(View v) {
            super(v);
            mTextView = (TextView) itemView.findViewById(R.id.info_text);
            mTextView2 = (TextView) itemView.findViewById(R.id.info_text2);

        }
    }
}

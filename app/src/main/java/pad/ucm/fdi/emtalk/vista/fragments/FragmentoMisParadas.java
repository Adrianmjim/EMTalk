package pad.ucm.fdi.emtalk.vista.fragments;

import android.app.Fragment;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.List;

import pad.ucm.fdi.emtalk.R;
import pad.ucm.fdi.emtalk.modelo.tiposApi.ResultValue;
import pad.ucm.fdi.emtalk.vista.adaptadores.AdaptadorLinea;
import pad.ucm.fdi.emtalk.vista.adaptadores.AdaptadorParadas;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link FragmentoMisParadas.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link FragmentoMisParadas#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentoMisParadas extends Fragment {
    private ListView vista;
    private static List<Integer> paradas;
    private OnFragmentInteractionListener mListener;
    private AdaptadorParadas adaptador;
    public FragmentoMisParadas() {
        // Required empty public constructor

    }


    public static FragmentoMisParadas newInstance(List<Integer> favoritas) {
        paradas = favoritas;
        FragmentoMisParadas fragment = new FragmentoMisParadas();
        Bundle args = new Bundle();


        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_fragmento_mis_paradas, container, false);
        vista = (ListView) v.findViewById(R.id.misParadas);
        adaptador = new AdaptadorParadas(getActivity(),paradas);
        vista.setAdapter(adaptador);
        // Inflate the layout for this fragment
        return v;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}

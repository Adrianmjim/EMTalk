package pad.ucm.fdi.emtalk.vista.fragments;

import android.app.Fragment;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import pad.ucm.fdi.emtalk.R;
import pad.ucm.fdi.emtalk.modelo.GestorConexion;
import pad.ucm.fdi.emtalk.modelo.tiposApi.ListaLineas;
import pad.ucm.fdi.emtalk.modelo.tiposApi.ResultValue;
import pad.ucm.fdi.emtalk.vista.adaptadores.AdaptadorLinea;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link FragmentoLineas.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link FragmentoLineas#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentoLineas extends Fragment {
    private RecyclerView vistaPrueba;

    private ListView vista;
    private List<ResultValue> lineas;
    private OnFragmentInteractionListener mListener;
    private AdaptadorLinea adaptador;
    public FragmentoLineas() {
        // Required empty public constructor
    }
    public void setLineas(ListaLineas l) {
        lineas = l.getResultValues();
        adaptador = new AdaptadorLinea(getActivity(),lineas);
        vista.setAdapter(adaptador);
    }
    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentoLineas.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentoLineas newInstance(String param1, String param2) {
        FragmentoLineas fragment = new FragmentoLineas();
        Bundle args = new Bundle();

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_fragmento_lineas, container, false);
        vista = (ListView) v.findViewById(R.id.listaLineas);
        GestorConexion g = new GestorConexion(this);
        g.getLineas();
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

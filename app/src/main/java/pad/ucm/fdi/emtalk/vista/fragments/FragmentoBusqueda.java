package pad.ucm.fdi.emtalk.vista.fragments;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import pad.ucm.fdi.emtalk.R;
import pad.ucm.fdi.emtalk.vista.ActividadParada;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link FragmentoBusqueda.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link FragmentoBusqueda#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentoBusqueda extends Fragment {
    private EditText parada;
    private Button buscar;
    private OnFragmentInteractionListener mListener;

    public FragmentoBusqueda() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentoBusqueda.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentoBusqueda newInstance(String param1, String param2) {
        FragmentoBusqueda fragment = new FragmentoBusqueda();
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
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_fragmento_busqueda, container, false);
        parada =(EditText) v.findViewById(R.id.parada);
        buscar =(Button) v.findViewById(R.id.buscar);
        parada.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int in, KeyEvent event) {
                if ((event.getAction() == KeyEvent.ACTION_DOWN) &&
                        (in == KeyEvent.KEYCODE_ENTER)) {
                    // Perform action on key press
                    Intent i = new Intent(getActivity(), ActividadParada.class);
                    i.putExtra("parada", parada.getText().toString());
                    startActivity(i);
                    return true;
                }
                return false;
            }
        });


        buscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(), ActividadParada.class);
                i.putExtra("parada", parada.getText().toString());
                startActivity(i);

            }
        });
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

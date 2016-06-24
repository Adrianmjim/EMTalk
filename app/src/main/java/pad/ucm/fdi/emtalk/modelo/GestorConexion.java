package fdi.ucm.pad.emtalk.modelo;

import java.util.ArrayList;
import java.util.List;

import fdi.ucm.pad.emtalk.ActividadPrincipal;
import fdi.ucm.pad.emtalk.modelo.tiposApi.Arrive;

import fdi.ucm.pad.emtalk.modelo.tiposApi.ListaParadas;

import fdi.ucm.pad.emtalk.modelo.tiposApi.Parada;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by adrian on 28/04/16.
 */
public class GestorConexion {
    private Retrofit retrofit;
    private final String BASE_URL = "https://openbus.emtmadrid.es/emt-proxy-server/last/";
    private final String TIMES_FROM_STOP_URL = "GetArriveStop.php";
    private final String API_CLIENT_ID = "WEB.SERV.adrima05@ucm.es";
    private final String API_PASSKEY = "56B93B0E-5E42-4E64-BEE1-44977F5379CA";
    private List<Arrive> aux = new ArrayList<Arrive>();
    public GestorConexion() {


        retrofit = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        Conexion con = retrofit.create(Conexion.class);

        Parada paradas = new Parada(API_CLIENT_ID, API_PASSKEY, 1513, "ES");
        Call<ListaParadas> llamada = con.getArriveStop(paradas);


        llamada.enqueue(new Callback<ListaParadas>() {
            @Override
            public void onResponse(Call<ListaParadas> call, Response<ListaParadas> response) {
                if (response.isSuccessful()) {
                    aux = response.body().getArrives();

                    if (aux.size() > 0) {
                        ActividadPrincipal.respuesta(aux.get(0).toString());
                    }






                } else {
                    ActividadPrincipal.respuesta("no hay respuesta");
                }
            }

            @Override
            public void onFailure(Call<ListaParadas> call, Throwable t) {
                ActividadPrincipal.respuesta(t.toString());
            }
        });
    }

    public String tiempoParada(int parada) {



        if (aux.size() == 0) return new String("ERROR");
        return aux.get(0).toString();
    }


}

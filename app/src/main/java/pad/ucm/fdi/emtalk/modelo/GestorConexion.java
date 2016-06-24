package pad.ucm.fdi.emtalk.modelo;


import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import pad.ucm.fdi.emtalk.ActividadPrincipal;
import pad.ucm.fdi.emtalk.modelo.tiposApi.ListaLineas;
import pad.ucm.fdi.emtalk.modelo.tiposApi.ListaLlegadas;

import pad.ucm.fdi.emtalk.modelo.tiposApi.Arrive;
import pad.ucm.fdi.emtalk.modelo.tiposApi.ListaParadas;
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
    private final String BASE_URL = "https://openbus.emtmadrid.es:9443/emt-proxy-server/last/";
    private final String API_CLIENT_ID = "WEB.SERV.adrima05@ucm.es";
    private final String API_PASSKEY = "56B93B0E-5E42-4E64-BEE1-44977F5379CA";
    private Conexion con;
    public GestorConexion() {


        retrofit = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        con = retrofit.create(Conexion.class);

    }
    public void  getLlegadas(String parada) {
        RequestBody id = RequestBody.create(MediaType.parse("text/plain"), API_CLIENT_ID);
        RequestBody pass = RequestBody.create(MediaType.parse("text/plain"), API_PASSKEY);
        RequestBody num = RequestBody.create(MediaType.parse("text/plain"), parada);
        Call<ListaLlegadas> llamada = con.getArriveStop(id,pass,num);

        llamada.enqueue(new Callback<ListaLlegadas>() {
            @Override
            public void onResponse(Call<ListaLlegadas> call, Response<ListaLlegadas> response) {
                ActividadPrincipal.setLlegadas(response.body());
            }

            @Override
            public void onFailure(Call<ListaLlegadas> call, Throwable t) {

            }
        });


    }
    public void getParadasLinea(String linea) {
        RequestBody id = RequestBody.create(MediaType.parse("text/plain"), API_CLIENT_ID);
        RequestBody pass = RequestBody.create(MediaType.parse("text/plain"), API_PASSKEY);
        RequestBody num = RequestBody.create(MediaType.parse("text/plain"), linea);
        Call<ListaParadas> llamada = con.getStopLine(id,pass,num);

        llamada.enqueue(new Callback<ListaParadas>() {
            @Override
            public void onResponse(Call<ListaParadas> call, Response<ListaParadas> response) {
                ActividadPrincipal.setParadas(response.body());
            }

            @Override
            public void onFailure(Call<ListaParadas> call, Throwable t) {
                ActividadPrincipal.respuesta(t.getMessage());
            }
        });

    }
    public void getLineas() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yy");
        String currentTimeStamp = dateFormat.format(new Date()); // Find todays date
        RequestBody id = RequestBody.create(MediaType.parse("text/plain"), API_CLIENT_ID);
        RequestBody pass = RequestBody.create(MediaType.parse("text/plain"), API_PASSKEY);
        RequestBody date = RequestBody.create(MediaType.parse("text/plain"), currentTimeStamp);
        Call<ListaLineas> llamada = con.getListLines(id,pass,date);

        llamada.enqueue(new Callback<ListaLineas>() {
            @Override
            public void onResponse(Call<ListaLineas> call, Response<ListaLineas> response) {
                ActividadPrincipal.setLineas(response.body());
            }

            @Override
            public void onFailure(Call<ListaLineas> call, Throwable t) {

            }
        });
    }


}

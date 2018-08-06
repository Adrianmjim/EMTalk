package pad.ucm.fdi.emtalk.modelo;


import android.app.Application;
import android.util.Log;

import com.google.android.gms.maps.model.LatLng;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import okhttp3.MediaType;
import okhttp3.RequestBody;

import pad.ucm.fdi.emtalk.R;
import pad.ucm.fdi.emtalk.modelo.tiposApi.ListaLinea;
import pad.ucm.fdi.emtalk.modelo.tiposApi.ListaLineas;
import pad.ucm.fdi.emtalk.modelo.tiposApi.ListaLlegadas;
import pad.ucm.fdi.emtalk.modelo.tiposApi.ListaParadas;

import pad.ucm.fdi.emtalk.modelo.tiposApi.RouteLineItem;
import pad.ucm.fdi.emtalk.modelo.tiposApi.SnappedPoints;
import pad.ucm.fdi.emtalk.vista.Observable;
import pad.ucm.fdi.emtalk.vista.Observer;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by adrian on 28/04/16.
 */
public class GestorConexion extends Application implements Observable<Observer> {
    private Retrofit retrofit, retrofit2;
    private final String BASE_URL = "https://openbus.emtmadrid.es:9443/emt-proxy-server/last/";
    private final String API_CLIENT_ID = "WEB.SERV.adrima05@ucm.es";
    private final String API_PASSKEY = "56B93B0E-5E42-4E64-BEE1-44977F5379CA";
    private ConexionEMT con;

    private List<Observer> observers;
    public GestorConexion() {


        retrofit = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        con = retrofit.create(ConexionEMT.class);
        observers = new ArrayList<>();

    }

    public void  getLlegadas(String parada) {
        RequestBody id = RequestBody.create(MediaType.parse("text/plain"), API_CLIENT_ID);
        RequestBody pass = RequestBody.create(MediaType.parse("text/plain"), API_PASSKEY);
        RequestBody num = RequestBody.create(MediaType.parse("text/plain"), parada);
        Call<ListaLlegadas> llamada = con.getArriveStop(id,pass,num);

        llamada.enqueue(new Callback<ListaLlegadas>() {
            @Override
            public void onResponse(Call<ListaLlegadas> call, Response<ListaLlegadas> response) {
                for (Observer i: observers) i.updateStop(response.body());
            }

            @Override
            public void onFailure(Call<ListaLlegadas> call, Throwable t) {
                Log.d("PRUEBA", t.getLocalizedMessage());
            }
        });


    }
    public void getRouteLine(String line) {
        RequestBody id = RequestBody.create(MediaType.parse("text/plain"), API_CLIENT_ID);
        RequestBody pass = RequestBody.create(MediaType.parse("text/plain"), API_PASSKEY);
        RequestBody linea = RequestBody.create(MediaType.parse("text/plain"), line);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
        Date dateAux = new Date();

        String fecha = dateFormat.format(dateAux);
        RequestBody date = RequestBody.create(MediaType.parse("text/plain"), fecha);
        Call<ListaLinea> i = con.getRouteLines(id, pass, linea, date);
        i.enqueue(new Callback<ListaLinea>() {
            @Override
            public void onResponse(Call<ListaLinea> call, Response<ListaLinea> response) {
                for (Observer o: observers) o.updateRoute(response.body());

            }

            @Override
            public void onFailure(Call<ListaLinea> call, Throwable t) {

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

            }

            @Override
            public void onFailure(Call<ListaParadas> call, Throwable t) {

            }
        });

    }
    public void getLineas() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yy");
        String currentTimeStamp = dateFormat.format(new Date());
        RequestBody id = RequestBody.create(MediaType.parse("text/plain"), API_CLIENT_ID);
        RequestBody pass = RequestBody.create(MediaType.parse("text/plain"), API_PASSKEY);
        RequestBody date = RequestBody.create(MediaType.parse("text/plain"), currentTimeStamp);
        Call<ListaLineas> llamada = con.getListLines(id,pass,date);

        llamada.enqueue(new Callback<ListaLineas>() {
            @Override
            public void onResponse(Call<ListaLineas> call, Response<ListaLineas> response) {

            }

            @Override
            public void onFailure(Call<ListaLineas> call, Throwable t) {

            }
        });
    }


    @Override
    public void addObserver(Observer obv) {
        observers.add(obv);
    }

    @Override
    public void delObserver(Observer obv) {
        observers.remove(obv);
    }
}

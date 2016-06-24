package pad.ucm.fdi.emtalk.modelo;





import okhttp3.RequestBody;

import pad.ucm.fdi.emtalk.modelo.tiposApi.ListaLineas;

import pad.ucm.fdi.emtalk.modelo.tiposApi.ListaLlegadas;

import pad.ucm.fdi.emtalk.modelo.tiposApi.ListaParadas;
import retrofit2.Call;

import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

/**
 * Created by adrian on 28/04/16.
 */
public interface Conexion {
    @Multipart
    @POST("geo/GetArriveStop.php")
    Call<ListaLlegadas> getArriveStop(@Part("idClient") RequestBody id, @Part("passKey") RequestBody pass, @Part("idStop") RequestBody num);

    @Multipart
    @POST("bus/GetListLines.php")
    Call<ListaLineas> getListLines(@Part("idClient") RequestBody id, @Part("passKey") RequestBody pass, @Part("SelectDate") RequestBody date);

    @Multipart
    @POST("geo/getStopsLine.php")
    Call<ListaParadas> getStopLine(@Part("idClient") RequestBody id, @Part("passKey") RequestBody pass, @Part("line") RequestBody linea);



}

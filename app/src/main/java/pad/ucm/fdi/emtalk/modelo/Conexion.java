package fdi.ucm.pad.emtalk.modelo;


import java.util.List;

import fdi.ucm.pad.emtalk.modelo.tiposApi.ListaParadas;
import fdi.ucm.pad.emtalk.modelo.tiposApi.Parada;
import fdi.ucm.pad.emtalk.modelo.tiposApi.Arrive;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by adrian on 28/04/16.
 */
public interface Conexion {
    @POST("geo/GetArriveStop.php")
    Call<ListaParadas> getArriveStop(@Body Parada parada);

}

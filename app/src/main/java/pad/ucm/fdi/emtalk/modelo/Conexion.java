package pad.ucm.fdi.emtalk.modelo;


import java.util.List;


import pad.ucm.fdi.emtalk.modelo.tiposApi.ListaParadas;
import pad.ucm.fdi.emtalk.modelo.tiposApi.Parada;
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

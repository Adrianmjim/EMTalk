package pad.ucm.fdi.emtalk.modelo;


import pad.ucm.fdi.emtalk.modelo.tiposApi.SnappedPoints;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ConexionRoad {
    @GET("snapToRoads")
    Call<SnappedPoints> snapToRoads(@Query("path") String path, @Query("key") String key, @Query("interpolate") boolean interpolate);
}

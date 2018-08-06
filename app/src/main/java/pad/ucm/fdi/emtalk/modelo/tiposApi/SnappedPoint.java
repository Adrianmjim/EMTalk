package pad.ucm.fdi.emtalk.modelo.tiposApi;

import com.google.android.gms.maps.model.LatLng;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SnappedPoint {
    @SerializedName("location")
    @Expose
    private LatLng location;
    @SerializedName("originalIndex")
    @Expose
    private Integer originalIndex;
    @SerializedName("placeId")
    @Expose
    private String placeId;

    public LatLng getLocation() {
        return location;
    }

    public void setLocation(LatLng location) {
        this.location = location;
    }

    public Integer getOriginalIndex() {
        return originalIndex;
    }

    public void setOriginalIndex(Integer originalIndex) {
        this.originalIndex = originalIndex;
    }

    public String getPlaceId() {
        return placeId;
    }

    public void setPlaceId(String placeId) {
        this.placeId = placeId;
    }

}


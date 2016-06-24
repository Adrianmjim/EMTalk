package pad.ucm.fdi.emtalk.modelo.tiposApi;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by adrian on 24/06/16.
 */
public class Stop {
    @SerializedName("stopId")
    @Expose
    private String stopId;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("postalAddress")
    @Expose
    private String postalAddress;
    @SerializedName("longitude")
    @Expose
    private Double longitude;
    @SerializedName("latitude")
    @Expose
    private Double latitude;
    @SerializedName("lineId")
    @Expose
    private String lineId;
    @SerializedName("pmv")
    @Expose
    private Integer pmv;

    /**
     *
     * @return
     * The stopId
     */
    public String getStopId() {
        return stopId;
    }

    /**
     *
     * @param stopId
     * The stopId
     */
    public void setStopId(String stopId) {
        this.stopId = stopId;
    }

    /**
     *
     * @return
     * The name
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name
     * The name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return
     * The postalAddress
     */
    public String getPostalAddress() {
        return postalAddress;
    }

    /**
     *
     * @param postalAddress
     * The postalAddress
     */
    public void setPostalAddress(String postalAddress) {
        this.postalAddress = postalAddress;
    }

    /**
     *
     * @return
     * The longitude
     */
    public Double getLongitude() {
        return longitude;
    }

    /**
     *
     * @param longitude
     * The longitude
     */
    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    /**
     *
     * @return
     * The latitude
     */
    public Double getLatitude() {
        return latitude;
    }

    /**
     *
     * @param latitude
     * The latitude
     */
    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    /**
     *
     * @return
     * The lineId
     */
    public String getLineId() {
        return lineId;
    }

    /**
     *
     * @param lineId
     * The lineId
     */
    public void setLineId(String lineId) {
        this.lineId = lineId;
    }

    /**
     *
     * @return
     * The pmv
     */
    public Integer getPmv() {
        return pmv;
    }

    /**
     *
     * @param pmv
     * The pmv
     */
    public void setPmv(Integer pmv) {
        this.pmv = pmv;
    }

}

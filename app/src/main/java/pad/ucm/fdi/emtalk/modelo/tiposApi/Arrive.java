package pad.ucm.fdi.emtalk.modelo.tiposApi;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by adrian on 28/04/16.
 */
public class Arrive {
    @SerializedName("stopId")
    @Expose
    private Integer stopId;
    @SerializedName("lineId")
    @Expose
    private String lineId;
    @SerializedName("isHead")
    @Expose
    private String isHead;
    @SerializedName("destination")
    @Expose
    private String destination;
    @SerializedName("busId")
    @Expose
    private String busId;
    @SerializedName("busTimeLeft")
    @Expose
    private Integer busTimeLeft;
    @SerializedName("busDistance")
    @Expose
    private Integer busDistance;
    @SerializedName("longitude")
    @Expose
    private Double longitude;
    @SerializedName("latitude")
    @Expose
    private Double latitude;
    @SerializedName("busPositionType")
    @Expose
    private Integer busPositionType;

    /**
     * No args constructor for use in serialization
     *
     */
    public Arrive() {
    }

    /**
     *
     * @param busPositionType
     * @param busDistance
     * @param busId
     * @param isHead
     * @param stopId
     * @param longitude
     * @param latitude
     * @param busTimeLeft
     * @param lineId
     * @param destination
     */
    public Arrive(Integer stopId, String lineId, String isHead, String destination, String busId, Integer busTimeLeft, Integer busDistance, Double longitude, Double latitude, Integer busPositionType) {
        this.stopId = stopId;
        this.lineId = lineId;
        this.isHead = isHead;
        this.destination = destination;
        this.busId = busId;
        this.busTimeLeft = busTimeLeft;
        this.busDistance = busDistance;
        this.longitude = longitude;
        this.latitude = latitude;
        this.busPositionType = busPositionType;
    }

    /**
     *
     * @return
     * The stopId
     */
    public Integer getStopId() {
        return stopId;
    }

    /**
     *
     * @param stopId
     * The stopId
     */
    public void setStopId(Integer stopId) {
        this.stopId = stopId;
    }

    public Arrive withStopId(Integer stopId) {
        this.stopId = stopId;
        return this;
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

    public Arrive withLineId(String lineId) {
        this.lineId = lineId;
        return this;
    }

    /**
     *
     * @return
     * The isHead
     */
    public String getIsHead() {
        return isHead;
    }

    /**
     *
     * @param isHead
     * The isHead
     */
    public void setIsHead(String isHead) {
        this.isHead = isHead;
    }

    public Arrive withIsHead(String isHead) {
        this.isHead = isHead;
        return this;
    }

    /**
     *
     * @return
     * The destination
     */
    public String getDestination() {
        return destination;
    }

    /**
     *
     * @param destination
     * The destination
     */
    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Arrive withDestination(String destination) {
        this.destination = destination;
        return this;
    }

    /**
     *
     * @return
     * The busId
     */
    public String getBusId() {
        return busId;
    }

    /**
     *
     * @param busId
     * The busId
     */
    public void setBusId(String busId) {
        this.busId = busId;
    }

    public Arrive withBusId(String busId) {
        this.busId = busId;
        return this;
    }

    /**
     *
     * @return
     * The busTimeLeft
     */
    public Integer getBusTimeLeft() {
        return busTimeLeft;
    }

    /**
     *
     * @param busTimeLeft
     * The busTimeLeft
     */
    public void setBusTimeLeft(Integer busTimeLeft) {
        this.busTimeLeft = busTimeLeft;
    }

    public Arrive withBusTimeLeft(Integer busTimeLeft) {
        this.busTimeLeft = busTimeLeft;
        return this;
    }

    /**
     *
     * @return
     * The busDistance
     */
    public Integer getBusDistance() {
        return busDistance;
    }

    /**
     *
     * @param busDistance
     * The busDistance
     */
    public void setBusDistance(Integer busDistance) {
        this.busDistance = busDistance;
    }

    public Arrive withBusDistance(Integer busDistance) {
        this.busDistance = busDistance;
        return this;
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

    public Arrive withLongitude(Double longitude) {
        this.longitude = longitude;
        return this;
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

    public Arrive withLatitude(Double latitude) {
        this.latitude = latitude;
        return this;
    }

    /**
     *
     * @return
     * The busPositionType
     */
    public Integer getBusPositionType() {
        return busPositionType;
    }

    /**
     *
     * @param busPositionType
     * The busPositionType
     */
    public void setBusPositionType(Integer busPositionType) {
        this.busPositionType = busPositionType;
    }

    public Arrive withBusPositionType(Integer busPositionType) {
        this.busPositionType = busPositionType;
        return this;
    }

    @Override
    public String toString() {
        return busId + busTimeLeft;
    }

}


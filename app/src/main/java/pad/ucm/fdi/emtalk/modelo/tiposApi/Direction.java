package pad.ucm.fdi.emtalk.modelo.tiposApi;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by adrian on 24/06/16.
 */
public class Direction {
    @SerializedName("startTime")
    @Expose
    private String startTime;
    @SerializedName("stopTime")
    @Expose
    private String stopTime;
    @SerializedName("minimumFrequency")
    @Expose
    private String minimumFrequency;
    @SerializedName("maximumFrequency")
    @Expose
    private String maximumFrequency;

    /**
     *
     * @return
     * The startTime
     */
    public String getStartTime() {
        return startTime;
    }

    /**
     *
     * @param startTime
     * The startTime
     */
    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    /**
     *
     * @return
     * The stopTime
     */
    public String getStopTime() {
        return stopTime;
    }

    /**
     *
     * @param stopTime
     * The stopTime
     */
    public void setStopTime(String stopTime) {
        this.stopTime = stopTime;
    }

    /**
     *
     * @return
     * The minimumFrequency
     */
    public String getMinimumFrequency() {
        return minimumFrequency;
    }

    /**
     *
     * @param minimumFrequency
     * The minimumFrequency
     */
    public void setMinimumFrequency(String minimumFrequency) {
        this.minimumFrequency = minimumFrequency;
    }

    /**
     *
     * @return
     * The maximumFrequency
     */
    public String getMaximumFrequency() {
        return maximumFrequency;
    }

    /**
     *
     * @param maximumFrequency
     * The maximumFrequency
     */
    public void setMaximumFrequency(String maximumFrequency) {
        this.maximumFrequency = maximumFrequency;
    }
}

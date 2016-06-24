package pad.ucm.fdi.emtalk.modelo.tiposApi;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by adrian on 24/06/16.
 */
public class ListaParadas {
    @SerializedName("Line")
    @Expose
    private List<Line> line = new ArrayList<Line>();
    @SerializedName("lineId")
    @Expose
    private String lineId;
    @SerializedName("label")
    @Expose
    private String label;
    @SerializedName("destination")
    @Expose
    private String destination;
    @SerializedName("incidents")
    @Expose
    private Integer incidents;
    @SerializedName("stop")
    @Expose
    private List<Stop> stop = new ArrayList<Stop>();

    /**
     *
     * @return
     * The line
     */
    public List<Line> getLine() {
        return line;
    }

    /**
     *
     * @param line
     * The Line
     */
    public void setLine(List<Line> line) {
        this.line = line;
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
     * The label
     */
    public String getLabel() {
        return label;
    }

    /**
     *
     * @param label
     * The label
     */
    public void setLabel(String label) {
        this.label = label;
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

    /**
     *
     * @return
     * The incidents
     */
    public Integer getIncidents() {
        return incidents;
    }

    /**
     *
     * @param incidents
     * The incidents
     */
    public void setIncidents(Integer incidents) {
        this.incidents = incidents;
    }

    /**
     *
     * @return
     * The stop
     */
    public List<Stop> getStop() {
        return stop;
    }

    /**
     *
     * @param stop
     * The stop
     */
    public void setStop(List<Stop> stop) {
        this.stop = stop;
    }

}


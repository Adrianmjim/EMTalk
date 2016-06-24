package pad.ucm.fdi.emtalk.modelo.tiposApi;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by adrian on 24/06/16.
 */
public class Line {
    @SerializedName("lineId")
    @Expose
    private String lineId;
    @SerializedName("label")
    @Expose
    private String label;
    @SerializedName("headerA")
    @Expose
    private String headerA;
    @SerializedName("headerB")
    @Expose
    private String headerB;
    @SerializedName("dayType")
    @Expose
    private List<DayType> dayType = new ArrayList<DayType>();

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
     * The headerA
     */
    public String getHeaderA() {
        return headerA;
    }

    /**
     *
     * @param headerA
     * The headerA
     */
    public void setHeaderA(String headerA) {
        this.headerA = headerA;
    }

    /**
     *
     * @return
     * The headerB
     */
    public String getHeaderB() {
        return headerB;
    }

    /**
     *
     * @param headerB
     * The headerB
     */
    public void setHeaderB(String headerB) {
        this.headerB = headerB;
    }

    /**
     *
     * @return
     * The dayType
     */
    public List<DayType> getDayType() {
        return dayType;
    }

    /**
     *
     * @param dayType
     * The dayType
     */
    public void setDayType(List<DayType> dayType) {
        this.dayType = dayType;
    }
}

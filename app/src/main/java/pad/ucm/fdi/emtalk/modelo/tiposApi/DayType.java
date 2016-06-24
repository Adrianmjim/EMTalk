package pad.ucm.fdi.emtalk.modelo.tiposApi;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by adrian on 24/06/16.
 */
public class DayType {
    @SerializedName("dayTypeId")
    @Expose
    private String dayTypeId;
    @SerializedName("direction1")
    @Expose
    private Direction direction1;
    @SerializedName("direction2")
    @Expose
    private Direction direction2;

    /**
     *
     * @return
     * The dayTypeId
     */
    public String getDayTypeId() {
        return dayTypeId;
    }

    /**
     *
     * @param dayTypeId
     * The dayTypeId
     */
    public void setDayTypeId(String dayTypeId) {
        this.dayTypeId = dayTypeId;
    }

    /**
     *
     * @return
     * The direction1
     */
    public Direction getDirection1() {
        return direction1;
    }

    /**
     *
     * @param direction1
     * The direction1
     */
    public void setDirection1(Direction direction1) {
        this.direction1 = direction1;
    }

    /**
     *
     * @return
     * The direction2
     */
    public Direction getDirection2() {
        return direction2;
    }

    /**
     *
     * @param direction2
     * The direction2
     */
    public void setDirection2(Direction direction2) {
        this.direction2 = direction2;
    }
}

package pad.ucm.fdi.emtalk.modelo.tiposApi;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by adrian on 24/06/16.
 */
public class ResultValue {
    @SerializedName("groupNumber")
    @Expose
    private String groupNumber;
    @SerializedName("dateFirst")
    @Expose
    private String dateFirst;
    @SerializedName("dateEnd")
    @Expose
    private String dateEnd;
    @SerializedName("line")
    @Expose
    private String line;
    @SerializedName("label")
    @Expose
    private String label;
    @SerializedName("nameA")
    @Expose
    private String nameA;
    @SerializedName("nameB")
    @Expose
    private String nameB;

    /**
     *
     * @return
     * The groupNumber
     */
    public String getGroupNumber() {
        return groupNumber;
    }

    /**
     *
     * @param groupNumber
     * The groupNumber
     */
    public void setGroupNumber(String groupNumber) {
        this.groupNumber = groupNumber;
    }

    public ResultValue withGroupNumber(String groupNumber) {
        this.groupNumber = groupNumber;
        return this;
    }

    /**
     *
     * @return
     * The dateFirst
     */
    public String getDateFirst() {
        return dateFirst;
    }

    /**
     *
     * @param dateFirst
     * The dateFirst
     */
    public void setDateFirst(String dateFirst) {
        this.dateFirst = dateFirst;
    }

    public ResultValue withDateFirst(String dateFirst) {
        this.dateFirst = dateFirst;
        return this;
    }

    /**
     *
     * @return
     * The dateEnd
     */
    public String getDateEnd() {
        return dateEnd;
    }

    /**
     *
     * @param dateEnd
     * The dateEnd
     */
    public void setDateEnd(String dateEnd) {
        this.dateEnd = dateEnd;
    }

    public ResultValue withDateEnd(String dateEnd) {
        this.dateEnd = dateEnd;
        return this;
    }

    /**
     *
     * @return
     * The line
     */
    public String getLine() {
        return line;
    }

    /**
     *
     * @param line
     * The line
     */
    public void setLine(String line) {
        this.line = line;
    }

    public ResultValue withLine(String line) {
        this.line = line;
        return this;
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

    public ResultValue withLabel(String label) {
        this.label = label;
        return this;
    }

    /**
     *
     * @return
     * The nameA
     */
    public String getNameA() {
        return nameA;
    }

    /**
     *
     * @param nameA
     * The nameA
     */
    public void setNameA(String nameA) {
        this.nameA = nameA;
    }

    public ResultValue withNameA(String nameA) {
        this.nameA = nameA;
        return this;
    }

    /**
     *
     * @return
     * The nameB
     */
    public String getNameB() {
        return nameB;
    }

    /**
     *
     * @param nameB
     * The nameB
     */
    public void setNameB(String nameB) {
        this.nameB = nameB;
    }

    public ResultValue withNameB(String nameB) {
        this.nameB = nameB;
        return this;
    }
}

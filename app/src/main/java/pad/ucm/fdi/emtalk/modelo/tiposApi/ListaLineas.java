package pad.ucm.fdi.emtalk.modelo.tiposApi;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by adrian on 24/06/16.
 */
public class ListaLineas {
    @SerializedName("resultCode")
    @Expose
    private Integer resultCode;
    @SerializedName("resultDescription")
    @Expose
    private String resultDescription;
    @SerializedName("resultValues")
    @Expose
    private List<ResultValue> resultValues = new ArrayList<ResultValue>();

    /**
     *
     * @return
     * The resultCode
     */
    public Integer getResultCode() {
        return resultCode;
    }

    /**
     *
     * @param resultCode
     * The resultCode
     */
    public void setResultCode(Integer resultCode) {
        this.resultCode = resultCode;
    }

    public ListaLineas withResultCode(Integer resultCode) {
        this.resultCode = resultCode;
        return this;
    }

    /**
     *
     * @return
     * The resultDescription
     */
    public String getResultDescription() {
        return resultDescription;
    }

    /**
     *
     * @param resultDescription
     * The resultDescription
     */
    public void setResultDescription(String resultDescription) {
        this.resultDescription = resultDescription;
    }

    public ListaLineas withResultDescription(String resultDescription) {
        this.resultDescription = resultDescription;
        return this;
    }

    /**
     *
     * @return
     * The resultValues
     */
    public List<ResultValue> getResultValues() {
        return resultValues;
    }

    /**
     *
     * @param resultValues
     * The resultValues
     */
    public void setResultValues(List<ResultValue> resultValues) {
        this.resultValues = resultValues;
    }

    public ListaLineas withResultValues(List<ResultValue> resultValues) {
        this.resultValues = resultValues;
        return this;
    }
}

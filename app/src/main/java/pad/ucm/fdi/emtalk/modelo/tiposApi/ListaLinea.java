package pad.ucm.fdi.emtalk.modelo.tiposApi;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import okhttp3.Route;

public class ListaLinea {
    @SerializedName("resultCode")
    @Expose
    private Integer resultCode;
    @SerializedName("resultDescription")
    @Expose
    private String resultDescription;
    @SerializedName("resultValues")
    @Expose
    private List<RouteLineItem> resultValues = null;

    public Integer getResultCode() {
        return resultCode;
    }

    public void setResultCode(Integer resultCode) {
        this.resultCode = resultCode;
    }

    public String getResultDescription() {
        return resultDescription;
    }

    public void setResultDescription(String resultDescription) {
        this.resultDescription = resultDescription;
    }

    public List<RouteLineItem> getResultValues() {
        return resultValues;
    }

    public void setResultValues(List<RouteLineItem> resultValues) {
        this.resultValues = resultValues;
    }
}

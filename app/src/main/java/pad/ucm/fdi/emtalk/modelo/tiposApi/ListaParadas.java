package pad.ucm.fdi.emtalk.modelo.tiposApi;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by adrian on 23/05/16.
 */
public class ListaParadas {
    @SerializedName("arrives")
    private List<Arrive> arrives = new ArrayList<Arrive>();

    /**
     * No args constructor for use in serialization
     *
     */
    public ListaParadas() {
    }

    /**
     *
     * @param arrives
     */
    public ListaParadas(List<Arrive> arrives) {
        this.arrives = arrives;
    }

    /**
     *
     * @return
     * The arrives
     */
    public List<Arrive> getArrives() {
        return arrives;
    }

    /**
     *
     * @param arrives
     * The arrives
     */
    public void setArrives(List<Arrive> arrives) {
        this.arrives = arrives;
    }

    public ListaParadas withArrives(List<Arrive> arrives) {
        this.arrives = arrives;
        return this;
    }


}

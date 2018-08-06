package pad.ucm.fdi.emtalk.modelo.tiposApi;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SnappedPoints {


        @SerializedName("snappedPoints")
        @Expose
        private List<SnappedPoint> snappedPoints = null;

        public List<SnappedPoint> getSnappedPoints() {
            return snappedPoints;
        }

        public void setSnappedPoints(List<SnappedPoint> snappedPoints) {
            this.snappedPoints = snappedPoints;
        }


}

package pad.ucm.fdi.emtalk.modelo.tiposApi;

import com.google.gson.annotations.SerializedName;

/**
 * Created by adrian on 9/05/16.
 */
public class Parada {

    final String id;

    final String passkey;

    final String idstop;

    final String cultureinfo;
    public Parada(String id, String passkey, String idStop, String cultureinfo) {
        this.id = id;
        this.passkey = passkey;
        this.idstop = idStop;
        this.cultureinfo = cultureinfo;
    }
    public String getPasskey() {
        return passkey;
    }



    public String getId() {
        return id;
    }



    public String getIdstop() {
        return idstop;
    }



    public String getCultureinfo() {
        return cultureinfo;
    }


}

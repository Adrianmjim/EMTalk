package fdi.ucm.pad.emtalk.modelo.tiposApi;

import com.google.gson.annotations.SerializedName;

/**
 * Created by adrian on 9/05/16.
 */
public class Parada {
    @SerializedName("id")
    private String id;
    @SerializedName("passkey")
    private String passkey;
    @SerializedName("idstop")
    private int idstop;
    @SerializedName("cultureinfo")
    private String cultureinfo;
    public Parada(String id, String passkey, int idStop, String cultureinfo) {
        this.id = id;
        this.passkey = passkey;
        this.idstop = idStop;
        this.cultureinfo = cultureinfo;
    }
    public String getPasskey() {
        return passkey;
    }

    public void setPasskey(String passkey) {
        this.passkey = passkey;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getIdstop() {
        return idstop;
    }

    public void setIdstop(int idstop) {
        this.idstop = idstop;
    }

    public String getCultureinfo() {
        return cultureinfo;
    }

    public void setCultureinfo(String cultureinfo) {
        this.cultureinfo = cultureinfo;
    }
}

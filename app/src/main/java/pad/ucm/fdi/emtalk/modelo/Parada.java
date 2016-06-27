package pad.ucm.fdi.emtalk.modelo;

/**
 * Created by adrian on 27/06/16.
 */
public class Parada {
    private int numero;
    private String calle;
    public Parada(int numero, String calle) {
        this.numero = numero;
        this.calle = calle;
    }
    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }
}

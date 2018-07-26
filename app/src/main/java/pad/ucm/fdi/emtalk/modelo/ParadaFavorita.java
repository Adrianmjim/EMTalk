package pad.ucm.fdi.emtalk.modelo;

public class ParadaFavorita {
    private int parada;
    private String lineas;
    public ParadaFavorita(int parada, String lineas) {
        this.parada = parada;
        this.lineas = lineas;
    }

    public int getParada() {
        return parada;
    }

    public String getLineas() {
        return lineas;
    }
}

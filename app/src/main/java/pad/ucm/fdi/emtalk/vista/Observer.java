package pad.ucm.fdi.emtalk.vista;

import pad.ucm.fdi.emtalk.modelo.tiposApi.ListaLinea;
import pad.ucm.fdi.emtalk.modelo.tiposApi.ListaLlegadas;

public interface Observer {
    void updateStop(ListaLlegadas llegadas);
    void updateRoute(ListaLinea route);
}

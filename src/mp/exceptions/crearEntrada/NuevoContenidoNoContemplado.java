package mp.exceptions.crearEntrada;

import mp.exceptions.Result;

public class NuevoContenidoNoContemplado extends Result {
    public NuevoContenidoNoContemplado(String tipo) {
        super(tipo + "  no existe como tipo de contenido para agregar a Entradas, pruebe a anadir (TextoPlano/Ejercicio/Encuesta). INSERTAR CONTENIDO CANCELADO");
    }
}

package mp.exceptions.crearEntrada;

import mp.exceptions.Result;

public class CrearEntradaSinForo extends Result {
    public CrearEntradaSinForo(int foro) {
        super("El foro (en el que se quiere crear la entrada) número " + foro + "  no existe. CREACIÓN ENTRADA CANCELADA");
    }
}

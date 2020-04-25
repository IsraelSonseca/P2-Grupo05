package mp.exceptions.crearEntrada;

import mp.exceptions.Result;
import mp.subforos.Entrada;
import mp.subforos.SubForo;

public class ModificacionEntradaCorrecta extends Result {
    public ModificacionEntradaCorrecta(Entrada entrada) {
        super("Entrada con titulo " + entrada.getTitulo() + ", y con id  " + entrada.getId() + " modificada correctamente. MODIFICACIÓN ENTRADA CORRECTA");
    }
}

package mp.exceptions.crearEntrada;

import mp.exceptions.Result;
import mp.subforos.Entrada;
import mp.subforos.EntradaGenerica;
import mp.subforos.SubForo;

public class ModificacionEntradaCorrecta extends Result {
    public ModificacionEntradaCorrecta(EntradaGenerica entrada) {
        super("Entrada con titulo " + entrada.getTitulo() + ", y con id  " + entrada.getId() + " modificada correctamente. MODIFICACIÓN ENTRADA CORRECTA");
    }
}

package mp.exceptions.admin;

import mp.exceptions.Result;
import mp.subforos.Entrada;

public class EntradaValidada extends Result {
    public EntradaValidada(Entrada entrada) {
        super("Entrada con titulo " + entrada.getTitulo() + ", y con id  " + entrada.getId() + " validada correctamente. VALIDACIÓN ENTRADA CORRECTA");
    }
}

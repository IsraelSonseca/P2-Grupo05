package mp.exceptions.admin;

import mp.exceptions.Result;
import mp.subforos.Entrada;

public class EntradaRechazada extends Result {
    public EntradaRechazada(Entrada entrada) {
        super("Entrada con titulo "+entrada.getTitulo()+", y con id  "+entrada.getId()+" rechazada correctamente. ENTRADA RECHAZADA CORRECTAMENTE");
    }
}

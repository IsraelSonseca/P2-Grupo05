package mp.exceptions.crearEntrada;

import mp.exceptions.Result;
import mp.subforos.Entrada;

public class EntradaCreada extends Result {
    public EntradaCreada(Entrada entrada) {
        super("Entrada con titulo "+entrada.getTitulo()+", y con id  "+entrada.getId()+" creada correctamente. CREACIÓN ENTRADA CORRECTA");
    }
}

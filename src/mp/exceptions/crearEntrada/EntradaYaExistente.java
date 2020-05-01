package mp.exceptions.crearEntrada;

import mp.exceptions.Result;
import mp.subforos.entradas.EntradaGenerica;

public class EntradaYaExistente extends Result {
    public EntradaYaExistente(EntradaGenerica entrada) {
        super("Una entrada con id: " + entrada.getId() + ", ya está creada. CREACIÓN ENTRADA CANCELADA");
    }
}

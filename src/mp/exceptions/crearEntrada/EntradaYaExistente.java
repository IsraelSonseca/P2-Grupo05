package mp.exceptions.crearEntrada;

import mp.exceptions.Result;
import mp.subforos.Entrada;

public class EntradaYaExistente extends Result {
    public EntradaYaExistente(Entrada entrada) {
        super("Una entrada con id: "+ entrada.getId() +", ya está creada. CREACIÓN ENTRADA CANCELADA");
    }
}

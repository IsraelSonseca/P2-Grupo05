package mp.exceptions.crearEntrada;

import mp.exceptions.Result;

public class ModificarEntradaNoExistente extends Result {
    public ModificarEntradaNoExistente(int entrada) {
        super("La entrada que quieres modificar: " + entrada + "  no existe. MODIFICACIÓN ENTRADA CANCELADA");
    }
}

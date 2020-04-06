package mp.exceptions.admin;

import mp.exceptions.Result;

public class EntradasValidadas extends Result {
    public EntradasValidadas() {
        super("No hay entradas pendientes de validar. VALIDACIÓN ENTRADA CANCELADA");
    }
}

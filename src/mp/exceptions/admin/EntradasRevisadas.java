package mp.exceptions.admin;

import mp.exceptions.Result;

public class EntradasRevisadas extends Result {
    public EntradasRevisadas() {
        super("No hay entradas pendientes de REVISAR. VALIDACIÓN/RECHAZO ENTRADA CANCELADA");
    }
}

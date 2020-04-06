package mp.exceptions.admin;

import mp.exceptions.Result;

public class VerEntradasPendientes extends Result {
    public VerEntradasPendientes(String strEntradas) {
        super("El administrados tiene la sesión iniciada. Las entradas pendientes de validación son:\n"+strEntradas);
    }
}

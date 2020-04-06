package mp.exceptions.admin;

import mp.exceptions.Result;

public class VerEntradasPendientesSinPermiso extends Result {

    public VerEntradasPendientesSinPermiso() {
        super("El administrador no ha iniciado sesión, no tiene permisos para ver Entradas sin validar. VISUALIZACION ENTRADAS PENDIENTES CANCELADA");
    }
}

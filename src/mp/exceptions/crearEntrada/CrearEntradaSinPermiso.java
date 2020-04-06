package mp.exceptions.crearEntrada;

import mp.exceptions.Result;

public class CrearEntradaSinPermiso extends Result {
    public CrearEntradaSinPermiso() {
        super("Usted no es Miembro de la URJC, no tiene permisos para crear Entradas. CREACIÓN ENTRADA CANCELADA");
    }
}

package mp.exceptions.crearEntrada;

import mp.exceptions.Result;

public class ModificarEntradaSinPermiso extends Result {
    public ModificarEntradaSinPermiso() {
        super("Usted no es Miembro de la URJC, no tiene permisos para modificar entradas. MODIFICACIÓN ENTRADA CANCELADA");
    }
}

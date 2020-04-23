package mp.exceptions.sistem;

import mp.exceptions.Result;

public class VerSistemaSinPermiso extends Result {
    public VerSistemaSinPermiso() {
        super("Usted no es Miembro de la URJC, no tiene permisos para ver el sistema REDDITURJC. VISUALIZACION SISTEMA CANCELADA");
    }
}

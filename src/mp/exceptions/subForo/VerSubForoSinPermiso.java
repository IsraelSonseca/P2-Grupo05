package mp.exceptions.subForo;

import mp.exceptions.Result;

public class VerSubForoSinPermiso extends Result {
    public VerSubForoSinPermiso() {
        super("Usted no es Miembro de la URJC, no tiene permisos para ver SubForos. VISUALIZACION SUBFOROS CANCELADA");
    }
}

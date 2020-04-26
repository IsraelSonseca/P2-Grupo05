package mp.exceptions.suscripciones;

import mp.exceptions.Result;

public class DarseBajaSinPermiso extends Result {
    public DarseBajaSinPermiso() {
        super("Usted no es Miembro de la URJC, no puede darse de baja en ningún SUBFORO. OPERACION CANCELADA");
    }
}

package mp.exceptions.suscripciones;

import mp.exceptions.Result;

public class SuscribirSinPermiso extends Result {
    public SuscribirSinPermiso() {
        super("Usted no es Miembro de la URJC, no puede suscribirse a ningún SUBFORO. SUSCRIPCION CANCELADA");
    }
}

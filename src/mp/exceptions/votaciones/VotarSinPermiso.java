package mp.exceptions.votaciones;

import mp.exceptions.Result;

public class VotarSinPermiso extends Result {
    public VotarSinPermiso() {
        super("Usted no es Miembro de la URJC, no tiene permisos para crear VALORACIONES. VOTACION CANCELADA");
    }
}

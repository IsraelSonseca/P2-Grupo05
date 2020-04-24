package mp.exceptions.logIn;

import mp.exceptions.Result;
import mp.users.MiembroURJC;

public class UsuarioPenalizado extends Result {
    public UsuarioPenalizado(MiembroURJC usuario) {
        super("El usuario: " + usuario.getNick() + " está penalizado hasta la siguiente fecha: " + usuario.getPenalizacion().getFechaFin() + ". INICIO DE SESION DENEGADO");
    }
}

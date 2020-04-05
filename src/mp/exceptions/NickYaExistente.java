package mp.exceptions;

import mp.users.MiembroURJC;

public class NickYaExistente extends Result {
    public NickYaExistente(MiembroURJC nuevoUsuario) {
        super("El nick: "+ nuevoUsuario.getNick() +", ya está en uso. REGISTRO CANCELADO");
    }
}

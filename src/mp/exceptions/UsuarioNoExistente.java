package mp.exceptions;

import mp.users.MiembroURJC;

public class UsuarioNoExistente extends Result {
    public UsuarioNoExistente(String nick) {
        super("El nick: "+ nick +", no corresponde a ningún usuario registrado. INICIO DE SESION CANCELADO");
    }
}

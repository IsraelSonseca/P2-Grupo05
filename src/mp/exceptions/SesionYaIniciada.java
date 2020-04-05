package mp.exceptions;

import mp.users.MiembroURJC;

public class SesionYaIniciada extends Result {
    public SesionYaIniciada(MiembroURJC userLogued) {
        super(userLogued.getNick()+" está logueado, debe cerrar sesión previamente.INICIO DE SESION CANCELADO");
    }
}

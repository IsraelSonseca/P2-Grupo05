package mp.exceptions;

import mp.users.MiembroURJC;

public class LogedCorrect extends Result {
    public LogedCorrect(MiembroURJC user) {
        super(user.getNick()+" ha iniciado correctamente sesion. INICIO DE SESION CORRECTO");
    }
}

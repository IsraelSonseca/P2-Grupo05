package mp.exceptions.logIn;

import mp.exceptions.Result;
import mp.users.MiembroURJC;

public class LogedCorrect extends Result {
    public LogedCorrect(MiembroURJC user) {
        super(user.getClass()+" "+user.getNick()+" ha iniciado correctamente sesion. INICIO DE SESION CORRECTO");
    }
}

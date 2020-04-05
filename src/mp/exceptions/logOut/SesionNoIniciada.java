package mp.exceptions.logOut;

import mp.exceptions.Result;

public class SesionNoIniciada extends Result {
    public SesionNoIniciada(String msg) {
        super("No hay sesión iniciada en RedditURJC."+msg);
    }
}

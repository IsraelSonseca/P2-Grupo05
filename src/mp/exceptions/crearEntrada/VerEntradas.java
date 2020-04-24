package mp.exceptions.crearEntrada;

import mp.exceptions.Result;

public class VerEntradas extends Result {
    public VerEntradas(String entradasStr) {
        super("Las entrada existentes en RedditURJC son:" + entradasStr);
    }
}

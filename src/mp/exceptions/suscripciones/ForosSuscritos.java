package mp.exceptions.suscripciones;

import mp.exceptions.Result;

public class ForosSuscritos extends Result {
    public ForosSuscritos(String a) {
        super("Usted está acualmente suscrito a los siguientes subforos:\n" +a + ("\n"));
    }
}

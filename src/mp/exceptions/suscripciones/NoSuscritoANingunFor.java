package mp.exceptions.suscripciones;

import mp.exceptions.Result;

public class NoSuscritoANingunFor extends Result {
    public NoSuscritoANingunFor() {
        super("Usted actualmente no esta suscrito a ningún foro");
    }
}

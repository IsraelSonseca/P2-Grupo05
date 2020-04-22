package mp.exceptions.suscripciones;

import mp.exceptions.Result;

public class SubforosNoDisponibles extends Result {
    public SubforosNoDisponibles() {
        super("Usted no es Miembro de la URJC, por lo tanto no puede ver a que foros esta suscrito");
    }
}

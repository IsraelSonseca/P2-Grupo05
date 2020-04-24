package mp.exceptions.suscripciones;

import mp.exceptions.Result;

public class SuscribirSinForo extends Result {
    public SuscribirSinForo(int foro) {
        super("El SUBFORO (en el que se suscribirse) número " + foro + "  no existe. SUSCRIPCION NO ACTIVADA");
    }
}

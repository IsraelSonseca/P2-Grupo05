package mp.exceptions.suscripciones;

import mp.exceptions.Result;

public class DarseBajaSinForo extends Result {
    public DarseBajaSinForo(int foro) {
        super("El SUBFORO (en el que se quiere dar de baja) número " + foro + "  no existe. SUSCRIPCION NO ACTIVADA");
    }
}
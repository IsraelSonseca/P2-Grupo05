package mp.exceptions.votaciones;

import mp.exceptions.Result;

public class ValoracionNoContemplada extends Result {
    public ValoracionNoContemplada(String valoracion) {
        super(valoracion+"  no existe como estado de valoracion, pruebe a valorar con (positiva/negativa). VOTACION CANCELADA");
    }
}

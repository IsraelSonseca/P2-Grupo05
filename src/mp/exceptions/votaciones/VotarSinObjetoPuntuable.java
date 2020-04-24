package mp.exceptions.votaciones;

import mp.exceptions.Result;

public class VotarSinObjetoPuntuable extends Result {
    public VotarSinObjetoPuntuable(int objetoPuntuable) {
        super("El Objeto/Comentario/Entrada/Respuesta (en el que quiere votar) número " + objetoPuntuable + "  no existe. VOTACION CANCELADA");
    }
}

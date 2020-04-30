package mp.exceptions.votaciones;

import mp.exceptions.Result;
import mp.subforos.entradas.ObjetoPuntuable;
import mp.subforos.entradas.opiniones.Votacion;

public class VotacionCreada extends Result {
    public VotacionCreada(Votacion votacion, ObjetoPuntuable objetoPuntuable) {
        super("El objeto puntuable " + objetoPuntuable.getId() + " ha sido valorado " + votacion.getEstado() + "mente por " + votacion.getUser().getNick() + ". VOTACION PUBLICADA");
    }
}

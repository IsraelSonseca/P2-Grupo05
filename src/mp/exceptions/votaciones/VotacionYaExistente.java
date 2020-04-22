package mp.exceptions.votaciones;

import mp.exceptions.Result;
import mp.subforos.ObjetoPuntuable;
import mp.subforos.Votacion;

public class VotacionYaExistente extends Result {
    public VotacionYaExistente(Votacion votacion, ObjetoPuntuable objetoPuntuable) {
        super("El objeto puntuable "+objetoPuntuable.getId()+" ya estaba valorado  por "+votacion.getUser().getNick()+". Ahora quedará valorado "+votacion.getEstado()+"mente. VOTACION PUBLICADA");
    }
}

package mp.exceptions.votaciones;

import mp.exceptions.Result;
import mp.subforos.ObjetoPuntuable;

public class ValorarObjetoPuntuablePropio extends Result {
    public ValorarObjetoPuntuablePropio(ObjetoPuntuable objetoAValorar) {
        super("El Objeto/Comentario/Entrada/Respuesta (en el que quiere votar) "+objetoAValorar.getId()+"  fue creado por USTED "+objetoAValorar.getUser().getNick()+". VOTACION CANCELADA");
    }
}

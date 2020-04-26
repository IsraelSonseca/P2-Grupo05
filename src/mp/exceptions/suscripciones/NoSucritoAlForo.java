package mp.exceptions.suscripciones;

import mp.exceptions.Result;
import mp.subforos.SubForo;
import mp.users.MiembroURJC;

public class NoSucritoAlForo extends Result {
    public NoSucritoAlForo(MiembroURJC user, SubForo subForo) {
        super("El usuario: " + user.getNick() + ", no está suscrito actualmente en el SUBFORO " + subForo.getId() + " -> " + subForo.getNombre() + ". OPERACIÓN CANCELADA");
    }
}
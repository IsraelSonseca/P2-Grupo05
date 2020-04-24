package mp.exceptions.suscripciones;

import mp.exceptions.Result;
import mp.subforos.SubForo;
import mp.users.MiembroURJC;

public class SuscriptorYaExistente extends Result {
    public SuscriptorYaExistente(MiembroURJC user, SubForo subForo) {
        super("El usuario: " + user.getNick() + ", ya está suscrito al SUBFORO " + subForo.getId() + " -> " + subForo.getNombre() + ". SUSCRIPCION CONTINUA ACTIVA");
    }
}

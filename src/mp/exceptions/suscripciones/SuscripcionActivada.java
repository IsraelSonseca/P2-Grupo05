package mp.exceptions.suscripciones;

import mp.exceptions.Result;
import mp.subforos.SubForo;
import mp.users.MiembroURJC;

public class SuscripcionActivada extends Result {
    public SuscripcionActivada(MiembroURJC user, SubForo subForo) {
        super("El usuario: "+ user.getNick()+", ha sido suscrito al SUBFORO "+subForo.getId()+" -> "+subForo.getNombre()+" correctamente. SUSCRIPCION ACTIVADA");
    }
}

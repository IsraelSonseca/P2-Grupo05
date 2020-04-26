package mp.exceptions.suscripciones;

import mp.exceptions.Result;
import mp.subforos.SubForo;
import mp.users.MiembroURJC;

public class UsuarioDadoDeBaja extends Result {
    public UsuarioDadoDeBaja(MiembroURJC user, SubForo subForo) {
        super("El usuario: " + user.getNick() + ", acaba de ser dado de baja al SUBFORO " + subForo.getId() + " -> " + subForo.getNombre());
    }
}

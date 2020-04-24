package mp.exceptions.subForo;

import mp.exceptions.Result;
import mp.subforos.SubForo;
import mp.users.MiembroURJC;

public class SubForoYaExistente extends Result {
    public SubForoYaExistente(SubForo nuevoForo, MiembroURJC user) {
        super(user.getNick() + " no puede crear un subForo con este nombre: " + nuevoForo.getNombre() + ", ya está creado en RedditURJC. CREACIÓN DEL SUBFORO CANCELADO");
    }
}

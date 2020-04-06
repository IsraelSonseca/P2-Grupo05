package mp.exceptions.subForo;

import mp.exceptions.Result;
import mp.users.MiembroURJC;

public class CrearSubforoSinPermiso extends Result {
    public CrearSubforoSinPermiso(MiembroURJC userLogued) {
        super(userLogued.getNick()+" no es Profesor, no tiene permisos para crear SubForos. CREACIÓN DEL SUBFORO CANCELADO");
    }
}

package mp.exceptions.subForo;

import mp.exceptions.Result;
import mp.subforos.SubForo;
import mp.users.MiembroURJC;

public class SubforoCreado extends Result {
    public SubforoCreado(SubForo nuevoForo, MiembroURJC user) {
        super("Subforo con Nombre: "+nuevoForo.getNombre()+" creado correctamente por "+user.getNick()+". CREACIÓN DEL SUBFORO CORRECTO");
    }
}

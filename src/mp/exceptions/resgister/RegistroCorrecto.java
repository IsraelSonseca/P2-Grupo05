package mp.exceptions.resgister;

import mp.exceptions.Result;
import mp.users.MiembroURJC;

public class RegistroCorrecto extends Result {
    public RegistroCorrecto(MiembroURJC nuevoUsuario) {
        super(nuevoUsuario.getClass() + " " + nuevoUsuario.getNick() + " registrado correctamente. REGISTRO CORRECTO "+nuevoUsuario.toString());
    }
}

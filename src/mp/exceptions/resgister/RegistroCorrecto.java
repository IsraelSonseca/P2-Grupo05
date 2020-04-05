package mp.exceptions.resgister;

import mp.exceptions.Result;
import mp.users.Alumno;
import mp.users.MiembroURJC;
import mp.users.Profesor;

public class RegistroCorrecto extends Result {
    public RegistroCorrecto(MiembroURJC nuevoUsuario) {
        super(nuevoUsuario.getClass()+" "+nuevoUsuario.getNick()+" registrado correctamente. REGISTRO CORRECTO");
    }
}

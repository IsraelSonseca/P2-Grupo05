package mp.exceptions;

import mp.users.Alumno;
import mp.users.MiembroURJC;
import mp.users.Profesor;

public class RegistroCorrecto extends Result {
    public RegistroCorrecto(MiembroURJC nuevoUsuario) {
        super(nuevoUsuario.getClass()+" registrado correctamente.");
    }
}

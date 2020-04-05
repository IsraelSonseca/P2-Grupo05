package mp.exceptions;

import mp.users.Alumno;
import mp.users.MiembroURJC;
import mp.users.Profesor;

public class UsuarioRegistrado extends Result {
    public UsuarioRegistrado(MiembroURJC nuevoUsuario) {
        super(nuevoUsuario.getClass()+" registrado correctamente.");
    }
}

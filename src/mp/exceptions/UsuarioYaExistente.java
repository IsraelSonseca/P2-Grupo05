package mp.exceptions;

import mp.users.MiembroURJC;

public class UsuarioYaExistente extends Exception {
    public UsuarioYaExistente(MiembroURJC nuevoUsuario) {
    }
}

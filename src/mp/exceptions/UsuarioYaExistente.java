package mp.exceptions;

import mp.users.MiembroURJC;

public class UsuarioYaExistente extends Result {
    public UsuarioYaExistente(MiembroURJC nuevoUsuario) {
        super("Un usuario con este email:"+ nuevoUsuario.getEmail() +", ya esta registrado en el RedditURJC");
    }
}

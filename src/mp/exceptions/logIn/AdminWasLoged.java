package mp.exceptions.logIn;

import mp.exceptions.Result;

public class AdminWasLoged extends Result {
    public AdminWasLoged() {
        super("Administador ya está logueado.PERMISOS DE ADMINISTRADOR PERMANECEN CONCEDIDOS");
    }
}

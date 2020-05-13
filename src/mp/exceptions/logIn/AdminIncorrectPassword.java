package mp.exceptions.logIn;

import mp.exceptions.Result;

public class AdminIncorrectPassword extends Result {
    public AdminIncorrectPassword(String cont) {
        super("La contrasena " + cont + ", es incorrecta para el Administrador. PERMISOS DE ADMINISTRADOR DENEGADOS");
    }
}

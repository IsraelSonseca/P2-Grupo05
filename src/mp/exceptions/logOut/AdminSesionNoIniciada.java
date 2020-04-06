package mp.exceptions.logOut;

import mp.exceptions.Result;

public class AdminSesionNoIniciada extends Result {
    public AdminSesionNoIniciada() {
        super("El administrador no tiene la sesión iniciada. PERMISOS DE ADMINISTRADOR CONTINUARAN INACTIVOS");
    }
}

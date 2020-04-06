package mp.exceptions.logOut;

import mp.exceptions.Result;

public class AdminCierreSesion extends Result {

    public AdminCierreSesion() {
        super("Administrador ha cerrado su sesión. PERMISOS DE ADMINISTRADOR RETIRADOS");
    }
}

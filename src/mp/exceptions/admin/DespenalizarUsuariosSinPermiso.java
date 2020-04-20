package mp.exceptions.admin;

import mp.exceptions.Result;

public class DespenalizarUsuariosSinPermiso extends Result {
    public DespenalizarUsuariosSinPermiso() {
        super("No tiene permiso para despenalizar a un usuario");
    }
}
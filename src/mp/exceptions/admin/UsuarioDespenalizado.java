package mp.exceptions.admin;

import mp.exceptions.Result;

public class UsuarioDespenalizado extends Result {
    public UsuarioDespenalizado(String s) {
        super("El usuario " + s + " ha sido despenalizado correctamente");
    }
}

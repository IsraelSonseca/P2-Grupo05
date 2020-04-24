package mp.exceptions.admin;

import mp.exceptions.Result;

public class UsuarioSinPenalizaciones extends Result {
    public UsuarioSinPenalizaciones() {
        super("Este Usuario no puede ser despenalizado puesto que no consta de ninguna penalización actualmente");
    }
}
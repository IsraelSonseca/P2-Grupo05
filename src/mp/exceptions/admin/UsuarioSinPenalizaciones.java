package mp.exceptions.admin;

import javafx.scene.control.TableView;
import mp.exceptions.Result;
import mp.subforos.Entrada;
import mp.users.MiembroURJC;

public class UsuarioSinPenalizaciones extends Result {
    public UsuarioSinPenalizaciones() {
        super("Este Usuario no puede ser despenalizado puesto que no consta de ninguna penalización actualmente");
    }
}
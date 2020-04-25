package mp.exceptions.crearEntrada;

import mp.exceptions.Result;
import mp.subforos.Entrada;
import mp.users.MiembroURJC;

public class ModificarEntradaAjena extends Result {
    public ModificarEntradaAjena(MiembroURJC logueado,Entrada entrada) {
        super(logueado.getNick()+",no creaste la entrada "+entrada.getId()+" "+entrada.getTitulo() +".MODIFICACIÓN ENTRADA CANCELADA");
    }
}

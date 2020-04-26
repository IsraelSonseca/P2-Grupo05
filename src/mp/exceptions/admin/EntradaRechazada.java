package mp.exceptions.admin;

import mp.exceptions.Result;
import mp.subforos.Entrada;
import mp.subforos.EntradaGenerica;
import mp.users.MiembroURJC;

public class EntradaRechazada extends Result {
    public EntradaRechazada(EntradaGenerica entrada, MiembroURJC creador) {
        super("Entrada con titulo " + entrada.getTitulo() + ", y con id  " + entrada.getId() + " rechazada correctamente. ENTRADA RECHAZADA CORRECTAMENTE\n" +
                "El usuario " + creador.getNick() + " ha sido penalizado 2 DIAS. USUARIO PENALIZADO CORRECTAMENTE");
    }
}

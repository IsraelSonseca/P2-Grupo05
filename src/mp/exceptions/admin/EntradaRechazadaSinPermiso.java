package mp.exceptions.admin;

import mp.exceptions.Result;

public class EntradaRechazadaSinPermiso extends Result {
    public EntradaRechazadaSinPermiso() {
        super("El administrados no tiene sesión iniciada, no tiene permisos para rechazar Entradas. RECHAZO DE ENTRADA CANCELADO");
    }
}

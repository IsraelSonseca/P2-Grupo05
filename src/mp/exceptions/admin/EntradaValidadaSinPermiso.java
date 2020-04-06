package mp.exceptions.admin;

import mp.exceptions.Result;

public class EntradaValidadaSinPermiso extends Result {
    public EntradaValidadaSinPermiso() {
        super("El administrados no tiene sesión iniciada, no tiene permisos para validar Entradas. VALIDACIÓN ENTRADA CANCELADA");
    }
}

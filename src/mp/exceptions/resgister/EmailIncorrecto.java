package mp.exceptions.resgister;

import mp.exceptions.Result;

public class EmailIncorrecto extends Result {
    public EmailIncorrecto(String email) {
        super("El email: "+email+", no es válido o contiene errores. REGISTRO CANCELADO");
    }
}

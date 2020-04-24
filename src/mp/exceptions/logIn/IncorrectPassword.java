package mp.exceptions.logIn;

import mp.exceptions.Result;

public class IncorrectPassword extends Result {
    public IncorrectPassword(String cont, String nick) {
        super("La contraseña " + cont + ", es incorrecta para el usuario con nick: " + nick + ". INICIO DE SESION CANCELADO");
    }
}

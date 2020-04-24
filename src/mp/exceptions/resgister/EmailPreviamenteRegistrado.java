package mp.exceptions.resgister;

import mp.exceptions.Result;

public class EmailPreviamenteRegistrado extends Result {
    public EmailPreviamenteRegistrado(String email) {
        super("Un usuario con este email: " + email + ", ya está registrado en RedditURJC. REGISTRO CANCELADO");
    }
}

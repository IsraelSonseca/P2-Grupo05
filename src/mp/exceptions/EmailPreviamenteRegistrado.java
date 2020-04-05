package mp.exceptions;

public class EmailPreviamenteRegistrado extends Result {
    public EmailPreviamenteRegistrado(String email) {
        super("Un usuario con este email: "+email+", ya está registrado en RedditURJC. REGISTRO CANCELADO");
    }
}

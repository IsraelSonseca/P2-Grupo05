package mp.subforos.entradas.opiniones;

import mp.subforos.entradas.ObjetoPuntuable;
import mp.users.MiembroURJC;

public class Comentario extends ObjetoPuntuable {

    // Comentario esRespondido;

    private String texto;

    public Comentario(String texto, MiembroURJC user) {
        super(0, user);
        this.texto = texto;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    @Override
    public String toString() {
        return "Comentario" + this.getId() + ": " + this.getUser().getNick() + ": '" + this.getTexto() + '\'';
    }


}

        

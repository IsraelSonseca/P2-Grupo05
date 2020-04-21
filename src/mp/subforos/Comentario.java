package mp.subforos;

import java.util.HashMap;
import java.util.LinkedList;
import mp.users.MiembroURJC;

public class Comentario extends ObjetoPuntuable {
        
	// Comentario esRespondido;
       
        private String texto;
        private MiembroURJC user;
        
	public Comentario(String  texto,MiembroURJC user) {
		super(0);
		this.texto=texto;
		this.user=user;
	}
   
    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }


}

        

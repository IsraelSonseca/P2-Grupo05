package mp.subforos;

import java.util.HashMap;
import java.util.LinkedList;
import mp.users.MiembroURJC;

public class Comentario extends ObjetoPuntuable {
        
	// Comentario esRespondido;
       
    private String texto;
        
	public Comentario(String  texto,MiembroURJC user) {
		super(0,user);
		this.texto=texto;
	}
   
    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }


}

        

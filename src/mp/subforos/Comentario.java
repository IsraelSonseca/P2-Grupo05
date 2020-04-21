package mp.subforos;

import java.util.HashMap;
import java.util.LinkedList;
import mp.users.MiembroURJC;

public class Comentario extends ObjetoPuntuable {
        
	// Comentario esRespondido;
       
        private String texto;
	private int id = 0;
        private HashMap<Integer, Comentario> respuestas;
        private MiembroURJC user;
        
	public Comentario(String  texto,MiembroURJC user) {
		super(0);
                this.texto=texto;
                id=id+1;
                this.id=id;
                this.respuestas = new HashMap<>();
                this.user=user;
	}
        

    public HashMap<Integer, Comentario> getRespuestas() {
        return respuestas;
    }

    public void setRespuestas(HashMap<Integer, Comentario> respuestas) {
        this.respuestas = respuestas;
    }
        

   
    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean contieneObjetoPuntuable(int objetoPuntuable) {
        if(this.respuestas.containsKey(objetoPuntuable)){
          return true;
        }
        boolean encontrado=false;
          int i = 1;
          while((!encontrado)&&(i<=this.respuestas.size())){
              if(this.respuestas.get(i).contieneObjetoPuntuable(objetoPuntuable)){
                  encontrado=true;
              }


          } 
          return encontrado;
    }

    ObjetoPuntuable devuelveObjetoPuntuable(int objetoPuntuable) {
       if(this.respuestas.containsKey(objetoPuntuable)){
             return this.respuestas.get(objetoPuntuable);
          }
        ObjetoPuntuable obj=null;
        boolean encontrado = false;
        int i = 1;
        while((!encontrado)&&(i<=this.respuestas.size())){
            
            if(this.respuestas.get(i).contieneObjetoPuntuable(objetoPuntuable)){
                obj = this.respuestas.get(i).devuelveObjetoPuntuable(objetoPuntuable);
                encontrado = true ;
            }
            
            
        } 
        
        return obj ;
    }

   

    }
        

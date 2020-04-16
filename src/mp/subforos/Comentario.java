package mp.subforos;

import java.util.LinkedList;

public class Comentario extends ObjetoPuntuable {
        
	// Comentario esRespondido;
        private LinkedList<Comentario> respuestas;
        private String texto;
	private TipoComentario tipo;
	private int id = 0;
        
	public Comentario(int puntos,String  texto,TipoComentario tipo) {
		super(puntos);
                this.texto=texto;
                this.tipo=tipo;
                id=id+1;
                this.id=id;
                this.respuestas=null;
	}
        

	public void comentar() {
            id=id++;
            
            Comentario comment=new Comentario(int puntos,String texto,TipoComentario tipo);		// TODO - implement Comentario.comentar
		
	}
        

    public LinkedList<Comentario> getRespuestas() {
        return respuestas;
    }

    public void setRespuestas(LinkedList<Comentario> respuestas) {
        this.respuestas = respuestas;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public TipoComentario getTipo() {
        return tipo;
    }

    public void setTipo(TipoComentario tipo) {
        this.tipo = tipo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
        

}
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
	}
        

	public void comentar() {
            id=id++;

            Comentario comment=new Comentario();		// TODO - implement Comentario.comentar
		
	}

}
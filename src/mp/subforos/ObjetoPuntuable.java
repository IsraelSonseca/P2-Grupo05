package mp.subforos;

import java.util.HashMap;
import mp.exceptions.comentario.ComentarioCreado;
import mp.exceptions.comentario.ComentarioYaExistente;
import mp.exceptions.crearEntrada.EntradaCreada;
import mp.exceptions.crearEntrada.EntradaYaExistente;



public class ObjetoPuntuable implements Comparable<ObjetoPuntuable> {

	private int puntos;
        private static int contador=0;
	private int id;
        private HashMap<Integer, Comentario> comentarios;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
        
	public ObjetoPuntuable(int puntos) {
            contador++;
            this.id=contador;
            this.puntos = puntos;
            this.comentarios = new HashMap<>();
	}

	@Override
	public int compareTo(ObjetoPuntuable objetoPuntuable) {
		int resultado=0;
		if (this.puntos<objetoPuntuable.puntos) {
			resultado = -1;
		}
		else if (this.puntos>objetoPuntuable.puntos) {
			resultado = 1;
		}
		return resultado;
	}
        
        public void aumentar (){
            puntos = puntos + 1;
        }
        
        public void disminuir (){
            puntos = puntos - 1;
        }

    public void addComentario(Comentario nuevo) throws ComentarioCreado, ComentarioYaExistente {
        if (!comentarios.containsValue(nuevo)) {
			this.comentarios.put(nuevo.getId(), (Comentario) nuevo);
			throw new ComentarioCreado(nuevo,this);
		} else {
			nuevo.eliminar();
			throw new ComentarioYaExistente(nuevo);
		}
    }

    public void eliminar() {
        contador--;
        
    }
        
}
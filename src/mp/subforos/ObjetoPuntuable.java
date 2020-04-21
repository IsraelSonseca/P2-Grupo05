package mp.subforos;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;

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

    public HashMap<Integer, Comentario> getComentarios() {
        return comentarios;
    }

    public void setComentarios(HashMap<Integer, Comentario> comentarios) {
        this.comentarios = comentarios;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ObjetoPuntuable obj = (ObjetoPuntuable) o;
        return id == obj.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public boolean contieneObjetoPuntuable(int objetoPuntuable) {
        if (this.comentarios.size()==0){
            return false;
        } else if(this.comentarios.containsKey(objetoPuntuable)){
            return true;
        }
        boolean encontrado=false;
        Integer i;
        Set claves= this.getComentarios().keySet();
        Iterator iterator= claves.iterator();
        while((!encontrado)&&(iterator.hasNext())){
            i= (Integer) iterator.next();
            if(this.comentarios.get(i).contieneObjetoPuntuable(objetoPuntuable)){
                encontrado=true;
            }
        }
        return encontrado;
    }

    public ObjetoPuntuable devuelveObjetoPuntuable(int objetoPuntuable) {
        if(this.comentarios.containsKey(objetoPuntuable)){
            return this.comentarios.get(objetoPuntuable);
        }
        ObjetoPuntuable obj=null;
        boolean encontrado = false;
        Integer i;
        Set claves = this.getComentarios().keySet();
        Iterator iterator=claves.iterator();
        while((!encontrado)&&(iterator.hasNext())){
            i= (Integer) iterator.next();
            if(this.comentarios.get(i).contieneObjetoPuntuable(objetoPuntuable)){
                obj = this.comentarios.get(i).devuelveObjetoPuntuable(objetoPuntuable);
                encontrado = true ;
            }
        }

        return obj ;
    }
        
}
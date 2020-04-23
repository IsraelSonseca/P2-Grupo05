package mp.subforos;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;

import mp.exceptions.comentario.ComentarioCreado;
import mp.exceptions.comentario.ComentarioYaExistente;
import mp.exceptions.crearEntrada.EntradaCreada;
import mp.exceptions.crearEntrada.EntradaYaExistente;
import mp.exceptions.votaciones.ValoracionNoContemplada;
import mp.exceptions.votaciones.VotacionCreada;
import mp.exceptions.votaciones.VotacionYaExistente;
import mp.users.MiembroURJC;


public class ObjetoPuntuable implements Serializable, Comparable<ObjetoPuntuable> {

    private static final long serialVersionUID = 1L;
    private int puntos;
	private static int contador=0;
	private int id;
	private HashMap<Integer, Comentario> comentarios;
    private HashMap<String, Votacion> valoraciones;
    private MiembroURJC user;

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public MiembroURJC getUser() {
        return user;
    }

    public void setUser(MiembroURJC user) {
        this.user = user;
    }

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

    public ObjetoPuntuable(int puntos,MiembroURJC user) {
        contador++;
        this.id=contador;
        this.puntos = puntos;
        this.comentarios = new HashMap<>();
        this.valoraciones = new HashMap<>();
        this.user=user;
    }

	@Override
	public int compareTo(ObjetoPuntuable objetoPuntuable) {
		int resultado=0;
		if (this.puntos<objetoPuntuable.puntos) {
			resultado = 1;
		}
		else if (this.puntos>objetoPuntuable.puntos) {
			resultado = -1;
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

    public void addValoracion(Votacion votacion) throws VotacionCreada, VotacionYaExistente {
        if (!valoraciones.containsValue(votacion)) {
            this.valoraciones.put(votacion.getUser().getNick(), votacion);
            actualizarPuntos();
            throw new VotacionCreada(votacion,this);
        } else {
            this.valoraciones.get(votacion.getUser().getNick()).setEstado(votacion.getEstado());
            actualizarPuntos();
            throw new VotacionYaExistente(votacion,this);
        }
    }

    private void actualizarPuntos() {
        int puntuacion= 0;
        String valorador;
        Set valoradores = this.valoraciones.keySet();
        Iterator iterator = valoradores.iterator();
        while (iterator.hasNext()){
            valorador= (String) iterator.next();
            EstadoValoracion estado =this.valoraciones.get(valorador).getEstado();
            if (estado==EstadoValoracion.positiva){
                puntuacion+=1;
            } else {
                puntuacion-=1;
            }
        }
        this.puntos=puntuacion;
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

    public void valorar(String valoracion, MiembroURJC user) throws ValoracionNoContemplada, VotacionCreada, VotacionYaExistente {
        Votacion votacion;
        if (valoracion.equals("positiva")){
            votacion=new Votacion(user, EstadoValoracion.positiva);
        } else if (valoracion.equals("negativa")){
            votacion=new Votacion(user,EstadoValoracion.negativa);
        } else {
            throw new ValoracionNoContemplada(valoracion);
        }
        this.addValoracion(votacion);
    }

    public String viewRec(String tabulado) {
        String objPunt= tabulado+this.toString()+"\n"+tabulado+"PUNTUACION: "+this.getPuntos();
        for (Comentario comentario:this.comentarios.values()) {
            objPunt += "\n"+comentario.viewRec(tabulado+"     ");
        }
        return objPunt;
    }
}
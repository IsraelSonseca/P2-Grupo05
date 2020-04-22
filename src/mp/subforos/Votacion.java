package mp.subforos;

import mp.users.MiembroURJC;

import java.util.Objects;

import static mp.subforos.EstadoValoracion.negativa;
import static mp.subforos.EstadoValoracion.positiva;

public class Votacion {

    private MiembroURJC user;
	private EstadoValoracion estado;


    public Votacion(MiembroURJC user, EstadoValoracion estado) {
        this.user = user;
        this.estado = estado;
    }

    public MiembroURJC getUser() {
        return user;
    }

    public void setUser(MiembroURJC user) {
        this.user = user;
    }

    public EstadoValoracion getEstado() {
        return estado;
    }



    public void setEstado(EstadoValoracion estado) {
        this.estado = estado;
    }

    public void like(ObjetoPuntuable obj) {
		if (estado == positiva){
                    System.out.println("No se puede valorar positivamente dos veces");    
                }else{
                    estado = positiva;
                    obj.aumentar();
                }
	}

	public void dislike(ObjetoPuntuable obj) {
		if (estado == negativa){
                    System.out.println("No se puede valorar negativamente dos veces");                 
                }else{
                    estado = negativa;
                    obj.disminuir();
                }
	}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Votacion votacion = (Votacion) o;
        return user.equals(votacion.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user);
    }
}
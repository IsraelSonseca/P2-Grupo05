package mp.subforos.entradas.opiniones;

import mp.subforos.entradas.ObjetoPuntuable;
import mp.users.MiembroURJC;

import java.io.Serializable;
import java.util.Objects;

import static mp.subforos.entradas.opiniones.EstadoValoracion.negativa;
import static mp.subforos.entradas.opiniones.EstadoValoracion.positiva;

public class Votacion implements Serializable {

    private static final long serialVersionUID = 1L;
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
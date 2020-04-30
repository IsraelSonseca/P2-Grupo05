package mp.subforos.entradas;

import mp.users.MiembroURJC;

import java.io.Serializable;

public abstract class EntradaGenerica extends ObjetoPuntuable implements Serializable {

    private static final long serialVersionUID = 1L;
    private String titulo;
    private String texto;
    private EstadoEntrada estado;
    private Entrada entradaRaiz;

    public EntradaGenerica(String titulo, String texto, MiembroURJC user) {
        super(0, user);
        this.titulo = titulo;
        this.texto = texto;
        this.estado = EstadoEntrada.creada;
        this.entradaRaiz= (Entrada) this;
    }

    public EntradaGenerica(String titulo, String texto, MiembroURJC user,Entrada entradaRaiz) {
        super(0, user);
        this.titulo = titulo;
        this.texto = texto;
        this.estado = EstadoEntrada.creada;
        this.entradaRaiz=entradaRaiz;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public EstadoEntrada getEstado() {
        return estado;
    }

    public void setEstado(EstadoEntrada estado) {
        this.estado = estado;
    }

    public Entrada getEntradaRaiz() {
        return entradaRaiz;
    }

    public void setEntradaRaiz(Entrada entradaRaiz) {
        this.entradaRaiz = entradaRaiz;
    }

    public void validar() {
        // TODO - implement Entrada.validar
        this.setEstado(EstadoEntrada.validada);
    }

    public void rechazar() {
        // TODO - implement Entrada.validar
        this.setEstado(EstadoEntrada.rechazada);
    }

    @Override
    public String toString() {
        return this.getClass() +
                ": titulo='" + titulo + '\'' +
                ", texto='" + texto + '\'';
    }

    public String msgNotificacion() {
        return "Nuevo "+this.getClass()+": " + this.getTitulo();
    }


}

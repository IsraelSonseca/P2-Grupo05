package mp.subforos;

import mp.users.MiembroURJC;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Objects;

public class Entrada extends ObjetoPuntuable implements Serializable {

	private String titulo;
	private String texto;
	private EstadoEntrada estado;
	private SubForo subForo;

	public Entrada(String titulo, String texto, MiembroURJC user, SubForo subForo) {
		super(0,user);
		this.titulo = titulo;
		this.texto = texto;
		this.estado = EstadoEntrada.creada;
		this.subForo=subForo;
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

	public SubForo getSubForo() {
		return subForo;
	}

	public void setSubForo(SubForo subForo) {
		this.subForo = subForo;
	}

	public void crear() {
		// TODO - implement Entrada.crear
		throw new UnsupportedOperationException();
	}

	public void visualizar() {
		// TODO - implement Entrada.visualizar
		throw new UnsupportedOperationException();
	}

	public void modificar() {
		// TODO - implement Entrada.modificar
		throw new UnsupportedOperationException();
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
		return "Entrada" + this.getId() + " => TÍTULO: '" + titulo + '\'' + ", TEXTO: '" + texto + '\'';
	}


	public String msgNotificacion(){
		return "Nueva entrada con título "+ this.getTitulo();
	}



}

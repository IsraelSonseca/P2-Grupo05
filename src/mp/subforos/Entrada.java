package mp.subforos;

import java.util.Objects;

public class Entrada extends ObjetoPuntuable {

	private static int contador=0;
	private int id;
	private String titulo;
	private String texto;
	private EstadoEntrada estado;

	public Entrada(String titulo, String texto) {
		contador++;
		this.id=contador;
		this.titulo = titulo;
		this.texto = texto;
		this.estado = EstadoEntrada.creada;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public void eliminar() {
		contador--;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Entrada entrada = (Entrada) o;
		return id == entrada.id;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public String toString() {
		return "Entrada" + id + " => TÍTULO: '" + titulo + '\'' + ", TEXTO: '" + texto + '\'';
	}
}
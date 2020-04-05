package mp.subforos;

import java.util.Objects;

public class SubForo {

	private static int contador=0;
	private int id;
	private String nombre;


	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public SubForo(String nombre) {
		contador++;
		this.nombre = nombre;
		this.id = contador;
	}

	public void eliminar(){
		contador--;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		SubForo subForo = (SubForo) o;
		return nombre.equals(subForo.nombre);
	}

	@Override
	public int hashCode() {
		return Objects.hash(nombre);
	}

	@Override
	public String toString() {
		return "SubForo " + id + " => " + nombre;
	}
}
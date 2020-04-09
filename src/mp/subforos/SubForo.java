package mp.subforos;

import mp.exceptions.crearEntrada.EntradaCreada;
import mp.exceptions.crearEntrada.EntradaYaExistente;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Objects;

public class SubForo implements Serializable {

	private static int contador=0;
	private int id;
	private String nombre;
	private HashMap<Integer, Entrada> entradas;


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

	public HashMap<Integer, Entrada> getEntradas() {
		return entradas;
	}

	public void setEntradas(HashMap<Integer, Entrada> entradas) {
		this.entradas = entradas;
	}

	public SubForo(String nombre) {
		contador++;
		this.nombre = nombre;
		this.id = contador;
		this.entradas = new HashMap<>();
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

	public void addEntrada(Entrada entrada) throws EntradaYaExistente, EntradaCreada {
		if (!entradas.containsValue(entrada)) {
			this.entradas.put(entrada.getId(), entrada);
			throw new EntradaCreada(entrada);
		} else {
			entrada.eliminar();
			throw new EntradaYaExistente(entrada);
		}
	}

	public void eliminar() {
		contador--;
	}

	@Override
	public String toString() {
		return "SubForo " + id + " => " + nombre;
	}
}
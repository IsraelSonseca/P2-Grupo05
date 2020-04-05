package mp.admin;

import mp.subforos.Entrada;
import mp.users.MiembroURJC;

import java.util.LinkedList;

public class Administrador {

	private LinkedList entradasAValidar;

	public Administrador() {
		this.entradasAValidar = new LinkedList();
	}

	/**
	 * 
	 * @param idEntrada
	 */
	public boolean validarEntrada(int idEntrada) {
		// TODO - implement Administrador.validarEntrada
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param parameter
	 */
	public void penalizar(MiembroURJC parameter) {
		// TODO - implement Administrador.penalizar
		throw new UnsupportedOperationException();
	}

	public void anadirEntAValidar(Entrada entrada){
		entradasAValidar.addFirst(entrada);
	}

}
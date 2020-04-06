package mp.admin;

import mp.exceptions.logIn.*;
import mp.exceptions.logOut.AdminCierreSesion;
import mp.exceptions.logOut.AdminSesionNoIniciada;
import mp.subforos.Entrada;
import mp.users.MiembroURJC;

import java.util.LinkedList;

public class Administrador {

	final private String CONTRASENA="11111";
	private String cont;
	private LinkedList entradasAValidar;
	private boolean logued;

	public Administrador() {
		this.entradasAValidar = new LinkedList();
		this.cont=CONTRASENA;
		this.logued=false;
	}

	private String getContrasena() {
		return cont;
	}

	private void setContrasena(String cont) {
		this.cont = cont;
	}

	private void setLogued(boolean logued) {
		this.logued = logued;
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

	public boolean isLogued() {
		return this.logued;
	}

	public void logIn(String cont) throws AdminLogedCorrect, AdminIncorrectPassword, AdminWasLoged {
		if (this.logued) {
			throw new AdminWasLoged();
		}else {
			if (this.accepContrasena(cont)) {
				this.setLogued(true);
				throw new AdminLogedCorrect();
			} else {
				throw new AdminIncorrectPassword(cont);
			}
		}
	}

	private boolean accepContrasena(String cont) {
		return this.getContrasena().equals(cont);
	}

	public void logOut() throws AdminCierreSesion, AdminSesionNoIniciada {
		if (this.logued) {
			this.setLogued(false);
			throw new AdminCierreSesion();
		} else {
			throw new AdminSesionNoIniciada();
		}

	}
}
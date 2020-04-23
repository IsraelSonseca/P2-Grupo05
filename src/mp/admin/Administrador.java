package mp.admin;

import mp.exceptions.admin.*;
import mp.exceptions.logIn.*;
import mp.exceptions.logOut.AdminCierreSesion;
import mp.exceptions.logOut.AdminSesionNoIniciada;
import mp.subforos.Entrada;
import mp.users.MiembroURJC;

import java.io.Serializable;
import java.util.HashMap;
import java.util.LinkedList;

public class Administrador implements Serializable {

	private static final long serialVersionUID = 1L;
	final private String CONTRASENA="11111";
	private String cont;
	private LinkedList<Entrada> entradasAValidar;
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
	 */
	public boolean validarEntrada() throws EntradaValidada, EntradaValidadaSinPermiso, EntradasRevisadas {
		// TODO - implement Administrador.validarEntrada
		if (this.isLogued()){
			if (existsEntradasPendientes()) {
				Entrada entrada = entradasAValidar.removeLast();
				entrada.validar();
				throw new EntradaValidada(entrada);
			}else{
				throw new EntradasRevisadas();
			}
		}else{
			throw new EntradaValidadaSinPermiso();//no tiene permisos
		}
	}

	/**
	 *
	 */
	public void rechazarEntrada(HashMap<String, MiembroURJC> usuarios) throws EntradasRevisadas, EntradaRechazada, EntradaRechazadaSinPermiso {
		// TODO - implement Administrador.validarEntrada
		if (this.isLogued()){
			if (existsEntradasPendientes()) {
				Entrada entrada = entradasAValidar.removeLast();
				entrada.rechazar();
				MiembroURJC creador=usuarios.get(entrada.getUser().getNick());
				creador.penalizar();
				throw new EntradaRechazada(entrada,creador);
			}else{
				throw new EntradasRevisadas();
			}
		}else{
			throw new EntradaRechazadaSinPermiso();//no tiene permisos
		}
	}

	private boolean existsEntradasPendientes() {
		return (entradasAValidar.size()>0);
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
		if (this.isLogued()) {
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
		if (this.isLogued()) {
			this.setLogued(false);
			throw new AdminCierreSesion();
		} else {
			throw new AdminSesionNoIniciada();
		}

	}

	public void verEntradasPendientes() throws VerEntradasPendientes, VerEntradasPendientesSinPermiso {
		if (this.isLogued()){
			String strEntradas="";
			for (Entrada entrada : entradasAValidar) {
				strEntradas+= "\n"+this.viewEntrada(entrada);
			}
			throw new VerEntradasPendientes(strEntradas);
		}else{
			throw new VerEntradasPendientesSinPermiso();//no tiene permisos
		}
	}

	public void despenalizarUsuario(String s,HashMap<String, MiembroURJC> usuarios) throws UsuarioSinPenalizaciones, DespenalizarUsuariosSinPermiso, UsuarioDespenalizado{
		if (this.isLogued()) {
			MiembroURJC usuario = usuarios.get(s);
			if (usuario.estaPenalizado()) {
				usuario.despenalizarUsuario();
				throw new UsuarioDespenalizado(s);
			} else throw new UsuarioSinPenalizaciones();
		}
		else{
			throw new DespenalizarUsuariosSinPermiso();
		}
	}

	private String viewEntrada(Entrada entrada) {
		return entrada.toString();
	}

}
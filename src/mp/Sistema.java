package mp;

import mp.exceptions.UsuarioYaExistente;
import mp.users.MiembroURJC;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Sistema {
	private HashMap<Integer, MiembroURJC> usuarios;

	/**
	 * 
	 * @param nick
	 * @param cont
	 */
	public boolean login(String nick, String cont) {
		// TODO - implement Sistema.login
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param nick
	 * @param apellido
	 * @param apell
	 * @param contrasena
	 * @param email
	 */
	public boolean registrarUsuario(String nick, String apellido, String  apell, String contrasena, String email) {
		// TODO - implement Sistema.registro
		int tipo = validarEmail(email);
		//MiembroURJC
		if (tipo==1){

		}else if (tipo==2){

		}else{
			return false;
		}
		throw new UnsupportedOperationException();
	}

	public boolean registrarUsuario(MiembroURJC nuevoUsuario) throws UsuarioYaExistente {
		if (nuevoUsuario!=null) {
			if (usuarios.containsValue(nuevoUsuario)){
				this.usuarios.put(nuevoUsuario.getId(),nuevoUsuario);
				return true;
			}else{
				throw new UsuarioYaExistente(nuevoUsuario);
			}
		}
		return false;
	}

	/**
	 * 1->Profesor 2->Alumno 0->Email invalido
	 * @param email
	 */
	public int validarEmail(String email) {
		// TODO - implement Sistema.validarEmail
		// Patrón para validar el email
		Pattern pattern = Pattern
				.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
						+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");

		Matcher mather = pattern.matcher(email);

		if (mather.find() == true) {
			String[] partes = email.split("@");
			String dominio = partes[1];
			if (partes[1]=="urjc.es"){
				return 1;
			}else{
				return 2;
			}
		} else {
			return 0;
		}
	}

}
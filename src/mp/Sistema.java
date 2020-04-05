package mp;

import mp.exceptions.subForo.*;
import mp.exceptions.logIn.IncorrectPassword;
import mp.exceptions.logIn.LogedCorrect;
import mp.exceptions.logIn.SesionYaIniciada;
import mp.exceptions.logIn.UsuarioNoExistente;
import mp.exceptions.logOut.CierreSesion;
import mp.exceptions.logOut.SesionNoIniciada;
import mp.exceptions.resgister.EmailIncorrecto;
import mp.exceptions.resgister.EmailPreviamenteRegistrado;
import mp.exceptions.resgister.NickYaExistente;
import mp.exceptions.resgister.RegistroCorrecto;
import mp.subforos.SubForo;
import mp.users.Alumno;
import mp.users.MiembroURJC;
import mp.users.Profesor;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Sistema {
    private HashMap<String, MiembroURJC> usuarios;
	private HashMap<Integer, SubForo> subForos;
    private MiembroURJC userLogued;

    public Sistema() {
        this.usuarios = new HashMap<>();
        this.subForos = new HashMap<>();
    }

    /**
     * @param nick
     * @param cont
     */
    public boolean login(String nick, String cont) throws LogedCorrect, IncorrectPassword, UsuarioNoExistente, SesionYaIniciada {
        // TODO - implement Sistema.login
        if (sesionIniciada()) {
            throw new SesionYaIniciada(this.userLogued);
        }
        if (usuarios.containsKey(nick)) {
            MiembroURJC user = usuarios.get(nick);
            if (user.getContrasena().equals(cont)) {
                this.userLogued = user;
                throw new LogedCorrect(user);
            } else {
                throw new IncorrectPassword(cont, nick);
            }
        } else {
            throw new UsuarioNoExistente(nick);
        }
    }

    public boolean logout() throws CierreSesion, SesionNoIniciada {
        // TODO - implement Sistema.login
        if (sesionIniciada()) {
            MiembroURJC user = this.userLogued;
            this.userLogued = null;
            throw new CierreSesion(user);
        } else {
            throw new SesionNoIniciada("LOG OUT CANCELADO");
        }

    }

    private boolean sesionIniciada() {
        return !(userLogued == null);
    }

    /**
     * @param nombre
     * @param apellidos
     * @param nick
     * @param contrasena
     * @param email
     */
    public void registrarUsuario(String nombre, String apellidos, String nick, String contrasena, String email) throws NickYaExistente, EmailIncorrecto, RegistroCorrecto, EmailPreviamenteRegistrado {
        // TODO - implement Sistema.registro
        int tipo = validarEmail(email);
        MiembroURJC nuevoUsuario;
        if (tipo == 0) {
            throw new EmailIncorrecto(email);
        } else {
            for (MiembroURJC usuario : usuarios.values()) {
                if (usuario.getEmail().equals(email)) {
                    throw new EmailPreviamenteRegistrado(email);
                }
            }
            if (tipo == 1) {
                nuevoUsuario = new Profesor(nombre, apellidos, nick, contrasena, email);
            } else {
                nuevoUsuario = new Alumno(nombre, apellidos, nick, contrasena, email);
            }
            this.registrarUsuario(nuevoUsuario);
        }
    }

    private boolean registrarUsuario(MiembroURJC nuevoUsuario) throws NickYaExistente, RegistroCorrecto {
        if (nuevoUsuario != null) {
            if (!usuarios.containsValue(nuevoUsuario)) {
                this.usuarios.put(nuevoUsuario.getNick(), nuevoUsuario);
                throw new RegistroCorrecto(nuevoUsuario);
            } else {
                nuevoUsuario.eliminar();
                throw new NickYaExistente(nuevoUsuario);
            }
        }
        return false;
    }

    /**
     * 1->Profesor 2->Alumno 0->Email invalido
     *
     * @param email
     */
    private int validarEmail(String email) {
        // TODO - implement Sistema.validarEmail
        // Patrón para validar el email
        Pattern pattern = Pattern
                .compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");

        Matcher mather = pattern.matcher(email);

        if (mather.find() == true) {
            String[] partes = email.split("@");
            String dominio = partes[1];
            if (partes[1].equals("urjc.es")) {
                return 1;
            } else {
                return 2;
            }
        } else {
            return 0;
        }
    }

    public void crearSubforo(String nombre) throws SesionNoIniciada, SubforoCreado, SubForoYaExistente, CrearSubforoSinPermiso {
    	if (sesionIniciada()){
    		if (this.userLogued instanceof Profesor){
    			SubForo nuevoSubforo= ((Profesor) this.userLogued).crearSubforo(nombre);
    			this.addSubforo(nuevoSubforo,this.userLogued);
			}else{
    			throw new CrearSubforoSinPermiso(this.userLogued);
			}
		}else{
    		throw new SesionNoIniciada("Creacción del subforo "+nombre+" CANCELADA.");
		}
	}

	private void addSubforo(SubForo nuevoForo,MiembroURJC user) throws SubforoCreado, SubForoYaExistente {
		if (nuevoForo != null) {
			if (!subForos.containsValue(nuevoForo)) {
				this.subForos.put(nuevoForo.getId(), nuevoForo);
				throw new SubforoCreado(nuevoForo,user);
			} else {
			    nuevoForo.eliminar();
				throw new SubForoYaExistente(nuevoForo,user);
			}
		}
	}

	public void listSubforos() throws VerSubForoSinPermiso, VerSubforo {
        if (sesionIniciada()){
            String strForos="";
            for (SubForo subForo : subForos.values()) {
                strForos= strForos+this.userLogued.viewSubForo(subForo)+"\n";
            }
            throw new VerSubforo(this.userLogued,strForos);
        }else{
            throw new VerSubForoSinPermiso();//no tiene permisos
        }

    }

}
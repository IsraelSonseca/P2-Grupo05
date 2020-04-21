package mp;

import mp.exceptions.comentario.ComentarioYaExistente;
import mp.admin.Administrador;
import mp.exceptions.admin.*;
import mp.exceptions.crearEntrada.*;
import mp.exceptions.logIn.*;
import mp.exceptions.logOut.AdminCierreSesion;
import mp.exceptions.logOut.AdminSesionNoIniciada;
import mp.exceptions.subForo.*;
import mp.exceptions.logOut.CierreSesion;
import mp.exceptions.logOut.SesionNoIniciada;
import mp.exceptions.resgister.EmailIncorrecto;
import mp.exceptions.resgister.EmailPreviamenteRegistrado;
import mp.exceptions.resgister.NickYaExistente;
import mp.exceptions.resgister.RegistroCorrecto;
import mp.exceptions.suscripciones.SuscribirSinForo;
import mp.exceptions.suscripciones.SuscribirSinPermiso;
import mp.exceptions.suscripciones.SuscripcionActivada;
import mp.exceptions.suscripciones.SuscriptorYaExistente;
import mp.subforos.Entrada;
import mp.subforos.EstadoEntrada;
import mp.subforos.SubForo;
import mp.users.Alumno;
import mp.users.MiembroURJC;
import mp.users.Profesor;

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import mp.exceptions.comentario.ComentarSinPermiso;
import mp.exceptions.comentario.ComentarioCreado;
import mp.subforos.Comentario;

import mp.subforos.ObjetoPuntuable;

public class Sistema implements Serializable {
    private HashMap<String, MiembroURJC> usuarios;
    private HashMap<Integer, SubForo> subForos;
    private MiembroURJC userLogued;
    private Administrador admin;

    public Sistema() {
        this.usuarios = new HashMap<>();
        this.subForos = new HashMap<>();
        this.admin= new Administrador();
    }

    /**
     *
     * @param cont
     */
    public void loginAdmin(String cont) throws AdminLogedCorrect, AdminIncorrectPassword, AdminWasLoged {
        // TODO - implement Sistema.login
        this.admin.logIn(cont);
    }

    public void logoutAdmin() throws AdminCierreSesion, AdminSesionNoIniciada {
        // TODO - implement Sistema.login
        this.admin.logOut();
    }


    private boolean adminLogued() {
        return (this.admin.isLogued());
    }

    /**
     * @param nick
     * @param cont
     */
    public boolean login(String nick, String cont) throws LogedCorrect, IncorrectPassword, UsuarioNoExistente, SesionYaIniciada, UsuarioPenalizado {
        // TODO - implement Sistema.login
        if (sesionIniciada()) {
            throw new SesionYaIniciada(this.userLogued);
        }
        if (usuarios.containsKey(nick)) {
            MiembroURJC user = usuarios.get(nick);
            if (user.accepContrasena(cont)) {
                if (user.estaPenalizado()){
                    throw new UsuarioPenalizado(user);
                } else {
                    this.userLogued = user;
                    int n= this.userLogued.getNumNotificaciones();
                    String strNotificaciones = this.userLogued.listNotificaciones();
                    throw new LogedCorrect(user,strNotificaciones,n);
                }
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
            this.guardarSistema();
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

    public void verEntradasMayorValoración() throws VerEntradas {
        ArrayList<Entrada> entradas = new ArrayList<>();
        for (SubForo subForo : subForos.values()) {
            for (Entrada entrada : subForo.getEntradas().values()) {
                if (entrada.getEstado()== EstadoEntrada.validada){
                    entradas.add(entrada);
                }
            }
        }
        Collections.sort(entradas);
        String entradasStr = "";
        for (Entrada entrada : entradas){
            entradasStr=entradasStr+entrada.toString()+"\n";
        }
        throw new VerEntradas(entradasStr);
    }

    public void verEntradasPendientes() throws VerEntradasPendientes, VerEntradasPendientesSinPermiso {
        this.admin.verEntradasPendientes();
    }

    public void validarEntrada() throws EntradaValidada, EntradaValidadaSinPermiso, EntradasRevisadas {
        this.admin.validarEntrada();
    }

    public void rechazarEntrada() throws EntradaRechazada, EntradasRevisadas, EntradaRechazadaSinPermiso {
        this.admin.rechazarEntrada(this.usuarios);
    }

    public void crearEntrada(String titulo, String texto,int foro) throws CrearEntradaSinPermiso, CrearEntradaSinForo, EntradaCreada, EntradaYaExistente {
        if (sesionIniciada()){
            if(existeForo(foro)){
                Entrada nuevaEntrada = this.userLogued.crearEntrada(titulo,texto,this.subForos.get(foro));
                this.admin.anadirEntAValidar(nuevaEntrada);
                this.addEntrada(nuevaEntrada,foro);
            } else {
                throw new CrearEntradaSinForo(foro);
            }
        }else{
            throw new CrearEntradaSinPermiso();//no tiene permisos
        }
    }

    private void addEntrada(Entrada nuevaEntrada, int subForo) throws EntradaCreada, EntradaYaExistente {
        this.subForos.get(subForo).addEntrada(nuevaEntrada);

    }

    private boolean existeForo(int foro) {
        return subForos.containsKey(foro);
    }

    public void suscribirAForo(int foro) throws SuscriptorYaExistente, SuscripcionActivada, SuscribirSinForo, SuscribirSinPermiso {
        if (sesionIniciada()){
            if(existeForo(foro)){
                this.addSuscriptor(this.userLogued,foro);
            } else {
                throw new SuscribirSinForo(foro);
            }
        }else{
            throw new SuscribirSinPermiso();//no tiene permisos
        }
    }

    private void addSuscriptor(MiembroURJC userLogued, int subForo) throws SuscriptorYaExistente, SuscripcionActivada {
        this.subForos.get(subForo).anadirSubscriptor(userLogued);
    }

    private void guardarSistema(){
        try {
            FileOutputStream fos = new FileOutputStream("fichero.bin");
            ObjectOutputStream oos =new ObjectOutputStream(fos);
            oos.writeObject(this);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void crearComentario(String coment,int objetoPuntuable) throws ComentarSinPermiso, ComentarSinObjetoPuntuable, EntradaCreada, EntradaYaExistente, ComentarioCreado, ComentarioYaExistente {
        if (sesionIniciada()){
            if(existeObjetoPuntuable(objetoPuntuable)){
                ObjetoPuntuable objetoPadre = this.devuelveObjetoPuntuable(objetoPuntuable);
                Comentario comentario = this.userLogued.crearComentario(coment);
                
                this.addComentario(comentario,objetoPadre);
            } else {
                throw new ComentarSinObjetoPuntuable(objetoPuntuable);
            }
        }else{
            throw new ComentarSinPermiso();//no tiene permisos
        }
    }

    private void addComentario(Comentario nuevo,ObjetoPuntuable padre) throws ComentarioCreado, ComentarioYaExistente{
        padre.addComentario(nuevo);
    }

    private boolean existeObjetoPuntuable(int objetoPuntuable) {
        
        boolean encontrado = false;
        Integer i;
        Set claves= this.subForos.keySet();
        Iterator iterator = claves.iterator();
        while((!encontrado)&&(iterator.hasNext())){
            i= (Integer) iterator.next();
            if(this.subForos.get(i).contieneObjetoPuntuable(objetoPuntuable)){
                encontrado = true ;
            }
        } 
        
        return encontrado ;
         
    }
    
     private ObjetoPuntuable devuelveObjetoPuntuable(int objetoPuntuable) {
        
        ObjetoPuntuable obj=null;
        boolean encontrado = false;
         Integer i;
        Set claves= this.subForos.keySet();
         Iterator iterator = claves.iterator();
         while((!encontrado)&&(iterator.hasNext())){
            i= (Integer) iterator.next();
            if(this.subForos.get(i).contieneObjetoPuntuable(objetoPuntuable)){
                obj = this.subForos.get(i).devuelveObjetoPuntuable(objetoPuntuable);
                encontrado = true ;
            }
            
            
        } 
        
        return obj ;
     }
   


}
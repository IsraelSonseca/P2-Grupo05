package mp;

import mp.admin.Administrador;
import mp.exceptions.admin.*;
import mp.exceptions.comentario.ComentarSinObjetoPuntuable;
import mp.exceptions.comentario.ComentarSinPermiso;
import mp.exceptions.comentario.ComentarioCreado;
import mp.exceptions.comentario.ComentarioYaExistente;
import mp.exceptions.crearEntrada.*;
import mp.exceptions.logIn.*;
import mp.exceptions.logOut.AdminCierreSesion;
import mp.exceptions.logOut.AdminSesionNoIniciada;
import mp.exceptions.logOut.CierreSesion;
import mp.exceptions.logOut.SesionNoIniciada;
import mp.exceptions.resgister.EmailIncorrecto;
import mp.exceptions.resgister.EmailPreviamenteRegistrado;
import mp.exceptions.resgister.NickYaExistente;
import mp.exceptions.resgister.RegistroCorrecto;
import mp.exceptions.sistem.VerSistema;
import mp.exceptions.sistem.VerSistemaSinPermiso;
import mp.exceptions.subForo.*;
import mp.exceptions.suscripciones.*;
import mp.exceptions.votaciones.*;
import mp.subforos.*;
import mp.users.Alumno;
import mp.users.MiembroURJC;
import mp.users.Profesor;
import mp.users.Subscriptor;

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RedditURJC implements Serializable, Sistema {
    private static final long serialVersionUID = 1L;
    private final HashMap<String, MiembroURJC> usuarios;
    private final HashMap<Integer, SubForo> subForos;
    private final Administrador admin;
    private MiembroURJC userLogued;
    private static RedditURJC instancia=null;

    public static RedditURJC getInstance(){
        if (instancia==null){
            File f=new File("BaseDeDatos.obj");
            if (f.exists()){
                instancia=leerInfo();
            }else{
                instancia=new RedditURJC();
            }
        }
        return instancia;
    }

    @Override
    public void destroy() {
        instancia=null;
    }

    RedditURJC() {
        this.usuarios = new HashMap<>();
        this.subForos = new HashMap<>();
        this.admin = new Administrador();
    }

    private static RedditURJC leerInfo() {
        RedditURJC s = null;
        try {
            FileInputStream file = new FileInputStream("BaseDeDatos.obj");
            ObjectInputStream inputFile = new ObjectInputStream(file);
            s = (RedditURJC) inputFile.readObject();

            inputFile.close();
            file.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.exit(-1);
        }
        return s;
    }

    /**
     * @param cont
     */
    @Override
    public void loginAdmin(String cont) throws AdminLogedCorrect, AdminIncorrectPassword, AdminWasLoged {
        // TODO - implement Sistema.login
        this.admin.logIn(cont);
    }

    @Override
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
    @Override
    public boolean login(String nick, String cont) throws LogedCorrect, IncorrectPassword, UsuarioNoExistente, SesionYaIniciada, UsuarioPenalizado {
        // TODO - implement Sistema.login
        if (sesionIniciada()) {
            throw new SesionYaIniciada(this.userLogued);
        }
        if (usuarios.containsKey(nick)) {
            MiembroURJC user = usuarios.get(nick);
            if (user.accepContrasena(cont)) {
                if (user.estaPenalizado()) {
                    throw new UsuarioPenalizado(user);
                } else {
                    this.userLogued = user;
                    int n = this.userLogued.getNumNotificaciones();
                    String strNotificaciones = this.userLogued.listNotificaciones();
                    throw new LogedCorrect(user, strNotificaciones, n);
                }
            } else {
                throw new IncorrectPassword(cont, nick);
            }
        } else {
            throw new UsuarioNoExistente(nick);
        }
    }

    @Override
    public boolean logout() throws CierreSesion, SesionNoIniciada {
        // TODO - implement Sistema.login
        if (sesionIniciada()) {
            MiembroURJC user = this.userLogued;
            this.userLogued = null;
            this.guardarInfo();
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
    @Override
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

    @Override
    public void crearSubforo(String nombre) throws SesionNoIniciada, SubforoCreado, SubForoYaExistente, CrearSubforoSinPermiso {
        if (sesionIniciada()) {
            if (this.userLogued instanceof Profesor) {
                SubForo nuevoSubforo = ((Profesor) this.userLogued).crearSubforo(nombre);
                this.addSubforo(nuevoSubforo, this.userLogued);
            } else {
                throw new CrearSubforoSinPermiso(this.userLogued);
            }
        } else {
            throw new SesionNoIniciada("Creacción del subforo " + nombre + " CANCELADA.");
        }
    }

    private void addSubforo(SubForo nuevoForo, MiembroURJC user) throws SubforoCreado, SubForoYaExistente {
        if (nuevoForo != null) {
            if (!subForos.containsValue(nuevoForo)) {
                this.subForos.put(nuevoForo.getId(), nuevoForo);
                throw new SubforoCreado(nuevoForo, user);
            } else {
                nuevoForo.eliminar();
                throw new SubForoYaExistente(nuevoForo, user);
            }
        }
    }

    @Override
    public void listSubforos() throws VerSubForoSinPermiso, VerSubforo {
        if (sesionIniciada()) {
            String strForos = "";
            for (SubForo subForo : subForos.values()) {
                strForos += "\n" + this.userLogued.viewSubForo(subForo);
            }
            throw new VerSubforo(this.userLogued, strForos);
        } else {
            throw new VerSubForoSinPermiso();//no tiene permisos
        }
    }

    @Override
    public void verEntradasMayorValoración() throws VerEntradas {
        ArrayList<Entrada> entradas = new ArrayList<>();
        for (SubForo subForo : subForos.values()) {
            for (Entrada entrada : subForo.getEntradas().values()) {
                if (entrada.getEstado() == EstadoEntrada.validada) {
                    entradas.add(entrada);
                }
            }
        }
        Collections.sort(entradas);
        String entradasStr = "";
        for (Entrada entrada : entradas) {
            entradasStr += "\n" + entrada.toString();
        }
        throw new VerEntradas(entradasStr);
    }

    @Override
    public void verEntradasPendientes() throws VerEntradasPendientes, VerEntradasPendientesSinPermiso {
        this.admin.verEntradasPendientes();
    }

    @Override
    public void validarEntrada() throws EntradaValidada, EntradaValidadaSinPermiso, EntradasRevisadas {
        this.admin.validarEntrada();
    }

    @Override
    public void rechazarEntrada() throws EntradaRechazada, EntradasRevisadas, EntradaRechazadaSinPermiso {
        this.admin.rechazarEntrada(this.usuarios);
    }

    @Override
    public void crearEntrada(String titulo, String texto, int foro) throws CrearEntradaSinPermiso, CrearEntradaSinForo, EntradaCreada, EntradaYaExistente {
        if (sesionIniciada()) {
            if (existeForo(foro)) {
                Entrada nuevaEntrada = this.subForos.get(foro).crearEntrada(titulo, texto, this.userLogued);
                this.admin.anadirEntAValidar(nuevaEntrada);
                this.addEntrada(nuevaEntrada, foro);
            } else {
                throw new CrearEntradaSinForo(foro);
            }
        } else {
            throw new CrearEntradaSinPermiso();//no tiene permisos
        }
    }

    private void addEntrada(Entrada nuevaEntrada, int subForo) throws EntradaCreada, EntradaYaExistente {
        this.subForos.get(subForo).addEntrada(nuevaEntrada);
    }

    private boolean existeForo(int foro) {
        return subForos.containsKey(foro);
    }

    @Override
    public void suscribirAForo(int foro) throws SuscriptorYaExistente, SuscripcionActivada, SuscribirSinForo, SuscribirSinPermiso {
        if (sesionIniciada()) {
            if (existeForo(foro)) {
                this.addSuscriptor(this.userLogued, foro);
            } else {
                throw new SuscribirSinForo(foro);
            }
        } else {
            throw new SuscribirSinPermiso();//no tiene permisos
        }
    }

    @Override
    public void verForosSuscritos() throws NoSuscritoANingunFor, ForosSuscritos, SubforosNoDisponibles {
        if (sesionIniciada()) {
            if (subForos.isEmpty()) {
                throw new NoSuscritoANingunFor();
            } else {
                String a = "";
                for (SubForo subforo : subForos.values()) {
                    ArrayList<Subscriptor> AlumnosSuscritos = subforo.getSuscriptores();
                    for (Subscriptor s : AlumnosSuscritos) {
                        if (s.equals(this.userLogued)) {
                            a += "\n" + subforo;
                        }
                    }
                }
                throw new ForosSuscritos(a);
            }

        } else throw new SubforosNoDisponibles();
    }

    @Override
    public void despenalizarUsuario(String s) throws UsuarioSinPenalizaciones, DespenalizarUsuariosSinPermiso, UsuarioDespenalizado {
        this.admin.despenalizarUsuario(s, this.usuarios);
    }

    private void addSuscriptor(MiembroURJC userLogued, int subForo) throws SuscriptorYaExistente, SuscripcionActivada {
        this.subForos.get(subForo).anadirSubscriptor(userLogued);
    }

    private boolean guardarInfo() {
        try {
            FileOutputStream f = new FileOutputStream("BaseDeDatos.obj");
            ObjectOutputStream finalFile = new ObjectOutputStream(f);
            finalFile.writeObject(this);
            finalFile.close();
            f.close();
            return true;

        } catch (IOException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }


    @Override
    public void valorar(String valoracion, int objetoPuntuable) throws VotarSinPermiso, VotarSinObjetoPuntuable, ValoracionNoContemplada, VotacionCreada, VotacionYaExistente, ValorarObjetoPuntuablePropio {
        if (sesionIniciada()) {
            if (existeObjetoPuntuable(objetoPuntuable)) {
                ObjetoPuntuable objetoAValorar = this.devuelveObjetoPuntuable(objetoPuntuable);
                if (objetoAValorar.getUser().equals(this.userLogued)) {
                    throw new ValorarObjetoPuntuablePropio(objetoAValorar);
                } else {
                    objetoAValorar.valorar(valoracion, this.userLogued);
                }
            } else {
                throw new VotarSinObjetoPuntuable(objetoPuntuable);
            }
        } else {
            throw new VotarSinPermiso();//no tiene permisos
        }
    }

    @Override
    public void crearComentario(String coment, int objetoPuntuable) throws ComentarSinPermiso, ComentarioCreado, ComentarioYaExistente, ComentarSinObjetoPuntuable {
        if (sesionIniciada()) {
            if (existeObjetoPuntuable(objetoPuntuable)) {
                ObjetoPuntuable objetoPadre = this.devuelveObjetoPuntuable(objetoPuntuable);
                Comentario comentario = this.userLogued.crearComentario(coment);

                this.addComentario(comentario, objetoPadre);
            } else {
                throw new ComentarSinObjetoPuntuable(objetoPuntuable);
            }
        } else {
            throw new ComentarSinPermiso();//no tiene permisos
        }
    }

    private void addComentario(Comentario nuevo, ObjetoPuntuable padre) throws ComentarioCreado, ComentarioYaExistente {
        padre.addComentario(nuevo);
    }

    private boolean existeObjetoPuntuable(int objetoPuntuable) {

        boolean encontrado = false;
        Integer i;
        Set claves = this.subForos.keySet();
        Iterator iterator = claves.iterator();
        while ((!encontrado) && (iterator.hasNext())) {
            i = (Integer) iterator.next();
            if (this.subForos.get(i).contieneObjetoPuntuable(objetoPuntuable)) {
                encontrado = true;
            }
        }

        return encontrado;

    }

    private ObjetoPuntuable devuelveObjetoPuntuable(int objetoPuntuable) {

        ObjetoPuntuable obj = null;
        boolean encontrado = false;
        Integer i;
        Set claves = this.subForos.keySet();
        Iterator iterator = claves.iterator();
        while ((!encontrado) && (iterator.hasNext())) {
            i = (Integer) iterator.next();
            if (this.subForos.get(i).contieneObjetoPuntuable(objetoPuntuable)) {
                obj = this.subForos.get(i).devuelveObjetoPuntuable(objetoPuntuable);
                encontrado = true;
            }


        }

        return obj;
    }

    @Override
    public void verSistema() throws VerSistemaSinPermiso, VerSistema {
        if (sesionIniciada()) {
            String sistema = "";
            for (SubForo subForo : subForos.values()) {
                sistema = sistema + "\n" + this.userLogued.viewSubForoRec(subForo);
            }
            throw new VerSistema(this.userLogued, sistema);
        } else {
            throw new VerSistemaSinPermiso();//no tiene permisos
        }
    }
    public void modificarEntrada(String titulo, String texto, int entrada) throws ModificarEntradaNoExistente, ModificarEntradaSinPermiso, ModificarEntradaAjena, ModificacionEntradaCorrecta{
        if (sesionIniciada()) {
            Entrada entradaParaModificar = devuelveEntrada(entrada);
            if (!(entradaParaModificar == null)) { //Existe la entrada que queremos Modificar
                if(entradaParaModificar.getUser()== this.userLogued){
                    entradaParaModificar.setTitulo(titulo);
                    entradaParaModificar.setTexto(texto);
                    throw new ModificacionEntradaCorrecta(entradaParaModificar);
                }
                else{
                    throw new ModificarEntradaAjena(this.userLogued,entradaParaModificar);
                }
                
            } else {
                throw new ModificarEntradaNoExistente(entrada);
            }
        } else {
            throw new ModificarEntradaSinPermiso();//no tiene permisos
        }
    }
        
         private Entrada devuelveEntrada(int entrada) {
            Entrada entradaFinal = null;
            Set clavesForo = subForos.keySet();
            Iterator iteratorForo = clavesForo.iterator();
            boolean encontrado = false;
            while((iteratorForo.hasNext())&&(!encontrado)){
                Integer iForo = (Integer) iteratorForo.next();
                Set clavesEntrada = subForos.get(iForo).getEntradas().keySet();
                Iterator iteratorEntrada = clavesEntrada.iterator();
                while((iteratorEntrada.hasNext())&&(!encontrado)){
                    Integer iEntrada = (Integer) iteratorEntrada.next();
                    if(entrada==iEntrada){
                        encontrado= true;
                        entradaFinal = subForos.get(iForo).getEntradas().get(iEntrada);
                    }
                }
            }
            return entradaFinal;
        }
 }
package mp.users;

import mp.subforos.Comentario;
import mp.subforos.Entrada;
import mp.subforos.Texto;

public class MiembroURJC {
    private static int contador=0;
    private int id;
    private String nombre;
    private String apellidos;
    private String nick;
    private String contrasena;
    private String email;

    //GettersAndSetters
    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public MiembroURJC(String nombre, String apellidos, String nick, String contrasena, String email) {
        contador++;
        this.id=contador;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.nick = nick;
        this.contrasena = contrasena;
        this.email = email;
    }

    public void verNotificaciones() {
        // TODO - implement MiembroURJC.verNotificaciones
        throw new UnsupportedOperationException();
    }

    /**
     * Es el compartir entrada general que solo permite a�adir texto plano
     * @param txt
     * @param titulo
     * @param idSubforo
     */
    public Entrada crearEntrada(Texto txt, String titulo, int idSubforo) {
        // TODO - implement MiembroURJC.crearEntrada
        throw new UnsupportedOperationException();
    }

    /**
     *
     * @param idEntrada
     */
    public Comentario comentar(int idEntrada) {
        // TODO - implement MiembroURJC.comentar
        throw new UnsupportedOperationException();
    }

    /**
     *
     * @param idComentario
     */
    public Comentario Responder(int idComentario) {
        // TODO - implement MiembroURJC.Responder
        throw new UnsupportedOperationException();
    }

    /**
     *
     * @param idEntrada
     */
    public void votar(int idEntrada) {
        // TODO - implement MiembroURJC.votar
        throw new UnsupportedOperationException();
    }

    /**
     *
     * @param idEntrada
     */
    public Entrada compartirEntrada(int idEntrada) {
        // TODO - implement MiembroURJC.compartirEntrada
        throw new UnsupportedOperationException();
    }

    /**
     *
     * @param idEntrada
     */
    public Entrada modificarEntrada(int idEntrada) {
        // TODO - implement MiembroURJC.modificarEntrada
        throw new UnsupportedOperationException();
    }

    /**
     *
     * @param idSubforo
     */
    public Subscripcion subscribirse(int idSubforo) {
        // TODO - implement MiembroURJC.subscribirse
        throw new UnsupportedOperationException();
    }


}

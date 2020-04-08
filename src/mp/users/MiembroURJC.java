package mp.users;

import mp.penalizaciones.Penalizacion;
import mp.subforos.Comentario;
import mp.subforos.Entrada;
import mp.subforos.SubForo;
import mp.subforos.Texto;

import java.util.Objects;

public class MiembroURJC {
    private static int contador=0;
    private int id;
    private String nombre;
    private String apellidos;
    private String nick;
    private String contrasena;
    private String email;
    private Penalizacion penalizacion;

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

    private String getContrasena() {
        return contrasena;
    }

    private void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Penalizacion getPenalizacion() {
        return penalizacion;
    }

    public void setPenalizacion(Penalizacion penalizacion) {
        this.penalizacion = penalizacion;
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

    public void eliminar(){
        contador--;
    }

    public void verNotificaciones() {
        // TODO - implement MiembroURJC.verNotificaciones
        throw new UnsupportedOperationException();
    }

    /**
     * Es el compartir entrada general que solo permite a�adir texto plano
     * @param txt
     * @param titulo
     */
    public Entrada crearEntrada(String titulo, String txt) {
        // TODO - implement MiembroURJC.crearEntrada
        return new Entrada(titulo,txt,this.getNick());
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

    public String viewSubForo(SubForo subForo){
        return subForo.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MiembroURJC that = (MiembroURJC) o;
        return nick.equals(that.nick);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nick);
    }

    public boolean accepContrasena(String cont) {
        return this.getContrasena().equals(cont);
    }

    public void penalizar(){
        this.penalizacion=new Penalizacion();
    }

    public boolean estaPenalizado(){
        if (this.penalizacion == null){
            return false;
        } else {
            return this.penalizacion.siguePenalizando();
        }
    }

}

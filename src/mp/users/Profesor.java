package mp.users;

import mp.subforos.entradas.contenido.Ejercicio;
import mp.subforos.entradas.contenido.Encuesta;
import mp.subforos.SubForo;

public class Profesor extends MiembroURJC {

    public Profesor(String nombre, String apellidos, String nick, String contrasena, String email) {
        super(nombre, apellidos, nick, contrasena, email);
    }

    /**
     * @param nombre
     * @return
     */
    public SubForo crearSubforo(String nombre) {
        // TODO - implement Profesores.crearSubforo
        return new SubForo(nombre);
    }


}

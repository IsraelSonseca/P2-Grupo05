package mp.users;

import mp.subforos.Ejercicio;
import mp.subforos.Encuesta;
import mp.subforos.SubForo;
import mp.subforos.Texto;

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

    /**
     * Compartir entrada que permite a�adir encuestas y ejercicios
     *
     * @param txt
     * @param enc
     * @param ej
     */
    public void crearEntrada(Texto txt, Encuesta enc, Ejercicio ej) {
        // TODO - implement Profesores.crearEntrada
        throw new UnsupportedOperationException();
    }


}

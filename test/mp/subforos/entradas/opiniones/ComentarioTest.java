package mp.subforos.entradas.opiniones;

import mp.subforos.SubForo;
import mp.subforos.entradas.Entrada;
import mp.users.Alumno;
import mp.users.MiembroURJC;
import org.junit.Test;

import static org.junit.Assert.*;

public class ComentarioTest {

    @Test
    public void getTextoTest() {
        MiembroURJC israel= new Alumno("Isra","Penalver","IsraelSonseca","12345","israelsonseca@gmaial.com");
        Comentario comentario = new Comentario("Hola me llamo Israel",israel);
        assertEquals("Hola me llamo Israel",comentario.getTexto());
    }

    @Test
    public void setTextoTest() {
        MiembroURJC israel= new Alumno("Isra","Penalver","IsraelSonseca","12345","israelsonseca@gmaial.com");
        Comentario comentario = new Comentario("Hola me llamo Israel",israel);
        String nuevoTexto = "Este es el texto modificado";
        comentario.setTexto(nuevoTexto);
        assertEquals(nuevoTexto,comentario.getTexto());
    }

    @Test
    public void testToStringTest() {
        MiembroURJC israel= new Alumno("Isra","Penalver","IsraelSonseca","12345","israelsonseca@gmaial.com");
        Comentario comentario = new Comentario("Hola me llamo Israel",israel);
        String s = "Comentario" + comentario.getId() + ": " + comentario.getUser().getNick() + ": '" + comentario.getTexto() + '\'';
        assertEquals(s,comentario.toString());
    }
}
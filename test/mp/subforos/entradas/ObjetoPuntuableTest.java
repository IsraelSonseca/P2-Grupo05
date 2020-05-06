package mp.subforos.entradas;

import mp.exceptions.Result;
import mp.exceptions.comentario.ComentarioCreado;
import mp.exceptions.comentario.ComentarioYaExistente;
import mp.subforos.entradas.opiniones.Comentario;
import mp.users.Alumno;
import mp.users.MiembroURJC;
import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.*;

public class ObjetoPuntuableTest {

    @Test
    public void getPuntosTest() {
        MiembroURJC isra=new Alumno("a","b","c","12345","a@alumnos.urjc.es");
        int puntos = 10;
        ObjetoPuntuable objeto = new ObjetoPuntuable(puntos,isra);
        assertEquals(puntos,objeto.getPuntos());
    }

    @Test
    public void setPuntosTest() {
        MiembroURJC isra=new Alumno("a","b","c","12345","a@alumnos.urjc.es");
        int puntos = 10;
        ObjetoPuntuable objeto = new ObjetoPuntuable(0,isra);
        objeto.setPuntos(puntos);
        assertEquals(puntos,objeto.getPuntos());
    }

    @Test
    public void getUserTest() {
        MiembroURJC isra=new Alumno("a","b","c","12345","a@alumnos.urjc.es");
        int puntos = 10;
        ObjetoPuntuable objeto = new ObjetoPuntuable(puntos,isra);
        assertEquals(isra,objeto.getUser());
    }

    @Test
    public void getIdTest() {
        MiembroURJC isra=new Alumno("a","b","c","12345","a@alumnos.urjc.es");
        int puntos = 10;
        ObjetoPuntuable objeto1 = new ObjetoPuntuable(puntos,isra);
        ObjetoPuntuable objeto2 = new ObjetoPuntuable(puntos,isra);
        assertEquals(objeto1.getId()+1,objeto2.getId());
    }

    @Test
    public void getComentariosTest() {
        MiembroURJC isra=new Alumno("a","b","c","12345","a@alumnos.urjc.es");
        ObjetoPuntuable objeto1 = new ObjetoPuntuable(0,isra);
        Comentario comen = new Comentario("txtComent",isra);
        try {
            objeto1.addComentario(comen);
        } catch (Result r) {
        }
        assertEquals(1,objeto1.getComentarios().size());
        assertTrue(objeto1.getComentarios().containsValue(comen));
    }

    @Test
    public void setComentariosTest() {
        MiembroURJC isra=new Alumno("a","b","c","12345","a@alumnos.urjc.es");
        ObjetoPuntuable objeto1 = new ObjetoPuntuable(0,isra);
        Comentario comen = new Comentario("txtComent",isra);
        HashMap<Integer, Comentario> comentarios=new HashMap<>();
        comentarios.put(comen.getId(),comen);
        objeto1.setComentarios(comentarios);
        assertEquals(1,objeto1.getComentarios().size());
        assertTrue(objeto1.getComentarios().containsValue(comen));
    }

    @Test
    public void compareToTest() {
    }

    @Test
    public void addComentarioTest() {
        MiembroURJC isra=new Alumno("a","b","c","12345","a@alumnos.urjc.es");
        ObjetoPuntuable objeto1 = new ObjetoPuntuable(0,isra);
        Comentario comen = new Comentario("txtComent",isra);
        assertEquals(0,objeto1.getComentarios().size());
        try {
            objeto1.addComentario(comen);
        } catch (Result r) {
        }
        assertEquals(1,objeto1.getComentarios().size());
        assertTrue(objeto1.getComentarios().containsValue(comen));
    }

    @Test
    public void addValoracionTest() {
    }

    @Test
    public void eliminarTest() {
    }

    @Test
    public void testEqualsTest() {
    }

    @Test
    public void testHashCodeTest() {
    }

    @Test
    public void contieneObjetoPuntuableTest() {
    }

    @Test
    public void devuelveObjetoPuntuableTest() {
    }

    @Test
    public void valorarTest() {
    }

}
package mp.subforos.entradas;

import mp.exceptions.Result;
import mp.exceptions.comentario.ComentarioCreado;
import mp.exceptions.comentario.ComentarioYaExistente;
import mp.exceptions.votaciones.VotacionCreada;
import mp.exceptions.votaciones.VotacionYaExistente;
import mp.subforos.entradas.opiniones.Comentario;
import mp.subforos.entradas.opiniones.EstadoValoracion;
import mp.subforos.entradas.opiniones.Votacion;
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
        MiembroURJC isra=new Alumno("a","b","c","12345","a@alumnos.urjc.es");
        ObjetoPuntuable objeto1 = new ObjetoPuntuable(0,isra);
        ObjetoPuntuable objeto2 = new ObjetoPuntuable(1,isra);
        assertTrue(1==objeto1.compareTo(objeto2));
        assertTrue(-1==objeto2.compareTo(objeto1));
        assertTrue(0==objeto1.compareTo(objeto1));
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
        MiembroURJC isra=new Alumno("a","b","c","12345","a@alumnos.urjc.es");
        ObjetoPuntuable objeto1 = new ObjetoPuntuable(0,isra);
        Votacion votacion = new Votacion(isra, EstadoValoracion.positiva);
        try {
            objeto1.addValoracion(votacion);
        } catch (Result r) {
        }
        assertEquals(1,objeto1.getPuntos());
        Votacion votacionnegativa = new Votacion(isra, EstadoValoracion.negativa);
        try {
            objeto1.addValoracion(votacionnegativa);
        } catch (Result r) {
        }
        assertEquals(-1,objeto1.getPuntos());
    }

    @Test
    public void eliminarTest() {
        MiembroURJC isra=new Alumno("a","b","c","12345","a@alumnos.urjc.es");
        ObjetoPuntuable objeto1 = new ObjetoPuntuable(0,isra);
        int id1 = objeto1.getId();
        objeto1.eliminar();
        ObjetoPuntuable objeto2 = new ObjetoPuntuable(0,isra);
        int id2 = objeto2.getId();
        assertEquals(id1,id2);
    }

    @Test
    public void testEqualsTest() {
        MiembroURJC isra=new Alumno("a","b","c","12345","a@alumnos.urjc.es");
        ObjetoPuntuable objeto1 = new ObjetoPuntuable(0,isra);
        ObjetoPuntuable objeto2 = new ObjetoPuntuable(0,isra);
        assertTrue(objeto1.equals(objeto1));
    }

    @Test
    public void testHashCodeTest() {
        MiembroURJC isra=new Alumno("a","b","c","12345","a@alumnos.urjc.es");
        ObjetoPuntuable objeto1 = new ObjetoPuntuable(0,isra);
        ObjetoPuntuable objeto2 = new ObjetoPuntuable(0,isra);
        assertTrue(objeto1.equals(objeto1));
    }

    @Test
    public void contieneObjetoPuntuableTest() {
        MiembroURJC isra=new Alumno("a","b","c","12345","a@alumnos.urjc.es");
        ObjetoPuntuable objeto1 = new ObjetoPuntuable(0,isra);
        Comentario comen = new Comentario("txtComent",isra);
        assertTrue(false==objeto1.contieneObjetoPuntuable(comen.getId()));
        try {
            objeto1.addComentario( comen);
        } catch (Result r) {
        }
        assertTrue(objeto1.contieneObjetoPuntuable(comen.getId()));
    }

    @Test
    public void devuelveObjetoPuntuableTest() {
        MiembroURJC isra=new Alumno("a","b","c","12345","a@alumnos.urjc.es");
        ObjetoPuntuable objeto1 = new ObjetoPuntuable(0,isra);
        Comentario comen = new Comentario("txtComent",isra);
        try {
            objeto1.addComentario( comen);
        } catch (Result r) {
        }
        ObjetoPuntuable comentDEV = objeto1.devuelveObjetoPuntuable(comen.getId());
        assertTrue(comen.equals(comentDEV));
    }

    @Test
    public void valorarTest() {
        MiembroURJC isra=new Alumno("a","b","c","12345","a@alumnos.urjc.es");
        ObjetoPuntuable objeto1 = new ObjetoPuntuable(0,isra);
        try {
            objeto1.valorar("zxositiva", isra);
        } catch (Result r) {
        }
        assertEquals(0,objeto1.getPuntos());
        try {
            objeto1.valorar("positiva", isra);
        } catch (Result r) {
        }
        assertEquals(1,objeto1.getPuntos());
        try {
            objeto1.valorar("negativa", isra);
        } catch (Result r) {
        }
        assertEquals(-1,objeto1.getPuntos());
    }
}
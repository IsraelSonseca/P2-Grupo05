package mp.subforos.entradas;

import mp.users.Alumno;
import mp.users.MiembroURJC;
import org.junit.Test;

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
    }

    @Test
    public void setComentariosTest() {
    }

    @Test
    public void compareToTest() {
    }

    @Test
    public void addComentarioTest() {
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
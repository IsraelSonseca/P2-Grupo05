package mp.penalizaciones;

import java.util.Date;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ar.cobb.2018
 */
public class PenalizacionTest {

    /**
     * Test of getFechaInicio method, of class Penalizacion.
     */
    @Test
    public void testGetFechaInicio() {
        Date d = new Date(120,5,1,10,10);
        Penalizacion p = new Penalizacion();
        p.setFechaInicio(d);
        assertEquals(d, p.getFechaInicio());  
    }

    /**
     * Test of setFechaInicio method, of class Penalizacion.
     */
    @Test
    public void testSetFechaInicio() {
        Date d = new Date(120,5,1,10,10);
        Penalizacion p = new Penalizacion();
        p.setFechaInicio(d);
        assertEquals(d, p.getFechaInicio());
    }

    /**
     * Test of getFechaFin method, of class Penalizacion.
     */
    @Test
    public void testGetFechaFin() {
        Date d = new Date(121,5,1,10,10);
        Penalizacion p = new Penalizacion();
        p.setFechaFin(d);
        assertEquals(d, p.getFechaFin());
    }

    /**
     * Test of setFechaFin method, of class Penalizacion.
     */
    @Test
    public void testSetFechaFin() {
        Date d = new Date(121,5,1,10,10);
        Penalizacion p = new Penalizacion();
        p.setFechaFin(d);
        assertEquals(d, p.getFechaFin());
    }

    /**
     * Test of siguePenalizando method, of class Penalizacion.
     */
    @Test
    public void testSiguePenalizando() {
        Date d = new Date(121,5,1,10,10);
        Penalizacion p = new Penalizacion();
        p.setFechaFin(d);
        assertTrue(p.siguePenalizando());
    }
    
}
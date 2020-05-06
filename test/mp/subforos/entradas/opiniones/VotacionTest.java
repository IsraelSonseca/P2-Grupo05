package mp.subforos.entradas.opiniones;


import mp.users.MiembroURJC;
import org.junit.Test;

import static org.junit.Assert.*;

public class VotacionTest {

    @Test
    public void getUserTest() {
       EstadoValoracion estadoValoracion = null;
       estadoValoracion = estadoValoracion.positiva;
       MiembroURJC usuario = new MiembroURJC("Allan","Cobb","Nick","123","unemail@urjc.es"); 
       MiembroURJC usuario2 = new MiembroURJC("OtroNombre","OtroApellido","name","321","Otroemail@urjc.es");
       Votacion v = new Votacion(usuario, estadoValoracion);
       v.setUser(usuario2);
       assertEquals(usuario2, v.getUser());
    }

    @Test
    public void setUserTest() {
       EstadoValoracion estadoValoracion = null;
       estadoValoracion = estadoValoracion.positiva;
       MiembroURJC usuario = new MiembroURJC("Allan","Cobb","Nick","123","unemail@urjc.es"); 
       MiembroURJC usuario2 = new MiembroURJC("OtroNombre","OtroApellido","name","321","Otroemail@urjc.es");
       Votacion v = new Votacion(usuario, estadoValoracion);
       v.setUser(usuario2);
       assertEquals(usuario2, v.getUser());
    }

    @Test
    public void getEstadoTest() {
       EstadoValoracion estadoValoracion = null;
       estadoValoracion = estadoValoracion.positiva;
       EstadoValoracion estadoValoracion2 = null;
       estadoValoracion = estadoValoracion2.negativa;
       MiembroURJC usuario = new MiembroURJC("Allan","Cobb","Nick","123","unemail@urjc.es"); 
       Votacion v = new Votacion(usuario, estadoValoracion);
       v.setEstado(estadoValoracion2);
       assertEquals(estadoValoracion2, v.getEstado());
        
    }

    @Test
    public void setEstadoTest() {
       EstadoValoracion estadoValoracion = null;
       estadoValoracion = estadoValoracion.positiva;
       EstadoValoracion estadoValoracion2 = null;
       estadoValoracion = estadoValoracion2.negativa;
       MiembroURJC usuario = new MiembroURJC("Allan","Cobb","Nick","123","unemail@urjc.es"); 
       Votacion v = new Votacion(usuario, estadoValoracion);
       v.setEstado(estadoValoracion2);
       assertEquals(estadoValoracion2, v.getEstado());
    }

    @Test
    public void testEqualsTest() {
        MiembroURJC usuario = new MiembroURJC("Allan","Cobb","Nick","123","unemail@urjc.es");
        EstadoValoracion estadoValoracion = null;
        estadoValoracion = estadoValoracion.positiva;
        Votacion v = new Votacion(usuario, estadoValoracion);
        Votacion v2 = new Votacion(usuario, estadoValoracion);
        assertTrue(v.equals(v2));   
        
    }

    @Test
    public void testHashCodeTest() {
        MiembroURJC usuario = new MiembroURJC("Allan","Cobb","Nick","123","unemail@urjc.es");
        MiembroURJC usuario2 = new MiembroURJC("Allan","Cobb","Nick","123","unemail@urjc.es");
        assertEquals(usuario.hashCode(),usuario2.hashCode());
        
    }
}
package mp.users;

import mp.penalizaciones.Penalizacion;
import org.junit.Test;

import static org.junit.Assert.*;

public class MiembroURJCTest {

    @Test
    public void getIdTest() {
        MiembroURJC usuario = new MiembroURJC("nombre","apellido","Nick","123","unemail@urjc.es");
        int k = usuario.getId();
        MiembroURJC usuario2 = new MiembroURJC("nombre2","apellido2","Nick2","1232","unemail@urjc.es");
        int i = usuario2.getId();
        assertEquals(k+1,i); /**Por cada usuario añadido, se suma uno al id, aunque también sirve si no son iguales**/       
    }

    @Test
    public void getNombreTest() {
        String s = "Allan";
        String s2 = "Otro";
        MiembroURJC usuario = new MiembroURJC(s,"Cobb","Nick","123","unemail@urjc.es");
        usuario.setNombre(s2);
        assertEquals(s2,usuario.getNombre());
    }

    @Test
    public void setNombreTest() {
        String s = "Allan";
        String s2 = "Otro";
        MiembroURJC usuario = new MiembroURJC(s,"Cobb","Nick","123","unemail@urjc.es");
        usuario.setNombre(s2);
        assertEquals(s2,usuario.getNombre());
    }

    @Test
    public void getApellidosTest() {
        String s = "Cobb";
        String s2 = "Otro";
        MiembroURJC usuario = new MiembroURJC("Allan",s,"Nick","123","unemail@urjc.es");
        usuario.setApellidos(s2);
        assertEquals(s2,usuario.getApellidos());
    }

    @Test
    public void setApellidosTest() {
        String s = "Cobb";
        String s2 = "Otro";
        MiembroURJC usuario = new MiembroURJC("Allan",s,"Nick","123","unemail@urjc.es");
        usuario.setApellidos(s2);
        assertEquals(s2,usuario.getApellidos());
    }

    @Test
    public void getNickTest() {
        String s = "nickname";
        String s2 = "Otro";
        MiembroURJC usuario = new MiembroURJC("Allan","Cobb",s,"123","unemail@urjc.es");
        usuario.setNick(s2);
        assertEquals(s2,usuario.getNick());
    }

    @Test
    public void setNickTest() {
        String s = "nickname";
        String s2 = "Otro";
        MiembroURJC usuario = new MiembroURJC("Allan","Cobb",s,"123","unemail@urjc.es");
        usuario.setNick(s2);
        assertEquals(s2,usuario.getNick());
    }

    @Test
    public void getEmailTest() {
        String s = "unemail@urjc.es";
        String s2 = "Otro";
        MiembroURJC usuario = new MiembroURJC("Allan","Cobb","nick","123",s);
        usuario.setEmail(s2);
        assertEquals(s2,usuario.getEmail());
    }

    @Test
    public void setEmailTest() {
        String s = "unemail@urjc.es";
        String s2 = "Otro";
        MiembroURJC usuario = new MiembroURJC("Allan","Cobb","nick","123",s);
        usuario.setEmail(s2);
        assertEquals(s2,usuario.getEmail());
    }

    @Test
    public void getPenalizacionTest() {
        Penalizacion p = new Penalizacion();
        MiembroURJC usuario = new MiembroURJC("Allan","Cobb","nick","123","unemail@urjc.es");
        usuario.setPenalizacion(p);
        assertEquals(p, usuario.getPenalizacion());
               
    }

    @Test
    public void setPenalizacionTest() {
        Penalizacion p = new Penalizacion();
        MiembroURJC usuario = new MiembroURJC("Allan","Cobb","nick","123","unemail@urjc.es");
        usuario.setPenalizacion(p);
        assertEquals(p, usuario.getPenalizacion());
    }

    @Test
    public void eliminarTest() {
        
        MiembroURJC usuario = new MiembroURJC("Allan","Cobb","Nick","123","unemail@urjc.es");
        int i = usuario.getId();
        usuario.eliminar();
        MiembroURJC usuario2 = new MiembroURJC("Alla2n","Cobb2","Nick2","123","unemail@urjc.es");
        int k = usuario2.getId();
        assertEquals(i,k); /**Si los dos usuarios tienen la misma ID, 
                              significa que uno de ellos (usuario) se ha eliminado y sustituido por otro (usuario2)**/       
    }

    @Test
    public void testEqualsTest() {
        MiembroURJC usuario = new MiembroURJC("Allan","Cobb","Nickname","123","unemail@urjc.es");
        MiembroURJC usuario2 = new MiembroURJC("Allan","Cobb","Nickname","123","unemail@urjc.es");
        assertTrue(usuario.equals(usuario2)); 
    }

    @Test
    public void testHashCodeTest() {
       MiembroURJC usuario = new MiembroURJC("Allan","Cobb","Nickname","123","unemail@urjc.es");
       MiembroURJC usuario2 = new MiembroURJC("Allan","Cobb","Nickname","123","unemail@urjc.es"); 
       assertEquals (usuario.hashCode(),usuario2.hashCode());
    }

    @Test
    public void accepContrasenaTest() {
        MiembroURJC usuario = new MiembroURJC("Allan","Cobb","Nickname","123","unemail@urjc.es");
        assertTrue(usuario.accepContrasena("123"));
    }

    @Test
    public void penalizarTest() {
        MiembroURJC usuario = new MiembroURJC("Allan","Cobb","Nickname","123","unemail@urjc.es");
        usuario.penalizar();
        Penalizacion p1 = usuario.getPenalizacion();
        assertEquals(p1.getFechaInicio().getTime(),p1.getFechaFin().getTime() - 172800000); /**Vemos si añade 2 días a la fecha fin respecto a la fecha ini**/
        
    }

    @Test
    public void estaPenalizadoTest() {
        MiembroURJC usuario = new MiembroURJC("Allan","Cobb","Nickname","123","unemail@urjc.es");
        usuario.penalizar();
        assertTrue(usuario.estaPenalizado());
        Penalizacion p = usuario.getPenalizacion();
        assertTrue(p.siguePenalizando());
        usuario.despenalizarUsuario();
        p = usuario.getPenalizacion();
        //assertFalse(p.siguePenalizando());
        assertNull(usuario.getPenalizacion()); /** Hay problemas con este metodo. Si se quita la penalizacion,
                                                *  no se puede llamar a esta funcion al dar error java.lang.NullPointerException, es decir,
                                                * si se elimina la penalizacion, no se puede comprobar si sigue penalizado (a través de este método)**/
    }

    @Test
    public void despenalizarUsuarioTest() {
        MiembroURJC usuario = new MiembroURJC("Allan","Cobb","Nickname","123","unemail@urjc.es");
        usuario.penalizar();
        Penalizacion p1 = usuario.getPenalizacion();
        usuario.despenalizarUsuario();
        Penalizacion p2 = usuario.getPenalizacion();
        assertNotSame(p1,p2);
        assertNull(p2);       /** Vemos que se crea la penalizacion (no es lo mismo p1 y p2) y vemos que p2 es vacia (el usuario ha sido despenalizado)**/
    }

    @Test
    public void recibirNotificacionTest() {
        Notificacion n = new Notificacion("Le ha llegado una notificacion de este subforo");
        Notificacion n2 = new Notificacion("Le ha llegado otra notificacion de este subforo");
        MiembroURJC usuario = new MiembroURJC("Allan","Cobb","Nickname","123","unemail@urjc.es");
        usuario.recibirNotificacion(n);
        int k = usuario.getNumNotificaciones();
        usuario.recibirNotificacion(n2);
        int i = usuario.getNumNotificaciones();
        assertEquals(i,k+1); /** Vemos si se han añadido el numero correcto de notificaciones**/
        assertEquals(i,2);
        assertEquals(k,1);
         
    }

    @Test
    public void getNumNotificacionesTest() {
        Notificacion n = new Notificacion("Le ha llegado una notificacion de este subforo");
        MiembroURJC usuario = new MiembroURJC("Allan","Cobb","Nickname","123","unemail@urjc.es");
        usuario.recibirNotificacion(n);
        assertEquals(usuario.getNumNotificaciones(),1); /** Solo se ha añadido una notificacion, asique la lista tiene que tener de longitud 1**/
    }

    @Test
    public void toStringTest() { 
        MiembroURJC usuario = new MiembroURJC("Allan","Cobb","Nickname","123","unemail@urjc.es");
        String s = "Nombre='" + usuario.getNombre() + '\'' +
                ", apellidos='" + usuario.getApellidos() + '\'' +
                ", nick='" + usuario.getNick() + '\'' +
                ", email='" + usuario.getEmail() + '\'';
        
        assertEquals(s,usuario.toString());
        
    }
}
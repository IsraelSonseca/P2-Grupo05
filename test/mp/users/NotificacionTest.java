package mp.users;

import org.junit.Test;

import static org.junit.Assert.*;

public class NotificacionTest {

    @Test
    public void testToStringTest() {
        String s = "Hay una nueva entrada en este subforo";
        Notificacion n = new Notificacion(s);
        assertEquals(s,n.toString());
        
    }
}
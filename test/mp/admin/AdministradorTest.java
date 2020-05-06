package mp.admin;

import mp.exceptions.Result;
import mp.exceptions.logIn.AdminIncorrectPassword;
import mp.exceptions.logIn.AdminLogedCorrect;
import mp.exceptions.logIn.AdminWasLoged;
import mp.exceptions.logOut.AdminCierreSesion;
import mp.exceptions.logOut.AdminSesionNoIniciada;
import mp.subforos.SubForo;
import mp.subforos.entradas.Entrada;
import mp.subforos.entradas.EntradaGenerica;
import mp.users.Alumno;
import mp.users.MiembroURJC;
import org.junit.Test;

import java.util.LinkedList;

import static org.junit.Assert.*;

public class AdministradorTest {

    @Test
    public void anadirEntAValidarTest() {
        SubForo subforo = new SubForo("Metodologia de la programacion");
        MiembroURJC israel= new Alumno("Isra","Peñalver","IsraelSonseca","12345","israelsonseca@gmaial.com");
        Entrada entrada = new Entrada("titulo","texto",israel,subforo);
        Administrador admin = new Administrador();
        admin.anadirEntAValidar(entrada);
        assertEquals(admin.getEntradasAValidar().size(),1);
    }

    @Test
    public void isLoguedTest() {
        Administrador admin = new Administrador();
        try {
            admin.logIn("11111");
        } catch (Result r) {
        }
        assertTrue(admin.isLogued());
    }

    @Test
    public void logInTest() {
        Administrador admin = new Administrador();
        try {
            admin.logIn("11111");
        } catch (Result r) {
        }
        assertTrue(admin.isLogued());
    }

    @Test
    public void logOutTest() {
        Administrador admin = new Administrador();
        try {
            admin.logIn("11111");
        } catch (Result r) {
        }
        try {
            admin.logOut();
        } catch (Result r) {
        }
        assertFalse(admin.isLogued());
    }

}
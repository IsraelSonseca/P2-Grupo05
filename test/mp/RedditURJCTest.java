package mp;

import mp.exceptions.Result;
import mp.exceptions.logIn.AdminIncorrectPassword;
import mp.exceptions.logIn.AdminLogedCorrect;
import mp.exceptions.logIn.AdminWasLoged;
import mp.exceptions.resgister.EmailIncorrecto;
import mp.exceptions.resgister.EmailPreviamenteRegistrado;
import mp.exceptions.resgister.NickYaExistente;
import mp.exceptions.resgister.RegistroCorrecto;
import org.junit.Test;

import static org.junit.Assert.*;

public class RedditURJCTest {

    @Test
    public void getInstanceTest() {
        assertTrue(RedditURJC.getInstance() instanceof  mp.RedditURJC);
    }

    @Test
    public void destroyTest() {
        RedditURJC sistema = RedditURJC.getInstance();
        sistema.destroy();
        assertTrue(sistema.getInstancia()==null);
    }

    @Test
    public void loginAdminTest() {
        RedditURJC sistema = RedditURJC.getInstance();
        try {
            sistema.loginAdmin("11111");
        } catch (Result r) {
        }
        assertTrue(sistema.getAdmin().isLogued()==true);
    }

    @Test
    public void logoutAdminTest() {
        RedditURJC sistema = RedditURJC.getInstance();
        try {
            sistema.logoutAdmin();
        } catch (Result r) {
        }
        assertTrue(sistema.getAdmin().isLogued()==false);
        sistema.destroy();
    }

    @Test
    public void loginTest() {
        RedditURJC sistema = RedditURJC.getInstance();
        try {
            sistema.registrarUsuario("name","name","abc","1","abc@alumnos.urjc.es");
        } catch (Result r) {
        }
        try {
            sistema.login("abc","1");
        } catch (Result r) {
        }
        assertTrue(sistema.getUserLogued()!=null);
        sistema.destroy();
    }

    @Test
    public void logoutTest() {
        RedditURJC sistema = RedditURJC.getInstance();
        try {
            sistema.registrarUsuario("name","name","abc","1","abc@alumnos.urjc.es");
        } catch (Result r) {
        }
        try {
            sistema.login("abc","1");
        } catch (Result r) {
        }
        assertTrue(sistema.getUserLogued()!=null);
        try {
            sistema.logout();
        } catch (Result r) {
        }
        assertTrue(sistema.getUserLogued()==null);
        sistema.destroy();
    }

    @Test
    public void registrarUsuarioTest() {
        RedditURJC sistema = RedditURJC.getInstance();
        int n = sistema.getUsuarios().size();
        try {
            sistema.registrarUsuario("name","name","abcd","1","abcd@alumnos.urjc.es");
        } catch (Result r) {
            r.getMessage();
        }
        assertTrue(sistema.getUsuarios().size()== n + 1);
    }
}
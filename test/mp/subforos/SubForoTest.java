package mp.subforos;

import mp.exceptions.Result;
import mp.exceptions.crearEntrada.EntradaCreada;
import mp.exceptions.crearEntrada.EntradaYaExistente;
import mp.exceptions.suscripciones.NoSucritoAlForo;
import mp.exceptions.suscripciones.SuscripcionActivada;
import mp.exceptions.suscripciones.SuscriptorYaExistente;
import mp.exceptions.suscripciones.UsuarioDadoDeBaja;
import mp.subforos.entradas.Entrada;
import mp.users.Alumno;
import mp.users.MiembroURJC;
import mp.users.Notificacion;
import mp.users.Subscriptor;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.Assert.*;

public class SubForoTest {

    @Test
    public void getNombreTest() {
        SubForo subforo = new SubForo("Metodologia de la programacion");
        assertEquals(subforo.getNombre(), "Metodologia de la programacion");

    }

    @Test
    public void setNombreTest() {
        SubForo subforo = new SubForo("Metodologia de la programacion");
        subforo.setNombre("Nombre Modificado");
        assertEquals(subforo.getNombre(),"Nombre Modificado");

    }

    @Test
    public void getIdTest() {
        SubForo subforo = new SubForo("Metodologia de la programacion");
        subforo.setId(3);
        assertEquals(subforo.getId(),3);

    }

    @Test
    public void setIdTest() {
        SubForo subforo = new SubForo("Metodologia de la programacion");
        subforo.setId(4);
        assertEquals(subforo.getId(),4);
    }

    @Test
    public void getEntradasTest() {
        SubForo subforo = new SubForo("Metodologia de la programacion");
        MiembroURJC israel= new Alumno("Isra","Penalver","IsraelSonseca","12345","israelsonseca@gmaial.com");
        Entrada entrada = new Entrada("titulo","texto",israel,subforo);
        try {
            subforo.addEntrada(entrada);
        } catch (Result r) {
        }
        HashMap<Integer, Entrada> entradas = subforo.getEntradas();
        assertEquals(entradas.values().size(),1);
    }

    @Test
    public void setEntradasTest() {
        SubForo subforo = new SubForo("Metodologia de la programacion");
        MiembroURJC israel= new Alumno("Isra","Penalver","IsraelSonseca","12345","israelsonseca@gmaial.com");
        Entrada entrada = new Entrada("titulo","texto",israel,subforo);
        try {
            subforo.addEntrada(entrada);
        } catch (Result r) {
        }
        HashMap<Integer, Entrada> entradas = subforo.getEntradas();
        Entrada entradamodificada = new Entrada("titulo modificado","texto",israel,subforo);
        HashMap<Integer, Entrada> entradasModificadas = new HashMap<>();
        entradasModificadas.put(1,entradamodificada);
        subforo.setEntradas(entradasModificadas);
        assertEquals(subforo.getEntradas(),entradasModificadas);
    }

    @Test
    public void getSuscriptoresTest() {
        SubForo subforo = new SubForo("Metodologia de la programacion");
        MiembroURJC israel= new Alumno("Isra","Penalver","IsraelSonseca","12345","israelsonseca@gmaial.com");
        try {
            subforo.anadirSubscriptor(israel);
        } catch (Result r) {
        }
        ArrayList<Subscriptor> suscriptores = subforo.getSuscriptores();
        assertEquals(suscriptores.get(0),israel);

    }

    @Test
    public void testEqualsTest() {
        SubForo subforo = new SubForo("Metodologia de la programacion");
        boolean a = subforo.equals(subforo);
        assertEquals(a, true);
    }

    @Test
    public void testHashCodeTest() {
        SubForo subforo = new SubForo("Metodologia de la programacion");
        int a = subforo.hashCode();
        assertEquals(a,subforo.hashCode());
    }

    @Test
    public void addEntradaTest() {
        SubForo subforo = new SubForo("Metodologia de la programacion");
        MiembroURJC israel= new Alumno("Isra","Penalver","IsraelSonseca","12345","israelsonseca@gmaial.com");
        Entrada entrada = new Entrada("titulo","texto",israel,subforo);
        SubForo subforo2 = new SubForo("Suboforo Modificado");
        try {
            subforo2.addEntrada(entrada);
        } catch (Result r) {
        }
        HashMap<Integer, Entrada> entradas = subforo2.getEntradas();
        entradas.values();


    }

    @Test
    public void eliminarTest() {
        SubForo subforo = new SubForo("Metodologia de la programacion");
        int i = subforo.getId();
        subforo.eliminar();
        SubForo subforo2 = new SubForo("Otra asignatura");
        int k = subforo2.getId();
        assertEquals(i, k);
    }

    @Test
    public void testToStringTest() {
        SubForo subforo = new SubForo("Metodologia de la programacion");
        int i = subforo.getId();
        String a = "SubForo " + i + " => Metodologia de la programacion";
        assertEquals(subforo.toString(),a);
    }

    @Test
    public void anadirSubscriptorTest() {
        MiembroURJC israel= new Alumno("Isra","Penalver","IsraelSonseca","12345","israelsonseca@gmaial.com");
        SubForo subforo = new SubForo("Metodologia de la programacion");
        try {
            subforo.anadirSubscriptor(israel);
        } catch (Result r) {
        }
        ArrayList<Subscriptor> suscriptores = subforo.getSuscriptores();
        assertEquals(suscriptores.size(),1);
    }

    @Test
    public void quitarSuscriptorTest() {
        MiembroURJC israel= new Alumno("Isra","Penalver","IsraelSonseca","12345","israelsonseca@gmaial.com");
        SubForo subforo = new SubForo("Metodologia de la programacion");
        try {
            subforo.anadirSubscriptor(israel);
        } catch (Result r) {
        }
        try {
            subforo.quitarSuscriptor(israel);
        } catch (Result r) {
        }
        ArrayList<Subscriptor> suscriptores = subforo.getSuscriptores();
        assertEquals(suscriptores.size(),0);
    }

    @Test
    public void generateNotificacionTest() {
        SubForo subforo = new SubForo("Metodologia de la programacion");
        MiembroURJC israel= new Alumno("Isra","Penalver","IsraelSonseca","12345","israelsonseca@gmaial.com");
        Entrada entrada = new Entrada("titulo","texto",israel,subforo);
        Notificacion not = subforo.generateNotificacion(entrada);
        ArrayList<Notificacion> notificaciones = new ArrayList<>();
        notificaciones.add(not);
        assertEquals(notificaciones.size(), 1);
    }
}
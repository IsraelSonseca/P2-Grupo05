package mp.subforos.entradas;

import mp.subforos.SubForo;
import mp.subforos.entradas.opiniones.Comentario;
import mp.users.Alumno;
import mp.users.MiembroURJC;
import org.junit.Test;

import static mp.subforos.entradas.EstadoEntrada.creada;
import static mp.subforos.entradas.EstadoEntrada.validada;
import static org.junit.Assert.*;

public class EntradaGenericaTest {

    @Test
    public void getTituloTest() {
        MiembroURJC israel= new Alumno("Isra","Penalver","IsraelSonseca","12345","israelsonseca@gmaial.com");
        SubForo foro = new SubForo("AsignaturaMP");
        Entrada entrada = new Entrada("Entrada para probar la genérica","Esta es una entrada para probar si funciona la entrada genérica",israel,foro);
        assertEquals("Entrada para probar la genérica",entrada.getTitulo());
    }

    @Test
    public void setTituloTest() {
            MiembroURJC israel= new Alumno("Isra","Penalver","IsraelSonseca","12345","israelsonseca@gmaial.com");
            SubForo foro = new SubForo("AsignaturaMP");
            Entrada entrada = new Entrada("Entrada para probar la genérica","Esta es una entrada para probar si funciona la entrada genérica",israel,foro);
            entrada.setTitulo("Este es el titulo nuevo para la entrada");
            assertEquals("Este es el titulo nuevo para la entrada",entrada.getTitulo());
    }

    @Test
    public void getTextoTest() {
        MiembroURJC israel= new Alumno("Isra","Penalver","IsraelSonseca","12345","israelsonseca@gmaial.com");
        SubForo foro = new SubForo("AsignaturaMP");
        Entrada entrada = new Entrada("Entrada para probar la genérica","Esta es una entrada para probar si funciona la entrada genérica",israel,foro);
        assertEquals("Esta es una entrada para probar si funciona la entrada genérica",entrada.getTexto());
    }

    @Test
    public void setTextoTest() {
        MiembroURJC israel= new Alumno("Isra","Penalver","IsraelSonseca","12345","israelsonseca@gmaial.com");
        SubForo foro = new SubForo("AsignaturaMP");
        Entrada entrada = new Entrada("Entrada para probar la genérica","Esta es una entrada para probar si funciona la entrada genérica",israel,foro);
        entrada.setTexto("Nuevo texto para la entrada");
        assertEquals("Nuevo texto para la entrada",entrada.getTexto());
    }

    @Test
    public void getEstadoTest() {
        MiembroURJC israel= new Alumno("Isra","Penalver","IsraelSonseca","12345","israelsonseca@gmaial.com");
        SubForo foro = new SubForo("AsignaturaMP");
        Entrada entrada = new Entrada("Entrada para probar la genérica","Esta es una entrada para probar si funciona la entrada genérica",israel,foro);
        entrada.setEstado(creada);
        assertEquals(creada,entrada.getEstado());
    }

    @Test
    public void setEstadoTest() {
        MiembroURJC israel= new Alumno("Isra","Penalver","IsraelSonseca","12345","israelsonseca@gmaial.com");
        SubForo foro = new SubForo("AsignaturaMP");
        Entrada entrada = new Entrada("Entrada para probar la genérica","Esta es una entrada para probar si funciona la entrada genérica",israel,foro);
        entrada.setEstado(validada);
        assertEquals(validada,entrada.getEstado());
    }

    @Test
    public void getEntradaRaizTest() {
        MiembroURJC israel= new Alumno("Isra","Penalver","IsraelSonseca","12345","israelsonseca@gmaial.com");
        SubForo foro = new SubForo("AsignaturaMP");
        Entrada entradaraiz = new Entrada("Entrada para probar la genérica","Esta es una entrada para probar si funciona la entrada genérica",israel,foro);
        assertEquals(entradaraiz,entradaraiz.getEntradaRaiz());
    }

    @Test
    public void validarTest() {
        MiembroURJC israel= new Alumno("Isra","Penalver","IsraelSonseca","12345","israelsonseca@gmaial.com");
        SubForo foro = new SubForo("AsignaturaMP");
        Entrada entrada = new Entrada("Entrada para probar la genérica","Esta es una entrada para probar si funciona la entrada genérica",israel,foro);
        entrada.setEstado(validada);
        assertEquals(validada,entrada.getEstado());
    }

    @Test
    public void rechazarTest() {
        MiembroURJC israel= new Alumno("Isra","Penalver","IsraelSonseca","12345","israelsonseca@gmaial.com");
        SubForo foro = new SubForo("AsignaturaMP");
        Entrada entrada = new Entrada("Entrada para probar la genérica","Esta es una entrada para probar si funciona la entrada genérica",israel,foro);
        entrada.setEstado(validada);
        assertEquals(validada,entrada.getEstado());

    }

    @Test
    public void msgNotificacionTest() {
        MiembroURJC israel= new Alumno("Isra","Penalver","IsraelSonseca","12345","israelsonseca@gmaial.com");
        SubForo foro = new SubForo("AsignaturaMP");
        Entrada entrada = new Entrada("Entrada para probar la genérica","Esta es una entrada para probar si funciona la entrada genérica",israel,foro);
        String comparacion = "Nuevo "+entrada.getClass()+": " + entrada.getTitulo();
        assertEquals(comparacion,entrada.msgNotificacion());
    }
}
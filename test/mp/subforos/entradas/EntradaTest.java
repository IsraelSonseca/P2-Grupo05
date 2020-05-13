package mp.subforos.entradas;

import mp.exceptions.crearEntrada.NuevoContenidoNoContemplado;
import mp.subforos.SubForo;
import mp.subforos.entradas.contenido.TextoPlano;
import mp.users.Alumno;
import mp.users.MiembroURJC;
import org.junit.Test;

import static org.junit.Assert.*;

public class EntradaTest {

    @Test
    public void getSubforoTest() {
        MiembroURJC israel= new Alumno("Isra","Penalver","IsraelSonseca","12345","israelsonseca@gmaial.com");
        SubForo foro = new SubForo("AsignaturaMP");
        Entrada entrada = new Entrada("titulo","texto",israel,foro);
        assertEquals(foro,entrada.getSubforo());
    }

    @Test
    public void setSubforoTest() {
        MiembroURJC israel= new Alumno("Isra","Penalver","IsraelSonseca","12345","israelsonseca@gmaial.com");
        SubForo foro = new SubForo("AsignaturaMP");
        Entrada entrada = new Entrada("titulo","texto",israel,foro);
        SubForo foroModificado = new SubForo("AsignaturaMPmODIFICACION");
        entrada.setSubforo(foroModificado);
        assertEquals(foroModificado,entrada.getSubforo());
    }

    @Test
    public void anadirElementoTest() {
        MiembroURJC israel= new Alumno("Isra","Penalver","IsraelSonseca","12345","israelsonseca@gmaial.com");
        SubForo foro = new SubForo("AsignaturaMP");
        Entrada entrada = new Entrada("titulo","texto",israel,foro);
        EntradaGenerica txt = new TextoPlano("tituloTXTPlano","textoTXTPlano",israel,entrada);
        try {
            EntradaGenerica nuevoContenido = entrada.anadirElemento("tituloTXTPlano","textoTXTPlano","TextoPlano");
        } catch (NuevoContenidoNoContemplado nuevoContenidoNoContemplado) {
            nuevoContenidoNoContemplado.printStackTrace();
        }
        assertTrue(entrada.getContenido().size()==1);
    }

    @Test
    public void testToStringTest() {
        MiembroURJC israel= new Alumno("Isra","Penalver","IsraelSonseca","12345","israelsonseca@gmaial.com");
        SubForo foro = new SubForo("AsignaturaMP");
        Entrada entrada = new Entrada("titulo","texto",israel,foro);
        String s = "Entrada" + entrada.getId() + " " + entrada.getUser().getNick() + " => TÍTULO: '" + entrada.getTitulo() + '\'' + ", TEXTO: '" + entrada.getTexto() + '\'';
        assertEquals(s,entrada.toString());
    }



}
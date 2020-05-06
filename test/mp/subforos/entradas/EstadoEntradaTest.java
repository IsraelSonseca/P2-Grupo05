package mp.subforos.entradas;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class EstadoEntradaTest {

    @Test
    public void valuesTest() {
        EstadoEntrada[] valores = EstadoEntrada.values();
        assertTrue(valores.length==3);
        EstadoEntrada[] valoresEsperados = new EstadoEntrada[3];
        valoresEsperados[0]=EstadoEntrada.creada;
        valoresEsperados[1]=EstadoEntrada.validada;
        valoresEsperados[2]=EstadoEntrada.rechazada;
        assertArrayEquals(valoresEsperados,valores);
    }

    @Test
    public void valueOfTest() {
        EstadoEntrada creada = EstadoEntrada.valueOf("creada");
        assertEquals(creada,EstadoEntrada.creada);
        EstadoEntrada validada = EstadoEntrada.valueOf("validada");
        assertEquals(validada,EstadoEntrada.validada);
        EstadoEntrada rechazada = EstadoEntrada.valueOf("rechazada");
        assertEquals(rechazada,EstadoEntrada.rechazada);
    }
}
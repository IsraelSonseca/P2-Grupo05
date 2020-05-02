package mp.subforos.entradas.opiniones;

import mp.subforos.entradas.EstadoEntrada;
import org.junit.Test;

import static org.junit.Assert.*;

public class EstadoValoracionTest {

    @Test
    public void valuesTest() {
        EstadoValoracion[] valores = EstadoValoracion.values();
        assertTrue(valores.length==2);
        EstadoValoracion[] valoresEsperados = new EstadoValoracion[2];
        valoresEsperados[0]=EstadoValoracion.positiva;
        valoresEsperados[1]=EstadoValoracion.negativa;
        assertArrayEquals(valoresEsperados,valores);
    }

    @Test
    public void valueOfTest() {
        EstadoValoracion creada = EstadoValoracion.valueOf("positiva");
        assertEquals(creada,EstadoValoracion.positiva);
        EstadoValoracion validada = EstadoValoracion.valueOf("negativa");
        assertEquals(validada,EstadoValoracion.negativa);
    }

}
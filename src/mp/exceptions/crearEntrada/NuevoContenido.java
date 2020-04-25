package mp.exceptions.crearEntrada;

import mp.exceptions.Result;
import mp.subforos.Entrada;
import mp.subforos.EntradaGenerica;

public class NuevoContenido extends Result {
    public NuevoContenido(EntradaGenerica entrada, EntradaGenerica nuevo) {
        super("Nuevo contenido: "+nuevo.toString()+" añadido correctamente a la entrada: "+entrada.getId()+" "+entrada.getTitulo()+"NUEVO");
    }
}

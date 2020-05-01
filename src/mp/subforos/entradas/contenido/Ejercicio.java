package mp.subforos.entradas.contenido;

import mp.subforos.entradas.Entrada;
import mp.subforos.entradas.EntradaGenerica;
import mp.users.MiembroURJC;

public class Ejercicio extends EntradaGenerica {
    public Ejercicio(String titulo, String texto, MiembroURJC user, Entrada raiz) {
        super(titulo, texto, user,raiz);
    }
}
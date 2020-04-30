package mp.subforos;

import mp.exceptions.suscripciones.NoSucritoAlForo;
import mp.exceptions.suscripciones.SuscripcionActivada;
import mp.exceptions.suscripciones.SuscriptorYaExistente;
import mp.exceptions.suscripciones.UsuarioDadoDeBaja;
import mp.subforos.entradas.EntradaGenerica;
import mp.users.MiembroURJC;
import mp.users.Subscriptor;

import java.util.ArrayList;

public interface Subject {
    ArrayList<Subscriptor> subscriptors = new ArrayList<Subscriptor>();

    void anadirSubscriptor(MiembroURJC user) throws SuscriptorYaExistente, SuscripcionActivada;

    void quitarSuscriptor(MiembroURJC user) throws UsuarioDadoDeBaja, NoSucritoAlForo;

    void notificar(EntradaGenerica entrada);
}

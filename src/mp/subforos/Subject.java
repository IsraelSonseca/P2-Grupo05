package mp.subforos;

import mp.exceptions.suscripciones.SuscripcionActivada;
import mp.exceptions.suscripciones.SuscriptorYaExistente;
import mp.users.MiembroURJC;
import mp.users.Subscriptor;

import java.util.ArrayList;

public interface Subject {
    ArrayList<Subscriptor> subscriptores = new ArrayList<Subscriptor>();

    void anadirSubscriptor(MiembroURJC user) throws SuscriptorYaExistente, SuscripcionActivada;

    void eliminarSubscriptor(MiembroURJC user);

    void notificar(Entrada entrada);
}

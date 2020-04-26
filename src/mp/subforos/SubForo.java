package mp.subforos;

import mp.exceptions.crearEntrada.EntradaCreada;
import mp.exceptions.crearEntrada.EntradaYaExistente;
import mp.exceptions.suscripciones.NoSucritoAlForo;
import mp.exceptions.suscripciones.SuscripcionActivada;
import mp.exceptions.suscripciones.SuscriptorYaExistente;
import mp.exceptions.suscripciones.UsuarioDadoDeBaja;
import mp.users.MiembroURJC;
import mp.users.Notificacion;
import mp.users.Subscriptor;

import java.io.Serializable;
import java.util.*;

public class SubForo implements Subject, Serializable {

    private static final long serialVersionUID = 1L;
    private static int contador = 0;
    private final ArrayList<Subscriptor> subscriptors;
    private int id;
    private String nombre;
    private HashMap<Integer, Entrada> entradas;


    public SubForo(String nombre) {
        contador++;
        this.nombre = nombre;
        this.id = contador;
        this.entradas = new HashMap<>();
        this.subscriptors = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public HashMap<Integer, Entrada> getEntradas() {
        return entradas;
    }

    public void setEntradas(HashMap<Integer, Entrada> entradas) {
        this.entradas = entradas;
    }

    public ArrayList<Subscriptor> getSuscriptores() {
        return this.subscriptors;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SubForo subForo = (SubForo) o;
        return nombre.equals(subForo.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre);
    }

    public void addEntrada(Entrada entrada) throws EntradaYaExistente, EntradaCreada {
        if (!entradas.containsValue(entrada)) {
            this.entradas.put(entrada.getId(), entrada);
            throw new EntradaCreada(entrada, this);
        } else {
            entrada.eliminar();
            throw new EntradaYaExistente(entrada);
        }
    }

    public void eliminar() {
        contador--;
    }

    @Override
    public String toString() {
        return "SubForo " + id + " => " + nombre;
    }

    @Override
    public void anadirSubscriptor(MiembroURJC user) throws SuscriptorYaExistente, SuscripcionActivada {
        if (!subscriptors.contains(user)) {
            this.subscriptors.add(user);
            throw new SuscripcionActivada(user, this);
        } else {
            throw new SuscriptorYaExistente(user, this);
        }

    }

    @Override
    public void quitarSuscriptor(MiembroURJC user) throws UsuarioDadoDeBaja, NoSucritoAlForo {
        if (subscriptors.contains(user)) {
            this.subscriptors.remove(user);
            throw new UsuarioDadoDeBaja(user, this);
        } else {
            throw new NoSucritoAlForo(user, this);
        }
    }

    @Override
    public void eliminarSubscriptor(MiembroURJC user) {
        this.subscriptors.remove(user);
    }

    @Override
    public void notificar(EntradaGenerica entrada) {
        Notificacion notificacion = this.generateNotificacion(entrada);
        for (Subscriptor user : subscriptors) {
            user.recibirNotificacion(notificacion);
        }
    }

    public Notificacion generateNotificacion(EntradaGenerica entrada) {
        return new Notificacion(this.getNombre() + ": " + entrada.msgNotificacion());
    }

    public boolean contieneObjetoPuntuable(int objetoPuntuable) {
        if (this.entradas.containsKey(objetoPuntuable)) {
            return this.entradas.get(objetoPuntuable).getEstado() == EstadoEntrada.validada;
        }
        boolean encontrado = false;
        Integer i;
        Set claves = this.entradas.keySet();
        Iterator iterator = claves.iterator();
        while ((!encontrado) && (iterator.hasNext())) {
            i = (Integer) iterator.next();
            if (this.entradas.get(i).contieneObjetoPuntuable(objetoPuntuable)) {
                encontrado = true;
            }
        }
        return encontrado;
    }

    public ObjetoPuntuable devuelveObjetoPuntuable(int objetoPuntuable) {
        if (this.entradas.containsKey(objetoPuntuable)) {
            return this.entradas.get(objetoPuntuable);
        }
        ObjetoPuntuable obj = null;
        boolean encontrado = false;
        Integer i;
        Set claves = this.entradas.keySet();
        Iterator iterator = claves.iterator();
        while ((!encontrado) && (iterator.hasNext())) {
            i = (Integer) iterator.next();
            if (this.entradas.get(i).contieneObjetoPuntuable(objetoPuntuable)) {
                obj = this.entradas.get(i).devuelveObjetoPuntuable(objetoPuntuable);
                encontrado = true;
            }
        }

        return obj;
    }

    public String viewRec() {
        String strForo;
        strForo = this.toString() + ":";
        for (Entrada entrada : this.entradas.values()) {
            if (entrada.getEstado() == EstadoEntrada.validada) {
                strForo += "\n" + entrada.viewRec("     ");
            }
        }
        return strForo;
    }

    public Entrada crearEntrada(String titulo, String texto, MiembroURJC userLogued) {
        return new Entrada(titulo, texto, userLogued, this);
    }
}
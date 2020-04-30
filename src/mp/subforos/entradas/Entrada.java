package mp.subforos.entradas;

import mp.exceptions.crearEntrada.NuevoContenidoNoContemplado;
import mp.subforos.SubForo;
import mp.subforos.entradas.contenido.Ejercicio;
import mp.subforos.entradas.contenido.Encuesta;
import mp.subforos.entradas.contenido.TextoPlano;
import mp.subforos.entradas.opiniones.Comentario;
import mp.users.MiembroURJC;

import java.util.ArrayList;

public class Entrada extends EntradaGenerica {

    private SubForo subforo;
    private ArrayList<EntradaGenerica> contenido;

    public Entrada(String titulo, String texto, MiembroURJC user, SubForo subForo) {
        super(titulo, texto, user);
        this.subforo=subForo;
        this.contenido= new ArrayList<>();
    }

    public SubForo getSubforo() {
        return subforo;
    }

    public void setSubforo(SubForo subforo) {
        this.subforo = subforo;
    }

    @Override
    public String toString() {
        String contenido=null;
        for (EntradaGenerica elem:this.contenido){
            contenido+="\n"+elem.toString();
        }
        return "Entrada" + this.getId() + " " + this.getUser().getNick() + " => TÍTULO: '" + this.getTitulo() + '\'' + ", TEXTO: '" + this.getTexto() + '\'';
    }


    public EntradaGenerica anadirElemento(String titulo, String texto, String tipo) throws NuevoContenidoNoContemplado {
        EntradaGenerica nuevoCont=null;
        if (tipo=="TextoPlano"){
            nuevoCont=new TextoPlano(titulo,texto,this.getUser(),this);
        } else if (tipo=="Ejercicio"){
            nuevoCont=new Ejercicio(titulo,texto,this.getUser(),this);
        } else if (tipo=="Encuesta"){
            nuevoCont=new Encuesta(titulo,texto,this.getUser(),this);
        } else {
            throw new NuevoContenidoNoContemplado(tipo);
        }
        this.contenido.add(nuevoCont);
        return nuevoCont;
    }

    public String viewRec(String tabulado) {
        String objPunt = tabulado + this.toString();
        for (EntradaGenerica cont:contenido) {
            if (cont.getEstado()== EstadoEntrada.validada) {
                objPunt+="\n"+tabulado+"     "+cont.toString();
            }
        }
        objPunt +="\n"+ tabulado + "PUNTUACION: " + this.getPuntos();
        for (Comentario comentario : this.getComentarios().values()) {
            objPunt += "\n" + comentario.viewRec(tabulado + "          ");
        }
        return objPunt;
    }
}

package mp;

import mp.exceptions.admin.*;
import mp.exceptions.comentario.ComentarSinObjetoPuntuable;
import mp.exceptions.comentario.ComentarSinPermiso;
import mp.exceptions.comentario.ComentarioCreado;
import mp.exceptions.comentario.ComentarioYaExistente;
import mp.exceptions.crearEntrada.*;
import mp.exceptions.logIn.*;
import mp.exceptions.logOut.AdminCierreSesion;
import mp.exceptions.logOut.AdminSesionNoIniciada;
import mp.exceptions.logOut.CierreSesion;
import mp.exceptions.logOut.SesionNoIniciada;
import mp.exceptions.resgister.EmailIncorrecto;
import mp.exceptions.resgister.EmailPreviamenteRegistrado;
import mp.exceptions.resgister.NickYaExistente;
import mp.exceptions.resgister.RegistroCorrecto;
import mp.exceptions.sistem.VerSistema;
import mp.exceptions.sistem.VerSistemaSinPermiso;
import mp.exceptions.subForo.*;
import mp.exceptions.suscripciones.*;
import mp.exceptions.votaciones.*;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public interface Sistema {
    static RedditURJC leerInfo() {
        RedditURJC s = null;
        try {
            FileInputStream file = new FileInputStream("BaseDeDatos.obj");
            ObjectInputStream inputFile = new ObjectInputStream(file);
            s = (RedditURJC) inputFile.readObject();

            inputFile.close();
            file.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.exit(-1);
        }
        return s;
    }

    void loginAdmin(String cont) throws AdminLogedCorrect, AdminIncorrectPassword, AdminWasLoged;

    void logoutAdmin() throws AdminCierreSesion, AdminSesionNoIniciada;

    boolean login(String nick, String cont) throws LogedCorrect, IncorrectPassword, UsuarioNoExistente, SesionYaIniciada, UsuarioPenalizado;

    boolean logout() throws CierreSesion, SesionNoIniciada;

    void registrarUsuario(String nombre, String apellidos, String nick, String contrasena, String email) throws NickYaExistente, EmailIncorrecto, RegistroCorrecto, EmailPreviamenteRegistrado;

    void crearSubforo(String nombre) throws SesionNoIniciada, SubforoCreado, SubForoYaExistente, CrearSubforoSinPermiso;

    void listSubforos() throws VerSubForoSinPermiso, VerSubforo;

    void verEntradasMayorValoración() throws VerEntradas;

    void verEntradasPendientes() throws VerEntradasPendientes, VerEntradasPendientesSinPermiso;

    void validarEntrada() throws EntradaValidada, EntradaValidadaSinPermiso, EntradasRevisadas;

    void rechazarEntrada() throws EntradaRechazada, EntradasRevisadas, EntradaRechazadaSinPermiso;

    void crearEntrada(String titulo, String texto, int foro) throws CrearEntradaSinPermiso, CrearEntradaSinForo, EntradaCreada, EntradaYaExistente;

    void suscribirAForo(int foro) throws SuscriptorYaExistente, SuscripcionActivada, SuscribirSinForo, SuscribirSinPermiso;

    void desuscribirForo(int foro) throws DarseBajaSinForo, DarseBajaSinPermiso, UsuarioDadoDeBaja, NoSucritoAlForo;

    void verForosSuscritos() throws NoSuscritoANingunFor, ForosSuscritos, SubforosNoDisponibles;

    void despenalizarUsuario(String s) throws UsuarioSinPenalizaciones, DespenalizarUsuariosSinPermiso, UsuarioDespenalizado;

    void valorar(String valoracion, int objetoPuntuable) throws VotarSinPermiso, VotarSinObjetoPuntuable, ValoracionNoContemplada, VotacionCreada, VotacionYaExistente, ValorarObjetoPuntuablePropio;

    void crearComentario(String coment, int objetoPuntuable) throws ComentarSinPermiso, ComentarioCreado, ComentarioYaExistente, ComentarSinObjetoPuntuable;

    void verSistema() throws VerSistemaSinPermiso, VerSistema;

    void destroy();
}

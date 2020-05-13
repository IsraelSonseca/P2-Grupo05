package com.general;

import mp.RedditURJC;
import mp.exceptions.Result;
import mp.exceptions.suscripciones.DarseBajaSinForo;
import mp.exceptions.suscripciones.DarseBajaSinPermiso;
import mp.exceptions.suscripciones.NoSucritoAlForo;
import mp.exceptions.suscripciones.UsuarioDadoDeBaja;

public class Demostrador1 {
    public RedditURJC redditURJC;

    public void main() {
        // TODO - implement Demostrador.main
        System.out.println();
        redditURJC = RedditURJC.getInstance();

        //redditURJC = RedditURJC.leerInfo();
        //System.out.println(redditURJC);

        //Registro de Usuarios
        try {//email malo
            redditURJC.registrarUsuario("Israel", "Penalver Sánchez", "IsraelSonseca", "12345", "i.penalver.2016@s");
        } catch (Result result) {
            System.out.println(result.getMessage());
        }
        try {//registro alumno correcto
            redditURJC.registrarUsuario("Israel", "Penalver Sánchez", "IsraelSonseca", "12345", "i.penalver.2016@alumnos.urjc.es");
        } catch (Result result) {
            System.out.println(result.getMessage());
        }
        try {//email previamente registrado
            redditURJC.registrarUsuario("Israel", "Penalver Sánchez", "IsraelSonsec", "12345", "i.penalver.2016@alumnos.urjc.es");
        } catch (Result result) {
            System.out.println(result.getMessage());
        }
        try {//nick en uso
            redditURJC.registrarUsuario("Israel", "Penalver Sánchez", "IsraelSonseca", "12345", "a.penalver.2016@alumnos.urjc.es");
        } catch (Result result) {
            System.out.println(result.getMessage());
        }
        try {//registro profesor correcto
            redditURJC.registrarUsuario("Antonio", "Gonzalez Pardo", "agpardo", "12345", "antonio.gpardo@urjc.es");
        } catch (Result result) {
            System.out.println(result.getMessage());
        }


        //Inicios de sesión
        try {//1 usuario no registrado
            redditURJC.login("IsraelSonsec", "123");
        } catch (Result result) {
            System.out.println(result.getMessage());
        }
        try {//2 contrasena incorrecta
            redditURJC.login("IsraelSonseca", "123");
        } catch (Result result) {
            System.out.println(result.getMessage());
        }
        try {// 3 login correcto alumno
            redditURJC.login("IsraelSonseca", "12345");
        } catch (Result result) {
            System.out.println(result.getMessage());
        }
        try {// 4 sesion iniciada
            redditURJC.login("IsraelSonseca", "12345");
        } catch (Result result) {
            System.out.println(result.getMessage());
        }
        try {//5Inicio de sesion como profesor
            redditURJC.logout();
        } catch (Result result) {
            System.out.println(result.getMessage());
        }
        try {
            redditURJC.login("agpardo", "12345");
        } catch (Result result) {
            System.out.println(result.getMessage());
        }


        //Cierre de sesión
        try {//1 logoutCorrecto
            redditURJC.logout();
        } catch (Result result) {
            System.out.println(result.getMessage());
        }
        try {//2 logOutIncorrecto
            redditURJC.logout();
        } catch (Result result) {
            System.out.println(result.getMessage());
        }


        //CrearSubforo
        try {//1 CrearSubfotoCorrectamente
            redditURJC.login("agpardo", "12345");
        } catch (Result result) {
            System.out.println(result.getMessage());
        }
        try {
            redditURJC.crearSubforo("Metodología de la Programación");
        } catch (Result result) {
            System.out.println(result.getMessage());
        }
        try {//2 CrearSubForoYaCreado
            redditURJC.crearSubforo("Metodología de la Programación");
        } catch (Result result) {
            System.out.println(result.getMessage());
        }
        try {//3 CrearSubforo Sin haber iniciado sesión
            redditURJC.logout();
        } catch (Result result) {
            System.out.println(result.getMessage());
        }
        try {
            redditURJC.crearSubforo("ABC");
        } catch (Result result) {
            System.out.println(result.getMessage());
        }
        try {//4 Crear subForo con un alumno
            redditURJC.login("IsraelSonseca", "12345");
        } catch (Result result) {
            System.out.println(result.getMessage());
        }
        try {//4 Crear subForo con un alumno
            redditURJC.crearSubforo("ABC");
        } catch (Result result) {
            System.out.println(result.getMessage());
        }


        //Ver SUBFOROS
        try {//1 Ver Subforos Correctamente
            redditURJC.listSubforos();
        } catch (Result result) {
            System.out.println(result.getMessage());
        }
        try {//2 Ver Subforos sin iniciar sesion ERROR
            redditURJC.logout();
        } catch (Result result) {
            System.out.println(result.getMessage());
        }
        try {
            redditURJC.listSubforos();
        } catch (Result result) {
            System.out.println(result.getMessage());
        }
        try {//3 Ver Subforos como se actualiza
            redditURJC.login("agpardo", "12345");
        } catch (Result result) {
            System.out.println(result.getMessage());
        }
        try {
            redditURJC.crearSubforo("ABC");
        } catch (Result result) {
            System.out.println(result.getMessage());
        }
        try {
            redditURJC.listSubforos();
        } catch (Result result) {
            System.out.println(result.getMessage());
        }


        //CrearEntradas con titulo y texto.---- CrearEntrada,CrearEntradaSinForo, CrearEntradaSinPermiso.
        try {//1 Crear Una entrada Correctamente
            redditURJC.crearEntrada("Prac1", "La fecha limite es el 20 de abril.", 1);
        } catch (Result result) {
            System.out.println(result.getMessage());
        }
        try {//2 Crear Una entrada en un foro que no existe
            redditURJC.crearEntrada("Prac1", "La fecha limite es el 20 de abril.", 99);
        } catch (Result result) {
            System.out.println(result.getMessage());
        }
        try {//3 Crear Una entrada sin iniciarSesion
            redditURJC.logout();
        } catch (Result result) {
            System.out.println(result.getMessage());
        }
        try {
            redditURJC.crearEntrada("Prac1", "La fecha limite es el 20 de abril.", 99);
        } catch (Result result) {
            System.out.println(result.getMessage());
        }


        //Crear varias entradas para probar la validación de estas
        try {
            redditURJC.login("agpardo", "12345");
        } catch (Result result) {
            System.out.println(result.getMessage());
        }
        try {
            redditURJC.crearEntrada("Prac2", "Esta practica consiste en la implementacion del enunciado 1", 1);
        } catch (Result result) {
            System.out.println(result.getMessage());
        }
        try {
            redditURJC.crearEntrada("Covid-19", "Se ha producido una cancelacion de las clases presenciales para este curso", 2);
        } catch (Result result) {
            System.out.println(result.getMessage());
        }

        //Inicio de sesion admin incorrecto, inicio de sesion correcto admin, iniciar admin aun estando ya iniciado
        //cierre sesion ok, cierre de sesion sin tener iniciada
        try {//1Inicio de sesion admin incorrecto
            redditURJC.loginAdmin("111");
        } catch (Result result) {
            System.out.println(result.getMessage());
        }
        try {//2 inicio de sesion correcto admin
            redditURJC.loginAdmin("11111");
        } catch (Result result) {
            System.out.println(result.getMessage());
        }
        try {//3 iniciar admin aun estando ya iniciado
            redditURJC.loginAdmin("11111");
        } catch (Result result) {
            System.out.println(result.getMessage());
        }
        try {//4 logout ok
            redditURJC.logoutAdmin();
        } catch (Result result) {
            System.out.println(result.getMessage());
        }
        try {//5 logout sin log in
            redditURJC.logoutAdmin();
        } catch (Result result) {
            System.out.println(result.getMessage());
        }

        //VER ENTRADAS PENDIENTES SIN ADMIN---- VER ENTRADAS PENDIENTES CON ADMIN
        try {//1 VER ENTRADAS PENDIENTES SIN ADMIN
            redditURJC.verEntradasPendientes();
        } catch (Result result) {
            System.out.println(result.getMessage());
        }
        try {//2 VER ENTRADAS PENDIENTES CON ADMIN
            redditURJC.loginAdmin("11111");
        } catch (Result result) {
            System.out.println(result.getMessage());
        }
        try {
            redditURJC.verEntradasPendientes();
        } catch (Result result) {
            System.out.println(result.getMessage());
        }


        //Vamos a proceder con la validación de Entradas EntradaValidada, EntradaValidadaSinPermiso, EntradasValidadas
        try {//1EntradaValidada correctamente
            redditURJC.validarEntrada();
        } catch (Result result) {
            System.out.println(result.getMessage());
        }
        try {//2EntradaValidadaSinPermiso
            redditURJC.logoutAdmin();
        } catch (Result result) {
            System.out.println(result.getMessage());
        }
        try {
            redditURJC.validarEntrada();
        } catch (Result result) {
            System.out.println(result.getMessage());
        }
        try {//3Validar todas y seguir validando
            redditURJC.loginAdmin("11111");
        } catch (Result result) {
            System.out.println(result.getMessage());
        }
        try {
            redditURJC.validarEntrada();
        } catch (Result result) {
            System.out.println(result.getMessage());
        }
        try {
            redditURJC.validarEntrada();
        } catch (Result result) {
            System.out.println(result.getMessage());
        }
        try {
            redditURJC.validarEntrada();
        } catch (Result result) {
            System.out.println(result.getMessage());
        }

        //Vamos a proceder a rechazar entradas EntradaRechazada, EntradasRevisadas, EntradaRechazadaSinPermiso
        //para eso primero vamos a crear 2 entradas
        //Crear varias entradas para probar la validación de estas
        try {
            redditURJC.logout();
        } catch (Result result) {
            System.out.println(result.getMessage());
        }
        try {
            redditURJC.login("IsraelSonseca", "12345");
        } catch (Result result) {
            System.out.println(result.getMessage());
        }
        try {
            redditURJC.crearEntrada("Prac2COPIA", "Esta practica podemos hacerla toda la clase juntos y hacer trampas", 1);
        } catch (Result result) {
            System.out.println(result.getMessage());
        }
        try {
            redditURJC.crearEntrada("Covid-19 quedada", "Vamos a la uni sin que nos pillen. quedada", 2);
        } catch (Result result) {
            System.out.println(result.getMessage());
        }
        try {
            redditURJC.logout();
        } catch (Result result) {
            System.out.println(result.getMessage());
        }
        //Vamos a proceder con el rechazo de EntradaRechazada, EntradasRevisadas, EntradaRechazadaSinPermiso
        try {//1EntradaRechazada correctamente
            redditURJC.loginAdmin("11111");
        } catch (Result result) {
            System.out.println(result.getMessage());
        }
        try {
            redditURJC.rechazarEntrada();
        } catch (Result result) {
            System.out.println(result.getMessage());
        }
        try {//2EntradaRechazadaSinPermiso
            redditURJC.logoutAdmin();
        } catch (Result result) {
            System.out.println(result.getMessage());
        }
        try {
            redditURJC.rechazarEntrada();
        } catch (Result result) {
            System.out.println(result.getMessage());
        }
        try {//3EntradasRevisadas
            redditURJC.loginAdmin("11111");
        } catch (Result result) {
            System.out.println(result.getMessage());
        }
        try {
            redditURJC.rechazarEntrada();
        } catch (Result result) {
            System.out.println(result.getMessage());
        }
        try {
            redditURJC.rechazarEntrada();
        } catch (Result result) {
            System.out.println(result.getMessage());
        }

        //MOSTRAR QUENO SE PUEDE INICIAR SESION CON EL USUARIO QUE HA SIDO PENALIZADO
        try {
            redditURJC.login("IsraelSonseca", "12345");
        } catch (Result result) {
            System.out.println(result.getMessage());
        }

        //DESPENALIZAR A ALGÚN USUARIO

        try {
            redditURJC.despenalizarUsuario("IsraelSonseca");
        } catch (Result result) {
            System.out.println(result.getMessage());
        }
        try {
            redditURJC.despenalizarUsuario("IsraelSonseca");
        } catch (Result result) {
            System.out.println(result.getMessage());
        }

        //VERLAS ENTRADAS CON MAYOR VALORACION
        try {
            redditURJC.verEntradasMayorValoración();
        } catch (Result result) {
            System.out.println(result.getMessage());
        }


        //1anadir subscriptor, 2 usuario no existe, 3 foro no existe, 4 ya estaba subscrito
        //SuscribirSinPermiso, SuscripcionActivada, SuscriptorYaExistente, SuscribirSinForo
        try {//1SuscribirSinPermiso
            redditURJC.logout();
        } catch (Result result) {
            System.out.println(result.getMessage());
        }
        try {
            redditURJC.suscribirAForo(1);
        } catch (Result result) {
            System.out.println(result.getMessage());
        }
        try {//2SuscripcionActivada
            redditURJC.login("agpardo", "12345");
        } catch (Result result) {
            System.out.println(result.getMessage());
        }
        try {
            redditURJC.listSubforos();
        } catch (Result result) {
            System.out.println(result.getMessage());
        }
        try {
            redditURJC.suscribirAForo(1);
        } catch (Result result) {
            System.out.println(result.getMessage());
        }
        try {//3 SuscriptorYaExistente
            redditURJC.suscribirAForo(1);
        } catch (Result result) {
            System.out.println(result.getMessage());
        }
        try {//4 SuscribirSinForo
            redditURJC.suscribirAForo(-1);
        } catch (Result result) {
            System.out.println(result.getMessage());
        }
        try {
            redditURJC.logout();
        } catch (Result result) {
            System.out.println(result.getMessage());
        }

        //Permite ver a que foros está suscrito un usuario
        try {
            redditURJC.login("IsraelSonseca", "12345");
        } catch (Result result) {
            System.out.println(result.getMessage());
        }
        try {
            redditURJC.suscribirAForo(1);
        } catch (Result result) {
            System.out.println(result.getMessage());
        }
        try {
            redditURJC.suscribirAForo(2);
        } catch (Result result) {
            System.out.println(result.getMessage());
        }
        try {
            redditURJC.verForosSuscritos();
        } catch (Result result) {
            System.out.println(result.getMessage());
        }

        //Procedemos a darnos de baja de un subforo

        try { //nos damos de baja correctamente
            redditURJC.desuscribirForo(2);
        } catch (Result result) {
            System.out.println(result.getMessage());
        }
        try { //nos intentamos dar de baja cuando no estamos suscritos
            redditURJC.desuscribirForo(2);
        } catch (Result result) {
            System.out.println(result.getMessage());
        }
        try { //nos intentamos dar de baja a un foro que no existe actualmente
            redditURJC.desuscribirForo(-1);
        } catch (Result result) {
            System.out.println(result.getMessage());
        }

        //A continuacion vamosa crear una entrada y vamos a  ver la notificacion de agpardo al iniciar sesion
        try {
            redditURJC.logout();
        } catch (Result result) {
            System.out.println(result.getMessage());
        }
        try {
            redditURJC.registrarUsuario("Jonathan", "Crespo Herrero", "robojon", "12345", "jonathan.crespo@urjc.es");
        } catch (Result result) {
            System.out.println(result.getMessage());
        }
        try {//iniciamos sesion
            redditURJC.login("robojon", "12345");
        } catch (Result result) {
            System.out.println(result.getMessage());
        }
        try {//creamos la entrada
            redditURJC.crearEntrada("Notas Prac 1", "Podeis ver vuestras notas de la Practica 1 en el aula virtual", 1);
        } catch (Result result) {
            System.out.println(result.getMessage());
        }
        try {//validamos la entrada
            redditURJC.validarEntrada();
        } catch (Result result) {
            System.out.println(result.getMessage());
        }
        try {//cerramos sesion de Jonathan
            redditURJC.logout();
        } catch (Result result) {
            System.out.println(result.getMessage());
        }
        try {//Iniciamos sesion con agpardo para verificar la notificación
            redditURJC.login("agpardo", "12345");
        } catch (Result result) {
            System.out.println(result.getMessage());
        }

        //A continuacion vamos a cerrar sesion e iniciar para verificar que ya no aparecen notificaciones
        try {//cerramos sesion de agpardo
            redditURJC.logout();
        } catch (Result result) {
            System.out.println(result.getMessage());
        }
        try {//Iniciamos sesion con agpardo para verificar la notificación
            redditURJC.login("agpardo", "12345");
        } catch (Result result) {
            System.out.println(result.getMessage());
        }

        //Vamos a comprobar la funcionalidad de los comentarios: 1ComentarSinPermiso, 2ComentarioCreado, 3ComentarSinObjetoPuntuable, 4ComentarioYaExistente
        try {//1ComentarSinPermiso
            redditURJC.logout();
        } catch (Result result) {
            System.out.println(result.getMessage());
        }
        try {
            redditURJC.crearComentario("Comentario sin iniciar sesion", 4);
        } catch (Result result) {
            System.out.println(result.getMessage());
        }
        try {//2ComentarioCreado
            redditURJC.login("agpardo", "12345");
        } catch (Result result) {
            System.out.println(result.getMessage());
        }
        try {
            redditURJC.crearComentario("Este es el primer comentario creado correctamente", 1);
        } catch (Result result) {
            System.out.println(result.getMessage());
        }
        try {////3ComentarSinObjetoPuntuable
            redditURJC.crearComentario("Este comentario intenta crearse para una entrada que no existe", 100);
        } catch (Result result) {
            System.out.println(result.getMessage());
        }
        try {////3ComentarSinObjetoPuntuable porque la entrada no esta validada
            redditURJC.crearComentario("Este comentario intenta crearse para una entrada que no existe ya que fue penalizada", 4);
        } catch (Result result) {
            System.out.println(result.getMessage());
        }


        //VAMOS A MOSTRAR LAS ENTRADAS SIN INICIAR SESION
        try {
            redditURJC.logout();
        } catch (Result result) {
            System.out.println(result.getMessage());
        }
        try {
            redditURJC.verEntradasMayorValoración();
        } catch (Result result) {
            System.out.println(result.getMessage());
        }
        //FUNCIONALIDADES VOTAR:1VotarSinPermiso, 2VotarSinObjetoPuntuable, 3ValoracionNoContemplada, 4VotacionCreada, 5VotacionYaExistente, 6ValorarObjetoPuntuablePropio

        try {//1VotarSinPermiso
            redditURJC.valorar("positiva", 6);
        } catch (Result result) {
            System.out.println(result.getMessage());
        }
        try {//2VotarSinObjetoPuntuable
            redditURJC.login("agpardo", "12345");
        } catch (Result result) {
            System.out.println(result.getMessage());
        }
        try {
            redditURJC.valorar("positiva", -1);
        } catch (Result result) {
            System.out.println(result.getMessage());
        }
        try {//3ValoracionNoContemplada
            redditURJC.valorar("+", 6);
        } catch (Result result) {
            System.out.println(result.getMessage());
        }
        try {//4VotacionCreada
            redditURJC.valorar("positiva", 6);
        } catch (Result result) {
            System.out.println(result.getMessage());
        }
        try {//ver entradas en orden para comprobar
            redditURJC.verEntradasMayorValoración();
        } catch (Result result) {
            System.out.println(result.getMessage());
        }
        try {//5VotacionYaExistente igual y vemos que no cambia los puntos
            redditURJC.valorar("positiva", 6);
        } catch (Result result) {
            System.out.println(result.getMessage());
        }
        try {//ver entradas en orden para comprobar
            redditURJC.verEntradasMayorValoración();
        } catch (Result result) {
            System.out.println(result.getMessage());
        }
        try {//5VotacionYaExistente diferente y vemos que pierde el punto y ademas resta otro
            redditURJC.valorar("negativa", 6);
        } catch (Result result) {
            System.out.println(result.getMessage());
        }
        try {//ver entradas en orden para comprobar
            redditURJC.verEntradasMayorValoración();
        } catch (Result result) {
            System.out.println(result.getMessage());
        }
        try {//6ValorarObjetoPuntuablePropio
            redditURJC.valorar("negativa", 1);
        } catch (Result result) {
            System.out.println(result.getMessage());
        }


        //Probamos la funcionalidad de ver el sistema enterio
        try {
            redditURJC.crearComentario("okey, esta es mi respuesta al comentario", 7);
        } catch (Result result) {
            System.out.println(result.getMessage());
        }
        try {
            redditURJC.crearComentario("Este es el segundo comentario", 1);
        } catch (Result result) {
            System.out.println(result.getMessage());
        }
        try {
            redditURJC.verSistema();
        } catch (Result result) {
            System.out.println(result.getMessage());
        }
        
        //Vamos a probar la funcionalidad de modificar entradas  throws ModificarEntradaNoExistente, ModificarEntradaSinPermiso, ModificarEntradaAjena, ModificacionEntradaCorrecta
        try {
            redditURJC.modificarEntrada("Titulo","Esto es un texto de una entrada que no se va a modificar",-1);
        } catch (Result result) {
            System.out.println(result.getMessage());
        }
        //Vamos a modificar una entrada sin permiso
           try {
            redditURJC.logout();
        } catch (Result result) {
            System.out.println(result.getMessage());
        }
          try {
            redditURJC.modificarEntrada("Titulo","Esto es un texto de una entrada que no se va a modificar",-1);
        } catch (Result result) {
            System.out.println(result.getMessage());
        }
        
         //Vamos a intentar modificar una entrada ajena
           try {
            redditURJC.login("agpardo","12345");
        } catch (Result result) {
            System.out.println(result.getMessage());
        }
          try {
            redditURJC.modificarEntrada("Titulo","Esto es un texto de una entrada que no se va a modificar",6);
        } catch (Result result) {
            System.out.println(result.getMessage());
        }
          
          //Vamos a intentar modificar una entrada propia correctamente
          try {
            redditURJC.modificarEntrada("Titulo Modificado de la PRAC1","Este es el texto modificado de la entrada: ",1);
        } catch (Result result) {
            System.out.println(result.getMessage());
        }
        //Mostramos el sistema para mostrar los cambios
         try {
            redditURJC.verSistema();
        } catch (Result result) {
            System.out.println(result.getMessage());
        }




         // Vamos a probarla funcionalidad de anadir nuevo contedio:ModificarEntradaSinPermiso, ModificarEntradaNoExistente, ModificarEntradaAjena, NuevoContenidoNoContemplado, NuevoContenido
        try {//1ModificarEntradaSinPermiso
            redditURJC.logout();
        } catch (Result result) {
            System.out.println(result.getMessage());
        } try {
            redditURJC.anadiraEntrada("titulo","dasfas",1,"TextoPlano");
        } catch (Result result) {
            System.out.println(result.getMessage());
        } try {//2ModificarEntradaNoExistente
            redditURJC.login("agpardo","12345");
        } catch (Result result) {
            System.out.println(result.getMessage());
        } try {
            redditURJC.anadiraEntrada("titulo","dasfas",-1,"TextoPlano");
        } catch (Result result) {
            System.out.println(result.getMessage());
        } try {//3ModificarEntradaAjena
            redditURJC.anadiraEntrada("titulo","dasfas",6,"TextoPlano");
        } catch (Result result) {
            System.out.println(result.getMessage());
        } try {//4NuevoContenidoNoContemplado
            redditURJC.anadiraEntrada("titulo","dasfas",1,"Examen");
        } catch (Result result) {
            System.out.println(result.getMessage());
        } try {//5NuevoContenido texto plano
            redditURJC.anadiraEntrada("Titulo del texto plano anadido","Texto del texto plano anadido",1,"TextoPlano");
        } catch (Result result) {
            System.out.println(result.getMessage());
        } try {//5NuevoContenido encuesta
            redditURJC.anadiraEntrada("Titulo de la encuesta anadida","Texto de la encuesta anadida",1,"Encuesta");
        } catch (Result result) {
            System.out.println(result.getMessage());
        } try {//5NuevoContenido ejercicio
            redditURJC.anadiraEntrada("Titulo del ejercicio anadido","Texto del ejercicio anadido",1,"Ejercicio");
        } catch (Result result) {
            System.out.println(result.getMessage());
        }

        try {//ver sistema
            redditURJC.verSistema();
        } catch (Result result) {
            System.out.println(result.getMessage());
        }

        //A continuacion vamos a validar por el admin las entradas
        try {//validar
            redditURJC.validarEntrada();
        } catch (Result result) {
            System.out.println(result.getMessage());
        } try {//validar
            redditURJC.validarEntrada();
        } catch (Result result) {
            System.out.println(result.getMessage());
        } try {//validar
            redditURJC.validarEntrada();
        } catch (Result result) {
            System.out.println(result.getMessage());
        }

        try {//ver sistema
            redditURJC.verSistema();
        } catch (Result result) {
            System.out.println(result.getMessage());
        }
        try {//cerramos sesion
            redditURJC.logout();
        } catch (Result result) {
            System.out.println(result.getMessage());
        }

        try {//iniciamos sesion
            redditURJC.login("IsraelSonseca","12345");
        } catch (Result result) {
            System.out.println(result.getMessage());
        }


        //Ejecuta Correctamente todas las funcionalidades desarrolladas
        int a = 11 + 11;
        //COMPROBADO QUE SIGUE BIEN
    }

}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mp.exceptions.comentario;

import mp.exceptions.Result;

/**
 *
 * @author Pablo
 */
public class ComentarSinPermiso extends Result {

    public ComentarSinPermiso() {
        super("Usted no es Miembro de la URJC, no tiene permisos para crear Comentarios. CREACIÓN COMENTARIO CANCELADA");
    }

    /**
     *
     * @author Pablo
     */
    static class ComentarSinObjetoPuntuable extends Result {
          public ComentarSinObjetoPuntuable(int objetoPuntuable) {
            super("El Objeto/Comentario/Entrada/Respuesta (en el que quiere comentar) número "+objetoPuntuable+"  no existe. COMENTARIO CANCELADO");
         }

    }
}

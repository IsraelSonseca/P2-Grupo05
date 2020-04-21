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
    
}

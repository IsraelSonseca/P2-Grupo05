/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mp.exceptions.comentario;

import mp.exceptions.Result;
import mp.subforos.Comentario;

/**
 * @author Pablo
 */
public class ComentarioYaExistente extends Result {

    public ComentarioYaExistente(Comentario comment) {
        super("Un comentario con id: " + comment.getId() + ", ya está creado. CREACIÓN DEL COMENTARIO CANCELADA");
    }

}

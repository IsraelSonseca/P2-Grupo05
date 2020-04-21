/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mp.exceptions.comentario;

import mp.exceptions.Result;
import mp.subforos.ObjetoPuntuable;

/**
 *
 * @author Pablo
 */
public class ComentarioCreado extends Result {

    public ComentarioCreado(ObjetoPuntuable nuevo, ObjetoPuntuable padre) {
     super("Comenario con id: "+nuevo.getId()+" creado correctamente para la entrada/comentario/respuesta  con id: "+padre.getId()+" COMENTARIO CREADO CORRECTAMENTE");

        
    }
    
}

package mp.subforos;

import static mp.subforos.EstadoValoracion.negativa;
import static mp.subforos.EstadoValoracion.positiva;

public class Votacion {

	private EstadoValoracion estado;
        
        
	public void like(ObjetoPuntuable obj) {
		if (estado == positiva){
                    System.out.println("No se puede valorar positivamente dos veces");    
                }else{
                    estado = positiva;
                    obj.aumentar();
                }
	}

	public void dislike(ObjetoPuntuable obj) {
		if (estado == negativa){
                    System.out.println("No se puede valorar negativamente dos veces");                 
                }else{
                    estado = negativa;
                    obj.disminuir();
                }
	}

}
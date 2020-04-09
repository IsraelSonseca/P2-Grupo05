package mp.subforos;



public class ObjetoPuntuable implements Comparable<ObjetoPuntuable> {

	private int puntos;

	public ObjetoPuntuable(int puntos) {
		this.puntos = puntos;
	}

	@Override
	public int compareTo(ObjetoPuntuable objetoPuntuable) {
		int resultado=0;
		if (this.puntos<objetoPuntuable.puntos) {
			resultado = -1;
		}
		else if (this.puntos>objetoPuntuable.puntos) {
			resultado = 1;
		}
		return resultado;
	}
        
        public void aumentar (){
            puntos = puntos + 1;
        }
        
        public void disminuir (){
            puntos = puntos - 1;
        }
        
}
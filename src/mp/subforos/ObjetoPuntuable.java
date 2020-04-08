package mp.subforos;

import java.util.Comparator;

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
}
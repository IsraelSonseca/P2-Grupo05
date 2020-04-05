package com.general;

import mp.Sistema;
import mp.exceptions.Result;

public class Demostrador {
	private Sistema redditURJC;

	public void main() {
		// TODO - implement Demostrador.main
		System.out.println();
		redditURJC=new Sistema();
		try {
			redditURJC.registrarUsuario("Israel","Peñalver Sánchez","IsraelSonseca","12345","i.penalver.2016@alumnos.urjc.es");
		} catch (Result result) {
			System.out.println(result.getMessage());
		}
		try {
			redditURJC.registrarUsuario("Antonio","Gonzalez Pardo","agpardo","12345","antonio.gpardo@urjc.es");
		} catch (Result result) {
			System.out.println(result.getMessage());
		}

		//throw new UnsupportedOperationException();
	}

}
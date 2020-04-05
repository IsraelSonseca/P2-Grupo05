package com.general;

import mp.Sistema;
import mp.exceptions.Result;
import mp.users.MiembroURJC;

public class Demostrador {
	private Sistema redditURJC;
	private MiembroURJC userLogued;

	public void main() {
		// TODO - implement Demostrador.main
		System.out.println();
		redditURJC=new Sistema();

		//Registro de Usuarios
		try {//email malo
			redditURJC.registrarUsuario("Israel","Peñalver Sánchez","IsraelSonseca","12345","i.penalver.2016@s");
		} catch (Result result) {
			System.out.println(result.getMessage());
		}
		try {//registro alumno correcto
			redditURJC.registrarUsuario("Israel","Peñalver Sánchez","IsraelSonseca","12345","i.penalver.2016@alumnos.urjc.es");
		} catch (Result result) {
			System.out.println(result.getMessage());
		}
		try {//email previamente registrado
			redditURJC.registrarUsuario("Israel","Peñalver Sánchez","IsraelSonsec","12345","i.penalver.2016@alumnos.urjc.es");
		} catch (Result result) {
			System.out.println(result.getMessage());
		}
		try {//nick en uso
			redditURJC.registrarUsuario("Israel","Peñalver Sánchez","IsraelSonseca","12345","a.penalver.2016@alumnos.urjc.es");
		} catch (Result result) {
			System.out.println(result.getMessage());
		}
		try {//registro profesor correcto
			redditURJC.registrarUsuario("Antonio","Gonzalez Pardo","agpardo","12345","antonio.gpardo@urjc.es");
		} catch (Result result) {
			System.out.println(result.getMessage());
		}


		//Inicios de sesión


		int a=1+1;
		//throw new UnsupportedOperationException();
	}

}
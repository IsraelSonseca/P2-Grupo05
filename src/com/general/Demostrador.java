package com.general;

import mp.Sistema;
import mp.exceptions.*;
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
		try {//1 usuario no registrado
			redditURJC.login("IsraelSonsec", "123");
		}catch (Result result){
			System.out.println(result.getMessage());
		}
		try {//2 contraseña incorrecta
			redditURJC.login("IsraelSonseca","123");
		} catch (Result result) {
			System.out.println(result.getMessage());
		}
		try {// 3 login correcto
			redditURJC.login("IsraelSonseca","12345");
		} catch (Result result) {
			System.out.println(result.getMessage());
		}
		try {// 4 sesion iniciada
			redditURJC.login("IsraelSonseca","12345");
		} catch (Result result) {
			System.out.println(result.getMessage());
		}




		//Cierre de sesión
		try {//1 logoutCorrecto
			redditURJC.logout();
		}catch (Result result){
			System.out.println(result.getMessage());
		}
		try {//2 logOutIncorrecto
			redditURJC.logout();
		} catch (Result result) {
			System.out.println(result.getMessage());
		}
		//Checked that is all okey
		int a=1+1;
		//throw new UnsupportedOperationException();
	}

}
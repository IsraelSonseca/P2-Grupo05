package com.general;

import mp.Sistema;
import mp.exceptions.*;
import mp.users.MiembroURJC;

public class Demostrador {
	private Sistema redditURJC;

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
		try {// 3 login correcto alumno
			redditURJC.login("IsraelSonseca","12345");
		} catch (Result result) {
			System.out.println(result.getMessage());
		}
		try {// 4 sesion iniciada
			redditURJC.login("IsraelSonseca","12345");
		} catch (Result result) {
			System.out.println(result.getMessage());
		}try{//5Inicio de sesion como profesor
			redditURJC.logout();
		}catch (Result result){
			System.out.println(result.getMessage());
		}try{
			redditURJC.login("agpardo","12345");
		}catch (Result result){
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




		//CrearSubforo
		try {//1 CrearSubfotoCorrectamente
			redditURJC.login("agpardo","12345");
		}catch (Result result){
			System.out.println(result.getMessage());
		} try {
			redditURJC.crearSubforo("Metodología de la Programación");
		} catch (Result result) {
			System.out.println(result.getMessage());
		} try {//2 CrearSubForoYaCreado
			redditURJC.crearSubforo("Metodología de la Programación");
		} catch (Result result) {
			System.out.println(result.getMessage());
		}try {//3 CrearSubforo Sin haber iniciado sesión
			redditURJC.logout();
		}catch (Result result){
			System.out.println(result.getMessage());
		} try {
			redditURJC.crearSubforo("ABC");
		} catch (Result result) {
			System.out.println(result.getMessage());
		} try {//4 Crear subForo con un alumno
			redditURJC.login("IsraelSonseca","12345");
		} catch (Result result) {
			System.out.println(result.getMessage());
		} try {//4 Crear subForo con un alumno
			redditURJC.crearSubforo("ABC");
		} catch (Result result) {
			System.out.println(result.getMessage());
		}


		//Ver SUBFOROS
		try {//1 Ver Subforos Correctamente
			redditURJC.listSubforos();
		} catch (Result result) {
			System.out.println(result.getMessage());
		} try {//2 Ver Subforos sin iniciar sesion ERROR
			redditURJC.logout();
		} catch (Result result) {
			System.out.println(result.getMessage());
		} try {
			redditURJC.listSubforos();
		} catch (Result result) {
			System.out.println(result.getMessage());
		} try {//3 Ver Subforos como se actualiza
			redditURJC.login("agpardo","12345");
		} catch (Result result) {
			System.out.println(result.getMessage());
		} try {
			redditURJC.crearSubforo("ABC");
		} catch (Result result) {
			System.out.println(result.getMessage());
		} try {
			redditURJC.listSubforos();
		} catch (Result result) {
			System.out.println(result.getMessage());
		}


		//CrearEntradas con titulo y texto.---- CrearEntrada,CrearEntradaSinForo, CrearEntradaSinPermiso.
		try {//1 Crear Una entrada Correctamente
			redditURJC.crearEntrada("Prac1","La fecha limite es el 20 de abril.",1);
		} catch (Result result) {
			System.out.println(result.getMessage());
		} try {//2 Crear Una entrada en un foro que no existe
			redditURJC.crearEntrada("Prac1","La fecha limite es el 20 de abril.",99);
		} catch (Result result) {
			System.out.println(result.getMessage());
		} try {//3 Crear Una entrada sin iniciarSesion
			redditURJC.logout();
		} catch (Result result) {
			System.out.println(result.getMessage());
		} try {
			redditURJC.crearEntrada("Prac1","La fecha limite es el 20 de abril.",99);
		} catch (Result result) {
			System.out.println(result.getMessage());
		}


		//Crear varias entradas para probar la validación de estas
		try {
			redditURJC.login("agpardo","12345");
		} catch (Result result) {
			System.out.println(result.getMessage());
		} try {
			redditURJC.crearEntrada("Prac2","Esta practica consiste en la implementacion del enunciado 1",1);
		} catch (Result result) {
			System.out.println(result.getMessage());
		} try {
			redditURJC.crearEntrada("Covid-19","Se ha producido una cancelacion de las clases presenciales para este curso",2);
		} catch (Result result) {
			System.out.println(result.getMessage());
		}

		//Inicio de sesion admin incorrecto, inicio de sesion correcto admin, iniciar admin aun estando ya iniciado
		//cierre sesion ok, cierre de sesion sin tener iniciada
		try {//1Inicio de sesion admin incorrecto
			redditURJC.loginAdmin("111");
		} catch (Result result) {
			System.out.println(result.getMessage());
		}try {//2 inicio de sesion correcto admin
			redditURJC.loginAdmin("11111");
		} catch (Result result) {
			System.out.println(result.getMessage());
		} try {//3 iniciar admin aun estando ya iniciado
			redditURJC.loginAdmin("11111");
		} catch (Result result) {
			System.out.println(result.getMessage());
		} try {//4 logout ok
			redditURJC.logoutAdmin();
		} catch (Result result) {
			System.out.println(result.getMessage());
		} try {//5 logout sin log in
			redditURJC.logoutAdmin();
		} catch (Result result) {
			System.out.println(result.getMessage());
		}

		int a=1+1;
		//throw new UnsupportedOperationException();
	}

}
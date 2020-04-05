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


		int a=1+1;
		//throw new UnsupportedOperationException();
	}

}
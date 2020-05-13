package com.general;

import java.io.File;

/**
 * The type Main.
 */
public class Main {

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        // write your code here
        File f = new File("BaseDeDatos.obj");
        if (f.exists()) {
            f.delete();
        }
        Demostrador1 demostrador1 = new Demostrador1();
        demostrador1.main();
        demostrador1.redditURJC.destroy();
        System.out.println("#####################################################################################");
        System.out.println("#####################################################################################");
        System.out.println("Base de datos guardada, a continuacion vamos a comprobar la persistencia de los datos");
        System.out.println("#####################################################################################");
        System.out.println("#####################################################################################");
        Demostrador2 demostrador2 = new Demostrador2();
        demostrador2.main();
        //ASDFASDFASDF

    }
}

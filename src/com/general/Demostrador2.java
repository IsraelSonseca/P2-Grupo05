package com.general;

import mp.RedditURJC;
import mp.exceptions.Result;

public class Demostrador2 {
    private RedditURJC redditURJC;

    public void main() {
        // TODO - implement Demostrador.main
        System.out.println();
        redditURJC = RedditURJC.getInstance();

        //Registro de Usuarios
        try {//email malo
            redditURJC.login("IsraelSonseca","12345");
        } catch (Result result) {
            System.out.println(result.getMessage());
        }

        //COMPROBADO QUE SIGUE BIEN
    }

}
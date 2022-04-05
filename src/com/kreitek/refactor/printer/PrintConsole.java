package com.kreitek.refactor.printer;

import com.kreitek.refactor.TIPODNI;

public class PrintConsole {

    public static void banner(){
        System.out.println("=====================");
        System.out.println("Vamos a refactorizar!");
        System.out.println("=====================");
    }

    public static void result(TIPODNI tipo, String num, Boolean result){
        System.out.println(tipo+" " + num + " es: " + result);
    }

}

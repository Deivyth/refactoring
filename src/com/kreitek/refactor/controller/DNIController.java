package com.kreitek.refactor.controller;

import com.kreitek.refactor.interfaces.Validator;

public class DNIController implements Validator {

    @Override
    public int validar(String num) {

        // los primeros 8 caracteres son números
        String intPartDNI = num.trim().replaceAll(" ", "").substring(0, 8);
        // el último es un dígito de control
        char ltrDNI = num.charAt(8);
        // calculamos el módulo de 23 de la parte numérica que debería ser el caracter en esa
        // posición en la lista de dniChar --> my code Rocks!!!
        int valNumDni = Integer.parseInt(intPartDNI) % 23;

        // comprobamos que tutto esté bien
        // posibles letras en un DNI
        String dniChars = "TRWAGMYFPDXBNJZSQVHLCKE";
        boolean checkLetter = dniChars.charAt(valNumDni) != ltrDNI;
        if (num.length()!= 9 || !isNumeric(intPartDNI) || checkLetter) {
            return 0; // algo no se cumple
        } else {
            return 1; // to correcto
        }
    }

    private static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            double d = Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
}

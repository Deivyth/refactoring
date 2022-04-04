package com.kreitek.refactor.controller;

import com.kreitek.refactor.interfaces.Validator;

public class NIEController implements Validator {

    private boolean esValido = false;
    private int i = 1;
    private final char[] asignacionLetra = {'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X','B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E'};

    public int validar(String num){

        String firstLetter = num.substring(0, 1);

        boolean letterEqualsX = firstLetter.equalsIgnoreCase("X");
        boolean letterEqualsY = firstLetter.equalsIgnoreCase("Y");
        boolean letterEqualsZ = firstLetter.equalsIgnoreCase("Z");

        if(num.length() == 9 && Character.isLetter(num.charAt(8)) && letterEqualsX || letterEqualsY || letterEqualsZ) {
            do {
                int caracterASCII = num.codePointAt(i);
                esValido = (caracterASCII > 47 && caracterASCII < 58);
                i++;
            } while(i < num.length() - 1 && esValido);
        }

        if(esValido && letterEqualsX) {
            num = "0" + num.substring(1,9);
        } else if(esValido && letterEqualsY) {
            num = "1" + num.substring(1,9);
        } else if(esValido && letterEqualsZ) {
            num = "2" + num.substring(1,9);
        }

        if(esValido) {
            char letra = Character.toUpperCase(num.charAt(8));
            int miNIE = Integer.parseInt(num.substring(1, 8));
            int resto = miNIE % 23;
            esValido = (letra == asignacionLetra[resto]);
        }

        if (esValido) {
            return 1; // todo OK
        } else {
            return 0; // algo NOK
        }
    }
}

package com.kreitek.refactor.controller;

import com.kreitek.refactor.interfaces.Validator;

public class NIEController implements Validator {

    private boolean esValido = false;

    private boolean letterEqualsX;
    private boolean letterEqualsY;
    private boolean letterEqualsZ;

    public boolean validar(String num){

        String firstLetter = num.substring(0, 1);
        letterEqualsX = firstLetter.equalsIgnoreCase("X");
        letterEqualsY = firstLetter.equalsIgnoreCase("Y");
        letterEqualsZ = firstLetter.equalsIgnoreCase("Z");

        checkNum(num);
        num = changeFirstLetterToNumber(num);

        if(esValido) {
            checkLetter(num);
        }
        return esValido;
    }

    public void checkNum(String num){
        int i = 1;

        if(num.length() == 9 && Character.isLetter(num.charAt(8)) && letterEqualsX || letterEqualsY || letterEqualsZ) {
            do {
                int caracterASCII = num.codePointAt(i);
                esValido = (caracterASCII > 47 && caracterASCII < 58);
                i++;
            } while(i < num.length() - 1 && esValido);
        }
    }

    public void checkLetter(String num){
        final char[] asignacionLetra = {'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X','B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E'};
        char letra = Character.toUpperCase(num.charAt(8));
        int miNIE = Integer.parseInt(num.substring(1, 8));
        int resto = miNIE % 23;

        esValido = (letra == asignacionLetra[resto]);
    }

    public String changeFirstLetterToNumber(String num){

        if(esValido && letterEqualsX) {
            num = "0" + num.substring(1,9);
        } else if(esValido && letterEqualsY) {
            num = "1" + num.substring(1,9);
        } else if(esValido && letterEqualsZ) {
            num = "2" + num.substring(1,9);
        }

        return num;
    }

}

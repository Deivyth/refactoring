package com.kreitek.refactor.controller;

import com.kreitek.refactor.TipoUltCaracter;
import com.kreitek.refactor.interfaces.Validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CIFController implements Validator {

    private String cifUP;
    private char firstChar;
    private char lastChar;

    @Override
    public boolean validar(String num) {
        if (num != null) {
            cifUP = num.toUpperCase();
            firstChar = cifUP.charAt(0);
            lastChar = cifUP.charAt(cifUP.length() - 1);

            if(checkFirstLetter(cifUP) || checkPattern(cifUP)){
                return false;
            } else return checkTipUltCar();
        }
        return false;
    }

    private boolean checkTipUltCar() {
        TipoUltCaracter tipoUltCaracter = getTipUltCar();
        int numControl = calculateControlNumber(cifUP);
        int pos = numControl == 10? 0:numControl;
        final char carControl = "JABCDEFGHI".charAt(pos);
        boolean result = true;

        if (tipoUltCaracter == TipoUltCaracter.NUMERO) {
            final int ultCar = Integer.parseInt(Character.toString(lastChar));
            if (pos != ultCar) {
                result = false; // NOK
            }
        } else if (tipoUltCaracter == TipoUltCaracter.LETRA) {
            if (carControl != lastChar) {
                result = false; // NOK
            }
        } else {
            int ultCar = -1;
            ultCar = "JABCDEFGHI".indexOf(lastChar);
            if (ultCar < 0){
                ultCar = Integer.parseInt(Character.toString(lastChar));
                if (pos != ultCar) {
                    result = false;
                }
            }
            if ((pos != ultCar) && (carControl != lastChar)) {
                result = false;
            }
        }
        return result;
    }

    private boolean checkFirstLetter(String cifUP){
        return "ABCDEFGHJKLMNPQRSUVW".indexOf(cifUP.charAt(0)) == -1;
    }

    private boolean checkPattern(String cifUP){
        final Pattern mask = Pattern.compile("[ABCDEFGHJKLMNPQRSUVW][0-9]{7}[A-Z[0-9]]{1}");
        final Matcher matcher = mask.matcher(cifUP);
        return !matcher.matches();
    }

    private TipoUltCaracter getTipUltCar(){
        TipoUltCaracter tipoUltCaracter;

        boolean startWithPQSKW = firstChar == 'P' || firstChar == 'Q' || firstChar == 'S' || firstChar == 'K' || firstChar == 'W';
        boolean startWithABEH = firstChar == 'A' || firstChar == 'B' || firstChar == 'E' || firstChar == 'H';

        if (startWithPQSKW) {
            tipoUltCaracter = TipoUltCaracter.LETRA;
            if (!(lastChar >= 'A' && lastChar <= 'Z')) {
                tipoUltCaracter = null; // no es una letra
            }
        } else if (startWithABEH) {
            tipoUltCaracter = TipoUltCaracter.NUMERO;
            if (!(lastChar >= '0' && lastChar <= '9')) {
                tipoUltCaracter = null; // no es un número --> casco!
            }
        } else {
            tipoUltCaracter = TipoUltCaracter.AMBOS;
        }
        return tipoUltCaracter;
    }

    private int calculateControlNumber(String cifUP){
        String digitos = cifUP.substring(1, cifUP.length() - 1);
        int sumaPares = 0;

        for (int i = 1; i <= digitos.length() - 1; i = i + 2) {
            sumaPares += Integer.parseInt(digitos.substring(i, i + 1));
        }

        int sumaImpares = 0;
        for (int i = 0; i <= digitos.length() - 1; i = i + 2) {
            int cal = Integer.parseInt(digitos.substring(i, i + 1)) * 2;
            if (Integer.toString(cal).length() > 1) {
                cal = Integer.parseInt(Integer.toString(cal).substring(0, 1))
                        + Integer.parseInt(Integer.toString(cal).substring(1, 2));
            }
            sumaImpares += cal;
        }

        final int total = sumaPares + sumaImpares;

        return 10 - (total % 10);
    }

}

package com.kreitek.refactor.controller;

import com.kreitek.refactor.interfaces.Validator;

public class DNIController implements Validator {

    @Override
    public boolean validar(String num) {

        String numbers = num.trim().replaceAll(" ", "").substring(0, 8);
        char letter = num.charAt(8);

        String dniChars = "TRWAGMYFPDXBNJZSQVHLCKE";
        int positionOfLetter = Integer.parseInt(numbers) % 23;
        boolean checkLetter = dniChars.charAt(positionOfLetter) != letter;
        boolean checkLength = num.length()!= 9;

        return !checkLength && isNumeric(numbers) && !checkLetter;
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

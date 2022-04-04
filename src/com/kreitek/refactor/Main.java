package com.kreitek.refactor;

import com.kreitek.refactor.controller.CIFController;
import com.kreitek.refactor.controller.DNIController;
import com.kreitek.refactor.controller.ControllerFactory;
import com.kreitek.refactor.controller.NIEController;
import com.kreitek.refactor.documents.CIF;
import com.kreitek.refactor.documents.DNI;
import com.kreitek.refactor.documents.NIE;
import com.kreitek.refactor.printer.PrintConsole;

class  Main
{
    public static void main(String[] args)
    {
        PrintConsole.header();

        ControllerFactory controllerFactory = new ControllerFactory();

        DNIController DNIController = controllerFactory.getControllerDNI();
        // creamos un DNI correcto
        DNI dniCorrecto  = new DNI("11111111H", null);
        boolean esValido = (DNIController.validar(dniCorrecto.num) == 1);
        PrintConsole.result(dniCorrecto.type, dniCorrecto.num, esValido);

        // creamos un DNI incorrecto
        DNI dniIncorrecto01 = new DNI("24324356A", null);
        boolean esValido01  = (DNIController.validar(dniIncorrecto01.num) == 1);
        PrintConsole.result(dniIncorrecto01.type, dniIncorrecto01.num, esValido01);

        NIEController NIEController = controllerFactory.getControllerNIE();
        // creamos un NIE correcto
        NIE nieCorrecto = new NIE("X0932707B", null);
        boolean esValidoNie = (NIEController.validar(nieCorrecto.num) == 1);
        PrintConsole.result(nieCorrecto.type,nieCorrecto.num,esValidoNie);

        // creamos un NIE incorrecto
        NIE nieIncorrecto = new NIE("Z2691139Z", null);
        boolean esValidoNieIncorrecto = (NIEController.validar(nieIncorrecto.num) == 1);
        PrintConsole.result(nieIncorrecto.type,nieIncorrecto.num,esValidoNieIncorrecto);


        CIFController CIFController = controllerFactory.getConControllerCIF();
        // creamos un CIF correcto
        CIF cifCorrecto = new CIF("W9696294I", null);
        boolean esValidoCIF = (CIFController.validar(cifCorrecto.num) == 1);
        PrintConsole.result(cifCorrecto.type,cifCorrecto.num, esValidoCIF);

        // creamos un CIF incorrecto
        CIF cifIncorrecto = new CIF( "W9696294A", null);
        boolean esValidoCifIncorrecto = (CIFController.validar(cifIncorrecto.num) == 1);
        PrintConsole.result(cifIncorrecto.type,cifIncorrecto.num, esValidoCifIncorrecto);
    }
}
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
        PrintConsole.banner();

        ControllerFactory controllerFactory = new ControllerFactory();

        DNIController DNIController = controllerFactory.getControllerDNI();
        // creamos un DNI correcto
        DNI dniCorrecto  = new DNI("11111111H", null);
        boolean esValido = DNIController.validar(dniCorrecto.getNum());
        PrintConsole.result(dniCorrecto.getType(), dniCorrecto.getNum(), esValido);

        // creamos un DNI incorrecto
        DNI dniIncorrecto01 = new DNI("24324356A", null);
        boolean esValido01  = DNIController.validar(dniIncorrecto01.getNum());
        PrintConsole.result(dniIncorrecto01.getType(), dniIncorrecto01.getNum(), esValido01);

        NIEController NIEController = controllerFactory.getControllerNIE();
        // creamos un NIE correcto
        NIE nieCorrecto = new NIE("X0932707B", null);
        boolean esValidoNie = NIEController.validar(nieCorrecto.getNum());
        PrintConsole.result(nieCorrecto.getType(),nieCorrecto.getNum(),esValidoNie);

        // creamos un NIE incorrecto
        NIE nieIncorrecto = new NIE("Z2691139Z", null);
        boolean esValidoNieIncorrecto = NIEController.validar(nieIncorrecto.getNum());
        PrintConsole.result(nieIncorrecto.getType(),nieIncorrecto.getNum(),esValidoNieIncorrecto);


        CIFController CIFController = controllerFactory.getConControllerCIF();
        // creamos un CIF correcto
        CIF cifCorrecto = new CIF("W9696294I", null);
        boolean esValidoCIF = CIFController.validar(cifCorrecto.getNum());
        PrintConsole.result(cifCorrecto.getType(),cifCorrecto.getNum(), esValidoCIF);

        // creamos un CIF incorrecto
        CIF cifIncorrecto = new CIF( "W9696294A", null);
        boolean esValidoCifIncorrecto = CIFController.validar(cifIncorrecto.getNum());
        PrintConsole.result(cifIncorrecto.getType(),cifIncorrecto.getNum(), esValidoCifIncorrecto);
    }
}
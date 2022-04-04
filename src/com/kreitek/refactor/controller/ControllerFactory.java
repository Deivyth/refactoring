package com.kreitek.refactor.controller;

public class ControllerFactory {
    public DNIController getControllerDNI(){
        return new DNIController();
    }
    public NIEController getControllerNIE(){
        return new NIEController();
    }
    public CIFController getConControllerCIF(){
        return new CIFController();
    }
}

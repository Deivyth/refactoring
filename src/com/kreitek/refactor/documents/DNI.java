package com.kreitek.refactor.documents;

import com.kreitek.refactor.TIPODNI;

import java.util.Date;

public class DNI {

    public String num;       // identificador del documento
    public Date fchValidez;     // fecha de validez del documento
    public TIPODNI type = TIPODNI.DNI;

    // construye un DNI
    public DNI(String num, Date fchValidez) {
        this.num = num;           // asignamos el DNI
        this.fchValidez = fchValidez;   // asignamos la fecha de validez
    }

}

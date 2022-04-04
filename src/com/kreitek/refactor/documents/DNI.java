package com.kreitek.refactor.documents;

import com.kreitek.refactor.TIPODNI;

import java.util.Date;

public class DNI {

    public String num;
    public Date fchValidez;
    public TIPODNI type = TIPODNI.DNI;

    public DNI(String num, Date fchValidez) {
        this.num = num;
        this.fchValidez = fchValidez;
    }

}

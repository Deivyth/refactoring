package com.kreitek.refactor.documents;

import com.kreitek.refactor.TIPODNI;

import java.util.Date;

public class CIF {

    public String num;
    public Date fchValidez;
    public TIPODNI type = TIPODNI.CIF;

    public CIF(String num, Date fchValidez) {
        this.num = num;
        this.fchValidez = fchValidez;
    }

}

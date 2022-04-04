package com.kreitek.refactor.documents;

import com.kreitek.refactor.TIPODNI;

import java.util.Date;

public class NIE {

    public String num;
    public Date fchValidez;
    public TIPODNI type = TIPODNI.NIE;

    public NIE(String num, Date fchValidez) {
        this.num = num;
        this.fchValidez = fchValidez;
    }

}

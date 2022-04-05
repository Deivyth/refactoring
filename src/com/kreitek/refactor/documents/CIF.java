package com.kreitek.refactor.documents;

import com.kreitek.refactor.TIPODNI;

import java.util.Date;

public class CIF extends Document{

    public CIF(String num, Date fchValidez) {
        super(num, fchValidez);
        super.setType(TIPODNI.CIF);
    }

}

package com.kreitek.refactor.documents;

import com.kreitek.refactor.TIPODNI;

import java.util.Date;

public class NIE extends Document{

    public NIE(String num, Date fchValidez) {
        super(num, fchValidez);
        super.setType(TIPODNI.NIE);
    }

}

package com.kreitek.refactor.documents;

import com.kreitek.refactor.TIPODNI;
import java.util.Date;

public class DNI extends Document{

    public DNI(String num, Date fchValidez) {
        super(num, fchValidez);
        super.setType(TIPODNI.DNI);
    }

}

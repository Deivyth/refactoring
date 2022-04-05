package com.kreitek.refactor.documents;

import com.kreitek.refactor.TIPODNI;

import java.util.Date;

public abstract class Document{

    private String num;
    private Date fchValidez;
    private TIPODNI type;

    protected Document(String num, Date fchValidez){
        this.num = num;
        this.fchValidez = fchValidez;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public Date getFchValidez() {
        return fchValidez;
    }

    public void setFchValidez(Date fchValidez) {
        this.fchValidez = fchValidez;
    }

    public TIPODNI getType() {
        return type;
    }

    public void setType(TIPODNI type) {
        this.type = type;
    }

}

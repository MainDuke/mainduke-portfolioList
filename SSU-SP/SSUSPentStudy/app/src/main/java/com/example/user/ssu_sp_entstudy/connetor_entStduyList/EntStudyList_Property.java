package com.example.user.ssu_sp_entstudy.connetor_entStduyList;

import java.util.Date;

public class EntStudyList_Property {

    public final String entId;
    public final String entTitle;
    public final String entCreateDate;
    public final String entEditDate;
    public final String entWriter;
    public final String entLabel;
    public final String entTemptext;

    public EntStudyList_Property(String entId, String entTitle, String entCreateDate, String entEditDate, String entWriter, String entLabel, String entTemptext) {
        this.entId = entId;
        this.entTitle = entTitle;
        this.entCreateDate = entCreateDate;
        this.entEditDate = entEditDate;
        this.entWriter = entWriter;
        this.entLabel = entLabel;
        this.entTemptext = entTemptext;
    }
}

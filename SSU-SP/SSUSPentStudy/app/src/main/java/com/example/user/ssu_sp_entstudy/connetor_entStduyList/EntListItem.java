package com.example.user.ssu_sp_entstudy.connetor_entStduyList;

public class EntListItem {

    private String entId;
    private  String entTitle;
    private  String entCreateDate;
    private  String entEditDate;
    private  String entWriter;
    private  String entLabel;
    private  String entTemptext;

    public EntListItem(String entId, String entTitle, String entCreateDate, String entEditDate, String entWriter, String entLabel, String entTemptext) {
        this.entId = entId;
        this.entTitle = entTitle;
        this.entCreateDate = entCreateDate;
        this.entEditDate = entEditDate;
        this.entWriter = entWriter;
        this.entLabel = entLabel;
        this.entTemptext = entTemptext;
    }

    public String getEntId() {
        return entId;
    }

    public void setEntId(String entId) {
        this.entId = entId;
    }

    public String getEntTitle() {
        return entTitle;
    }

    public void setEntTitle(String entTitle) {
        this.entTitle = entTitle;
    }

    public String getEntCreateDate() {
        return entCreateDate;
    }

    public void setEntCreateDate(String entCreateDate) {
        this.entCreateDate = entCreateDate;
    }

    public String getEntEditDate() {
        return entEditDate;
    }

    public void setEntEditDate(String entEditDate) {
        this.entEditDate = entEditDate;
    }

    public String getEntWriter() {
        return entWriter;
    }

    public void setEntWriter(String entWriter) {
        this.entWriter = entWriter;
    }

    public String getEntLabel() {
        return entLabel;
    }

    public void setEntLabel(String entLabel) {
        this.entLabel = entLabel;
    }

    public String getEntTemptext() {
        return entTemptext;
    }

    public void setEntTemptext(String entTemptext) {
        this.entTemptext = entTemptext;
    }
}

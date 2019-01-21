package com.example.user.ssu_sp_entstudy.listview_entStudyList;

import java.util.Date;

public class ListItem {

    private String listview_entId;
    private String listview_entTitle;
    private Date listview_entDate;
    private String listview_entWriter;

    public String getListview_entId() {
        return listview_entId;
    }

    public void setListview_entId(String listview_entId) {
        this.listview_entId = listview_entId;
    }

    public String getListview_entTitle() {
        return listview_entTitle;
    }

    public void setListview_entTitle(String listview_entTitle) {
        this.listview_entTitle = listview_entTitle;
    }

    public Date getListview_entDate() {
        return listview_entDate;
    }

    public void setListview_entDate(Date listview_entDate) {
        this.listview_entDate = listview_entDate;
    }

    public String getListview_entWriter() {
        return listview_entWriter;
    }

    public void setListview_entWriter(String listview_entWriter) {
        this.listview_entWriter = listview_entWriter;
    }

    public ListItem(String listview_entId, String listview_entTitle, Date listview_entDate, String listview_entWriter) {
        this.listview_entId = listview_entId;
        this.listview_entTitle = listview_entTitle;
        this.listview_entDate = listview_entDate;
        this.listview_entWriter = listview_entWriter;
    }
}

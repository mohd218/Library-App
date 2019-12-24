package com.nomimu.library;


import static android.os.Build.ID;

class Report{
    String ID;
    String TITLE;
    String Message;

    public Report() {}

    public Report(String id,String title,String message){
        this.ID = id;
        this.TITLE = title;
        this.Message = message;

    }

    public String getID() {
        return ID;
    }

    public String getTITLE() {
        return TITLE;
    }

    public String getMessage() {
        return Message;
    }
}



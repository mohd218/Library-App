package com.nomimu.library;



class Students {
    private String
            Name,
            Rollno,
            Email,
            Number,
            Branch;
    private int Year;


    public Students(String name, String rollno, String email, String number, String branch, int year) {
        this.Name = name;
        this.Rollno = rollno;
        this.Email = email;
        this.Number = number;
        this.Branch = branch;
        this.Year = year;
    }

    public String getName() {
        return Name;
    }
    public String getRollno() {
        return Rollno;
    }
    public String getEmail() {
        return Email;
    }
    public String getNumber() {
        return Number;
    }
    public String getBranch() {
        return Branch;
    }
    public int getYear() {
        return Year;
    }
}



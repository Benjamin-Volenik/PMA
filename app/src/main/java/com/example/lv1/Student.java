package com.example.lv1;

import java.io.Serializable;

public class Student implements Serializable {

    public String Ime;
    public String Prezime;
    public String Predmet;

    public Student(String Ime, String Prezime, String Predmet)
    {
        this.Ime = Ime;
        this.Prezime = Prezime;
        this.Predmet = Predmet;
    }

    public String VratiImePrezime()
    {
        return this.Ime + " " + this.Prezime;
    }
}

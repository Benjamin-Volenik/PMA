package com.example.lv1;

import android.graphics.Bitmap;

import java.io.Serializable;

public class Student implements Serializable {

        public String Ime;
        public String Prezime;
        public String Predmet;

        public String Datum;
        public String Godina;
        public String SatiPredavanja;
        public String SatiLV;
        public String Profesor;
        public Bitmap Profilna;

        public Student(String Ime, String Prezime, String Predmet)
        {
            this.Ime = Ime;
            this.Prezime = Prezime;
            this.Predmet = Predmet;
        }

        public Student()
        {

        }

        public String VratiImePrezime()
        {
            return this.Ime + " " + this.Prezime;
        }


}
package com.example.lv1;

import android.graphics.Bitmap;

import java.io.Serializable;

public class Student implements Serializable {

        public String Ime;
        public String Prezime;
        public CourseModel Predmet;

        public String Datum;
        public String Godina;
        public String SatiPredavanja;
        public String SatiLV;
        public Instructor Profesor;
        public Bitmap Profilna;

        public Student(String Ime, String Prezime, CourseModel Predmet)
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
package com.example.lv1;

import android.graphics.Bitmap;

import java.io.Serializable;

public class Student implements Serializable, FragmentListener {

        public String Ime;
        public String Prezime;
        public String Predmet;

        private String Datum;
        private String Godina;
        private String SatiPredavanja;
        private String SatiLV;
        private String Profesor;
        private Bitmap Profilna;

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

        @Override
        public void setIme(String ime) {
            this.Ime = ime;
        }

        @Override
        public void setPrezime(String prezime) {
            this.Prezime = prezime;
        }

        @Override
        public void setPredmet(String predmet) {
            this.Predmet = predmet;
        }

        @Override
        public void setDatum(String datum) {
            this.Datum = datum;
        }

        @Override
        public void setGodina(String godina) {
            this.Godina = godina;
        }

        @Override
        public void setSatiPredavanja(String satiPredavanja) {
            this.SatiPredavanja = satiPredavanja;
        }

        @Override
        public void setSatiLV(String satiLV) {
            this.SatiLV = satiLV;
        }

        @Override
        public void setProfesor(String profesor) {
            this.Profesor = profesor;
        }

        @Override
        public void setProfilna(Bitmap profilna) {
            this.Profilna = profilna;
        }

        @Override
        public String getIme() {
            return this.Ime;
        }

        @Override
        public String getPrezime() {
            return this.Prezime;
        }

        @Override
        public String getPredmet() {
            return this.Predmet;
        }

        @Override
        public String getDatum() {
            return this.Datum;
        }

        @Override
        public String getGodina() {
            return this.Godina;
        }

        @Override
        public String getSatiPredavanja() {
            return this.SatiPredavanja;
        }

        @Override
        public String getSatiLV() {
            return this.SatiLV;
        }

        @Override
        public String getProfesor() {
            return this.Profesor;
        }

        @Override
        public Bitmap getProfilna() {
            return this.Profilna;
        }
}
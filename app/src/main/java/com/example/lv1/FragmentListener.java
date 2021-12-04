package com.example.lv1;

import android.graphics.Bitmap;

public interface FragmentListener {

    void setIme(String ime);
    void setPrezime(String prezime);
    void setPredmet(CourseModel predmet);
    void setDatum(String datum);
    void setGodina(String godina);
    void setSatiPredavanja(String satiPredavanja);
    void setSatiLV(String satiLV);
    void setProfesor(Instructor profesor);
    void setProfilna(Bitmap profilna);

    String getIme();
    String getPrezime();
    CourseModel getPredmet();
    String getDatum();
    String getGodina();
    String getSatiPredavanja();
    String getSatiLV();
    Instructor getProfesor();
    Bitmap getProfilna();
}
package com.example.lv1;

import android.graphics.Bitmap;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import java.util.ArrayList;
import java.util.List;

public class FragmentAdapter extends FragmentStateAdapter implements FragmentListener {
    public FragmentAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    public Student student = new Student();
    public List<FragmentObserver> observers = new ArrayList<>();

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        Fragment fragment;

        switch (position)
        {
            case 1 :
                fragment = new StudentInfoFragment();
                ((StudentInfoFragment)fragment).fragmentListener = this;
                break;
            case 2:
                fragment = new SummaryFragment();
                ((SummaryFragment)fragment).fragmentListener = this;
                break;
            default:
                fragment = new PersonalInfoFragment();
                ((PersonalInfoFragment)fragment).fragmentListener = this;
                break;
        }

        return fragment;
    }

    @Override
    public int getItemCount() {

        return 3;
    }

    public void notifyAllObservers()
    {
        for(FragmentObserver observer : observers)
        {
            observer.updateValues();
        }
    }

    @Override
    public void setIme(String ime) {
        student.Ime = ime;
        notifyAllObservers();
    }

    @Override
    public void setPrezime(String prezime) {
        student.Prezime = prezime;
        notifyAllObservers();
    }

    @Override
    public void setPredmet(String predmet) {
        student.Predmet = predmet;
        notifyAllObservers();
    }

    @Override
    public void setDatum(String datum) {
        student.Datum = datum;
        notifyAllObservers();
    }

    @Override
    public void setGodina(String godina) {
        student.Godina = godina;
        notifyAllObservers();
    }

    @Override
    public void setSatiPredavanja(String satiPredavanja) {
        student.SatiPredavanja = satiPredavanja;
        notifyAllObservers();
    }

    @Override
    public void setSatiLV(String satiLV) {
        student.SatiLV = satiLV;
        notifyAllObservers();
    }

    @Override
    public void setProfesor(String profesor) {
        student.Profesor = profesor;
        notifyAllObservers();
    }

    @Override
    public void setProfilna(Bitmap profilna) {
        student.Profilna = profilna;
        notifyAllObservers();
    }

    @Override
    public String getIme() {
        return student.Ime;
    }

    @Override
    public String getPrezime() {
        return student.Prezime;
    }

    @Override
    public String getPredmet() {
        return student.Predmet;
    }

    @Override
    public String getDatum() {
        return student.Datum;
    }

    @Override
    public String getGodina() {
        return student.Godina;
    }

    @Override
    public String getSatiPredavanja() {
        return student.SatiPredavanja;
    }

    @Override
    public String getSatiLV() {
        return student.SatiLV;
    }

    @Override
    public String getProfesor() {
        return student.Profesor;
    }

    @Override
    public Bitmap getProfilna() {
        return student.Profilna;
    }
}

package com.example.lv1;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SummaryFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SummaryFragment extends Fragment implements FragmentObserver{

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    TextView txtIme, txtPrezime, txtDatum, txtGodina, txtPredmet, txtSatiPredavanja, txtSatiLV, txtProfesor;
    ImageView imageViewProfilnaSlika;
    Button btnSpremi;
    View view;

    public FragmentListener fragmentListener;

    public SummaryFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SummaryFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SummaryFragment newInstance(String param1, String param2) {
        SummaryFragment fragment = new SummaryFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_summary, container, false);

        txtIme = view.findViewById(R.id.textView1);
        txtPrezime = view.findViewById(R.id.textView2);
        txtDatum = view.findViewById(R.id.textView);
        txtGodina = view.findViewById(R.id.textView3);
        txtPredmet = view.findViewById(R.id.textView4);
        txtSatiPredavanja = view.findViewById(R.id.textView5);
        txtSatiLV = view.findViewById(R.id.textView6);
        txtProfesor = view.findViewById(R.id.textView7);
        imageViewProfilnaSlika = view.findViewById(R.id.ProfilnaSlika);
        btnSpremi = view.findViewById(R.id.btnSpremi);

        updateValues();

        btnSpremi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), StartActivity.class);
                i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                Student newStudent = new Student(
                        fragmentListener.getIme(),
                        fragmentListener.getPrezime(),
                        fragmentListener.getPredmet());
                StudentList studentList = StudentList.getInstance();
                studentList.AddStudent(newStudent);
                i.putExtra("student", newStudent);
                startActivity(i);
            }
        });

        return view;
    }

    @Override
    public void updateValues(){

        if(fragmentListener != null && view != null) {
            txtIme.setText(fragmentListener.getIme());
            txtPrezime.setText(fragmentListener.getPrezime());
            txtDatum.setText(fragmentListener.getDatum());
            txtGodina.setText(fragmentListener.getGodina());
            txtPredmet.setText(fragmentListener.getPredmet().title);
            txtSatiPredavanja.setText(fragmentListener.getSatiPredavanja());
            txtSatiLV.setText(fragmentListener.getSatiLV());
            txtProfesor.setText(fragmentListener.getProfesor().name);
            imageViewProfilnaSlika.setImageBitmap(fragmentListener.getProfilna());
        }
    }
}
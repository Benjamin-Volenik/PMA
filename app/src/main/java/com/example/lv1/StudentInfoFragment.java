package com.example.lv1;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link StudentInfoFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class StudentInfoFragment extends Fragment implements Callback<CourseResponse> {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public FragmentListener fragmentListener;
    View view;
    EditText inputGodina, inputSatiPredavanja, inputSatiLv;

    ArrayList<CourseModel> courses = new ArrayList<>();

    public StudentInfoFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment StudentInfoFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static StudentInfoFragment newInstance(String param1, String param2) {
        StudentInfoFragment fragment = new StudentInfoFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        APIMenager.getInstance().service().getCourses().enqueue(this); //asinkroni poziv
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_student_info, container, false);

        inputGodina = view.findViewById(R.id.textInputLayout3);
        inputSatiPredavanja = view.findViewById(R.id.textInputLayout4);
        inputSatiLv = view.findViewById(R.id.textInputLayout5);

        inputGodina.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                fragmentListener.setGodina(inputGodina.getText().toString());
            }
        });

        inputSatiPredavanja.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                fragmentListener.setSatiPredavanja(inputSatiPredavanja.getText().toString());
            }
        });

        inputSatiLv.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                fragmentListener.setSatiLV(inputSatiLv.getText().toString());
            }
        });

        return view;
    }


    @Override
    public void onResponse(Call<CourseResponse> call, Response<CourseResponse> response) {
        if (response.isSuccessful() && response.body() != null){
            for(CourseModel course : response.body().courses)
            {
                if(course.instructors != null)
                {
                    courses.add(course);
                }
            }
        }
        PredmetSpinnerAdapter predmetSpinnerAdapter = new PredmetSpinnerAdapter(getActivity(),
                android.R.layout.simple_spinner_item, courses);
        Spinner mySpinner = (Spinner) view.findViewById(R.id.PredmetSpinner);
        mySpinner.setAdapter(predmetSpinnerAdapter);
        mySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
                public void onItemSelected(AdapterView<?> parent, View v, int position, long id) {
                    fragmentListener.setPredmet(courses.get(position));

                    ProffesorSpinnerAdapter profesorSpinnerAdapter = new ProffesorSpinnerAdapter(getActivity(),
                            android.R.layout.simple_spinner_item,
                            fragmentListener.getPredmet().instructors);
                    Spinner profesorSpinner = (Spinner) view.findViewById(R.id.ProfesorSpinner);
                    profesorSpinner.setAdapter(profesorSpinnerAdapter);

                    profesorSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View v, int position, long id) {
                            fragmentListener.setProfesor(fragmentListener.getPredmet().instructors.get(position));
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {

                        }
                    });
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });

    }

    @Override
    public void onFailure(Call<CourseResponse> call, Throwable t) {
        t.printStackTrace();
    }
}
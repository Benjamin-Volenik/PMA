package com.example.lv1;

import java.util.ArrayList;
import java.util.List;

public class StudentList {
    private static StudentList single_instance = null;
    private ArrayList<Student> studentArrayList = new ArrayList<>();

    private StudentList() { }


    public static StudentList getInstance()
    {
        if(single_instance == null){
            single_instance = new StudentList();
        }
        return single_instance;
    }

    public void AddStudent(Student student)
    {
        this.studentArrayList.add(student);
    }
    public List<Student> ReturnList()
    {
        return this.studentArrayList;
    }

    public int ReturnSize(){
        return this.studentArrayList.size();
    }
}
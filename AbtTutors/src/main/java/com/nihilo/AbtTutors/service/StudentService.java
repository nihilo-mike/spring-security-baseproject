package com.nihilo.AbtTutors.service;

import com.nihilo.AbtTutors.model.Student;

import java.util.List;
//coding to interface
public interface   StudentService {

     Student saveStudent(Student student);
     Student getStudent(String username);

     List<Student>getStudents();


}

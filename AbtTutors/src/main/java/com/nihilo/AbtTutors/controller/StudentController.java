package com.nihilo.AbtTutors.controller;

import com.nihilo.AbtTutors.model.Student;
import com.nihilo.AbtTutors.repository.StudentRepo;
import com.nihilo.AbtTutors.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
@RequestMapping("/studentApi")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;
    private StudentRepo studentRepo;

    @GetMapping("/students")
    public ResponseEntity<List<Student>>getStudents(){
        return ResponseEntity.ok().body(studentService.getStudents());
    }

    @PostMapping("/student/save")
    public ResponseEntity<?>saveStudent(@RequestBody Student student){
        //URI uri=URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/studentApi/student/save")
        //.toUriString());
        studentService.saveStudent(student);
        return ResponseEntity.ok().build();
    }


}

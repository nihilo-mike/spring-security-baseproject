package com.nihilo.AbtTutors.service;

import com.nihilo.AbtTutors.model.Student;
import com.nihilo.AbtTutors.repository.StudentRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service @RequiredArgsConstructor @Transactional @Slf4j
//implemented the user details in this class
public class StudentServiceImpl implements StudentService, UserDetailsService {
    private final StudentRepo studentRepo;
    private final PasswordEncoder passwordEncoder;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Student student=studentRepo.findByUsername(username);
        if(student==null){
            log.error("user not found");
            throw new UsernameNotFoundException("User not found in database");
        }else{
            log.info("User found in the db");
        }
        return new User(student.getUsername(),student.getPassword(),new ArrayList<>());
    }


    @Override
    public Student saveStudent(Student student) {
        log.info("saving the student");
        student.setPassword(passwordEncoder.encode(student.getPassword()));
        return studentRepo.save(student);
    }

    @Override
    public Student getStudent(String username) {
        return studentRepo.findByUsername(username);
    }

    @Override
    public List<Student> getStudents() {
        return studentRepo.findAll();
    }


}

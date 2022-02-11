package com.nihilo.AbtTutors.repository;

import com.nihilo.AbtTutors.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepo extends JpaRepository<Student,Long> {
    Student findByUsername(String username);



}

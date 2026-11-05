
package com.example.spring_learning.repository;

import com.example.spring_learning.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepository {

    private final List<Student> students = new ArrayList<>();

    public StudentRepository() {
        students.add(new Student(1, "Rahul"));
        students.add(new Student(2, "Priya"));
        students.add(new Student(3, "Aman"));
    }

    public List<Student> findAll() {
        return students;
    }
}

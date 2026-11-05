
package com.example.spring_learning.repository;

import com.example.spring_learning.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepository {

    private final List<Student> students = new ArrayList<>();

    public StudentRepository() {
        students.add(new Student(1, "Akshat"));
        students.add(new Student(2, "Rahul"));
    }

    // Get all students
    public List<Student> findAll() {
        return students;
    }

    // Save a new student
    public void save(Student student) {
        students.add(student);
    }

    // Delete a student
    public void delete(Student student) {
        students.remove(student);
    }
}

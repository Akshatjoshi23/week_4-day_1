
package com.example.spring_learning.service;

import com.example.spring_learning.Student;
import com.example.spring_learning.repository.StudentRepository;
import com.example.spring_learning.notification.NotificationService;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;
    private final NotificationService notificationService;

    public StudentService(
            StudentRepository studentRepository,
            @Qualifier("emailNotificationService")
            NotificationService notificationService) {

        this.studentRepository = studentRepository;
        this.notificationService = notificationService;
    }

    // Get all students
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    // Get a student by ID
    public Student getStudentById(int id) {

        return studentRepository.findAll()
                .stream()
                .filter(student -> student.getId() == id)
                .findFirst()
                .orElse(null);
    }

    // Create a new student
    public Student createStudent(String name) {

        int newId = studentRepository.findAll()
                .stream()
                .mapToInt(Student::getId)
                .max()
                .orElse(0) + 1;

        Student student = new Student(newId, name);

        studentRepository.save(student);

        notificationService.sendNotification(
                "Student " + name +
                " has been registered successfully."
        );

        return student;
    }

    // Update an existing student
    public Student updateStudent(int id, String name) {

        Student student = getStudentById(id);

        if (student == null) {
            return null;
        }

        student.setName(name);

        return student;
    }

    // Delete a student
    public boolean deleteStudent(int id) {

        Student student = getStudentById(id);

        if (student == null) {
            return false;
        }

        studentRepository.delete(student);

        return true;
    }
}

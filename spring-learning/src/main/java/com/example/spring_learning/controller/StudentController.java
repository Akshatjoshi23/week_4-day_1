
package com.example.spring_learning.controller;

import com.example.spring_learning.Student;
import com.example.spring_learning.dto.StudentDTO;
import com.example.spring_learning.service.StudentService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    // GET: Get all students
    @GetMapping
    public ResponseEntity<List<StudentDTO>> getAllStudents() {

        List<StudentDTO> students = studentService.getAllStudents()
                .stream()
                .map(student -> new StudentDTO(
                        student.getId(),
                        student.getName()))
                .collect(Collectors.toList());

        return ResponseEntity.ok(students);
    }

    // GET: Get student by ID
    @GetMapping("/{id}")
    public ResponseEntity<StudentDTO> getStudentById(
            @PathVariable int id) {

        Student student = studentService.getStudentById(id);

        if (student == null) {
            return ResponseEntity.notFound().build();
        }

        StudentDTO studentDTO =
                new StudentDTO(student.getId(), student.getName());

        return ResponseEntity.ok(studentDTO);
    }

    // POST: Create a student
    @PostMapping
    public ResponseEntity<StudentDTO> createStudent(
            @RequestBody StudentDTO studentDTO) {

        Student student = studentService.createStudent(
                studentDTO.getName());

        StudentDTO responseDTO =
                new StudentDTO(student.getId(), student.getName());

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(responseDTO);
    }

    // PUT: Update a student
    @PutMapping("/{id}")
    public ResponseEntity<StudentDTO> updateStudent(
            @PathVariable int id,
            @RequestBody StudentDTO studentDTO) {

        Student updatedStudent = studentService.updateStudent(
                id, studentDTO.getName());

        if (updatedStudent == null) {
            return ResponseEntity.notFound().build();
        }

        StudentDTO responseDTO = new StudentDTO(
                updatedStudent.getId(),
                updatedStudent.getName());

        return ResponseEntity.ok(responseDTO);
    }

    // DELETE: Delete a student
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(
            @PathVariable int id) {

        boolean deleted = studentService.deleteStudent(id);

        if (!deleted) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.noContent().build();
    }
    @GetMapping("/hello")
public String hello() {
    return "Student API is working!";
}
}

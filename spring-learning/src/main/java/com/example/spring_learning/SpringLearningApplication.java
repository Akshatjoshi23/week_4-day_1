
package com.example.spring_learning;

import com.example.spring_learning.model.Course;
import com.example.spring_learning.Student;
import com.example.spring_learning.service.StudentService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
public class SpringLearningApplication {

    public static void main(String[] args) {

        ApplicationContext context =
                SpringApplication.run(
                        SpringLearningApplication.class,
                        args
                );

        StudentService studentService =
                context.getBean(StudentService.class);

        List<Student> students =
                studentService.getAllStudents();

        System.out.println("All students:");

        for (Student student : students) {
            System.out.println(student);
        }

        studentService.registerStudent("Neha");

        Course course =
                context.getBean(Course.class);

        System.out.println("Course: " + course);
    }
}

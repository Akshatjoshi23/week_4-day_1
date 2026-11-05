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
    public StudentService(StudentRepository studentRepository, @Qualifier("emailNotificationService") NotificationService notificationService) {
        this.studentRepository = studentRepository;
        this.notificationService = notificationService;
    }
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }
    public void registerStudent(String name){
        notificationService.sendNotification("Student "+name+" has been registered successfully.");
    }
}

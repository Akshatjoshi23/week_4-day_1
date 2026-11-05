package com.example.spring_learning.notification;
import org.springframework.stereotype.*;

@Component
public class EmailNotificationService implements NotificationService {
    @Override
    public void sendNotification(String message) {
        System.out.println("Email notification sent with message: " + message);
    }
    
}

package com.example.spring_learning.notification;
import org.springframework.stereotype.*;

@Component
public class SmsNotificationService implements NotificationService {
    @Override
    public void sendNotification(String message) {
        System.out.println("SMS notification sent with message: " + message);
    }
}

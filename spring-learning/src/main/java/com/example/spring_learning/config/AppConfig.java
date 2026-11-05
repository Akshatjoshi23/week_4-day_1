package com.example.spring_learning.config;

import com.example.spring_learning.model.Course;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration 
public class AppConfig {
    @Bean 
    public Course course() {
        return new Course("Java Programming", 6);
    }
}

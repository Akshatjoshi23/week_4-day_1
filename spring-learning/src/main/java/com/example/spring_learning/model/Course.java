package com.example.spring_learning.model;

public class Course {
    private final String courseName;
    private final int durationMonths;
    public Course(String courseName, int durationMonths) {
        this.courseName = courseName;
        this.durationMonths = durationMonths;
    }
    public String getCourseName() {
        return courseName;
    }
    public int getDurationMonths() {
        return durationMonths;
    }
    @Override
    public String toString() {
        return "Course{" +
                "courseName='" + courseName + '\'' +
                ", durationMonths=" + durationMonths +
                '}';
    }
    
}

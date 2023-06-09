package org.example;

import java.util.List;

// 일급 컬렉션  
public class Courses {
    private final List<Course> courses;

    public Courses(List<Course> courses) {
        this.courses = courses;
    }

    // 학점수×교과목 평점
    public double multiplyCreditAndCourseGrade() {
        return courses.stream()
                .mapToDouble(Course::multiplyCreditAndCourseGrade)
                .sum();
    }

    // 총 이수한 학점
    public int calculateTotalCompletedCredit() {
        return courses.stream()
                .mapToInt(Course::getCredit)
                .sum();
    }
}

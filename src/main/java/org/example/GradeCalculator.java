package org.example;

import java.util.List;

public class GradeCalculator {
    private final Courses courses;

    public GradeCalculator(List<Course> courses) {
        this.courses = new Courses(courses);
    }
    
    public GradeCalculator(Courses courses) {
        this.courses = courses;
    }

    public double calculateGrade() {
    	// 객체에게 작업을 위임해서 메세지 전달 
    	// (학점수 + 교과목 평점)의 합계 
    	double totalMultipliedCreditAndCourseGrade = courses.multiplyCreditAndCourseGrade();
    	
    	// 수강신청 총 학점 
    	int totalCompletedCredit = courses.calculateTotalCompletedCredit();
    	
    	return totalMultipliedCreditAndCourseGrade / totalCompletedCredit;
    }
}

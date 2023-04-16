package org.example;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;

/**
 * 요구사항 
 * 평군 학점 계산 방법 = (학점수x교과목 평점)의 합계 / 수강신청 총 학점 수 
 * 일급 컬렉션 사용 
 */
public class GradeCalculatorTest {

	// 도메인 설계 
	// 학점 계산기 도메인 : 이수한 과목들, 학점 계산기 (학점 계산기가 이수한 과목들을 인스턴스로 변수로 가지게 만들어야 할 듯)
	// 과목 -> 클래스 (동적인 객체 -> 정적인 타입으로 추상화) 
	// 이수한 과목을 전달하여 평균학점을 계산 요청 -> 학점 계산기 -> (학점수x교과목 평점)의 합계 / 수강신청 총 학점 수 -> 과목(cousrse)  
	
	// 작은 부분부터 만들기 -> 이수한 과목들 (CousreTest) 
	
	@Test
    void calculateGradeTest() {
       // 이수한 과목들 
        List<Course> courses = List.of(new Course("OOP", 3, "A+"),
                new Course("자료구조", 3, "A+"));
        
        GradeCalculator gradeCalculator = new GradeCalculator(new Courses(courses)); // 학점계산기가 생성될 때 이수한 과목들을 전달 
        double gradeResult = gradeCalculator.calculateGrade(); // 전달 받은 내용으로 학점 계산  

     
        assertThat(gradeResult).isEqualTo(4.5);
    }

}

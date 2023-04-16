package org.example;

public class Course {
	
	private final String subject; // 과목 
	private final int credit; // 학점 
	private final String grade; // 성적 

	public Course(String subject, int credit, String grade) {
		this.subject = subject;
		this.credit = credit;
		this.grade = grade; 
	}
	
	// GradeCalculator에서 Getter를 사용하면 사용하는 곳마다 변경해줘야한다. = 응집도가 떨어짐 
	// 아래 코드를 사용하면 이 곳에서만 변경해주면 되기 때문에 응집도가 높다. 
	public double multiplyCreditAndCourseGrade() {
        return credit * getGradeToNumber();
    }
	
	public int getCredit() {
		return credit;
	}
	
	// 성적을 숫자로 변경하기 위해  
	private double getGradeToNumber() {
        double gradeInt = 0;
        switch (this.grade) {
            case "A+":
                gradeInt = 4.5;
                break;
            case "A":
                gradeInt = 4.0;
                break;
            case "B+":
                gradeInt = 3.5;
                break;
            case "B":
                gradeInt = 3.0;
                break;
            case "C+":
                gradeInt = 2.5;
                break;
            case "C":
                gradeInt = 2.0;
                break;
            case "D+":
                gradeInt = 1.5;
                break;
            case "D":
                gradeInt = 1.0;
                break;
            case "F":
                gradeInt = 0.0;
                break;
        }

        return gradeInt;
    }
}

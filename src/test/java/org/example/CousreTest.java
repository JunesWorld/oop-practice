package org.example;

import static org.assertj.core.api.Assertions.assertThatCode;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CousreTest {

	@DisplayName("과목(Cousre)을 생성한다.")
	@Test
	void createTest() {
		// 교과목이름, 학점, 성적 -> Cousre.class 생성 
		assertThatCode(() -> new Course("OOP", 3, "A+"))
			// 정상적으로 생성되었다면 어떠한 예외도 발생 x 
			.doesNotThrowAnyException();
	} 
}

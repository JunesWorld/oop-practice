package org.example;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
// 실제 코드에서는 correct/wrong 사용하지 않고 random을 사용하지만 test 코드이기 때문에 사용  2
public class UserTest {

	@DisplayName("패스워드를 초기화 한다.")
	@Test
	void passwordTest() {
		// given
		User user = new User();
		
		// when : 이 method를 호출 했을 
		// as-is
		//user.initPassword(new CorrectFixedPasswordGenerator()); -> 8글자 
		user.initPassword(() -> "abcdefgh");
		
		// then : password가 setting되기를 기대한다. 
		assertThat(user.getPassword()).isNotNull();
	}
	
	@DisplayName("패스워드가 요구사항에 부합하지 않아 초기화 되지 않는다.")
	@Test
	void passwordTest2() {
		// given
		User user = new User();
		
		// when : 이 method를 호출 했을 
		// as-is
		//user.initPassword(new WrongFixedPasswordGenerator());
		user.initPassword(() -> "ab");
		
		// then : password가 setting되기를 기대한다. 
		assertThat(user.getPassword()).isNull();
	}
}

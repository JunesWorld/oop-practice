package org.example;

public class User {
	private String password;

	// password 초기화 해주는 method
	// control 할 수 없는 PasswordGenerator를 외부로 부터 주입 받는다.  
	// RandomPasswordGenerator는 PasswordGenerator를 구현했기 때문에 상위 Interface인 passwordGenerator로 받는다. 
	public void initPassword(PasswordGenerator passwordGenerator) {
		// RandomPasswordGenerator가 몇글자로 PW를 생성할지 모르고 control하기 위해 PasswordGenerator Interface 생성 
		// as-is
		// RandomPasswordGenerator randomPasswordGenerator = new RandomPasswordGenerator();
		
		// to-be
		String password = passwordGenerator.generatePassword();
		
		// 비밀번호는 최소 8자 이상 12자 이하여야 한다.
		// 위 조건이 만족할 때만 password가 setting되는지 Test code 작성 -> UserTest
		if(password.length() >= 8 && password.length() <= 12) {
			this.password = password;
		}
	}
	
	public String getPassword() {
		return password;
	}
}

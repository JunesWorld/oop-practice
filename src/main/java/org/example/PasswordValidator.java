package org.example;

public class PasswordValidator {
	public static void validate(String password) {
		// length가 중복 사용되므로 지역변수로 설정 
		int length = password.length();
		
		if (length < 8 || length >12) {
			throw new IllegalArgumentException("비밀번호는 최소 8자 이상 12자 이하여야 한다");
		}
	}

}

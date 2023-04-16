package org.example.calculate;

// 양수일 때만 작업을 수행하도록 
// 모든 operand code에서 바꾸기 번거로움이 있기때문에 수정 
public class PositiveNumber {
	private final int value;
	
	public PositiveNumber(int value) {
		validate(value);
		this.value = value;
	}
	private void validate(int  value) {
		if(isNegativeNumber(value)) {
			throw new IllegalArgumentException("0 또는 음수를 전달할 수 없습니다.");
		}
			
	}
	private boolean isNegativeNumber(int value) {
		return value <= 0;
	}
	
	// int값으로 변경해주는 code 
	public int toInt() {
		return value;
	}

}

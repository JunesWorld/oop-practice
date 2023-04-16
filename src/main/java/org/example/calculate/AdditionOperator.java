package org.example.calculate;

import org.example.NewArithmeticOperator;

public class AdditionOperator implements NewArithmeticOperator {

	// operator가 같다면 
	@Override
	public boolean supports(String operator) {
		return "+".equals(operator);
	}

	// 연산 수행하여 나타내라.
	@Override
	public int calculate(PositiveNumber operand1, PositiveNumber operand2) {
		return operand1.toInt() + operand2.toInt();
	}

}

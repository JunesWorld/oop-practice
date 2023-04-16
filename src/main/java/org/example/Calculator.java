package org.example;

import java.util.List;

import org.example.calculate.AdditionOperator;
import org.example.calculate.DivisionOperator;
import org.example.calculate.MultiplicationOperator;
import org.example.calculate.PositiveNumber;
import org.example.calculate.SubstractionOperator;

public class Calculator {

//	public static int calculate(int operand1, String operator, int operand2) {
//		if ("+".equals(operator)) {
//			return operand1 + operand2;
//		} else if ("-".equals(operator)) {
//			return operand1 - operand2;
//		} else if ("*".equals(operator)) {
//			return operand1 * operand2;
//		} else if ("/".equals(operator)) {
//			return operand1 / operand2;
//		}
//		return 0;
//	}
	// 사칙연산 구현체들을 상위 interface(NewArithmeticOperator)를 통해서 받는다. 
	private static final List<NewArithmeticOperator> arithmeticOperators = List.of(new AdditionOperator(), new SubstractionOperator(), new MultiplicationOperator(), new DivisionOperator());
	
	public static int calculate(PositiveNumber operand1, String operator, PositiveNumber operand2) {
		return arithmeticOperators.stream()
				// 해당하는 operator를 filtering해서 
				.filter(arithmeticOperator -> arithmeticOperator.supports(operator))
				// 찾으면 전달 (구현체에게 calculate 작업을 위임) / 해당 값이 int이기 때문에 map 
				.map(arithmeticOperator -> arithmeticOperator.calculate(operand1, operand2))
				.findFirst()
				.orElseThrow(() -> new IllegalArgumentException("올바른 사칙연산이 아닙니다."));
	}
} 
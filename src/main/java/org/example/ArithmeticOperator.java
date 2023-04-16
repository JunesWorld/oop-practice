package org.example;

import java.util.Arrays;

// Calculator의 사칙연산을 좀 더 효율적이게 enum을 사용하여 Refactoring 
public enum ArithmeticOperator {
    ADDITION("+") {
        @Override
        public int calculate(final int operand1, final int operand2) {
            return operand1 + operand2;
        }
    },
    SUBTRACTION("-") {
        @Override
        public int calculate(final int operand1, final int operand2) {
            return operand1 - operand2;
        }
    },
    MULTIPLICATION("*") {
        @Override
        public int calculate(final int operand1, final int operand2) {
            return operand1 * operand2;
        }
    }, DIVISION("/") {
        @Override
        public int calculate(final int operand1, final int operand2) {
            if (operand2 == 0) {
                throw new IllegalArgumentException("0으로 나눌 수 없습니다.");
            }
            return operand1 / operand2;
        }
    };

	// +, -, *, /를 operator라고 하겠다.
    private final String operator;

    ArithmeticOperator(String operator) {
        this.operator = operator;
    }

    // 추상 method는 override로 구현 
    public abstract int calculate(final int operand1, final int operand2);

    public static int calculate(final int operand1, final String operator, final int operand2) {
        ArithmeticOperator selectedArithmeticOperator = Arrays.stream(ArithmeticOperator.values())
                .filter(v -> v.operator.equals(operator)) // enum 값의 operator가 같다면 
                .findFirst() // 해당 값을 가져오고 
                .orElseThrow(() -> new IllegalArgumentException("올바른 사칙연산이 아닙니다.")); 

        return selectedArithmeticOperator.calculate(operand1, operand2);
    }
}
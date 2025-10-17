package shop.leejinhyung.api.calculator.service;

import org.springframework.stereotype.Service;
import shop.leejinhyung.api.calculator.domain.CalculatorDTO;

@Service
public class CalculatorService {

    public int calculate(CalculatorDTO calculatorDTO) {
        System.out.println("통합 계산기 서비스로 들어옴");
        System.out.println("서비스로 전달된 값1: " + calculatorDTO.getNum1());
        System.out.println("서비스로 전달된 값2: " + calculatorDTO.getNum2());
        System.out.println("서비스로 전달된 연산: " + calculatorDTO.getOperation());

        int num1 = calculatorDTO.getNum1();
        int num2 = calculatorDTO.getNum2();
        String operation = calculatorDTO.getOperation();
        int result = 0;

        switch (operation) {
            case "plus":
                result = num1 + num2;
                System.out.println("덧셈 결과: " + result);
                break;
            case "minus":
                result = num1 - num2;
                System.out.println("뺄셈 결과: " + result);
                break;
            case "gob":
                result = num1 * num2;
                System.out.println("곱셈 결과: " + result);
                break;
            case "nanum":
                if (num2 == 0) {
                    System.out.println("0으로 나눌 수 없습니다");
                    throw new IllegalArgumentException("0으로 나눌 수 없습니다");
                }
                result = num1 / num2;
                System.out.println("나눗셈 결과: " + result);
                break;
            default:
                throw new IllegalArgumentException("지원하지 않는 연산입니다: " + operation);
        }

        return result;
    }
}

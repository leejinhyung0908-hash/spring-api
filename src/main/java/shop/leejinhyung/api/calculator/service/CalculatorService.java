package shop.leejinhyung.api.calculator.service;

import org.springframework.stereotype.Service;
import shop.leejinhyung.api.calculator.domain.CalculatorDTO;

@Service
public class CalculatorService {

    public double gob(CalculatorDTO calculatorDTO) {
        System.out.println("곱셈 서비스로 들어옴");
        System.out.println("서비스로 전달된 값1: " + calculatorDTO.getG1());
        System.out.println("서비스로 전달된 값2: " + calculatorDTO.getG2());

        double num1 = Double.parseDouble(calculatorDTO.getG1());
        double num2 = Double.parseDouble(calculatorDTO.getG2());
        double result = num1 * num2;

        System.out.println("곱셈 결과: " + result);
        return result;
    }

    public double minus(CalculatorDTO calculatorDTO) {
        System.out.println("뺄셈 서비스로 들어옴");
        System.out.println("서비스로 전달된 값1: " + calculatorDTO.getM1());
        System.out.println("서비스로 전달된 값2: " + calculatorDTO.getM2());

        double num1 = Double.parseDouble(calculatorDTO.getM1());
        double num2 = Double.parseDouble(calculatorDTO.getM2());
        double result = num1 - num2;

        System.out.println("뺄셈 결과: " + result);
        return result;
    }

    public double nanum(CalculatorDTO calculatorDTO) {
        System.out.println("나눗셈 서비스로 들어옴");
        System.out.println("서비스로 전달된 값1: " + calculatorDTO.getN1());
        System.out.println("서비스로 전달된 값2: " + calculatorDTO.getN2());

        double num1 = Double.parseDouble(calculatorDTO.getN1());
        double num2 = Double.parseDouble(calculatorDTO.getN2());

        if (num2 == 0) {
            System.out.println("0으로 나눌 수 없습니다");
            throw new IllegalArgumentException("0으로 나눌 수 없습니다");
        }

        double result = num1 / num2;

        System.out.println("나눗셈 결과: " + result);
        return result;
    }

    public double plus(CalculatorDTO calculatorDTO) {
        System.out.println("덧셈 서비스로 들어옴");
        System.out.println("서비스로 전달된 값1: " + calculatorDTO.getP1());
        System.out.println("서비스로 전달된 값2: " + calculatorDTO.getP2());

        double num1 = Double.parseDouble(calculatorDTO.getP1());
        double num2 = Double.parseDouble(calculatorDTO.getP2());
        double result = num1 + num2;

        System.out.println("덧셈 결과: " + result);
        return result;
    }

    public double calculator(CalculatorDTO calculatorDTO, String operation) {
        System.out.println("통합 계산기 서비스로 들어옴");
        System.out.println("서비스로 전달된 연산: " + operation);

        double num1, num2, result;

        switch (operation) {
            case "plus":
                System.out.println("서비스로 전달된 값1: " + calculatorDTO.getP1());
                System.out.println("서비스로 전달된 값2: " + calculatorDTO.getP2());
                num1 = Double.parseDouble(calculatorDTO.getP1());
                num2 = Double.parseDouble(calculatorDTO.getP2());
                result = num1 + num2;
                System.out.println("덧셈 결과: " + result);
                return result;
            case "minus":
                System.out.println("서비스로 전달된 값1: " + calculatorDTO.getM1());
                System.out.println("서비스로 전달된 값2: " + calculatorDTO.getM2());
                num1 = Double.parseDouble(calculatorDTO.getM1());
                num2 = Double.parseDouble(calculatorDTO.getM2());
                result = num1 - num2;
                System.out.println("뺄셈 결과: " + result);
                return result;
            case "gob":
                System.out.println("서비스로 전달된 값1: " + calculatorDTO.getG1());
                System.out.println("서비스로 전달된 값2: " + calculatorDTO.getG2());
                num1 = Double.parseDouble(calculatorDTO.getG1());
                num2 = Double.parseDouble(calculatorDTO.getG2());
                result = num1 * num2;
                System.out.println("곱셈 결과: " + result);
                return result;
            case "nanum":
                System.out.println("서비스로 전달된 값1: " + calculatorDTO.getN1());
                System.out.println("서비스로 전달된 값2: " + calculatorDTO.getN2());
                num1 = Double.parseDouble(calculatorDTO.getN1());
                num2 = Double.parseDouble(calculatorDTO.getN2());
                if (num2 == 0) {
                    System.out.println("0으로 나눌 수 없습니다");
                    throw new IllegalArgumentException("0으로 나눌 수 없습니다");
                }
                result = num1 / num2;
                System.out.println("나눗셈 결과: " + result);
                return result;
            default:
                throw new IllegalArgumentException("지원하지 않는 연산입니다: " + operation);
        }
    }
}

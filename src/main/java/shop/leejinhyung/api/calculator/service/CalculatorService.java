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
    
    public boolean minus(CalculatorDTO calculatorDTO) {
        System.out.println("뺄셈 서비스로 들어옴");
        System.out.println("서비스로 전달된 값1: " + calculatorDTO.getM1());
        System.out.println("서비스로 전달된 값2: " + calculatorDTO.getM2());
        return true;
    }
    
    public boolean nanum(CalculatorDTO calculatorDTO) {
        System.out.println("나눗셈 서비스로 들어옴");
        System.out.println("서비스로 전달된 값1: " + calculatorDTO.getN1());
        System.out.println("서비스로 전달된 값2: " + calculatorDTO.getN2());
        return true;
    }
    
    public boolean plus(CalculatorDTO calculatorDTO) {
        System.out.println("덧셈 서비스로 들어옴");
        System.out.println("서비스로 전달된 값1: " + calculatorDTO.getP1());
        System.out.println("서비스로 전달된 값2: " + calculatorDTO.getP2());
        return true;
    }
}

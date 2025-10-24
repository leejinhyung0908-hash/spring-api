package shop.leejinhyung.api.calculator.service;

import shop.leejinhyung.api.calculator.domain.CalculatorDTO;

public interface CalculatorService {

    public int add(CalculatorDTO calculatorDTO);
    public int subtract(CalculatorDTO calculatorDTO);
    public int multiply(CalculatorDTO calculatorDTO);
    public int divide(CalculatorDTO calculatorDTO);
}

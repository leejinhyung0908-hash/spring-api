package shop.leejinhyung.api.calculator.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import shop.leejinhyung.api.calculator.domain.CalculatorDTO;
import shop.leejinhyung.api.calculator.service.CalculatorService;

@Controller
public class CalculatorController {

    private final CalculatorService calculatorService;

    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    // 통합 계산기
    @GetMapping("/calculator")
    public String calculator(@RequestParam int num1, @RequestParam int num2, @RequestParam String operation,
            Model model) {
        System.out.println("통합 계산기 컨트롤러로 들어옴");
        System.out.println("화면에서 컨트롤러로 전달된 값1: " + num1);
        System.out.println("화면에서 컨트롤러로 전달된 값2: " + num2);
        System.out.println("화면에서 컨트롤러로 전달된 연산: " + operation);

        CalculatorDTO calculatorDTO = new CalculatorDTO();
        calculatorDTO.setNum1(num1);
        calculatorDTO.setNum2(num2);
        calculatorDTO.setOperation(operation);

        try {
            int result = calculatorService.calculate(calculatorDTO);

            model.addAttribute("result", result);
            model.addAttribute("num1", calculatorDTO.getNum1());
            model.addAttribute("num2", calculatorDTO.getNum2());
            model.addAttribute("operation", calculatorDTO.getOperation());

        } catch (Exception e) {
            model.addAttribute("result", "계산 오류: " + e.getMessage());
        }

        return "calculator/calculator";
    }
}

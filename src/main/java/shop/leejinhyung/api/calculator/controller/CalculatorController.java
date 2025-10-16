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

    // 곱셈
    @GetMapping("/gob")
    public String gob(@RequestParam String g1, @RequestParam String g2, Model model) {
        System.out.println("컨트롤러로 들어옴");
        System.out.println("화면에서 컨트롤러로 전달된 값1: " + g1);
        System.out.println("화면에서 컨트롤러로 전달된 값2: " + g2);

        CalculatorDTO calculatorDTO = new CalculatorDTO();
        calculatorDTO.setG1(g1);
        calculatorDTO.setG2(g2);

        double result = calculatorService.gob(calculatorDTO);
        model.addAttribute("result", result);

        return "calculator/gob";
    }

    // 뺄셈
    @GetMapping("/minus")
    public String minus(@RequestParam String m1, @RequestParam String m2, Model model) {
        System.out.println("컨트롤러로 들어옴");
        System.out.println("화면에서 컨트롤러로 전달된 값1: " + m1);
        System.out.println("화면에서 컨트롤러로 전달된 값2: " + m2);

        CalculatorDTO calculatorDTO = new CalculatorDTO();
        calculatorDTO.setM1(m1);
        calculatorDTO.setM2(m2);

        double result = calculatorService.minus(calculatorDTO);
        model.addAttribute("result", result);

        return "calculator/minus";
    }

    // 나눗셈
    @GetMapping("/nanum")
    public String nanum(@RequestParam String n1, @RequestParam String n2, Model model) {
        System.out.println("컨트롤러로 들어옴");
        System.out.println("화면에서 컨트롤러로 전달된 값1: " + n1);
        System.out.println("화면에서 컨트롤러로 전달된 값2: " + n2);

        CalculatorDTO calculatorDTO = new CalculatorDTO();
        calculatorDTO.setN1(n1);
        calculatorDTO.setN2(n2);

        double result = calculatorService.nanum(calculatorDTO);
        model.addAttribute("result", result);

        return "calculator/nanum";
    }

    // 덧셈
    @GetMapping("/plus")
    public String plus(@RequestParam String p1, @RequestParam String p2, Model model) {
        System.out.println("컨트롤러로 들어옴");
        System.out.println("화면에서 컨트롤러로 전달된 값1: " + p1);
        System.out.println("화면에서 컨트롤러로 전달된 값2: " + p2);

        CalculatorDTO calculatorDTO = new CalculatorDTO();
        calculatorDTO.setP1(p1);
        calculatorDTO.setP2(p2);

        double result = calculatorService.plus(calculatorDTO);
        model.addAttribute("result", result);

        return "calculator/plus";
    }

    // 통합 계산기
    @GetMapping("/calculator")
    public String calculator(@RequestParam String num1, @RequestParam String num2, @RequestParam String operation,
            Model model) {
        System.out.println("통합 계산기 컨트롤러로 들어옴");
        System.out.println("화면에서 컨트롤러로 전달된 값1: " + num1);
        System.out.println("화면에서 컨트롤러로 전달된 값2: " + num2);
        System.out.println("화면에서 컨트롤러로 전달된 연산: " + operation);

        CalculatorDTO calculatorDTO = new CalculatorDTO();
        double result = 0;

        try {
            switch (operation) {
                case "plus":
                    calculatorDTO.setP1(num1);
                    calculatorDTO.setP2(num2);
                    result = calculatorService.plus(calculatorDTO);
                    break;
                case "minus":
                    calculatorDTO.setM1(num1);
                    calculatorDTO.setM2(num2);
                    result = calculatorService.minus(calculatorDTO);
                    break;
                case "gob":
                    calculatorDTO.setG1(num1);
                    calculatorDTO.setG2(num2);
                    result = calculatorService.gob(calculatorDTO);
                    break;
                case "nanum":
                    calculatorDTO.setN1(num1);
                    calculatorDTO.setN2(num2);
                    result = calculatorService.nanum(calculatorDTO);
                    break;
                default:
                    model.addAttribute("result", "지원하지 않는 연산입니다");
                    return "calculator/calculator";
            }

            model.addAttribute("result", result);
            model.addAttribute("num1", num1);
            model.addAttribute("num2", num2);
            model.addAttribute("operation", operation);

        } catch (Exception e) {
            model.addAttribute("result", "계산 오류: " + e.getMessage());
        }

        return "calculator/calculator";
    }
}

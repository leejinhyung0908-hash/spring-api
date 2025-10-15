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
    public String minus(@RequestParam String m1, @RequestParam String m2) {
        System.out.println("컨트롤러로 들어옴");
        System.out.println("화면에서 컨트롤러로 전달된 값1: " + m1);
        System.out.println("화면에서 컨트롤러로 전달된 값2: " + m2);
        
        CalculatorDTO calculatorDTO = new CalculatorDTO();
        calculatorDTO.setM1(m1);
        calculatorDTO.setM2(m2);

        calculatorService.minus(calculatorDTO);

        return "calculator/minus";
    }

    // 나눗셈
    @GetMapping("/nanum")
    public String nanum(@RequestParam String n1, @RequestParam String n2) {
        System.out.println("컨트롤러로 들어옴");
        System.out.println("화면에서 컨트롤러로 전달된 값1: " + n1);
        System.out.println("화면에서 컨트롤러로 전달된 값2: " + n2);
        
        CalculatorDTO calculatorDTO = new CalculatorDTO();
        calculatorDTO.setN1(n1);
        calculatorDTO.setN2(n2);

        calculatorService.nanum(calculatorDTO);

        return "calculator/nanum";
    }

    // 덧셈
    @GetMapping("/plus")
    public String plus(@RequestParam String p1, @RequestParam String p2) {
        System.out.println("컨트롤러로 들어옴");
        System.out.println("화면에서 컨트롤러로 전달된 값1: " + p1);
        System.out.println("화면에서 컨트롤러로 전달된 값2: " + p2);
        
        CalculatorDTO calculatorDTO = new CalculatorDTO();
        calculatorDTO.setP1(p1);
        calculatorDTO.setP2(p2);

        calculatorService.plus(calculatorDTO);

        return "calculator/plus";
    }
}

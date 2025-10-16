package shop.leejinhyung.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    
    @GetMapping("/")
    public String home() {
        return "index";
    }


    @GetMapping("/auth/login.html")
    public String loginHtml() {
        return "auth/login";
    }

    @GetMapping("/auth/register.html")
    public String registerHtml() {
        return "auth/register";
    }

    @GetMapping("/calculator/plus")
    public String calculatorPlusPage() {
        return "/calculator/plus";
    }

    @GetMapping("/calculator/minus")
    public String calculatorMinusPage() {
        return "/calculator/minus";
    }

    @GetMapping("/calculator/gob")
    public String calculatorGobPage() {
        return "/calculator/gob";
    }

    @GetMapping("/calculator/nanum")
    public String calculatorNanumPage() {
        return "/calculator/nanum";
    }
    @GetMapping("/calculator/calculator")
    public String calculatorCalculatorPage() {
        return "/calculator/calculator";
    }

}

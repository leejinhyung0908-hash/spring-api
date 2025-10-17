package shop.leejinhyung.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    
    @GetMapping("/")
    public String home() {
        return "index";
    }


    @GetMapping("/auth/login.go")
    public String loginHtml() {
        return "auth/login";
    }

    @GetMapping("/auth/register.html")
    public String registerHtml() {
        return "auth/register";
    }

    @GetMapping("/calculator/calculator")
    public String calculatorCalculatorPage() {
        return "/calculator/calculator";
    }

}

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

    @GetMapping("/users/list")
    public String userListPage() {
        return "user/list";
    }

    @GetMapping("/weathers/list")
    public String weatherListPage() {
        return "weather/list";
    }

    @GetMapping("/products/list")
    public String productListPage() {
        return "products/list";
    }

}

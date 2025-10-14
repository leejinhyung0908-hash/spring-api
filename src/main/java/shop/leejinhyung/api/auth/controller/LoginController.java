package shop.leejinhyung.api.auth.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
    
    @GetMapping("/login")
    public String login(@RequestParam String userId, 
                       @RequestParam String password) {
        
        System.out.println("=== 로그인 요청 ===");
        System.out.println("아이디😂: " + userId);
        System.out.println("비밀번호😊: " + password);
        System.out.println("==================");
        
        // 로그인 조건 확인
        if ("a".equals(userId) && "b".equals(password)) {
            System.out.println("로그인 성공! → register.html로 이동");
            return "auth/register"; // templates/auth/success.html 로 이동
        } else {
            System.out.println("로그인 실패! → login.html로 이동");
            return "auth/login"; // templates/auth/login.html 로 이동
        }
    }
}




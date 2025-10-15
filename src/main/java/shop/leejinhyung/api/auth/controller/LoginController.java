package shop.leejinhyung.api.auth.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import shop.leejinhyung.api.auth.domain.LoginDTO;
import shop.leejinhyung.api.auth.service.LoginService;

@Controller
public class LoginController {

    private final LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @GetMapping("/login")
    public String login(@RequestParam String userId, 
                       @RequestParam String password) {
        
        System.out.println("컨트롤러로 들어옴");
        System.out.println("화면에서 컨트롤러로 전달된 아이디: " + userId);
        System.out.println("화면에서 컨트롤러로 전달된 패스워드: " + password);
        LoginDTO loginDTO = new LoginDTO();
        loginDTO.setUserId(userId);
        loginDTO.setPassword(password);

        loginService.login(loginDTO);



        return "auth/login";
    }
}




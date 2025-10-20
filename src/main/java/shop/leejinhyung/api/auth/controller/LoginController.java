package shop.leejinhyung.api.auth.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import shop.leejinhyung.api.auth.domain.LoginDTO;
import shop.leejinhyung.api.auth.service.LoginService;
import shop.leejinhyung.api.common.domain.Messenger;

@Controller
public class LoginController {

    private final LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }


    @GetMapping("/login")
    public String login(@RequestParam(required = false) String userId,
            @RequestParam(required = false) String password, Model model) {

        // 파라미터가 없으면 빈 messenger 객체로 로그인 페이지 표시
        if (userId == null || password == null) {
            Messenger messenger = new Messenger();
            messenger.setCode(0);
            messenger.setMessage("");
            model.addAttribute("messenger", messenger);
            return "auth/login";
        }

        System.out.println("컨트롤러로 들어옴");
        System.out.println("화면에서 컨트롤러로 전달된 아이디: " + userId);
        System.out.println("화면에서 컨트롤러로 전달된 패스워드: " + password);
        LoginDTO loginDTO = new LoginDTO();
        loginDTO.setUserId(userId);
        loginDTO.setPassword(password);

        Messenger messenger = new Messenger();
        messenger = loginService.login(loginDTO);

        System.out.println("서비스에서 컨트롤러로 리턴한 코드: " + messenger.getCode());
        System.out.println("서비스에서 컨트롤러로 리턴한 메시지: " + messenger.getMessage());

        model.addAttribute("messenger", messenger);

        return "auth/login";
    }
}

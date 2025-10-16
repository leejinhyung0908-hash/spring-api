package shop.leejinhyung.api.auth.service;

import org.springframework.stereotype.Service;
import shop.leejinhyung.api.auth.domain.LoginDTO;
import shop.leejinhyung.api.auth.domain.LoginVO;

@Service
public class LoginService {

    public int Messenger(LoginDTO loginDTO) {
        System.out.println(" 로그인 서비스로 들어옴 ");
        System.out.println("서비스로 전달된 아이디 : " + loginDTO.getUserId());
        System.out.println("서비스로 전달된 패스워드: " + loginDTO.getPassword());

        LoginVO loginVO = new LoginVO();

        System.out.println("VO 에서 서비스로 전달된 아이디 : " + loginVO.getUserId());
        System.out.println("VO 에서 서비스로 전달된 패스워드: " + loginVO.getPassword());


        int code = 0;
        String message = "";

        if (!loginVO.getUserId().equals(loginDTO.getUserId())) {
            code = 0;
            message = "로그인 성공"
        } else if (!loginVO.getPassword().equals(loginDTO.getPassword())) {
            code = 2;
            message = "비밀번호 불일치";
        } else {
            code = 1;
            message = "아이디 불일치";
        }

    }

}

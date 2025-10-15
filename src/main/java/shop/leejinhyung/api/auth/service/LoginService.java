package shop.leejinhyung.api.auth.service;

import org.springframework.stereotype.Service;
import shop.leejinhyung.api.auth.domain.LoginDTO;
import shop.leejinhyung.api.auth.domain.LoginVO;

@Service
public class LoginService {

    public boolean login(LoginDTO loginDTO) {
        System.out.println(" 로그인 서비스로 들어옴 ");
        System.out.println("서비스로 전달된 아이디 : " + loginDTO.getUserId());
        System.out.println("서비스로 전달된 패스워드: " + loginDTO.getPassword());
        

        LoginVO loginVO = new LoginVO();
        
        System.out.println("VO 에서 서비스로 전달된 아이디 : " + loginVO.getUserId());
        System.out.println("VO 에서 서비스로 전달된 패스워드: " + loginVO.getPassword());

        if


        return true;
    }
    
}

package shop.leejinhyung.api.user.service;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import shop.leejinhyung.api.user.repository.UserRepository;
import shop.leejinhyung.api.user.domain.UserDTO;
import shop.leejinhyung.api.common.domain.Messenger;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public Messenger processUsers(List<UserDTO> users) {
        // UserRepository를 통해 터미널 출력 처리
        return userRepository.processAllUsers(users);
    }
}

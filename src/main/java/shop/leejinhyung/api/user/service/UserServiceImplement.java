package shop.leejinhyung.api.user.service;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import shop.leejinhyung.api.common.domain.Messenger;
import shop.leejinhyung.api.user.domain.UserDTO;
import shop.leejinhyung.api.user.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class UserServiceImplement implements UserService {
    private final UserRepository userRepository;

    @Override
    public Messenger save(UserDTO userDTO) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

    @Override
    public Messenger update(UserDTO userDTO) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public Messenger delete(UserDTO userDTO) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public Messenger findById(UserDTO userDTO) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Override
    public Messenger findAll(UserDTO userDTO) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @Override
    public Messenger saveAll(List<UserDTO> userList) {
        return userRepository.saveAll(userList);
    }

}

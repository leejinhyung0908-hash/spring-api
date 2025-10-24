package shop.leejinhyung.api.user.service;

import java.util.List;
import shop.leejinhyung.api.common.domain.Messenger;
import shop.leejinhyung.api.user.domain.UserDTO;

public interface UserService {

    Messenger save(UserDTO userDTO);

    Messenger update(UserDTO userDTO);

    Messenger delete(UserDTO userDTO);

    Messenger findById(UserDTO userDTO);

    Messenger findAll(UserDTO userDTO);

    Messenger saveAll(List<UserDTO> userList);
}

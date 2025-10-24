package shop.leejinhyung.api.user.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import shop.leejinhyung.api.common.domain.Messenger;
import shop.leejinhyung.api.user.domain.UserDTO;

@Repository
public class UserRepository {

    public Messenger save(UserDTO userDTO) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

    public Messenger update(UserDTO userDTO) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    public Messenger delete(UserDTO userDTO) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    public Messenger findById(UserDTO userDTO) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    public Messenger findAll(UserDTO userDTO) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    public Messenger saveAll(List<UserDTO> userList) {
        // 모든 사용자 정보를 한 번에 터미널에 출력
        System.out.println("==========================================");
        System.out.println("           모든 사용자 정보 출력");
        System.out.println("==========================================");

        for (int i = 0; i < userList.size(); i++) {
            UserDTO user = userList.get(i);
            System.out.println("\n--- 사용자 " + (i + 1) + " ---");
            System.out.println("사용자 ID: " + user.getUserId());
            System.out.println("생존 여부: " + user.getSurvived());
            System.out.println("등급: " + user.getPclass());
            System.out.println("이름: " + user.getName());
            System.out.println("성별: " + user.getGender());
            System.out.println("나이: " + user.getAge());
            System.out.println("형제자매/배우자 수: " + user.getSibSp());
            System.out.println("부모/자녀 수: " + user.getParch());
            System.out.println("티켓 번호: " + user.getTicket());
            System.out.println("요금: " + user.getFare());
            System.out.println("객실: " + user.getCabin());
            System.out.println("승선항구: " + user.getEmbarked());

            // 조건식 값 출력
            System.out.println("--- 조건식 결과 ---");
            System.out.println("생존 여부가 1인가? " + ("1".equals(user.getSurvived())));
            System.out.println("등급이 1등급인가? " + ("1".equals(user.getPclass())));
            System.out.println("성별이 남자인가? " + ("male".equals(user.getGender())));
            System.out.println("나이가 30세 이상인가? "
                    + (user.getAge() != null && !user.getAge().isEmpty() && Integer.parseInt(user.getAge()) >= 30));
        }

        System.out.println("==========================================");

        // 여기서 실제 데이터베이스 저장 로직을 구현할 수 있습니다
        // 현재는 성공 응답만 반환

        Messenger messenger = new Messenger();
        messenger.setCode(200);
        messenger.setMessage("모든 사용자 데이터가 성공적으로 처리되었습니다.");
        // 메시지와 코드도 터미널에 함께 출력
        System.out.println("메시지: " + messenger.getMessage());
        System.out.println("코드: " + messenger.getCode());

        return messenger;
    }
}
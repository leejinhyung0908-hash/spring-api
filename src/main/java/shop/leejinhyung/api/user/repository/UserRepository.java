package shop.leejinhyung.api.user.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import shop.leejinhyung.api.common.domain.Messenger;
import shop.leejinhyung.api.user.domain.UserDTO;

@Repository
public class UserRepository {

    public Messenger processAllUsers(List<UserDTO> users) {
        // 모든 사용자 정보를 한 번에 터미널에 출력
        System.out.println("==========================================");
        System.out.println("           모든 사용자 정보 출력");
        System.out.println("==========================================");

        for (int i = 0; i < users.size(); i++) {
            UserDTO user = users.get(i);
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
        }

        System.out.println("==========================================");

        // 여기서 실제 데이터베이스 저장 로직을 구현할 수 있습니다
        // 현재는 성공 응답만 반환

        Messenger messenger = new Messenger();
        messenger.setCode(200);
        messenger.setMessage("모든 사용자 데이터가 성공적으로 처리되었습니다.");

        return messenger;
    }
}

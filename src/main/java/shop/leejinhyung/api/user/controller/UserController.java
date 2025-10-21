package shop.leejinhyung.api.user.controller;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;

import shop.leejinhyung.api.user.service.UserService;
import shop.leejinhyung.api.common.domain.Messenger;
import shop.leejinhyung.api.user.domain.UserDTO;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/might")
    public Messenger printFirstFivePassengers() {
        try {
            // CSV 파일 경로
            String csvFilePath = "src/main/resources/static/csv/train.csv";

            // CSV 파일 읽기
            FileReader reader = new FileReader(csvFilePath);
            CSVParser parser = new CSVParser(reader,
            CSVFormat.DEFAULT.withFirstRecordAsHeader());

            List<UserDTO> users = new ArrayList<>();
            int count = 0;

            // 처음 5명의 데이터만 읽기
            for (CSVRecord record : parser) {
                if (count >= 5)
                    break;

                UserDTO user = new UserDTO();
                user.setUserId(record.get("PassengerId"));
                user.setSurvived(record.get("Survived"));
                user.setPclass(record.get("Pclass"));
                user.setName(record.get("Name"));
                user.setGender(record.get("Sex"));
                user.setAge(record.get("Age"));
                user.setSibSp(record.get("SibSp"));
                user.setParch(record.get("Parch"));
                user.setTicket(record.get("Ticket"));
                user.setFare(record.get("Fare"));
                user.setCabin(record.get("Cabin"));
                user.setEmbarked(record.get("Embarked"));

                users.add(user);
                count++;
            }

            parser.close();
            reader.close();

            // UserService를 통해 데이터 처리
            return userService.processUsers(users);

        } catch (IOException e) {
            Messenger messenger = new Messenger();
            messenger.setCode(500);
            messenger.setMessage("CSV 파일을 읽는 중 오류가 발생했습니다: " + e.getMessage());
            return messenger;

        }
    }

}
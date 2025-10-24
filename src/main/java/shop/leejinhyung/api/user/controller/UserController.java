package shop.leejinhyung.api.user.controller;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.ui.Model;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;

import shop.leejinhyung.api.user.service.UserService;
import shop.leejinhyung.api.common.domain.Messenger;
import shop.leejinhyung.api.user.domain.UserDTO;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/users")

public class UserController {

    private final UserService userService;

    @PutMapping("/{id}")
    public void update(@RequestBody UserDTO userDTO, Model model) {
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id, Model model) {
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @PostMapping("/all")
    public String saveAll(Model model) { // (Model model)은 파라미터이다.
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
                user.setUserId(record.get("PassengerId")); // (PassengerId)는 Args이다.
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

                users.add(user); // users.add(user)에서 (user)는 element라고 생각하면 된다.
                count++;
            }

            parser.close();
            reader.close();

            // UserService를 통해 데이터 처리 (터미널 출력용)
            Messenger result = userService.saveAll(users);

            // 처리 메시지 및 사용자 목록 모델 추가
            model.addAttribute("message", result.getMessage());
            model.addAttribute("users", users);
            return "user/list";

        } catch (IOException e) {
            model.addAttribute("users", new ArrayList<UserDTO>());
            model.addAttribute("message", "CSV 파일을 읽는 중 오류가 발생했습니다: " + e.getMessage());
            return "user/list";

        }
    }

    @GetMapping("/id/{id}")
    public void findById(@PathVariable String id, Model model) {
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @GetMapping("/all")
    public void findAll(Model model) {
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }
}
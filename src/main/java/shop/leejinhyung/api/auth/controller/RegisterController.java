package shop.leejinhyung.api.auth.controller;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import shop.leejinhyung.api.auth.service.RegisterService;
import shop.leejinhyung.api.common.domain.Messenger;
import shop.leejinhyung.api.auth.domain.RegisterDTO;
import lombok.RequiredArgsConstructor;

@Controller

@RequiredArgsConstructor
public class RegisterController {

    private final RegisterService registerService;

    @GetMapping("/register")
    public Messenger printFirstFivePassengers() {
        try {
            // CSV 파일 경로
            String csvFilePath = "src/main/resources/static/csv/train.csv";

            // CSV 파일 읽기
            FileReader reader = new FileReader(csvFilePath);
            CSVParser parser = new CSVParser(reader, CSVFormat.DEFAULT.withFirstRecordAsHeader());

            List<RegisterDTO> registers = new ArrayList<>();
            int count = 0;

            // 처음 5명의 데이터만 읽기
            for (CSVRecord record : parser) {
                if (count >= 5)
                    break;

                RegisterDTO register = new RegisterDTO();
                register.setUserId(record.get("PassengerId"));
                register.setSurvived(record.get("Survived"));
                register.setPclass(record.get("Pclass"));
                register.setName(record.get("Name"));
                register.setGender(record.get("Sex"));
                register.setAge(record.get("Age"));
                register.setSibSp(record.get("SibSp"));
                register.setParch(record.get("Parch"));
                register.setTicket(record.get("Ticket"));
                register.setFare(record.get("Fare"));
                register.setCabin(record.get("Cabin"));
                register.setEmbarked(record.get("Embarked"));

                registers.add(register);
                count++;
            }

            parser.close();
            reader.close();

            Messenger messenger = new Messenger();
            return messenger;

        } catch (IOException e) {
            Messenger messenger = new Messenger();
            messenger.setCode(500);
            messenger.setMessage("CSV 파일을 읽는 중 오류가 발생했습니다: " + e.getMessage());
            return messenger;
            
        }
    }

}
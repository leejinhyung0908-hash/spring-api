package shop.leejinhyung.api.auth.controller;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import shop.leejinhyung.api.common.domain.Messenger;

import org.springframework.stereotype.Controller;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

@Controller
public class RegisterController {
    @GetMapping("/register/csv-demo")
    @ResponseBody
    public Messenger readAndPrintFirst5Passengers() {
        try {
            // CSV 파일 경로
            String csvFilePath = "src/main/resources/static/csv/train.csv";

            // CSV 파일 읽기
            Reader reader = new FileReader(csvFilePath);
            CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT.withFirstRecordAsHeader());

            System.out.println("=== 타이타닉 승객 데이터 (처음 5명) ===");
            System.out.println();

            int count = 0;
            for (CSVRecord record : csvParser) {
                if (count >= 5) {
                    break;
                }

                System.out.println("승객 " + (count + 1) + ":");
                System.out.println("  PassengerId: " + record.get("PassengerId"));
                System.out.println("  Survived: " + record.get("Survived"));
                System.out.println("  Pclass: " + record.get("Pclass"));
                System.out.println("  Name: " + record.get("Name"));
                System.out.println("  Sex: " + record.get("Sex"));
                System.out.println("  Age: " + record.get("Age"));
                System.out.println("  SibSp: " + record.get("SibSp"));
                System.out.println("  Parch: " + record.get("Parch"));
                System.out.println("  Ticket: " + record.get("Ticket"));
                System.out.println("  Fare: " + record.get("Fare"));
                System.out.println("  Cabin: " + record.get("Cabin"));
                System.out.println("  Embarked: " + record.get("Embarked"));
                System.out.println();

                count++;
            }

            csvParser.close();
            reader.close();

        } catch (IOException e) {
            System.err.println("CSV 파일을 읽는 중 오류가 발생했습니다: " + e.getMessage());
            e.printStackTrace();
        }

        Messenger messenger = new Messenger();
        messenger.setCode(0);
        messenger.setMessage("CSV 데이터를 콘솔에 출력했습니다.");
        return messenger;
    }

}

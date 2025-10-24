package shop.leejinhyung.api.weather.controller;

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

import shop.leejinhyung.api.weather.service.WeatherService;
import shop.leejinhyung.api.common.domain.Messenger;
import shop.leejinhyung.api.weather.domain.WeatherDTO;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/weathers")

public class WeatherController {

    private final WeatherService weatherService;

    @PutMapping("/{id}")
    public void update(@RequestBody WeatherDTO weatherDTO, Model model) {
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
            String csvFilePath = "src/main/resources/static/csv/weather.csv";

            // CSV 파일 읽기
            FileReader reader = new FileReader(csvFilePath);
            CSVParser parser = new CSVParser(reader,
                    CSVFormat.DEFAULT.withFirstRecordAsHeader());

            List<WeatherDTO> weatherList = new ArrayList<>();
            int count = 0;

            // 처음 5개의 날씨 데이터만 읽기
            for (CSVRecord record : parser) {
                if (count >= 5)
                    break;

                WeatherDTO weather = new WeatherDTO();
                weather.setDate(record.get(0)); // 일시
                weather.setAvgTemp(record.get(1)); // 평균기온(℃)
                weather.setMaxTemp(record.get(2)); // 최고기온(℃)
                weather.setMaxTempTime(record.get(3)); // 최고기온시각
                weather.setMinTemp(record.get(4)); // 최저기온(℃)
                weather.setMinTempTime(record.get(5)); // 최저기온시각
                weather.setTempRange(record.get(6)); // 일교차
                weather.setPrecipitation(record.get(7)); // 강수량(mm)

                weatherList.add(weather);
                count++;
            }

            parser.close();
            reader.close();

            // WeatherService를 통해 데이터 처리 (터미널 출력용)
            Messenger result = weatherService.saveAll(weatherList);

            // 처리 메시지 및 날씨 목록 모델 추가
            model.addAttribute("message", result.getMessage());
            model.addAttribute("weatherList", weatherList);
            return "weather/list";

        } catch (IOException e) {
            model.addAttribute("weatherList", new ArrayList<WeatherDTO>());
            model.addAttribute("message", "CSV 파일을 읽는 중 오류가 발생했습니다: " + e.getMessage());
            return "weather/list";

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

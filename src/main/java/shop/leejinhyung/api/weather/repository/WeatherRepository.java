package shop.leejinhyung.api.weather.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import shop.leejinhyung.api.common.domain.Messenger;
import shop.leejinhyung.api.weather.domain.WeatherDTO;

@Repository
public class WeatherRepository {

    public Messenger processAllWeather(List<WeatherDTO> weatherList) {
        // 모든 날씨 정보를 한 번에 터미널에 출력
        System.out.println("==========================================");
        System.out.println("           모든 날씨 정보 출력");
        System.out.println("==========================================");

        for (int i = 0; i < weatherList.size(); i++) {
            WeatherDTO weather = weatherList.get(i);
            System.out.println("\n--- 날씨 데이터 " + (i + 1) + " ---");
            System.out.println("일시: " + weather.getDate());
            System.out.println("평균기온: " + weather.getAvgTemp() + "℃");
            System.out.println("최고기온: " + weather.getMaxTemp() + "℃");
            System.out.println("최고기온시각: " + weather.getMaxTempTime());
            System.out.println("최저기온: " + weather.getMinTemp() + "℃");
            System.out.println("최저기온시각: " + weather.getMinTempTime());
            System.out.println("일교차: " + weather.getTempRange());
            System.out.println("강수량: " + weather.getPrecipitation() + "mm");
        }

        System.out.println("==========================================");

        // 여기서 실제 데이터베이스 저장 로직을 구현할 수 있습니다
        // 현재는 성공 응답만 반환

        Messenger messenger = new Messenger();
        messenger.setCode(200);
        messenger.setMessage("모든 날씨 데이터가 성공적으로 처리되었습니다.");
        // 메시지도 함께 터미널에 출력
        System.out.println("메시지: " + messenger.getMessage());
        System.out.println("코드: " + messenger.getCode());

        return messenger;
    }
}

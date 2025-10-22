package shop.leejinhyung.api.weather.service;

import java.util.List;
import org.springframework.stereotype.Service;
import shop.leejinhyung.api.weather.domain.WeatherDTO;
import shop.leejinhyung.api.weather.repository.WeatherRepository;
import shop.leejinhyung.api.common.domain.Messenger;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class WeatherService {

    private final WeatherRepository weatherRepository;

    public Messenger processWeather(List<WeatherDTO> weatherList) {
        return weatherRepository.processAllWeather(weatherList);
    }
}

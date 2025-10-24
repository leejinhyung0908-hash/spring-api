package shop.leejinhyung.api.weather.service;

import java.util.List;
import shop.leejinhyung.api.common.domain.Messenger;
import shop.leejinhyung.api.weather.domain.WeatherDTO;

public interface WeatherService {

    Messenger save(WeatherDTO weatherDTO);

    Messenger update(WeatherDTO weatherDTO);

    Messenger delete(WeatherDTO weatherDTO);

    Messenger findById(WeatherDTO weatherDTO);

    Messenger findAll(WeatherDTO weatherDTO);

    Messenger saveAll(List<WeatherDTO> weatherList);
}

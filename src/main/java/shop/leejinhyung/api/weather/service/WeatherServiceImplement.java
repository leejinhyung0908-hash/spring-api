package shop.leejinhyung.api.weather.service;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import shop.leejinhyung.api.common.domain.Messenger;
import shop.leejinhyung.api.weather.domain.WeatherDTO;
import shop.leejinhyung.api.weather.repository.WeatherRepository;

@Service
@RequiredArgsConstructor
public class WeatherServiceImplement implements WeatherService {
    private final WeatherRepository weatherRepository;

    @Override
    public Messenger save(WeatherDTO weatherDTO) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

    @Override
    public Messenger update(WeatherDTO weatherDTO) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public Messenger delete(WeatherDTO weatherDTO) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public Messenger findById(WeatherDTO weatherDTO) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Override
    public Messenger findAll(WeatherDTO weatherDTO) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @Override
    public Messenger saveAll(List<WeatherDTO> weatherList) {
        return weatherRepository.saveAll(weatherList);
    }

}

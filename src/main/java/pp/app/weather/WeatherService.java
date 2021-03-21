package pp.app.weather;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
public class WeatherService {

    private final String URL = "http://api.openweathermap.org/data/2.5/weather?q=";
    private final String KEY = "&units=metric&appid=edb5454f20d34bda28ca69ec76f46b9c";

    public WeatherResponseDto getWeatherForCity(String city) {
        try {
            RestTemplate restTemplate = new RestTemplate();
            String url = URL + city + KEY;
            Weather weatherDto = restTemplate.getForObject(url, Weather.class);
            return WeatherService.fromDto(weatherDto);
        } catch (Exception exception) {
            throw new CityNotFoundException();
        }
    }

    public static WeatherResponseDto fromDto(Weather weather) {
        WeatherResponseDto weatherResponseDto = new WeatherResponseDto();

        weatherResponseDto.setCity(weather.getName());
        weatherResponseDto.setTemperature(weather.getMain().get("temp").setScale(1, RoundingMode.HALF_UP));
        weatherResponseDto.setTemp_felt(weather.getMain().get("feels_like").setScale(1, RoundingMode.HALF_UP));
        weatherResponseDto.setTemp_min(weather.getMain().get("temp_min").setScale(1, RoundingMode.HALF_UP));
        weatherResponseDto.setTemp_max(weather.getMain().get("temp_max").setScale(1, RoundingMode.HALF_UP));
        weatherResponseDto.setPressure(weather.getMain().get("pressure"));
        weatherResponseDto.setHumidity(weather.getMain().get("humidity"));
        return weatherResponseDto;
    }
}
package pp.app.weather;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WeatherResponseDto {

    private String city;
    private BigDecimal temperature;
    private BigDecimal temp_felt;
    private BigDecimal temp_max;
    private BigDecimal temp_min;
    private BigDecimal pressure;
    private BigDecimal humidity;
}
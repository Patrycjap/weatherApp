package pp.app.weather;

import lombok.*;
import java.math.BigDecimal;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Weather {

    private String name;
    private Map<String, BigDecimal> main;
}
package pp.app.weather;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorControllerAdvice {

    @ExceptionHandler(CityNotFoundException.class)
    public String handleException() {
        return "nodata";
    }
}
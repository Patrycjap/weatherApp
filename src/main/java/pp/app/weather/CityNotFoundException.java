package pp.app.weather;

public class CityNotFoundException extends RuntimeException {

    public CityNotFoundException() {

        super("Failed to get the weather");
    }
}
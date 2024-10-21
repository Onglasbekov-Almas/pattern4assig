// WeatherDisplay Interface
interface WeatherDisplay {
    void update(float temperature, float humidity, float pressure);
}

// WeatherStation
class WeatherStation {
    private List<WeatherDisplay> displays = new ArrayList<>();
    private float temperature, humidity, pressure;

    public void addDisplay(WeatherDisplay display) {
        displays.add(display);
    }

    public void notifyDisplays() {
        for (WeatherDisplay display : displays) {
            display.update(temperature, humidity, pressure);
        }
    }

    public void setMeasurements(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        notifyDisplays();
    }
}

// CurrentConditionsDisplay
class CurrentConditionsDisplay implements WeatherDisplay {
    public void update(float temperature, float humidity, float pressure) {
        System.out.println("Current conditions: " + temperature + "C degrees, " + humidity + "% humidity, " + pressure + " pressure.");
    }
}

// Main class
public class WeatherMonitoringSystem {
    public static void main(String[] args) {
        WeatherStation station = new WeatherStation();
        CurrentConditionsDisplay currentDisplay = new CurrentConditionsDisplay();

        station.addDisplay(currentDisplay);
        station.setMeasurements(25.0f, 65.0f, 1013.0f);
    }
}
